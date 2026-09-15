package drr.regulation.mas.rewrite.margin;

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
import drr.regulation.common.margin.CommonMarginReport;
import drr.regulation.mas.rewrite.margin.meta.MASMarginReportMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="MASMarginReport", builder=MASMarginReport.MASMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="MASMarginReport", model="drr", builder=MASMarginReport.MASMarginReportBuilderImpl.class, version="7.7.0")
public interface MASMarginReport extends CommonMarginReport {

	MASMarginReportMeta metaData = new MASMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "3" * field "Counterparty 2 Identifier Type"
	 *
	 * Provision Indicator of whether LEI (including pre-LEI) was used to identify Counterparty 2.
	 *
	 */
	@Override
	Boolean getCounterparty2IdentifierType();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "58" * field "Initial margin collateral portfolio code (DTCC)"
	 *
	 * Provision Unique code assigned by Counterparty 1 to the portfolio when collateral is reported on a portfolio basis, where applicable.
	 *
	 */
	@Override
	String getVariationMarginCollateralPortfolioCode();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "75" * field "Collateralisation category"
	 *
	 * Provision Indicator of whether a collateral agreement (or collateral agreements) between the counterparties exists (uncollateralised/partially collateralised/one-way collateralised/fully collateralised) , where applicable.
	 *
	 */
	@Override
	CollateralisationType3Code getCollateralisationCategory();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "133" * field "Action type"
	 *
	 * Provision Type of action taken on the contract.
	 *
	 */
	@Override
	MarginActionEnum getActionType();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "134" * field "Event Timestamp"
	 *
	 * Provision Date of occurrence of the event
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "10" * field "Unique Transaction Identifier (UTI)"
	 *
	 * Provision Unique identifier to denote the contract.
	 *
	 */
	String getUniqueTransactionIdentifierProprietary();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "[Internal]" * field "Technical Record Id (ISO)"
	 *
	 * Provision Unique technical identification of the original data for which the status is provided for the BDR.
	 *
	 */
	String getTechnicalRecordId();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "[Not in regulation]" * field "Execution agent of Counterparty 1"
	 *
	 * Provision LEI of the entity that entered into the Reportable Transaction as agent for the Reporting Entity without becoming a counterparty themselves.
	 *
	 */
	String getExecutionAgentOfTheCounterparty1();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Margin   
	 * dataElement "8" * field "Reporting specified person"
	 *
	 * Provision Identifier of the specified person with the reporting obligation in respect of the contract.
	 *
	 */
	String getReportingSpecifiedPerson();

	/*********************** Build Methods  ***********************/
	MASMarginReport build();
	
	MASMarginReport.MASMarginReportBuilder toBuilder();
	
	static MASMarginReport.MASMarginReportBuilder builder() {
		return new MASMarginReport.MASMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MASMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MASMarginReport> getType() {
		return MASMarginReport.class;
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
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty1"), String.class, getExecutionAgentOfTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("reportingSpecifiedPerson"), String.class, getReportingSpecifiedPerson(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MASMarginReportBuilder extends MASMarginReport, CommonMarginReport.CommonMarginReportBuilder {
		@Override
		MASMarginReport.MASMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		MASMarginReport.MASMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		MASMarginReport.MASMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		MASMarginReport.MASMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		MASMarginReport.MASMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		MASMarginReport.MASMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		MASMarginReport.MASMarginReportBuilder setUti(String uti);
		@Override
		MASMarginReport.MASMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		MASMarginReport.MASMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		MASMarginReport.MASMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		MASMarginReport.MASMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		MASMarginReport.MASMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		@Override
		MASMarginReport.MASMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		@Override
		MASMarginReport.MASMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		MASMarginReport.MASMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		MASMarginReport.MASMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		MASMarginReport.MASMarginReportBuilder setActionType(MarginActionEnum actionType);
		@Override
		MASMarginReport.MASMarginReportBuilder setEventDate(Date eventDate);
		@Override
		MASMarginReport.MASMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		MASMarginReport.MASMarginReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		MASMarginReport.MASMarginReportBuilder setVariationMarginCollateralPortfolioCodeOverriddenAsString(String variationMarginCollateralPortfolioCode);
		MASMarginReport.MASMarginReportBuilder setCollateralisationCategoryOverriddenAsCollateralisationType3Code(CollateralisationType3Code collateralisationCategory);
		MASMarginReport.MASMarginReportBuilder setActionTypeOverriddenAsMarginActionEnum(MarginActionEnum actionType);
		MASMarginReport.MASMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		MASMarginReport.MASMarginReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		MASMarginReport.MASMarginReportBuilder setTechnicalRecordId(String technicalRecordId);
		MASMarginReport.MASMarginReportBuilder setExecutionAgentOfTheCounterparty1(String executionAgentOfTheCounterparty1);
		MASMarginReport.MASMarginReportBuilder setReportingSpecifiedPerson(String reportingSpecifiedPerson);

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
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
			processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty1"), String.class, getExecutionAgentOfTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("reportingSpecifiedPerson"), String.class, getReportingSpecifiedPerson(), this);
		}
		

		MASMarginReport.MASMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of MASMarginReport  ***********************/
	class MASMarginReportImpl extends CommonMarginReport.CommonMarginReportImpl implements MASMarginReport {
		private final Boolean counterparty2IdentifierType;
		private final String variationMarginCollateralPortfolioCode;
		private final CollateralisationType3Code collateralisationCategory;
		private final MarginActionEnum actionType;
		private final ZonedDateTime eventTimestamp;
		private final String uniqueTransactionIdentifierProprietary;
		private final String technicalRecordId;
		private final String executionAgentOfTheCounterparty1;
		private final String reportingSpecifiedPerson;
		
		protected MASMarginReportImpl(MASMarginReport.MASMarginReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.variationMarginCollateralPortfolioCode = builder.getVariationMarginCollateralPortfolioCode();
			this.collateralisationCategory = builder.getCollateralisationCategory();
			this.actionType = builder.getActionType();
			this.eventTimestamp = builder.getEventTimestamp();
			this.uniqueTransactionIdentifierProprietary = builder.getUniqueTransactionIdentifierProprietary();
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.executionAgentOfTheCounterparty1 = builder.getExecutionAgentOfTheCounterparty1();
			this.reportingSpecifiedPerson = builder.getReportingSpecifiedPerson();
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
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralisationCategory")
		public CollateralisationType3Code getCollateralisationCategory() {
			return collateralisationCategory;
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
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		public String getUniqueTransactionIdentifierProprietary() {
			return uniqueTransactionIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionAgentOfTheCounterparty1")
		public String getExecutionAgentOfTheCounterparty1() {
			return executionAgentOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("reportingSpecifiedPerson")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSpecifiedPerson")
		public String getReportingSpecifiedPerson() {
			return reportingSpecifiedPerson;
		}
		
		@Override
		public MASMarginReport build() {
			return this;
		}
		
		@Override
		public MASMarginReport.MASMarginReportBuilder toBuilder() {
			MASMarginReport.MASMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MASMarginReport.MASMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getVariationMarginCollateralPortfolioCode()).ifPresent(builder::setVariationMarginCollateralPortfolioCodeOverriddenAsString);
			ofNullable(getCollateralisationCategory()).ifPresent(builder::setCollateralisationCategoryOverriddenAsCollateralisationType3Code);
			ofNullable(getActionType()).ifPresent(builder::setActionTypeOverriddenAsMarginActionEnum);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getUniqueTransactionIdentifierProprietary()).ifPresent(builder::setUniqueTransactionIdentifierProprietary);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordId);
			ofNullable(getExecutionAgentOfTheCounterparty1()).ifPresent(builder::setExecutionAgentOfTheCounterparty1);
			ofNullable(getReportingSpecifiedPerson()).ifPresent(builder::setReportingSpecifiedPerson);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MASMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(collateralisationCategory, _that.getCollateralisationCategory())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty1, _that.getExecutionAgentOfTheCounterparty1())) return false;
			if (!Objects.equals(reportingSpecifiedPerson, _that.getReportingSpecifiedPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (collateralisationCategory != null ? collateralisationCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty1 != null ? executionAgentOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (reportingSpecifiedPerson != null ? reportingSpecifiedPerson.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MASMarginReport {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"collateralisationCategory=" + this.collateralisationCategory + ", " +
				"actionType=" + this.actionType + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"executionAgentOfTheCounterparty1=" + this.executionAgentOfTheCounterparty1 + ", " +
				"reportingSpecifiedPerson=" + this.reportingSpecifiedPerson +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MASMarginReport  ***********************/
	class MASMarginReportBuilderImpl extends CommonMarginReport.CommonMarginReportBuilderImpl implements MASMarginReport.MASMarginReportBuilder {
	
		protected Boolean counterparty2IdentifierType;
		protected String variationMarginCollateralPortfolioCode;
		protected CollateralisationType3Code collateralisationCategory;
		protected MarginActionEnum actionType;
		protected ZonedDateTime eventTimestamp;
		protected String uniqueTransactionIdentifierProprietary;
		protected String technicalRecordId;
		protected String executionAgentOfTheCounterparty1;
		protected String reportingSpecifiedPerson;
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralisationCategory")
		public CollateralisationType3Code getCollateralisationCategory() {
			return collateralisationCategory;
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
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		public String getUniqueTransactionIdentifierProprietary() {
			return uniqueTransactionIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionAgentOfTheCounterparty1")
		public String getExecutionAgentOfTheCounterparty1() {
			return executionAgentOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("reportingSpecifiedPerson")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSpecifiedPerson")
		public String getReportingSpecifiedPerson() {
			return reportingSpecifiedPerson;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public MASMarginReport.MASMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASMarginReport.MASMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public MASMarginReport.MASMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralisationCategory")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCollateralisationCategoryOverriddenAsCollateralisationType3Code(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASMarginReport.MASMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			return setCollateralisationCategoryOverriddenAsCollateralisationType3Code(_collateralisationCategory);
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public MASMarginReport.MASMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public MASMarginReport.MASMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public MASMarginReport.MASMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginCollateralPortfolioCodeOverriddenAsString(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASMarginReport.MASMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			return setVariationMarginCollateralPortfolioCodeOverriddenAsString(_variationMarginCollateralPortfolioCode);
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public MASMarginReport.MASMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public MASMarginReport.MASMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public MASMarginReport.MASMarginReportBuilder setActionTypeOverriddenAsMarginActionEnum(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASMarginReport.MASMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			return setActionTypeOverriddenAsMarginActionEnum(_actionType);
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public MASMarginReport.MASMarginReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public MASMarginReport.MASMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASMarginReport.MASMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public MASMarginReport.MASMarginReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public MASMarginReport.MASMarginReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionAgentOfTheCounterparty1")
		@Override
		public MASMarginReport.MASMarginReportBuilder setExecutionAgentOfTheCounterparty1(String _executionAgentOfTheCounterparty1) {
			this.executionAgentOfTheCounterparty1 = _executionAgentOfTheCounterparty1 == null ? null : _executionAgentOfTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("reportingSpecifiedPerson")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingSpecifiedPerson")
		@Override
		public MASMarginReport.MASMarginReportBuilder setReportingSpecifiedPerson(String _reportingSpecifiedPerson) {
			this.reportingSpecifiedPerson = _reportingSpecifiedPerson == null ? null : _reportingSpecifiedPerson;
			return this;
		}
		
		@Override
		public MASMarginReport build() {
			return new MASMarginReport.MASMarginReportImpl(this);
		}
		
		@Override
		public MASMarginReport.MASMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MASMarginReport.MASMarginReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getCollateralisationCategory()!=null) return true;
			if (getActionType()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getUniqueTransactionIdentifierProprietary()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getExecutionAgentOfTheCounterparty1()!=null) return true;
			if (getReportingSpecifiedPerson()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MASMarginReport.MASMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MASMarginReport.MASMarginReportBuilder o = (MASMarginReport.MASMarginReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCodeOverriddenAsString);
			merger.mergeBasic(getCollateralisationCategory(), o.getCollateralisationCategory(), this::setCollateralisationCategoryOverriddenAsCollateralisationType3Code);
			merger.mergeBasic(getActionType(), o.getActionType(), this::setActionTypeOverriddenAsMarginActionEnum);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietary(), o.getUniqueTransactionIdentifierProprietary(), this::setUniqueTransactionIdentifierProprietary);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			merger.mergeBasic(getExecutionAgentOfTheCounterparty1(), o.getExecutionAgentOfTheCounterparty1(), this::setExecutionAgentOfTheCounterparty1);
			merger.mergeBasic(getReportingSpecifiedPerson(), o.getReportingSpecifiedPerson(), this::setReportingSpecifiedPerson);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MASMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(collateralisationCategory, _that.getCollateralisationCategory())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty1, _that.getExecutionAgentOfTheCounterparty1())) return false;
			if (!Objects.equals(reportingSpecifiedPerson, _that.getReportingSpecifiedPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (collateralisationCategory != null ? collateralisationCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty1 != null ? executionAgentOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (reportingSpecifiedPerson != null ? reportingSpecifiedPerson.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MASMarginReportBuilder {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"collateralisationCategory=" + this.collateralisationCategory + ", " +
				"actionType=" + this.actionType + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"executionAgentOfTheCounterparty1=" + this.executionAgentOfTheCounterparty1 + ", " +
				"reportingSpecifiedPerson=" + this.reportingSpecifiedPerson +
			'}' + " " + super.toString();
		}
	}
}
