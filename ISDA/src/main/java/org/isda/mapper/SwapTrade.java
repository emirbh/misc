package org.isda.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapTrade {

    private String tradeId;
    private int tradeVersion;
    private String actionType;
    private String eventType;
    private String productType;

    private LocalDate tradeDate;
    private LocalDate effectiveDate;
    private LocalDate terminationDate;

    private BigDecimal notionalAmount;
    private String notionalCurrency;
    private BigDecimal notionalAmount2;
    private String notionalCurrency2;

    private BigDecimal fixedRate;
    private String floatingRateIndex;
    private String floatingRateIndexTenor;
    private BigDecimal spread;

    private String fixedDayCount;
    private String floatingDayCount;
    private String paymentFrequency;
    private String resetFrequency;

    private String businessDayConvention;
    private List<String> businessCenters;

    private PartyInfo party1;
    private PartyInfo party2;

    private String executionVenue;
    private String confirmationMethod;
    private String masterAgreementType;
    private String clearingStatus;

    private String optionType;
    private LocalDate optionExpiryDate;
    private String optionExerciseStyle;
    private BigDecimal strikeRate;
    private BigDecimal premium;
    private String premiumCurrency;
    private String settlementType;

    private BigDecimal fxRate;
    private LocalDate fxFarDate;
    private BigDecimal fxFarRate;

    private BigDecimal capRate;
    private BigDecimal floorRate;

    private String inflationIndex;
    private String inflationInterpolation;

    private LocalDate cancelableFrom;
    private PartyInfo novationNewParty;
    private String priorTradeId;

    private BigDecimal feeAmount;
    private String feeCurrency;

    // Getters

    public String getTradeId() { return tradeId; }
    public int getTradeVersion() { return tradeVersion; }
    public String getActionType() { return actionType; }
    public String getEventType() { return eventType; }
    public String getProductType() { return productType; }

    public LocalDate getTradeDate() { return tradeDate; }
    public LocalDate getEffectiveDate() { return effectiveDate; }
    public LocalDate getTerminationDate() { return terminationDate; }

    public BigDecimal getNotionalAmount() { return notionalAmount; }
    public String getNotionalCurrency() { return notionalCurrency; }
    public BigDecimal getNotionalAmount2() { return notionalAmount2; }
    public String getNotionalCurrency2() { return notionalCurrency2; }

    public BigDecimal getFixedRate() { return fixedRate; }
    public String getFloatingRateIndex() { return floatingRateIndex; }
    public String getFloatingRateIndexTenor() { return floatingRateIndexTenor; }
    public BigDecimal getSpread() { return spread; }

    public String getFixedDayCount() { return fixedDayCount; }
    public String getFloatingDayCount() { return floatingDayCount; }
    public String getPaymentFrequency() { return paymentFrequency; }
    public String getResetFrequency() { return resetFrequency; }

    public String getBusinessDayConvention() { return businessDayConvention; }
    public List<String> getBusinessCenters() { return businessCenters; }

    public PartyInfo getParty1() { return party1; }
    public PartyInfo getParty2() { return party2; }

    public String getExecutionVenue() { return executionVenue; }
    public String getConfirmationMethod() { return confirmationMethod; }
    public String getMasterAgreementType() { return masterAgreementType; }
    public String getClearingStatus() { return clearingStatus; }

    public String getOptionType() { return optionType; }
    public LocalDate getOptionExpiryDate() { return optionExpiryDate; }
    public String getOptionExerciseStyle() { return optionExerciseStyle; }
    public BigDecimal getStrikeRate() { return strikeRate; }
    public BigDecimal getPremium() { return premium; }
    public String getPremiumCurrency() { return premiumCurrency; }
    public String getSettlementType() { return settlementType; }

    public BigDecimal getFxRate() { return fxRate; }
    public LocalDate getFxFarDate() { return fxFarDate; }
    public BigDecimal getFxFarRate() { return fxFarRate; }

    public BigDecimal getCapRate() { return capRate; }
    public BigDecimal getFloorRate() { return floorRate; }

    public String getInflationIndex() { return inflationIndex; }
    public String getInflationInterpolation() { return inflationInterpolation; }

    public LocalDate getCancelableFrom() { return cancelableFrom; }
    public PartyInfo getNovationNewParty() { return novationNewParty; }
    public String getPriorTradeId() { return priorTradeId; }

    public BigDecimal getFeeAmount() { return feeAmount; }
    public String getFeeCurrency() { return feeCurrency; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PartyInfo {
        private String lei;
        private String name;

        public String getLei() { return lei; }
        public String getName() { return name; }
    }
}
