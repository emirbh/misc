package org.isda.mapper.fpml;

import org.isda.mapper.SwapTrade;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads CitiML trade notifications into SwapTrade POJOs.
 *
 * CitiML wraps an FpML *recordkeeping* payload in a Citi envelope. The envelope
 * is read natively rather than transformed away, because it carries the
 * lifecycle, clearing and venue data that standard FpML has nowhere to put —
 * the same fields the FpML reader has to hardcode.
 *
 * Namespaces are matched by URI, never by prefix: prefixes such as "ns6" are
 * assigned by whatever generated the document and are not stable between files.
 */
public final class CitimlTradeReader {

    /** CitiML embeds the recordkeeping view of FpML, not the confirmation view. */
    private static final String FPML_NS = "http://www.fpml.org/FpML-5/recordkeeping";
    private static final String CITIML_NS = "http://tradecapturesys.cmb.citigroup.net/citiml-2-0";
    private static final String CITIML_FX_NS = "http://tradecapturesys.cmb.citigroup.net/citiml-fx-extended-2-0";

    private final DocumentBuilder docBuilder;

    public CitimlTradeReader() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            this.docBuilder = factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create XML parser", e);
        }
    }

    /** Read all .xml files from a directory. */
    public List<SwapTrade> readDirectory(Path dir) throws IOException {
        List<SwapTrade> trades = new ArrayList<>();
        File[] files = dir.toFile().listFiles((d, name) -> name.endsWith(".xml"));
        if (files == null) return trades;
        for (File file : files) {
            try {
                trades.addAll(readFile(file.toPath()));
            } catch (Exception e) {
                System.err.println("  CitiML parse failed for " + file.getName() + ": " + e.getMessage());
            }
        }
        return trades;
    }

    /**
     * A notification carries a bundle, which may hold more than one post-event
     * trade, so a single file can yield several trades.
     */
    public List<SwapTrade> readFile(Path file) throws Exception {
        Document doc = docBuilder.parse(file.toFile());
        Element root = doc.getDocumentElement();

        Map<String, SwapTrade.PartyInfo> parties = extractParties(root);

        List<SwapTrade> trades = new ArrayList<>();
        NodeList postEvents = root.getElementsByTagNameNS(CITIML_NS, "citimlPostEventTrade");
        for (int i = 0; i < postEvents.getLength(); i++) {
            trades.add(extractTrade((Element) postEvents.item(i), parties));
        }
        return trades;
    }

    private SwapTrade extractTrade(Element postEventTrade, Map<String, SwapTrade.PartyInfo> parties) {
        SwapTrade t = new SwapTrade();

        Element trade = childNS(postEventTrade, CITIML_NS, "postEventTrade");
        Element header = trade == null ? null : childNS(trade, FPML_NS, "tradeHeader");

        extractIdentifiers(header, t);
        extractTradeInformation(header, t, parties);
        if (header != null) {
            t.setTradeDate(dateVal(header, FPML_NS, "tradeDate"));
        }

        // Lifecycle and processing data — the reason to read the envelope
        Element extension = childNS(postEventTrade, CITIML_NS, "citimlTradeExtensionData");
        extractLifecycle(extension, t);

        Element fxLeg = trade == null ? null : childNS(trade, FPML_NS, "fxSingleLeg");
        if (fxLeg != null) {
            extractFxSingleLeg(fxLeg, t, parties);
        }

        extractSettlementProvision(postEventTrade, t);

        if (t.getProductType() == null) {
            t.setProductType("unknown");
        }
        return t;
    }

    // --- Trade header ---

    private void extractIdentifiers(Element header, SwapTrade t) {
        if (header == null) return;

        Element pti = childNS(header, FPML_NS, "partyTradeIdentifier");
        if (pti == null) return;

        Element versioned = childNS(pti, FPML_NS, "versionedTradeId");
        if (versioned != null) {
            t.setTradeId(textVal(versioned, FPML_NS, "tradeId"));
            String version = textVal(versioned, FPML_NS, "version");
            t.setTradeVersion(version != null ? Integer.parseInt(version) : 1);
        }
        if (t.getTradeId() == null) {
            t.setTradeId(textVal(pti, FPML_NS, "tradeId"));
            t.setTradeVersion(1);
        }
    }

    private void extractTradeInformation(Element header, SwapTrade t,
                                         Map<String, SwapTrade.PartyInfo> parties) {
        if (header == null) return;
        Element info = childNS(header, FPML_NS, "partyTradeInformation");
        if (info == null) return;

        t.setExecutionVenue(textVal(info, FPML_NS, "executionVenueType"));
        t.setConfirmationMethod(mapVerificationMethod(textVal(info, FPML_NS, "verificationMethod")));
        if (t.getClearingStatus() == null) {
            t.setClearingStatus(upper(textVal(info, FPML_NS, "clearingStatus")));
        }

        // relatedParty roles decide which party reports
        NodeList related = info.getElementsByTagNameNS(FPML_NS, "relatedParty");
        for (int i = 0; i < related.getLength(); i++) {
            Element rp = (Element) related.item(i);
            String role = textVal(rp, FPML_NS, "role");
            String ref = attrVal(childNS(rp, FPML_NS, "partyReference"), "href");
            if (ref == null || !parties.containsKey(ref)) continue;

            if ("ReportingParty".equals(role) && t.getParty1() == null) {
                t.setParty1(parties.get(ref));
            } else if ("Counterparty".equals(role) && t.getParty2() == null) {
                t.setParty2(parties.get(ref));
            }
        }
    }

    // --- Citi extension data ---

    private void extractLifecycle(Element extension, SwapTrade t) {
        if (extension == null) return;

        Element processing = childNS(extension, CITIML_NS, "citimlTradeProcessing");
        if (processing != null) {
            Element lifecycle = childNS(processing, CITIML_NS, "citimlLifeCycleAction");
            if (lifecycle != null) {
                t.setActionType(mapAction(textVal(lifecycle, CITIML_NS, "citimlAction")));
            }
            Element clearing = childNS(processing, CITIML_NS, "citimlClearingDetails");
            if (clearing != null) {
                t.setClearingStatus(upper(textVal(clearing, CITIML_NS, "citimlClearingStatus")));
            }
            t.setTerminationDate(dateVal(processing, CITIML_NS, "citimlTerminationDate"));
        }

        t.setEventType(mapEventType(textVal(extension, CITIML_NS, "citimlEventType")));

        if (t.getActionType() == null) t.setActionType("NEWT");
        if (t.getEventType() == null) t.setEventType("TRAD");
    }

    /** citimlAction is a display word; the pipeline speaks the 4-char codes. */
    static String mapAction(String action) {
        if (action == null) return null;
        switch (action) {
            case "New":       return "NEWT";
            case "Amend":
            case "Modify":    return "MODI";
            case "Correct":   return "CORR";
            case "Cancel":
            case "Error":     return "EROR";
            case "Terminate": return "TERM";
            default:          return "NEWT";
        }
    }

    static String mapEventType(String eventType) {
        if (eventType == null) return null;
        switch (eventType) {
            case "NewTradeEvent":     return "TRAD";
            case "NovationEvent":     return "NOVA";
            case "TerminationEvent":  return "ETRM";
            case "AllocationEvent":   return "ALOC";
            case "CompressionEvent":  return "COMP";
            default:                  return "TRAD";
        }
    }

    static String mapVerificationMethod(String method) {
        if (method == null) return null;
        return "Unverified".equals(method) ? "NON_ELECTRONIC" : "ELECTRONIC";
    }

    // --- FX single leg ---

    private void extractFxSingleLeg(Element fxLeg, SwapTrade t,
                                    Map<String, SwapTrade.PartyInfo> parties) {
        t.setProductType(resolveProductType(fxLeg));

        Element ccy1 = childNS(fxLeg, FPML_NS, "exchangedCurrency1");
        if (ccy1 != null) {
            Element amount = childNS(ccy1, FPML_NS, "paymentAmount");
            t.setNotionalAmount(decimalVal(amount, FPML_NS, "amount"));
            t.setNotionalCurrency(textVal(amount, FPML_NS, "currency"));
            if (t.getEffectiveDate() == null) {
                Element payDate = childNS(ccy1, FPML_NS, "paymentDate");
                t.setEffectiveDate(dateVal(payDate, FPML_NS, "unadjustedDate"));
            }
        }

        Element ccy2 = childNS(fxLeg, FPML_NS, "exchangedCurrency2");
        if (ccy2 != null) {
            Element amount = childNS(ccy2, FPML_NS, "paymentAmount");
            t.setNotionalAmount2(decimalVal(amount, FPML_NS, "amount"));
            t.setNotionalCurrency2(textVal(amount, FPML_NS, "currency"));
        }

        t.setValueDate(dateVal(fxLeg, FPML_NS, "valueDate"));
        if (t.getTerminationDate() == null) {
            t.setTerminationDate(t.getValueDate());
        }

        Element rate = childNS(fxLeg, FPML_NS, "exchangeRate");
        if (rate != null) {
            t.setFxRate(decimalVal(rate, FPML_NS, "rate"));
            t.setSpotRate(decimalVal(rate, FPML_NS, "spotRate"));
        }
    }

    /**
     * Citi tags a leg with a dozen productType schemes. FX.Taxonomy2 is the
     * most specific; the product-taxonomy productId is the fallback.
     */
    private String resolveProductType(Element fxLeg) {
        String fxTaxonomy = schemedValue(fxLeg, FPML_NS, "productType",
                "productTypeScheme", "FX.Taxonomy2");
        if (fxTaxonomy != null) {
            return "NDF".equalsIgnoreCase(fxTaxonomy) ? "fx_ndf" : "fx_" + fxTaxonomy.toLowerCase();
        }

        String taxonomyId = schemedValue(fxLeg, FPML_NS, "productId", "productIdScheme",
                "http://www.fpml.org/coding-scheme/product-taxonomy");
        if (taxonomyId != null && taxonomyId.endsWith(":NDF")) {
            return "fx_ndf";
        }
        return "fx_forward";
    }

    private void extractSettlementProvision(Element postEventTrade, SwapTrade t) {
        Element provision = firstDescendantNS(postEventTrade, CITIML_FX_NS, "citimlSettlementProvision");
        if (provision == null) return;

        t.setSettlementCurrency(textVal(provision, FPML_NS, "settlementCurrency"));

        Element nds = childNS(provision, FPML_NS, "nonDeliverableSettlement");
        if (nds == null) return;

        t.setSettlementType("CASH");
        t.setReferenceCurrency(textVal(nds, FPML_NS, "referenceCurrency"));
        t.setSettlementRateOption(textVal(nds, FPML_NS, "settlementRateOption"));

        Element fixing = childNS(nds, FPML_NS, "fxFixingDate");
        if (fixing != null) {
            String multiplier = textVal(fixing, FPML_NS, "periodMultiplier");
            if (multiplier != null) {
                t.setFxFixingOffsetDays(Integer.parseInt(multiplier));
            }
            Element centers = childNS(fixing, FPML_NS, "businessCenters");
            if (centers != null) {
                List<String> list = new ArrayList<>();
                NodeList bc = centers.getElementsByTagNameNS(FPML_NS, "businessCenter");
                for (int i = 0; i < bc.getLength(); i++) {
                    list.add(bc.item(i).getTextContent().trim());
                }
                if (!list.isEmpty()) t.setFxFixingBusinessCenters(list);
            }
        }
    }

    // --- Parties ---

    /**
     * CitiML identifies parties by internal codes (TPS, GFCID, ACTI), not LEI.
     * The TPS code is carried through so the trade can be processed, but DRR
     * expects an LEI here — see the code-to-LEI lookup gap.
     */
    private Map<String, SwapTrade.PartyInfo> extractParties(Element root) {
        Map<String, SwapTrade.PartyInfo> map = new HashMap<>();
        NodeList parties = root.getElementsByTagNameNS(CITIML_NS, "party");
        for (int i = 0; i < parties.getLength(); i++) {
            Element party = (Element) parties.item(i);
            String id = party.getAttribute("id");
            if (id == null || id.isEmpty()) continue;

            String code = schemedValue(party, FPML_NS, "partyId", "partyIdScheme", "TPS");
            if (code == null) {
                code = textVal(party, FPML_NS, "partyId");
            }
            String name = textVal(party, FPML_NS, "partyName");
            map.put(id, new SwapTrade.PartyInfo(code, name != null ? name : id));
        }
        return map;
    }

    // --- XML helpers ---

    /** Direct-descendant lookup that does not cross into a nested trade. */
    private Element childNS(Element parent, String ns, String localName) {
        if (parent == null) return null;
        NodeList children = parent.getElementsByTagNameNS(ns, localName);
        return children.getLength() > 0 ? (Element) children.item(0) : null;
    }

    private Element firstDescendantNS(Element parent, String ns, String localName) {
        return childNS(parent, ns, localName);
    }

    /** Finds the element whose scheme attribute matches, e.g. partyIdScheme="TPS". */
    private String schemedValue(Element parent, String ns, String localName,
                                String schemeAttr, String schemeValue) {
        if (parent == null) return null;
        NodeList nodes = parent.getElementsByTagNameNS(ns, localName);
        for (int i = 0; i < nodes.getLength(); i++) {
            Element el = (Element) nodes.item(i);
            if (schemeValue.equals(el.getAttribute(schemeAttr))) {
                String v = el.getTextContent().trim();
                return v.isEmpty() ? null : v;
            }
        }
        return null;
    }

    private String textVal(Element parent, String ns, String localName) {
        Element child = childNS(parent, ns, localName);
        if (child == null) return null;
        String v = child.getTextContent().trim();
        return v.isEmpty() ? null : v;
    }

    private LocalDate dateVal(Element parent, String ns, String localName) {
        String v = textVal(parent, ns, localName);
        return v == null ? null : LocalDate.parse(v);
    }

    private BigDecimal decimalVal(Element parent, String ns, String localName) {
        String v = textVal(parent, ns, localName);
        return v == null ? null : new BigDecimal(v);
    }

    private String attrVal(Element el, String attr) {
        if (el == null) return null;
        String v = el.getAttribute(attr);
        return v.isEmpty() ? null : v;
    }

    private static String upper(String s) {
        return s == null ? null : s.toUpperCase(java.util.Locale.ROOT);
    }
}
