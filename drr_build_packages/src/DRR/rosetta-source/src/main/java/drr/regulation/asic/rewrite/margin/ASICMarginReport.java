package drr.regulation.asic.rewrite.margin;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import drr.regulation.asic.rewrite.margin.meta.ASICMarginReportMeta;
import drr.regulation.common.margin.CommonMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ASICMarginReport", builder=ASICMarginReport.ASICMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ASICMarginReport", model="drr", builder=ASICMarginReport.ASICMarginReportBuilderImpl.class, version="7.7.0")
public interface ASICMarginReport extends CommonMarginReport {

	ASICMarginReportMeta metaData = new ASICMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * table "3" * dataElement "5" * field "Counterparty 2"
	 *
	 * Provision The LEI or another identifier, determined in accordance with subrule S1.3.1(2), of the entity that is:
	             If the counterparty of the OTC Derivative the subject of the Reportable Transaction whose identifier is not reported at Counterparty 1 (item 3 above) is an RE or Trustee of the managed investment scheme or trust that holds the OTC Derivative the subject of the Reportable Transaction, the managed investment scheme or trust;
	             Otherwise, the counterparty of the OTC Derivative the subject of the Reportable Transaction whose identifier is not reported at Counterparty 1 (item 3 above).
	 *
	 */
	@Override
	String getCounterparty2();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * table "3" * dataElement "1" * field "Unique transaction identifier"
	 *
	 * Provision For a report made under Rule 2.2.2, if one transaction identifier was reported for the Reportable Transaction, the transaction identifier.
	             If more than one transaction identifier was reported for the Reportable Transaction, one of those transaction identifiers.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup APACJFSAPeerReviewGroup ISDA APAC/JFSA Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended Asia-Pacific and JFSA transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20251203"
	 *
	 * Provision It has been agreed to represent the transaction identifier under reportable information, in addition to the CDM trade, because the UTI reported can vary across jurisdictions. Each regime may apply different rules for generation, formatting, and lifecycle interpretation.
	 *
	 */
	String getUniqueTransactionIdentifierProprietary();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * table "3" * dataElement "2" * field "Reporting entity"
	 *
	 * Provision The current LEI of the Reporting Entity
	 *
	 */
	String getReportingEntity();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * table "3" * dataElement "4" * field "Small-scale Buy-side Entity indicator"
	 *
	 * Provision If applicable, an indicator that the Reporting Entity is making the report as a Small-scale Buy-side Entity.
	 *
	 */
	String getSmallScaleBuySideEntityIndicator();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * table "3" * dataElement "9" * field "Portfolio containing non-reported component indicator"
	 *
	 * Provision An indicator of whether the collateral portfolio in which the OTC Derivative the subject of the Reportable Transaction includes transactions that are not reported under these Rules.
	 *
	 */
	Boolean getPortfolioContainingNonReportedComponentIndicator();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * dataElement "[Internal]" * field "Technical Record Id (ISO)"
	 *
	 * Provision Unique technical identification of the original data for which the status is provided for the BDR.
	 *
	 */
	String getTechnicalRecordId();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Margin   
	 * dataElement "N/A" * field "Execution agent of Counterparty 1"
	 *
	 * Provision If applicable, the LEI of the entity that entered into the Reportable Transaction as agent for the Reporting Entity without becoming a counterparty themselves.
	 *
	 */
	String getExecutionAgentOfCounterparty1();

	/*********************** Build Methods  ***********************/
	ASICMarginReport build();
	
	ASICMarginReport.ASICMarginReportBuilder toBuilder();
	
	static ASICMarginReport.ASICMarginReportBuilder builder() {
		return new ASICMarginReport.ASICMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ASICMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ASICMarginReport> getType() {
		return ASICMarginReport.class;
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
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
		processor.processBasic(path.newSubPath("reportingEntity"), String.class, getReportingEntity(), this);
		processor.processBasic(path.newSubPath("smallScaleBuySideEntityIndicator"), String.class, getSmallScaleBuySideEntityIndicator(), this);
		processor.processBasic(path.newSubPath("portfolioContainingNonReportedComponentIndicator"), Boolean.class, getPortfolioContainingNonReportedComponentIndicator(), this);
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		processor.processBasic(path.newSubPath("executionAgentOfCounterparty1"), String.class, getExecutionAgentOfCounterparty1(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ASICMarginReportBuilder extends ASICMarginReport, CommonMarginReport.CommonMarginReportBuilder {
		@Override
		ASICMarginReport.ASICMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setUti(String uti);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setActionType(MarginActionEnum actionType);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setEventDate(Date eventDate);
		@Override
		ASICMarginReport.ASICMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		ASICMarginReport.ASICMarginReportBuilder setCounterparty2OverriddenAsString(String counterparty2);
		ASICMarginReport.ASICMarginReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		ASICMarginReport.ASICMarginReportBuilder setReportingEntity(String reportingEntity);
		ASICMarginReport.ASICMarginReportBuilder setSmallScaleBuySideEntityIndicator(String smallScaleBuySideEntityIndicator);
		ASICMarginReport.ASICMarginReportBuilder setPortfolioContainingNonReportedComponentIndicator(Boolean portfolioContainingNonReportedComponentIndicator);
		ASICMarginReport.ASICMarginReportBuilder setTechnicalRecordId(String technicalRecordId);
		ASICMarginReport.ASICMarginReportBuilder setExecutionAgentOfCounterparty1(String executionAgentOfCounterparty1);

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
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
			processor.processBasic(path.newSubPath("reportingEntity"), String.class, getReportingEntity(), this);
			processor.processBasic(path.newSubPath("smallScaleBuySideEntityIndicator"), String.class, getSmallScaleBuySideEntityIndicator(), this);
			processor.processBasic(path.newSubPath("portfolioContainingNonReportedComponentIndicator"), Boolean.class, getPortfolioContainingNonReportedComponentIndicator(), this);
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
			processor.processBasic(path.newSubPath("executionAgentOfCounterparty1"), String.class, getExecutionAgentOfCounterparty1(), this);
		}
		

		ASICMarginReport.ASICMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of ASICMarginReport  ***********************/
	class ASICMarginReportImpl extends CommonMarginReport.CommonMarginReportImpl implements ASICMarginReport {
		private final String counterparty2;
		private final String uniqueTransactionIdentifierProprietary;
		private final String reportingEntity;
		private final String smallScaleBuySideEntityIndicator;
		private final Boolean portfolioContainingNonReportedComponentIndicator;
		private final String technicalRecordId;
		private final String executionAgentOfCounterparty1;
		
		protected ASICMarginReportImpl(ASICMarginReport.ASICMarginReportBuilder builder) {
			super(builder);
			this.counterparty2 = builder.getCounterparty2();
			this.uniqueTransactionIdentifierProprietary = builder.getUniqueTransactionIdentifierProprietary();
			this.reportingEntity = builder.getReportingEntity();
			this.smallScaleBuySideEntityIndicator = builder.getSmallScaleBuySideEntityIndicator();
			this.portfolioContainingNonReportedComponentIndicator = builder.getPortfolioContainingNonReportedComponentIndicator();
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.executionAgentOfCounterparty1 = builder.getExecutionAgentOfCounterparty1();
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
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		public String getUniqueTransactionIdentifierProprietary() {
			return uniqueTransactionIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("reportingEntity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingEntity")
		public String getReportingEntity() {
			return reportingEntity;
		}
		
		@Override
		@RosettaAttribute("smallScaleBuySideEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("smallScaleBuySideEntityIndicator")
		public String getSmallScaleBuySideEntityIndicator() {
			return smallScaleBuySideEntityIndicator;
		}
		
		@Override
		@RosettaAttribute("portfolioContainingNonReportedComponentIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioContainingNonReportedComponentIndicator")
		public Boolean getPortfolioContainingNonReportedComponentIndicator() {
			return portfolioContainingNonReportedComponentIndicator;
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
		@RosettaAttribute("executionAgentOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionAgentOfCounterparty1")
		public String getExecutionAgentOfCounterparty1() {
			return executionAgentOfCounterparty1;
		}
		
		@Override
		public ASICMarginReport build() {
			return this;
		}
		
		@Override
		public ASICMarginReport.ASICMarginReportBuilder toBuilder() {
			ASICMarginReport.ASICMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ASICMarginReport.ASICMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2OverriddenAsString);
			ofNullable(getUniqueTransactionIdentifierProprietary()).ifPresent(builder::setUniqueTransactionIdentifierProprietary);
			ofNullable(getReportingEntity()).ifPresent(builder::setReportingEntity);
			ofNullable(getSmallScaleBuySideEntityIndicator()).ifPresent(builder::setSmallScaleBuySideEntityIndicator);
			ofNullable(getPortfolioContainingNonReportedComponentIndicator()).ifPresent(builder::setPortfolioContainingNonReportedComponentIndicator);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordId);
			ofNullable(getExecutionAgentOfCounterparty1()).ifPresent(builder::setExecutionAgentOfCounterparty1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ASICMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(reportingEntity, _that.getReportingEntity())) return false;
			if (!Objects.equals(smallScaleBuySideEntityIndicator, _that.getSmallScaleBuySideEntityIndicator())) return false;
			if (!Objects.equals(portfolioContainingNonReportedComponentIndicator, _that.getPortfolioContainingNonReportedComponentIndicator())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(executionAgentOfCounterparty1, _that.getExecutionAgentOfCounterparty1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (reportingEntity != null ? reportingEntity.hashCode() : 0);
			_result = 31 * _result + (smallScaleBuySideEntityIndicator != null ? smallScaleBuySideEntityIndicator.hashCode() : 0);
			_result = 31 * _result + (portfolioContainingNonReportedComponentIndicator != null ? portfolioContainingNonReportedComponentIndicator.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfCounterparty1 != null ? executionAgentOfCounterparty1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ASICMarginReport {" +
				"counterparty2=" + this.counterparty2 + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"reportingEntity=" + this.reportingEntity + ", " +
				"smallScaleBuySideEntityIndicator=" + this.smallScaleBuySideEntityIndicator + ", " +
				"portfolioContainingNonReportedComponentIndicator=" + this.portfolioContainingNonReportedComponentIndicator + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"executionAgentOfCounterparty1=" + this.executionAgentOfCounterparty1 +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ASICMarginReport  ***********************/
	class ASICMarginReportBuilderImpl extends CommonMarginReport.CommonMarginReportBuilderImpl implements ASICMarginReport.ASICMarginReportBuilder {
	
		protected String counterparty2;
		protected String uniqueTransactionIdentifierProprietary;
		protected String reportingEntity;
		protected String smallScaleBuySideEntityIndicator;
		protected Boolean portfolioContainingNonReportedComponentIndicator;
		protected String technicalRecordId;
		protected String executionAgentOfCounterparty1;
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		public String getUniqueTransactionIdentifierProprietary() {
			return uniqueTransactionIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("reportingEntity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingEntity")
		public String getReportingEntity() {
			return reportingEntity;
		}
		
		@Override
		@RosettaAttribute("smallScaleBuySideEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("smallScaleBuySideEntityIndicator")
		public String getSmallScaleBuySideEntityIndicator() {
			return smallScaleBuySideEntityIndicator;
		}
		
		@Override
		@RosettaAttribute("portfolioContainingNonReportedComponentIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioContainingNonReportedComponentIndicator")
		public Boolean getPortfolioContainingNonReportedComponentIndicator() {
			return portfolioContainingNonReportedComponentIndicator;
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
		@RosettaAttribute("executionAgentOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionAgentOfCounterparty1")
		public String getExecutionAgentOfCounterparty1() {
			return executionAgentOfCounterparty1;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCounterparty2OverriddenAsString(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCounterparty2(String _counterparty2) {
			return setCounterparty2OverriddenAsString(_counterparty2);
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTimestamp")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("reportingEntity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingEntity")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setReportingEntity(String _reportingEntity) {
			this.reportingEntity = _reportingEntity == null ? null : _reportingEntity;
			return this;
		}
		
		@RosettaAttribute("smallScaleBuySideEntityIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("smallScaleBuySideEntityIndicator")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setSmallScaleBuySideEntityIndicator(String _smallScaleBuySideEntityIndicator) {
			this.smallScaleBuySideEntityIndicator = _smallScaleBuySideEntityIndicator == null ? null : _smallScaleBuySideEntityIndicator;
			return this;
		}
		
		@RosettaAttribute("portfolioContainingNonReportedComponentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolioContainingNonReportedComponentIndicator")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setPortfolioContainingNonReportedComponentIndicator(Boolean _portfolioContainingNonReportedComponentIndicator) {
			this.portfolioContainingNonReportedComponentIndicator = _portfolioContainingNonReportedComponentIndicator == null ? null : _portfolioContainingNonReportedComponentIndicator;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionAgentOfCounterparty1")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder setExecutionAgentOfCounterparty1(String _executionAgentOfCounterparty1) {
			this.executionAgentOfCounterparty1 = _executionAgentOfCounterparty1 == null ? null : _executionAgentOfCounterparty1;
			return this;
		}
		
		@Override
		public ASICMarginReport build() {
			return new ASICMarginReport.ASICMarginReportImpl(this);
		}
		
		@Override
		public ASICMarginReport.ASICMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2()!=null) return true;
			if (getUniqueTransactionIdentifierProprietary()!=null) return true;
			if (getReportingEntity()!=null) return true;
			if (getSmallScaleBuySideEntityIndicator()!=null) return true;
			if (getPortfolioContainingNonReportedComponentIndicator()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getExecutionAgentOfCounterparty1()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ASICMarginReport.ASICMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ASICMarginReport.ASICMarginReportBuilder o = (ASICMarginReport.ASICMarginReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2OverriddenAsString);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietary(), o.getUniqueTransactionIdentifierProprietary(), this::setUniqueTransactionIdentifierProprietary);
			merger.mergeBasic(getReportingEntity(), o.getReportingEntity(), this::setReportingEntity);
			merger.mergeBasic(getSmallScaleBuySideEntityIndicator(), o.getSmallScaleBuySideEntityIndicator(), this::setSmallScaleBuySideEntityIndicator);
			merger.mergeBasic(getPortfolioContainingNonReportedComponentIndicator(), o.getPortfolioContainingNonReportedComponentIndicator(), this::setPortfolioContainingNonReportedComponentIndicator);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			merger.mergeBasic(getExecutionAgentOfCounterparty1(), o.getExecutionAgentOfCounterparty1(), this::setExecutionAgentOfCounterparty1);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ASICMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(reportingEntity, _that.getReportingEntity())) return false;
			if (!Objects.equals(smallScaleBuySideEntityIndicator, _that.getSmallScaleBuySideEntityIndicator())) return false;
			if (!Objects.equals(portfolioContainingNonReportedComponentIndicator, _that.getPortfolioContainingNonReportedComponentIndicator())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(executionAgentOfCounterparty1, _that.getExecutionAgentOfCounterparty1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (reportingEntity != null ? reportingEntity.hashCode() : 0);
			_result = 31 * _result + (smallScaleBuySideEntityIndicator != null ? smallScaleBuySideEntityIndicator.hashCode() : 0);
			_result = 31 * _result + (portfolioContainingNonReportedComponentIndicator != null ? portfolioContainingNonReportedComponentIndicator.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfCounterparty1 != null ? executionAgentOfCounterparty1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ASICMarginReportBuilder {" +
				"counterparty2=" + this.counterparty2 + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"reportingEntity=" + this.reportingEntity + ", " +
				"smallScaleBuySideEntityIndicator=" + this.smallScaleBuySideEntityIndicator + ", " +
				"portfolioContainingNonReportedComponentIndicator=" + this.portfolioContainingNonReportedComponentIndicator + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"executionAgentOfCounterparty1=" + this.executionAgentOfCounterparty1 +
			'}' + " " + super.toString();
		}
	}
}
