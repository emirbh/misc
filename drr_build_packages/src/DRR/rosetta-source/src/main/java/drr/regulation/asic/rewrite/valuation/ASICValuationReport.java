package drr.regulation.asic.rewrite.valuation;

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
import drr.regulation.asic.rewrite.valuation.meta.ASICValuationReportMeta;
import drr.regulation.common.valuation.CommonValuationReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ASICValuationReport", builder=ASICValuationReport.ASICValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ASICValuationReport", model="drr", builder=ASICValuationReport.ASICValuationReportBuilderImpl.class, version="7.7.0")
public interface ASICValuationReport extends CommonValuationReport {

	ASICValuationReportMeta metaData = new ASICValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "8"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2
	             - Allowable Values:
	                 - true, for legal entities
	                 - false, for natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity.
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
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * table "1" * dataElement "8" * field "Counterparty 2 identifier type indicator"
	 *
	 * Provision For the identifier reported for Counterparty 2 (item 7 above), the applicable True or False value specified in column 5 of this item.
	 *
	 */
	@Override
	Boolean getCounterparty2IdentifierType();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * table "1" * dataElement "5" * field "Reporting entity"
	 *
	 * Provision The current LEI of the Reporting Entity
	 *
	 */
	@Override
	String getEntityResponsibleForReporting();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * table "1" * dataElement "104" * field "Report submitting entity"
	 *
	 * Provision The LEI of the person submitting the report of a Reportable Transaction.
	 *
	 */
	@Override
	String getReportSubmittingEntityID();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * dataElement "[Internal]" * field "Technical Record Id (ISO)"
	 *
	 * Provision Unique technical identification of the original data for which the status is provided for the BDR.
	 *
	 */
	@Override
	String getTechnicalRecordId();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * dataElement "[Not in Regulation]" * field "Execution Agent of Counterparty 2"
	 *
	 * Provision The Execution agent of Counterparty 2
	 *
	 */
	String getExecutionAgentOfTheCounterparty2();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * table "1" * dataElement "13" * field "Execution agent of the Counterparty 1"
	 *
	 * Provision If applicable, the LEI of the entity that entered into the Reportable Transaction as agent for the Reporting Entity without becoming a counterparty themselves.
	 *
	 */
	String getExecutionAgentOfTheCounterparty1();
	/**
	 *
	 * Body ASIC
	 * Corpus Dissemination Valuation   
	 * table "2" * dataElement "4" * field "Small-scale buy-side Entity indicator"
	 *
	 * Provision If applicable, an indicator that the Reporting Entity is making the report as a Small-scale Buy-side Entity.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240207"
	 *
	 * Provision in FpML a small bank indicator exists in clearing exceptions (http://www.fpml.org/coding-scheme/cftc-clearing-exception-and-exemptions-1-1.xml), also http://www.fpml.org/coding-scheme/party-role-3-9.xml when value is ExecutionAgent is defined as 'The (generally buy-side) organization'  we could use this data as a base to define the indicator in CDM
	 *
	 */
	String getSmallScaleBuySideEntityIndicator();

	/*********************** Build Methods  ***********************/
	ASICValuationReport build();
	
	ASICValuationReport.ASICValuationReportBuilder toBuilder();
	
	static ASICValuationReport.ASICValuationReportBuilder builder() {
		return new ASICValuationReport.ASICValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ASICValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ASICValuationReport> getType() {
		return ASICValuationReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
		processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
		processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
		processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
		processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
		processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), String.class, getCounterparty2IdentifierSource(), this);
		processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg1"), Date.class, getNextFloatingReferenceResetDateLeg1(), this);
		processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg2"), Date.class, getNextFloatingReferenceResetDateLeg2(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifier"), String.class, getUniqueTransactionIdentifier(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
		processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
		processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg1"), BigDecimal.class, getLastFloatingReferenceValueLeg1(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg2"), BigDecimal.class, getLastFloatingReferenceValueLeg2(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg1"), Date.class, getLastFloatingReferenceResetDateLeg1(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg2"), Date.class, getLastFloatingReferenceResetDateLeg2(), this);
		processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty2"), String.class, getExecutionAgentOfTheCounterparty2(), this);
		processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty1"), String.class, getExecutionAgentOfTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("smallScaleBuySideEntityIndicator"), String.class, getSmallScaleBuySideEntityIndicator(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ASICValuationReportBuilder extends ASICValuationReport, CommonValuationReport.CommonValuationReportBuilder {
		@Override
		ASICValuationReport.ASICValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setLevel(ReportLevelEnum level);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setEventDate(Date eventDate);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		@Override
		ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		ASICValuationReport.ASICValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		ASICValuationReport.ASICValuationReportBuilder setEntityResponsibleForReportingOverriddenAsString(String entityResponsibleForReporting);
		ASICValuationReport.ASICValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String reportSubmittingEntityID);
		ASICValuationReport.ASICValuationReportBuilder setTechnicalRecordIdOverriddenAsString(String technicalRecordId);
		ASICValuationReport.ASICValuationReportBuilder setExecutionAgentOfTheCounterparty2(String executionAgentOfTheCounterparty2);
		ASICValuationReport.ASICValuationReportBuilder setExecutionAgentOfTheCounterparty1(String executionAgentOfTheCounterparty1);
		ASICValuationReport.ASICValuationReportBuilder setSmallScaleBuySideEntityIndicator(String smallScaleBuySideEntityIndicator);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
			processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
			processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
			processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
			processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
			processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
			processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
			processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), String.class, getCounterparty2IdentifierSource(), this);
			processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg1"), Date.class, getNextFloatingReferenceResetDateLeg1(), this);
			processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg2"), Date.class, getNextFloatingReferenceResetDateLeg2(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifier"), String.class, getUniqueTransactionIdentifier(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
			processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
			processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg1"), BigDecimal.class, getLastFloatingReferenceValueLeg1(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg2"), BigDecimal.class, getLastFloatingReferenceValueLeg2(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg1"), Date.class, getLastFloatingReferenceResetDateLeg1(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg2"), Date.class, getLastFloatingReferenceResetDateLeg2(), this);
			processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty2"), String.class, getExecutionAgentOfTheCounterparty2(), this);
			processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty1"), String.class, getExecutionAgentOfTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("smallScaleBuySideEntityIndicator"), String.class, getSmallScaleBuySideEntityIndicator(), this);
		}
		

		ASICValuationReport.ASICValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of ASICValuationReport  ***********************/
	class ASICValuationReportImpl extends CommonValuationReport.CommonValuationReportImpl implements ASICValuationReport {
		private final Boolean counterparty2IdentifierType;
		private final String entityResponsibleForReporting;
		private final String reportSubmittingEntityID;
		private final String technicalRecordId;
		private final String executionAgentOfTheCounterparty2;
		private final String executionAgentOfTheCounterparty1;
		private final String smallScaleBuySideEntityIndicator;
		
		protected ASICValuationReportImpl(ASICValuationReport.ASICValuationReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.executionAgentOfTheCounterparty2 = builder.getExecutionAgentOfTheCounterparty2();
			this.executionAgentOfTheCounterparty1 = builder.getExecutionAgentOfTheCounterparty1();
			this.smallScaleBuySideEntityIndicator = builder.getSmallScaleBuySideEntityIndicator();
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
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
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
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty2")
		public String getExecutionAgentOfTheCounterparty2() {
			return executionAgentOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty1")
		public String getExecutionAgentOfTheCounterparty1() {
			return executionAgentOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("smallScaleBuySideEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("smallScaleBuySideEntityIndicator")
		public String getSmallScaleBuySideEntityIndicator() {
			return smallScaleBuySideEntityIndicator;
		}
		
		@Override
		public ASICValuationReport build() {
			return this;
		}
		
		@Override
		public ASICValuationReport.ASICValuationReportBuilder toBuilder() {
			ASICValuationReport.ASICValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ASICValuationReport.ASICValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReportingOverriddenAsString);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityIDOverriddenAsString);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordIdOverriddenAsString);
			ofNullable(getExecutionAgentOfTheCounterparty2()).ifPresent(builder::setExecutionAgentOfTheCounterparty2);
			ofNullable(getExecutionAgentOfTheCounterparty1()).ifPresent(builder::setExecutionAgentOfTheCounterparty1);
			ofNullable(getSmallScaleBuySideEntityIndicator()).ifPresent(builder::setSmallScaleBuySideEntityIndicator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ASICValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty2, _that.getExecutionAgentOfTheCounterparty2())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty1, _that.getExecutionAgentOfTheCounterparty1())) return false;
			if (!Objects.equals(smallScaleBuySideEntityIndicator, _that.getSmallScaleBuySideEntityIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty2 != null ? executionAgentOfTheCounterparty2.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty1 != null ? executionAgentOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (smallScaleBuySideEntityIndicator != null ? smallScaleBuySideEntityIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ASICValuationReport {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"executionAgentOfTheCounterparty2=" + this.executionAgentOfTheCounterparty2 + ", " +
				"executionAgentOfTheCounterparty1=" + this.executionAgentOfTheCounterparty1 + ", " +
				"smallScaleBuySideEntityIndicator=" + this.smallScaleBuySideEntityIndicator +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ASICValuationReport  ***********************/
	class ASICValuationReportBuilderImpl extends CommonValuationReport.CommonValuationReportBuilderImpl implements ASICValuationReport.ASICValuationReportBuilder {
	
		protected Boolean counterparty2IdentifierType;
		protected String entityResponsibleForReporting;
		protected String reportSubmittingEntityID;
		protected String technicalRecordId;
		protected String executionAgentOfTheCounterparty2;
		protected String executionAgentOfTheCounterparty1;
		protected String smallScaleBuySideEntityIndicator;
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
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
		@RosettaAttribute("executionAgentOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty2")
		public String getExecutionAgentOfTheCounterparty2() {
			return executionAgentOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty1")
		public String getExecutionAgentOfTheCounterparty1() {
			return executionAgentOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("smallScaleBuySideEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("smallScaleBuySideEntityIndicator")
		public String getSmallScaleBuySideEntityIndicator() {
			return smallScaleBuySideEntityIndicator;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setTechnicalRecordIdOverriddenAsString(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			return setTechnicalRecordIdOverriddenAsString(_technicalRecordId);
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			return setReportSubmittingEntityIDOverriddenAsString(_reportSubmittingEntityID);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setEntityResponsibleForReportingOverriddenAsString(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			return setEntityResponsibleForReportingOverriddenAsString(_entityResponsibleForReporting);
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentOfTheCounterparty2")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setExecutionAgentOfTheCounterparty2(String _executionAgentOfTheCounterparty2) {
			this.executionAgentOfTheCounterparty2 = _executionAgentOfTheCounterparty2 == null ? null : _executionAgentOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentOfTheCounterparty1")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setExecutionAgentOfTheCounterparty1(String _executionAgentOfTheCounterparty1) {
			this.executionAgentOfTheCounterparty1 = _executionAgentOfTheCounterparty1 == null ? null : _executionAgentOfTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("smallScaleBuySideEntityIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("smallScaleBuySideEntityIndicator")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder setSmallScaleBuySideEntityIndicator(String _smallScaleBuySideEntityIndicator) {
			this.smallScaleBuySideEntityIndicator = _smallScaleBuySideEntityIndicator == null ? null : _smallScaleBuySideEntityIndicator;
			return this;
		}
		
		@Override
		public ASICValuationReport build() {
			return new ASICValuationReport.ASICValuationReportImpl(this);
		}
		
		@Override
		public ASICValuationReport.ASICValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getExecutionAgentOfTheCounterparty2()!=null) return true;
			if (getExecutionAgentOfTheCounterparty1()!=null) return true;
			if (getSmallScaleBuySideEntityIndicator()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ASICValuationReport.ASICValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ASICValuationReport.ASICValuationReportBuilder o = (ASICValuationReport.ASICValuationReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReportingOverriddenAsString);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityIDOverriddenAsString);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordIdOverriddenAsString);
			merger.mergeBasic(getExecutionAgentOfTheCounterparty2(), o.getExecutionAgentOfTheCounterparty2(), this::setExecutionAgentOfTheCounterparty2);
			merger.mergeBasic(getExecutionAgentOfTheCounterparty1(), o.getExecutionAgentOfTheCounterparty1(), this::setExecutionAgentOfTheCounterparty1);
			merger.mergeBasic(getSmallScaleBuySideEntityIndicator(), o.getSmallScaleBuySideEntityIndicator(), this::setSmallScaleBuySideEntityIndicator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ASICValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty2, _that.getExecutionAgentOfTheCounterparty2())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty1, _that.getExecutionAgentOfTheCounterparty1())) return false;
			if (!Objects.equals(smallScaleBuySideEntityIndicator, _that.getSmallScaleBuySideEntityIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty2 != null ? executionAgentOfTheCounterparty2.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty1 != null ? executionAgentOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (smallScaleBuySideEntityIndicator != null ? smallScaleBuySideEntityIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ASICValuationReportBuilder {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"executionAgentOfTheCounterparty2=" + this.executionAgentOfTheCounterparty2 + ", " +
				"executionAgentOfTheCounterparty1=" + this.executionAgentOfTheCounterparty1 + ", " +
				"smallScaleBuySideEntityIndicator=" + this.smallScaleBuySideEntityIndicator +
			'}' + " " + super.toString();
		}
	}
}
