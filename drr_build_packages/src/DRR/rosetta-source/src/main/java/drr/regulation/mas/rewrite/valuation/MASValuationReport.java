package drr.regulation.mas.rewrite.valuation;

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
import drr.regulation.common.valuation.CommonValuationReport;
import drr.regulation.mas.rewrite.valuation.meta.MASValuationReportMeta;
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
@RosettaDataType(value="MASValuationReport", builder=MASValuationReport.MASValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="MASValuationReport", model="drr", builder=MASValuationReport.MASValuationReportBuilderImpl.class, version="7.7.0")
public interface MASValuationReport extends CommonValuationReport {

	MASValuationReportMeta metaData = new MASValuationReportMeta();

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
	 * Body MAS
	 * Corpus Dissemination Valuation   
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
	 * Corpus Dissemination Valuation   
	 * dataElement "9" * field "Data submitter"
	 *
	 * Provision Identifier of the entity submitting information on the contract, which is reported to a licensed trade repository or licensed foreign trade repository.
	 *
	 */
	@Override
	String getReportSubmittingEntityID();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Valuation   
	 * dataElement "[Not in regulation]" * field "Execution agent of Counterparty 1"
	 *
	 * Provision LEI of the entity that entered into the Reportable Transaction as agent for the Reporting Entity without becoming a counterparty themselves.
	 *
	 */
	String getExecutionAgentOfTheCounterparty1();
	/**
	 *
	 * Body MAS
	 * Corpus Dissemination Valuation   
	 * dataElement "[Not in regulation]" * field "Execution agent of Counterparty 2"
	 *
	 * Provision The Execution agent of the Counterparty 2.
	 *
	 */
	String getExecutionAgentOfTheCounterparty2();

	/*********************** Build Methods  ***********************/
	MASValuationReport build();
	
	MASValuationReport.MASValuationReportBuilder toBuilder();
	
	static MASValuationReport.MASValuationReportBuilder builder() {
		return new MASValuationReport.MASValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MASValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MASValuationReport> getType() {
		return MASValuationReport.class;
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
		processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty1"), String.class, getExecutionAgentOfTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty2"), String.class, getExecutionAgentOfTheCounterparty2(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MASValuationReportBuilder extends MASValuationReport, CommonValuationReport.CommonValuationReportBuilder {
		@Override
		MASValuationReport.MASValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		MASValuationReport.MASValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		MASValuationReport.MASValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		MASValuationReport.MASValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		MASValuationReport.MASValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		MASValuationReport.MASValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		MASValuationReport.MASValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		MASValuationReport.MASValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		MASValuationReport.MASValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		MASValuationReport.MASValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		MASValuationReport.MASValuationReportBuilder setLevel(ReportLevelEnum level);
		@Override
		MASValuationReport.MASValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		MASValuationReport.MASValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		MASValuationReport.MASValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		MASValuationReport.MASValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		@Override
		MASValuationReport.MASValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		@Override
		MASValuationReport.MASValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		@Override
		MASValuationReport.MASValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		MASValuationReport.MASValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		MASValuationReport.MASValuationReportBuilder setEventDate(Date eventDate);
		@Override
		MASValuationReport.MASValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		MASValuationReport.MASValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		@Override
		MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		@Override
		MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		@Override
		MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		MASValuationReport.MASValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		MASValuationReport.MASValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String reportSubmittingEntityID);
		MASValuationReport.MASValuationReportBuilder setExecutionAgentOfTheCounterparty1(String executionAgentOfTheCounterparty1);
		MASValuationReport.MASValuationReportBuilder setExecutionAgentOfTheCounterparty2(String executionAgentOfTheCounterparty2);

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
			processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty1"), String.class, getExecutionAgentOfTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("executionAgentOfTheCounterparty2"), String.class, getExecutionAgentOfTheCounterparty2(), this);
		}
		

		MASValuationReport.MASValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of MASValuationReport  ***********************/
	class MASValuationReportImpl extends CommonValuationReport.CommonValuationReportImpl implements MASValuationReport {
		private final Boolean counterparty2IdentifierType;
		private final String reportSubmittingEntityID;
		private final String executionAgentOfTheCounterparty1;
		private final String executionAgentOfTheCounterparty2;
		
		protected MASValuationReportImpl(MASValuationReport.MASValuationReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.executionAgentOfTheCounterparty1 = builder.getExecutionAgentOfTheCounterparty1();
			this.executionAgentOfTheCounterparty2 = builder.getExecutionAgentOfTheCounterparty2();
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
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty1")
		public String getExecutionAgentOfTheCounterparty1() {
			return executionAgentOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty2")
		public String getExecutionAgentOfTheCounterparty2() {
			return executionAgentOfTheCounterparty2;
		}
		
		@Override
		public MASValuationReport build() {
			return this;
		}
		
		@Override
		public MASValuationReport.MASValuationReportBuilder toBuilder() {
			MASValuationReport.MASValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MASValuationReport.MASValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityIDOverriddenAsString);
			ofNullable(getExecutionAgentOfTheCounterparty1()).ifPresent(builder::setExecutionAgentOfTheCounterparty1);
			ofNullable(getExecutionAgentOfTheCounterparty2()).ifPresent(builder::setExecutionAgentOfTheCounterparty2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MASValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty1, _that.getExecutionAgentOfTheCounterparty1())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty2, _that.getExecutionAgentOfTheCounterparty2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty1 != null ? executionAgentOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty2 != null ? executionAgentOfTheCounterparty2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MASValuationReport {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"executionAgentOfTheCounterparty1=" + this.executionAgentOfTheCounterparty1 + ", " +
				"executionAgentOfTheCounterparty2=" + this.executionAgentOfTheCounterparty2 +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MASValuationReport  ***********************/
	class MASValuationReportBuilderImpl extends CommonValuationReport.CommonValuationReportBuilderImpl implements MASValuationReport.MASValuationReportBuilder {
	
		protected Boolean counterparty2IdentifierType;
		protected String reportSubmittingEntityID;
		protected String executionAgentOfTheCounterparty1;
		protected String executionAgentOfTheCounterparty2;
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty1")
		public String getExecutionAgentOfTheCounterparty1() {
			return executionAgentOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("executionAgentOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentOfTheCounterparty2")
		public String getExecutionAgentOfTheCounterparty2() {
			return executionAgentOfTheCounterparty2;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public MASValuationReport.MASValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public MASValuationReport.MASValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public MASValuationReport.MASValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASValuationReport.MASValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public MASValuationReport.MASValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public MASValuationReport.MASValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public MASValuationReport.MASValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public MASValuationReport.MASValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public MASValuationReport.MASValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public MASValuationReport.MASValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public MASValuationReport.MASValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public MASValuationReport.MASValuationReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public MASValuationReport.MASValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public MASValuationReport.MASValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public MASValuationReport.MASValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			return setReportSubmittingEntityIDOverriddenAsString(_reportSubmittingEntityID);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public MASValuationReport.MASValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public MASValuationReport.MASValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public MASValuationReport.MASValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public MASValuationReport.MASValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public MASValuationReport.MASValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public MASValuationReport.MASValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public MASValuationReport.MASValuationReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public MASValuationReport.MASValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public MASValuationReport.MASValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public MASValuationReport.MASValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentOfTheCounterparty1")
		@Override
		public MASValuationReport.MASValuationReportBuilder setExecutionAgentOfTheCounterparty1(String _executionAgentOfTheCounterparty1) {
			this.executionAgentOfTheCounterparty1 = _executionAgentOfTheCounterparty1 == null ? null : _executionAgentOfTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentOfTheCounterparty2")
		@Override
		public MASValuationReport.MASValuationReportBuilder setExecutionAgentOfTheCounterparty2(String _executionAgentOfTheCounterparty2) {
			this.executionAgentOfTheCounterparty2 = _executionAgentOfTheCounterparty2 == null ? null : _executionAgentOfTheCounterparty2;
			return this;
		}
		
		@Override
		public MASValuationReport build() {
			return new MASValuationReport.MASValuationReportImpl(this);
		}
		
		@Override
		public MASValuationReport.MASValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MASValuationReport.MASValuationReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getExecutionAgentOfTheCounterparty1()!=null) return true;
			if (getExecutionAgentOfTheCounterparty2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MASValuationReport.MASValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MASValuationReport.MASValuationReportBuilder o = (MASValuationReport.MASValuationReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityIDOverriddenAsString);
			merger.mergeBasic(getExecutionAgentOfTheCounterparty1(), o.getExecutionAgentOfTheCounterparty1(), this::setExecutionAgentOfTheCounterparty1);
			merger.mergeBasic(getExecutionAgentOfTheCounterparty2(), o.getExecutionAgentOfTheCounterparty2(), this::setExecutionAgentOfTheCounterparty2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MASValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty1, _that.getExecutionAgentOfTheCounterparty1())) return false;
			if (!Objects.equals(executionAgentOfTheCounterparty2, _that.getExecutionAgentOfTheCounterparty2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty1 != null ? executionAgentOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (executionAgentOfTheCounterparty2 != null ? executionAgentOfTheCounterparty2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MASValuationReportBuilder {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"executionAgentOfTheCounterparty1=" + this.executionAgentOfTheCounterparty1 + ", " +
				"executionAgentOfTheCounterparty2=" + this.executionAgentOfTheCounterparty2 +
			'}' + " " + super.toString();
		}
	}
}
