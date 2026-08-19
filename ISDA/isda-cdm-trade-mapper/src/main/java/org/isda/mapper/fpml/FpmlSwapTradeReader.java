package org.isda.mapper.fpml;

import org.isda.mapper.SwapTrade;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads FpML 5.x confirmation XML files and extracts trade data
 * into SwapTrade POJOs for the existing pipeline.
 *
 * Supports an optional FpmlPreprocessor to normalise proprietary
 * XML dialects (e.g. CitiML) before parsing.
 */
public final class FpmlSwapTradeReader {

    private static final String FPML_NS = "http://www.fpml.org/FpML-5/confirmation";

    private final FpmlPreprocessor preprocessor;
    private final DocumentBuilder docBuilder;

    public FpmlSwapTradeReader(FpmlPreprocessor preprocessor) {
        this.preprocessor = preprocessor;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            this.docBuilder = factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create XML parser", e);
        }
    }

    public FpmlSwapTradeReader() {
        this(new IdentityPreprocessor());
    }

    /**
     * Read all .xml files from a directory and produce SwapTrade objects.
     */
    public List<SwapTrade> readDirectory(Path dir) throws IOException {
        List<SwapTrade> trades = new ArrayList<>();
        File[] files = dir.toFile().listFiles((d, name) -> name.endsWith(".xml"));
        if (files == null) return trades;
        for (File file : files) {
            try {
                trades.add(readFile(file.toPath()));
            } catch (Exception e) {
                System.err.println("  FpML parse failed for " + file.getName() + ": " + e.getMessage());
            }
        }
        return trades;
    }

    /**
     * Read a single FpML XML file.
     */
    public SwapTrade readFile(Path file) throws Exception {
        String xml = Files.readString(file);
        String processed = preprocessor.process(xml);
        Document doc = docBuilder.parse(new InputSource(new StringReader(processed)));
        return extractTrade(doc);
    }

    private SwapTrade extractTrade(Document doc) {
        SwapTrade t = new SwapTrade();

        Element root = doc.getDocumentElement();

        // Resolve parties by id → {lei, name}
        Map<String, SwapTrade.PartyInfo> partyMap = extractParties(root);

        // Trade header
        Element trade = firstChild(root, "trade");
        if (trade == null) return t;

        Element header = firstChild(trade, "tradeHeader");
        if (header != null) {
            t.setTradeDate(dateVal(header, "tradeDate"));

            // Extract trade IDs and party refs
            NodeList ptis = header.getElementsByTagNameNS(FPML_NS, "partyTradeIdentifier");
            if (ptis.getLength() > 0) {
                Element pti = (Element) ptis.item(0);
                t.setTradeId(textVal(pti, "tradeId"));

                String partyRef = attrVal(firstChild(pti, "partyReference"), "href");
                if (partyRef != null && partyMap.containsKey(partyRef)) {
                    t.setParty1(partyMap.get(partyRef));
                }
            }
            if (ptis.getLength() > 1) {
                Element pti = (Element) ptis.item(1);
                String partyRef = attrVal(firstChild(pti, "partyReference"), "href");
                if (partyRef != null && partyMap.containsKey(partyRef)) {
                    t.setParty2(partyMap.get(partyRef));
                }
            }
        }

        // Default version and action/event for FpML confirmations
        t.setTradeVersion(1);
        t.setActionType("NEWT");
        t.setEventType("TRAD");

        // Determine product type and extract economics from swap streams
        Element swap = firstChild(trade, "swap");
        if (swap != null) {
            extractSwap(swap, t, partyMap);
        }

        Element swaption = firstChild(trade, "swaption");
        if (swaption != null) {
            t.setProductType("swaption");
            Element underlyingSwap = firstChild(swaption, "swap");
            if (underlyingSwap != null) {
                extractSwap(underlyingSwap, t, partyMap);
            }
            t.setOptionExerciseStyle(textVal(swaption, "exerciseStyle"));
            Element european = firstChild(swaption, "europeanExercise");
            if (european != null) {
                t.setOptionExpiryDate(dateVal(european, "expirationDate"));
            }
        }

        Element fra = firstChild(trade, "fra");
        if (fra != null) {
            t.setProductType("fra");
            extractFra(fra, t);
        }

        Element capFloor = firstChild(trade, "capFloor");
        if (capFloor != null) {
            t.setProductType("cap_floor");
            extractCapFloor(capFloor, t);
        }

        Element fxSwap = firstChild(trade, "fxSwap");
        if (fxSwap != null) {
            t.setProductType("fx_swap");
        }

        return t;
    }

    private void extractSwap(Element swap, SwapTrade t, Map<String, SwapTrade.PartyInfo> partyMap) {
        if (t.getProductType() == null) {
            t.setProductType("vanilla_swap");
        }

        NodeList streams = swap.getElementsByTagNameNS(FPML_NS, "swapStream");
        for (int i = 0; i < streams.getLength(); i++) {
            Element stream = (Element) streams.item(i);
            Element calc = firstChild(firstChild(stream, "calculationPeriodAmount"), "calculation");
            if (calc == null) continue;

            // Extract notional
            Element notionalSched = firstChild(firstChild(calc, "notionalSchedule"), "notionalStepSchedule");
            if (notionalSched != null && t.getNotionalAmount() == null) {
                t.setNotionalAmount(decimalVal(notionalSched, "initialValue"));
                t.setNotionalCurrency(textVal(notionalSched, "currency"));
            }

            // Fixed leg
            Element fixedRate = firstChild(calc, "fixedRateSchedule");
            if (fixedRate != null) {
                t.setFixedRate(decimalVal(fixedRate, "initialValue"));
                t.setFixedDayCount(textVal(calc, "dayCountFraction"));

                Element cpDates = firstChild(stream, "calculationPeriodDates");
                if (cpDates != null) {
                    t.setEffectiveDate(dateVal(firstChild(cpDates, "effectiveDate"), "unadjustedDate"));
                    t.setTerminationDate(dateVal(firstChild(cpDates, "terminationDate"), "unadjustedDate"));

                    Element cpFreq = firstChild(cpDates, "calculationPeriodFrequency");
                    if (cpFreq != null) {
                        t.setPaymentFrequency(periodToString(cpFreq));
                    }
                    extractBusinessDayConvention(cpDates, t);
                }
            }

            // Floating leg
            Element floatingCalc = firstChild(calc, "floatingRateCalculation");
            if (floatingCalc != null) {
                t.setFloatingRateIndex(textVal(floatingCalc, "floatingRateIndex"));
                Element tenor = firstChild(floatingCalc, "indexTenor");
                if (tenor != null) {
                    t.setFloatingRateIndexTenor(periodToString(tenor));
                }
                t.setFloatingDayCount(textVal(calc, "dayCountFraction"));

                Element resetDates = firstChild(stream, "resetDates");
                if (resetDates != null) {
                    Element resetFreq = firstChild(resetDates, "resetFrequency");
                    if (resetFreq != null) {
                        t.setResetFrequency(periodToString(resetFreq));
                    }
                }

                if (t.getEffectiveDate() == null) {
                    Element cpDates = firstChild(stream, "calculationPeriodDates");
                    if (cpDates != null) {
                        t.setEffectiveDate(dateVal(firstChild(cpDates, "effectiveDate"), "unadjustedDate"));
                        t.setTerminationDate(dateVal(firstChild(cpDates, "terminationDate"), "unadjustedDate"));
                    }
                }
            }

            // Spread
            Element spreadSched = firstChild(calc, "spreadSchedule");
            if (spreadSched != null) {
                t.setSpread(decimalVal(spreadSched, "initialValue"));
            }
        }

        // Assign parties if not yet set from trade header
        if (t.getParty1() == null && streams.getLength() > 0) {
            Element firstStream = (Element) streams.item(0);
            String payerRef = attrVal(firstChild(firstStream, "payerPartyReference"), "href");
            if (payerRef != null && partyMap.containsKey(payerRef)) {
                t.setParty1(partyMap.get(payerRef));
            }
            String receiverRef = attrVal(firstChild(firstStream, "receiverPartyReference"), "href");
            if (receiverRef != null && partyMap.containsKey(receiverRef)) {
                t.setParty2(partyMap.get(receiverRef));
            }
        }
    }

    private void extractFra(Element fra, SwapTrade t) {
        t.setEffectiveDate(dateVal(fra, "adjustedEffectiveDate"));
        t.setTerminationDate(dateVal(fra, "adjustedTerminationDate"));
        t.setNotionalAmount(decimalVal(firstChild(fra, "notional"), "amount"));
        t.setNotionalCurrency(textVal(firstChild(fra, "notional"), "currency"));
        t.setFixedRate(decimalVal(fra, "fixedRate"));
        t.setFloatingRateIndex(textVal(firstChild(fra, "floatingRateIndex"), null));
        Element tenor = firstChild(fra, "indexTenor");
        if (tenor != null) {
            t.setFloatingRateIndexTenor(periodToString(tenor));
        }
        t.setFixedDayCount(textVal(fra, "dayCountFraction"));
        t.setFloatingDayCount(textVal(fra, "dayCountFraction"));
    }

    private void extractCapFloor(Element capFloor, SwapTrade t) {
        Element stream = firstChild(capFloor, "capFloorStream");
        if (stream == null) return;

        Element calc = firstChild(firstChild(stream, "calculationPeriodAmount"), "calculation");
        if (calc != null) {
            Element notionalSched = firstChild(firstChild(calc, "notionalSchedule"), "notionalStepSchedule");
            if (notionalSched != null) {
                t.setNotionalAmount(decimalVal(notionalSched, "initialValue"));
                t.setNotionalCurrency(textVal(notionalSched, "currency"));
            }
            Element floatingCalc = firstChild(calc, "floatingRateCalculation");
            if (floatingCalc != null) {
                t.setFloatingRateIndex(textVal(floatingCalc, "floatingRateIndex"));
                Element tenor = firstChild(floatingCalc, "indexTenor");
                if (tenor != null) {
                    t.setFloatingRateIndexTenor(periodToString(tenor));
                }
                Element capStrike = firstChild(floatingCalc, "capRateSchedule");
                if (capStrike != null) {
                    t.setCapRate(decimalVal(capStrike, "initialValue"));
                }
                Element floorStrike = firstChild(floatingCalc, "floorRateSchedule");
                if (floorStrike != null) {
                    t.setFloorRate(decimalVal(floorStrike, "initialValue"));
                }
            }
            t.setFloatingDayCount(textVal(calc, "dayCountFraction"));
        }

        Element cpDates = firstChild(stream, "calculationPeriodDates");
        if (cpDates != null) {
            t.setEffectiveDate(dateVal(firstChild(cpDates, "effectiveDate"), "unadjustedDate"));
            t.setTerminationDate(dateVal(firstChild(cpDates, "terminationDate"), "unadjustedDate"));
        }
    }

    private Map<String, SwapTrade.PartyInfo> extractParties(Element root) {
        Map<String, SwapTrade.PartyInfo> map = new HashMap<>();
        NodeList parties = root.getElementsByTagNameNS(FPML_NS, "party");
        for (int i = 0; i < parties.getLength(); i++) {
            Element party = (Element) parties.item(i);
            String id = party.getAttribute("id");
            String lei = textVal(party, "partyId");
            String name = textVal(party, "partyName");
            if (id != null && !id.isEmpty()) {
                map.put(id, new SwapTrade.PartyInfo(lei, name != null ? name : id));
            }
        }
        return map;
    }

    private void extractBusinessDayConvention(Element cpDates, SwapTrade t) {
        if (t.getBusinessDayConvention() != null) return;
        Element adj = firstChild(cpDates, "calculationPeriodDatesAdjustments");
        if (adj != null) {
            t.setBusinessDayConvention(textVal(adj, "businessDayConvention"));
            Element bcs = firstChild(adj, "businessCenters");
            if (bcs == null) {
                bcs = resolveReference(adj, "businessCentersReference");
            }
            if (bcs != null) {
                List<String> centers = new ArrayList<>();
                NodeList bcList = bcs.getElementsByTagNameNS(FPML_NS, "businessCenter");
                for (int i = 0; i < bcList.getLength(); i++) {
                    centers.add(bcList.item(i).getTextContent().trim());
                }
                if (!centers.isEmpty()) {
                    t.setBusinessCenters(centers);
                }
            }
        }
    }

    // --- XML utility methods ---

    private Element firstChild(Element parent, String localName) {
        if (parent == null) return null;
        NodeList children = parent.getElementsByTagNameNS(FPML_NS, localName);
        if (children.getLength() == 0) {
            // Fallback: try without namespace (for preprocessed/proprietary XML)
            children = parent.getElementsByTagName(localName);
        }
        return children.getLength() > 0 ? (Element) children.item(0) : null;
    }

    private String textVal(Element parent, String localName) {
        if (parent == null) return null;
        if (localName == null) return parent.getTextContent().trim();
        Element child = firstChild(parent, localName);
        return child != null ? child.getTextContent().trim() : null;
    }

    private LocalDate dateVal(Element parent, String localName) {
        String v = textVal(parent, localName);
        return v != null && !v.isEmpty() ? LocalDate.parse(v) : null;
    }

    private BigDecimal decimalVal(Element parent, String localName) {
        String v = textVal(parent, localName);
        return v != null && !v.isEmpty() ? new BigDecimal(v) : null;
    }

    /**
     * FpML defines a value once with an id and points at it elsewhere with
     * href, so a missing inline element is normal rather than absent data.
     */
    private Element resolveReference(Element parent, String refName) {
        String href = attrVal(firstChild(parent, refName), "href");
        if (href == null) return null;
        NodeList all = parent.getOwnerDocument().getElementsByTagName("*");
        for (int i = 0; i < all.getLength(); i++) {
            Element el = (Element) all.item(i);
            if (href.equals(el.getAttribute("id"))) {
                return el;
            }
        }
        return null;
    }

    private String attrVal(Element el, String attr) {
        if (el == null) return null;
        String v = el.getAttribute(attr);
        return v.isEmpty() ? null : v;
    }

    private String periodToString(Element periodEl) {
        String multiplier = textVal(periodEl, "periodMultiplier");
        String period = textVal(periodEl, "period");
        if (multiplier != null && period != null) {
            return multiplier + period;
        }
        return null;
    }
}
