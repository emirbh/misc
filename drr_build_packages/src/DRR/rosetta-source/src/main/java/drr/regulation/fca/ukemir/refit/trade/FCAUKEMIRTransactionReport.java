package drr.regulation.fca.ukemir.refit.trade;

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
import drr.regulation.common.emir.EMIRTransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.fca.ukemir.refit.trade.meta.FCAUKEMIRTransactionReportMeta;
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
@RosettaDataType(value="FCAUKEMIRTransactionReport", builder=FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="FCAUKEMIRTransactionReport", model="drr", builder=FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilderImpl.class, version="7.7.0")
public interface FCAUKEMIRTransactionReport extends EMIRTransactionReport {

	FCAUKEMIRTransactionReportMeta metaData = new FCAUKEMIRTransactionReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Trade   
	 * table "1" * dataElement "5" * field "Nature of the Counterparty 1"
	 *
	 * Provision Indicate if the counterparty 1 is a CCP, a financial, non-financial counterparty or other type of counterparty as defined in points 1, 8 and 9 of Article 2 of Regulation (EU) No 648/2012 or an entity as referred to in accordance with point 5 of Article 1.
	 *
	 */
	@Override
	NatureOfCounterpartyEnum getNatureOfCounterparty1();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "8"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240606"
	 *
	 * Provision Peer Review agreed that a natural person involved as principal to a transaction can only appear as either the 'Buyer' or the 'Seller'. These roles are therefore used to identify natural persons acting in a private capacity. In such cases, Counterparty2IdentifierType must be set to False to indicate that the counterparty is not a legal entity with an LEI. For all other cases (legal entities with LEI), the value is set to True.
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 2 "Version 2 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 2) includes certain revisions and new data elements to the April 2018 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "8"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2.
	           - Allowable Values:
	               - True, for legal entities
	               - False, for natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240606"
	 *
	 * Provision Peer Review agreed that a natural person involved as principal to a transaction can only appear as either the 'Buyer' or the 'Seller'. These roles are therefore used to identify natural persons acting in a private capacity. In such cases, Counterparty2IdentifierType must be set to False to indicate that the counterparty is not a legal entity with an LEI. For all other cases (legal entities with LEI), the value is set to True.
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "8"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2
	           - Allowable Values:
	               - true, for legal entities
	               - false, for natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240606"
	 *
	 * Provision Peer Review agreed that a natural person involved as principal to a transaction can only appear as either the 'Buyer' or the 'Seller'. These roles are therefore used to identify natural persons acting in a private capacity. In such cases, Counterparty2IdentifierType must be set to False to indicate that the counterparty is not a legal entity with an LEI. For all other cases (legal entities with LEI), the value is set to True.
	 *
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Trade   
	 * table "1" * dataElement "8" * field "Counterparty 2 Identifier Type"
	 *
	 * Provision Indicator of whether LEI was used to identify counterparty 2.
	 *
	 */
	@Override
	Boolean getCounterparty2IdentifierType();
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Trade   
	 * table "2" * dataElement "12" * field "Derivative based on crypto-assets"
	 *
	 * Provision Indicator whether the derivative is based on crypto-assets.
	 *
	 */
	@Override
	Boolean getCryptoAssetUnderlyingIndicator();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "112"
	 *
	 * Provision Indication whether the report is done at trade or position level. Position level report can be used as a supplement to trade level reporting to report post trade events and if individual trades have been replaced by the position.
	 *
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Trade   
	 * table "2" * dataElement "154" * field "Level"
	 *
	 * Provision Indication whether the report is done at trade or position level. Position level report can be used only as a supplement to trade level reporting to report post- trade events and only if individual trades in fungible products have been replaced by the position.
	 *
	 */
	@Override
	ReportLevelEnum getLevel();
	@Override
	FCAUKEMIRNonReportable getNonReportable();

	/*********************** Build Methods  ***********************/
	FCAUKEMIRTransactionReport build();
	
	FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder toBuilder();
	
	static FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder builder() {
		return new FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FCAUKEMIRTransactionReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FCAUKEMIRTransactionReport> getType() {
		return FCAUKEMIRTransactionReport.class;
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
		processRosetta(path.newSubPath("nonReportable"), processor, FCAUKEMIRNonReportable.class, getNonReportable());
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
	interface FCAUKEMIRTransactionReportBuilder extends FCAUKEMIRTransactionReport, EMIRTransactionReport.EMIRTransactionReportBuilder {
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder getOrCreateNonReportable();
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder getNonReportable();
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEffectiveDate(Date effectiveDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExpirationDate(Date expirationDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty1(String counterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2(String counterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBeneficiary1(String beneficiary1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCleared(ClearedEnum cleared);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingMember(String clearingMember);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCallAmount(BigDecimal callAmount);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPutAmount(BigDecimal putAmount);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDelta(BigDecimal delta);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPrice(PriceFormat price);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriorUTI(String priorUTI);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDirection1(Direction1Enum direction1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCustomBasketCode(String customBasketCode);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(LegV1 leg1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(LegV1 leg2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(LegV2 leg1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(LegV2 leg2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(Leg leg1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(Leg leg2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLevel(ReportLevelEnum level);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventType(EventTypeEnum eventType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventIdentifier(String eventIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(CommonLeg leg1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(CommonLeg leg2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBrokerID(String brokerID);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setContractType(CommonContractType contractType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionType(OptionTypeCode optionType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIntragroup(Boolean intragroup);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSwapLinkID(String swapLinkID);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriorUSI(String priorUSI);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReferenceEntity(String referenceEntity);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSeniority(SeniorityEnum seniority);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSeries(Integer series);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBaseProduct(String baseProduct);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSubProduct(String subProduct);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNonReportable(NonReportable nonReportable);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setContractTypeOverriddenAsCommonContractType(CommonContractType contractType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setAssetClassOverriddenAsCommonAssetClass(CommonAssetClass assetClass);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMasterAgreementTypeOverriddenAsMasterAgreementEnum(MasterAgreementEnum masterAgreementType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime executionTimestamp);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date effectiveDate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryTypeOverriddenAsDeliveryTypeEnum(DeliveryTypeEnum deliveryType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOtherMasterAgreementType(String otherMasterAgreementType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPtrrId(String ptrrId);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingThresholdOfCounterparty1(Boolean clearingThresholdOfCounterparty1);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingThresholdOfCounterparty2(Boolean clearingThresholdOfCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportingObligationOfTheCounterparty2(Boolean reportingObligationOfTheCounterparty2);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDirectlyLinkedToCommercialActivityOrTreasuryFinancing(Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportTrackingNumber(String reportTrackingNumber);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIsin(String isin);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setProductClassification(String productClassification);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum indicatorOfTheUnderlyingIndex);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum indicatorOfTheUnderlyingIndex, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndex);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndex);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingObligation(ClearingObligationEnum clearingObligation);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPtrr(Boolean ptrr);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTypeOfPTRRTechnique(RiskReductionTechniqueEnum typeOfPTRRTechnique);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPtrrServiceProvider(String ptrrServiceProvider);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setVenueOfExecution(String venueOfExecution);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setForwardExchangeRate(BigDecimal forwardExchangeRate);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryPoint(String deliveryPoint);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryPoint(String deliveryPoint, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryPoint(List<String> deliveryPoint);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryPoint(List<String> deliveryPoint);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setInterconnectionPoint(String interconnectionPoint);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLoadType(EnergyLoadType1Code loadType);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery deliveryReport);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery deliveryReport, int idx);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryReport(List<? extends ReportableDelivery> deliveryReport);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryReport(List<? extends ReportableDelivery> deliveryReport);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTranche(Boolean tranche);
		@Override
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventDate(Date eventDate);
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNatureOfCounterparty1OverriddenAsNatureOfCounterpartyEnum(NatureOfCounterpartyEnum natureOfCounterparty1);
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCryptoAssetUnderlyingIndicatorOverriddenAsBoolean(Boolean cryptoAssetUnderlyingIndicator);
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLevelOverriddenAsReportLevelEnum(ReportLevelEnum level);
		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNonReportable(FCAUKEMIRNonReportable nonReportable);

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
			processRosetta(path.newSubPath("nonReportable"), processor, FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder.class, getNonReportable());
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
		

		FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder prune();
	}

	/*********************** Immutable Implementation of FCAUKEMIRTransactionReport  ***********************/
	class FCAUKEMIRTransactionReportImpl extends EMIRTransactionReport.EMIRTransactionReportImpl implements FCAUKEMIRTransactionReport {
		private final NatureOfCounterpartyEnum natureOfCounterparty1;
		private final Boolean counterparty2IdentifierType;
		private final Boolean cryptoAssetUnderlyingIndicator;
		private final ReportLevelEnum level;
		private final FCAUKEMIRNonReportable nonReportable;
		
		protected FCAUKEMIRTransactionReportImpl(FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder builder) {
			super(builder);
			this.natureOfCounterparty1 = builder.getNatureOfCounterparty1();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.cryptoAssetUnderlyingIndicator = builder.getCryptoAssetUnderlyingIndicator();
			this.level = builder.getLevel();
			this.nonReportable = ofNullable(builder.getNonReportable()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("natureOfCounterparty1")
		public NatureOfCounterpartyEnum getNatureOfCounterparty1() {
			return natureOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		public Boolean getCryptoAssetUnderlyingIndicator() {
			return cryptoAssetUnderlyingIndicator;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public FCAUKEMIRNonReportable getNonReportable() {
			return nonReportable;
		}
		
		@Override
		public FCAUKEMIRTransactionReport build() {
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder toBuilder() {
			FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNatureOfCounterparty1()).ifPresent(builder::setNatureOfCounterparty1OverriddenAsNatureOfCounterpartyEnum);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getCryptoAssetUnderlyingIndicator()).ifPresent(builder::setCryptoAssetUnderlyingIndicatorOverriddenAsBoolean);
			ofNullable(getLevel()).ifPresent(builder::setLevelOverriddenAsReportLevelEnum);
			ofNullable(getNonReportable()).ifPresent(builder::setNonReportable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAUKEMIRTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(natureOfCounterparty1, _that.getNatureOfCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(cryptoAssetUnderlyingIndicator, _that.getCryptoAssetUnderlyingIndicator())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (natureOfCounterparty1 != null ? natureOfCounterparty1.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (cryptoAssetUnderlyingIndicator != null ? cryptoAssetUnderlyingIndicator.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRTransactionReport {" +
				"natureOfCounterparty1=" + this.natureOfCounterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"cryptoAssetUnderlyingIndicator=" + this.cryptoAssetUnderlyingIndicator + ", " +
				"level=" + this.level + ", " +
				"nonReportable=" + this.nonReportable +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FCAUKEMIRTransactionReport  ***********************/
	class FCAUKEMIRTransactionReportBuilderImpl implements FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder {
	
		protected Date effectiveDate;
		protected Date earlyTerminationDate;
		protected ZonedDateTime reportingTimestamp;
		protected ZonedDateTime executionTimestamp;
		protected Date expirationDate;
		protected String counterparty1;
		protected String counterparty2;
		protected Boolean counterparty2IdentifierType;
		protected String beneficiary1;
		protected Boolean beneficiary1IdentifierTypeIndicator;
		protected String buyerIdentifier;
		protected String sellerIdentifier;
		protected ClearedEnum cleared;
		protected String centralCounterparty;
		protected String clearingMember;
		protected ConfirmationEnum confirmed;
		protected BigDecimal callAmount;
		protected BigDecimal putAmount;
		protected ISOCurrencyCodeEnum callCurrency;
		protected ISOCurrencyCodeEnum putCurrency;
		protected BigDecimal delta;
		protected List<PricePeriod.PricePeriodBuilder> priceSchedule = new ArrayList<>();
		protected List<PricePeriod.PricePeriodBuilder> strikePriceSchedule = new ArrayList<>();
		protected PriceFormat.PriceFormatBuilder price;
		protected PriceNotationEnum priceNotation;
		protected ISOCurrencyCodeEnum priceCurrency;
		protected PriceFormat.PriceFormatBuilder packageTransactionPrice;
		protected PriceNotationEnum packageTransactionPriceNotation;
		protected ISOCurrencyCodeEnum packageTransactionPriceCurrency;
		protected PriceFormat.PriceFormatBuilder packageTransactionSpread;
		protected PriceNotationEnum packageTransactionSpreadNotation;
		protected ISOCurrencyCodeEnum packageTransactionSpreadCurrency;
		protected String packageIdentifier;
		protected PriceFormat.PriceFormatBuilder strikePrice;
		protected PriceNotationEnum strikePriceNotation;
		protected String strikePriceCurrency;
		protected String priceUnitOfMeasure;
		protected BigDecimal optionPremiumAmount;
		protected ISOCurrencyCodeEnum optionPremiumCurrency;
		protected Date optionPremiumPaymentDate;
		protected BigDecimal exchangeRate;
		protected String exchangeRateBasis;
		protected BigDecimal cdSIndexAttachmentPoint;
		protected BigDecimal cdSIndexDetachmentPoint;
		protected Boolean collateralPortfolioIndicator;
		protected Date firstExerciseDate;
		protected Date finalContractualSettlementDate;
		protected ISOCountryCodeEnum settlementLocation;
		protected String priorUTI;
		protected Direction1Enum direction1;
		protected BigDecimal valuationAmount;
		protected ISOCurrencyCodeEnum valuationCurrency;
		protected ValuationType1Code valuationMethod;
		protected ZonedDateTime valuationTimestamp;
		protected String customBasketCode;
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> basketConstituents = new ArrayList<>();
		protected List<OtherPayment.OtherPaymentBuilder> otherPayment = new ArrayList<>();
		protected CommonLeg.CommonLegBuilder leg1;
		protected CommonLeg.CommonLegBuilder leg2;
		protected String underlyingIdOther;
		protected AssetIdTypeEnum underlyingIdOtherSource;
		protected String underlyingAssetTradingPlatformIdentifier;
		protected String underlyingAssetPriceSource;
		protected Boolean cryptoAssetUnderlyingIndicator;
		protected ReportLevelEnum level;
		protected ActionTypeEnum actionType;
		protected EventTypeEnum eventType;
		protected String eventIdentifier;
		protected ZonedDateTime eventTimestamp;
		protected ZonedDateTime confirmationTimestamp;
		protected String platformIdentifier;
		protected ISOCountryCodeEnum bookingLocation;
		protected ISOCountryCodeEnum traderLocation;
		protected DeliveryTypeEnum deliveryType;
		protected String executionAgentCounterparty1;
		protected String executionAgentCounterparty2;
		protected NatureOfCounterpartyEnum natureOfCounterparty1;
		protected NatureOfCounterpartyEnum natureOfCounterparty2;
		protected List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1 = new ArrayList<>();
		protected List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2 = new ArrayList<>();
		protected List<String> corporateSectorOfTheCounterparty1 = new ArrayList<>();
		protected List<String> corporateSectorOfTheCounterparty2 = new ArrayList<>();
		protected String counterparty2Name;
		protected String reportSubmittingEntityID;
		protected String entityResponsibleForReporting;
		protected ISOCountryCodeEnum countryOfTheCounterparty2;
		protected Counterparty2IdentifierEnum counterparty2IdentifierSource;
		protected TradingCapacity7Code tradingCapacity;
		protected String brokerID;
		protected CommonContractType contractType;
		protected CommonAssetClass assetClass;
		protected OptionTypeCode optionType;
		protected OptionStyleEnum optionStyle;
		protected EmbeddedOptionTypeEnum embeddedOptionType;
		protected MasterAgreementEnum masterAgreementType;
		protected Integer masterAgreementVersion;
		protected String secondaryTransactionIdentifier;
		protected Boolean intragroup;
		protected Boolean nonStandardizedTermIndicator;
		protected Boolean amendmentIndicator;
		protected String underlyingIdentification;
		protected UnderlyingIdentificationTypeEnum underlyingIdentificationType;
		protected String nameOfTheUnderlyingIndex;
		protected Date maturityDateOfTheUnderlying;
		protected String swapLinkID;
		protected Boolean packageIndicator;
		protected Boolean customBasketIndicator;
		protected String priorUTIProprietary;
		protected ZonedDateTime clearingTimestamp;
		protected ClearingAccountOriginEnum clearingAccountOrigin;
		protected ZonedDateTime clearingReceiptTimestamp;
		protected String uniqueTransactionIdentifier;
		protected String uniqueTransactionIdentifierProprietary;
		protected String uniqueProductIdentifier;
		protected String originalSwapUTI;
		protected String subsequentPositionUTI;
		protected String originalSwapSDRIdentifier;
		protected String priorUSI;
		protected String newSDRIdentifier;
		protected String technicalRecordId;
		protected String referenceEntity;
		protected SeniorityEnum seniority;
		protected Integer series;
		protected BigDecimal indexFactor;
		protected Integer seriesVersion;
		protected String baseProduct;
		protected String subProduct;
		protected String furtherSubProduct;
		protected SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder barrier;
		protected String initialMarginCollateralPortfolioCode;
		protected String variationMarginCollateralPortfolioCode;
		protected FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder nonReportable;
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
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationDate")
		public Date getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
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
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public Date getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary1")
		public String getBeneficiary1() {
			return beneficiary1;
		}
		
		@Override
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		public Boolean getBeneficiary1IdentifierTypeIndicator() {
			return beneficiary1IdentifierTypeIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIdentifier")
		public String getBuyerIdentifier() {
			return buyerIdentifier;
		}
		
		@Override
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIdentifier")
		public String getSellerIdentifier() {
			return sellerIdentifier;
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
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterparty")
		public String getCentralCounterparty() {
			return centralCounterparty;
		}
		
		@Override
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMember")
		public String getClearingMember() {
			return clearingMember;
		}
		
		@Override
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmed")
		public ConfirmationEnum getConfirmed() {
			return confirmed;
		}
		
		@Override
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmount")
		public BigDecimal getCallAmount() {
			return callAmount;
		}
		
		@Override
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmount")
		public BigDecimal getPutAmount() {
			return putAmount;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callCurrency")
		public ISOCurrencyCodeEnum getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putCurrency")
		public ISOCurrencyCodeEnum getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		@RosettaAttribute("delta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delta")
		public BigDecimal getDelta() {
			return delta;
		}
		
		@Override
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceSchedule")
		public List<? extends PricePeriod.PricePeriodBuilder> getPriceSchedule() {
			return priceSchedule;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder getOrCreatePriceSchedule(int index) {
			if (priceSchedule==null) {
				this.priceSchedule = new ArrayList<>();
			}
			return getIndex(priceSchedule, index, () -> {
						PricePeriod.PricePeriodBuilder newPriceSchedule = PricePeriod.builder();
						return newPriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		public List<? extends PricePeriod.PricePeriodBuilder> getStrikePriceSchedule() {
			return strikePriceSchedule;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder getOrCreateStrikePriceSchedule(int index) {
			if (strikePriceSchedule==null) {
				this.strikePriceSchedule = new ArrayList<>();
			}
			return getIndex(strikePriceSchedule, index, () -> {
						PricePeriod.PricePeriodBuilder newStrikePriceSchedule = PricePeriod.builder();
						return newStrikePriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public PriceFormat.PriceFormatBuilder getPrice() {
			return price;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceNotation")
		public PriceNotationEnum getPriceNotation() {
			return priceNotation;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceCurrency")
		public ISOCurrencyCodeEnum getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPrice")
		public PriceFormat.PriceFormatBuilder getPackageTransactionPrice() {
			return packageTransactionPrice;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionPrice() {
			PriceFormat.PriceFormatBuilder result;
			if (packageTransactionPrice!=null) {
				result = packageTransactionPrice;
			}
			else {
				result = packageTransactionPrice = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		public PriceNotationEnum getPackageTransactionPriceNotation() {
			return packageTransactionPriceNotation;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		public ISOCurrencyCodeEnum getPackageTransactionPriceCurrency() {
			return packageTransactionPriceCurrency;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpread")
		public PriceFormat.PriceFormatBuilder getPackageTransactionSpread() {
			return packageTransactionSpread;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionSpread() {
			PriceFormat.PriceFormatBuilder result;
			if (packageTransactionSpread!=null) {
				result = packageTransactionSpread;
			}
			else {
				result = packageTransactionSpread = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		public PriceNotationEnum getPackageTransactionSpreadNotation() {
			return packageTransactionSpreadNotation;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		public ISOCurrencyCodeEnum getPackageTransactionSpreadCurrency() {
			return packageTransactionSpreadCurrency;
		}
		
		@Override
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIdentifier")
		public String getPackageIdentifier() {
			return packageIdentifier;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public PriceFormat.PriceFormatBuilder getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreateStrikePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (strikePrice!=null) {
				result = strikePrice;
			}
			else {
				result = strikePrice = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceNotation")
		public PriceNotationEnum getStrikePriceNotation() {
			return strikePriceNotation;
		}
		
		@Override
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceCurrency")
		public String getStrikePriceCurrency() {
			return strikePriceCurrency;
		}
		
		@Override
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceUnitOfMeasure")
		public String getPriceUnitOfMeasure() {
			return priceUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumAmount")
		public BigDecimal getOptionPremiumAmount() {
			return optionPremiumAmount;
		}
		
		@Override
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumCurrency")
		public ISOCurrencyCodeEnum getOptionPremiumCurrency() {
			return optionPremiumCurrency;
		}
		
		@Override
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		public Date getOptionPremiumPaymentDate() {
			return optionPremiumPaymentDate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public BigDecimal getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRateBasis")
		public String getExchangeRateBasis() {
			return exchangeRateBasis;
		}
		
		@Override
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		public BigDecimal getCdSIndexAttachmentPoint() {
			return cdSIndexAttachmentPoint;
		}
		
		@Override
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		public BigDecimal getCdSIndexDetachmentPoint() {
			return cdSIndexDetachmentPoint;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		public Boolean getCollateralPortfolioIndicator() {
			return collateralPortfolioIndicator;
		}
		
		@Override
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstExerciseDate")
		public Date getFirstExerciseDate() {
			return firstExerciseDate;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public Date getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public ISOCountryCodeEnum getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTI")
		public String getPriorUTI() {
			return priorUTI;
		}
		
		@Override
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction1")
		public Direction1Enum getDirection1() {
			return direction1;
		}
		
		@Override
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAmount")
		public BigDecimal getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationCurrency")
		public ISOCurrencyCodeEnum getValuationCurrency() {
			return valuationCurrency;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationMethod")
		public ValuationType1Code getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTimestamp")
		public ZonedDateTime getValuationTimestamp() {
			return valuationTimestamp;
		}
		
		@Override
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasketCode")
		public String getCustomBasketCode() {
			return customBasketCode;
		}
		
		@Override
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituents")
		public List<? extends BasketConstituentsReport.BasketConstituentsReportBuilder> getBasketConstituents() {
			return basketConstituents;
		}
		
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder getOrCreateBasketConstituents(int index) {
			if (basketConstituents==null) {
				this.basketConstituents = new ArrayList<>();
			}
			return getIndex(basketConstituents, index, () -> {
						BasketConstituentsReport.BasketConstituentsReportBuilder newBasketConstituents = BasketConstituentsReport.builder();
						return newBasketConstituents;
					});
		}
		
		@Override
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPayment")
		public List<? extends OtherPayment.OtherPaymentBuilder> getOtherPayment() {
			return otherPayment;
		}
		
		@Override
		public OtherPayment.OtherPaymentBuilder getOrCreateOtherPayment(int index) {
			if (otherPayment==null) {
				this.otherPayment = new ArrayList<>();
			}
			return getIndex(otherPayment, index, () -> {
						OtherPayment.OtherPaymentBuilder newOtherPayment = OtherPayment.builder();
						return newOtherPayment;
					});
		}
		
		@Override
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1")
		public CommonLeg.CommonLegBuilder getLeg1() {
			return leg1;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder getOrCreateLeg1() {
			CommonLeg.CommonLegBuilder result;
			if (leg1!=null) {
				result = leg1;
			}
			else {
				result = leg1 = CommonLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public CommonLeg.CommonLegBuilder getLeg2() {
			return leg2;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder getOrCreateLeg2() {
			CommonLeg.CommonLegBuilder result;
			if (leg2!=null) {
				result = leg2;
			}
			else {
				result = leg2 = CommonLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingIdOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdOther")
		public String getUnderlyingIdOther() {
			return underlyingIdOther;
		}
		
		@Override
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdOtherSource")
		public AssetIdTypeEnum getUnderlyingIdOtherSource() {
			return underlyingIdOtherSource;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		public String getUnderlyingAssetTradingPlatformIdentifier() {
			return underlyingAssetTradingPlatformIdentifier;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		public String getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		public Boolean getCryptoAssetUnderlyingIndicator() {
			return cryptoAssetUnderlyingIndicator;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("actionType")
		public ActionTypeEnum getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventType")
		public EventTypeEnum getEventType() {
			return eventType;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public String getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationTimestamp")
		public ZonedDateTime getConfirmationTimestamp() {
			return confirmationTimestamp;
		}
		
		@Override
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("platformIdentifier")
		public String getPlatformIdentifier() {
			return platformIdentifier;
		}
		
		@Override
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bookingLocation")
		public ISOCountryCodeEnum getBookingLocation() {
			return bookingLocation;
		}
		
		@Override
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("traderLocation")
		public ISOCountryCodeEnum getTraderLocation() {
			return traderLocation;
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
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentCounterparty1")
		public String getExecutionAgentCounterparty1() {
			return executionAgentCounterparty1;
		}
		
		@Override
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentCounterparty2")
		public String getExecutionAgentCounterparty2() {
			return executionAgentCounterparty2;
		}
		
		@Override
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("natureOfCounterparty1")
		public NatureOfCounterpartyEnum getNatureOfCounterparty1() {
			return natureOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("natureOfCounterparty2")
		public NatureOfCounterpartyEnum getNatureOfCounterparty2() {
			return natureOfCounterparty2;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		public List<ClearingExceptionsAndExemptionsEnum> getClearingExceptionsAndExemptionsCounterparty1() {
			return clearingExceptionsAndExemptionsCounterparty1;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty2")
		public List<ClearingExceptionsAndExemptionsEnum> getClearingExceptionsAndExemptionsCounterparty2() {
			return clearingExceptionsAndExemptionsCounterparty2;
		}
		
		@Override
		@RosettaAttribute("corporateSectorOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty1")
		public List<String> getCorporateSectorOfTheCounterparty1() {
			return corporateSectorOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("corporateSectorOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty2")
		public List<String> getCorporateSectorOfTheCounterparty2() {
			return corporateSectorOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2Name")
		public String getCounterparty2Name() {
			return counterparty2Name;
		}
		
		@Override
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		public ISOCountryCodeEnum getCountryOfTheCounterparty2() {
			return countryOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		public Counterparty2IdentifierEnum getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingCapacity")
		public TradingCapacity7Code getTradingCapacity() {
			return tradingCapacity;
		}
		
		@Override
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerID")
		public String getBrokerID() {
			return brokerID;
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
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionTypeCode getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionStyle")
		public OptionStyleEnum getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("embeddedOptionType")
		public EmbeddedOptionTypeEnum getEmbeddedOptionType() {
			return embeddedOptionType;
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
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementVersion")
		public Integer getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		public String getSecondaryTransactionIdentifier() {
			return secondaryTransactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intragroup")
		public Boolean getIntragroup() {
			return intragroup;
		}
		
		@Override
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		public Boolean getNonStandardizedTermIndicator() {
			return nonStandardizedTermIndicator;
		}
		
		@Override
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendmentIndicator")
		public Boolean getAmendmentIndicator() {
			return amendmentIndicator;
		}
		
		@Override
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdentification")
		public String getUnderlyingIdentification() {
			return underlyingIdentification;
		}
		
		@Override
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdentificationType")
		public UnderlyingIdentificationTypeEnum getUnderlyingIdentificationType() {
			return underlyingIdentificationType;
		}
		
		@Override
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		public String getNameOfTheUnderlyingIndex() {
			return nameOfTheUnderlyingIndex;
		}
		
		@Override
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		public Date getMaturityDateOfTheUnderlying() {
			return maturityDateOfTheUnderlying;
		}
		
		@Override
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swapLinkID")
		public String getSwapLinkID() {
			return swapLinkID;
		}
		
		@Override
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIndicator")
		public Boolean getPackageIndicator() {
			return packageIndicator;
		}
		
		@Override
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasketIndicator")
		public Boolean getCustomBasketIndicator() {
			return customBasketIndicator;
		}
		
		@Override
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTIProprietary")
		public String getPriorUTIProprietary() {
			return priorUTIProprietary;
		}
		
		@Override
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingTimestamp")
		public ZonedDateTime getClearingTimestamp() {
			return clearingTimestamp;
		}
		
		@Override
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingAccountOrigin")
		public ClearingAccountOriginEnum getClearingAccountOrigin() {
			return clearingAccountOrigin;
		}
		
		@Override
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		public ZonedDateTime getClearingReceiptTimestamp() {
			return clearingReceiptTimestamp;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		public String getUniqueTransactionIdentifier() {
			return uniqueTransactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		public String getUniqueTransactionIdentifierProprietary() {
			return uniqueTransactionIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueProductIdentifier")
		public String getUniqueProductIdentifier() {
			return uniqueProductIdentifier;
		}
		
		@Override
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapUTI")
		public String getOriginalSwapUTI() {
			return originalSwapUTI;
		}
		
		@Override
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subsequentPositionUTI")
		public String getSubsequentPositionUTI() {
			return subsequentPositionUTI;
		}
		
		@Override
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		public String getOriginalSwapSDRIdentifier() {
			return originalSwapSDRIdentifier;
		}
		
		@Override
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUSI")
		public String getPriorUSI() {
			return priorUSI;
		}
		
		@Override
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newSDRIdentifier")
		public String getNewSDRIdentifier() {
			return newSDRIdentifier;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public String getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public SeniorityEnum getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("series")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("series")
		public Integer getSeries() {
			return series;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seriesVersion")
		public Integer getSeriesVersion() {
			return seriesVersion;
		}
		
		@Override
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseProduct")
		public String getBaseProduct() {
			return baseProduct;
		}
		
		@Override
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subProduct")
		public String getSubProduct() {
			return subProduct;
		}
		
		@Override
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("furtherSubProduct")
		public String getFurtherSubProduct() {
			return furtherSubProduct;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder getOrCreateBarrier() {
			SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = SingleOrUpperAndLowerBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder getNonReportable() {
			return nonReportable;
		}
		
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder getOrCreateNonReportable() {
			FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder result;
			if (nonReportable!=null) {
				result = nonReportable;
			}
			else {
				result = nonReportable = FCAUKEMIRNonReportable.builder();
			}
			
			return result;
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEffectiveDate(Date _effectiveDate) {
			return setEffectiveDateOverriddenAsDate(_effectiveDate);
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			return setExecutionTimestampOverriddenAsZonedDateTime(_executionTimestamp);
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(CommonLeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(Leg _leg1) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(LegV2 _leg1) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg1(LegV1 _leg1) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(CommonLeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(Leg _leg2) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(LegV2 _leg2) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLeg2(LegV1 _leg2) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCryptoAssetUnderlyingIndicatorOverriddenAsBoolean(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			return setCryptoAssetUnderlyingIndicatorOverriddenAsBoolean(_cryptoAssetUnderlyingIndicator);
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("level")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLevelOverriddenAsReportLevelEnum(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLevel(ReportLevelEnum _level) {
			return setLevelOverriddenAsReportLevelEnum(_level);
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryTypeOverriddenAsDeliveryTypeEnum(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			return setDeliveryTypeOverriddenAsDeliveryTypeEnum(_deliveryType);
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNatureOfCounterparty1OverriddenAsNatureOfCounterpartyEnum(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			return setNatureOfCounterparty1OverriddenAsNatureOfCounterpartyEnum(_natureOfCounterparty1);
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("contractType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setContractTypeOverriddenAsCommonContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setContractType(CommonContractType _contractType) {
			return setContractTypeOverriddenAsCommonContractType(_contractType);
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("assetClass")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setAssetClassOverriddenAsCommonAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setAssetClass(CommonAssetClass _assetClass) {
			return setAssetClassOverriddenAsCommonAssetClass(_assetClass);
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("masterAgreementType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMasterAgreementTypeOverriddenAsMasterAgreementEnum(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			return setMasterAgreementTypeOverriddenAsMasterAgreementEnum(_masterAgreementType);
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPackageIndicator(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketIndicator")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNonReportable(FCAUKEMIRNonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setNonReportable(NonReportable _nonReportable) {
			final FCAUKEMIRNonReportable ifThenElseResult;
			if (_nonReportable == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _nonReportable instanceof FCAUKEMIRNonReportable ? FCAUKEMIRNonReportable.class.cast(_nonReportable) : null;
			}
			return setNonReportable(ifThenElseResult);
		}
		
		@RosettaAttribute("otherMasterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherMasterAgreementType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setOtherMasterAgreementType(String _otherMasterAgreementType) {
			this.otherMasterAgreementType = _otherMasterAgreementType == null ? null : _otherMasterAgreementType;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("ptrrId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptrrId")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPtrrId(String _ptrrId) {
			this.ptrrId = _ptrrId == null ? null : _ptrrId;
			return this;
		}
		
		@RosettaAttribute("clearingThresholdOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingThresholdOfCounterparty1")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingThresholdOfCounterparty1(Boolean _clearingThresholdOfCounterparty1) {
			this.clearingThresholdOfCounterparty1 = _clearingThresholdOfCounterparty1 == null ? null : _clearingThresholdOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("clearingThresholdOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingThresholdOfCounterparty2")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingThresholdOfCounterparty2(Boolean _clearingThresholdOfCounterparty2) {
			this.clearingThresholdOfCounterparty2 = _clearingThresholdOfCounterparty2 == null ? null : _clearingThresholdOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("reportingObligationOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingObligationOfTheCounterparty2")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportingObligationOfTheCounterparty2(Boolean _reportingObligationOfTheCounterparty2) {
			this.reportingObligationOfTheCounterparty2 = _reportingObligationOfTheCounterparty2 == null ? null : _reportingObligationOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("directlyLinkedToCommercialActivityOrTreasuryFinancing")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDirectlyLinkedToCommercialActivityOrTreasuryFinancing(Boolean _directlyLinkedToCommercialActivityOrTreasuryFinancing) {
			this.directlyLinkedToCommercialActivityOrTreasuryFinancing = _directlyLinkedToCommercialActivityOrTreasuryFinancing == null ? null : _directlyLinkedToCommercialActivityOrTreasuryFinancing;
			return this;
		}
		
		@RosettaAttribute("reportTrackingNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportTrackingNumber")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setReportTrackingNumber(String _reportTrackingNumber) {
			this.reportTrackingNumber = _reportTrackingNumber == null ? null : _reportTrackingNumber;
			return this;
		}
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isin")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@RosettaAttribute("productClassification")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("productClassification")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setProductClassification(String _productClassification) {
			this.productClassification = _productClassification == null ? null : _productClassification;
			return this;
		}
		
		@RosettaAttribute("indicatorOfTheUnderlyingIndex")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("indicatorOfTheUnderlyingIndex")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum _indicatorOfTheUnderlyingIndex) {
			if (_indicatorOfTheUnderlyingIndex != null) {
				this.indicatorOfTheUnderlyingIndex.add(_indicatorOfTheUnderlyingIndex);
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(IndexEnum _indicatorOfTheUnderlyingIndex, int idx) {
			getIndex(this.indicatorOfTheUnderlyingIndex, idx, () -> _indicatorOfTheUnderlyingIndex);
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndexs) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setIndicatorOfTheUnderlyingIndex(List<IndexEnum> indicatorOfTheUnderlyingIndexs) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setClearingObligation(ClearingObligationEnum _clearingObligation) {
			this.clearingObligation = _clearingObligation == null ? null : _clearingObligation;
			return this;
		}
		
		@RosettaAttribute("ptrr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptrr")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPtrr(Boolean _ptrr) {
			this.ptrr = _ptrr == null ? null : _ptrr;
			return this;
		}
		
		@RosettaAttribute("typeOfPTRRTechnique")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("typeOfPTRRTechnique")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTypeOfPTRRTechnique(RiskReductionTechniqueEnum _typeOfPTRRTechnique) {
			this.typeOfPTRRTechnique = _typeOfPTRRTechnique == null ? null : _typeOfPTRRTechnique;
			return this;
		}
		
		@RosettaAttribute("ptrrServiceProvider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptrrServiceProvider")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setPtrrServiceProvider(String _ptrrServiceProvider) {
			this.ptrrServiceProvider = _ptrrServiceProvider == null ? null : _ptrrServiceProvider;
			return this;
		}
		
		@RosettaAttribute("venueOfExecution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("venueOfExecution")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setVenueOfExecution(String _venueOfExecution) {
			this.venueOfExecution = _venueOfExecution == null ? null : _venueOfExecution;
			return this;
		}
		
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardExchangeRate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setForwardExchangeRate(BigDecimal _forwardExchangeRate) {
			this.forwardExchangeRate = _forwardExchangeRate == null ? null : _forwardExchangeRate;
			return this;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryPoint")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryPoint(String _deliveryPoint) {
			if (_deliveryPoint != null) {
				this.deliveryPoint.add(_deliveryPoint);
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryPoint(String _deliveryPoint, int idx) {
			getIndex(this.deliveryPoint, idx, () -> _deliveryPoint);
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryPoint(List<String> deliveryPoints) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryPoint(List<String> deliveryPoints) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setInterconnectionPoint(String _interconnectionPoint) {
			this.interconnectionPoint = _interconnectionPoint == null ? null : _interconnectionPoint;
			return this;
		}
		
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loadType")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setLoadType(EnergyLoadType1Code _loadType) {
			this.loadType = _loadType == null ? null : _loadType;
			return this;
		}
		
		@RosettaAttribute("deliveryReport")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryReport")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery _deliveryReport) {
			if (_deliveryReport != null) {
				this.deliveryReport.add(_deliveryReport.toBuilder());
			}
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryReport(ReportableDelivery _deliveryReport, int idx) {
			getIndex(this.deliveryReport, idx, () -> _deliveryReport.toBuilder());
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder addDeliveryReport(List<? extends ReportableDelivery> deliveryReports) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setDeliveryReport(List<? extends ReportableDelivery> deliveryReports) {
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setTranche(Boolean _tranche) {
			this.tranche = _tranche == null ? null : _tranche;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventDate")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@Override
		public FCAUKEMIRTransactionReport build() {
			return new FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportImpl(this);
		}
		
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder prune() {
			priceSchedule = priceSchedule.stream().filter(b->b!=null).<PricePeriod.PricePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			strikePriceSchedule = strikePriceSchedule.stream().filter(b->b!=null).<PricePeriod.PricePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (price!=null && !price.prune().hasData()) price = null;
			if (packageTransactionPrice!=null && !packageTransactionPrice.prune().hasData()) packageTransactionPrice = null;
			if (packageTransactionSpread!=null && !packageTransactionSpread.prune().hasData()) packageTransactionSpread = null;
			if (strikePrice!=null && !strikePrice.prune().hasData()) strikePrice = null;
			basketConstituents = basketConstituents.stream().filter(b->b!=null).<BasketConstituentsReport.BasketConstituentsReportBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			otherPayment = otherPayment.stream().filter(b->b!=null).<OtherPayment.OtherPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (leg1!=null && !leg1.prune().hasData()) leg1 = null;
			if (leg2!=null && !leg2.prune().hasData()) leg2 = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (nonReportable!=null && !nonReportable.prune().hasData()) nonReportable = null;
			deliveryReport = deliveryReport.stream().filter(b->b!=null).<ReportableDelivery.ReportableDeliveryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEarlyTerminationDate()!=null) return true;
			if (getReportingTimestamp()!=null) return true;
			if (getExecutionTimestamp()!=null) return true;
			if (getExpirationDate()!=null) return true;
			if (getCounterparty1()!=null) return true;
			if (getCounterparty2()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getBeneficiary1()!=null) return true;
			if (getBeneficiary1IdentifierTypeIndicator()!=null) return true;
			if (getBuyerIdentifier()!=null) return true;
			if (getSellerIdentifier()!=null) return true;
			if (getCleared()!=null) return true;
			if (getCentralCounterparty()!=null) return true;
			if (getClearingMember()!=null) return true;
			if (getConfirmed()!=null) return true;
			if (getCallAmount()!=null) return true;
			if (getPutAmount()!=null) return true;
			if (getCallCurrency()!=null) return true;
			if (getPutCurrency()!=null) return true;
			if (getDelta()!=null) return true;
			if (getPriceSchedule()!=null && getPriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStrikePriceSchedule()!=null && getStrikePriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getPriceNotation()!=null) return true;
			if (getPriceCurrency()!=null) return true;
			if (getPackageTransactionPrice()!=null && getPackageTransactionPrice().hasData()) return true;
			if (getPackageTransactionPriceNotation()!=null) return true;
			if (getPackageTransactionPriceCurrency()!=null) return true;
			if (getPackageTransactionSpread()!=null && getPackageTransactionSpread().hasData()) return true;
			if (getPackageTransactionSpreadNotation()!=null) return true;
			if (getPackageTransactionSpreadCurrency()!=null) return true;
			if (getPackageIdentifier()!=null) return true;
			if (getStrikePrice()!=null && getStrikePrice().hasData()) return true;
			if (getStrikePriceNotation()!=null) return true;
			if (getStrikePriceCurrency()!=null) return true;
			if (getPriceUnitOfMeasure()!=null) return true;
			if (getOptionPremiumAmount()!=null) return true;
			if (getOptionPremiumCurrency()!=null) return true;
			if (getOptionPremiumPaymentDate()!=null) return true;
			if (getExchangeRate()!=null) return true;
			if (getExchangeRateBasis()!=null) return true;
			if (getCdSIndexAttachmentPoint()!=null) return true;
			if (getCdSIndexDetachmentPoint()!=null) return true;
			if (getCollateralPortfolioIndicator()!=null) return true;
			if (getFirstExerciseDate()!=null) return true;
			if (getFinalContractualSettlementDate()!=null) return true;
			if (getSettlementLocation()!=null) return true;
			if (getPriorUTI()!=null) return true;
			if (getDirection1()!=null) return true;
			if (getValuationAmount()!=null) return true;
			if (getValuationCurrency()!=null) return true;
			if (getValuationMethod()!=null) return true;
			if (getValuationTimestamp()!=null) return true;
			if (getCustomBasketCode()!=null) return true;
			if (getBasketConstituents()!=null && getBasketConstituents().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOtherPayment()!=null && getOtherPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLeg1()!=null && getLeg1().hasData()) return true;
			if (getLeg2()!=null && getLeg2().hasData()) return true;
			if (getUnderlyingIdOther()!=null) return true;
			if (getUnderlyingIdOtherSource()!=null) return true;
			if (getUnderlyingAssetTradingPlatformIdentifier()!=null) return true;
			if (getUnderlyingAssetPriceSource()!=null) return true;
			if (getCryptoAssetUnderlyingIndicator()!=null) return true;
			if (getLevel()!=null) return true;
			if (getActionType()!=null) return true;
			if (getEventType()!=null) return true;
			if (getEventIdentifier()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getConfirmationTimestamp()!=null) return true;
			if (getPlatformIdentifier()!=null) return true;
			if (getBookingLocation()!=null) return true;
			if (getTraderLocation()!=null) return true;
			if (getDeliveryType()!=null) return true;
			if (getExecutionAgentCounterparty1()!=null) return true;
			if (getExecutionAgentCounterparty2()!=null) return true;
			if (getNatureOfCounterparty1()!=null) return true;
			if (getNatureOfCounterparty2()!=null) return true;
			if (getClearingExceptionsAndExemptionsCounterparty1()!=null && !getClearingExceptionsAndExemptionsCounterparty1().isEmpty()) return true;
			if (getClearingExceptionsAndExemptionsCounterparty2()!=null && !getClearingExceptionsAndExemptionsCounterparty2().isEmpty()) return true;
			if (getCorporateSectorOfTheCounterparty1()!=null && !getCorporateSectorOfTheCounterparty1().isEmpty()) return true;
			if (getCorporateSectorOfTheCounterparty2()!=null && !getCorporateSectorOfTheCounterparty2().isEmpty()) return true;
			if (getCounterparty2Name()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getCountryOfTheCounterparty2()!=null) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getTradingCapacity()!=null) return true;
			if (getBrokerID()!=null) return true;
			if (getContractType()!=null) return true;
			if (getAssetClass()!=null) return true;
			if (getOptionType()!=null) return true;
			if (getOptionStyle()!=null) return true;
			if (getEmbeddedOptionType()!=null) return true;
			if (getMasterAgreementType()!=null) return true;
			if (getMasterAgreementVersion()!=null) return true;
			if (getSecondaryTransactionIdentifier()!=null) return true;
			if (getIntragroup()!=null) return true;
			if (getNonStandardizedTermIndicator()!=null) return true;
			if (getAmendmentIndicator()!=null) return true;
			if (getUnderlyingIdentification()!=null) return true;
			if (getUnderlyingIdentificationType()!=null) return true;
			if (getNameOfTheUnderlyingIndex()!=null) return true;
			if (getMaturityDateOfTheUnderlying()!=null) return true;
			if (getSwapLinkID()!=null) return true;
			if (getPackageIndicator()!=null) return true;
			if (getCustomBasketIndicator()!=null) return true;
			if (getPriorUTIProprietary()!=null) return true;
			if (getClearingTimestamp()!=null) return true;
			if (getClearingAccountOrigin()!=null) return true;
			if (getClearingReceiptTimestamp()!=null) return true;
			if (getUniqueTransactionIdentifier()!=null) return true;
			if (getUniqueTransactionIdentifierProprietary()!=null) return true;
			if (getUniqueProductIdentifier()!=null) return true;
			if (getOriginalSwapUTI()!=null) return true;
			if (getSubsequentPositionUTI()!=null) return true;
			if (getOriginalSwapSDRIdentifier()!=null) return true;
			if (getPriorUSI()!=null) return true;
			if (getNewSDRIdentifier()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getReferenceEntity()!=null) return true;
			if (getSeniority()!=null) return true;
			if (getSeries()!=null) return true;
			if (getIndexFactor()!=null) return true;
			if (getSeriesVersion()!=null) return true;
			if (getBaseProduct()!=null) return true;
			if (getSubProduct()!=null) return true;
			if (getFurtherSubProduct()!=null) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getInitialMarginCollateralPortfolioCode()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getNonReportable()!=null && getNonReportable().hasData()) return true;
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
		public FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder o = (FCAUKEMIRTransactionReport.FCAUKEMIRTransactionReportBuilder) other;
			
			merger.mergeRosetta(getPriceSchedule(), o.getPriceSchedule(), this::getOrCreatePriceSchedule);
			merger.mergeRosetta(getStrikePriceSchedule(), o.getStrikePriceSchedule(), this::getOrCreateStrikePriceSchedule);
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeRosetta(getPackageTransactionPrice(), o.getPackageTransactionPrice(), this::setPackageTransactionPrice);
			merger.mergeRosetta(getPackageTransactionSpread(), o.getPackageTransactionSpread(), this::setPackageTransactionSpread);
			merger.mergeRosetta(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeRosetta(getBasketConstituents(), o.getBasketConstituents(), this::getOrCreateBasketConstituents);
			merger.mergeRosetta(getOtherPayment(), o.getOtherPayment(), this::getOrCreateOtherPayment);
			merger.mergeRosetta(getLeg1(), o.getLeg1(), this::setLeg1);
			merger.mergeRosetta(getLeg2(), o.getLeg2(), this::setLeg2);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getNonReportable(), o.getNonReportable(), this::setNonReportable);
			merger.mergeRosetta(getDeliveryReport(), o.getDeliveryReport(), this::getOrCreateDeliveryReport);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDateOverriddenAsDate);
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getExecutionTimestamp(), o.getExecutionTimestamp(), this::setExecutionTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getBeneficiary1(), o.getBeneficiary1(), this::setBeneficiary1);
			merger.mergeBasic(getBeneficiary1IdentifierTypeIndicator(), o.getBeneficiary1IdentifierTypeIndicator(), this::setBeneficiary1IdentifierTypeIndicator);
			merger.mergeBasic(getBuyerIdentifier(), o.getBuyerIdentifier(), this::setBuyerIdentifier);
			merger.mergeBasic(getSellerIdentifier(), o.getSellerIdentifier(), this::setSellerIdentifier);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setClearedOverriddenAsClearedEnum);
			merger.mergeBasic(getCentralCounterparty(), o.getCentralCounterparty(), this::setCentralCounterparty);
			merger.mergeBasic(getClearingMember(), o.getClearingMember(), this::setClearingMember);
			merger.mergeBasic(getConfirmed(), o.getConfirmed(), this::setConfirmed);
			merger.mergeBasic(getCallAmount(), o.getCallAmount(), this::setCallAmount);
			merger.mergeBasic(getPutAmount(), o.getPutAmount(), this::setPutAmount);
			merger.mergeBasic(getCallCurrency(), o.getCallCurrency(), this::setCallCurrency);
			merger.mergeBasic(getPutCurrency(), o.getPutCurrency(), this::setPutCurrency);
			merger.mergeBasic(getDelta(), o.getDelta(), this::setDelta);
			merger.mergeBasic(getPriceNotation(), o.getPriceNotation(), this::setPriceNotation);
			merger.mergeBasic(getPriceCurrency(), o.getPriceCurrency(), this::setPriceCurrency);
			merger.mergeBasic(getPackageTransactionPriceNotation(), o.getPackageTransactionPriceNotation(), this::setPackageTransactionPriceNotation);
			merger.mergeBasic(getPackageTransactionPriceCurrency(), o.getPackageTransactionPriceCurrency(), this::setPackageTransactionPriceCurrency);
			merger.mergeBasic(getPackageTransactionSpreadNotation(), o.getPackageTransactionSpreadNotation(), this::setPackageTransactionSpreadNotation);
			merger.mergeBasic(getPackageTransactionSpreadCurrency(), o.getPackageTransactionSpreadCurrency(), this::setPackageTransactionSpreadCurrency);
			merger.mergeBasic(getPackageIdentifier(), o.getPackageIdentifier(), this::setPackageIdentifier);
			merger.mergeBasic(getStrikePriceNotation(), o.getStrikePriceNotation(), this::setStrikePriceNotation);
			merger.mergeBasic(getStrikePriceCurrency(), o.getStrikePriceCurrency(), this::setStrikePriceCurrency);
			merger.mergeBasic(getPriceUnitOfMeasure(), o.getPriceUnitOfMeasure(), this::setPriceUnitOfMeasure);
			merger.mergeBasic(getOptionPremiumAmount(), o.getOptionPremiumAmount(), this::setOptionPremiumAmount);
			merger.mergeBasic(getOptionPremiumCurrency(), o.getOptionPremiumCurrency(), this::setOptionPremiumCurrency);
			merger.mergeBasic(getOptionPremiumPaymentDate(), o.getOptionPremiumPaymentDate(), this::setOptionPremiumPaymentDate);
			merger.mergeBasic(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeBasic(getExchangeRateBasis(), o.getExchangeRateBasis(), this::setExchangeRateBasis);
			merger.mergeBasic(getCdSIndexAttachmentPoint(), o.getCdSIndexAttachmentPoint(), this::setCdSIndexAttachmentPoint);
			merger.mergeBasic(getCdSIndexDetachmentPoint(), o.getCdSIndexDetachmentPoint(), this::setCdSIndexDetachmentPoint);
			merger.mergeBasic(getCollateralPortfolioIndicator(), o.getCollateralPortfolioIndicator(), this::setCollateralPortfolioIndicator);
			merger.mergeBasic(getFirstExerciseDate(), o.getFirstExerciseDate(), this::setFirstExerciseDate);
			merger.mergeBasic(getFinalContractualSettlementDate(), o.getFinalContractualSettlementDate(), this::setFinalContractualSettlementDate);
			merger.mergeBasic(getSettlementLocation(), o.getSettlementLocation(), this::setSettlementLocation);
			merger.mergeBasic(getPriorUTI(), o.getPriorUTI(), this::setPriorUTI);
			merger.mergeBasic(getDirection1(), o.getDirection1(), this::setDirection1);
			merger.mergeBasic(getValuationAmount(), o.getValuationAmount(), this::setValuationAmount);
			merger.mergeBasic(getValuationCurrency(), o.getValuationCurrency(), this::setValuationCurrency);
			merger.mergeBasic(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			merger.mergeBasic(getValuationTimestamp(), o.getValuationTimestamp(), this::setValuationTimestamp);
			merger.mergeBasic(getCustomBasketCode(), o.getCustomBasketCode(), this::setCustomBasketCode);
			merger.mergeBasic(getUnderlyingIdOther(), o.getUnderlyingIdOther(), this::setUnderlyingIdOther);
			merger.mergeBasic(getUnderlyingIdOtherSource(), o.getUnderlyingIdOtherSource(), this::setUnderlyingIdOtherSource);
			merger.mergeBasic(getUnderlyingAssetTradingPlatformIdentifier(), o.getUnderlyingAssetTradingPlatformIdentifier(), this::setUnderlyingAssetTradingPlatformIdentifier);
			merger.mergeBasic(getUnderlyingAssetPriceSource(), o.getUnderlyingAssetPriceSource(), this::setUnderlyingAssetPriceSource);
			merger.mergeBasic(getCryptoAssetUnderlyingIndicator(), o.getCryptoAssetUnderlyingIndicator(), this::setCryptoAssetUnderlyingIndicatorOverriddenAsBoolean);
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevelOverriddenAsReportLevelEnum);
			merger.mergeBasic(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeBasic(getEventType(), o.getEventType(), this::setEventType);
			merger.mergeBasic(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestamp);
			merger.mergeBasic(getConfirmationTimestamp(), o.getConfirmationTimestamp(), this::setConfirmationTimestamp);
			merger.mergeBasic(getPlatformIdentifier(), o.getPlatformIdentifier(), this::setPlatformIdentifier);
			merger.mergeBasic(getBookingLocation(), o.getBookingLocation(), this::setBookingLocation);
			merger.mergeBasic(getTraderLocation(), o.getTraderLocation(), this::setTraderLocation);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryTypeOverriddenAsDeliveryTypeEnum);
			merger.mergeBasic(getExecutionAgentCounterparty1(), o.getExecutionAgentCounterparty1(), this::setExecutionAgentCounterparty1);
			merger.mergeBasic(getExecutionAgentCounterparty2(), o.getExecutionAgentCounterparty2(), this::setExecutionAgentCounterparty2);
			merger.mergeBasic(getNatureOfCounterparty1(), o.getNatureOfCounterparty1(), this::setNatureOfCounterparty1OverriddenAsNatureOfCounterpartyEnum);
			merger.mergeBasic(getNatureOfCounterparty2(), o.getNatureOfCounterparty2(), this::setNatureOfCounterparty2);
			merger.mergeBasic(getClearingExceptionsAndExemptionsCounterparty1(), o.getClearingExceptionsAndExemptionsCounterparty1(), (Consumer<ClearingExceptionsAndExemptionsEnum>) this::addClearingExceptionsAndExemptionsCounterparty1);
			merger.mergeBasic(getClearingExceptionsAndExemptionsCounterparty2(), o.getClearingExceptionsAndExemptionsCounterparty2(), (Consumer<ClearingExceptionsAndExemptionsEnum>) this::addClearingExceptionsAndExemptionsCounterparty2);
			merger.mergeBasic(getCorporateSectorOfTheCounterparty1(), o.getCorporateSectorOfTheCounterparty1(), (Consumer<String>) this::addCorporateSectorOfTheCounterparty1);
			merger.mergeBasic(getCorporateSectorOfTheCounterparty2(), o.getCorporateSectorOfTheCounterparty2(), (Consumer<String>) this::addCorporateSectorOfTheCounterparty2);
			merger.mergeBasic(getCounterparty2Name(), o.getCounterparty2Name(), this::setCounterparty2Name);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityID);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			merger.mergeBasic(getCountryOfTheCounterparty2(), o.getCountryOfTheCounterparty2(), this::setCountryOfTheCounterparty2);
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSource);
			merger.mergeBasic(getTradingCapacity(), o.getTradingCapacity(), this::setTradingCapacity);
			merger.mergeBasic(getBrokerID(), o.getBrokerID(), this::setBrokerID);
			merger.mergeBasic(getContractType(), o.getContractType(), this::setContractTypeOverriddenAsCommonContractType);
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClassOverriddenAsCommonAssetClass);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getOptionStyle(), o.getOptionStyle(), this::setOptionStyle);
			merger.mergeBasic(getEmbeddedOptionType(), o.getEmbeddedOptionType(), this::setEmbeddedOptionType);
			merger.mergeBasic(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementTypeOverriddenAsMasterAgreementEnum);
			merger.mergeBasic(getMasterAgreementVersion(), o.getMasterAgreementVersion(), this::setMasterAgreementVersion);
			merger.mergeBasic(getSecondaryTransactionIdentifier(), o.getSecondaryTransactionIdentifier(), this::setSecondaryTransactionIdentifier);
			merger.mergeBasic(getIntragroup(), o.getIntragroup(), this::setIntragroup);
			merger.mergeBasic(getNonStandardizedTermIndicator(), o.getNonStandardizedTermIndicator(), this::setNonStandardizedTermIndicator);
			merger.mergeBasic(getAmendmentIndicator(), o.getAmendmentIndicator(), this::setAmendmentIndicator);
			merger.mergeBasic(getUnderlyingIdentification(), o.getUnderlyingIdentification(), this::setUnderlyingIdentification);
			merger.mergeBasic(getUnderlyingIdentificationType(), o.getUnderlyingIdentificationType(), this::setUnderlyingIdentificationType);
			merger.mergeBasic(getNameOfTheUnderlyingIndex(), o.getNameOfTheUnderlyingIndex(), this::setNameOfTheUnderlyingIndex);
			merger.mergeBasic(getMaturityDateOfTheUnderlying(), o.getMaturityDateOfTheUnderlying(), this::setMaturityDateOfTheUnderlying);
			merger.mergeBasic(getSwapLinkID(), o.getSwapLinkID(), this::setSwapLinkID);
			merger.mergeBasic(getPackageIndicator(), o.getPackageIndicator(), this::setPackageIndicator);
			merger.mergeBasic(getCustomBasketIndicator(), o.getCustomBasketIndicator(), this::setCustomBasketIndicator);
			merger.mergeBasic(getPriorUTIProprietary(), o.getPriorUTIProprietary(), this::setPriorUTIProprietary);
			merger.mergeBasic(getClearingTimestamp(), o.getClearingTimestamp(), this::setClearingTimestamp);
			merger.mergeBasic(getClearingAccountOrigin(), o.getClearingAccountOrigin(), this::setClearingAccountOrigin);
			merger.mergeBasic(getClearingReceiptTimestamp(), o.getClearingReceiptTimestamp(), this::setClearingReceiptTimestamp);
			merger.mergeBasic(getUniqueTransactionIdentifier(), o.getUniqueTransactionIdentifier(), this::setUniqueTransactionIdentifier);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietary(), o.getUniqueTransactionIdentifierProprietary(), this::setUniqueTransactionIdentifierProprietary);
			merger.mergeBasic(getUniqueProductIdentifier(), o.getUniqueProductIdentifier(), this::setUniqueProductIdentifier);
			merger.mergeBasic(getOriginalSwapUTI(), o.getOriginalSwapUTI(), this::setOriginalSwapUTI);
			merger.mergeBasic(getSubsequentPositionUTI(), o.getSubsequentPositionUTI(), this::setSubsequentPositionUTI);
			merger.mergeBasic(getOriginalSwapSDRIdentifier(), o.getOriginalSwapSDRIdentifier(), this::setOriginalSwapSDRIdentifier);
			merger.mergeBasic(getPriorUSI(), o.getPriorUSI(), this::setPriorUSI);
			merger.mergeBasic(getNewSDRIdentifier(), o.getNewSDRIdentifier(), this::setNewSDRIdentifier);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			merger.mergeBasic(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeBasic(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeBasic(getSeries(), o.getSeries(), this::setSeries);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			merger.mergeBasic(getSeriesVersion(), o.getSeriesVersion(), this::setSeriesVersion);
			merger.mergeBasic(getBaseProduct(), o.getBaseProduct(), this::setBaseProduct);
			merger.mergeBasic(getSubProduct(), o.getSubProduct(), this::setSubProduct);
			merger.mergeBasic(getFurtherSubProduct(), o.getFurtherSubProduct(), this::setFurtherSubProduct);
			merger.mergeBasic(getInitialMarginCollateralPortfolioCode(), o.getInitialMarginCollateralPortfolioCode(), this::setInitialMarginCollateralPortfolioCode);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCode);
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
		
			FCAUKEMIRTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(beneficiary1, _that.getBeneficiary1())) return false;
			if (!Objects.equals(beneficiary1IdentifierTypeIndicator, _that.getBeneficiary1IdentifierTypeIndicator())) return false;
			if (!Objects.equals(buyerIdentifier, _that.getBuyerIdentifier())) return false;
			if (!Objects.equals(sellerIdentifier, _that.getSellerIdentifier())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(centralCounterparty, _that.getCentralCounterparty())) return false;
			if (!Objects.equals(clearingMember, _that.getClearingMember())) return false;
			if (!Objects.equals(confirmed, _that.getConfirmed())) return false;
			if (!Objects.equals(callAmount, _that.getCallAmount())) return false;
			if (!Objects.equals(putAmount, _that.getPutAmount())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(delta, _that.getDelta())) return false;
			if (!ListEquals.listEquals(priceSchedule, _that.getPriceSchedule())) return false;
			if (!ListEquals.listEquals(strikePriceSchedule, _that.getStrikePriceSchedule())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceNotation, _that.getPriceNotation())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(packageTransactionPrice, _that.getPackageTransactionPrice())) return false;
			if (!Objects.equals(packageTransactionPriceNotation, _that.getPackageTransactionPriceNotation())) return false;
			if (!Objects.equals(packageTransactionPriceCurrency, _that.getPackageTransactionPriceCurrency())) return false;
			if (!Objects.equals(packageTransactionSpread, _that.getPackageTransactionSpread())) return false;
			if (!Objects.equals(packageTransactionSpreadNotation, _that.getPackageTransactionSpreadNotation())) return false;
			if (!Objects.equals(packageTransactionSpreadCurrency, _that.getPackageTransactionSpreadCurrency())) return false;
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePriceNotation, _that.getStrikePriceNotation())) return false;
			if (!Objects.equals(strikePriceCurrency, _that.getStrikePriceCurrency())) return false;
			if (!Objects.equals(priceUnitOfMeasure, _that.getPriceUnitOfMeasure())) return false;
			if (!Objects.equals(optionPremiumAmount, _that.getOptionPremiumAmount())) return false;
			if (!Objects.equals(optionPremiumCurrency, _that.getOptionPremiumCurrency())) return false;
			if (!Objects.equals(optionPremiumPaymentDate, _that.getOptionPremiumPaymentDate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(exchangeRateBasis, _that.getExchangeRateBasis())) return false;
			if (!Objects.equals(cdSIndexAttachmentPoint, _that.getCdSIndexAttachmentPoint())) return false;
			if (!Objects.equals(cdSIndexDetachmentPoint, _that.getCdSIndexDetachmentPoint())) return false;
			if (!Objects.equals(collateralPortfolioIndicator, _that.getCollateralPortfolioIndicator())) return false;
			if (!Objects.equals(firstExerciseDate, _that.getFirstExerciseDate())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(priorUTI, _that.getPriorUTI())) return false;
			if (!Objects.equals(direction1, _that.getDirection1())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			if (!Objects.equals(valuationCurrency, _that.getValuationCurrency())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(valuationTimestamp, _that.getValuationTimestamp())) return false;
			if (!Objects.equals(customBasketCode, _that.getCustomBasketCode())) return false;
			if (!ListEquals.listEquals(basketConstituents, _that.getBasketConstituents())) return false;
			if (!ListEquals.listEquals(otherPayment, _that.getOtherPayment())) return false;
			if (!Objects.equals(leg1, _that.getLeg1())) return false;
			if (!Objects.equals(leg2, _that.getLeg2())) return false;
			if (!Objects.equals(underlyingIdOther, _that.getUnderlyingIdOther())) return false;
			if (!Objects.equals(underlyingIdOtherSource, _that.getUnderlyingIdOtherSource())) return false;
			if (!Objects.equals(underlyingAssetTradingPlatformIdentifier, _that.getUnderlyingAssetTradingPlatformIdentifier())) return false;
			if (!Objects.equals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			if (!Objects.equals(cryptoAssetUnderlyingIndicator, _that.getCryptoAssetUnderlyingIndicator())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(confirmationTimestamp, _that.getConfirmationTimestamp())) return false;
			if (!Objects.equals(platformIdentifier, _that.getPlatformIdentifier())) return false;
			if (!Objects.equals(bookingLocation, _that.getBookingLocation())) return false;
			if (!Objects.equals(traderLocation, _that.getTraderLocation())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(executionAgentCounterparty1, _that.getExecutionAgentCounterparty1())) return false;
			if (!Objects.equals(executionAgentCounterparty2, _that.getExecutionAgentCounterparty2())) return false;
			if (!Objects.equals(natureOfCounterparty1, _that.getNatureOfCounterparty1())) return false;
			if (!Objects.equals(natureOfCounterparty2, _that.getNatureOfCounterparty2())) return false;
			if (!ListEquals.listEquals(clearingExceptionsAndExemptionsCounterparty1, _that.getClearingExceptionsAndExemptionsCounterparty1())) return false;
			if (!ListEquals.listEquals(clearingExceptionsAndExemptionsCounterparty2, _that.getClearingExceptionsAndExemptionsCounterparty2())) return false;
			if (!ListEquals.listEquals(corporateSectorOfTheCounterparty1, _that.getCorporateSectorOfTheCounterparty1())) return false;
			if (!ListEquals.listEquals(corporateSectorOfTheCounterparty2, _that.getCorporateSectorOfTheCounterparty2())) return false;
			if (!Objects.equals(counterparty2Name, _that.getCounterparty2Name())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(countryOfTheCounterparty2, _that.getCountryOfTheCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(tradingCapacity, _that.getTradingCapacity())) return false;
			if (!Objects.equals(brokerID, _that.getBrokerID())) return false;
			if (!Objects.equals(contractType, _that.getContractType())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(embeddedOptionType, _that.getEmbeddedOptionType())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			if (!Objects.equals(secondaryTransactionIdentifier, _that.getSecondaryTransactionIdentifier())) return false;
			if (!Objects.equals(intragroup, _that.getIntragroup())) return false;
			if (!Objects.equals(nonStandardizedTermIndicator, _that.getNonStandardizedTermIndicator())) return false;
			if (!Objects.equals(amendmentIndicator, _that.getAmendmentIndicator())) return false;
			if (!Objects.equals(underlyingIdentification, _that.getUnderlyingIdentification())) return false;
			if (!Objects.equals(underlyingIdentificationType, _that.getUnderlyingIdentificationType())) return false;
			if (!Objects.equals(nameOfTheUnderlyingIndex, _that.getNameOfTheUnderlyingIndex())) return false;
			if (!Objects.equals(maturityDateOfTheUnderlying, _that.getMaturityDateOfTheUnderlying())) return false;
			if (!Objects.equals(swapLinkID, _that.getSwapLinkID())) return false;
			if (!Objects.equals(packageIndicator, _that.getPackageIndicator())) return false;
			if (!Objects.equals(customBasketIndicator, _that.getCustomBasketIndicator())) return false;
			if (!Objects.equals(priorUTIProprietary, _that.getPriorUTIProprietary())) return false;
			if (!Objects.equals(clearingTimestamp, _that.getClearingTimestamp())) return false;
			if (!Objects.equals(clearingAccountOrigin, _that.getClearingAccountOrigin())) return false;
			if (!Objects.equals(clearingReceiptTimestamp, _that.getClearingReceiptTimestamp())) return false;
			if (!Objects.equals(uniqueTransactionIdentifier, _that.getUniqueTransactionIdentifier())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			if (!Objects.equals(originalSwapUTI, _that.getOriginalSwapUTI())) return false;
			if (!Objects.equals(subsequentPositionUTI, _that.getSubsequentPositionUTI())) return false;
			if (!Objects.equals(originalSwapSDRIdentifier, _that.getOriginalSwapSDRIdentifier())) return false;
			if (!Objects.equals(priorUSI, _that.getPriorUSI())) return false;
			if (!Objects.equals(newSDRIdentifier, _that.getNewSDRIdentifier())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(series, _that.getSeries())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seriesVersion, _that.getSeriesVersion())) return false;
			if (!Objects.equals(baseProduct, _that.getBaseProduct())) return false;
			if (!Objects.equals(subProduct, _that.getSubProduct())) return false;
			if (!Objects.equals(furtherSubProduct, _that.getFurtherSubProduct())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
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
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (beneficiary1 != null ? beneficiary1.hashCode() : 0);
			_result = 31 * _result + (beneficiary1IdentifierTypeIndicator != null ? beneficiary1IdentifierTypeIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerIdentifier != null ? buyerIdentifier.hashCode() : 0);
			_result = 31 * _result + (sellerIdentifier != null ? sellerIdentifier.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterparty != null ? centralCounterparty.hashCode() : 0);
			_result = 31 * _result + (clearingMember != null ? clearingMember.hashCode() : 0);
			_result = 31 * _result + (confirmed != null ? confirmed.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callAmount != null ? callAmount.hashCode() : 0);
			_result = 31 * _result + (putAmount != null ? putAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (putCurrency != null ? putCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delta != null ? delta.hashCode() : 0);
			_result = 31 * _result + (priceSchedule != null ? priceSchedule.hashCode() : 0);
			_result = 31 * _result + (strikePriceSchedule != null ? strikePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceNotation != null ? priceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionPrice != null ? packageTransactionPrice.hashCode() : 0);
			_result = 31 * _result + (packageTransactionPriceNotation != null ? packageTransactionPriceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionPriceCurrency != null ? packageTransactionPriceCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpread != null ? packageTransactionSpread.hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpreadNotation != null ? packageTransactionSpreadNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpreadCurrency != null ? packageTransactionSpreadCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceNotation != null ? strikePriceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePriceCurrency != null ? strikePriceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnitOfMeasure != null ? priceUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (optionPremiumAmount != null ? optionPremiumAmount.hashCode() : 0);
			_result = 31 * _result + (optionPremiumCurrency != null ? optionPremiumCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionPremiumPaymentDate != null ? optionPremiumPaymentDate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateBasis != null ? exchangeRateBasis.hashCode() : 0);
			_result = 31 * _result + (cdSIndexAttachmentPoint != null ? cdSIndexAttachmentPoint.hashCode() : 0);
			_result = 31 * _result + (cdSIndexDetachmentPoint != null ? cdSIndexDetachmentPoint.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIndicator != null ? collateralPortfolioIndicator.hashCode() : 0);
			_result = 31 * _result + (firstExerciseDate != null ? firstExerciseDate.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priorUTI != null ? priorUTI.hashCode() : 0);
			_result = 31 * _result + (direction1 != null ? direction1.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			_result = 31 * _result + (valuationCurrency != null ? valuationCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTimestamp != null ? valuationTimestamp.hashCode() : 0);
			_result = 31 * _result + (customBasketCode != null ? customBasketCode.hashCode() : 0);
			_result = 31 * _result + (basketConstituents != null ? basketConstituents.hashCode() : 0);
			_result = 31 * _result + (otherPayment != null ? otherPayment.hashCode() : 0);
			_result = 31 * _result + (leg1 != null ? leg1.hashCode() : 0);
			_result = 31 * _result + (leg2 != null ? leg2.hashCode() : 0);
			_result = 31 * _result + (underlyingIdOther != null ? underlyingIdOther.hashCode() : 0);
			_result = 31 * _result + (underlyingIdOtherSource != null ? underlyingIdOtherSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetTradingPlatformIdentifier != null ? underlyingAssetTradingPlatformIdentifier.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			_result = 31 * _result + (cryptoAssetUnderlyingIndicator != null ? cryptoAssetUnderlyingIndicator.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (confirmationTimestamp != null ? confirmationTimestamp.hashCode() : 0);
			_result = 31 * _result + (platformIdentifier != null ? platformIdentifier.hashCode() : 0);
			_result = 31 * _result + (bookingLocation != null ? bookingLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (traderLocation != null ? traderLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionAgentCounterparty1 != null ? executionAgentCounterparty1.hashCode() : 0);
			_result = 31 * _result + (executionAgentCounterparty2 != null ? executionAgentCounterparty2.hashCode() : 0);
			_result = 31 * _result + (natureOfCounterparty1 != null ? natureOfCounterparty1.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (natureOfCounterparty2 != null ? natureOfCounterparty2.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingExceptionsAndExemptionsCounterparty1 != null ? clearingExceptionsAndExemptionsCounterparty1.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (clearingExceptionsAndExemptionsCounterparty2 != null ? clearingExceptionsAndExemptionsCounterparty2.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (corporateSectorOfTheCounterparty1 != null ? corporateSectorOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (corporateSectorOfTheCounterparty2 != null ? corporateSectorOfTheCounterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2Name != null ? counterparty2Name.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (countryOfTheCounterparty2 != null ? countryOfTheCounterparty2.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradingCapacity != null ? tradingCapacity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (brokerID != null ? brokerID.hashCode() : 0);
			_result = 31 * _result + (contractType != null ? contractType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (embeddedOptionType != null ? embeddedOptionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			_result = 31 * _result + (secondaryTransactionIdentifier != null ? secondaryTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (intragroup != null ? intragroup.hashCode() : 0);
			_result = 31 * _result + (nonStandardizedTermIndicator != null ? nonStandardizedTermIndicator.hashCode() : 0);
			_result = 31 * _result + (amendmentIndicator != null ? amendmentIndicator.hashCode() : 0);
			_result = 31 * _result + (underlyingIdentification != null ? underlyingIdentification.hashCode() : 0);
			_result = 31 * _result + (underlyingIdentificationType != null ? underlyingIdentificationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nameOfTheUnderlyingIndex != null ? nameOfTheUnderlyingIndex.hashCode() : 0);
			_result = 31 * _result + (maturityDateOfTheUnderlying != null ? maturityDateOfTheUnderlying.hashCode() : 0);
			_result = 31 * _result + (swapLinkID != null ? swapLinkID.hashCode() : 0);
			_result = 31 * _result + (packageIndicator != null ? packageIndicator.hashCode() : 0);
			_result = 31 * _result + (customBasketIndicator != null ? customBasketIndicator.hashCode() : 0);
			_result = 31 * _result + (priorUTIProprietary != null ? priorUTIProprietary.hashCode() : 0);
			_result = 31 * _result + (clearingTimestamp != null ? clearingTimestamp.hashCode() : 0);
			_result = 31 * _result + (clearingAccountOrigin != null ? clearingAccountOrigin.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingReceiptTimestamp != null ? clearingReceiptTimestamp.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifier != null ? uniqueTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			_result = 31 * _result + (originalSwapUTI != null ? originalSwapUTI.hashCode() : 0);
			_result = 31 * _result + (subsequentPositionUTI != null ? subsequentPositionUTI.hashCode() : 0);
			_result = 31 * _result + (originalSwapSDRIdentifier != null ? originalSwapSDRIdentifier.hashCode() : 0);
			_result = 31 * _result + (priorUSI != null ? priorUSI.hashCode() : 0);
			_result = 31 * _result + (newSDRIdentifier != null ? newSDRIdentifier.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (series != null ? series.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seriesVersion != null ? seriesVersion.hashCode() : 0);
			_result = 31 * _result + (baseProduct != null ? baseProduct.hashCode() : 0);
			_result = 31 * _result + (subProduct != null ? subProduct.hashCode() : 0);
			_result = 31 * _result + (furtherSubProduct != null ? furtherSubProduct.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
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
			return "FCAUKEMIRTransactionReportBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"beneficiary1=" + this.beneficiary1 + ", " +
				"beneficiary1IdentifierTypeIndicator=" + this.beneficiary1IdentifierTypeIndicator + ", " +
				"buyerIdentifier=" + this.buyerIdentifier + ", " +
				"sellerIdentifier=" + this.sellerIdentifier + ", " +
				"cleared=" + this.cleared + ", " +
				"centralCounterparty=" + this.centralCounterparty + ", " +
				"clearingMember=" + this.clearingMember + ", " +
				"confirmed=" + this.confirmed + ", " +
				"callAmount=" + this.callAmount + ", " +
				"putAmount=" + this.putAmount + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"putCurrency=" + this.putCurrency + ", " +
				"delta=" + this.delta + ", " +
				"priceSchedule=" + this.priceSchedule + ", " +
				"strikePriceSchedule=" + this.strikePriceSchedule + ", " +
				"price=" + this.price + ", " +
				"priceNotation=" + this.priceNotation + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"packageTransactionPrice=" + this.packageTransactionPrice + ", " +
				"packageTransactionPriceNotation=" + this.packageTransactionPriceNotation + ", " +
				"packageTransactionPriceCurrency=" + this.packageTransactionPriceCurrency + ", " +
				"packageTransactionSpread=" + this.packageTransactionSpread + ", " +
				"packageTransactionSpreadNotation=" + this.packageTransactionSpreadNotation + ", " +
				"packageTransactionSpreadCurrency=" + this.packageTransactionSpreadCurrency + ", " +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceNotation=" + this.strikePriceNotation + ", " +
				"strikePriceCurrency=" + this.strikePriceCurrency + ", " +
				"priceUnitOfMeasure=" + this.priceUnitOfMeasure + ", " +
				"optionPremiumAmount=" + this.optionPremiumAmount + ", " +
				"optionPremiumCurrency=" + this.optionPremiumCurrency + ", " +
				"optionPremiumPaymentDate=" + this.optionPremiumPaymentDate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"exchangeRateBasis=" + this.exchangeRateBasis + ", " +
				"cdSIndexAttachmentPoint=" + this.cdSIndexAttachmentPoint + ", " +
				"cdSIndexDetachmentPoint=" + this.cdSIndexDetachmentPoint + ", " +
				"collateralPortfolioIndicator=" + this.collateralPortfolioIndicator + ", " +
				"firstExerciseDate=" + this.firstExerciseDate + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"priorUTI=" + this.priorUTI + ", " +
				"direction1=" + this.direction1 + ", " +
				"valuationAmount=" + this.valuationAmount + ", " +
				"valuationCurrency=" + this.valuationCurrency + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"valuationTimestamp=" + this.valuationTimestamp + ", " +
				"customBasketCode=" + this.customBasketCode + ", " +
				"basketConstituents=" + this.basketConstituents + ", " +
				"otherPayment=" + this.otherPayment + ", " +
				"leg1=" + this.leg1 + ", " +
				"leg2=" + this.leg2 + ", " +
				"underlyingIdOther=" + this.underlyingIdOther + ", " +
				"underlyingIdOtherSource=" + this.underlyingIdOtherSource + ", " +
				"underlyingAssetTradingPlatformIdentifier=" + this.underlyingAssetTradingPlatformIdentifier + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource + ", " +
				"cryptoAssetUnderlyingIndicator=" + this.cryptoAssetUnderlyingIndicator + ", " +
				"level=" + this.level + ", " +
				"actionType=" + this.actionType + ", " +
				"eventType=" + this.eventType + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"confirmationTimestamp=" + this.confirmationTimestamp + ", " +
				"platformIdentifier=" + this.platformIdentifier + ", " +
				"bookingLocation=" + this.bookingLocation + ", " +
				"traderLocation=" + this.traderLocation + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"executionAgentCounterparty1=" + this.executionAgentCounterparty1 + ", " +
				"executionAgentCounterparty2=" + this.executionAgentCounterparty2 + ", " +
				"natureOfCounterparty1=" + this.natureOfCounterparty1 + ", " +
				"natureOfCounterparty2=" + this.natureOfCounterparty2 + ", " +
				"clearingExceptionsAndExemptionsCounterparty1=" + this.clearingExceptionsAndExemptionsCounterparty1 + ", " +
				"clearingExceptionsAndExemptionsCounterparty2=" + this.clearingExceptionsAndExemptionsCounterparty2 + ", " +
				"corporateSectorOfTheCounterparty1=" + this.corporateSectorOfTheCounterparty1 + ", " +
				"corporateSectorOfTheCounterparty2=" + this.corporateSectorOfTheCounterparty2 + ", " +
				"counterparty2Name=" + this.counterparty2Name + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"countryOfTheCounterparty2=" + this.countryOfTheCounterparty2 + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"tradingCapacity=" + this.tradingCapacity + ", " +
				"brokerID=" + this.brokerID + ", " +
				"contractType=" + this.contractType + ", " +
				"assetClass=" + this.assetClass + ", " +
				"optionType=" + this.optionType + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"embeddedOptionType=" + this.embeddedOptionType + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion + ", " +
				"secondaryTransactionIdentifier=" + this.secondaryTransactionIdentifier + ", " +
				"intragroup=" + this.intragroup + ", " +
				"nonStandardizedTermIndicator=" + this.nonStandardizedTermIndicator + ", " +
				"amendmentIndicator=" + this.amendmentIndicator + ", " +
				"underlyingIdentification=" + this.underlyingIdentification + ", " +
				"underlyingIdentificationType=" + this.underlyingIdentificationType + ", " +
				"nameOfTheUnderlyingIndex=" + this.nameOfTheUnderlyingIndex + ", " +
				"maturityDateOfTheUnderlying=" + this.maturityDateOfTheUnderlying + ", " +
				"swapLinkID=" + this.swapLinkID + ", " +
				"packageIndicator=" + this.packageIndicator + ", " +
				"customBasketIndicator=" + this.customBasketIndicator + ", " +
				"priorUTIProprietary=" + this.priorUTIProprietary + ", " +
				"clearingTimestamp=" + this.clearingTimestamp + ", " +
				"clearingAccountOrigin=" + this.clearingAccountOrigin + ", " +
				"clearingReceiptTimestamp=" + this.clearingReceiptTimestamp + ", " +
				"uniqueTransactionIdentifier=" + this.uniqueTransactionIdentifier + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier + ", " +
				"originalSwapUTI=" + this.originalSwapUTI + ", " +
				"subsequentPositionUTI=" + this.subsequentPositionUTI + ", " +
				"originalSwapSDRIdentifier=" + this.originalSwapSDRIdentifier + ", " +
				"priorUSI=" + this.priorUSI + ", " +
				"newSDRIdentifier=" + this.newSDRIdentifier + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"seniority=" + this.seniority + ", " +
				"series=" + this.series + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"seriesVersion=" + this.seriesVersion + ", " +
				"baseProduct=" + this.baseProduct + ", " +
				"subProduct=" + this.subProduct + ", " +
				"furtherSubProduct=" + this.furtherSubProduct + ", " +
				"barrier=" + this.barrier + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"nonReportable=" + this.nonReportable + ", " +
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
			'}';
		}
	}
}
