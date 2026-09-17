#!/usr/bin/env bash
# Check that everything build-all downloads can be obtained on this machine:
# each Maven artifact from the local repository or through Artifactory, and each
# Eclipse p2 update site the EMF builds read. Reads required-artifacts.txt and
# required-p2-sites.txt from the directory this script is in, and can be run from
# anywhere. Nothing is downloaded or installed.
#
#   ARTIFACTORY_URL    Maven repository URL in Artifactory, e.g.
#                      https://artifactory.example.com/artifactory/maven-remote
#                      (unset: only the local repository is checked)
#   ARTIFACTORY_TOKEN  bearer token, or ARTIFACTORY_USER + ARTIFACTORY_PASSWORD
#   LOCAL_REPO         local Maven repository (default: temp/m2)
#   PARALLEL           concurrent Artifactory requests (default: 16)
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
LIST="${ARTIFACT_LIST:-$ROOT/required-artifacts.txt}"
SITES="$ROOT/required-p2-sites.txt"
LOCAL_REPO="${LOCAL_REPO:-$ROOT/temp/m2}"
REPORT="$ROOT/temp/logs/artifact-check.txt"
export ARTIFACTORY_URL="${ARTIFACTORY_URL%/}" ARTIFACTORY_TOKEN="${ARTIFACTORY_TOKEN:-}" \
       ARTIFACTORY_USER="${ARTIFACTORY_USER:-}" ARTIFACTORY_PASSWORD="${ARTIFACTORY_PASSWORD:-}"
for f in "$LIST" "$SITES"; do
  if [ ! -f "$f" ]; then
    echo "Not found: $f" >&2
    echo "Copy required-artifacts.txt and required-p2-sites.txt next to check-artifacts.sh." >&2
    exit 2
  fi
done
mkdir -p "$(dirname "$REPORT")"
WORKDIR=$(mktemp -d); trap 'rm -rf "$WORKDIR"' EXIT

# HTTP status of a HEAD request; 000 when the host cannot be reached.
http_status() { # url
  local auth=()
  if [ -n "$ARTIFACTORY_TOKEN" ]; then auth=(-H "Authorization: Bearer $ARTIFACTORY_TOKEN")
  elif [ -n "$ARTIFACTORY_USER" ]; then auth=(-u "$ARTIFACTORY_USER:$ARTIFACTORY_PASSWORD"); fi
  curl -s -o /dev/null -I -L --max-time 60 -w '%{http_code}' ${auth[@]+"${auth[@]}"} "$1" || true
}
export -f http_status

# ---- Maven artifacts ----
grep -v '^#' "$LIST" | grep -v '^$' > "$WORKDIR/all"
: > "$WORKDIR/local"; : > "$WORKDIR/remote"
while IFS= read -r p; do
  if [ -f "$LOCAL_REPO/$p" ]; then echo "$p" >> "$WORKDIR/local"; else echo "$p" >> "$WORKDIR/remote"; fi
done < "$WORKDIR/all"

: > "$WORKDIR/results"
if [ -n "$ARTIFACTORY_URL" ] && [ -s "$WORKDIR/remote" ]; then
  echo "Checking $(wc -l < "$WORKDIR/remote" | tr -d ' ') artifacts through $ARTIFACTORY_URL ..."
  tr '\n' '\0' < "$WORKDIR/remote" |
    xargs -0 -n 1 -P "${PARALLEL:-16}" bash -c 'echo "$(http_status "$ARTIFACTORY_URL/$1") $1"' _ > "$WORKDIR/results"
else
  sed 's/^/--- /' "$WORKDIR/remote" > "$WORKDIR/results"
fi

{
  sed 's/^/LOCAL        /' "$WORKDIR/local"
  awk '$1 == "200" { print "ARTIFACTORY  " $2 }' "$WORKDIR/results"
  awk '$1 != "200" { print "MISSING      " $2 "  (" ($1 == "---" ? "not local, no ARTIFACTORY_URL" : ($1 == "000" ? "no response" : "HTTP " $1)) ")" }' "$WORKDIR/results"
} | sort -k2 > "$REPORT"

TOTAL=$(wc -l < "$WORKDIR/all" | tr -d ' ')
LOCAL=$(grep -c '^LOCAL' "$REPORT" || true)
REMOTE=$(grep -c '^ARTIFACTORY' "$REPORT" || true)
MISSING=$(grep -c '^MISSING' "$REPORT" || true)
echo
echo "Maven artifacts: $TOTAL required — $LOCAL local, $REMOTE through Artifactory, $MISSING missing"
{ grep '^MISSING' "$REPORT" || true; } | head -20 | sed 's/^MISSING  */  missing: /'
if [ "$MISSING" -gt 20 ]; then echo "  ... and $((MISSING - 20)) more"; fi

# ---- Eclipse p2 update sites (not Maven; checked directly) ----
echo
echo "Eclipse p2 update sites:"
UNREACHABLE=0
while IFS= read -r site; do
  ok=""
  for f in p2.index compositeContent.jar compositeContent.xml content.jar content.xml.xz content.xml; do
    [ "$(ARTIFACTORY_TOKEN='' ARTIFACTORY_USER='' http_status "$site/$f")" = 200 ] && { ok=1; break; }
  done
  if [ -n "$ok" ]; then echo "  ok           $site"; else echo "  UNREACHABLE  $site"; UNREACHABLE=$((UNREACHABLE + 1)); fi
done < <(grep -v '^#' "$SITES" | grep -v '^$')
{ echo; echo "p2 sites unreachable: $UNREACHABLE"; } >> "$REPORT"

echo
echo "Full report: $REPORT"
[ "$MISSING" -eq 0 ] && [ "$UNREACHABLE" -eq 0 ]
