package drr.regulation.csa.rewrite.margin;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
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
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.margin.CommonMarginReport;
import drr.regulation.csa.rewrite.margin.meta.CSAMarginReportMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
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
@RosettaDataType(value="CSAMarginReport", builder=CSAMarginReport.CSAMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CSAMarginReport", model="drr", builder=CSAMarginReport.CSAMarginReportBuilderImpl.class, version="7.7.0")
public interface CSAMarginReport extends CommonMarginReport {

	CSAMarginReportMeta metaData = new CSAMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "2" * field "Counterparty 2"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty. However, if the allocation of the block trade to specific funds does not take place prior to the reporting deadline, then the fund manager executing the transaction on behalf of the fund can be reported as the counterparty.
	 *
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "2" * field "Counterparty 2 (non-reporting counterparty)" * footnote "5"
	 *
	 * Provision Only one counterparty should be reported. In cases where multiple counterparties are legally responsible as the second counterparty (for example joint and several liability, or solidary liability in Quebec), report only one of the counterparties and use the same counterparty for all continuation data and lifecycle events.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250320" * field "Counterparty 2 (non-reporting counterparty)"
	 *
	 * Provision The same CDE Counterparty 2 extraction is required.
	 *
	 */
	@Override
	String getCounterparty2();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "95" * field "Event Timestamp"
	 *
	 * Provision Date and time of occurrence of the event. In the case of a modification agreed for a future date, this data element should reflect the date, the modification occurs (becomes effective) and not when it was negotiated. In the case of a correction, this data element should reflect the date and time as of when the correction is applicable. In the case of a clearing event, this data element should reflect the recorded date and time when the alpha transaction is accepted by the central counterparty (CCP) for clearing. In the case of collateral update, the date and time for which the information contained in the report is provided.
	 *
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "95" * field "Event Timestamp" * footnote "48"
	 *
	 * Provision Both the date and time portion are required to be reported. The time element is as specific as technologically practicable. If the time portion is not available, report 00:00:00 for the time portion.
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "98" * field "Action Type"
	 *
	 * Provision Type of action taken on the transaction or type of end-of-day reporting. See Appendix 3.8 for a description of the allowable values.
	 *
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "98" * field "Action Type" * footnote "50"
	 *
	 * Provision Only one Action type value is allowed per submission. Multiple Action type values should not be submitted in one transaction report. For example, if a data element needs to be corrected on a previously submitted transaction that is getting terminated, the Correct (CORR) value should be submitted as a separate submission prior to the submission of the Terminate (TERM) transaction.
	 *
	 */
	@Override
	MarginActionEnum getActionType();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "3" * field "Counterparty 2 Identifier Source"
	 *
	 * Provision Source used to identify the Counterparty 2.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250320" * field "Counterparty 2 Identifier Source"
	 *
	 * Provision Improvement on the logic was done to consider first if person exists. If not, then consider party.
	 *
	 */
	String getCounterparty2IdentifierSource();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin   
	 * dataElement "80" * field "Portfolio containing nonreportable component indicator"
	 *
	 * Provision If collateral is reported on a portfolio basis, indicator of whether the collateral portfolio includes swap transactions exempt from reporting.
	 *
	 */
	Boolean getPortfolioContainingNonReportableComponentIndicator();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Trade Party 1 - ID Type"
	 *
	 * Provision GTR required Control Field.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup CanadianDataAndReporting ISDA Data and Reporting Canadian Working Group "This distribution list is responsible for addressing industry compliance and implementation issues related to trade reporting under Canadian regulatory requirements across provinces. The group has been the driving force for work such as the Multi-lateral non-dealer Canadian reporting agreement, regulatory response letters, and reporting discussions with the OSC, MSC, Quebec, BCSC and ASC." 
	 * date "20250508" * field "Trade Party 1 - ID Type"
	 *
	 * Provision Reporting firms on the WG call said they would be using an LEI. There is only a possible use case for crypto trades reporting by SEFs; however, DRR is not going to model this case until is demanded by firms.
	 *
	 */
	PartyIdentifierTypeEnum getTradeParty1IDType();
	PartyIdentifierTypeEnum getSubmittingPartyIDType();
	String getUsiID();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "USI ID Prefix"
	 *
	 * Provision The USI is a unique identifier assigned to all swap transactions which identifies the transaction (the swap and its counterparties) uniquely throughout its duration. It consists of a namespace and a transaction identifier.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250327" * field "USI ID Prefix"
	 *
	 * Provision The group agreed on not considering USI ID Prefix due to it comes from an old format and it had been agreed to only consider one field, that is USI ID, considering the concatenation of both fields. Thus, USI ID is the only field that needs to be populated.
	 *
	 */
	String getUsiIDPrefix();
	List<SupervisoryBodyEnum> getTradeParty1ReportingDestination();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Comment 1"
	 *
	 * Provision For CSV submissions if  populated with an * the entire line is treated as comment.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250507" * field "Comment 1"
	 *
	 * Provision Empty because CSV submission is still not supported by current DRR model. This rule will be revisited once Harmonized CSV projection is included.
	 *
	 */
	String getComment1();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Margin    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Message ID"
	 *
	 * Provision Purpose of this field is to allow firms to submit a unique ID that will allow them to tie in specific submissions/modifications. For example if 5 modifications are submitted on a specific PET, this will allow the firm to ensure they receive responses for all 5 modifications.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250604" * field "Message ID"
	 *
	 * Provision Each Message ID must be unique, irrespective of the report type. This unique identification is achieved by concatenating with the Reporting Timestamp field.
	 *
	 */
	String getMessageID();
	String getMessageType();
	String getVersion();

	/*********************** Build Methods  ***********************/
	CSAMarginReport build();
	
	CSAMarginReport.CSAMarginReportBuilder toBuilder();
	
	static CSAMarginReport.CSAMarginReportBuilder builder() {
		return new CSAMarginReport.CSAMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAMarginReport> getType() {
		return CSAMarginReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioCode"), String.class, getCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
		processor.processBasic(path.newSubPath("uti"), String.class, getUti(), this);
		processor.processBasic(path.newSubPath("collateralisationCategory"), CollateralisationType3Code.class, getCollateralisationCategory(), this);
		processor.processBasic(path.newSubPath("initialMarginPostedByTheCounterparty1PreHaircut"), BigDecimal.class, getInitialMarginPostedByTheCounterparty1PreHaircut(), this);
		processor.processBasic(path.newSubPath("initialMarginPostedByTheCounterparty1PostHaircut"), BigDecimal.class, getInitialMarginPostedByTheCounterparty1PostHaircut(), this);
		processor.processBasic(path.newSubPath("initialMarginPostedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getInitialMarginPostedByCounterparty1Currency(), this);
		processor.processBasic(path.newSubPath("variationMarginPostedByTheCounterparty1PreHaircut"), BigDecimal.class, getVariationMarginPostedByTheCounterparty1PreHaircut(), this);
		processor.processBasic(path.newSubPath("variationMarginPostedByTheCounterparty1PostHaircut"), BigDecimal.class, getVariationMarginPostedByTheCounterparty1PostHaircut(), this);
		processor.processBasic(path.newSubPath("variationMarginPostedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getVariationMarginPostedByCounterparty1Currency(), this);
		processor.processBasic(path.newSubPath("initialMarginCollectedByCounterparty1PreHaircut"), BigDecimal.class, getInitialMarginCollectedByCounterparty1PreHaircut(), this);
		processor.processBasic(path.newSubPath("initialMarginCollectedByCounterparty1PostHaircut"), BigDecimal.class, getInitialMarginCollectedByCounterparty1PostHaircut(), this);
		processor.processBasic(path.newSubPath("initialMarginCollectedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getInitialMarginCollectedByCounterparty1Currency(), this);
		processor.processBasic(path.newSubPath("variationMarginCollectedByTheCounterparty1PreHaircut"), BigDecimal.class, getVariationMarginCollectedByTheCounterparty1PreHaircut(), this);
		processor.processBasic(path.newSubPath("variationMarginCollectedByTheCounterparty1PostHaircut"), BigDecimal.class, getVariationMarginCollectedByTheCounterparty1PostHaircut(), this);
		processor.processBasic(path.newSubPath("variationMarginCollectedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getVariationMarginCollectedByCounterparty1Currency(), this);
		processor.processBasic(path.newSubPath("excessCollateralPostedByTheCounterparty1"), BigDecimal.class, getExcessCollateralPostedByTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("currencyOfTheExcessCollateralPosted"), String.class, getCurrencyOfTheExcessCollateralPosted(), this);
		processor.processBasic(path.newSubPath("excessCollateralCollectedByTheCounterparty1"), BigDecimal.class, getExcessCollateralCollectedByTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("currencyOfTheExcessCollateralCollected"), String.class, getCurrencyOfTheExcessCollateralCollected(), this);
		processor.processBasic(path.newSubPath("collateralTimestamp"), ZonedDateTime.class, getCollateralTimestamp(), this);
		processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
		processor.processBasic(path.newSubPath("actionType"), MarginActionEnum.class, getActionType(), this);
		processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
		processor.processBasic(path.newSubPath("eventTimestamp"), ZonedDateTime.class, getEventTimestamp(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), String.class, getCounterparty2IdentifierSource(), this);
		processor.processBasic(path.newSubPath("portfolioContainingNonReportableComponentIndicator"), Boolean.class, getPortfolioContainingNonReportableComponentIndicator(), this);
		processor.processBasic(path.newSubPath("tradeParty1IDType"), PartyIdentifierTypeEnum.class, getTradeParty1IDType(), this);
		processor.processBasic(path.newSubPath("submittingPartyIDType"), PartyIdentifierTypeEnum.class, getSubmittingPartyIDType(), this);
		processor.processBasic(path.newSubPath("usiID"), String.class, getUsiID(), this);
		processor.processBasic(path.newSubPath("usiIDPrefix"), String.class, getUsiIDPrefix(), this);
		processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty1ReportingDestination(), this);
		processor.processBasic(path.newSubPath("comment1"), String.class, getComment1(), this);
		processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
		processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
		processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAMarginReportBuilder extends CSAMarginReport, CommonMarginReport.CommonMarginReportBuilder {
		@Override
		CSAMarginReport.CSAMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setUti(String uti);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setActionType(MarginActionEnum actionType);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setEventDate(Date eventDate);
		@Override
		CSAMarginReport.CSAMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		CSAMarginReport.CSAMarginReportBuilder setCounterparty2OverriddenAsString(String counterparty2);
		CSAMarginReport.CSAMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		CSAMarginReport.CSAMarginReportBuilder setActionTypeOverriddenAsMarginActionEnum(MarginActionEnum actionType);
		CSAMarginReport.CSAMarginReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		CSAMarginReport.CSAMarginReportBuilder setPortfolioContainingNonReportableComponentIndicator(Boolean portfolioContainingNonReportableComponentIndicator);
		CSAMarginReport.CSAMarginReportBuilder setTradeParty1IDType(PartyIdentifierTypeEnum tradeParty1IDType);
		CSAMarginReport.CSAMarginReportBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum submittingPartyIDType);
		CSAMarginReport.CSAMarginReportBuilder setUsiID(String usiID);
		CSAMarginReport.CSAMarginReportBuilder setUsiIDPrefix(String usiIDPrefix);
		CSAMarginReport.CSAMarginReportBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination);
		CSAMarginReport.CSAMarginReportBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination, int idx);
		CSAMarginReport.CSAMarginReportBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		CSAMarginReport.CSAMarginReportBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		CSAMarginReport.CSAMarginReportBuilder setComment1(String comment1);
		CSAMarginReport.CSAMarginReportBuilder setMessageID(String messageID);
		CSAMarginReport.CSAMarginReportBuilder setMessageType(String messageType);
		CSAMarginReport.CSAMarginReportBuilder setVersion(String version);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioCode"), String.class, getCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
			processor.processBasic(path.newSubPath("uti"), String.class, getUti(), this);
			processor.processBasic(path.newSubPath("collateralisationCategory"), CollateralisationType3Code.class, getCollateralisationCategory(), this);
			processor.processBasic(path.newSubPath("initialMarginPostedByTheCounterparty1PreHaircut"), BigDecimal.class, getInitialMarginPostedByTheCounterparty1PreHaircut(), this);
			processor.processBasic(path.newSubPath("initialMarginPostedByTheCounterparty1PostHaircut"), BigDecimal.class, getInitialMarginPostedByTheCounterparty1PostHaircut(), this);
			processor.processBasic(path.newSubPath("initialMarginPostedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getInitialMarginPostedByCounterparty1Currency(), this);
			processor.processBasic(path.newSubPath("variationMarginPostedByTheCounterparty1PreHaircut"), BigDecimal.class, getVariationMarginPostedByTheCounterparty1PreHaircut(), this);
			processor.processBasic(path.newSubPath("variationMarginPostedByTheCounterparty1PostHaircut"), BigDecimal.class, getVariationMarginPostedByTheCounterparty1PostHaircut(), this);
			processor.processBasic(path.newSubPath("variationMarginPostedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getVariationMarginPostedByCounterparty1Currency(), this);
			processor.processBasic(path.newSubPath("initialMarginCollectedByCounterparty1PreHaircut"), BigDecimal.class, getInitialMarginCollectedByCounterparty1PreHaircut(), this);
			processor.processBasic(path.newSubPath("initialMarginCollectedByCounterparty1PostHaircut"), BigDecimal.class, getInitialMarginCollectedByCounterparty1PostHaircut(), this);
			processor.processBasic(path.newSubPath("initialMarginCollectedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getInitialMarginCollectedByCounterparty1Currency(), this);
			processor.processBasic(path.newSubPath("variationMarginCollectedByTheCounterparty1PreHaircut"), BigDecimal.class, getVariationMarginCollectedByTheCounterparty1PreHaircut(), this);
			processor.processBasic(path.newSubPath("variationMarginCollectedByTheCounterparty1PostHaircut"), BigDecimal.class, getVariationMarginCollectedByTheCounterparty1PostHaircut(), this);
			processor.processBasic(path.newSubPath("variationMarginCollectedByCounterparty1Currency"), ISOCurrencyCodeEnum.class, getVariationMarginCollectedByCounterparty1Currency(), this);
			processor.processBasic(path.newSubPath("excessCollateralPostedByTheCounterparty1"), BigDecimal.class, getExcessCollateralPostedByTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("currencyOfTheExcessCollateralPosted"), String.class, getCurrencyOfTheExcessCollateralPosted(), this);
			processor.processBasic(path.newSubPath("excessCollateralCollectedByTheCounterparty1"), BigDecimal.class, getExcessCollateralCollectedByTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("currencyOfTheExcessCollateralCollected"), String.class, getCurrencyOfTheExcessCollateralCollected(), this);
			processor.processBasic(path.newSubPath("collateralTimestamp"), ZonedDateTime.class, getCollateralTimestamp(), this);
			processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
			processor.processBasic(path.newSubPath("actionType"), MarginActionEnum.class, getActionType(), this);
			processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
			processor.processBasic(path.newSubPath("eventTimestamp"), ZonedDateTime.class, getEventTimestamp(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), String.class, getCounterparty2IdentifierSource(), this);
			processor.processBasic(path.newSubPath("portfolioContainingNonReportableComponentIndicator"), Boolean.class, getPortfolioContainingNonReportableComponentIndicator(), this);
			processor.processBasic(path.newSubPath("tradeParty1IDType"), PartyIdentifierTypeEnum.class, getTradeParty1IDType(), this);
			processor.processBasic(path.newSubPath("submittingPartyIDType"), PartyIdentifierTypeEnum.class, getSubmittingPartyIDType(), this);
			processor.processBasic(path.newSubPath("usiID"), String.class, getUsiID(), this);
			processor.processBasic(path.newSubPath("usiIDPrefix"), String.class, getUsiIDPrefix(), this);
			processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty1ReportingDestination(), this);
			processor.processBasic(path.newSubPath("comment1"), String.class, getComment1(), this);
			processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
			processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
			processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
		}
		

		CSAMarginReport.CSAMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of CSAMarginReport  ***********************/
	class CSAMarginReportImpl extends CommonMarginReport.CommonMarginReportImpl implements CSAMarginReport {
		private final String counterparty2;
		private final ZonedDateTime eventTimestamp;
		private final MarginActionEnum actionType;
		private final String counterparty2IdentifierSource;
		private final Boolean portfolioContainingNonReportableComponentIndicator;
		private final PartyIdentifierTypeEnum tradeParty1IDType;
		private final PartyIdentifierTypeEnum submittingPartyIDType;
		private final String usiID;
		private final String usiIDPrefix;
		private final List<SupervisoryBodyEnum> tradeParty1ReportingDestination;
		private final String comment1;
		private final String messageID;
		private final String messageType;
		private final String version;
		
		protected CSAMarginReportImpl(CSAMarginReport.CSAMarginReportBuilder builder) {
			super(builder);
			this.counterparty2 = builder.getCounterparty2();
			this.eventTimestamp = builder.getEventTimestamp();
			this.actionType = builder.getActionType();
			this.counterparty2IdentifierSource = builder.getCounterparty2IdentifierSource();
			this.portfolioContainingNonReportableComponentIndicator = builder.getPortfolioContainingNonReportableComponentIndicator();
			this.tradeParty1IDType = builder.getTradeParty1IDType();
			this.submittingPartyIDType = builder.getSubmittingPartyIDType();
			this.usiID = builder.getUsiID();
			this.usiIDPrefix = builder.getUsiIDPrefix();
			this.tradeParty1ReportingDestination = ofNullable(builder.getTradeParty1ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.comment1 = builder.getComment1();
			this.messageID = builder.getMessageID();
			this.messageType = builder.getMessageType();
			this.version = builder.getVersion();
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
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("actionType")
		public MarginActionEnum getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public String getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("portfolioContainingNonReportableComponentIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("portfolioContainingNonReportableComponentIndicator")
		public Boolean getPortfolioContainingNonReportableComponentIndicator() {
			return portfolioContainingNonReportableComponentIndicator;
		}
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		public PartyIdentifierTypeEnum getTradeParty1IDType() {
			return tradeParty1IDType;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		public PartyIdentifierTypeEnum getSubmittingPartyIDType() {
			return submittingPartyIDType;
		}
		
		@Override
		@RosettaAttribute("usiID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("usiID")
		public String getUsiID() {
			return usiID;
		}
		
		@Override
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("usiIDPrefix")
		public String getUsiIDPrefix() {
			return usiIDPrefix;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("comment1")
		public String getComment1() {
			return comment1;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("version")
		public String getVersion() {
			return version;
		}
		
		@Override
		public CSAMarginReport build() {
			return this;
		}
		
		@Override
		public CSAMarginReport.CSAMarginReportBuilder toBuilder() {
			CSAMarginReport.CSAMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAMarginReport.CSAMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2OverriddenAsString);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getActionType()).ifPresent(builder::setActionTypeOverriddenAsMarginActionEnum);
			ofNullable(getCounterparty2IdentifierSource()).ifPresent(builder::setCounterparty2IdentifierSource);
			ofNullable(getPortfolioContainingNonReportableComponentIndicator()).ifPresent(builder::setPortfolioContainingNonReportableComponentIndicator);
			ofNullable(getTradeParty1IDType()).ifPresent(builder::setTradeParty1IDType);
			ofNullable(getSubmittingPartyIDType()).ifPresent(builder::setSubmittingPartyIDType);
			ofNullable(getUsiID()).ifPresent(builder::setUsiID);
			ofNullable(getUsiIDPrefix()).ifPresent(builder::setUsiIDPrefix);
			ofNullable(getTradeParty1ReportingDestination()).ifPresent(builder::setTradeParty1ReportingDestination);
			ofNullable(getComment1()).ifPresent(builder::setComment1);
			ofNullable(getMessageID()).ifPresent(builder::setMessageID);
			ofNullable(getMessageType()).ifPresent(builder::setMessageType);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSAMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(portfolioContainingNonReportableComponentIndicator, _that.getPortfolioContainingNonReportableComponentIndicator())) return false;
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(usiID, _that.getUsiID())) return false;
			if (!Objects.equals(usiIDPrefix, _that.getUsiIDPrefix())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!Objects.equals(comment1, _that.getComment1())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (portfolioContainingNonReportableComponentIndicator != null ? portfolioContainingNonReportableComponentIndicator.hashCode() : 0);
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (usiID != null ? usiID.hashCode() : 0);
			_result = 31 * _result + (usiIDPrefix != null ? usiIDPrefix.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (comment1 != null ? comment1.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAMarginReport {" +
				"counterparty2=" + this.counterparty2 + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"actionType=" + this.actionType + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"portfolioContainingNonReportableComponentIndicator=" + this.portfolioContainingNonReportableComponentIndicator + ", " +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"usiID=" + this.usiID + ", " +
				"usiIDPrefix=" + this.usiIDPrefix + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"comment1=" + this.comment1 + ", " +
				"messageID=" + this.messageID + ", " +
				"messageType=" + this.messageType + ", " +
				"version=" + this.version +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CSAMarginReport  ***********************/
	class CSAMarginReportBuilderImpl extends CommonMarginReport.CommonMarginReportBuilderImpl implements CSAMarginReport.CSAMarginReportBuilder {
	
		protected String counterparty2;
		protected ZonedDateTime eventTimestamp;
		protected MarginActionEnum actionType;
		protected String counterparty2IdentifierSource;
		protected Boolean portfolioContainingNonReportableComponentIndicator;
		protected PartyIdentifierTypeEnum tradeParty1IDType;
		protected PartyIdentifierTypeEnum submittingPartyIDType;
		protected String usiID;
		protected String usiIDPrefix;
		protected List<SupervisoryBodyEnum> tradeParty1ReportingDestination = new ArrayList<>();
		protected String comment1;
		protected String messageID;
		protected String messageType;
		protected String version;
		
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
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("actionType")
		public MarginActionEnum getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public String getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("portfolioContainingNonReportableComponentIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("portfolioContainingNonReportableComponentIndicator")
		public Boolean getPortfolioContainingNonReportableComponentIndicator() {
			return portfolioContainingNonReportableComponentIndicator;
		}
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		public PartyIdentifierTypeEnum getTradeParty1IDType() {
			return tradeParty1IDType;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		public PartyIdentifierTypeEnum getSubmittingPartyIDType() {
			return submittingPartyIDType;
		}
		
		@Override
		@RosettaAttribute("usiID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("usiID")
		public String getUsiID() {
			return usiID;
		}
		
		@Override
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("usiIDPrefix")
		public String getUsiIDPrefix() {
			return usiIDPrefix;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("comment1")
		public String getComment1() {
			return comment1;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("version")
		public String getVersion() {
			return version;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCounterparty2OverriddenAsString(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCounterparty2(String _counterparty2) {
			return setCounterparty2OverriddenAsString(_counterparty2);
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setActionTypeOverriddenAsMarginActionEnum(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			return setActionTypeOverriddenAsMarginActionEnum(_actionType);
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("portfolioContainingNonReportableComponentIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("portfolioContainingNonReportableComponentIndicator")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setPortfolioContainingNonReportableComponentIndicator(Boolean _portfolioContainingNonReportableComponentIndicator) {
			this.portfolioContainingNonReportableComponentIndicator = _portfolioContainingNonReportableComponentIndicator == null ? null : _portfolioContainingNonReportableComponentIndicator;
			return this;
		}
		
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setTradeParty1IDType(PartyIdentifierTypeEnum _tradeParty1IDType) {
			this.tradeParty1IDType = _tradeParty1IDType == null ? null : _tradeParty1IDType;
			return this;
		}
		
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum _submittingPartyIDType) {
			this.submittingPartyIDType = _submittingPartyIDType == null ? null : _submittingPartyIDType;
			return this;
		}
		
		@RosettaAttribute("usiID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("usiID")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setUsiID(String _usiID) {
			this.usiID = _usiID == null ? null : _usiID;
			return this;
		}
		
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("usiIDPrefix")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setUsiIDPrefix(String _usiIDPrefix) {
			this.usiIDPrefix = _usiIDPrefix == null ? null : _usiIDPrefix;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public CSAMarginReport.CSAMarginReportBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public CSAMarginReport.CSAMarginReportBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations != null) {
				for (final SupervisoryBodyEnum toAdd : tradeParty1ReportingDestinations) {
					this.tradeParty1ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations == null) {
				this.tradeParty1ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty1ReportingDestination = tradeParty1ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("comment1")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setComment1(String _comment1) {
			this.comment1 = _comment1 == null ? null : _comment1;
			return this;
		}
		
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("messageID")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setMessageID(String _messageID) {
			this.messageID = _messageID == null ? null : _messageID;
			return this;
		}
		
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("messageType")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setMessageType(String _messageType) {
			this.messageType = _messageType == null ? null : _messageType;
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("version")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder setVersion(String _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@Override
		public CSAMarginReport build() {
			return new CSAMarginReport.CSAMarginReportImpl(this);
		}
		
		@Override
		public CSAMarginReport.CSAMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getActionType()!=null) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getPortfolioContainingNonReportableComponentIndicator()!=null) return true;
			if (getTradeParty1IDType()!=null) return true;
			if (getSubmittingPartyIDType()!=null) return true;
			if (getUsiID()!=null) return true;
			if (getUsiIDPrefix()!=null) return true;
			if (getTradeParty1ReportingDestination()!=null && !getTradeParty1ReportingDestination().isEmpty()) return true;
			if (getComment1()!=null) return true;
			if (getMessageID()!=null) return true;
			if (getMessageType()!=null) return true;
			if (getVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAMarginReport.CSAMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CSAMarginReport.CSAMarginReportBuilder o = (CSAMarginReport.CSAMarginReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2OverriddenAsString);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getActionType(), o.getActionType(), this::setActionTypeOverriddenAsMarginActionEnum);
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSource);
			merger.mergeBasic(getPortfolioContainingNonReportableComponentIndicator(), o.getPortfolioContainingNonReportableComponentIndicator(), this::setPortfolioContainingNonReportableComponentIndicator);
			merger.mergeBasic(getTradeParty1IDType(), o.getTradeParty1IDType(), this::setTradeParty1IDType);
			merger.mergeBasic(getSubmittingPartyIDType(), o.getSubmittingPartyIDType(), this::setSubmittingPartyIDType);
			merger.mergeBasic(getUsiID(), o.getUsiID(), this::setUsiID);
			merger.mergeBasic(getUsiIDPrefix(), o.getUsiIDPrefix(), this::setUsiIDPrefix);
			merger.mergeBasic(getTradeParty1ReportingDestination(), o.getTradeParty1ReportingDestination(), (Consumer<SupervisoryBodyEnum>) this::addTradeParty1ReportingDestination);
			merger.mergeBasic(getComment1(), o.getComment1(), this::setComment1);
			merger.mergeBasic(getMessageID(), o.getMessageID(), this::setMessageID);
			merger.mergeBasic(getMessageType(), o.getMessageType(), this::setMessageType);
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSAMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(portfolioContainingNonReportableComponentIndicator, _that.getPortfolioContainingNonReportableComponentIndicator())) return false;
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(usiID, _that.getUsiID())) return false;
			if (!Objects.equals(usiIDPrefix, _that.getUsiIDPrefix())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!Objects.equals(comment1, _that.getComment1())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (portfolioContainingNonReportableComponentIndicator != null ? portfolioContainingNonReportableComponentIndicator.hashCode() : 0);
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (usiID != null ? usiID.hashCode() : 0);
			_result = 31 * _result + (usiIDPrefix != null ? usiIDPrefix.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (comment1 != null ? comment1.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAMarginReportBuilder {" +
				"counterparty2=" + this.counterparty2 + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"actionType=" + this.actionType + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"portfolioContainingNonReportableComponentIndicator=" + this.portfolioContainingNonReportableComponentIndicator + ", " +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"usiID=" + this.usiID + ", " +
				"usiIDPrefix=" + this.usiIDPrefix + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"comment1=" + this.comment1 + ", " +
				"messageID=" + this.messageID + ", " +
				"messageType=" + this.messageType + ", " +
				"version=" + this.version +
			'}' + " " + super.toString();
		}
	}
}
