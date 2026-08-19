package org.isda.mapper;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Streams SwapTrade objects from a CSV file, one row at a time.
 * The CSV header row maps column names to SwapTrade fields.
 *
 * Nested fields are flattened:
 *   party1Lei, party1Name, party2Lei, party2Name,
 *   novationNewPartyLei, novationNewPartyName
 *
 * List fields use pipe-delimited values:
 *   businessCenters = "USNY|GBLO"
 */
public final class CsvSwapTradeReader implements Iterable<SwapTrade>, Closeable {

    private final BufferedReader reader;
    private final String[] headers;
    private final Map<String, Integer> headerIndex;
    private String nextLine;

    public CsvSwapTradeReader(Path csvPath) throws IOException {
        this.reader = Files.newBufferedReader(csvPath);
        String headerLine = reader.readLine();
        if (headerLine == null) {
            throw new IOException("CSV file is empty: " + csvPath);
        }
        this.headers = parseCsvLine(headerLine);
        this.headerIndex = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            headerIndex.put(headers[i].trim(), i);
        }
        this.nextLine = reader.readLine();
    }

    @Override
    public Iterator<SwapTrade> iterator() {
        return new Iterator<SwapTrade>() {
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public SwapTrade next() {
                if (nextLine == null) throw new NoSuchElementException();
                String[] values = parseCsvLine(nextLine);
                try {
                    nextLine = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException("Error reading CSV", e);
                }
                return mapRow(values);
            }
        };
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    private SwapTrade mapRow(String[] values) {
        SwapTrade t = new SwapTrade();

        t.setTradeId(str(values, "tradeId"));
        t.setTradeVersion(intVal(values, "tradeVersion", 1));
        t.setActionType(str(values, "actionType"));
        t.setEventType(str(values, "eventType"));
        t.setProductType(str(values, "productType"));

        t.setTradeDate(date(values, "tradeDate"));
        t.setEffectiveDate(date(values, "effectiveDate"));
        t.setTerminationDate(date(values, "terminationDate"));

        t.setNotionalAmount(decimal(values, "notionalAmount"));
        t.setNotionalCurrency(str(values, "notionalCurrency"));
        t.setNotionalAmount2(decimal(values, "notionalAmount2"));
        t.setNotionalCurrency2(str(values, "notionalCurrency2"));

        t.setFixedRate(decimal(values, "fixedRate"));
        t.setFloatingRateIndex(str(values, "floatingRateIndex"));
        t.setFloatingRateIndexTenor(str(values, "floatingRateIndexTenor"));
        t.setSpread(decimal(values, "spread"));

        t.setFixedDayCount(str(values, "fixedDayCount"));
        t.setFloatingDayCount(str(values, "floatingDayCount"));
        t.setPaymentFrequency(str(values, "paymentFrequency"));
        t.setResetFrequency(str(values, "resetFrequency"));

        t.setBusinessDayConvention(str(values, "businessDayConvention"));
        t.setBusinessCenters(pipeList(values, "businessCenters"));

        t.setParty1(party(values, "party1Lei", "party1Name"));
        t.setParty2(party(values, "party2Lei", "party2Name"));

        t.setExecutionVenue(str(values, "executionVenue"));
        t.setConfirmationMethod(str(values, "confirmationMethod"));
        t.setMasterAgreementType(str(values, "masterAgreementType"));
        t.setClearingStatus(str(values, "clearingStatus"));

        t.setOptionType(str(values, "optionType"));
        t.setOptionExpiryDate(date(values, "optionExpiryDate"));
        t.setOptionExerciseStyle(str(values, "optionExerciseStyle"));
        t.setStrikeRate(decimal(values, "strikeRate"));
        t.setPremium(decimal(values, "premium"));
        t.setPremiumCurrency(str(values, "premiumCurrency"));
        t.setSettlementType(str(values, "settlementType"));

        t.setFxRate(decimal(values, "fxRate"));
        t.setFxFarDate(date(values, "fxFarDate"));
        t.setFxFarRate(decimal(values, "fxFarRate"));

        t.setCapRate(decimal(values, "capRate"));
        t.setFloorRate(decimal(values, "floorRate"));

        t.setInflationIndex(str(values, "inflationIndex"));
        t.setInflationInterpolation(str(values, "inflationInterpolation"));

        t.setCancelableFrom(date(values, "cancelableFrom"));
        t.setNovationNewParty(party(values, "novationNewPartyLei", "novationNewPartyName"));
        t.setPriorTradeId(str(values, "priorTradeId"));

        t.setFeeAmount(decimal(values, "feeAmount"));
        t.setFeeCurrency(str(values, "feeCurrency"));

        return t;
    }

    private String str(String[] values, String col) {
        Integer idx = headerIndex.get(col);
        if (idx == null || idx >= values.length) return null;
        String v = values[idx].trim();
        return v.isEmpty() ? null : v;
    }

    private int intVal(String[] values, String col, int defaultValue) {
        String v = str(values, col);
        return v == null ? defaultValue : Integer.parseInt(v);
    }

    private BigDecimal decimal(String[] values, String col) {
        String v = str(values, col);
        return v == null ? null : new BigDecimal(v);
    }

    private LocalDate date(String[] values, String col) {
        String v = str(values, col);
        return v == null ? null : LocalDate.parse(v);
    }

    private List<String> pipeList(String[] values, String col) {
        String v = str(values, col);
        if (v == null) return null;
        return Arrays.stream(v.split("\\|"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private SwapTrade.PartyInfo party(String[] values, String leiCol, String nameCol) {
        String lei = str(values, leiCol);
        String name = str(values, nameCol);
        if (lei == null && name == null) return null;
        return new SwapTrade.PartyInfo(lei, name);
    }

    static String[] parseCsvLine(String line) {
        // RFC 4180 compliant: handles quoted fields with commas and escaped quotes
        java.util.List<String> fields = new java.util.ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (inQuotes) {
                if (c == '"') {
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        current.append('"');
                        i++;
                    } else {
                        inQuotes = false;
                    }
                } else {
                    current.append(c);
                }
            } else {
                if (c == '"') {
                    inQuotes = true;
                } else if (c == ',') {
                    fields.add(current.toString());
                    current.setLength(0);
                } else {
                    current.append(c);
                }
            }
        }
        fields.add(current.toString());

        return fields.toArray(new String[0]);
    }
}
