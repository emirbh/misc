package drr.regulation.hkma.rewrite.trade;

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
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.ReferenceEntityFormatEnum;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.CommonTransactionReport;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.hkma.rewrite.trade.meta.HKMATransactionReportMeta;
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
@RosettaDataType(value="HKMATransactionReport", builder=HKMATransactionReport.HKMATransactionReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="HKMATransactionReport", model="drr", builder=HKMATransactionReport.HKMATransactionReportBuilderImpl.class, version="7.7.0")
public interface HKMATransactionReport extends CommonTransactionReport {

	HKMATransactionReportMeta metaData = new HKMATransactionReportMeta();

	/*********************** Getter Methods  ***********************/
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
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "9" * field "Counterparty 2 identifier type indicator"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2.
	 *
	 */
	@Override
	Boolean getCounterparty2IdentifierType();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "13" * field "Cleared"
	 *
	 * Provision Indicator of whether the contract has been cleared, or is intended to be cleared, by a central counterparty.
	 *
	 */
	@Override
	ClearedEnum getCleared();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "136" * field "Event timestamp"
	 *
	 * Provision Date and time of occurrence of the event.
	                 In the case of a modification agreed for a future date, this data element should reflect the date, the modification occurs (becomes effective) and not when it was negotiated.
	                 In the case of a correction, this data element should reflect the date and time as of when the correction is applicable.
	                 In the case of a clearing event, this data element should reflect the recorded date and time when the alpha transaction is accepted by the central counterparty (CCP) for clearing.
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "154" * field "Entity responsible for reporting"
	 *
	 * Provision Identification code of the Reporting Party who has the obligation to report the transaction.
	 *
	 */
	@Override
	String getEntityResponsibleForReporting();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "158" * field "Asset class"
	 *
	 * Provision Each reported contract shall be classified according to the asset class it is based on, if applicable.
	 *
	 */
	@Override
	CommonAssetClass getAssetClass();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "200" * field "Technical record identification"
	 *
	 * Provision Unique identifier of a trade action used as part of error management and status advice message.
	 *
	 */
	@Override
	String getTechnicalRecordId();
	List<BigDecimal> getBasketConstituentNumberOfUnits();
	List<String> getBasketConstituentUnitOfMeasure();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "197" * field "Product description"
	 *
	 * Provision Where applicable: indicates the transaction is rising from Bond Connect investment needs.
	 *
	 */
	String getProductDescription();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "198" * field "Beneficiary"
	 *
	 * Provision Where applicable: the CMU Sub-account Number of the Eligible investor for Bond Connect trades.
	 *
	 */
	String getBeneficiary();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "201" * field "Remarks"
	 *
	 * Provision A TR Trade Reference generated by the HKTR for post-trade action correlation, if applicable, when the designated trade cannot be correlated by using the UTI.
	 *
	 */
	String getRemarks();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "202" * field "Remarks 1"
	 *
	 * Provision 
	 *
	 */
	String getRemarks1();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "203" * field "Remarks 2"
	 *
	 * Provision 
	 *
	 */
	String getRemarks2();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "204" * field "Remarks 3"
	 *
	 * Provision 
	 *
	 */
	String getRemarks3();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "205" * field "Remarks 4"
	 *
	 * Provision 
	 *
	 */
	String getRemarks4();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "206" * field "Remarks 5"
	 *
	 * Provision 
	 *
	 */
	String getRemarks5();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "207" * field "Remarks 6"
	 *
	 * Provision 
	 *
	 */
	String getRemarks6();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "208" * field "Remarks 7"
	 *
	 * Provision 
	 *
	 */
	String getRemarks7();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "209" * field "Remarks 8"
	 *
	 * Provision 
	 *
	 */
	String getRemarks8();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "210" * field "Remarks 9"
	 *
	 * Provision 
	 *
	 */
	String getRemarks9();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "211" * field "Remarks 10"
	 *
	 * Provision 
	 *
	 */
	String getRemarks10();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "212" * field "Remarks 11"
	 *
	 * Provision 
	 *
	 */
	String getRemarks11();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "213" * field "Remarks 12"
	 *
	 * Provision 
	 *
	 */
	String getRemarks12();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "214" * field "Remarks 13"
	 *
	 * Provision 
	 *
	 */
	String getRemarks13();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * dataElement "139" * field "Unique Product Identifier (UPI)"
	 *
	 * Provision A unique set of characters that represents a particular OTC derivative.
	 *
	 */
	String getUniqueProductIdentifierProprietary();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Counterparty 2 Identifier Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format type for Counterparty 2
	 *
	 */
	PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat();
	HKTRPartyScheme getCounterparty2SchemeName();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Central Counterparty Identifier Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format type for Central Counterparty
	 *
	 */
	PartyIdentifierFormat2Enum getCentralCounterpartyIdentifierFormat();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Central Counterparty Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when identifier format is 'Other' for Central Counterparty
	 *
	 */
	HKTRPartyScheme getCentralCounterpartySchemeName();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Broker Identifier Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format type for Broker
	 *
	 */
	PartyIdentifierFormat2Enum getBrokerIdentifierFormat();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Broker Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when identifier format is 'Other' for Broker
	 *
	 */
	HKTRPartyScheme getBrokerSchemeName();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Reference Entity Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format type for Reference Entity
	 *
	 */
	ReferenceEntityFormatEnum getReferenceEntityFormat();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Clearing Member Identifier Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format type for Clearing Member
	 *
	 */
	PartyIdentifierFormat2Enum getClearingMemberIdentifierFormat();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Clearing Member Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when identifier format is 'Other' for Clearing Member
	 *
	 */
	HKTRPartyScheme getClearingMemberSchemeName();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Prior UTI Proprietary Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when Prior UTI is proprietary
	 *
	 */
	UTIProprietarySchemeNameEnum getPriorUTIProprietarySchemeName();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Trade   
	 * field "Unique Transaction Identifier Proprietary Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when Unique Transaction Identifier is proprietary
	 *
	 */
	UTIProprietarySchemeNameEnum getUniqueTransactionIdentifierProprietarySchemeName();

	/*********************** Build Methods  ***********************/
	HKMATransactionReport build();
	
	HKMATransactionReport.HKMATransactionReportBuilder toBuilder();
	
	static HKMATransactionReport.HKMATransactionReportBuilder builder() {
		return new HKMATransactionReport.HKMATransactionReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HKMATransactionReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HKMATransactionReport> getType() {
		return HKMATransactionReport.class;
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
		processor.processBasic(path.newSubPath("basketConstituentNumberOfUnits"), BigDecimal.class, getBasketConstituentNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("basketConstituentUnitOfMeasure"), String.class, getBasketConstituentUnitOfMeasure(), this);
		processor.processBasic(path.newSubPath("productDescription"), String.class, getProductDescription(), this);
		processor.processBasic(path.newSubPath("beneficiary"), String.class, getBeneficiary(), this);
		processor.processBasic(path.newSubPath("remarks"), String.class, getRemarks(), this);
		processor.processBasic(path.newSubPath("remarks1"), String.class, getRemarks1(), this);
		processor.processBasic(path.newSubPath("remarks2"), String.class, getRemarks2(), this);
		processor.processBasic(path.newSubPath("remarks3"), String.class, getRemarks3(), this);
		processor.processBasic(path.newSubPath("remarks4"), String.class, getRemarks4(), this);
		processor.processBasic(path.newSubPath("remarks5"), String.class, getRemarks5(), this);
		processor.processBasic(path.newSubPath("remarks6"), String.class, getRemarks6(), this);
		processor.processBasic(path.newSubPath("remarks7"), String.class, getRemarks7(), this);
		processor.processBasic(path.newSubPath("remarks8"), String.class, getRemarks8(), this);
		processor.processBasic(path.newSubPath("remarks9"), String.class, getRemarks9(), this);
		processor.processBasic(path.newSubPath("remarks10"), String.class, getRemarks10(), this);
		processor.processBasic(path.newSubPath("remarks11"), String.class, getRemarks11(), this);
		processor.processBasic(path.newSubPath("remarks12"), String.class, getRemarks12(), this);
		processor.processBasic(path.newSubPath("remarks13"), String.class, getRemarks13(), this);
		processor.processBasic(path.newSubPath("uniqueProductIdentifierProprietary"), String.class, getUniqueProductIdentifierProprietary(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierFormat"), PartyIdentifierFormat2Enum.class, getCounterparty2IdentifierFormat(), this);
		processor.processBasic(path.newSubPath("counterparty2SchemeName"), HKTRPartyScheme.class, getCounterparty2SchemeName(), this);
		processor.processBasic(path.newSubPath("centralCounterpartyIdentifierFormat"), PartyIdentifierFormat2Enum.class, getCentralCounterpartyIdentifierFormat(), this);
		processor.processBasic(path.newSubPath("centralCounterpartySchemeName"), HKTRPartyScheme.class, getCentralCounterpartySchemeName(), this);
		processor.processBasic(path.newSubPath("brokerIdentifierFormat"), PartyIdentifierFormat2Enum.class, getBrokerIdentifierFormat(), this);
		processor.processBasic(path.newSubPath("brokerSchemeName"), HKTRPartyScheme.class, getBrokerSchemeName(), this);
		processor.processBasic(path.newSubPath("referenceEntityFormat"), ReferenceEntityFormatEnum.class, getReferenceEntityFormat(), this);
		processor.processBasic(path.newSubPath("clearingMemberIdentifierFormat"), PartyIdentifierFormat2Enum.class, getClearingMemberIdentifierFormat(), this);
		processor.processBasic(path.newSubPath("clearingMemberSchemeName"), HKTRPartyScheme.class, getClearingMemberSchemeName(), this);
		processor.processBasic(path.newSubPath("priorUTIProprietarySchemeName"), UTIProprietarySchemeNameEnum.class, getPriorUTIProprietarySchemeName(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietarySchemeName"), UTIProprietarySchemeNameEnum.class, getUniqueTransactionIdentifierProprietarySchemeName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface HKMATransactionReportBuilder extends HKMATransactionReport, CommonTransactionReport.CommonTransactionReportBuilder {
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEffectiveDate(Date effectiveDate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setExpirationDate(Date expirationDate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty1(String counterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2(String counterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBeneficiary1(String beneficiary1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCleared(ClearedEnum cleared);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setClearingMember(String clearingMember);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCallAmount(BigDecimal callAmount);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPutAmount(BigDecimal putAmount);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setDelta(BigDecimal delta);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPrice(PriceFormat price);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriorUTI(String priorUTI);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setDirection1(Direction1Enum direction1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCustomBasketCode(String customBasketCode);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg1(LegV1 leg1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg2(LegV1 leg2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg1(LegV2 leg1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg2(LegV2 leg2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg1(Leg leg1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg2(Leg leg2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLevel(ReportLevelEnum level);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEventType(EventTypeEnum eventType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEventIdentifier(String eventIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg1(CommonLeg leg1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setLeg2(CommonLeg leg2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBrokerID(String brokerID);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setContractType(CommonContractType contractType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOptionType(OptionTypeCode optionType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setIntragroup(Boolean intragroup);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSwapLinkID(String swapLinkID);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setPriorUSI(String priorUSI);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setReferenceEntity(String referenceEntity);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSeniority(SeniorityEnum seniority);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSeries(Integer series);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBaseProduct(String baseProduct);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setSubProduct(String subProduct);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		HKMATransactionReport.HKMATransactionReportBuilder setNonReportable(NonReportable nonReportable);
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		HKMATransactionReport.HKMATransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		HKMATransactionReport.HKMATransactionReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		HKMATransactionReport.HKMATransactionReportBuilder setEntityResponsibleForReportingOverriddenAsString(String entityResponsibleForReporting);
		HKMATransactionReport.HKMATransactionReportBuilder setAssetClassOverriddenAsCommonAssetClass(CommonAssetClass assetClass);
		HKMATransactionReport.HKMATransactionReportBuilder setTechnicalRecordIdOverriddenAsString(String technicalRecordId);
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentNumberOfUnits(BigDecimal basketConstituentNumberOfUnits);
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentNumberOfUnits(BigDecimal basketConstituentNumberOfUnits, int idx);
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentNumberOfUnits(List<BigDecimal> basketConstituentNumberOfUnits);
		HKMATransactionReport.HKMATransactionReportBuilder setBasketConstituentNumberOfUnits(List<BigDecimal> basketConstituentNumberOfUnits);
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentUnitOfMeasure(String basketConstituentUnitOfMeasure);
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentUnitOfMeasure(String basketConstituentUnitOfMeasure, int idx);
		HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentUnitOfMeasure(List<String> basketConstituentUnitOfMeasure);
		HKMATransactionReport.HKMATransactionReportBuilder setBasketConstituentUnitOfMeasure(List<String> basketConstituentUnitOfMeasure);
		HKMATransactionReport.HKMATransactionReportBuilder setProductDescription(String productDescription);
		HKMATransactionReport.HKMATransactionReportBuilder setBeneficiary(String beneficiary);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks(String remarks);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks1(String remarks1);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks2(String remarks2);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks3(String remarks3);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks4(String remarks4);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks5(String remarks5);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks6(String remarks6);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks7(String remarks7);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks8(String remarks8);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks9(String remarks9);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks10(String remarks10);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks11(String remarks11);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks12(String remarks12);
		HKMATransactionReport.HKMATransactionReportBuilder setRemarks13(String remarks13);
		HKMATransactionReport.HKMATransactionReportBuilder setUniqueProductIdentifierProprietary(String uniqueProductIdentifierProprietary);
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierFormat(PartyIdentifierFormat2Enum counterparty2IdentifierFormat);
		HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2SchemeName(HKTRPartyScheme counterparty2SchemeName);
		HKMATransactionReport.HKMATransactionReportBuilder setCentralCounterpartyIdentifierFormat(PartyIdentifierFormat2Enum centralCounterpartyIdentifierFormat);
		HKMATransactionReport.HKMATransactionReportBuilder setCentralCounterpartySchemeName(HKTRPartyScheme centralCounterpartySchemeName);
		HKMATransactionReport.HKMATransactionReportBuilder setBrokerIdentifierFormat(PartyIdentifierFormat2Enum brokerIdentifierFormat);
		HKMATransactionReport.HKMATransactionReportBuilder setBrokerSchemeName(HKTRPartyScheme brokerSchemeName);
		HKMATransactionReport.HKMATransactionReportBuilder setReferenceEntityFormat(ReferenceEntityFormatEnum referenceEntityFormat);
		HKMATransactionReport.HKMATransactionReportBuilder setClearingMemberIdentifierFormat(PartyIdentifierFormat2Enum clearingMemberIdentifierFormat);
		HKMATransactionReport.HKMATransactionReportBuilder setClearingMemberSchemeName(HKTRPartyScheme clearingMemberSchemeName);
		HKMATransactionReport.HKMATransactionReportBuilder setPriorUTIProprietarySchemeName(UTIProprietarySchemeNameEnum priorUTIProprietarySchemeName);
		HKMATransactionReport.HKMATransactionReportBuilder setUniqueTransactionIdentifierProprietarySchemeName(UTIProprietarySchemeNameEnum uniqueTransactionIdentifierProprietarySchemeName);

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
			processor.processBasic(path.newSubPath("basketConstituentNumberOfUnits"), BigDecimal.class, getBasketConstituentNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("basketConstituentUnitOfMeasure"), String.class, getBasketConstituentUnitOfMeasure(), this);
			processor.processBasic(path.newSubPath("productDescription"), String.class, getProductDescription(), this);
			processor.processBasic(path.newSubPath("beneficiary"), String.class, getBeneficiary(), this);
			processor.processBasic(path.newSubPath("remarks"), String.class, getRemarks(), this);
			processor.processBasic(path.newSubPath("remarks1"), String.class, getRemarks1(), this);
			processor.processBasic(path.newSubPath("remarks2"), String.class, getRemarks2(), this);
			processor.processBasic(path.newSubPath("remarks3"), String.class, getRemarks3(), this);
			processor.processBasic(path.newSubPath("remarks4"), String.class, getRemarks4(), this);
			processor.processBasic(path.newSubPath("remarks5"), String.class, getRemarks5(), this);
			processor.processBasic(path.newSubPath("remarks6"), String.class, getRemarks6(), this);
			processor.processBasic(path.newSubPath("remarks7"), String.class, getRemarks7(), this);
			processor.processBasic(path.newSubPath("remarks8"), String.class, getRemarks8(), this);
			processor.processBasic(path.newSubPath("remarks9"), String.class, getRemarks9(), this);
			processor.processBasic(path.newSubPath("remarks10"), String.class, getRemarks10(), this);
			processor.processBasic(path.newSubPath("remarks11"), String.class, getRemarks11(), this);
			processor.processBasic(path.newSubPath("remarks12"), String.class, getRemarks12(), this);
			processor.processBasic(path.newSubPath("remarks13"), String.class, getRemarks13(), this);
			processor.processBasic(path.newSubPath("uniqueProductIdentifierProprietary"), String.class, getUniqueProductIdentifierProprietary(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierFormat"), PartyIdentifierFormat2Enum.class, getCounterparty2IdentifierFormat(), this);
			processor.processBasic(path.newSubPath("counterparty2SchemeName"), HKTRPartyScheme.class, getCounterparty2SchemeName(), this);
			processor.processBasic(path.newSubPath("centralCounterpartyIdentifierFormat"), PartyIdentifierFormat2Enum.class, getCentralCounterpartyIdentifierFormat(), this);
			processor.processBasic(path.newSubPath("centralCounterpartySchemeName"), HKTRPartyScheme.class, getCentralCounterpartySchemeName(), this);
			processor.processBasic(path.newSubPath("brokerIdentifierFormat"), PartyIdentifierFormat2Enum.class, getBrokerIdentifierFormat(), this);
			processor.processBasic(path.newSubPath("brokerSchemeName"), HKTRPartyScheme.class, getBrokerSchemeName(), this);
			processor.processBasic(path.newSubPath("referenceEntityFormat"), ReferenceEntityFormatEnum.class, getReferenceEntityFormat(), this);
			processor.processBasic(path.newSubPath("clearingMemberIdentifierFormat"), PartyIdentifierFormat2Enum.class, getClearingMemberIdentifierFormat(), this);
			processor.processBasic(path.newSubPath("clearingMemberSchemeName"), HKTRPartyScheme.class, getClearingMemberSchemeName(), this);
			processor.processBasic(path.newSubPath("priorUTIProprietarySchemeName"), UTIProprietarySchemeNameEnum.class, getPriorUTIProprietarySchemeName(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietarySchemeName"), UTIProprietarySchemeNameEnum.class, getUniqueTransactionIdentifierProprietarySchemeName(), this);
		}
		

		HKMATransactionReport.HKMATransactionReportBuilder prune();
	}

	/*********************** Immutable Implementation of HKMATransactionReport  ***********************/
	class HKMATransactionReportImpl extends CommonTransactionReport.CommonTransactionReportImpl implements HKMATransactionReport {
		private final Boolean counterparty2IdentifierType;
		private final ClearedEnum cleared;
		private final ZonedDateTime eventTimestamp;
		private final String entityResponsibleForReporting;
		private final CommonAssetClass assetClass;
		private final String technicalRecordId;
		private final List<BigDecimal> basketConstituentNumberOfUnits;
		private final List<String> basketConstituentUnitOfMeasure;
		private final String productDescription;
		private final String beneficiary;
		private final String remarks;
		private final String remarks1;
		private final String remarks2;
		private final String remarks3;
		private final String remarks4;
		private final String remarks5;
		private final String remarks6;
		private final String remarks7;
		private final String remarks8;
		private final String remarks9;
		private final String remarks10;
		private final String remarks11;
		private final String remarks12;
		private final String remarks13;
		private final String uniqueProductIdentifierProprietary;
		private final PartyIdentifierFormat2Enum counterparty2IdentifierFormat;
		private final HKTRPartyScheme counterparty2SchemeName;
		private final PartyIdentifierFormat2Enum centralCounterpartyIdentifierFormat;
		private final HKTRPartyScheme centralCounterpartySchemeName;
		private final PartyIdentifierFormat2Enum brokerIdentifierFormat;
		private final HKTRPartyScheme brokerSchemeName;
		private final ReferenceEntityFormatEnum referenceEntityFormat;
		private final PartyIdentifierFormat2Enum clearingMemberIdentifierFormat;
		private final HKTRPartyScheme clearingMemberSchemeName;
		private final UTIProprietarySchemeNameEnum priorUTIProprietarySchemeName;
		private final UTIProprietarySchemeNameEnum uniqueTransactionIdentifierProprietarySchemeName;
		
		protected HKMATransactionReportImpl(HKMATransactionReport.HKMATransactionReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.cleared = builder.getCleared();
			this.eventTimestamp = builder.getEventTimestamp();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
			this.assetClass = builder.getAssetClass();
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.basketConstituentNumberOfUnits = ofNullable(builder.getBasketConstituentNumberOfUnits()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.basketConstituentUnitOfMeasure = ofNullable(builder.getBasketConstituentUnitOfMeasure()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.productDescription = builder.getProductDescription();
			this.beneficiary = builder.getBeneficiary();
			this.remarks = builder.getRemarks();
			this.remarks1 = builder.getRemarks1();
			this.remarks2 = builder.getRemarks2();
			this.remarks3 = builder.getRemarks3();
			this.remarks4 = builder.getRemarks4();
			this.remarks5 = builder.getRemarks5();
			this.remarks6 = builder.getRemarks6();
			this.remarks7 = builder.getRemarks7();
			this.remarks8 = builder.getRemarks8();
			this.remarks9 = builder.getRemarks9();
			this.remarks10 = builder.getRemarks10();
			this.remarks11 = builder.getRemarks11();
			this.remarks12 = builder.getRemarks12();
			this.remarks13 = builder.getRemarks13();
			this.uniqueProductIdentifierProprietary = builder.getUniqueProductIdentifierProprietary();
			this.counterparty2IdentifierFormat = builder.getCounterparty2IdentifierFormat();
			this.counterparty2SchemeName = builder.getCounterparty2SchemeName();
			this.centralCounterpartyIdentifierFormat = builder.getCentralCounterpartyIdentifierFormat();
			this.centralCounterpartySchemeName = builder.getCentralCounterpartySchemeName();
			this.brokerIdentifierFormat = builder.getBrokerIdentifierFormat();
			this.brokerSchemeName = builder.getBrokerSchemeName();
			this.referenceEntityFormat = builder.getReferenceEntityFormat();
			this.clearingMemberIdentifierFormat = builder.getClearingMemberIdentifierFormat();
			this.clearingMemberSchemeName = builder.getClearingMemberSchemeName();
			this.priorUTIProprietarySchemeName = builder.getPriorUTIProprietarySchemeName();
			this.uniqueTransactionIdentifierProprietarySchemeName = builder.getUniqueTransactionIdentifierProprietarySchemeName();
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
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
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
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("basketConstituentNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituentNumberOfUnits")
		public List<BigDecimal> getBasketConstituentNumberOfUnits() {
			return basketConstituentNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("basketConstituentUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituentUnitOfMeasure")
		public List<String> getBasketConstituentUnitOfMeasure() {
			return basketConstituentUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("productDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productDescription")
		public String getProductDescription() {
			return productDescription;
		}
		
		@Override
		@RosettaAttribute("beneficiary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary")
		public String getBeneficiary() {
			return beneficiary;
		}
		
		@Override
		@RosettaAttribute("remarks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks")
		public String getRemarks() {
			return remarks;
		}
		
		@Override
		@RosettaAttribute("remarks1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks1")
		public String getRemarks1() {
			return remarks1;
		}
		
		@Override
		@RosettaAttribute("remarks2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks2")
		public String getRemarks2() {
			return remarks2;
		}
		
		@Override
		@RosettaAttribute("remarks3")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks3")
		public String getRemarks3() {
			return remarks3;
		}
		
		@Override
		@RosettaAttribute("remarks4")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks4")
		public String getRemarks4() {
			return remarks4;
		}
		
		@Override
		@RosettaAttribute("remarks5")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks5")
		public String getRemarks5() {
			return remarks5;
		}
		
		@Override
		@RosettaAttribute("remarks6")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks6")
		public String getRemarks6() {
			return remarks6;
		}
		
		@Override
		@RosettaAttribute("remarks7")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks7")
		public String getRemarks7() {
			return remarks7;
		}
		
		@Override
		@RosettaAttribute("remarks8")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks8")
		public String getRemarks8() {
			return remarks8;
		}
		
		@Override
		@RosettaAttribute("remarks9")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks9")
		public String getRemarks9() {
			return remarks9;
		}
		
		@Override
		@RosettaAttribute("remarks10")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks10")
		public String getRemarks10() {
			return remarks10;
		}
		
		@Override
		@RosettaAttribute("remarks11")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks11")
		public String getRemarks11() {
			return remarks11;
		}
		
		@Override
		@RosettaAttribute("remarks12")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks12")
		public String getRemarks12() {
			return remarks12;
		}
		
		@Override
		@RosettaAttribute("remarks13")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks13")
		public String getRemarks13() {
			return remarks13;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueProductIdentifierProprietary")
		public String getUniqueProductIdentifierProprietary() {
			return uniqueProductIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		public PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat() {
			return counterparty2IdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("counterparty2SchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2SchemeName")
		public HKTRPartyScheme getCounterparty2SchemeName() {
			return counterparty2SchemeName;
		}
		
		@Override
		@RosettaAttribute("centralCounterpartyIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterpartyIdentifierFormat")
		public PartyIdentifierFormat2Enum getCentralCounterpartyIdentifierFormat() {
			return centralCounterpartyIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("centralCounterpartySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterpartySchemeName")
		public HKTRPartyScheme getCentralCounterpartySchemeName() {
			return centralCounterpartySchemeName;
		}
		
		@Override
		@RosettaAttribute("brokerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerIdentifierFormat")
		public PartyIdentifierFormat2Enum getBrokerIdentifierFormat() {
			return brokerIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("brokerSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerSchemeName")
		public HKTRPartyScheme getBrokerSchemeName() {
			return brokerSchemeName;
		}
		
		@Override
		@RosettaAttribute("referenceEntityFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntityFormat")
		public ReferenceEntityFormatEnum getReferenceEntityFormat() {
			return referenceEntityFormat;
		}
		
		@Override
		@RosettaAttribute("clearingMemberIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMemberIdentifierFormat")
		public PartyIdentifierFormat2Enum getClearingMemberIdentifierFormat() {
			return clearingMemberIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("clearingMemberSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMemberSchemeName")
		public HKTRPartyScheme getClearingMemberSchemeName() {
			return clearingMemberSchemeName;
		}
		
		@Override
		@RosettaAttribute("priorUTIProprietarySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTIProprietarySchemeName")
		public UTIProprietarySchemeNameEnum getPriorUTIProprietarySchemeName() {
			return priorUTIProprietarySchemeName;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		public UTIProprietarySchemeNameEnum getUniqueTransactionIdentifierProprietarySchemeName() {
			return uniqueTransactionIdentifierProprietarySchemeName;
		}
		
		@Override
		public HKMATransactionReport build() {
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder toBuilder() {
			HKMATransactionReport.HKMATransactionReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HKMATransactionReport.HKMATransactionReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getCleared()).ifPresent(builder::setClearedOverriddenAsClearedEnum);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReportingOverriddenAsString);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClassOverriddenAsCommonAssetClass);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordIdOverriddenAsString);
			ofNullable(getBasketConstituentNumberOfUnits()).ifPresent(builder::setBasketConstituentNumberOfUnits);
			ofNullable(getBasketConstituentUnitOfMeasure()).ifPresent(builder::setBasketConstituentUnitOfMeasure);
			ofNullable(getProductDescription()).ifPresent(builder::setProductDescription);
			ofNullable(getBeneficiary()).ifPresent(builder::setBeneficiary);
			ofNullable(getRemarks()).ifPresent(builder::setRemarks);
			ofNullable(getRemarks1()).ifPresent(builder::setRemarks1);
			ofNullable(getRemarks2()).ifPresent(builder::setRemarks2);
			ofNullable(getRemarks3()).ifPresent(builder::setRemarks3);
			ofNullable(getRemarks4()).ifPresent(builder::setRemarks4);
			ofNullable(getRemarks5()).ifPresent(builder::setRemarks5);
			ofNullable(getRemarks6()).ifPresent(builder::setRemarks6);
			ofNullable(getRemarks7()).ifPresent(builder::setRemarks7);
			ofNullable(getRemarks8()).ifPresent(builder::setRemarks8);
			ofNullable(getRemarks9()).ifPresent(builder::setRemarks9);
			ofNullable(getRemarks10()).ifPresent(builder::setRemarks10);
			ofNullable(getRemarks11()).ifPresent(builder::setRemarks11);
			ofNullable(getRemarks12()).ifPresent(builder::setRemarks12);
			ofNullable(getRemarks13()).ifPresent(builder::setRemarks13);
			ofNullable(getUniqueProductIdentifierProprietary()).ifPresent(builder::setUniqueProductIdentifierProprietary);
			ofNullable(getCounterparty2IdentifierFormat()).ifPresent(builder::setCounterparty2IdentifierFormat);
			ofNullable(getCounterparty2SchemeName()).ifPresent(builder::setCounterparty2SchemeName);
			ofNullable(getCentralCounterpartyIdentifierFormat()).ifPresent(builder::setCentralCounterpartyIdentifierFormat);
			ofNullable(getCentralCounterpartySchemeName()).ifPresent(builder::setCentralCounterpartySchemeName);
			ofNullable(getBrokerIdentifierFormat()).ifPresent(builder::setBrokerIdentifierFormat);
			ofNullable(getBrokerSchemeName()).ifPresent(builder::setBrokerSchemeName);
			ofNullable(getReferenceEntityFormat()).ifPresent(builder::setReferenceEntityFormat);
			ofNullable(getClearingMemberIdentifierFormat()).ifPresent(builder::setClearingMemberIdentifierFormat);
			ofNullable(getClearingMemberSchemeName()).ifPresent(builder::setClearingMemberSchemeName);
			ofNullable(getPriorUTIProprietarySchemeName()).ifPresent(builder::setPriorUTIProprietarySchemeName);
			ofNullable(getUniqueTransactionIdentifierProprietarySchemeName()).ifPresent(builder::setUniqueTransactionIdentifierProprietarySchemeName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			HKMATransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!ListEquals.listEquals(basketConstituentNumberOfUnits, _that.getBasketConstituentNumberOfUnits())) return false;
			if (!ListEquals.listEquals(basketConstituentUnitOfMeasure, _that.getBasketConstituentUnitOfMeasure())) return false;
			if (!Objects.equals(productDescription, _that.getProductDescription())) return false;
			if (!Objects.equals(beneficiary, _that.getBeneficiary())) return false;
			if (!Objects.equals(remarks, _that.getRemarks())) return false;
			if (!Objects.equals(remarks1, _that.getRemarks1())) return false;
			if (!Objects.equals(remarks2, _that.getRemarks2())) return false;
			if (!Objects.equals(remarks3, _that.getRemarks3())) return false;
			if (!Objects.equals(remarks4, _that.getRemarks4())) return false;
			if (!Objects.equals(remarks5, _that.getRemarks5())) return false;
			if (!Objects.equals(remarks6, _that.getRemarks6())) return false;
			if (!Objects.equals(remarks7, _that.getRemarks7())) return false;
			if (!Objects.equals(remarks8, _that.getRemarks8())) return false;
			if (!Objects.equals(remarks9, _that.getRemarks9())) return false;
			if (!Objects.equals(remarks10, _that.getRemarks10())) return false;
			if (!Objects.equals(remarks11, _that.getRemarks11())) return false;
			if (!Objects.equals(remarks12, _that.getRemarks12())) return false;
			if (!Objects.equals(remarks13, _that.getRemarks13())) return false;
			if (!Objects.equals(uniqueProductIdentifierProprietary, _that.getUniqueProductIdentifierProprietary())) return false;
			if (!Objects.equals(counterparty2IdentifierFormat, _that.getCounterparty2IdentifierFormat())) return false;
			if (!Objects.equals(counterparty2SchemeName, _that.getCounterparty2SchemeName())) return false;
			if (!Objects.equals(centralCounterpartyIdentifierFormat, _that.getCentralCounterpartyIdentifierFormat())) return false;
			if (!Objects.equals(centralCounterpartySchemeName, _that.getCentralCounterpartySchemeName())) return false;
			if (!Objects.equals(brokerIdentifierFormat, _that.getBrokerIdentifierFormat())) return false;
			if (!Objects.equals(brokerSchemeName, _that.getBrokerSchemeName())) return false;
			if (!Objects.equals(referenceEntityFormat, _that.getReferenceEntityFormat())) return false;
			if (!Objects.equals(clearingMemberIdentifierFormat, _that.getClearingMemberIdentifierFormat())) return false;
			if (!Objects.equals(clearingMemberSchemeName, _that.getClearingMemberSchemeName())) return false;
			if (!Objects.equals(priorUTIProprietarySchemeName, _that.getPriorUTIProprietarySchemeName())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietarySchemeName, _that.getUniqueTransactionIdentifierProprietarySchemeName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (basketConstituentNumberOfUnits != null ? basketConstituentNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (basketConstituentUnitOfMeasure != null ? basketConstituentUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (productDescription != null ? productDescription.hashCode() : 0);
			_result = 31 * _result + (beneficiary != null ? beneficiary.hashCode() : 0);
			_result = 31 * _result + (remarks != null ? remarks.hashCode() : 0);
			_result = 31 * _result + (remarks1 != null ? remarks1.hashCode() : 0);
			_result = 31 * _result + (remarks2 != null ? remarks2.hashCode() : 0);
			_result = 31 * _result + (remarks3 != null ? remarks3.hashCode() : 0);
			_result = 31 * _result + (remarks4 != null ? remarks4.hashCode() : 0);
			_result = 31 * _result + (remarks5 != null ? remarks5.hashCode() : 0);
			_result = 31 * _result + (remarks6 != null ? remarks6.hashCode() : 0);
			_result = 31 * _result + (remarks7 != null ? remarks7.hashCode() : 0);
			_result = 31 * _result + (remarks8 != null ? remarks8.hashCode() : 0);
			_result = 31 * _result + (remarks9 != null ? remarks9.hashCode() : 0);
			_result = 31 * _result + (remarks10 != null ? remarks10.hashCode() : 0);
			_result = 31 * _result + (remarks11 != null ? remarks11.hashCode() : 0);
			_result = 31 * _result + (remarks12 != null ? remarks12.hashCode() : 0);
			_result = 31 * _result + (remarks13 != null ? remarks13.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifierProprietary != null ? uniqueProductIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierFormat != null ? counterparty2IdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2SchemeName != null ? counterparty2SchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterpartyIdentifierFormat != null ? centralCounterpartyIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterpartySchemeName != null ? centralCounterpartySchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (brokerIdentifierFormat != null ? brokerIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (brokerSchemeName != null ? brokerSchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceEntityFormat != null ? referenceEntityFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingMemberIdentifierFormat != null ? clearingMemberIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingMemberSchemeName != null ? clearingMemberSchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priorUTIProprietarySchemeName != null ? priorUTIProprietarySchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietarySchemeName != null ? uniqueTransactionIdentifierProprietarySchemeName.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMATransactionReport {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"cleared=" + this.cleared + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"assetClass=" + this.assetClass + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"basketConstituentNumberOfUnits=" + this.basketConstituentNumberOfUnits + ", " +
				"basketConstituentUnitOfMeasure=" + this.basketConstituentUnitOfMeasure + ", " +
				"productDescription=" + this.productDescription + ", " +
				"beneficiary=" + this.beneficiary + ", " +
				"remarks=" + this.remarks + ", " +
				"remarks1=" + this.remarks1 + ", " +
				"remarks2=" + this.remarks2 + ", " +
				"remarks3=" + this.remarks3 + ", " +
				"remarks4=" + this.remarks4 + ", " +
				"remarks5=" + this.remarks5 + ", " +
				"remarks6=" + this.remarks6 + ", " +
				"remarks7=" + this.remarks7 + ", " +
				"remarks8=" + this.remarks8 + ", " +
				"remarks9=" + this.remarks9 + ", " +
				"remarks10=" + this.remarks10 + ", " +
				"remarks11=" + this.remarks11 + ", " +
				"remarks12=" + this.remarks12 + ", " +
				"remarks13=" + this.remarks13 + ", " +
				"uniqueProductIdentifierProprietary=" + this.uniqueProductIdentifierProprietary + ", " +
				"counterparty2IdentifierFormat=" + this.counterparty2IdentifierFormat + ", " +
				"counterparty2SchemeName=" + this.counterparty2SchemeName + ", " +
				"centralCounterpartyIdentifierFormat=" + this.centralCounterpartyIdentifierFormat + ", " +
				"centralCounterpartySchemeName=" + this.centralCounterpartySchemeName + ", " +
				"brokerIdentifierFormat=" + this.brokerIdentifierFormat + ", " +
				"brokerSchemeName=" + this.brokerSchemeName + ", " +
				"referenceEntityFormat=" + this.referenceEntityFormat + ", " +
				"clearingMemberIdentifierFormat=" + this.clearingMemberIdentifierFormat + ", " +
				"clearingMemberSchemeName=" + this.clearingMemberSchemeName + ", " +
				"priorUTIProprietarySchemeName=" + this.priorUTIProprietarySchemeName + ", " +
				"uniqueTransactionIdentifierProprietarySchemeName=" + this.uniqueTransactionIdentifierProprietarySchemeName +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of HKMATransactionReport  ***********************/
	class HKMATransactionReportBuilderImpl extends CommonTransactionReport.CommonTransactionReportBuilderImpl implements HKMATransactionReport.HKMATransactionReportBuilder {
	
		protected Boolean counterparty2IdentifierType;
		protected ClearedEnum cleared;
		protected ZonedDateTime eventTimestamp;
		protected String entityResponsibleForReporting;
		protected CommonAssetClass assetClass;
		protected String technicalRecordId;
		protected List<BigDecimal> basketConstituentNumberOfUnits = new ArrayList<>();
		protected List<String> basketConstituentUnitOfMeasure = new ArrayList<>();
		protected String productDescription;
		protected String beneficiary;
		protected String remarks;
		protected String remarks1;
		protected String remarks2;
		protected String remarks3;
		protected String remarks4;
		protected String remarks5;
		protected String remarks6;
		protected String remarks7;
		protected String remarks8;
		protected String remarks9;
		protected String remarks10;
		protected String remarks11;
		protected String remarks12;
		protected String remarks13;
		protected String uniqueProductIdentifierProprietary;
		protected PartyIdentifierFormat2Enum counterparty2IdentifierFormat;
		protected HKTRPartyScheme counterparty2SchemeName;
		protected PartyIdentifierFormat2Enum centralCounterpartyIdentifierFormat;
		protected HKTRPartyScheme centralCounterpartySchemeName;
		protected PartyIdentifierFormat2Enum brokerIdentifierFormat;
		protected HKTRPartyScheme brokerSchemeName;
		protected ReferenceEntityFormatEnum referenceEntityFormat;
		protected PartyIdentifierFormat2Enum clearingMemberIdentifierFormat;
		protected HKTRPartyScheme clearingMemberSchemeName;
		protected UTIProprietarySchemeNameEnum priorUTIProprietarySchemeName;
		protected UTIProprietarySchemeNameEnum uniqueTransactionIdentifierProprietarySchemeName;
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
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
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("basketConstituentNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituentNumberOfUnits")
		public List<BigDecimal> getBasketConstituentNumberOfUnits() {
			return basketConstituentNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("basketConstituentUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituentUnitOfMeasure")
		public List<String> getBasketConstituentUnitOfMeasure() {
			return basketConstituentUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("productDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productDescription")
		public String getProductDescription() {
			return productDescription;
		}
		
		@Override
		@RosettaAttribute("beneficiary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary")
		public String getBeneficiary() {
			return beneficiary;
		}
		
		@Override
		@RosettaAttribute("remarks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks")
		public String getRemarks() {
			return remarks;
		}
		
		@Override
		@RosettaAttribute("remarks1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks1")
		public String getRemarks1() {
			return remarks1;
		}
		
		@Override
		@RosettaAttribute("remarks2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks2")
		public String getRemarks2() {
			return remarks2;
		}
		
		@Override
		@RosettaAttribute("remarks3")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks3")
		public String getRemarks3() {
			return remarks3;
		}
		
		@Override
		@RosettaAttribute("remarks4")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks4")
		public String getRemarks4() {
			return remarks4;
		}
		
		@Override
		@RosettaAttribute("remarks5")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks5")
		public String getRemarks5() {
			return remarks5;
		}
		
		@Override
		@RosettaAttribute("remarks6")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks6")
		public String getRemarks6() {
			return remarks6;
		}
		
		@Override
		@RosettaAttribute("remarks7")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks7")
		public String getRemarks7() {
			return remarks7;
		}
		
		@Override
		@RosettaAttribute("remarks8")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks8")
		public String getRemarks8() {
			return remarks8;
		}
		
		@Override
		@RosettaAttribute("remarks9")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks9")
		public String getRemarks9() {
			return remarks9;
		}
		
		@Override
		@RosettaAttribute("remarks10")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks10")
		public String getRemarks10() {
			return remarks10;
		}
		
		@Override
		@RosettaAttribute("remarks11")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks11")
		public String getRemarks11() {
			return remarks11;
		}
		
		@Override
		@RosettaAttribute("remarks12")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks12")
		public String getRemarks12() {
			return remarks12;
		}
		
		@Override
		@RosettaAttribute("remarks13")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks13")
		public String getRemarks13() {
			return remarks13;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueProductIdentifierProprietary")
		public String getUniqueProductIdentifierProprietary() {
			return uniqueProductIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		public PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat() {
			return counterparty2IdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("counterparty2SchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2SchemeName")
		public HKTRPartyScheme getCounterparty2SchemeName() {
			return counterparty2SchemeName;
		}
		
		@Override
		@RosettaAttribute("centralCounterpartyIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterpartyIdentifierFormat")
		public PartyIdentifierFormat2Enum getCentralCounterpartyIdentifierFormat() {
			return centralCounterpartyIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("centralCounterpartySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterpartySchemeName")
		public HKTRPartyScheme getCentralCounterpartySchemeName() {
			return centralCounterpartySchemeName;
		}
		
		@Override
		@RosettaAttribute("brokerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerIdentifierFormat")
		public PartyIdentifierFormat2Enum getBrokerIdentifierFormat() {
			return brokerIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("brokerSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerSchemeName")
		public HKTRPartyScheme getBrokerSchemeName() {
			return brokerSchemeName;
		}
		
		@Override
		@RosettaAttribute("referenceEntityFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntityFormat")
		public ReferenceEntityFormatEnum getReferenceEntityFormat() {
			return referenceEntityFormat;
		}
		
		@Override
		@RosettaAttribute("clearingMemberIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMemberIdentifierFormat")
		public PartyIdentifierFormat2Enum getClearingMemberIdentifierFormat() {
			return clearingMemberIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("clearingMemberSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMemberSchemeName")
		public HKTRPartyScheme getClearingMemberSchemeName() {
			return clearingMemberSchemeName;
		}
		
		@Override
		@RosettaAttribute("priorUTIProprietarySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTIProprietarySchemeName")
		public UTIProprietarySchemeNameEnum getPriorUTIProprietarySchemeName() {
			return priorUTIProprietarySchemeName;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		public UTIProprietarySchemeNameEnum getUniqueTransactionIdentifierProprietarySchemeName() {
			return uniqueTransactionIdentifierProprietarySchemeName;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg1(CommonLeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg1(Leg _leg1) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg1(LegV2 _leg1) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg1(LegV1 _leg1) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg2(CommonLeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg2(Leg _leg2) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg2(LegV2 _leg2) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setLeg2(LegV1 _leg2) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEntityResponsibleForReportingOverriddenAsString(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			return setEntityResponsibleForReportingOverriddenAsString(_entityResponsibleForReporting);
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("assetClass")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setAssetClassOverriddenAsCommonAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setAssetClass(CommonAssetClass _assetClass) {
			return setAssetClassOverriddenAsCommonAssetClass(_assetClass);
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPackageIndicator(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketIndicator")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setTechnicalRecordIdOverriddenAsString(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			return setTechnicalRecordIdOverriddenAsString(_technicalRecordId);
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setNonReportable(NonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("basketConstituentNumberOfUnits")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituentNumberOfUnits")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentNumberOfUnits(BigDecimal _basketConstituentNumberOfUnits) {
			if (_basketConstituentNumberOfUnits != null) {
				this.basketConstituentNumberOfUnits.add(_basketConstituentNumberOfUnits);
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentNumberOfUnits(BigDecimal _basketConstituentNumberOfUnits, int idx) {
			getIndex(this.basketConstituentNumberOfUnits, idx, () -> _basketConstituentNumberOfUnits);
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentNumberOfUnits(List<BigDecimal> basketConstituentNumberOfUnitss) {
			if (basketConstituentNumberOfUnitss != null) {
				for (final BigDecimal toAdd : basketConstituentNumberOfUnitss) {
					this.basketConstituentNumberOfUnits.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituentNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketConstituentNumberOfUnits")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBasketConstituentNumberOfUnits(List<BigDecimal> basketConstituentNumberOfUnitss) {
			if (basketConstituentNumberOfUnitss == null) {
				this.basketConstituentNumberOfUnits = new ArrayList<>();
			} else {
				this.basketConstituentNumberOfUnits = basketConstituentNumberOfUnitss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituentUnitOfMeasure")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituentUnitOfMeasure")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentUnitOfMeasure(String _basketConstituentUnitOfMeasure) {
			if (_basketConstituentUnitOfMeasure != null) {
				this.basketConstituentUnitOfMeasure.add(_basketConstituentUnitOfMeasure);
			}
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentUnitOfMeasure(String _basketConstituentUnitOfMeasure, int idx) {
			getIndex(this.basketConstituentUnitOfMeasure, idx, () -> _basketConstituentUnitOfMeasure);
			return this;
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder addBasketConstituentUnitOfMeasure(List<String> basketConstituentUnitOfMeasures) {
			if (basketConstituentUnitOfMeasures != null) {
				for (final String toAdd : basketConstituentUnitOfMeasures) {
					this.basketConstituentUnitOfMeasure.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituentUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketConstituentUnitOfMeasure")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBasketConstituentUnitOfMeasure(List<String> basketConstituentUnitOfMeasures) {
			if (basketConstituentUnitOfMeasures == null) {
				this.basketConstituentUnitOfMeasure = new ArrayList<>();
			} else {
				this.basketConstituentUnitOfMeasure = basketConstituentUnitOfMeasures.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productDescription")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setProductDescription(String _productDescription) {
			this.productDescription = _productDescription == null ? null : _productDescription;
			return this;
		}
		
		@RosettaAttribute("beneficiary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBeneficiary(String _beneficiary) {
			this.beneficiary = _beneficiary == null ? null : _beneficiary;
			return this;
		}
		
		@RosettaAttribute("remarks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks(String _remarks) {
			this.remarks = _remarks == null ? null : _remarks;
			return this;
		}
		
		@RosettaAttribute("remarks1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks1")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks1(String _remarks1) {
			this.remarks1 = _remarks1 == null ? null : _remarks1;
			return this;
		}
		
		@RosettaAttribute("remarks2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks2")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks2(String _remarks2) {
			this.remarks2 = _remarks2 == null ? null : _remarks2;
			return this;
		}
		
		@RosettaAttribute("remarks3")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks3")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks3(String _remarks3) {
			this.remarks3 = _remarks3 == null ? null : _remarks3;
			return this;
		}
		
		@RosettaAttribute("remarks4")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks4")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks4(String _remarks4) {
			this.remarks4 = _remarks4 == null ? null : _remarks4;
			return this;
		}
		
		@RosettaAttribute("remarks5")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks5")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks5(String _remarks5) {
			this.remarks5 = _remarks5 == null ? null : _remarks5;
			return this;
		}
		
		@RosettaAttribute("remarks6")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks6")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks6(String _remarks6) {
			this.remarks6 = _remarks6 == null ? null : _remarks6;
			return this;
		}
		
		@RosettaAttribute("remarks7")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks7")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks7(String _remarks7) {
			this.remarks7 = _remarks7 == null ? null : _remarks7;
			return this;
		}
		
		@RosettaAttribute("remarks8")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks8")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks8(String _remarks8) {
			this.remarks8 = _remarks8 == null ? null : _remarks8;
			return this;
		}
		
		@RosettaAttribute("remarks9")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks9")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks9(String _remarks9) {
			this.remarks9 = _remarks9 == null ? null : _remarks9;
			return this;
		}
		
		@RosettaAttribute("remarks10")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks10")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks10(String _remarks10) {
			this.remarks10 = _remarks10 == null ? null : _remarks10;
			return this;
		}
		
		@RosettaAttribute("remarks11")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks11")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks11(String _remarks11) {
			this.remarks11 = _remarks11 == null ? null : _remarks11;
			return this;
		}
		
		@RosettaAttribute("remarks12")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks12")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks12(String _remarks12) {
			this.remarks12 = _remarks12 == null ? null : _remarks12;
			return this;
		}
		
		@RosettaAttribute("remarks13")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks13")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setRemarks13(String _remarks13) {
			this.remarks13 = _remarks13 == null ? null : _remarks13;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifierProprietary")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUniqueProductIdentifierProprietary(String _uniqueProductIdentifierProprietary) {
			this.uniqueProductIdentifierProprietary = _uniqueProductIdentifierProprietary == null ? null : _uniqueProductIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2IdentifierFormat(PartyIdentifierFormat2Enum _counterparty2IdentifierFormat) {
			this.counterparty2IdentifierFormat = _counterparty2IdentifierFormat == null ? null : _counterparty2IdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("counterparty2SchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2SchemeName")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCounterparty2SchemeName(HKTRPartyScheme _counterparty2SchemeName) {
			this.counterparty2SchemeName = _counterparty2SchemeName == null ? null : _counterparty2SchemeName;
			return this;
		}
		
		@RosettaAttribute("centralCounterpartyIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterpartyIdentifierFormat")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCentralCounterpartyIdentifierFormat(PartyIdentifierFormat2Enum _centralCounterpartyIdentifierFormat) {
			this.centralCounterpartyIdentifierFormat = _centralCounterpartyIdentifierFormat == null ? null : _centralCounterpartyIdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("centralCounterpartySchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterpartySchemeName")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setCentralCounterpartySchemeName(HKTRPartyScheme _centralCounterpartySchemeName) {
			this.centralCounterpartySchemeName = _centralCounterpartySchemeName == null ? null : _centralCounterpartySchemeName;
			return this;
		}
		
		@RosettaAttribute("brokerIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerIdentifierFormat")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBrokerIdentifierFormat(PartyIdentifierFormat2Enum _brokerIdentifierFormat) {
			this.brokerIdentifierFormat = _brokerIdentifierFormat == null ? null : _brokerIdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("brokerSchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerSchemeName")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setBrokerSchemeName(HKTRPartyScheme _brokerSchemeName) {
			this.brokerSchemeName = _brokerSchemeName == null ? null : _brokerSchemeName;
			return this;
		}
		
		@RosettaAttribute("referenceEntityFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntityFormat")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setReferenceEntityFormat(ReferenceEntityFormatEnum _referenceEntityFormat) {
			this.referenceEntityFormat = _referenceEntityFormat == null ? null : _referenceEntityFormat;
			return this;
		}
		
		@RosettaAttribute("clearingMemberIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMemberIdentifierFormat")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingMemberIdentifierFormat(PartyIdentifierFormat2Enum _clearingMemberIdentifierFormat) {
			this.clearingMemberIdentifierFormat = _clearingMemberIdentifierFormat == null ? null : _clearingMemberIdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("clearingMemberSchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMemberSchemeName")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setClearingMemberSchemeName(HKTRPartyScheme _clearingMemberSchemeName) {
			this.clearingMemberSchemeName = _clearingMemberSchemeName == null ? null : _clearingMemberSchemeName;
			return this;
		}
		
		@RosettaAttribute("priorUTIProprietarySchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietarySchemeName")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setPriorUTIProprietarySchemeName(UTIProprietarySchemeNameEnum _priorUTIProprietarySchemeName) {
			this.priorUTIProprietarySchemeName = _priorUTIProprietarySchemeName == null ? null : _priorUTIProprietarySchemeName;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder setUniqueTransactionIdentifierProprietarySchemeName(UTIProprietarySchemeNameEnum _uniqueTransactionIdentifierProprietarySchemeName) {
			this.uniqueTransactionIdentifierProprietarySchemeName = _uniqueTransactionIdentifierProprietarySchemeName == null ? null : _uniqueTransactionIdentifierProprietarySchemeName;
			return this;
		}
		
		@Override
		public HKMATransactionReport build() {
			return new HKMATransactionReport.HKMATransactionReportImpl(this);
		}
		
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getCleared()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getAssetClass()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getBasketConstituentNumberOfUnits()!=null && !getBasketConstituentNumberOfUnits().isEmpty()) return true;
			if (getBasketConstituentUnitOfMeasure()!=null && !getBasketConstituentUnitOfMeasure().isEmpty()) return true;
			if (getProductDescription()!=null) return true;
			if (getBeneficiary()!=null) return true;
			if (getRemarks()!=null) return true;
			if (getRemarks1()!=null) return true;
			if (getRemarks2()!=null) return true;
			if (getRemarks3()!=null) return true;
			if (getRemarks4()!=null) return true;
			if (getRemarks5()!=null) return true;
			if (getRemarks6()!=null) return true;
			if (getRemarks7()!=null) return true;
			if (getRemarks8()!=null) return true;
			if (getRemarks9()!=null) return true;
			if (getRemarks10()!=null) return true;
			if (getRemarks11()!=null) return true;
			if (getRemarks12()!=null) return true;
			if (getRemarks13()!=null) return true;
			if (getUniqueProductIdentifierProprietary()!=null) return true;
			if (getCounterparty2IdentifierFormat()!=null) return true;
			if (getCounterparty2SchemeName()!=null) return true;
			if (getCentralCounterpartyIdentifierFormat()!=null) return true;
			if (getCentralCounterpartySchemeName()!=null) return true;
			if (getBrokerIdentifierFormat()!=null) return true;
			if (getBrokerSchemeName()!=null) return true;
			if (getReferenceEntityFormat()!=null) return true;
			if (getClearingMemberIdentifierFormat()!=null) return true;
			if (getClearingMemberSchemeName()!=null) return true;
			if (getPriorUTIProprietarySchemeName()!=null) return true;
			if (getUniqueTransactionIdentifierProprietarySchemeName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMATransactionReport.HKMATransactionReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			HKMATransactionReport.HKMATransactionReportBuilder o = (HKMATransactionReport.HKMATransactionReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setClearedOverriddenAsClearedEnum);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReportingOverriddenAsString);
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClassOverriddenAsCommonAssetClass);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordIdOverriddenAsString);
			merger.mergeBasic(getBasketConstituentNumberOfUnits(), o.getBasketConstituentNumberOfUnits(), (Consumer<BigDecimal>) this::addBasketConstituentNumberOfUnits);
			merger.mergeBasic(getBasketConstituentUnitOfMeasure(), o.getBasketConstituentUnitOfMeasure(), (Consumer<String>) this::addBasketConstituentUnitOfMeasure);
			merger.mergeBasic(getProductDescription(), o.getProductDescription(), this::setProductDescription);
			merger.mergeBasic(getBeneficiary(), o.getBeneficiary(), this::setBeneficiary);
			merger.mergeBasic(getRemarks(), o.getRemarks(), this::setRemarks);
			merger.mergeBasic(getRemarks1(), o.getRemarks1(), this::setRemarks1);
			merger.mergeBasic(getRemarks2(), o.getRemarks2(), this::setRemarks2);
			merger.mergeBasic(getRemarks3(), o.getRemarks3(), this::setRemarks3);
			merger.mergeBasic(getRemarks4(), o.getRemarks4(), this::setRemarks4);
			merger.mergeBasic(getRemarks5(), o.getRemarks5(), this::setRemarks5);
			merger.mergeBasic(getRemarks6(), o.getRemarks6(), this::setRemarks6);
			merger.mergeBasic(getRemarks7(), o.getRemarks7(), this::setRemarks7);
			merger.mergeBasic(getRemarks8(), o.getRemarks8(), this::setRemarks8);
			merger.mergeBasic(getRemarks9(), o.getRemarks9(), this::setRemarks9);
			merger.mergeBasic(getRemarks10(), o.getRemarks10(), this::setRemarks10);
			merger.mergeBasic(getRemarks11(), o.getRemarks11(), this::setRemarks11);
			merger.mergeBasic(getRemarks12(), o.getRemarks12(), this::setRemarks12);
			merger.mergeBasic(getRemarks13(), o.getRemarks13(), this::setRemarks13);
			merger.mergeBasic(getUniqueProductIdentifierProprietary(), o.getUniqueProductIdentifierProprietary(), this::setUniqueProductIdentifierProprietary);
			merger.mergeBasic(getCounterparty2IdentifierFormat(), o.getCounterparty2IdentifierFormat(), this::setCounterparty2IdentifierFormat);
			merger.mergeBasic(getCounterparty2SchemeName(), o.getCounterparty2SchemeName(), this::setCounterparty2SchemeName);
			merger.mergeBasic(getCentralCounterpartyIdentifierFormat(), o.getCentralCounterpartyIdentifierFormat(), this::setCentralCounterpartyIdentifierFormat);
			merger.mergeBasic(getCentralCounterpartySchemeName(), o.getCentralCounterpartySchemeName(), this::setCentralCounterpartySchemeName);
			merger.mergeBasic(getBrokerIdentifierFormat(), o.getBrokerIdentifierFormat(), this::setBrokerIdentifierFormat);
			merger.mergeBasic(getBrokerSchemeName(), o.getBrokerSchemeName(), this::setBrokerSchemeName);
			merger.mergeBasic(getReferenceEntityFormat(), o.getReferenceEntityFormat(), this::setReferenceEntityFormat);
			merger.mergeBasic(getClearingMemberIdentifierFormat(), o.getClearingMemberIdentifierFormat(), this::setClearingMemberIdentifierFormat);
			merger.mergeBasic(getClearingMemberSchemeName(), o.getClearingMemberSchemeName(), this::setClearingMemberSchemeName);
			merger.mergeBasic(getPriorUTIProprietarySchemeName(), o.getPriorUTIProprietarySchemeName(), this::setPriorUTIProprietarySchemeName);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietarySchemeName(), o.getUniqueTransactionIdentifierProprietarySchemeName(), this::setUniqueTransactionIdentifierProprietarySchemeName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			HKMATransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!ListEquals.listEquals(basketConstituentNumberOfUnits, _that.getBasketConstituentNumberOfUnits())) return false;
			if (!ListEquals.listEquals(basketConstituentUnitOfMeasure, _that.getBasketConstituentUnitOfMeasure())) return false;
			if (!Objects.equals(productDescription, _that.getProductDescription())) return false;
			if (!Objects.equals(beneficiary, _that.getBeneficiary())) return false;
			if (!Objects.equals(remarks, _that.getRemarks())) return false;
			if (!Objects.equals(remarks1, _that.getRemarks1())) return false;
			if (!Objects.equals(remarks2, _that.getRemarks2())) return false;
			if (!Objects.equals(remarks3, _that.getRemarks3())) return false;
			if (!Objects.equals(remarks4, _that.getRemarks4())) return false;
			if (!Objects.equals(remarks5, _that.getRemarks5())) return false;
			if (!Objects.equals(remarks6, _that.getRemarks6())) return false;
			if (!Objects.equals(remarks7, _that.getRemarks7())) return false;
			if (!Objects.equals(remarks8, _that.getRemarks8())) return false;
			if (!Objects.equals(remarks9, _that.getRemarks9())) return false;
			if (!Objects.equals(remarks10, _that.getRemarks10())) return false;
			if (!Objects.equals(remarks11, _that.getRemarks11())) return false;
			if (!Objects.equals(remarks12, _that.getRemarks12())) return false;
			if (!Objects.equals(remarks13, _that.getRemarks13())) return false;
			if (!Objects.equals(uniqueProductIdentifierProprietary, _that.getUniqueProductIdentifierProprietary())) return false;
			if (!Objects.equals(counterparty2IdentifierFormat, _that.getCounterparty2IdentifierFormat())) return false;
			if (!Objects.equals(counterparty2SchemeName, _that.getCounterparty2SchemeName())) return false;
			if (!Objects.equals(centralCounterpartyIdentifierFormat, _that.getCentralCounterpartyIdentifierFormat())) return false;
			if (!Objects.equals(centralCounterpartySchemeName, _that.getCentralCounterpartySchemeName())) return false;
			if (!Objects.equals(brokerIdentifierFormat, _that.getBrokerIdentifierFormat())) return false;
			if (!Objects.equals(brokerSchemeName, _that.getBrokerSchemeName())) return false;
			if (!Objects.equals(referenceEntityFormat, _that.getReferenceEntityFormat())) return false;
			if (!Objects.equals(clearingMemberIdentifierFormat, _that.getClearingMemberIdentifierFormat())) return false;
			if (!Objects.equals(clearingMemberSchemeName, _that.getClearingMemberSchemeName())) return false;
			if (!Objects.equals(priorUTIProprietarySchemeName, _that.getPriorUTIProprietarySchemeName())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietarySchemeName, _that.getUniqueTransactionIdentifierProprietarySchemeName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (basketConstituentNumberOfUnits != null ? basketConstituentNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (basketConstituentUnitOfMeasure != null ? basketConstituentUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (productDescription != null ? productDescription.hashCode() : 0);
			_result = 31 * _result + (beneficiary != null ? beneficiary.hashCode() : 0);
			_result = 31 * _result + (remarks != null ? remarks.hashCode() : 0);
			_result = 31 * _result + (remarks1 != null ? remarks1.hashCode() : 0);
			_result = 31 * _result + (remarks2 != null ? remarks2.hashCode() : 0);
			_result = 31 * _result + (remarks3 != null ? remarks3.hashCode() : 0);
			_result = 31 * _result + (remarks4 != null ? remarks4.hashCode() : 0);
			_result = 31 * _result + (remarks5 != null ? remarks5.hashCode() : 0);
			_result = 31 * _result + (remarks6 != null ? remarks6.hashCode() : 0);
			_result = 31 * _result + (remarks7 != null ? remarks7.hashCode() : 0);
			_result = 31 * _result + (remarks8 != null ? remarks8.hashCode() : 0);
			_result = 31 * _result + (remarks9 != null ? remarks9.hashCode() : 0);
			_result = 31 * _result + (remarks10 != null ? remarks10.hashCode() : 0);
			_result = 31 * _result + (remarks11 != null ? remarks11.hashCode() : 0);
			_result = 31 * _result + (remarks12 != null ? remarks12.hashCode() : 0);
			_result = 31 * _result + (remarks13 != null ? remarks13.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifierProprietary != null ? uniqueProductIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierFormat != null ? counterparty2IdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2SchemeName != null ? counterparty2SchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterpartyIdentifierFormat != null ? centralCounterpartyIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterpartySchemeName != null ? centralCounterpartySchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (brokerIdentifierFormat != null ? brokerIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (brokerSchemeName != null ? brokerSchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceEntityFormat != null ? referenceEntityFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingMemberIdentifierFormat != null ? clearingMemberIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingMemberSchemeName != null ? clearingMemberSchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priorUTIProprietarySchemeName != null ? priorUTIProprietarySchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietarySchemeName != null ? uniqueTransactionIdentifierProprietarySchemeName.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMATransactionReportBuilder {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"cleared=" + this.cleared + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"assetClass=" + this.assetClass + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"basketConstituentNumberOfUnits=" + this.basketConstituentNumberOfUnits + ", " +
				"basketConstituentUnitOfMeasure=" + this.basketConstituentUnitOfMeasure + ", " +
				"productDescription=" + this.productDescription + ", " +
				"beneficiary=" + this.beneficiary + ", " +
				"remarks=" + this.remarks + ", " +
				"remarks1=" + this.remarks1 + ", " +
				"remarks2=" + this.remarks2 + ", " +
				"remarks3=" + this.remarks3 + ", " +
				"remarks4=" + this.remarks4 + ", " +
				"remarks5=" + this.remarks5 + ", " +
				"remarks6=" + this.remarks6 + ", " +
				"remarks7=" + this.remarks7 + ", " +
				"remarks8=" + this.remarks8 + ", " +
				"remarks9=" + this.remarks9 + ", " +
				"remarks10=" + this.remarks10 + ", " +
				"remarks11=" + this.remarks11 + ", " +
				"remarks12=" + this.remarks12 + ", " +
				"remarks13=" + this.remarks13 + ", " +
				"uniqueProductIdentifierProprietary=" + this.uniqueProductIdentifierProprietary + ", " +
				"counterparty2IdentifierFormat=" + this.counterparty2IdentifierFormat + ", " +
				"counterparty2SchemeName=" + this.counterparty2SchemeName + ", " +
				"centralCounterpartyIdentifierFormat=" + this.centralCounterpartyIdentifierFormat + ", " +
				"centralCounterpartySchemeName=" + this.centralCounterpartySchemeName + ", " +
				"brokerIdentifierFormat=" + this.brokerIdentifierFormat + ", " +
				"brokerSchemeName=" + this.brokerSchemeName + ", " +
				"referenceEntityFormat=" + this.referenceEntityFormat + ", " +
				"clearingMemberIdentifierFormat=" + this.clearingMemberIdentifierFormat + ", " +
				"clearingMemberSchemeName=" + this.clearingMemberSchemeName + ", " +
				"priorUTIProprietarySchemeName=" + this.priorUTIProprietarySchemeName + ", " +
				"uniqueTransactionIdentifierProprietarySchemeName=" + this.uniqueTransactionIdentifierProprietarySchemeName +
			'}' + " " + super.toString();
		}
	}
}
