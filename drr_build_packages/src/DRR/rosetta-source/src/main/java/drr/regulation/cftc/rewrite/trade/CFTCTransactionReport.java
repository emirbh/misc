package drr.regulation.cftc.rewrite.trade;

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
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.meta.CFTCTransactionReportMeta;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
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
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CFTCTransactionReport", builder=CFTCTransactionReport.CFTCTransactionReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CFTCTransactionReport", model="drr", builder=CFTCTransactionReport.CFTCTransactionReportBuilderImpl.class, version="7.7.0")
public interface CFTCTransactionReport extends CommonTransactionReport {

	CFTCTransactionReportMeta metaData = new CFTCTransactionReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "1" * field "Cleared"
	 *
	 * Provision Indicator of whether the transaction has been cleared, or is intended to be cleared, by a central counterparty.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "1" * field "Cleared" * footnote "14"
	 *
	 * Provision Throughout this Technical Specification, references to 'central counterparty' in CDE data elements should be read to mean 'derivatives clearing organizations' and 'exempt derivatives clearing organizations'.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "1" * field "Cleared" * footnote "15"
	 *
	 * Provision Throughout this Technical Specification, references to 'beta and gamma transactions' in CDE data elements should be read to mean 'clearing swaps'.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "1" * field "Cleared" * footnote "16"
	 *
	 * Provision Throughout this Technical Specification, references to 'alpha transactions' in CDE data elements should be read to mean 'original swaps'.
	 *
	 */
	@Override
	ClearedEnum getCleared();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "7"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 2 "Version 2 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 2) includes certain revisions and new data elements to the April 2018 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "7"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty.
	               - Format:
	               - Char(20), for an LEI code
	               - Varchar(72), for natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity)
	               - Allowable values:
	               - LEI code that is included in the LEI data as published by the Global LEI Foundation (GLEIF, www.gleif.org/).
	               - For natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity: LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "7"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty. However, if the allocation of the block trade to specific funds does not take place prior to the reporting deadline, then the fund manager executing the transaction on behalf of the fund can be reported as the counterparty.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "14" * field "Counterparty 2"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund, and not the fund manager is reported as the counterparty.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "14" * field "Counterparty 2" * footnote "26"
	 *
	 * Provision In the case of a swap transaction for pre-allocated block executed by a fund manager on behalf of a fund, the fund manager is reported as the counterparty.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "14" * field "Counterparty 2" * footnote "27"
	 *
	 * Provision Only one counterparty should be reported. In cases where multiple counterparties are legally responsible as the second counterparty (such as an obligated group, for example), report only one of the counterparties and use the
	             same counterparty for all continuation data and lifecycle events.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "14" * field "Counterparty 2" * footnote "28"
	 *
	 * Provision ROC Statement  Individuals Acting in a Business Capacity, ROC Statement - Individuals Acting in a Business Capacity
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "14" * field "Counterparty 2" * footnote "29"
	 *
	 * Provision Throughout this Technical Specification, Privacy Law Identifier (PLI) has been added as an allowable value for all Counterparty 2 (#14) associated data elements
	 *
	 */
	@Override
	String getCounterparty2();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "30" * field "Event Timestamp"
	 *
	 * Provision Date and time of occurrence of the event as determined by the reporting counterparty or a service provider. In the case of a clearing event, date and time when the original swap is accepted by the derivative clearing organization (DCO) for clearing and recorded by the DCOs system should be reported in this data element. The time element is as specific as technologically practicable.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "30" * field "Event Timestamp" * footnote "38"
	 *
	 * Provision In the case of collateral update (Action type = 'MARU'), this is the date for which the information contained in the report is provided. Time portion should be reported as '00:00:00'.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_2 CFTC 17 CFR Parts 45 Version 3.2 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications in Version 3.2 of the CFTC Technical Specification are: Implement UPI for credit, equity, foreign exchange, and interest rate asset classes to continue aligning reporting requirements with international standards developed by the CFTC and other global regulators; and Provide clarity to market participants with respect to compliance obligations." 
	 * appendix "1" * dataElement "30" * field "Event Timestamp" * footnote "39"
	 *
	 * Provision Both the date and time portion are required to be reported. If the time portion is not available, report '00:00:00' for the time portion.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240117"
	 *
	 * Provision DRR users are expected to use eventCreationDateTime as qualifier to the timestamp they have to report as the Event Timestamp
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "94" * field "Effective Date"
	 *
	 * Provision Unadjusted date at which obligations under the OTC derivative transaction come into effect, as included in the confirmation.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_1 CFTC 17 CFR Parts 45 Version 3.1 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications address 14 data elements for several swap data reporting topics including: clearing, counterparty identification, price, valuation, collateral and margin, and transaction-related data fields." 
	 * appendix "1" * dataElement "94" * field "Effective Date" * footnote "70"
	 *
	 * Provision For commodities swaps, report the pricing start date.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20230120"
	 *
	 * Provision For options the obligations under the OTC Derivative Transaction come into effect on the Trade Date. A fall back should be added to CDE Effective Date which handles effective date in this way when no specific effective date is specified.
	 *
	 */
	@Override
	Date getEffectiveDate();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "96" * field "Execution Timestamp"
	 *
	 * Provision Date and time a transaction was originally executed, resulting in the generation of a new UTI. This data element remains unchanged throughout the life of the UTI.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_1 CFTC 17 CFR Parts 45 Version 3.1 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications address 14 data elements for several swap data reporting topics including: clearing, counterparty identification, price, valuation, collateral and margin, and transaction-related data fields." 
	 * appendix "1" * dataElement "96" * field "Execution Timestamp" * footnote "72"
	 *
	 * Provision For clearing swaps, the execution timestamp is the date and time when the DCO accepts the original swap.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_1 CFTC 17 CFR Parts 45 Version 3.1 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications address 14 data elements for several swap data reporting topics including: clearing, counterparty identification, price, valuation, collateral and margin, and transaction-related data fields." 
	 * appendix "1" * dataElement "96" * field "Execution Timestamp" * footnote "73"
	 *
	 * Provision Both the date and time portion are required to be reported.
	 *
	 */
	@Override
	ZonedDateTime getExecutionTimestamp();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "45" * field "Package Indicator"
	 *
	 * Provision Indicator of whether the swap transaction is part of a package transaction.
	 *
	 */
	@Override
	Boolean getPackageIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "15" * field "Counterparty 2 Identifier Source"
	 *
	 * Provision Source used to identify the Counterparty 2.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_1 CFTC 17 CFR Parts 45 Version 3.1 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications address 14 data elements for several swap data reporting topics including: clearing, counterparty identification, price, valuation, collateral and margin, and transaction-related data fields." 
	 * appendix "1" * dataElement "15" * field "Counterparty 2 Identifier Source" * footnote "30"
	 *
	 * Provision Throughout this Technical Specification, for references to 'Privacy Law Identifiers', refer to DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf
	 *
	 */
	@Override
	Counterparty2IdentifierEnum getCounterparty2IdentifierSource();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "25" * field "Custom Basket Indicator"
	 *
	 * Provision Indicator of whether the swap transaction is based on a custom basket.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup USComplianceGroup US Compliance Working Group "This is an ISDA US Working Group." 
	 * date "20220429"
	 *
	 * Provision The US Compliance WG agree on this consistent definition for reporting #25 Custom Basket Indicator. The definition can be used for all 5 asset classes. For purposes of reporting Custom Basket Indicator (CFTC #25), market participants generally refer to a trade as being a custom basket if it is tailored for a specific client, either by the client, by the Swap Dealer, or by both, where the weightings, constituents, roll schedules, etc., are agreed bilaterally with the client and are customized for that specific client. Custom baskets can be in any of the 5 asset classes, which is also reflected in CFTCs validation rule for #25.
	 *
	 */
	@Override
	Boolean getCustomBasketIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "68" * field "Post-priced Swap Indicator"
	 *
	 * Provision Indicator of whether the swap transaction satisfies the definition of 'post-priced swap' in  43.2(a) of the Commission's regulations.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_1 CFTC 17 CFR Parts 45 Version 3.1 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications address 14 data elements for several swap data reporting topics including: clearing, counterparty identification, price, valuation, collateral and margin, and transaction-related data fields." 
	 * appendix "1" * dataElement "68" * field "Post-priced Swap Indicator" * footnote "59"
	 *
	 * Provision For transactions where the swap price is not known at the time to execution, those unknown swap price-related fields can be reported as blank until such time that the price is known.
	 *
	 */
	Boolean getPostPricedSwapIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "93" * field "Block Trade Election Indicator"
	 *
	 * Provision Indicator of whether an election has been made to report the swap transaction as a block transaction by the reporting counterparty or as calculated by either the swap data repository acting on behalf of the reporting counterparty or by using a third party.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup ISDAWorkingGroup ISDA Working Group "This is an ISDA Working Group." 
	 * date "20220420"
	 *
	 * Provision If blockTradeIndicator is not present then report as false
	 *
	 */
	Boolean getBlockTradeElectionIndicator();
	Boolean getPrimeBrokerageTransactionIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Regulation Part45 CFTC 17 CFR Parts 45 Version 3.0 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR)" 
	 * appendix "1" * dataElement "102" * field "Unique Swap Identifier (USI)"
	 *
	 * Provision The USI is a unique identifier assigned to all swap transactions which identifies the transaction (the swap and its counterparties) uniquely throughout its duration. It consists of a namespace and a transaction identifier.
	 *
	 *
	 * Body CFTC
	 * Corpus Regulation Part45_V3_1 CFTC 17 CFR Parts 45 Version 3.1 "Part 45 of the CFTCs regulations specifies the Commissions swap data recordkeeping and reporting requirements, pursuant to section 2(a)(13)(G) of the Commodity Exchange Act (CEA), which states that all swaps, whether cleared or uncleared, must be reported to a Swap Data Repository (SDR).The modifications address 14 data elements for several swap data reporting topics including: clearing, counterparty identification, price, valuation, collateral and margin, and transaction-related data fields." 
	 * appendix "1" * dataElement "102" * field "Unique Swap Identifier (USI)" * footnote "76"
	 *
	 * Provision Throughout this Technical Specification, references to 'CFTC USI Data Standard' should refer to the USI Data Standard, https://www.cftc.gov/sites/default/files/idc/groups/public/@swaps/documents/dfsubmission/usidatastandards100112.pdf
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220309"
	 *
	 * Provision Rule does not model UTI > USI priority defined in CFTC specification.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220309"
	 *
	 * Provision Firms do expect to report USI/UTI in both formats: as a single identifier field as well as using Issuer + identifier. The functional model needs to handle both scenarios.
	 *
	 */
	String getUniqueSwapIdentifier();
	DTCCAdditionalFields getDtccAdditionalFields();

	/*********************** Build Methods  ***********************/
	CFTCTransactionReport build();
	
	CFTCTransactionReport.CFTCTransactionReportBuilder toBuilder();
	
	static CFTCTransactionReport.CFTCTransactionReportBuilder builder() {
		return new CFTCTransactionReport.CFTCTransactionReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CFTCTransactionReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CFTCTransactionReport> getType() {
		return CFTCTransactionReport.class;
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
		processor.processBasic(path.newSubPath("postPricedSwapIndicator"), Boolean.class, getPostPricedSwapIndicator(), this);
		processor.processBasic(path.newSubPath("blockTradeElectionIndicator"), Boolean.class, getBlockTradeElectionIndicator(), this);
		processor.processBasic(path.newSubPath("primeBrokerageTransactionIndicator"), Boolean.class, getPrimeBrokerageTransactionIndicator(), this);
		processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
		processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.class, getDtccAdditionalFields());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CFTCTransactionReportBuilder extends CFTCTransactionReport, CommonTransactionReport.CommonTransactionReportBuilder {
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getOrCreateDtccAdditionalFields();
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getDtccAdditionalFields();
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEffectiveDate(Date effectiveDate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setExpirationDate(Date expirationDate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty1(String counterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2(String counterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBeneficiary1(String beneficiary1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCleared(ClearedEnum cleared);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearingMember(String clearingMember);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCallAmount(BigDecimal callAmount);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPutAmount(BigDecimal putAmount);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setDelta(BigDecimal delta);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPrice(PriceFormat price);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriorUTI(String priorUTI);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setDirection1(Direction1Enum direction1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCustomBasketCode(String customBasketCode);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(LegV1 leg1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(LegV1 leg2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(LegV2 leg1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(LegV2 leg2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(Leg leg1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(Leg leg2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLevel(ReportLevelEnum level);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEventType(EventTypeEnum eventType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEventIdentifier(String eventIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(CommonLeg leg1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(CommonLeg leg2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBrokerID(String brokerID);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setContractType(CommonContractType contractType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOptionType(OptionTypeCode optionType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setIntragroup(Boolean intragroup);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSwapLinkID(String swapLinkID);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setPriorUSI(String priorUSI);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setReferenceEntity(String referenceEntity);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSeniority(SeniorityEnum seniority);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSeries(Integer series);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBaseProduct(String baseProduct);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setSubProduct(String subProduct);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		CFTCTransactionReport.CFTCTransactionReportBuilder setNonReportable(NonReportable nonReportable);
		CFTCTransactionReport.CFTCTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2OverriddenAsString(String counterparty2);
		CFTCTransactionReport.CFTCTransactionReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		CFTCTransactionReport.CFTCTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date effectiveDate);
		CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime executionTimestamp);
		CFTCTransactionReport.CFTCTransactionReportBuilder setPackageIndicatorOverriddenAsBoolean(Boolean packageIndicator);
		CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		CFTCTransactionReport.CFTCTransactionReportBuilder setCustomBasketIndicatorOverriddenAsBoolean(Boolean customBasketIndicator);
		CFTCTransactionReport.CFTCTransactionReportBuilder setPostPricedSwapIndicator(Boolean postPricedSwapIndicator);
		CFTCTransactionReport.CFTCTransactionReportBuilder setBlockTradeElectionIndicator(Boolean blockTradeElectionIndicator);
		CFTCTransactionReport.CFTCTransactionReportBuilder setPrimeBrokerageTransactionIndicator(Boolean primeBrokerageTransactionIndicator);
		CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueSwapIdentifier(String uniqueSwapIdentifier);
		CFTCTransactionReport.CFTCTransactionReportBuilder setDtccAdditionalFields(DTCCAdditionalFields dtccAdditionalFields);

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
			processor.processBasic(path.newSubPath("postPricedSwapIndicator"), Boolean.class, getPostPricedSwapIndicator(), this);
			processor.processBasic(path.newSubPath("blockTradeElectionIndicator"), Boolean.class, getBlockTradeElectionIndicator(), this);
			processor.processBasic(path.newSubPath("primeBrokerageTransactionIndicator"), Boolean.class, getPrimeBrokerageTransactionIndicator(), this);
			processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
			processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.DTCCAdditionalFieldsBuilder.class, getDtccAdditionalFields());
		}
		

		CFTCTransactionReport.CFTCTransactionReportBuilder prune();
	}

	/*********************** Immutable Implementation of CFTCTransactionReport  ***********************/
	class CFTCTransactionReportImpl extends CommonTransactionReport.CommonTransactionReportImpl implements CFTCTransactionReport {
		private final ClearedEnum cleared;
		private final String counterparty2;
		private final ZonedDateTime eventTimestamp;
		private final Date effectiveDate;
		private final ZonedDateTime executionTimestamp;
		private final Boolean packageIndicator;
		private final Counterparty2IdentifierEnum counterparty2IdentifierSource;
		private final Boolean customBasketIndicator;
		private final Boolean postPricedSwapIndicator;
		private final Boolean blockTradeElectionIndicator;
		private final Boolean primeBrokerageTransactionIndicator;
		private final String uniqueSwapIdentifier;
		private final DTCCAdditionalFields dtccAdditionalFields;
		
		protected CFTCTransactionReportImpl(CFTCTransactionReport.CFTCTransactionReportBuilder builder) {
			super(builder);
			this.cleared = builder.getCleared();
			this.counterparty2 = builder.getCounterparty2();
			this.eventTimestamp = builder.getEventTimestamp();
			this.effectiveDate = builder.getEffectiveDate();
			this.executionTimestamp = builder.getExecutionTimestamp();
			this.packageIndicator = builder.getPackageIndicator();
			this.counterparty2IdentifierSource = builder.getCounterparty2IdentifierSource();
			this.customBasketIndicator = builder.getCustomBasketIndicator();
			this.postPricedSwapIndicator = builder.getPostPricedSwapIndicator();
			this.blockTradeElectionIndicator = builder.getBlockTradeElectionIndicator();
			this.primeBrokerageTransactionIndicator = builder.getPrimeBrokerageTransactionIndicator();
			this.uniqueSwapIdentifier = builder.getUniqueSwapIdentifier();
			this.dtccAdditionalFields = ofNullable(builder.getDtccAdditionalFields()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
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
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
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
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("packageIndicator")
		public Boolean getPackageIndicator() {
			return packageIndicator;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public Counterparty2IdentifierEnum getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		public Boolean getCustomBasketIndicator() {
			return customBasketIndicator;
		}
		
		@Override
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		public Boolean getPostPricedSwapIndicator() {
			return postPricedSwapIndicator;
		}
		
		@Override
		@RosettaAttribute("blockTradeElectionIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("blockTradeElectionIndicator")
		public Boolean getBlockTradeElectionIndicator() {
			return blockTradeElectionIndicator;
		}
		
		@Override
		@RosettaAttribute("primeBrokerageTransactionIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primeBrokerageTransactionIndicator")
		public Boolean getPrimeBrokerageTransactionIndicator() {
			return primeBrokerageTransactionIndicator;
		}
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public String getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtccAdditionalFields")
		public DTCCAdditionalFields getDtccAdditionalFields() {
			return dtccAdditionalFields;
		}
		
		@Override
		public CFTCTransactionReport build() {
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder toBuilder() {
			CFTCTransactionReport.CFTCTransactionReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CFTCTransactionReport.CFTCTransactionReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCleared()).ifPresent(builder::setClearedOverriddenAsClearedEnum);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2OverriddenAsString);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDateOverriddenAsDate);
			ofNullable(getExecutionTimestamp()).ifPresent(builder::setExecutionTimestampOverriddenAsZonedDateTime);
			ofNullable(getPackageIndicator()).ifPresent(builder::setPackageIndicatorOverriddenAsBoolean);
			ofNullable(getCounterparty2IdentifierSource()).ifPresent(builder::setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum);
			ofNullable(getCustomBasketIndicator()).ifPresent(builder::setCustomBasketIndicatorOverriddenAsBoolean);
			ofNullable(getPostPricedSwapIndicator()).ifPresent(builder::setPostPricedSwapIndicator);
			ofNullable(getBlockTradeElectionIndicator()).ifPresent(builder::setBlockTradeElectionIndicator);
			ofNullable(getPrimeBrokerageTransactionIndicator()).ifPresent(builder::setPrimeBrokerageTransactionIndicator);
			ofNullable(getUniqueSwapIdentifier()).ifPresent(builder::setUniqueSwapIdentifier);
			ofNullable(getDtccAdditionalFields()).ifPresent(builder::setDtccAdditionalFields);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(packageIndicator, _that.getPackageIndicator())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(customBasketIndicator, _that.getCustomBasketIndicator())) return false;
			if (!Objects.equals(postPricedSwapIndicator, _that.getPostPricedSwapIndicator())) return false;
			if (!Objects.equals(blockTradeElectionIndicator, _that.getBlockTradeElectionIndicator())) return false;
			if (!Objects.equals(primeBrokerageTransactionIndicator, _that.getPrimeBrokerageTransactionIndicator())) return false;
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			if (!Objects.equals(dtccAdditionalFields, _that.getDtccAdditionalFields())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (packageIndicator != null ? packageIndicator.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customBasketIndicator != null ? customBasketIndicator.hashCode() : 0);
			_result = 31 * _result + (postPricedSwapIndicator != null ? postPricedSwapIndicator.hashCode() : 0);
			_result = 31 * _result + (blockTradeElectionIndicator != null ? blockTradeElectionIndicator.hashCode() : 0);
			_result = 31 * _result + (primeBrokerageTransactionIndicator != null ? primeBrokerageTransactionIndicator.hashCode() : 0);
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			_result = 31 * _result + (dtccAdditionalFields != null ? dtccAdditionalFields.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCTransactionReport {" +
				"cleared=" + this.cleared + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"packageIndicator=" + this.packageIndicator + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"customBasketIndicator=" + this.customBasketIndicator + ", " +
				"postPricedSwapIndicator=" + this.postPricedSwapIndicator + ", " +
				"blockTradeElectionIndicator=" + this.blockTradeElectionIndicator + ", " +
				"primeBrokerageTransactionIndicator=" + this.primeBrokerageTransactionIndicator + ", " +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier + ", " +
				"dtccAdditionalFields=" + this.dtccAdditionalFields +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CFTCTransactionReport  ***********************/
	class CFTCTransactionReportBuilderImpl extends CommonTransactionReport.CommonTransactionReportBuilderImpl implements CFTCTransactionReport.CFTCTransactionReportBuilder {
	
		protected ClearedEnum cleared;
		protected String counterparty2;
		protected ZonedDateTime eventTimestamp;
		protected Date effectiveDate;
		protected ZonedDateTime executionTimestamp;
		protected Boolean packageIndicator;
		protected Counterparty2IdentifierEnum counterparty2IdentifierSource;
		protected Boolean customBasketIndicator;
		protected Boolean postPricedSwapIndicator;
		protected Boolean blockTradeElectionIndicator;
		protected Boolean primeBrokerageTransactionIndicator;
		protected String uniqueSwapIdentifier;
		protected DTCCAdditionalFields.DTCCAdditionalFieldsBuilder dtccAdditionalFields;
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
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
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
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
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("packageIndicator")
		public Boolean getPackageIndicator() {
			return packageIndicator;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public Counterparty2IdentifierEnum getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		public Boolean getCustomBasketIndicator() {
			return customBasketIndicator;
		}
		
		@Override
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		public Boolean getPostPricedSwapIndicator() {
			return postPricedSwapIndicator;
		}
		
		@Override
		@RosettaAttribute("blockTradeElectionIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("blockTradeElectionIndicator")
		public Boolean getBlockTradeElectionIndicator() {
			return blockTradeElectionIndicator;
		}
		
		@Override
		@RosettaAttribute("primeBrokerageTransactionIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primeBrokerageTransactionIndicator")
		public Boolean getPrimeBrokerageTransactionIndicator() {
			return primeBrokerageTransactionIndicator;
		}
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public String getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtccAdditionalFields")
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getDtccAdditionalFields() {
			return dtccAdditionalFields;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getOrCreateDtccAdditionalFields() {
			DTCCAdditionalFields.DTCCAdditionalFieldsBuilder result;
			if (dtccAdditionalFields!=null) {
				result = dtccAdditionalFields;
			}
			else {
				result = dtccAdditionalFields = DTCCAdditionalFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEffectiveDate(Date _effectiveDate) {
			return setEffectiveDateOverriddenAsDate(_effectiveDate);
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			return setExecutionTimestampOverriddenAsZonedDateTime(_executionTimestamp);
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2OverriddenAsString(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2(String _counterparty2) {
			return setCounterparty2OverriddenAsString(_counterparty2);
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(CommonLeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(Leg _leg1) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(LegV2 _leg1) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg1(LegV1 _leg1) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(CommonLeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(Leg _leg2) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(LegV2 _leg2) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLeg2(LegV1 _leg2) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
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
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			return setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(_counterparty2IdentifierSource);
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClass")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("packageIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageIndicatorOverriddenAsBoolean(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPackageIndicator(Boolean _packageIndicator) {
			return setPackageIndicatorOverriddenAsBoolean(_packageIndicator);
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCustomBasketIndicatorOverriddenAsBoolean(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			return setCustomBasketIndicatorOverriddenAsBoolean(_customBasketIndicator);
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setNonReportable(NonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPostPricedSwapIndicator(Boolean _postPricedSwapIndicator) {
			this.postPricedSwapIndicator = _postPricedSwapIndicator == null ? null : _postPricedSwapIndicator;
			return this;
		}
		
		@RosettaAttribute("blockTradeElectionIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("blockTradeElectionIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setBlockTradeElectionIndicator(Boolean _blockTradeElectionIndicator) {
			this.blockTradeElectionIndicator = _blockTradeElectionIndicator == null ? null : _blockTradeElectionIndicator;
			return this;
		}
		
		@RosettaAttribute("primeBrokerageTransactionIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primeBrokerageTransactionIndicator")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setPrimeBrokerageTransactionIndicator(Boolean _primeBrokerageTransactionIndicator) {
			this.primeBrokerageTransactionIndicator = _primeBrokerageTransactionIndicator == null ? null : _primeBrokerageTransactionIndicator;
			return this;
		}
		
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setUniqueSwapIdentifier(String _uniqueSwapIdentifier) {
			this.uniqueSwapIdentifier = _uniqueSwapIdentifier == null ? null : _uniqueSwapIdentifier;
			return this;
		}
		
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtccAdditionalFields")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder setDtccAdditionalFields(DTCCAdditionalFields _dtccAdditionalFields) {
			this.dtccAdditionalFields = _dtccAdditionalFields == null ? null : _dtccAdditionalFields.toBuilder();
			return this;
		}
		
		@Override
		public CFTCTransactionReport build() {
			return new CFTCTransactionReport.CFTCTransactionReportImpl(this);
		}
		
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder prune() {
			super.prune();
			if (dtccAdditionalFields!=null && !dtccAdditionalFields.prune().hasData()) dtccAdditionalFields = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCleared()!=null) return true;
			if (getCounterparty2()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getExecutionTimestamp()!=null) return true;
			if (getPackageIndicator()!=null) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getCustomBasketIndicator()!=null) return true;
			if (getPostPricedSwapIndicator()!=null) return true;
			if (getBlockTradeElectionIndicator()!=null) return true;
			if (getPrimeBrokerageTransactionIndicator()!=null) return true;
			if (getUniqueSwapIdentifier()!=null) return true;
			if (getDtccAdditionalFields()!=null && getDtccAdditionalFields().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCTransactionReport.CFTCTransactionReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CFTCTransactionReport.CFTCTransactionReportBuilder o = (CFTCTransactionReport.CFTCTransactionReportBuilder) other;
			
			merger.mergeRosetta(getDtccAdditionalFields(), o.getDtccAdditionalFields(), this::setDtccAdditionalFields);
			
			merger.mergeBasic(getCleared(), o.getCleared(), this::setClearedOverriddenAsClearedEnum);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2OverriddenAsString);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDateOverriddenAsDate);
			merger.mergeBasic(getExecutionTimestamp(), o.getExecutionTimestamp(), this::setExecutionTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getPackageIndicator(), o.getPackageIndicator(), this::setPackageIndicatorOverriddenAsBoolean);
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum);
			merger.mergeBasic(getCustomBasketIndicator(), o.getCustomBasketIndicator(), this::setCustomBasketIndicatorOverriddenAsBoolean);
			merger.mergeBasic(getPostPricedSwapIndicator(), o.getPostPricedSwapIndicator(), this::setPostPricedSwapIndicator);
			merger.mergeBasic(getBlockTradeElectionIndicator(), o.getBlockTradeElectionIndicator(), this::setBlockTradeElectionIndicator);
			merger.mergeBasic(getPrimeBrokerageTransactionIndicator(), o.getPrimeBrokerageTransactionIndicator(), this::setPrimeBrokerageTransactionIndicator);
			merger.mergeBasic(getUniqueSwapIdentifier(), o.getUniqueSwapIdentifier(), this::setUniqueSwapIdentifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(packageIndicator, _that.getPackageIndicator())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(customBasketIndicator, _that.getCustomBasketIndicator())) return false;
			if (!Objects.equals(postPricedSwapIndicator, _that.getPostPricedSwapIndicator())) return false;
			if (!Objects.equals(blockTradeElectionIndicator, _that.getBlockTradeElectionIndicator())) return false;
			if (!Objects.equals(primeBrokerageTransactionIndicator, _that.getPrimeBrokerageTransactionIndicator())) return false;
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			if (!Objects.equals(dtccAdditionalFields, _that.getDtccAdditionalFields())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (packageIndicator != null ? packageIndicator.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customBasketIndicator != null ? customBasketIndicator.hashCode() : 0);
			_result = 31 * _result + (postPricedSwapIndicator != null ? postPricedSwapIndicator.hashCode() : 0);
			_result = 31 * _result + (blockTradeElectionIndicator != null ? blockTradeElectionIndicator.hashCode() : 0);
			_result = 31 * _result + (primeBrokerageTransactionIndicator != null ? primeBrokerageTransactionIndicator.hashCode() : 0);
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			_result = 31 * _result + (dtccAdditionalFields != null ? dtccAdditionalFields.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCTransactionReportBuilder {" +
				"cleared=" + this.cleared + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"packageIndicator=" + this.packageIndicator + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"customBasketIndicator=" + this.customBasketIndicator + ", " +
				"postPricedSwapIndicator=" + this.postPricedSwapIndicator + ", " +
				"blockTradeElectionIndicator=" + this.blockTradeElectionIndicator + ", " +
				"primeBrokerageTransactionIndicator=" + this.primeBrokerageTransactionIndicator + ", " +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier + ", " +
				"dtccAdditionalFields=" + this.dtccAdditionalFields +
			'}' + " " + super.toString();
		}
	}
}
