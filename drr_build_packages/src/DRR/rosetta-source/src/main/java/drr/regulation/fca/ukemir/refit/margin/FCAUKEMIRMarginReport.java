package drr.regulation.fca.ukemir.refit.margin;

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
import drr.regulation.fca.ukemir.refit.margin.meta.FCAUKEMIRMarginReportMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="FCAUKEMIRMarginReport", builder=FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="FCAUKEMIRMarginReport", model="drr", builder=FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilderImpl.class, version="7.7.0")
public interface FCAUKEMIRMarginReport extends CommonMarginReport {

	FCAUKEMIRMarginReportMeta metaData = new FCAUKEMIRMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Margin   
	 * table "3" * dataElement "29" * field "Event date"
	 *
	 * Provision Date on which the reportable event relating to the derivative contract and captured by the report took place. In the case of collateral update - the date for which the information contained in the report is provided.
	 *
	 */
	@Override
	Date getEventDate();
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance" 
	 * table "3" * dataElement "3" * field "Entity responsible for reporting"
	 *
	 * Provision Where a financial counterparty is solely responsible, and legally liable, for reporting on behalf of both counterparties in accordance with Article 9(1a) of Regulation (EU) No 648/2012 and the non-financial counterparty does not decide to report itself the details of its OTC derivative contracts with the financial counterparty, the unique code identifying that financial counterparty. Where a management company is responsible, and legally liable, for reporting on behalf of an Undertaking for Collective Investment in Transferable Securities (UCITS) in accordance with Article 9(1b) of that Regulation, the unique code identifying that management company. Where an Alternative Investment Fund Manager (AIFM) is responsible, and legally liable, for reporting on behalf of an Alternative Investment Fund (AIF) in accordance with Article 9(1c) of that Regulation, the unique code identifying that AIFM. Where the trustees or managers of an occupational pension scheme are responsible, and legally liable, for reporting on its behalf in accordance with Article 9(1d) of that Regulation, the unique code identifying those trustees on managers. This field is applicable only to the OTC derivatives.
	 *
	 */
	String getEntityResponsibleForReporting();
	FCAUKEMIRNonReportableCollateralData getNonReportable();
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Margin   
	 * dataElement "3.30" * field "Execution agent"
	 *
	 * Provision LEI identifying the entity that executed the transaction on behalf of the counterparty, and binds the counterparty to the terms of the transaction, but is not a broker.
	 *
	 */
	String getExecutionAgentOfCounterparty1();
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Margin   
	 * dataElement "3.30" * field "Execution agent"
	 *
	 * Provision LEI identifying the entity that executed the transaction on behalf of the counterparty, and binds the counterparty to the terms of the transaction, but is not a broker.
	 *
	 */
	String getExecutionAgentOfCounterparty2();

	/*********************** Build Methods  ***********************/
	FCAUKEMIRMarginReport build();
	
	FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder toBuilder();
	
	static FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder builder() {
		return new FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FCAUKEMIRMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FCAUKEMIRMarginReport> getType() {
		return FCAUKEMIRMarginReport.class;
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
		processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
		processRosetta(path.newSubPath("nonReportable"), processor, FCAUKEMIRNonReportableCollateralData.class, getNonReportable());
		processor.processBasic(path.newSubPath("executionAgentOfCounterparty1"), String.class, getExecutionAgentOfCounterparty1(), this);
		processor.processBasic(path.newSubPath("executionAgentOfCounterparty2"), String.class, getExecutionAgentOfCounterparty2(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FCAUKEMIRMarginReportBuilder extends FCAUKEMIRMarginReport, CommonMarginReport.CommonMarginReportBuilder {
		FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder getOrCreateNonReportable();
		@Override
		FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder getNonReportable();
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setUti(String uti);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setActionType(MarginActionEnum actionType);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEventDate(Date eventDate);
		@Override
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEventDateOverriddenAsDate(Date eventDate);
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setNonReportable(FCAUKEMIRNonReportableCollateralData nonReportable);
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExecutionAgentOfCounterparty1(String executionAgentOfCounterparty1);
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExecutionAgentOfCounterparty2(String executionAgentOfCounterparty2);

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
			processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
			processRosetta(path.newSubPath("nonReportable"), processor, FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder.class, getNonReportable());
			processor.processBasic(path.newSubPath("executionAgentOfCounterparty1"), String.class, getExecutionAgentOfCounterparty1(), this);
			processor.processBasic(path.newSubPath("executionAgentOfCounterparty2"), String.class, getExecutionAgentOfCounterparty2(), this);
		}
		

		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of FCAUKEMIRMarginReport  ***********************/
	class FCAUKEMIRMarginReportImpl extends CommonMarginReport.CommonMarginReportImpl implements FCAUKEMIRMarginReport {
		private final Date eventDate;
		private final String entityResponsibleForReporting;
		private final FCAUKEMIRNonReportableCollateralData nonReportable;
		private final String executionAgentOfCounterparty1;
		private final String executionAgentOfCounterparty2;
		
		protected FCAUKEMIRMarginReportImpl(FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder builder) {
			super(builder);
			this.eventDate = builder.getEventDate();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
			this.nonReportable = ofNullable(builder.getNonReportable()).map(f->f.build()).orElse(null);
			this.executionAgentOfCounterparty1 = builder.getExecutionAgentOfCounterparty1();
			this.executionAgentOfCounterparty2 = builder.getExecutionAgentOfCounterparty2();
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
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public FCAUKEMIRNonReportableCollateralData getNonReportable() {
			return nonReportable;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfCounterparty1")
		public String getExecutionAgentOfCounterparty1() {
			return executionAgentOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfCounterparty2")
		public String getExecutionAgentOfCounterparty2() {
			return executionAgentOfCounterparty2;
		}
		
		@Override
		public FCAUKEMIRMarginReport build() {
			return this;
		}
		
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder toBuilder() {
			FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventDate()).ifPresent(builder::setEventDateOverriddenAsDate);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReporting);
			ofNullable(getNonReportable()).ifPresent(builder::setNonReportable);
			ofNullable(getExecutionAgentOfCounterparty1()).ifPresent(builder::setExecutionAgentOfCounterparty1);
			ofNullable(getExecutionAgentOfCounterparty2()).ifPresent(builder::setExecutionAgentOfCounterparty2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAUKEMIRMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
			if (!Objects.equals(executionAgentOfCounterparty1, _that.getExecutionAgentOfCounterparty1())) return false;
			if (!Objects.equals(executionAgentOfCounterparty2, _that.getExecutionAgentOfCounterparty2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfCounterparty1 != null ? executionAgentOfCounterparty1.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfCounterparty2 != null ? executionAgentOfCounterparty2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRMarginReport {" +
				"eventDate=" + this.eventDate + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"nonReportable=" + this.nonReportable + ", " +
				"executionAgentOfCounterparty1=" + this.executionAgentOfCounterparty1 + ", " +
				"executionAgentOfCounterparty2=" + this.executionAgentOfCounterparty2 +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FCAUKEMIRMarginReport  ***********************/
	class FCAUKEMIRMarginReportBuilderImpl extends CommonMarginReport.CommonMarginReportBuilderImpl implements FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder {
	
		protected Date eventDate;
		protected String entityResponsibleForReporting;
		protected FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder nonReportable;
		protected String executionAgentOfCounterparty1;
		protected String executionAgentOfCounterparty2;
		
		@Override
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder getNonReportable() {
			return nonReportable;
		}
		
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder getOrCreateNonReportable() {
			FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder result;
			if (nonReportable!=null) {
				result = nonReportable;
			}
			else {
				result = nonReportable = FCAUKEMIRNonReportableCollateralData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfCounterparty1")
		public String getExecutionAgentOfCounterparty1() {
			return executionAgentOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfCounterparty2")
		public String getExecutionAgentOfCounterparty2() {
			return executionAgentOfCounterparty2;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventDate")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEventDateOverriddenAsDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEventDate(Date _eventDate) {
			return setEventDateOverriddenAsDate(_eventDate);
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTimestamp")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setNonReportable(FCAUKEMIRNonReportableCollateralData _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("executionAgentOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentOfCounterparty1")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExecutionAgentOfCounterparty1(String _executionAgentOfCounterparty1) {
			this.executionAgentOfCounterparty1 = _executionAgentOfCounterparty1 == null ? null : _executionAgentOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentOfCounterparty2")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder setExecutionAgentOfCounterparty2(String _executionAgentOfCounterparty2) {
			this.executionAgentOfCounterparty2 = _executionAgentOfCounterparty2 == null ? null : _executionAgentOfCounterparty2;
			return this;
		}
		
		@Override
		public FCAUKEMIRMarginReport build() {
			return new FCAUKEMIRMarginReport.FCAUKEMIRMarginReportImpl(this);
		}
		
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder prune() {
			super.prune();
			if (nonReportable!=null && !nonReportable.prune().hasData()) nonReportable = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventDate()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getNonReportable()!=null && getNonReportable().hasData()) return true;
			if (getExecutionAgentOfCounterparty1()!=null) return true;
			if (getExecutionAgentOfCounterparty2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder o = (FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder) other;
			
			merger.mergeRosetta(getNonReportable(), o.getNonReportable(), this::setNonReportable);
			
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDateOverriddenAsDate);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			merger.mergeBasic(getExecutionAgentOfCounterparty1(), o.getExecutionAgentOfCounterparty1(), this::setExecutionAgentOfCounterparty1);
			merger.mergeBasic(getExecutionAgentOfCounterparty2(), o.getExecutionAgentOfCounterparty2(), this::setExecutionAgentOfCounterparty2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAUKEMIRMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
			if (!Objects.equals(executionAgentOfCounterparty1, _that.getExecutionAgentOfCounterparty1())) return false;
			if (!Objects.equals(executionAgentOfCounterparty2, _that.getExecutionAgentOfCounterparty2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfCounterparty1 != null ? executionAgentOfCounterparty1.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfCounterparty2 != null ? executionAgentOfCounterparty2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRMarginReportBuilder {" +
				"eventDate=" + this.eventDate + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"nonReportable=" + this.nonReportable + ", " +
				"executionAgentOfCounterparty1=" + this.executionAgentOfCounterparty1 + ", " +
				"executionAgentOfCounterparty2=" + this.executionAgentOfCounterparty2 +
			'}' + " " + super.toString();
		}
	}
}
