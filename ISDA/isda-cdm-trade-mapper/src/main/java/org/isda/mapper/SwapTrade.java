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

    // Setters (used by CsvSwapTradeReader to build instances from flat CSV rows)

    public void setTradeId(String tradeId) { this.tradeId = tradeId; }
    public void setTradeVersion(int tradeVersion) { this.tradeVersion = tradeVersion; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setProductType(String productType) { this.productType = productType; }
    public void setTradeDate(LocalDate tradeDate) { this.tradeDate = tradeDate; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }
    public void setTerminationDate(LocalDate terminationDate) { this.terminationDate = terminationDate; }
    public void setNotionalAmount(BigDecimal notionalAmount) { this.notionalAmount = notionalAmount; }
    public void setNotionalCurrency(String notionalCurrency) { this.notionalCurrency = notionalCurrency; }
    public void setNotionalAmount2(BigDecimal notionalAmount2) { this.notionalAmount2 = notionalAmount2; }
    public void setNotionalCurrency2(String notionalCurrency2) { this.notionalCurrency2 = notionalCurrency2; }
    public void setFixedRate(BigDecimal fixedRate) { this.fixedRate = fixedRate; }
    public void setFloatingRateIndex(String floatingRateIndex) { this.floatingRateIndex = floatingRateIndex; }
    public void setFloatingRateIndexTenor(String floatingRateIndexTenor) { this.floatingRateIndexTenor = floatingRateIndexTenor; }
    public void setSpread(BigDecimal spread) { this.spread = spread; }
    public void setFixedDayCount(String fixedDayCount) { this.fixedDayCount = fixedDayCount; }
    public void setFloatingDayCount(String floatingDayCount) { this.floatingDayCount = floatingDayCount; }
    public void setPaymentFrequency(String paymentFrequency) { this.paymentFrequency = paymentFrequency; }
    public void setResetFrequency(String resetFrequency) { this.resetFrequency = resetFrequency; }
    public void setBusinessDayConvention(String businessDayConvention) { this.businessDayConvention = businessDayConvention; }
    public void setBusinessCenters(List<String> businessCenters) { this.businessCenters = businessCenters; }
    public void setParty1(PartyInfo party1) { this.party1 = party1; }
    public void setParty2(PartyInfo party2) { this.party2 = party2; }
    public void setExecutionVenue(String executionVenue) { this.executionVenue = executionVenue; }
    public void setConfirmationMethod(String confirmationMethod) { this.confirmationMethod = confirmationMethod; }
    public void setMasterAgreementType(String masterAgreementType) { this.masterAgreementType = masterAgreementType; }
    public void setClearingStatus(String clearingStatus) { this.clearingStatus = clearingStatus; }
    public void setOptionType(String optionType) { this.optionType = optionType; }
    public void setOptionExpiryDate(LocalDate optionExpiryDate) { this.optionExpiryDate = optionExpiryDate; }
    public void setOptionExerciseStyle(String optionExerciseStyle) { this.optionExerciseStyle = optionExerciseStyle; }
    public void setStrikeRate(BigDecimal strikeRate) { this.strikeRate = strikeRate; }
    public void setPremium(BigDecimal premium) { this.premium = premium; }
    public void setPremiumCurrency(String premiumCurrency) { this.premiumCurrency = premiumCurrency; }
    public void setSettlementType(String settlementType) { this.settlementType = settlementType; }
    public void setFxRate(BigDecimal fxRate) { this.fxRate = fxRate; }
    public void setFxFarDate(LocalDate fxFarDate) { this.fxFarDate = fxFarDate; }
    public void setFxFarRate(BigDecimal fxFarRate) { this.fxFarRate = fxFarRate; }
    public void setCapRate(BigDecimal capRate) { this.capRate = capRate; }
    public void setFloorRate(BigDecimal floorRate) { this.floorRate = floorRate; }
    public void setInflationIndex(String inflationIndex) { this.inflationIndex = inflationIndex; }
    public void setInflationInterpolation(String inflationInterpolation) { this.inflationInterpolation = inflationInterpolation; }
    public void setCancelableFrom(LocalDate cancelableFrom) { this.cancelableFrom = cancelableFrom; }
    public void setNovationNewParty(PartyInfo novationNewParty) { this.novationNewParty = novationNewParty; }
    public void setPriorTradeId(String priorTradeId) { this.priorTradeId = priorTradeId; }
    public void setFeeAmount(BigDecimal feeAmount) { this.feeAmount = feeAmount; }
    public void setFeeCurrency(String feeCurrency) { this.feeCurrency = feeCurrency; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PartyInfo {
        private String lei;
        private String name;

        public PartyInfo() {}

        public PartyInfo(String lei, String name) {
            this.lei = lei;
            this.name = name;
        }

        public String getLei() { return lei; }
        public String getName() { return name; }
    }
}
