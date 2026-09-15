package drr.regulation.common.emir;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
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
import drr.regulation.common.ReportableDelivery;
import drr.regulation.common.emir.meta.EMIRTransactionReportMeta;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.CommonTransactionReport;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.standards.iosco.cde.version1.LegV1;
import drr.standards.iosco.cde.version2.LegV2;
import drr.standards.iosco.cde.version3.Leg;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ClearingObligationEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.DeliveryTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.EnergyLoadType1Code;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.IndexEnum;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.RiskReductionTechniqueEnum;
import drr.standards.iso.SeniorityEnum;
import drr.standards.iso.TradingCapacity7Code;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="EMIRTransactionReport", builder=EMIRTransactionReport.EMIRTransactionReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="EMIRTransactionReport", model="drr", builder=EMIRTransactionReport.EMIRTransactionReportBuilderImpl.class, version="7.7.0")
public interface EMIRTransactionReport extends CommonTransactionReport {

	EMIRTransactionReportMeta metaData = new EMIRTransactionReportMeta();

	/*********************** Getter Methods  ***********************/
	@Override
	CommonContractType getContractType();
	@Override
	CommonAssetClass getAssetClass();
	@Override
	ClearedEnum getCleared();
	@Override
	MasterAgreementEnum getMasterAgreementType();
	@Override
	ZonedDateTime getExecutionTimestamp();
	@Override
	Date getEffectiveDate();
	@Override
	DeliveryTypeEnum getDeliveryType();
	String getOtherMasterAgreementType();
	String getCollateralPortfolioCode();
	String getPtrrId();
	Boolean getClearingThresholdOfCounterparty1();
	Boolean getClearingThresholdOfCounterparty2();
	Boolean getReportingObligationOfTheCounterparty2();
	Boolean getDirectlyLinkedToCommercialActivityOrTreasuryFinancing();
	String getReportTrackingNumber();
	String getIsin();
	String getProductClassification();
	List<IndexEnum> getIndicatorOfTheUnderlyingIndex();
	ClearingObligationEnum getClearingObligation();
	Boolean getPtrr();
	RiskReductionTechniqueEnum getTypeOfPTRRTechnique();
	String getPtrrServiceProvider();
	String getVenueOfExecution();
	BigDecimal getForwardExchangeRate();
	List<String> getDeliveryPoint();
	String getInterconnectionPoint();
	EnergyLoadType1Code getLoadType();
	List<? extends ReportableDelivery> getDeliveryReport();
	Boolean getTranche();
	Date getEventDate();

	/*********************** Build Methods  ***********************/
	EMIRTransactionReport build();
	
	EMIRTransactionReport.EMIRTransactionReportBuilder toBuilder();
	
	static EMIRTransactionReport.EMIRTransactionReportBuilder builder() {
		return new EMIRTransactionReport.EMIRTransactionReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EMIRTransactionReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EMIRTransactionReport> getType() {
		return EMIRTransactionReport.class;
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
		processRosetta(path.newSubPath("leg1"), processor, CommonLeg.class, getLeg1());
		processRosetta(path.newSubPath("leg2"), processor, CommonLeg.class, getLeg2());
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
		processRosetta(path.newSubPath("nonReportable"), processor, NonReportable.class, getNonReportable());
		processor.processBasic(path.newSubPath("otherMasterAgreementType"), String.class, getOtherMasterAgreementType(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioCode"), String.class, getCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("ptrrId"), String.class, getPtrrId(), this);
		processor.processBasic(path.newSubPath("clearingThresholdOfCounterparty1"), Boolean.class, getClearingThresholdOfCounterparty1(), this);
		processor.processBasic(path.newSubPath("clearingThresholdOfCounterparty2"), Boolean.class, getClearingThresholdOfCounterparty2(), this);
		processor.processBasic(path.newSubPath("reportingObligationOfTheCounterparty2"), Boolean.class, getReportingObligationOfTheCounterparty2(), this);
		processor.processBasic(path.newSubPath("directlyLinkedToCommercialActivityOrTreasuryFinancing"), Boolean.class, getDirectlyLinkedToCommercialActivityOrTreasuryFinancing(), this);
		processor.processBasic(path.newSubPath("reportTrackingNumber"), String.class, getReportTrackingNumber(), this);
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		processor.processBasic(path.newSubPath("productClassification"), String.class, getProductClassification(), this);
		processor.processBasic(path.newSubPath("indicatorOfTheUnderlyingIndex"), IndexEnum.class, getIndicatorOfTheUnderlyingIndex(), this);
		processor.processBasic(path.newSubPath("clearingObligation"), ClearingObligationEnum.class, getClearingObligation(), this);
		processor.processBasic(path.newSubPath("ptrr"), Boolean.class, getPtrr(), this);
		processor.processBasic(path.newSubPath("typeOfPTRRTechnique"), RiskReductionTechniqueEnum.class, getTypeOfPTRRTechnique(), this);
		processor.processBasic(path.newSubPath("ptrrServiceProvider"), String.class, getPtrrServiceProvider(), this);
		processor.processBasic(path.newSubPath("venueOfExecution"), String.class, getVenueOfExecution(), this);
		processor.processBasic(path.newSubPath("forwardExchangeRate"), BigDecimal.class, getForwardExchangeRate(), this);
		processor.processBasic(path.newSubPath("deliveryPoint"), String.class, getDeliveryPoint(), this);
		processor.processBasic(path.newSubPath("interconnectionPoint"), String.class, getInterconnectionPoint(), this);
		processor.processBasic(path.newSubPath("loadType"), EnergyLoadType1Code.class, getLoadType(), this);
		processRosetta(path.newSubPath("deliveryReport"), processor, ReportableDelivery.class, getDeliveryReport());
		processor.processBasic(path.newSubPath("tranche"), Boolean.class, getTranche(), this);
		processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EMIRTransactionReportBuilder extends EMIRTransactionReport, CommonTransactionReport.CommonTransactionReportBuilder {
		ReportableDelivery.ReportableDeliveryBuilder getOrCreateDeliveryReport(int index);
		@Override
		List<? extends ReportableDelivery.ReportableDeliveryBuilder> getDeliveryReport();
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEffectiveDate(Date effectiveDate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setExpirationDate(Date expirationDate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty1(String counterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2(String counterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBeneficiary1(String beneficiary1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCleared(ClearedEnum cleared);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingMember(String clearingMember);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCallAmount(BigDecimal callAmount);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPutAmount(BigDecimal putAmount);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setDelta(BigDecimal delta);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPrice(PriceFormat price);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriorUTI(String priorUTI);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setDirection1(Direction1Enum direction1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCustomBasketCode(String customBasketCode);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(LegV1 leg1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(LegV1 leg2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(LegV2 leg1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(LegV2 leg2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(Leg leg1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(Leg leg2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLevel(ReportLevelEnum level);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEventType(EventTypeEnum eventType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEventIdentifier(String eventIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(CommonLeg leg1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(CommonLeg leg2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBrokerID(String brokerID);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setContractType(CommonContractType contractType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOptionType(OptionTypeCode optionType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setIntragroup(Boolean intragroup);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSwapLinkID(String swapLinkID);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setPriorUSI(String priorUSI);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setReferenceEntity(String referenceEntity);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSeniority(SeniorityEnum seniority);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSeries(Integer series);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBaseProduct(String baseProduct);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setSubProduct(String subProduct);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		EMIRTransactionReport.EMIRTransactionReportBuilder setNonReportable(NonReportable nonReportable);
		EMIRTransactionReport.EMIRTransactionReportBuilder setContractTypeOverriddenAsCommonContractType(CommonContractType contractType);
		EMIRTransactionReport.EMIRTransactionReportBuilder setAssetClassOverriddenAsCommonAssetClass(CommonAssetClass assetClass);
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		EMIRTransactionReport.EMIRTransactionReportBuilder setMasterAgreementTypeOverriddenAsMasterAgreementEnum(MasterAgreementEnum masterAgreementType);
		EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime executionTimestamp);
		EMIRTransactionReport.EMIRTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date effectiveDate);
		EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryTypeOverriddenAsDeliveryTypeEnum(DeliveryTypeEnum deliveryType);
		EMIRTransactionReport.EMIRTransactionReportBuilder setOtherMasterAgreementType(String otherMasterAgreementType);
		EMIRTransactionReport.EMIRTransactionReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		EMIRTransactionReport.EMIRTransactionReportBuilder setPtrrId(String ptrrId);
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingThresholdOfCounterparty1(Boolean clearingThresholdOfCounterparty1);
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingThresholdOfCounterparty2(Boolean clearingThresholdOfCounterparty2);
		EMIRTransactionReport.EMIRTransactionReportBuilder setReportingObligationOfTheCounterparty2(Boolean reportingObligationOfTheCounterparty2);
		EMIRTransactionReport.EMIRTransactionReportBuilder setDirectlyLinkedToCommercialActivityOrTreasuryFinancing(Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing);
		EMIRTransactionReport.EMIRTransactionReportBuilder setReportTrackingNumber(String reportTrackingNumber);
		EMIRTransactionReport.EMIRTransactionReportBuilder setIsin(String isin);
		EMIRTransactionReport.EMIRTransactionReportBuilder setProductClassification(String productClassification);
		EMIRTransactionReport.EMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum indicatorOfTheUnderlyingIndex);
		EMIRTransactionReport.EMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum indicatorOfTheUnderlyingIndex, int idx);
		EMIRTransactionReport.EMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndex);
		EMIRTransactionReport.EMIRTransactionReportBuilder setIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndex);
		EMIRTransactionReport.EMIRTransactionReportBuilder setClearingObligation(ClearingObligationEnum clearingObligation);
		EMIRTransactionReport.EMIRTransactionReportBuilder setPtrr(Boolean ptrr);
		EMIRTransactionReport.EMIRTransactionReportBuilder setTypeOfPTRRTechnique(RiskReductionTechniqueEnum typeOfPTRRTechnique);
		EMIRTransactionReport.EMIRTransactionReportBuilder setPtrrServiceProvider(String ptrrServiceProvider);
		EMIRTransactionReport.EMIRTransactionReportBuilder setVenueOfExecution(String venueOfExecution);
		EMIRTransactionReport.EMIRTransactionReportBuilder setForwardExchangeRate(BigDecimal forwardExchangeRate);
		EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryPoint(String deliveryPoint);
		EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryPoint(String deliveryPoint, int idx);
		EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryPoint(List<String> deliveryPoint);
		EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryPoint(List<String> deliveryPoint);
		EMIRTransactionReport.EMIRTransactionReportBuilder setInterconnectionPoint(String interconnectionPoint);
		EMIRTransactionReport.EMIRTransactionReportBuilder setLoadType(EnergyLoadType1Code loadType);
		EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery deliveryReport);
		EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery deliveryReport, int idx);
		EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryReport(List<? extends ReportableDelivery> deliveryReport);
		EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryReport(List<? extends ReportableDelivery> deliveryReport);
		EMIRTransactionReport.EMIRTransactionReportBuilder setTranche(Boolean tranche);
		EMIRTransactionReport.EMIRTransactionReportBuilder setEventDate(Date eventDate);

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
			processRosetta(path.newSubPath("leg1"), processor, CommonLeg.CommonLegBuilder.class, getLeg1());
			processRosetta(path.newSubPath("leg2"), processor, CommonLeg.CommonLegBuilder.class, getLeg2());
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
			processRosetta(path.newSubPath("nonReportable"), processor, NonReportable.NonReportableBuilder.class, getNonReportable());
			processor.processBasic(path.newSubPath("otherMasterAgreementType"), String.class, getOtherMasterAgreementType(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioCode"), String.class, getCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("ptrrId"), String.class, getPtrrId(), this);
			processor.processBasic(path.newSubPath("clearingThresholdOfCounterparty1"), Boolean.class, getClearingThresholdOfCounterparty1(), this);
			processor.processBasic(path.newSubPath("clearingThresholdOfCounterparty2"), Boolean.class, getClearingThresholdOfCounterparty2(), this);
			processor.processBasic(path.newSubPath("reportingObligationOfTheCounterparty2"), Boolean.class, getReportingObligationOfTheCounterparty2(), this);
			processor.processBasic(path.newSubPath("directlyLinkedToCommercialActivityOrTreasuryFinancing"), Boolean.class, getDirectlyLinkedToCommercialActivityOrTreasuryFinancing(), this);
			processor.processBasic(path.newSubPath("reportTrackingNumber"), String.class, getReportTrackingNumber(), this);
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
			processor.processBasic(path.newSubPath("productClassification"), String.class, getProductClassification(), this);
			processor.processBasic(path.newSubPath("indicatorOfTheUnderlyingIndex"), IndexEnum.class, getIndicatorOfTheUnderlyingIndex(), this);
			processor.processBasic(path.newSubPath("clearingObligation"), ClearingObligationEnum.class, getClearingObligation(), this);
			processor.processBasic(path.newSubPath("ptrr"), Boolean.class, getPtrr(), this);
			processor.processBasic(path.newSubPath("typeOfPTRRTechnique"), RiskReductionTechniqueEnum.class, getTypeOfPTRRTechnique(), this);
			processor.processBasic(path.newSubPath("ptrrServiceProvider"), String.class, getPtrrServiceProvider(), this);
			processor.processBasic(path.newSubPath("venueOfExecution"), String.class, getVenueOfExecution(), this);
			processor.processBasic(path.newSubPath("forwardExchangeRate"), BigDecimal.class, getForwardExchangeRate(), this);
			processor.processBasic(path.newSubPath("deliveryPoint"), String.class, getDeliveryPoint(), this);
			processor.processBasic(path.newSubPath("interconnectionPoint"), String.class, getInterconnectionPoint(), this);
			processor.processBasic(path.newSubPath("loadType"), EnergyLoadType1Code.class, getLoadType(), this);
			processRosetta(path.newSubPath("deliveryReport"), processor, ReportableDelivery.ReportableDeliveryBuilder.class, getDeliveryReport());
			processor.processBasic(path.newSubPath("tranche"), Boolean.class, getTranche(), this);
			processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
		}
		

		EMIRTransactionReport.EMIRTransactionReportBuilder prune();
	}

	/*********************** Immutable Implementation of EMIRTransactionReport  ***********************/
	class EMIRTransactionReportImpl extends CommonTransactionReport.CommonTransactionReportImpl implements EMIRTransactionReport {
		private final CommonContractType contractType;
		private final CommonAssetClass assetClass;
		private final ClearedEnum cleared;
		private final MasterAgreementEnum masterAgreementType;
		private final ZonedDateTime executionTimestamp;
		private final Date effectiveDate;
		private final DeliveryTypeEnum deliveryType;
		private final String otherMasterAgreementType;
		private final String collateralPortfolioCode;
		private final String ptrrId;
		private final Boolean clearingThresholdOfCounterparty1;
		private final Boolean clearingThresholdOfCounterparty2;
		private final Boolean reportingObligationOfTheCounterparty2;
		private final Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing;
		private final String reportTrackingNumber;
		private final String isin;
		private final String productClassification;
		private final List<IndexEnum> indicatorOfTheUnderlyingIndex;
		private final ClearingObligationEnum clearingObligation;
		private final Boolean ptrr;
		private final RiskReductionTechniqueEnum typeOfPTRRTechnique;
		private final String ptrrServiceProvider;
		private final String venueOfExecution;
		private final BigDecimal forwardExchangeRate;
		private final List<String> deliveryPoint;
		private final String interconnectionPoint;
		private final EnergyLoadType1Code loadType;
		private final List<? extends ReportableDelivery> deliveryReport;
		private final Boolean tranche;
		private final Date eventDate;
		
		protected EMIRTransactionReportImpl(EMIRTransactionReport.EMIRTransactionReportBuilder builder) {
			super(builder);
			this.contractType = builder.getContractType();
			this.assetClass = builder.getAssetClass();
			this.cleared = builder.getCleared();
			this.masterAgreementType = builder.getMasterAgreementType();
			this.executionTimestamp = builder.getExecutionTimestamp();
			this.effectiveDate = builder.getEffectiveDate();
			this.deliveryType = builder.getDeliveryType();
			this.otherMasterAgreementType = builder.getOtherMasterAgreementType();
			this.collateralPortfolioCode = builder.getCollateralPortfolioCode();
			this.ptrrId = builder.getPtrrId();
			this.clearingThresholdOfCounterparty1 = builder.getClearingThresholdOfCounterparty1();
			this.clearingThresholdOfCounterparty2 = builder.getClearingThresholdOfCounterparty2();
			this.reportingObligationOfTheCounterparty2 = builder.getReportingObligationOfTheCounterparty2();
			this.directlyLinkedToCommercialActivityOrTreasuryFinancing = builder.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing();
			this.reportTrackingNumber = builder.getReportTrackingNumber();
			this.isin = builder.getIsin();
			this.productClassification = builder.getProductClassification();
			this.indicatorOfTheUnderlyingIndex = ofNullable(builder.getIndicatorOfTheUnderlyingIndex()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.clearingObligation = builder.getClearingObligation();
			this.ptrr = builder.getPtrr();
			this.typeOfPTRRTechnique = builder.getTypeOfPTRRTechnique();
			this.ptrrServiceProvider = builder.getPtrrServiceProvider();
			this.venueOfExecution = builder.getVenueOfExecution();
			this.forwardExchangeRate = builder.getForwardExchangeRate();
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.interconnectionPoint = builder.getInterconnectionPoint();
			this.loadType = builder.getLoadType();
			this.deliveryReport = ofNullable(builder.getDeliveryReport()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tranche = builder.getTranche();
			this.eventDate = builder.getEventDate();
		}
		
		@Override
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractType")
		public CommonContractType getContractType() {
			return contractType;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("assetClass")
		public CommonAssetClass getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("masterAgreementType")
		public MasterAgreementEnum getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		public ZonedDateTime getExecutionTimestamp() {
			return executionTimestamp;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("otherMasterAgreementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherMasterAgreementType")
		public String getOtherMasterAgreementType() {
			return otherMasterAgreementType;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioCode")
		public String getCollateralPortfolioCode() {
			return collateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("ptrrId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptrrId")
		public String getPtrrId() {
			return ptrrId;
		}
		
		@Override
		@RosettaAttribute("clearingThresholdOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingThresholdOfCounterparty1")
		public Boolean getClearingThresholdOfCounterparty1() {
			return clearingThresholdOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("clearingThresholdOfCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingThresholdOfCounterparty2")
		public Boolean getClearingThresholdOfCounterparty2() {
			return clearingThresholdOfCounterparty2;
		}
		
		@Override
		@RosettaAttribute("reportingObligationOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingObligationOfTheCounterparty2")
		public Boolean getReportingObligationOfTheCounterparty2() {
			return reportingObligationOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		public Boolean getDirectlyLinkedToCommercialActivityOrTreasuryFinancing() {
			return directlyLinkedToCommercialActivityOrTreasuryFinancing;
		}
		
		@Override
		@RosettaAttribute("reportTrackingNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportTrackingNumber")
		public String getReportTrackingNumber() {
			return reportTrackingNumber;
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("productClassification")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("productClassification")
		public String getProductClassification() {
			return productClassification;
		}
		
		@Override
		@RosettaAttribute("indicatorOfTheUnderlyingIndex")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("indicatorOfTheUnderlyingIndex")
		public List<IndexEnum> getIndicatorOfTheUnderlyingIndex() {
			return indicatorOfTheUnderlyingIndex;
		}
		
		@Override
		@RosettaAttribute("clearingObligation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingObligation")
		public ClearingObligationEnum getClearingObligation() {
			return clearingObligation;
		}
		
		@Override
		@RosettaAttribute("ptrr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptrr")
		public Boolean getPtrr() {
			return ptrr;
		}
		
		@Override
		@RosettaAttribute("typeOfPTRRTechnique")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("typeOfPTRRTechnique")
		public RiskReductionTechniqueEnum getTypeOfPTRRTechnique() {
			return typeOfPTRRTechnique;
		}
		
		@Override
		@RosettaAttribute("ptrrServiceProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptrrServiceProvider")
		public String getPtrrServiceProvider() {
			return ptrrServiceProvider;
		}
		
		@Override
		@RosettaAttribute("venueOfExecution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("venueOfExecution")
		public String getVenueOfExecution() {
			return venueOfExecution;
		}
		
		@Override
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardExchangeRate")
		public BigDecimal getForwardExchangeRate() {
			return forwardExchangeRate;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryPoint")
		public List<String> getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public String getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public EnergyLoadType1Code getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("deliveryReport")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryReport")
		public List<? extends ReportableDelivery> getDeliveryReport() {
			return deliveryReport;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public Boolean getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		public EMIRTransactionReport build() {
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder toBuilder() {
			EMIRTransactionReport.EMIRTransactionReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EMIRTransactionReport.EMIRTransactionReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getContractType()).ifPresent(builder::setContractTypeOverriddenAsCommonContractType);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClassOverriddenAsCommonAssetClass);
			ofNullable(getCleared()).ifPresent(builder::setClearedOverriddenAsClearedEnum);
			ofNullable(getMasterAgreementType()).ifPresent(builder::setMasterAgreementTypeOverriddenAsMasterAgreementEnum);
			ofNullable(getExecutionTimestamp()).ifPresent(builder::setExecutionTimestampOverriddenAsZonedDateTime);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDateOverriddenAsDate);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryTypeOverriddenAsDeliveryTypeEnum);
			ofNullable(getOtherMasterAgreementType()).ifPresent(builder::setOtherMasterAgreementType);
			ofNullable(getCollateralPortfolioCode()).ifPresent(builder::setCollateralPortfolioCode);
			ofNullable(getPtrrId()).ifPresent(builder::setPtrrId);
			ofNullable(getClearingThresholdOfCounterparty1()).ifPresent(builder::setClearingThresholdOfCounterparty1);
			ofNullable(getClearingThresholdOfCounterparty2()).ifPresent(builder::setClearingThresholdOfCounterparty2);
			ofNullable(getReportingObligationOfTheCounterparty2()).ifPresent(builder::setReportingObligationOfTheCounterparty2);
			ofNullable(getDirectlyLinkedToCommercialActivityOrTreasuryFinancing()).ifPresent(builder::setDirectlyLinkedToCommercialActivityOrTreasuryFinancing);
			ofNullable(getReportTrackingNumber()).ifPresent(builder::setReportTrackingNumber);
			ofNullable(getIsin()).ifPresent(builder::setIsin);
			ofNullable(getProductClassification()).ifPresent(builder::setProductClassification);
			ofNullable(getIndicatorOfTheUnderlyingIndex()).ifPresent(builder::setIndicatorOfTheUnderlyingIndex);
			ofNullable(getClearingObligation()).ifPresent(builder::setClearingObligation);
			ofNullable(getPtrr()).ifPresent(builder::setPtrr);
			ofNullable(getTypeOfPTRRTechnique()).ifPresent(builder::setTypeOfPTRRTechnique);
			ofNullable(getPtrrServiceProvider()).ifPresent(builder::setPtrrServiceProvider);
			ofNullable(getVenueOfExecution()).ifPresent(builder::setVenueOfExecution);
			ofNullable(getForwardExchangeRate()).ifPresent(builder::setForwardExchangeRate);
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
			ofNullable(getLoadType()).ifPresent(builder::setLoadType);
			ofNullable(getDeliveryReport()).ifPresent(builder::setDeliveryReport);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
			ofNullable(getEventDate()).ifPresent(builder::setEventDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EMIRTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(contractType, _that.getContractType())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(otherMasterAgreementType, _that.getOtherMasterAgreementType())) return false;
			if (!Objects.equals(collateralPortfolioCode, _that.getCollateralPortfolioCode())) return false;
			if (!Objects.equals(ptrrId, _that.getPtrrId())) return false;
			if (!Objects.equals(clearingThresholdOfCounterparty1, _that.getClearingThresholdOfCounterparty1())) return false;
			if (!Objects.equals(clearingThresholdOfCounterparty2, _that.getClearingThresholdOfCounterparty2())) return false;
			if (!Objects.equals(reportingObligationOfTheCounterparty2, _that.getReportingObligationOfTheCounterparty2())) return false;
			if (!Objects.equals(directlyLinkedToCommercialActivityOrTreasuryFinancing, _that.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing())) return false;
			if (!Objects.equals(reportTrackingNumber, _that.getReportTrackingNumber())) return false;
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(productClassification, _that.getProductClassification())) return false;
			if (!ListEquals.listEquals(indicatorOfTheUnderlyingIndex, _that.getIndicatorOfTheUnderlyingIndex())) return false;
			if (!Objects.equals(clearingObligation, _that.getClearingObligation())) return false;
			if (!Objects.equals(ptrr, _that.getPtrr())) return false;
			if (!Objects.equals(typeOfPTRRTechnique, _that.getTypeOfPTRRTechnique())) return false;
			if (!Objects.equals(ptrrServiceProvider, _that.getPtrrServiceProvider())) return false;
			if (!Objects.equals(venueOfExecution, _that.getVenueOfExecution())) return false;
			if (!Objects.equals(forwardExchangeRate, _that.getForwardExchangeRate())) return false;
			if (!ListEquals.listEquals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!ListEquals.listEquals(deliveryReport, _that.getDeliveryReport())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (contractType != null ? contractType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherMasterAgreementType != null ? otherMasterAgreementType.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioCode != null ? collateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (ptrrId != null ? ptrrId.hashCode() : 0);
			_result = 31 * _result + (clearingThresholdOfCounterparty1 != null ? clearingThresholdOfCounterparty1.hashCode() : 0);
			_result = 31 * _result + (clearingThresholdOfCounterparty2 != null ? clearingThresholdOfCounterparty2.hashCode() : 0);
			_result = 31 * _result + (reportingObligationOfTheCounterparty2 != null ? reportingObligationOfTheCounterparty2.hashCode() : 0);
			_result = 31 * _result + (directlyLinkedToCommercialActivityOrTreasuryFinancing != null ? directlyLinkedToCommercialActivityOrTreasuryFinancing.hashCode() : 0);
			_result = 31 * _result + (reportTrackingNumber != null ? reportTrackingNumber.hashCode() : 0);
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (productClassification != null ? productClassification.hashCode() : 0);
			_result = 31 * _result + (indicatorOfTheUnderlyingIndex != null ? indicatorOfTheUnderlyingIndex.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (clearingObligation != null ? clearingObligation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ptrr != null ? ptrr.hashCode() : 0);
			_result = 31 * _result + (typeOfPTRRTechnique != null ? typeOfPTRRTechnique.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ptrrServiceProvider != null ? ptrrServiceProvider.hashCode() : 0);
			_result = 31 * _result + (venueOfExecution != null ? venueOfExecution.hashCode() : 0);
			_result = 31 * _result + (forwardExchangeRate != null ? forwardExchangeRate.hashCode() : 0);
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryReport != null ? deliveryReport.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EMIRTransactionReport {" +
				"contractType=" + this.contractType + ", " +
				"assetClass=" + this.assetClass + ", " +
				"cleared=" + this.cleared + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"otherMasterAgreementType=" + this.otherMasterAgreementType + ", " +
				"collateralPortfolioCode=" + this.collateralPortfolioCode + ", " +
				"ptrrId=" + this.ptrrId + ", " +
				"clearingThresholdOfCounterparty1=" + this.clearingThresholdOfCounterparty1 + ", " +
				"clearingThresholdOfCounterparty2=" + this.clearingThresholdOfCounterparty2 + ", " +
				"reportingObligationOfTheCounterparty2=" + this.reportingObligationOfTheCounterparty2 + ", " +
				"directlyLinkedToCommercialActivityOrTreasuryFinancing=" + this.directlyLinkedToCommercialActivityOrTreasuryFinancing + ", " +
				"reportTrackingNumber=" + this.reportTrackingNumber + ", " +
				"isin=" + this.isin + ", " +
				"productClassification=" + this.productClassification + ", " +
				"indicatorOfTheUnderlyingIndex=" + this.indicatorOfTheUnderlyingIndex + ", " +
				"clearingObligation=" + this.clearingObligation + ", " +
				"ptrr=" + this.ptrr + ", " +
				"typeOfPTRRTechnique=" + this.typeOfPTRRTechnique + ", " +
				"ptrrServiceProvider=" + this.ptrrServiceProvider + ", " +
				"venueOfExecution=" + this.venueOfExecution + ", " +
				"forwardExchangeRate=" + this.forwardExchangeRate + ", " +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"loadType=" + this.loadType + ", " +
				"deliveryReport=" + this.deliveryReport + ", " +
				"tranche=" + this.tranche + ", " +
				"eventDate=" + this.eventDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EMIRTransactionReport  ***********************/
	class EMIRTransactionReportBuilderImpl extends CommonTransactionReport.CommonTransactionReportBuilderImpl implements EMIRTransactionReport.EMIRTransactionReportBuilder {
	
		protected CommonContractType contractType;
		protected CommonAssetClass assetClass;
		protected ClearedEnum cleared;
		protected MasterAgreementEnum masterAgreementType;
		protected ZonedDateTime executionTimestamp;
		protected Date effectiveDate;
		protected DeliveryTypeEnum deliveryType;
		protected String otherMasterAgreementType;
		protected String collateralPortfolioCode;
		protected String ptrrId;
		protected Boolean clearingThresholdOfCounterparty1;
		protected Boolean clearingThresholdOfCounterparty2;
		protected Boolean reportingObligationOfTheCounterparty2;
		protected Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing;
		protected String reportTrackingNumber;
		protected String isin;
		protected String productClassification;
		protected List<IndexEnum> indicatorOfTheUnderlyingIndex = new ArrayList<>();
		protected ClearingObligationEnum clearingObligation;
		protected Boolean ptrr;
		protected RiskReductionTechniqueEnum typeOfPTRRTechnique;
		protected String ptrrServiceProvider;
		protected String venueOfExecution;
		protected BigDecimal forwardExchangeRate;
		protected List<String> deliveryPoint = new ArrayList<>();
		protected String interconnectionPoint;
		protected EnergyLoadType1Code loadType;
		protected List<ReportableDelivery.ReportableDeliveryBuilder> deliveryReport = new ArrayList<>();
		protected Boolean tranche;
		protected Date eventDate;
		
		@Override
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractType")
		public CommonContractType getContractType() {
			return contractType;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("assetClass")
		public CommonAssetClass getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("masterAgreementType")
		public MasterAgreementEnum getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		public ZonedDateTime getExecutionTimestamp() {
			return executionTimestamp;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("otherMasterAgreementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherMasterAgreementType")
		public String getOtherMasterAgreementType() {
			return otherMasterAgreementType;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioCode")
		public String getCollateralPortfolioCode() {
			return collateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("ptrrId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptrrId")
		public String getPtrrId() {
			return ptrrId;
		}
		
		@Override
		@RosettaAttribute("clearingThresholdOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingThresholdOfCounterparty1")
		public Boolean getClearingThresholdOfCounterparty1() {
			return clearingThresholdOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("clearingThresholdOfCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingThresholdOfCounterparty2")
		public Boolean getClearingThresholdOfCounterparty2() {
			return clearingThresholdOfCounterparty2;
		}
		
		@Override
		@RosettaAttribute("reportingObligationOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingObligationOfTheCounterparty2")
		public Boolean getReportingObligationOfTheCounterparty2() {
			return reportingObligationOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		public Boolean getDirectlyLinkedToCommercialActivityOrTreasuryFinancing() {
			return directlyLinkedToCommercialActivityOrTreasuryFinancing;
		}
		
		@Override
		@RosettaAttribute("reportTrackingNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportTrackingNumber")
		public String getReportTrackingNumber() {
			return reportTrackingNumber;
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("productClassification")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("productClassification")
		public String getProductClassification() {
			return productClassification;
		}
		
		@Override
		@RosettaAttribute("indicatorOfTheUnderlyingIndex")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("indicatorOfTheUnderlyingIndex")
		public List<IndexEnum> getIndicatorOfTheUnderlyingIndex() {
			return indicatorOfTheUnderlyingIndex;
		}
		
		@Override
		@RosettaAttribute("clearingObligation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingObligation")
		public ClearingObligationEnum getClearingObligation() {
			return clearingObligation;
		}
		
		@Override
		@RosettaAttribute("ptrr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptrr")
		public Boolean getPtrr() {
			return ptrr;
		}
		
		@Override
		@RosettaAttribute("typeOfPTRRTechnique")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("typeOfPTRRTechnique")
		public RiskReductionTechniqueEnum getTypeOfPTRRTechnique() {
			return typeOfPTRRTechnique;
		}
		
		@Override
		@RosettaAttribute("ptrrServiceProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptrrServiceProvider")
		public String getPtrrServiceProvider() {
			return ptrrServiceProvider;
		}
		
		@Override
		@RosettaAttribute("venueOfExecution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("venueOfExecution")
		public String getVenueOfExecution() {
			return venueOfExecution;
		}
		
		@Override
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardExchangeRate")
		public BigDecimal getForwardExchangeRate() {
			return forwardExchangeRate;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryPoint")
		public List<String> getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public String getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public EnergyLoadType1Code getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("deliveryReport")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryReport")
		public List<? extends ReportableDelivery.ReportableDeliveryBuilder> getDeliveryReport() {
			return deliveryReport;
		}
		
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder getOrCreateDeliveryReport(int index) {
			if (deliveryReport==null) {
				this.deliveryReport = new ArrayList<>();
			}
			return getIndex(deliveryReport, index, () -> {
						ReportableDelivery.ReportableDeliveryBuilder newDeliveryReport = ReportableDelivery.builder();
						return newDeliveryReport;
					});
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public Boolean getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEffectiveDate(Date _effectiveDate) {
			return setEffectiveDateOverriddenAsDate(_effectiveDate);
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			return setExecutionTimestampOverriddenAsZonedDateTime(_executionTimestamp);
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(CommonLeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(Leg _leg1) {
			final CommonLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CommonLeg ? CommonLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(LegV2 _leg1) {
			final CommonLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CommonLeg ? CommonLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg1(LegV1 _leg1) {
			final CommonLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof CommonLeg ? CommonLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(CommonLeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(Leg _leg2) {
			final CommonLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CommonLeg ? CommonLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(LegV2 _leg2) {
			final CommonLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CommonLeg ? CommonLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLeg2(LegV1 _leg2) {
			final CommonLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof CommonLeg ? CommonLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaAttribute("underlyingIdOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOther")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryTypeOverriddenAsDeliveryTypeEnum(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			return setDeliveryTypeOverriddenAsDeliveryTypeEnum(_deliveryType);
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("contractType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setContractTypeOverriddenAsCommonContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setContractType(CommonContractType _contractType) {
			return setContractTypeOverriddenAsCommonContractType(_contractType);
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("assetClass")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setAssetClassOverriddenAsCommonAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setAssetClass(CommonAssetClass _assetClass) {
			return setAssetClassOverriddenAsCommonAssetClass(_assetClass);
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("masterAgreementType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setMasterAgreementTypeOverriddenAsMasterAgreementEnum(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			return setMasterAgreementTypeOverriddenAsMasterAgreementEnum(_masterAgreementType);
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPackageIndicator(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketIndicator")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setNonReportable(NonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherMasterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherMasterAgreementType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setOtherMasterAgreementType(String _otherMasterAgreementType) {
			this.otherMasterAgreementType = _otherMasterAgreementType == null ? null : _otherMasterAgreementType;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("ptrrId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptrrId")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPtrrId(String _ptrrId) {
			this.ptrrId = _ptrrId == null ? null : _ptrrId;
			return this;
		}
		
		@RosettaAttribute("clearingThresholdOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingThresholdOfCounterparty1")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingThresholdOfCounterparty1(Boolean _clearingThresholdOfCounterparty1) {
			this.clearingThresholdOfCounterparty1 = _clearingThresholdOfCounterparty1 == null ? null : _clearingThresholdOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("clearingThresholdOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingThresholdOfCounterparty2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingThresholdOfCounterparty2(Boolean _clearingThresholdOfCounterparty2) {
			this.clearingThresholdOfCounterparty2 = _clearingThresholdOfCounterparty2 == null ? null : _clearingThresholdOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("reportingObligationOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingObligationOfTheCounterparty2")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setReportingObligationOfTheCounterparty2(Boolean _reportingObligationOfTheCounterparty2) {
			this.reportingObligationOfTheCounterparty2 = _reportingObligationOfTheCounterparty2 == null ? null : _reportingObligationOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDirectlyLinkedToCommercialActivityOrTreasuryFinancing(Boolean _directlyLinkedToCommercialActivityOrTreasuryFinancing) {
			this.directlyLinkedToCommercialActivityOrTreasuryFinancing = _directlyLinkedToCommercialActivityOrTreasuryFinancing == null ? null : _directlyLinkedToCommercialActivityOrTreasuryFinancing;
			return this;
		}
		
		@RosettaAttribute("reportTrackingNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportTrackingNumber")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setReportTrackingNumber(String _reportTrackingNumber) {
			this.reportTrackingNumber = _reportTrackingNumber == null ? null : _reportTrackingNumber;
			return this;
		}
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isin")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@RosettaAttribute("productClassification")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("productClassification")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setProductClassification(String _productClassification) {
			this.productClassification = _productClassification == null ? null : _productClassification;
			return this;
		}
		
		@RosettaAttribute("indicatorOfTheUnderlyingIndex")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("indicatorOfTheUnderlyingIndex")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum _indicatorOfTheUnderlyingIndex) {
			if (_indicatorOfTheUnderlyingIndex != null) {
				this.indicatorOfTheUnderlyingIndex.add(_indicatorOfTheUnderlyingIndex);
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum _indicatorOfTheUnderlyingIndex, int idx) {
			getIndex(this.indicatorOfTheUnderlyingIndex, idx, () -> _indicatorOfTheUnderlyingIndex);
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndexs) {
			if (indicatorOfTheUnderlyingIndexs != null) {
				for (final IndexEnum toAdd : indicatorOfTheUnderlyingIndexs) {
					this.indicatorOfTheUnderlyingIndex.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("indicatorOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("indicatorOfTheUnderlyingIndex")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndexs) {
			if (indicatorOfTheUnderlyingIndexs == null) {
				this.indicatorOfTheUnderlyingIndex = new ArrayList<>();
			} else {
				this.indicatorOfTheUnderlyingIndex = indicatorOfTheUnderlyingIndexs.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingObligation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingObligation")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setClearingObligation(ClearingObligationEnum _clearingObligation) {
			this.clearingObligation = _clearingObligation == null ? null : _clearingObligation;
			return this;
		}
		
		@RosettaAttribute("ptrr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptrr")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPtrr(Boolean _ptrr) {
			this.ptrr = _ptrr == null ? null : _ptrr;
			return this;
		}
		
		@RosettaAttribute("typeOfPTRRTechnique")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("typeOfPTRRTechnique")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setTypeOfPTRRTechnique(RiskReductionTechniqueEnum _typeOfPTRRTechnique) {
			this.typeOfPTRRTechnique = _typeOfPTRRTechnique == null ? null : _typeOfPTRRTechnique;
			return this;
		}
		
		@RosettaAttribute("ptrrServiceProvider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptrrServiceProvider")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setPtrrServiceProvider(String _ptrrServiceProvider) {
			this.ptrrServiceProvider = _ptrrServiceProvider == null ? null : _ptrrServiceProvider;
			return this;
		}
		
		@RosettaAttribute("venueOfExecution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("venueOfExecution")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setVenueOfExecution(String _venueOfExecution) {
			this.venueOfExecution = _venueOfExecution == null ? null : _venueOfExecution;
			return this;
		}
		
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardExchangeRate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setForwardExchangeRate(BigDecimal _forwardExchangeRate) {
			this.forwardExchangeRate = _forwardExchangeRate == null ? null : _forwardExchangeRate;
			return this;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryPoint")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryPoint(String _deliveryPoint) {
			if (_deliveryPoint != null) {
				this.deliveryPoint.add(_deliveryPoint);
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryPoint(String _deliveryPoint, int idx) {
			getIndex(this.deliveryPoint, idx, () -> _deliveryPoint);
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryPoint(List<String> deliveryPoints) {
			if (deliveryPoints != null) {
				for (final String toAdd : deliveryPoints) {
					this.deliveryPoint.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("deliveryPoint")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryPoint(List<String> deliveryPoints) {
			if (deliveryPoints == null) {
				this.deliveryPoint = new ArrayList<>();
			} else {
				this.deliveryPoint = deliveryPoints.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interconnectionPoint")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setInterconnectionPoint(String _interconnectionPoint) {
			this.interconnectionPoint = _interconnectionPoint == null ? null : _interconnectionPoint;
			return this;
		}
		
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loadType")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setLoadType(EnergyLoadType1Code _loadType) {
			this.loadType = _loadType == null ? null : _loadType;
			return this;
		}
		
		@RosettaAttribute("deliveryReport")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryReport")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery _deliveryReport) {
			if (_deliveryReport != null) {
				this.deliveryReport.add(_deliveryReport.toBuilder());
			}
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery _deliveryReport, int idx) {
			getIndex(this.deliveryReport, idx, () -> _deliveryReport.toBuilder());
			return this;
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder addDeliveryReport(List<? extends ReportableDelivery> deliveryReports) {
			if (deliveryReports != null) {
				for (final ReportableDelivery toAdd : deliveryReports) {
					this.deliveryReport.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("deliveryReport")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("deliveryReport")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setDeliveryReport(List<? extends ReportableDelivery> deliveryReports) {
			if (deliveryReports == null) {
				this.deliveryReport = new ArrayList<>();
			} else {
				this.deliveryReport = deliveryReports.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tranche")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setTranche(Boolean _tranche) {
			this.tranche = _tranche == null ? null : _tranche;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventDate")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@Override
		public EMIRTransactionReport build() {
			return new EMIRTransactionReport.EMIRTransactionReportImpl(this);
		}
		
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder prune() {
			super.prune();
			deliveryReport = deliveryReport.stream().filter(b->b!=null).<ReportableDelivery.ReportableDeliveryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getContractType()!=null) return true;
			if (getAssetClass()!=null) return true;
			if (getCleared()!=null) return true;
			if (getMasterAgreementType()!=null) return true;
			if (getExecutionTimestamp()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getDeliveryType()!=null) return true;
			if (getOtherMasterAgreementType()!=null) return true;
			if (getCollateralPortfolioCode()!=null) return true;
			if (getPtrrId()!=null) return true;
			if (getClearingThresholdOfCounterparty1()!=null) return true;
			if (getClearingThresholdOfCounterparty2()!=null) return true;
			if (getReportingObligationOfTheCounterparty2()!=null) return true;
			if (getDirectlyLinkedToCommercialActivityOrTreasuryFinancing()!=null) return true;
			if (getReportTrackingNumber()!=null) return true;
			if (getIsin()!=null) return true;
			if (getProductClassification()!=null) return true;
			if (getIndicatorOfTheUnderlyingIndex()!=null && !getIndicatorOfTheUnderlyingIndex().isEmpty()) return true;
			if (getClearingObligation()!=null) return true;
			if (getPtrr()!=null) return true;
			if (getTypeOfPTRRTechnique()!=null) return true;
			if (getPtrrServiceProvider()!=null) return true;
			if (getVenueOfExecution()!=null) return true;
			if (getForwardExchangeRate()!=null) return true;
			if (getDeliveryPoint()!=null && !getDeliveryPoint().isEmpty()) return true;
			if (getInterconnectionPoint()!=null) return true;
			if (getLoadType()!=null) return true;
			if (getDeliveryReport()!=null && getDeliveryReport().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTranche()!=null) return true;
			if (getEventDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EMIRTransactionReport.EMIRTransactionReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EMIRTransactionReport.EMIRTransactionReportBuilder o = (EMIRTransactionReport.EMIRTransactionReportBuilder) other;
			
			merger.mergeRosetta(getDeliveryReport(), o.getDeliveryReport(), this::getOrCreateDeliveryReport);
			
			merger.mergeBasic(getContractType(), o.getContractType(), this::setContractTypeOverriddenAsCommonContractType);
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClassOverriddenAsCommonAssetClass);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setClearedOverriddenAsClearedEnum);
			merger.mergeBasic(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementTypeOverriddenAsMasterAgreementEnum);
			merger.mergeBasic(getExecutionTimestamp(), o.getExecutionTimestamp(), this::setExecutionTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDateOverriddenAsDate);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryTypeOverriddenAsDeliveryTypeEnum);
			merger.mergeBasic(getOtherMasterAgreementType(), o.getOtherMasterAgreementType(), this::setOtherMasterAgreementType);
			merger.mergeBasic(getCollateralPortfolioCode(), o.getCollateralPortfolioCode(), this::setCollateralPortfolioCode);
			merger.mergeBasic(getPtrrId(), o.getPtrrId(), this::setPtrrId);
			merger.mergeBasic(getClearingThresholdOfCounterparty1(), o.getClearingThresholdOfCounterparty1(), this::setClearingThresholdOfCounterparty1);
			merger.mergeBasic(getClearingThresholdOfCounterparty2(), o.getClearingThresholdOfCounterparty2(), this::setClearingThresholdOfCounterparty2);
			merger.mergeBasic(getReportingObligationOfTheCounterparty2(), o.getReportingObligationOfTheCounterparty2(), this::setReportingObligationOfTheCounterparty2);
			merger.mergeBasic(getDirectlyLinkedToCommercialActivityOrTreasuryFinancing(), o.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing(), this::setDirectlyLinkedToCommercialActivityOrTreasuryFinancing);
			merger.mergeBasic(getReportTrackingNumber(), o.getReportTrackingNumber(), this::setReportTrackingNumber);
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			merger.mergeBasic(getProductClassification(), o.getProductClassification(), this::setProductClassification);
			merger.mergeBasic(getIndicatorOfTheUnderlyingIndex(), o.getIndicatorOfTheUnderlyingIndex(), (Consumer<IndexEnum>) this::addIndicatorOfTheUnderlyingIndex);
			merger.mergeBasic(getClearingObligation(), o.getClearingObligation(), this::setClearingObligation);
			merger.mergeBasic(getPtrr(), o.getPtrr(), this::setPtrr);
			merger.mergeBasic(getTypeOfPTRRTechnique(), o.getTypeOfPTRRTechnique(), this::setTypeOfPTRRTechnique);
			merger.mergeBasic(getPtrrServiceProvider(), o.getPtrrServiceProvider(), this::setPtrrServiceProvider);
			merger.mergeBasic(getVenueOfExecution(), o.getVenueOfExecution(), this::setVenueOfExecution);
			merger.mergeBasic(getForwardExchangeRate(), o.getForwardExchangeRate(), this::setForwardExchangeRate);
			merger.mergeBasic(getDeliveryPoint(), o.getDeliveryPoint(), (Consumer<String>) this::addDeliveryPoint);
			merger.mergeBasic(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			merger.mergeBasic(getLoadType(), o.getLoadType(), this::setLoadType);
			merger.mergeBasic(getTranche(), o.getTranche(), this::setTranche);
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EMIRTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(contractType, _that.getContractType())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(otherMasterAgreementType, _that.getOtherMasterAgreementType())) return false;
			if (!Objects.equals(collateralPortfolioCode, _that.getCollateralPortfolioCode())) return false;
			if (!Objects.equals(ptrrId, _that.getPtrrId())) return false;
			if (!Objects.equals(clearingThresholdOfCounterparty1, _that.getClearingThresholdOfCounterparty1())) return false;
			if (!Objects.equals(clearingThresholdOfCounterparty2, _that.getClearingThresholdOfCounterparty2())) return false;
			if (!Objects.equals(reportingObligationOfTheCounterparty2, _that.getReportingObligationOfTheCounterparty2())) return false;
			if (!Objects.equals(directlyLinkedToCommercialActivityOrTreasuryFinancing, _that.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing())) return false;
			if (!Objects.equals(reportTrackingNumber, _that.getReportTrackingNumber())) return false;
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(productClassification, _that.getProductClassification())) return false;
			if (!ListEquals.listEquals(indicatorOfTheUnderlyingIndex, _that.getIndicatorOfTheUnderlyingIndex())) return false;
			if (!Objects.equals(clearingObligation, _that.getClearingObligation())) return false;
			if (!Objects.equals(ptrr, _that.getPtrr())) return false;
			if (!Objects.equals(typeOfPTRRTechnique, _that.getTypeOfPTRRTechnique())) return false;
			if (!Objects.equals(ptrrServiceProvider, _that.getPtrrServiceProvider())) return false;
			if (!Objects.equals(venueOfExecution, _that.getVenueOfExecution())) return false;
			if (!Objects.equals(forwardExchangeRate, _that.getForwardExchangeRate())) return false;
			if (!ListEquals.listEquals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!ListEquals.listEquals(deliveryReport, _that.getDeliveryReport())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (contractType != null ? contractType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherMasterAgreementType != null ? otherMasterAgreementType.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioCode != null ? collateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (ptrrId != null ? ptrrId.hashCode() : 0);
			_result = 31 * _result + (clearingThresholdOfCounterparty1 != null ? clearingThresholdOfCounterparty1.hashCode() : 0);
			_result = 31 * _result + (clearingThresholdOfCounterparty2 != null ? clearingThresholdOfCounterparty2.hashCode() : 0);
			_result = 31 * _result + (reportingObligationOfTheCounterparty2 != null ? reportingObligationOfTheCounterparty2.hashCode() : 0);
			_result = 31 * _result + (directlyLinkedToCommercialActivityOrTreasuryFinancing != null ? directlyLinkedToCommercialActivityOrTreasuryFinancing.hashCode() : 0);
			_result = 31 * _result + (reportTrackingNumber != null ? reportTrackingNumber.hashCode() : 0);
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (productClassification != null ? productClassification.hashCode() : 0);
			_result = 31 * _result + (indicatorOfTheUnderlyingIndex != null ? indicatorOfTheUnderlyingIndex.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (clearingObligation != null ? clearingObligation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ptrr != null ? ptrr.hashCode() : 0);
			_result = 31 * _result + (typeOfPTRRTechnique != null ? typeOfPTRRTechnique.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ptrrServiceProvider != null ? ptrrServiceProvider.hashCode() : 0);
			_result = 31 * _result + (venueOfExecution != null ? venueOfExecution.hashCode() : 0);
			_result = 31 * _result + (forwardExchangeRate != null ? forwardExchangeRate.hashCode() : 0);
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryReport != null ? deliveryReport.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EMIRTransactionReportBuilder {" +
				"contractType=" + this.contractType + ", " +
				"assetClass=" + this.assetClass + ", " +
				"cleared=" + this.cleared + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"otherMasterAgreementType=" + this.otherMasterAgreementType + ", " +
				"collateralPortfolioCode=" + this.collateralPortfolioCode + ", " +
				"ptrrId=" + this.ptrrId + ", " +
				"clearingThresholdOfCounterparty1=" + this.clearingThresholdOfCounterparty1 + ", " +
				"clearingThresholdOfCounterparty2=" + this.clearingThresholdOfCounterparty2 + ", " +
				"reportingObligationOfTheCounterparty2=" + this.reportingObligationOfTheCounterparty2 + ", " +
				"directlyLinkedToCommercialActivityOrTreasuryFinancing=" + this.directlyLinkedToCommercialActivityOrTreasuryFinancing + ", " +
				"reportTrackingNumber=" + this.reportTrackingNumber + ", " +
				"isin=" + this.isin + ", " +
				"productClassification=" + this.productClassification + ", " +
				"indicatorOfTheUnderlyingIndex=" + this.indicatorOfTheUnderlyingIndex + ", " +
				"clearingObligation=" + this.clearingObligation + ", " +
				"ptrr=" + this.ptrr + ", " +
				"typeOfPTRRTechnique=" + this.typeOfPTRRTechnique + ", " +
				"ptrrServiceProvider=" + this.ptrrServiceProvider + ", " +
				"venueOfExecution=" + this.venueOfExecution + ", " +
				"forwardExchangeRate=" + this.forwardExchangeRate + ", " +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"loadType=" + this.loadType + ", " +
				"deliveryReport=" + this.deliveryReport + ", " +
				"tranche=" + this.tranche + ", " +
				"eventDate=" + this.eventDate +
			'}' + " " + super.toString();
		}
	}
}
