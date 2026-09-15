package drr.regulation.sec.rewrite.trade;

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
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.JurisdictionEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.meta.SECTransactionReportTradeMeta;
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
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="SECTransactionReportTrade", builder=SECTransactionReportTrade.SECTransactionReportTradeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="SECTransactionReportTrade", model="drr", builder=SECTransactionReportTrade.SECTransactionReportTradeBuilderImpl.class, version="7.7.0")
public interface SECTransactionReportTrade extends SECTransactionReport {

	SECTransactionReportTradeMeta metaData = new SECTransactionReportTradeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.g" * field "Clearing Swap USIs"
	 *
	 * Provision The unique swap identifiers (USI) of each clearing swap that replaces the original swap that was submitted for clearing to the derivatives clearing organization, other than the USI for the swap currently being reported (as 'USI' data element below).
	 *
	 */
	List<String> getClearingSwapUSIs();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.g" * field "Clearing Swap UTIs"
	 *
	 * Provision The unique transaction identifiers (UTI) of each clearing swap that replaces the original swap that was submitted for clearing to the derivatives clearing organization, other than the UTI for the swap currently being reported (as 'UTI' data element below).
	 *
	 */
	List<String> getClearingSwapUTIs();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.g" * field "Original Swap USI"
	 *
	 * Provision The unique swap identifier (USI) of the original swap submitted for clearing to the derivatives clearing organization that is replaced by clearing swaps.
	 *
	 */
	String getOriginalSwapUSI();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "902.c.7" * field "Allocation Indicator"
	 *
	 * Provision Indicator of whether the swap transaction is intended to be allocated, will not be allocated, or is a post allocation transaction.
	 *
	 */
	AllocationIndicatorEnum getAllocationIndicator();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * field "Jurisdiction"
	 *
	 * Provision The jurisdiction(s) that is requiring the reporting of the swap transaction.
	 *
	 */
	JurisdictionEnum getJurisdiction();

	/*********************** Build Methods  ***********************/
	SECTransactionReportTrade build();
	
	SECTransactionReportTrade.SECTransactionReportTradeBuilder toBuilder();
	
	static SECTransactionReportTrade.SECTransactionReportTradeBuilder builder() {
		return new SECTransactionReportTrade.SECTransactionReportTradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SECTransactionReportTrade> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SECTransactionReportTrade> getType() {
		return SECTransactionReportTrade.class;
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
		processRosetta(path.newSubPath("leg1"), processor, SECLeg.class, getLeg1());
		processRosetta(path.newSubPath("leg2"), processor, SECLeg.class, getLeg2());
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
		processor.processBasic(path.newSubPath("postPricedSwapIndicator"), Boolean.class, getPostPricedSwapIndicator(), this);
		processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
		processor.processBasic(path.newSubPath("counterparty1FinancialEntityIndicator"), Boolean.class, getCounterparty1FinancialEntityIndicator(), this);
		processor.processBasic(path.newSubPath("counterparty2FinancialEntityIndicator"), Boolean.class, getCounterparty2FinancialEntityIndicator(), this);
		processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.class, getDtccAdditionalFields());
		processor.processBasic(path.newSubPath("clearingSwapUSIs"), String.class, getClearingSwapUSIs(), this);
		processor.processBasic(path.newSubPath("clearingSwapUTIs"), String.class, getClearingSwapUTIs(), this);
		processor.processBasic(path.newSubPath("originalSwapUSI"), String.class, getOriginalSwapUSI(), this);
		processor.processBasic(path.newSubPath("allocationIndicator"), AllocationIndicatorEnum.class, getAllocationIndicator(), this);
		processor.processBasic(path.newSubPath("jurisdiction"), JurisdictionEnum.class, getJurisdiction(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SECTransactionReportTradeBuilder extends SECTransactionReportTrade, SECTransactionReport.SECTransactionReportBuilder {
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEffectiveDate(Date effectiveDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExpirationDate(Date expirationDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty1(String counterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2(String counterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBeneficiary1(String beneficiary1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCleared(ClearedEnum cleared);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingMember(String clearingMember);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCallAmount(BigDecimal callAmount);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPutAmount(BigDecimal putAmount);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setDelta(BigDecimal delta);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPrice(PriceFormat price);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriorUTI(String priorUTI);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setDirection1(Direction1Enum direction1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCustomBasketCode(String customBasketCode);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(LegV1 leg1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(LegV1 leg2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(LegV2 leg1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(LegV2 leg2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(Leg leg1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(Leg leg2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLevel(ReportLevelEnum level);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setActionType(ActionTypeEnum actionType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventType(EventTypeEnum eventType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventIdentifier(String eventIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(CommonLeg leg1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(CommonLeg leg2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBrokerID(String brokerID);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setContractType(CommonContractType contractType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionType(OptionTypeCode optionType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setIntragroup(Boolean intragroup);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSwapLinkID(String swapLinkID);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriorUSI(String priorUSI);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setReferenceEntity(String referenceEntity);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSeniority(SeniorityEnum seniority);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSeries(Integer series);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBaseProduct(String baseProduct);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setSubProduct(String subProduct);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setNonReportable(NonReportable nonReportable);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2OverriddenAsString(String counterparty2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(SECLeg leg1);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(SECLeg leg2);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCustomBasketIndicatorOverriddenAsBoolean(Boolean customBasketIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageIndicatorOverriddenAsBoolean(Boolean packageIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setEffectiveDateOverriddenAsDate(Date effectiveDate);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime executionTimestamp);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setPostPricedSwapIndicator(Boolean postPricedSwapIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueSwapIdentifier(String uniqueSwapIdentifier);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty1FinancialEntityIndicator(Boolean counterparty1FinancialEntityIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2FinancialEntityIndicator(Boolean counterparty2FinancialEntityIndicator);
		@Override
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setDtccAdditionalFields(DTCCAdditionalFields dtccAdditionalFields);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUSIs(String clearingSwapUSIs);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUSIs(String clearingSwapUSIs, int idx);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUSIs(List<String> clearingSwapUSIs);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingSwapUSIs(List<String> clearingSwapUSIs);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUTIs(String clearingSwapUTIs);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUTIs(String clearingSwapUTIs, int idx);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUTIs(List<String> clearingSwapUTIs);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingSwapUTIs(List<String> clearingSwapUTIs);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setOriginalSwapUSI(String originalSwapUSI);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setAllocationIndicator(AllocationIndicatorEnum allocationIndicator);
		SECTransactionReportTrade.SECTransactionReportTradeBuilder setJurisdiction(JurisdictionEnum jurisdiction);

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
			processRosetta(path.newSubPath("leg1"), processor, SECLeg.SECLegBuilder.class, getLeg1());
			processRosetta(path.newSubPath("leg2"), processor, SECLeg.SECLegBuilder.class, getLeg2());
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
			processor.processBasic(path.newSubPath("postPricedSwapIndicator"), Boolean.class, getPostPricedSwapIndicator(), this);
			processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
			processor.processBasic(path.newSubPath("counterparty1FinancialEntityIndicator"), Boolean.class, getCounterparty1FinancialEntityIndicator(), this);
			processor.processBasic(path.newSubPath("counterparty2FinancialEntityIndicator"), Boolean.class, getCounterparty2FinancialEntityIndicator(), this);
			processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.DTCCAdditionalFieldsBuilder.class, getDtccAdditionalFields());
			processor.processBasic(path.newSubPath("clearingSwapUSIs"), String.class, getClearingSwapUSIs(), this);
			processor.processBasic(path.newSubPath("clearingSwapUTIs"), String.class, getClearingSwapUTIs(), this);
			processor.processBasic(path.newSubPath("originalSwapUSI"), String.class, getOriginalSwapUSI(), this);
			processor.processBasic(path.newSubPath("allocationIndicator"), AllocationIndicatorEnum.class, getAllocationIndicator(), this);
			processor.processBasic(path.newSubPath("jurisdiction"), JurisdictionEnum.class, getJurisdiction(), this);
		}
		

		SECTransactionReportTrade.SECTransactionReportTradeBuilder prune();
	}

	/*********************** Immutable Implementation of SECTransactionReportTrade  ***********************/
	class SECTransactionReportTradeImpl extends SECTransactionReport.SECTransactionReportImpl implements SECTransactionReportTrade {
		private final List<String> clearingSwapUSIs;
		private final List<String> clearingSwapUTIs;
		private final String originalSwapUSI;
		private final AllocationIndicatorEnum allocationIndicator;
		private final JurisdictionEnum jurisdiction;
		
		protected SECTransactionReportTradeImpl(SECTransactionReportTrade.SECTransactionReportTradeBuilder builder) {
			super(builder);
			this.clearingSwapUSIs = ofNullable(builder.getClearingSwapUSIs()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.clearingSwapUTIs = ofNullable(builder.getClearingSwapUTIs()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.originalSwapUSI = builder.getOriginalSwapUSI();
			this.allocationIndicator = builder.getAllocationIndicator();
			this.jurisdiction = builder.getJurisdiction();
		}
		
		@Override
		@RosettaAttribute("clearingSwapUSIs")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUSIs")
		public List<String> getClearingSwapUSIs() {
			return clearingSwapUSIs;
		}
		
		@Override
		@RosettaAttribute("clearingSwapUTIs")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUTIs")
		public List<String> getClearingSwapUTIs() {
			return clearingSwapUTIs;
		}
		
		@Override
		@RosettaAttribute("originalSwapUSI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapUSI")
		public String getOriginalSwapUSI() {
			return originalSwapUSI;
		}
		
		@Override
		@RosettaAttribute("allocationIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocationIndicator")
		public AllocationIndicatorEnum getAllocationIndicator() {
			return allocationIndicator;
		}
		
		@Override
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("jurisdiction")
		public JurisdictionEnum getJurisdiction() {
			return jurisdiction;
		}
		
		@Override
		public SECTransactionReportTrade build() {
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder toBuilder() {
			SECTransactionReportTrade.SECTransactionReportTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SECTransactionReportTrade.SECTransactionReportTradeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getClearingSwapUSIs()).ifPresent(builder::setClearingSwapUSIs);
			ofNullable(getClearingSwapUTIs()).ifPresent(builder::setClearingSwapUTIs);
			ofNullable(getOriginalSwapUSI()).ifPresent(builder::setOriginalSwapUSI);
			ofNullable(getAllocationIndicator()).ifPresent(builder::setAllocationIndicator);
			ofNullable(getJurisdiction()).ifPresent(builder::setJurisdiction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SECTransactionReportTrade _that = getType().cast(o);
		
			if (!ListEquals.listEquals(clearingSwapUSIs, _that.getClearingSwapUSIs())) return false;
			if (!ListEquals.listEquals(clearingSwapUTIs, _that.getClearingSwapUTIs())) return false;
			if (!Objects.equals(originalSwapUSI, _that.getOriginalSwapUSI())) return false;
			if (!Objects.equals(allocationIndicator, _that.getAllocationIndicator())) return false;
			if (!Objects.equals(jurisdiction, _that.getJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingSwapUSIs != null ? clearingSwapUSIs.hashCode() : 0);
			_result = 31 * _result + (clearingSwapUTIs != null ? clearingSwapUTIs.hashCode() : 0);
			_result = 31 * _result + (originalSwapUSI != null ? originalSwapUSI.hashCode() : 0);
			_result = 31 * _result + (allocationIndicator != null ? allocationIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (jurisdiction != null ? jurisdiction.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECTransactionReportTrade {" +
				"clearingSwapUSIs=" + this.clearingSwapUSIs + ", " +
				"clearingSwapUTIs=" + this.clearingSwapUTIs + ", " +
				"originalSwapUSI=" + this.originalSwapUSI + ", " +
				"allocationIndicator=" + this.allocationIndicator + ", " +
				"jurisdiction=" + this.jurisdiction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SECTransactionReportTrade  ***********************/
	class SECTransactionReportTradeBuilderImpl extends SECTransactionReport.SECTransactionReportBuilderImpl implements SECTransactionReportTrade.SECTransactionReportTradeBuilder {
	
		protected List<String> clearingSwapUSIs = new ArrayList<>();
		protected List<String> clearingSwapUTIs = new ArrayList<>();
		protected String originalSwapUSI;
		protected AllocationIndicatorEnum allocationIndicator;
		protected JurisdictionEnum jurisdiction;
		
		@Override
		@RosettaAttribute("clearingSwapUSIs")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUSIs")
		public List<String> getClearingSwapUSIs() {
			return clearingSwapUSIs;
		}
		
		@Override
		@RosettaAttribute("clearingSwapUTIs")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUTIs")
		public List<String> getClearingSwapUTIs() {
			return clearingSwapUTIs;
		}
		
		@Override
		@RosettaAttribute("originalSwapUSI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapUSI")
		public String getOriginalSwapUSI() {
			return originalSwapUSI;
		}
		
		@Override
		@RosettaAttribute("allocationIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocationIndicator")
		public AllocationIndicatorEnum getAllocationIndicator() {
			return allocationIndicator;
		}
		
		@Override
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("jurisdiction")
		public JurisdictionEnum getJurisdiction() {
			return jurisdiction;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEffectiveDateOverriddenAsDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEffectiveDate(Date _effectiveDate) {
			return setEffectiveDateOverriddenAsDate(_effectiveDate);
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			return setExecutionTimestampOverriddenAsZonedDateTime(_executionTimestamp);
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2OverriddenAsString(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2(String _counterparty2) {
			return setCounterparty2OverriddenAsString(_counterparty2);
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(SECLeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(CommonLeg _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(Leg _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(LegV2 _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg1(LegV1 _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(SECLeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(CommonLeg _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(Leg _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(LegV2 _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLeg2(LegV1 _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaAttribute("underlyingIdOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOther")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			return setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(_counterparty2IdentifierSource);
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClass")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("packageIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageIndicatorOverriddenAsBoolean(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPackageIndicator(Boolean _packageIndicator) {
			return setPackageIndicatorOverriddenAsBoolean(_packageIndicator);
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCustomBasketIndicatorOverriddenAsBoolean(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			return setCustomBasketIndicatorOverriddenAsBoolean(_customBasketIndicator);
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setNonReportable(NonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setPostPricedSwapIndicator(Boolean _postPricedSwapIndicator) {
			this.postPricedSwapIndicator = _postPricedSwapIndicator == null ? null : _postPricedSwapIndicator;
			return this;
		}
		
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setUniqueSwapIdentifier(String _uniqueSwapIdentifier) {
			this.uniqueSwapIdentifier = _uniqueSwapIdentifier == null ? null : _uniqueSwapIdentifier;
			return this;
		}
		
		@RosettaAttribute("counterparty1FinancialEntityIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty1FinancialEntityIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty1FinancialEntityIndicator(Boolean _counterparty1FinancialEntityIndicator) {
			this.counterparty1FinancialEntityIndicator = _counterparty1FinancialEntityIndicator == null ? null : _counterparty1FinancialEntityIndicator;
			return this;
		}
		
		@RosettaAttribute("counterparty2FinancialEntityIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2FinancialEntityIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setCounterparty2FinancialEntityIndicator(Boolean _counterparty2FinancialEntityIndicator) {
			this.counterparty2FinancialEntityIndicator = _counterparty2FinancialEntityIndicator == null ? null : _counterparty2FinancialEntityIndicator;
			return this;
		}
		
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtccAdditionalFields")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setDtccAdditionalFields(DTCCAdditionalFields _dtccAdditionalFields) {
			this.dtccAdditionalFields = _dtccAdditionalFields == null ? null : _dtccAdditionalFields.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearingSwapUSIs")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingSwapUSIs")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUSIs(String _clearingSwapUSIs) {
			if (_clearingSwapUSIs != null) {
				this.clearingSwapUSIs.add(_clearingSwapUSIs);
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUSIs(String _clearingSwapUSIs, int idx) {
			getIndex(this.clearingSwapUSIs, idx, () -> _clearingSwapUSIs);
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUSIs(List<String> clearingSwapUSIss) {
			if (clearingSwapUSIss != null) {
				for (final String toAdd : clearingSwapUSIss) {
					this.clearingSwapUSIs.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUSIs")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingSwapUSIs")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingSwapUSIs(List<String> clearingSwapUSIss) {
			if (clearingSwapUSIss == null) {
				this.clearingSwapUSIs = new ArrayList<>();
			} else {
				this.clearingSwapUSIs = clearingSwapUSIss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUTIs")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingSwapUTIs")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUTIs(String _clearingSwapUTIs) {
			if (_clearingSwapUTIs != null) {
				this.clearingSwapUTIs.add(_clearingSwapUTIs);
			}
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUTIs(String _clearingSwapUTIs, int idx) {
			getIndex(this.clearingSwapUTIs, idx, () -> _clearingSwapUTIs);
			return this;
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder addClearingSwapUTIs(List<String> clearingSwapUTIss) {
			if (clearingSwapUTIss != null) {
				for (final String toAdd : clearingSwapUTIss) {
					this.clearingSwapUTIs.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUTIs")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingSwapUTIs")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setClearingSwapUTIs(List<String> clearingSwapUTIss) {
			if (clearingSwapUTIss == null) {
				this.clearingSwapUTIs = new ArrayList<>();
			} else {
				this.clearingSwapUTIs = clearingSwapUTIss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("originalSwapUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUSI")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setOriginalSwapUSI(String _originalSwapUSI) {
			this.originalSwapUSI = _originalSwapUSI == null ? null : _originalSwapUSI;
			return this;
		}
		
		@RosettaAttribute("allocationIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationIndicator")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setAllocationIndicator(AllocationIndicatorEnum _allocationIndicator) {
			this.allocationIndicator = _allocationIndicator == null ? null : _allocationIndicator;
			return this;
		}
		
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("jurisdiction")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder setJurisdiction(JurisdictionEnum _jurisdiction) {
			this.jurisdiction = _jurisdiction == null ? null : _jurisdiction;
			return this;
		}
		
		@Override
		public SECTransactionReportTrade build() {
			return new SECTransactionReportTrade.SECTransactionReportTradeImpl(this);
		}
		
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getClearingSwapUSIs()!=null && !getClearingSwapUSIs().isEmpty()) return true;
			if (getClearingSwapUTIs()!=null && !getClearingSwapUTIs().isEmpty()) return true;
			if (getOriginalSwapUSI()!=null) return true;
			if (getAllocationIndicator()!=null) return true;
			if (getJurisdiction()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECTransactionReportTrade.SECTransactionReportTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SECTransactionReportTrade.SECTransactionReportTradeBuilder o = (SECTransactionReportTrade.SECTransactionReportTradeBuilder) other;
			
			
			merger.mergeBasic(getClearingSwapUSIs(), o.getClearingSwapUSIs(), (Consumer<String>) this::addClearingSwapUSIs);
			merger.mergeBasic(getClearingSwapUTIs(), o.getClearingSwapUTIs(), (Consumer<String>) this::addClearingSwapUTIs);
			merger.mergeBasic(getOriginalSwapUSI(), o.getOriginalSwapUSI(), this::setOriginalSwapUSI);
			merger.mergeBasic(getAllocationIndicator(), o.getAllocationIndicator(), this::setAllocationIndicator);
			merger.mergeBasic(getJurisdiction(), o.getJurisdiction(), this::setJurisdiction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SECTransactionReportTrade _that = getType().cast(o);
		
			if (!ListEquals.listEquals(clearingSwapUSIs, _that.getClearingSwapUSIs())) return false;
			if (!ListEquals.listEquals(clearingSwapUTIs, _that.getClearingSwapUTIs())) return false;
			if (!Objects.equals(originalSwapUSI, _that.getOriginalSwapUSI())) return false;
			if (!Objects.equals(allocationIndicator, _that.getAllocationIndicator())) return false;
			if (!Objects.equals(jurisdiction, _that.getJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingSwapUSIs != null ? clearingSwapUSIs.hashCode() : 0);
			_result = 31 * _result + (clearingSwapUTIs != null ? clearingSwapUTIs.hashCode() : 0);
			_result = 31 * _result + (originalSwapUSI != null ? originalSwapUSI.hashCode() : 0);
			_result = 31 * _result + (allocationIndicator != null ? allocationIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (jurisdiction != null ? jurisdiction.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECTransactionReportTradeBuilder {" +
				"clearingSwapUSIs=" + this.clearingSwapUSIs + ", " +
				"clearingSwapUTIs=" + this.clearingSwapUTIs + ", " +
				"originalSwapUSI=" + this.originalSwapUSI + ", " +
				"allocationIndicator=" + this.allocationIndicator + ", " +
				"jurisdiction=" + this.jurisdiction +
			'}' + " " + super.toString();
		}
	}
}
