package drr.regulation.csa.rewrite.trade;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.meta.CSATransactionReportTradeMeta;
import drr.standards.iosco.cde.version1.LegV1;
import drr.standards.iosco.cde.version2.LegV2;
import drr.standards.iosco.cde.version3.Leg;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.DeliveryTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.SeniorityEnum;
import drr.standards.iso.TradingCapacity7Code;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 7.7.0
 */
@RosettaDataType(value="CSATransactionReportTrade", builder=CSATransactionReportTrade.CSATransactionReportTradeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CSATransactionReportTrade", model="drr", builder=CSATransactionReportTrade.CSATransactionReportTradeBuilderImpl.class, version="7.7.0")
public interface CSATransactionReportTrade extends CSATransactionReport {

	CSATransactionReportTradeMeta metaData = new CSATransactionReportTradeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CSATransactionReportTrade build();
	
	CSATransactionReportTrade.CSATransactionReportTradeBuilder toBuilder();
	
	static CSATransactionReportTrade.CSATransactionReportTradeBuilder builder() {
		return new CSATransactionReportTrade.CSATransactionReportTradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSATransactionReportTrade> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSATransactionReportTrade> getType() {
		return CSATransactionReportTrade.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("earlyTerminationDate"), Date.class, getEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("executionTimestamp"), ZonedDateTime.class, getExecutionTimestamp(), this);
		processor.processBasic(path.newSubPath("expirationDate"), Date.class, getExpirationDate(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("beneficiary1"), String.class, getBeneficiary1(), this);
		processor.processBasic(path.newSubPath("beneficiary1IdentifierTypeIndicator"), Boolean.class, getBeneficiary1IdentifierTypeIndicator(), this);
		processor.processBasic(path.newSubPath("buyerIdentifier"), String.class, getBuyerIdentifier(), this);
		processor.processBasic(path.newSubPath("sellerIdentifier"), String.class, getSellerIdentifier(), this);
		processor.processBasic(path.newSubPath("cleared"), ClearedEnum.class, getCleared(), this);
		processor.processBasic(path.newSubPath("centralCounterparty"), String.class, getCentralCounterparty(), this);
		processor.processBasic(path.newSubPath("clearingMember"), String.class, getClearingMember(), this);
		processor.processBasic(path.newSubPath("confirmed"), ConfirmationEnum.class, getConfirmed(), this);
		processor.processBasic(path.newSubPath("callAmount"), BigDecimal.class, getCallAmount(), this);
		processor.processBasic(path.newSubPath("putAmount"), BigDecimal.class, getPutAmount(), this);
		processor.processBasic(path.newSubPath("callCurrency"), ISOCurrencyCodeEnum.class, getCallCurrency(), this);
		processor.processBasic(path.newSubPath("putCurrency"), ISOCurrencyCodeEnum.class, getPutCurrency(), this);
		processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
		processRosetta(path.newSubPath("priceSchedule"), processor, PricePeriod.class, getPriceSchedule());
		processRosetta(path.newSubPath("strikePriceSchedule"), processor, PricePeriod.class, getStrikePriceSchedule());
		processRosetta(path.newSubPath("price"), processor, PriceFormat.class, getPrice());
		processor.processBasic(path.newSubPath("priceNotation"), PriceNotationEnum.class, getPriceNotation(), this);
		processor.processBasic(path.newSubPath("priceCurrency"), ISOCurrencyCodeEnum.class, getPriceCurrency(), this);
		processRosetta(path.newSubPath("packageTransactionPrice"), processor, PriceFormat.class, getPackageTransactionPrice());
		processor.processBasic(path.newSubPath("packageTransactionPriceNotation"), PriceNotationEnum.class, getPackageTransactionPriceNotation(), this);
		processor.processBasic(path.newSubPath("packageTransactionPriceCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionPriceCurrency(), this);
		processRosetta(path.newSubPath("packageTransactionSpread"), processor, PriceFormat.class, getPackageTransactionSpread());
		processor.processBasic(path.newSubPath("packageTransactionSpreadNotation"), PriceNotationEnum.class, getPackageTransactionSpreadNotation(), this);
		processor.processBasic(path.newSubPath("packageTransactionSpreadCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionSpreadCurrency(), this);
		processor.processBasic(path.newSubPath("packageIdentifier"), String.class, getPackageIdentifier(), this);
		processRosetta(path.newSubPath("strikePrice"), processor, PriceFormat.class, getStrikePrice());
		processor.processBasic(path.newSubPath("strikePriceNotation"), PriceNotationEnum.class, getStrikePriceNotation(), this);
		processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
		processor.processBasic(path.newSubPath("priceUnitOfMeasure"), String.class, getPriceUnitOfMeasure(), this);
		processor.processBasic(path.newSubPath("optionPremiumAmount"), BigDecimal.class, getOptionPremiumAmount(), this);
		processor.processBasic(path.newSubPath("optionPremiumCurrency"), ISOCurrencyCodeEnum.class, getOptionPremiumCurrency(), this);
		processor.processBasic(path.newSubPath("optionPremiumPaymentDate"), Date.class, getOptionPremiumPaymentDate(), this);
		processor.processBasic(path.newSubPath("exchangeRate"), BigDecimal.class, getExchangeRate(), this);
		processor.processBasic(path.newSubPath("exchangeRateBasis"), String.class, getExchangeRateBasis(), this);
		processor.processBasic(path.newSubPath("cdSIndexAttachmentPoint"), BigDecimal.class, getCdSIndexAttachmentPoint(), this);
		processor.processBasic(path.newSubPath("cdSIndexDetachmentPoint"), BigDecimal.class, getCdSIndexDetachmentPoint(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
		processor.processBasic(path.newSubPath("firstExerciseDate"), Date.class, getFirstExerciseDate(), this);
		processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
		processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
		processor.processBasic(path.newSubPath("priorUTI"), String.class, getPriorUTI(), this);
		processor.processBasic(path.newSubPath("direction1"), Direction1Enum.class, getDirection1(), this);
		processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
		processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
		processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
		processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
		processRosetta(path.newSubPath("basketConstituents"), processor, BasketConstituentsReport.class, getBasketConstituents());
		processRosetta(path.newSubPath("otherPayment"), processor, OtherPayment.class, getOtherPayment());
		processRosetta(path.newSubPath("leg1"), processor, CSALeg.class, getLeg1());
		processRosetta(path.newSubPath("leg2"), processor, CSALeg.class, getLeg2());
		processor.processBasic(path.newSubPath("underlyingIdOther"), String.class, getUnderlyingIdOther(), this);
		processor.processBasic(path.newSubPath("underlyingIdOtherSource"), AssetIdTypeEnum.class, getUnderlyingIdOtherSource(), this);
		processor.processBasic(path.newSubPath("underlyingAssetTradingPlatformIdentifier"), String.class, getUnderlyingAssetTradingPlatformIdentifier(), this);
		processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
		processor.processBasic(path.newSubPath("cryptoAssetUnderlyingIndicator"), Boolean.class, getCryptoAssetUnderlyingIndicator(), this);
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
		processor.processBasic(path.newSubPath("eventType"), EventTypeEnum.class, getEventType(), this);
		processor.processBasic(path.newSubPath("eventIdentifier"), String.class, getEventIdentifier(), this);
		processor.processBasic(path.newSubPath("eventTimestamp"), ZonedDateTime.class, getEventTimestamp(), this);
		processor.processBasic(path.newSubPath("confirmationTimestamp"), ZonedDateTime.class, getConfirmationTimestamp(), this);
		processor.processBasic(path.newSubPath("platformIdentifier"), String.class, getPlatformIdentifier(), this);
		processor.processBasic(path.newSubPath("bookingLocation"), ISOCountryCodeEnum.class, getBookingLocation(), this);
		processor.processBasic(path.newSubPath("traderLocation"), ISOCountryCodeEnum.class, getTraderLocation(), this);
		processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("executionAgentCounterparty1"), String.class, getExecutionAgentCounterparty1(), this);
		processor.processBasic(path.newSubPath("executionAgentCounterparty2"), String.class, getExecutionAgentCounterparty2(), this);
		processor.processBasic(path.newSubPath("natureOfCounterparty1"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty1(), this);
		processor.processBasic(path.newSubPath("natureOfCounterparty2"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty2(), this);
		processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty1"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty1(), this);
		processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty2"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty2(), this);
		processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty1"), String.class, getCorporateSectorOfTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty2"), String.class, getCorporateSectorOfTheCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
		processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
		processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
		processor.processBasic(path.newSubPath("countryOfTheCounterparty2"), ISOCountryCodeEnum.class, getCountryOfTheCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), Counterparty2IdentifierEnum.class, getCounterparty2IdentifierSource(), this);
		processor.processBasic(path.newSubPath("tradingCapacity"), TradingCapacity7Code.class, getTradingCapacity(), this);
		processor.processBasic(path.newSubPath("brokerID"), String.class, getBrokerID(), this);
		processor.processBasic(path.newSubPath("contractType"), CommonContractType.class, getContractType(), this);
		processor.processBasic(path.newSubPath("assetClass"), CommonAssetClass.class, getAssetClass(), this);
		processor.processBasic(path.newSubPath("optionType"), OptionTypeCode.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
		processor.processBasic(path.newSubPath("embeddedOptionType"), EmbeddedOptionTypeEnum.class, getEmbeddedOptionType(), this);
		processor.processBasic(path.newSubPath("masterAgreementType"), MasterAgreementEnum.class, getMasterAgreementType(), this);
		processor.processBasic(path.newSubPath("masterAgreementVersion"), Integer.class, getMasterAgreementVersion(), this);
		processor.processBasic(path.newSubPath("secondaryTransactionIdentifier"), String.class, getSecondaryTransactionIdentifier(), this);
		processor.processBasic(path.newSubPath("intragroup"), Boolean.class, getIntragroup(), this);
		processor.processBasic(path.newSubPath("nonStandardizedTermIndicator"), Boolean.class, getNonStandardizedTermIndicator(), this);
		processor.processBasic(path.newSubPath("amendmentIndicator"), Boolean.class, getAmendmentIndicator(), this);
		processor.processBasic(path.newSubPath("underlyingIdentification"), String.class, getUnderlyingIdentification(), this);
		processor.processBasic(path.newSubPath("underlyingIdentificationType"), UnderlyingIdentificationTypeEnum.class, getUnderlyingIdentificationType(), this);
		processor.processBasic(path.newSubPath("nameOfTheUnderlyingIndex"), String.class, getNameOfTheUnderlyingIndex(), this);
		processor.processBasic(path.newSubPath("maturityDateOfTheUnderlying"), Date.class, getMaturityDateOfTheUnderlying(), this);
		processor.processBasic(path.newSubPath("swapLinkID"), String.class, getSwapLinkID(), this);
		processor.processBasic(path.newSubPath("packageIndicator"), Boolean.class, getPackageIndicator(), this);
		processor.processBasic(path.newSubPath("customBasketIndicator"), Boolean.class, getCustomBasketIndicator(), this);
		processor.processBasic(path.newSubPath("priorUTIProprietary"), String.class, getPriorUTIProprietary(), this);
		processor.processBasic(path.newSubPath("clearingTimestamp"), ZonedDateTime.class, getClearingTimestamp(), this);
		processor.processBasic(path.newSubPath("clearingAccountOrigin"), ClearingAccountOriginEnum.class, getClearingAccountOrigin(), this);
		processor.processBasic(path.newSubPath("clearingReceiptTimestamp"), ZonedDateTime.class, getClearingReceiptTimestamp(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifier"), String.class, getUniqueTransactionIdentifier(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
		processor.processBasic(path.newSubPath("uniqueProductIdentifier"), String.class, getUniqueProductIdentifier(), this);
		processor.processBasic(path.newSubPath("originalSwapUTI"), String.class, getOriginalSwapUTI(), this);
		processor.processBasic(path.newSubPath("subsequentPositionUTI"), String.class, getSubsequentPositionUTI(), this);
		processor.processBasic(path.newSubPath("originalSwapSDRIdentifier"), String.class, getOriginalSwapSDRIdentifier(), this);
		processor.processBasic(path.newSubPath("priorUSI"), String.class, getPriorUSI(), this);
		processor.processBasic(path.newSubPath("newSDRIdentifier"), String.class, getNewSDRIdentifier(), this);
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		processor.processBasic(path.newSubPath("referenceEntity"), String.class, getReferenceEntity(), this);
		processor.processBasic(path.newSubPath("seniority"), SeniorityEnum.class, getSeniority(), this);
		processor.processBasic(path.newSubPath("series"), Integer.class, getSeries(), this);
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processor.processBasic(path.newSubPath("seriesVersion"), Integer.class, getSeriesVersion(), this);
		processor.processBasic(path.newSubPath("baseProduct"), String.class, getBaseProduct(), this);
		processor.processBasic(path.newSubPath("subProduct"), String.class, getSubProduct(), this);
		processor.processBasic(path.newSubPath("furtherSubProduct"), String.class, getFurtherSubProduct(), this);
		processRosetta(path.newSubPath("barrier"), processor, SingleOrUpperAndLowerBarrier.class, getBarrier());
		processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
		processRosetta(path.newSubPath("nonReportable"), processor, CSANonReportable.class, getNonReportable());
		processor.processBasic(path.newSubPath("countryAndProvinceOrTerritoryOfIndividual"), String.class, getCountryAndProvinceOrTerritoryOfIndividual(), this);
		processor.processBasic(path.newSubPath("jurisdictionOfCounterparty1"), String.class, getJurisdictionOfCounterparty1(), this);
		processor.processBasic(path.newSubPath("jurisdictionOfCounterparty2"), String.class, getJurisdictionOfCounterparty2(), this);
		processor.processBasic(path.newSubPath("interAffiliateIndicator"), Boolean.class, getInterAffiliateIndicator(), this);
		processor.processBasic(path.newSubPath("platformAnonymousExecutionIndicator"), Boolean.class, getPlatformAnonymousExecutionIndicator(), this);
		processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.class, getDtccAdditionalFields());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSATransactionReportTradeBuilder extends CSATransactionReportTrade, CSATransactionReport.CSATransactionReportBuilder {
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEffectiveDate(Date effectiveDate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setExpirationDate(Date expirationDate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty1(String counterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2(String counterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBeneficiary1(String beneficiary1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCleared(ClearedEnum cleared);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingMember(String clearingMember);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCallAmount(BigDecimal callAmount);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPutAmount(BigDecimal putAmount);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setDelta(BigDecimal delta);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPrice(PriceFormat price);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriorUTI(String priorUTI);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setDirection1(Direction1Enum direction1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCustomBasketCode(String customBasketCode);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(LegV1 leg1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(LegV1 leg2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(LegV2 leg1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(LegV2 leg2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(Leg leg1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(Leg leg2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLevel(ReportLevelEnum level);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setActionType(ActionTypeEnum actionType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventType(EventTypeEnum eventType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventIdentifier(String eventIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(CommonLeg leg1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(CommonLeg leg2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBrokerID(String brokerID);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setContractType(CommonContractType contractType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionType(OptionTypeCode optionType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setIntragroup(Boolean intragroup);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSwapLinkID(String swapLinkID);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriorUSI(String priorUSI);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setReferenceEntity(String referenceEntity);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSeniority(SeniorityEnum seniority);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSeries(Integer series);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBaseProduct(String baseProduct);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setSubProduct(String subProduct);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNonReportable(NonReportable nonReportable);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(CSALeg leg1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(CSALeg leg2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setNonReportable(CSANonReportable nonReportable);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setCountryAndProvinceOrTerritoryOfIndividual(String countryAndProvinceOrTerritoryOfIndividual);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty1(String jurisdictionOfCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty1(String jurisdictionOfCounterparty1, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty1(List<String> jurisdictionOfCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setJurisdictionOfCounterparty1(List<String> jurisdictionOfCounterparty1);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty2(String jurisdictionOfCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty2(String jurisdictionOfCounterparty2, int idx);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty2(List<String> jurisdictionOfCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setJurisdictionOfCounterparty2(List<String> jurisdictionOfCounterparty2);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setInterAffiliateIndicator(Boolean interAffiliateIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setPlatformAnonymousExecutionIndicator(Boolean platformAnonymousExecutionIndicator);
		@Override
		CSATransactionReportTrade.CSATransactionReportTradeBuilder setDtccAdditionalFields(DTCCAdditionalFields dtccAdditionalFields);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("earlyTerminationDate"), Date.class, getEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("executionTimestamp"), ZonedDateTime.class, getExecutionTimestamp(), this);
			processor.processBasic(path.newSubPath("expirationDate"), Date.class, getExpirationDate(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("beneficiary1"), String.class, getBeneficiary1(), this);
			processor.processBasic(path.newSubPath("beneficiary1IdentifierTypeIndicator"), Boolean.class, getBeneficiary1IdentifierTypeIndicator(), this);
			processor.processBasic(path.newSubPath("buyerIdentifier"), String.class, getBuyerIdentifier(), this);
			processor.processBasic(path.newSubPath("sellerIdentifier"), String.class, getSellerIdentifier(), this);
			processor.processBasic(path.newSubPath("cleared"), ClearedEnum.class, getCleared(), this);
			processor.processBasic(path.newSubPath("centralCounterparty"), String.class, getCentralCounterparty(), this);
			processor.processBasic(path.newSubPath("clearingMember"), String.class, getClearingMember(), this);
			processor.processBasic(path.newSubPath("confirmed"), ConfirmationEnum.class, getConfirmed(), this);
			processor.processBasic(path.newSubPath("callAmount"), BigDecimal.class, getCallAmount(), this);
			processor.processBasic(path.newSubPath("putAmount"), BigDecimal.class, getPutAmount(), this);
			processor.processBasic(path.newSubPath("callCurrency"), ISOCurrencyCodeEnum.class, getCallCurrency(), this);
			processor.processBasic(path.newSubPath("putCurrency"), ISOCurrencyCodeEnum.class, getPutCurrency(), this);
			processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
			processRosetta(path.newSubPath("priceSchedule"), processor, PricePeriod.PricePeriodBuilder.class, getPriceSchedule());
			processRosetta(path.newSubPath("strikePriceSchedule"), processor, PricePeriod.PricePeriodBuilder.class, getStrikePriceSchedule());
			processRosetta(path.newSubPath("price"), processor, PriceFormat.PriceFormatBuilder.class, getPrice());
			processor.processBasic(path.newSubPath("priceNotation"), PriceNotationEnum.class, getPriceNotation(), this);
			processor.processBasic(path.newSubPath("priceCurrency"), ISOCurrencyCodeEnum.class, getPriceCurrency(), this);
			processRosetta(path.newSubPath("packageTransactionPrice"), processor, PriceFormat.PriceFormatBuilder.class, getPackageTransactionPrice());
			processor.processBasic(path.newSubPath("packageTransactionPriceNotation"), PriceNotationEnum.class, getPackageTransactionPriceNotation(), this);
			processor.processBasic(path.newSubPath("packageTransactionPriceCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionPriceCurrency(), this);
			processRosetta(path.newSubPath("packageTransactionSpread"), processor, PriceFormat.PriceFormatBuilder.class, getPackageTransactionSpread());
			processor.processBasic(path.newSubPath("packageTransactionSpreadNotation"), PriceNotationEnum.class, getPackageTransactionSpreadNotation(), this);
			processor.processBasic(path.newSubPath("packageTransactionSpreadCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionSpreadCurrency(), this);
			processor.processBasic(path.newSubPath("packageIdentifier"), String.class, getPackageIdentifier(), this);
			processRosetta(path.newSubPath("strikePrice"), processor, PriceFormat.PriceFormatBuilder.class, getStrikePrice());
			processor.processBasic(path.newSubPath("strikePriceNotation"), PriceNotationEnum.class, getStrikePriceNotation(), this);
			processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
			processor.processBasic(path.newSubPath("priceUnitOfMeasure"), String.class, getPriceUnitOfMeasure(), this);
			processor.processBasic(path.newSubPath("optionPremiumAmount"), BigDecimal.class, getOptionPremiumAmount(), this);
			processor.processBasic(path.newSubPath("optionPremiumCurrency"), ISOCurrencyCodeEnum.class, getOptionPremiumCurrency(), this);
			processor.processBasic(path.newSubPath("optionPremiumPaymentDate"), Date.class, getOptionPremiumPaymentDate(), this);
			processor.processBasic(path.newSubPath("exchangeRate"), BigDecimal.class, getExchangeRate(), this);
			processor.processBasic(path.newSubPath("exchangeRateBasis"), String.class, getExchangeRateBasis(), this);
			processor.processBasic(path.newSubPath("cdSIndexAttachmentPoint"), BigDecimal.class, getCdSIndexAttachmentPoint(), this);
			processor.processBasic(path.newSubPath("cdSIndexDetachmentPoint"), BigDecimal.class, getCdSIndexDetachmentPoint(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
			processor.processBasic(path.newSubPath("firstExerciseDate"), Date.class, getFirstExerciseDate(), this);
			processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
			processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
			processor.processBasic(path.newSubPath("priorUTI"), String.class, getPriorUTI(), this);
			processor.processBasic(path.newSubPath("direction1"), Direction1Enum.class, getDirection1(), this);
			processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
			processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
			processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
			processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
			processRosetta(path.newSubPath("basketConstituents"), processor, BasketConstituentsReport.BasketConstituentsReportBuilder.class, getBasketConstituents());
			processRosetta(path.newSubPath("otherPayment"), processor, OtherPayment.OtherPaymentBuilder.class, getOtherPayment());
			processRosetta(path.newSubPath("leg1"), processor, CSALeg.CSALegBuilder.class, getLeg1());
			processRosetta(path.newSubPath("leg2"), processor, CSALeg.CSALegBuilder.class, getLeg2());
			processor.processBasic(path.newSubPath("underlyingIdOther"), String.class, getUnderlyingIdOther(), this);
			processor.processBasic(path.newSubPath("underlyingIdOtherSource"), AssetIdTypeEnum.class, getUnderlyingIdOtherSource(), this);
			processor.processBasic(path.newSubPath("underlyingAssetTradingPlatformIdentifier"), String.class, getUnderlyingAssetTradingPlatformIdentifier(), this);
			processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
			processor.processBasic(path.newSubPath("cryptoAssetUnderlyingIndicator"), Boolean.class, getCryptoAssetUnderlyingIndicator(), this);
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
			processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
			processor.processBasic(path.newSubPath("eventType"), EventTypeEnum.class, getEventType(), this);
			processor.processBasic(path.newSubPath("eventIdentifier"), String.class, getEventIdentifier(), this);
			processor.processBasic(path.newSubPath("eventTimestamp"), ZonedDateTime.class, getEventTimestamp(), this);
			processor.processBasic(path.newSubPath("confirmationTimestamp"), ZonedDateTime.class, getConfirmationTimestamp(), this);
			processor.processBasic(path.newSubPath("platformIdentifier"), String.class, getPlatformIdentifier(), this);
			processor.processBasic(path.newSubPath("bookingLocation"), ISOCountryCodeEnum.class, getBookingLocation(), this);
			processor.processBasic(path.newSubPath("traderLocation"), ISOCountryCodeEnum.class, getTraderLocation(), this);
			processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("executionAgentCounterparty1"), String.class, getExecutionAgentCounterparty1(), this);
			processor.processBasic(path.newSubPath("executionAgentCounterparty2"), String.class, getExecutionAgentCounterparty2(), this);
			processor.processBasic(path.newSubPath("natureOfCounterparty1"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty1(), this);
			processor.processBasic(path.newSubPath("natureOfCounterparty2"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty2(), this);
			processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty1"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty1(), this);
			processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty2"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty2(), this);
			processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty1"), String.class, getCorporateSectorOfTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty2"), String.class, getCorporateSectorOfTheCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
			processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
			processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
			processor.processBasic(path.newSubPath("countryOfTheCounterparty2"), ISOCountryCodeEnum.class, getCountryOfTheCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), Counterparty2IdentifierEnum.class, getCounterparty2IdentifierSource(), this);
			processor.processBasic(path.newSubPath("tradingCapacity"), TradingCapacity7Code.class, getTradingCapacity(), this);
			processor.processBasic(path.newSubPath("brokerID"), String.class, getBrokerID(), this);
			processor.processBasic(path.newSubPath("contractType"), CommonContractType.class, getContractType(), this);
			processor.processBasic(path.newSubPath("assetClass"), CommonAssetClass.class, getAssetClass(), this);
			processor.processBasic(path.newSubPath("optionType"), OptionTypeCode.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
			processor.processBasic(path.newSubPath("embeddedOptionType"), EmbeddedOptionTypeEnum.class, getEmbeddedOptionType(), this);
			processor.processBasic(path.newSubPath("masterAgreementType"), MasterAgreementEnum.class, getMasterAgreementType(), this);
			processor.processBasic(path.newSubPath("masterAgreementVersion"), Integer.class, getMasterAgreementVersion(), this);
			processor.processBasic(path.newSubPath("secondaryTransactionIdentifier"), String.class, getSecondaryTransactionIdentifier(), this);
			processor.processBasic(path.newSubPath("intragroup"), Boolean.class, getIntragroup(), this);
			processor.processBasic(path.newSubPath("nonStandardizedTermIndicator"), Boolean.class, getNonStandardizedTermIndicator(), this);
			processor.processBasic(path.newSubPath("amendmentIndicator"), Boolean.class, getAmendmentIndicator(), this);
			processor.processBasic(path.newSubPath("underlyingIdentification"), String.class, getUnderlyingIdentification(), this);
			processor.processBasic(path.newSubPath("underlyingIdentificationType"), UnderlyingIdentificationTypeEnum.class, getUnderlyingIdentificationType(), this);
			processor.processBasic(path.newSubPath("nameOfTheUnderlyingIndex"), String.class, getNameOfTheUnderlyingIndex(), this);
			processor.processBasic(path.newSubPath("maturityDateOfTheUnderlying"), Date.class, getMaturityDateOfTheUnderlying(), this);
			processor.processBasic(path.newSubPath("swapLinkID"), String.class, getSwapLinkID(), this);
			processor.processBasic(path.newSubPath("packageIndicator"), Boolean.class, getPackageIndicator(), this);
			processor.processBasic(path.newSubPath("customBasketIndicator"), Boolean.class, getCustomBasketIndicator(), this);
			processor.processBasic(path.newSubPath("priorUTIProprietary"), String.class, getPriorUTIProprietary(), this);
			processor.processBasic(path.newSubPath("clearingTimestamp"), ZonedDateTime.class, getClearingTimestamp(), this);
			processor.processBasic(path.newSubPath("clearingAccountOrigin"), ClearingAccountOriginEnum.class, getClearingAccountOrigin(), this);
			processor.processBasic(path.newSubPath("clearingReceiptTimestamp"), ZonedDateTime.class, getClearingReceiptTimestamp(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifier"), String.class, getUniqueTransactionIdentifier(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
			processor.processBasic(path.newSubPath("uniqueProductIdentifier"), String.class, getUniqueProductIdentifier(), this);
			processor.processBasic(path.newSubPath("originalSwapUTI"), String.class, getOriginalSwapUTI(), this);
			processor.processBasic(path.newSubPath("subsequentPositionUTI"), String.class, getSubsequentPositionUTI(), this);
			processor.processBasic(path.newSubPath("originalSwapSDRIdentifier"), String.class, getOriginalSwapSDRIdentifier(), this);
			processor.processBasic(path.newSubPath("priorUSI"), String.class, getPriorUSI(), this);
			processor.processBasic(path.newSubPath("newSDRIdentifier"), String.class, getNewSDRIdentifier(), this);
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
			processor.processBasic(path.newSubPath("referenceEntity"), String.class, getReferenceEntity(), this);
			processor.processBasic(path.newSubPath("seniority"), SeniorityEnum.class, getSeniority(), this);
			processor.processBasic(path.newSubPath("series"), Integer.class, getSeries(), this);
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processor.processBasic(path.newSubPath("seriesVersion"), Integer.class, getSeriesVersion(), this);
			processor.processBasic(path.newSubPath("baseProduct"), String.class, getBaseProduct(), this);
			processor.processBasic(path.newSubPath("subProduct"), String.class, getSubProduct(), this);
			processor.processBasic(path.newSubPath("furtherSubProduct"), String.class, getFurtherSubProduct(), this);
			processRosetta(path.newSubPath("barrier"), processor, SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder.class, getBarrier());
			processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
			processRosetta(path.newSubPath("nonReportable"), processor, CSANonReportable.CSANonReportableBuilder.class, getNonReportable());
			processor.processBasic(path.newSubPath("countryAndProvinceOrTerritoryOfIndividual"), String.class, getCountryAndProvinceOrTerritoryOfIndividual(), this);
			processor.processBasic(path.newSubPath("jurisdictionOfCounterparty1"), String.class, getJurisdictionOfCounterparty1(), this);
			processor.processBasic(path.newSubPath("jurisdictionOfCounterparty2"), String.class, getJurisdictionOfCounterparty2(), this);
			processor.processBasic(path.newSubPath("interAffiliateIndicator"), Boolean.class, getInterAffiliateIndicator(), this);
			processor.processBasic(path.newSubPath("platformAnonymousExecutionIndicator"), Boolean.class, getPlatformAnonymousExecutionIndicator(), this);
			processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.DTCCAdditionalFieldsBuilder.class, getDtccAdditionalFields());
		}
		

		CSATransactionReportTrade.CSATransactionReportTradeBuilder prune();
	}

	/*********************** Immutable Implementation of CSATransactionReportTrade  ***********************/
	class CSATransactionReportTradeImpl extends CSATransactionReport.CSATransactionReportImpl implements CSATransactionReportTrade {
		
		protected CSATransactionReportTradeImpl(CSATransactionReportTrade.CSATransactionReportTradeBuilder builder) {
			super(builder);
		}
		
		@Override
		public CSATransactionReportTrade build() {
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder toBuilder() {
			CSATransactionReportTrade.CSATransactionReportTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSATransactionReportTrade.CSATransactionReportTradeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSATransactionReportTrade {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CSATransactionReportTrade  ***********************/
	class CSATransactionReportTradeBuilderImpl extends CSATransactionReport.CSATransactionReportBuilderImpl implements CSATransactionReportTrade.CSATransactionReportTradeBuilder {
	
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
			if (priceSchedules != null) {
				for (final PricePeriod toAdd : priceSchedules) {
					this.priceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
			if (priceSchedules == null) {
				this.priceSchedule = new ArrayList<>();
			} else {
				this.priceSchedule = priceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
			if (strikePriceSchedules != null) {
				for (final PricePeriod toAdd : strikePriceSchedules) {
					this.strikePriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
			if (strikePriceSchedules == null) {
				this.strikePriceSchedule = new ArrayList<>();
			} else {
				this.strikePriceSchedule = strikePriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
			if (basketConstituentss != null) {
				for (final BasketConstituentsReport toAdd : basketConstituentss) {
					this.basketConstituents.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
			if (basketConstituentss == null) {
				this.basketConstituents = new ArrayList<>();
			} else {
				this.basketConstituents = basketConstituentss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
			if (otherPayments != null) {
				for (final OtherPayment toAdd : otherPayments) {
					this.otherPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
			if (otherPayments == null) {
				this.otherPayment = new ArrayList<>();
			} else {
				this.otherPayment = otherPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(CSALeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(CommonLeg _leg1) {
			final CSALeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CSALeg ? CSALeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(Leg _leg1) {
			final CSALeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CSALeg ? CSALeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(LegV2 _leg1) {
			final CSALeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CSALeg ? CSALeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg1(LegV1 _leg1) {
			final CSALeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CSALeg ? CSALeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(CSALeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(CommonLeg _leg2) {
			final CSALeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CSALeg ? CSALeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(Leg _leg2) {
			final CSALeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CSALeg ? CSALeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(LegV2 _leg2) {
			final CSALeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CSALeg ? CSALeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLeg2(LegV1 _leg2) {
			final CSALeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CSALeg ? CSALeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaAttribute("underlyingIdOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOther")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
			if (clearingExceptionsAndExemptionsCounterparty1s != null) {
				for (final ClearingExceptionsAndExemptionsEnum toAdd : clearingExceptionsAndExemptionsCounterparty1s) {
					this.clearingExceptionsAndExemptionsCounterparty1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
			if (clearingExceptionsAndExemptionsCounterparty1s == null) {
				this.clearingExceptionsAndExemptionsCounterparty1 = new ArrayList<>();
			} else {
				this.clearingExceptionsAndExemptionsCounterparty1 = clearingExceptionsAndExemptionsCounterparty1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
			if (clearingExceptionsAndExemptionsCounterparty2s != null) {
				for (final ClearingExceptionsAndExemptionsEnum toAdd : clearingExceptionsAndExemptionsCounterparty2s) {
					this.clearingExceptionsAndExemptionsCounterparty2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
			if (clearingExceptionsAndExemptionsCounterparty2s == null) {
				this.clearingExceptionsAndExemptionsCounterparty2 = new ArrayList<>();
			} else {
				this.clearingExceptionsAndExemptionsCounterparty2 = clearingExceptionsAndExemptionsCounterparty2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
			if (corporateSectorOfTheCounterparty1s != null) {
				for (final String toAdd : corporateSectorOfTheCounterparty1s) {
					this.corporateSectorOfTheCounterparty1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
			if (corporateSectorOfTheCounterparty1s == null) {
				this.corporateSectorOfTheCounterparty1 = new ArrayList<>();
			} else {
				this.corporateSectorOfTheCounterparty1 = corporateSectorOfTheCounterparty1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
			if (corporateSectorOfTheCounterparty2s != null) {
				for (final String toAdd : corporateSectorOfTheCounterparty2s) {
					this.corporateSectorOfTheCounterparty2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
			if (corporateSectorOfTheCounterparty2s == null) {
				this.corporateSectorOfTheCounterparty2 = new ArrayList<>();
			} else {
				this.corporateSectorOfTheCounterparty2 = corporateSectorOfTheCounterparty2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2Name")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			return setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(_counterparty2IdentifierSource);
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClass")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPackageIndicator(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNonReportable(CSANonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setNonReportable(NonReportable _nonReportable) {
			final CSANonReportable ifThenElseResult;
			if (_nonReportable == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _nonReportable instanceof CSANonReportable ? CSANonReportable.class.cast(_nonReportable) : null;
			}
			return setNonReportable(ifThenElseResult);
		}
		
		@RosettaAttribute("countryAndProvinceOrTerritoryOfIndividual")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryAndProvinceOrTerritoryOfIndividual")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setCountryAndProvinceOrTerritoryOfIndividual(String _countryAndProvinceOrTerritoryOfIndividual) {
			this.countryAndProvinceOrTerritoryOfIndividual = _countryAndProvinceOrTerritoryOfIndividual == null ? null : _countryAndProvinceOrTerritoryOfIndividual;
			return this;
		}
		
		@RosettaAttribute("jurisdictionOfCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("jurisdictionOfCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty1(String _jurisdictionOfCounterparty1) {
			if (_jurisdictionOfCounterparty1 != null) {
				this.jurisdictionOfCounterparty1.add(_jurisdictionOfCounterparty1);
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty1(String _jurisdictionOfCounterparty1, int idx) {
			getIndex(this.jurisdictionOfCounterparty1, idx, () -> _jurisdictionOfCounterparty1);
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty1(List<String> jurisdictionOfCounterparty1s) {
			if (jurisdictionOfCounterparty1s != null) {
				for (final String toAdd : jurisdictionOfCounterparty1s) {
					this.jurisdictionOfCounterparty1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("jurisdictionOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("jurisdictionOfCounterparty1")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setJurisdictionOfCounterparty1(List<String> jurisdictionOfCounterparty1s) {
			if (jurisdictionOfCounterparty1s == null) {
				this.jurisdictionOfCounterparty1 = new ArrayList<>();
			} else {
				this.jurisdictionOfCounterparty1 = jurisdictionOfCounterparty1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("jurisdictionOfCounterparty2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("jurisdictionOfCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty2(String _jurisdictionOfCounterparty2) {
			if (_jurisdictionOfCounterparty2 != null) {
				this.jurisdictionOfCounterparty2.add(_jurisdictionOfCounterparty2);
			}
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty2(String _jurisdictionOfCounterparty2, int idx) {
			getIndex(this.jurisdictionOfCounterparty2, idx, () -> _jurisdictionOfCounterparty2);
			return this;
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder addJurisdictionOfCounterparty2(List<String> jurisdictionOfCounterparty2s) {
			if (jurisdictionOfCounterparty2s != null) {
				for (final String toAdd : jurisdictionOfCounterparty2s) {
					this.jurisdictionOfCounterparty2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("jurisdictionOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("jurisdictionOfCounterparty2")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setJurisdictionOfCounterparty2(List<String> jurisdictionOfCounterparty2s) {
			if (jurisdictionOfCounterparty2s == null) {
				this.jurisdictionOfCounterparty2 = new ArrayList<>();
			} else {
				this.jurisdictionOfCounterparty2 = jurisdictionOfCounterparty2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("interAffiliateIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interAffiliateIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setInterAffiliateIndicator(Boolean _interAffiliateIndicator) {
			this.interAffiliateIndicator = _interAffiliateIndicator == null ? null : _interAffiliateIndicator;
			return this;
		}
		
		@RosettaAttribute("platformAnonymousExecutionIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformAnonymousExecutionIndicator")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setPlatformAnonymousExecutionIndicator(Boolean _platformAnonymousExecutionIndicator) {
			this.platformAnonymousExecutionIndicator = _platformAnonymousExecutionIndicator == null ? null : _platformAnonymousExecutionIndicator;
			return this;
		}
		
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtccAdditionalFields")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder setDtccAdditionalFields(DTCCAdditionalFields _dtccAdditionalFields) {
			this.dtccAdditionalFields = _dtccAdditionalFields == null ? null : _dtccAdditionalFields.toBuilder();
			return this;
		}
		
		@Override
		public CSATransactionReportTrade build() {
			return new CSATransactionReportTrade.CSATransactionReportTradeImpl(this);
		}
		
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSATransactionReportTrade.CSATransactionReportTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CSATransactionReportTrade.CSATransactionReportTradeBuilder o = (CSATransactionReportTrade.CSATransactionReportTradeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSATransactionReportTradeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
