package drr.regulation.csa.rewrite.valuation;

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
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.csa.rewrite.valuation.meta.CSAValuationReportMeta;
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
@RosettaDataType(value="CSAValuationReport", builder=CSAValuationReport.CSAValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CSAValuationReport", model="drr", builder=CSAValuationReport.CSAValuationReportBuilderImpl.class, version="7.7.0")
public interface CSAValuationReport extends CommonValuationReport {

	CSAValuationReportMeta metaData = new CSAValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation   
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
	@Override
	String getCounterparty2IdentifierSource();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation   
	 * dataElement "21" * field "Submitter Identifier"
	 *
	 * Provision Identifier of the entity submitting the data to the swap data repository (TR), the submitter identifier will be the same as the reporting counterparty or  swap execution facility (SEF) unless they use a third-party service provider, to submit the data to SDR in which case, report the underlier of the third party service provider. 
	 *
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation   
	 * dataElement "21" * field "Submitter Identifier" * footnote "15"
	 *
	 * Provision References to swap data repository or SDR in CFTC data element explanations should be read to mean designated / recognized trade repository.
	 *
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation   
	 * dataElement "21" * field "Submitter Identifier" * footnote "16"
	 *
	 * Provision References to swap execution facility or SEF in CFTC data element explanations should be read to mean derivatives trading facility / facility or platform for trading derivatives.
	 *
	 */
	@Override
	String getReportSubmittingEntityID();
	DTCCAdditionalValuationFields getDtccValuationFields();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation   
	 * dataElement "117" * field "Unique Product Identifier"
	 *
	 * Provision A unique set of characters that represents a particular OTC derivative.
	 *
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation   
	 * dataElement "117" * field "Unique Product Identifier" * footnote "60"
	 *
	 * Provision Refer to section 1.2.6 Use of UPI Instrument Types for explanation on Unique Product Identifiers.
	 *
	 */
	String getUniqueProductIdentifier();

	/*********************** Build Methods  ***********************/
	CSAValuationReport build();
	
	CSAValuationReport.CSAValuationReportBuilder toBuilder();
	
	static CSAValuationReport.CSAValuationReportBuilder builder() {
		return new CSAValuationReport.CSAValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAValuationReport> getType() {
		return CSAValuationReport.class;
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
		processRosetta(path.newSubPath("dtccValuationFields"), processor, DTCCAdditionalValuationFields.class, getDtccValuationFields());
		processor.processBasic(path.newSubPath("uniqueProductIdentifier"), String.class, getUniqueProductIdentifier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAValuationReportBuilder extends CSAValuationReport, CommonValuationReport.CommonValuationReportBuilder {
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder getOrCreateDtccValuationFields();
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder getDtccValuationFields();
		@Override
		CSAValuationReport.CSAValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setLevel(ReportLevelEnum level);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setEventDate(Date eventDate);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		@Override
		CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		CSAValuationReport.CSAValuationReportBuilder setCounterparty2IdentifierSourceOverriddenAsString(String counterparty2IdentifierSource);
		CSAValuationReport.CSAValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String reportSubmittingEntityID);
		CSAValuationReport.CSAValuationReportBuilder setDtccValuationFields(DTCCAdditionalValuationFields dtccValuationFields);
		CSAValuationReport.CSAValuationReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);

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
			processRosetta(path.newSubPath("dtccValuationFields"), processor, DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder.class, getDtccValuationFields());
			processor.processBasic(path.newSubPath("uniqueProductIdentifier"), String.class, getUniqueProductIdentifier(), this);
		}
		

		CSAValuationReport.CSAValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of CSAValuationReport  ***********************/
	class CSAValuationReportImpl extends CommonValuationReport.CommonValuationReportImpl implements CSAValuationReport {
		private final String counterparty2IdentifierSource;
		private final String reportSubmittingEntityID;
		private final DTCCAdditionalValuationFields dtccValuationFields;
		private final String uniqueProductIdentifier;
		
		protected CSAValuationReportImpl(CSAValuationReport.CSAValuationReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierSource = builder.getCounterparty2IdentifierSource();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.dtccValuationFields = ofNullable(builder.getDtccValuationFields()).map(f->f.build()).orElse(null);
			this.uniqueProductIdentifier = builder.getUniqueProductIdentifier();
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
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("dtccValuationFields")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtccValuationFields")
		public DTCCAdditionalValuationFields getDtccValuationFields() {
			return dtccValuationFields;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uniqueProductIdentifier")
		public String getUniqueProductIdentifier() {
			return uniqueProductIdentifier;
		}
		
		@Override
		public CSAValuationReport build() {
			return this;
		}
		
		@Override
		public CSAValuationReport.CSAValuationReportBuilder toBuilder() {
			CSAValuationReport.CSAValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAValuationReport.CSAValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierSource()).ifPresent(builder::setCounterparty2IdentifierSourceOverriddenAsString);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityIDOverriddenAsString);
			ofNullable(getDtccValuationFields()).ifPresent(builder::setDtccValuationFields);
			ofNullable(getUniqueProductIdentifier()).ifPresent(builder::setUniqueProductIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSAValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(dtccValuationFields, _that.getDtccValuationFields())) return false;
			if (!Objects.equals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (dtccValuationFields != null ? dtccValuationFields.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAValuationReport {" +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"dtccValuationFields=" + this.dtccValuationFields + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CSAValuationReport  ***********************/
	class CSAValuationReportBuilderImpl extends CommonValuationReport.CommonValuationReportBuilderImpl implements CSAValuationReport.CSAValuationReportBuilder {
	
		protected String counterparty2IdentifierSource;
		protected String reportSubmittingEntityID;
		protected DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder dtccValuationFields;
		protected String uniqueProductIdentifier;
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public String getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
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
		@RosettaAttribute("dtccValuationFields")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtccValuationFields")
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder getDtccValuationFields() {
			return dtccValuationFields;
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder getOrCreateDtccValuationFields() {
			DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder result;
			if (dtccValuationFields!=null) {
				result = dtccValuationFields;
			}
			else {
				result = dtccValuationFields = DTCCAdditionalValuationFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uniqueProductIdentifier")
		public String getUniqueProductIdentifier() {
			return uniqueProductIdentifier;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			return setReportSubmittingEntityIDOverriddenAsString(_reportSubmittingEntityID);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setCounterparty2IdentifierSourceOverriddenAsString(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			return setCounterparty2IdentifierSourceOverriddenAsString(_counterparty2IdentifierSource);
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("dtccValuationFields")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtccValuationFields")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setDtccValuationFields(DTCCAdditionalValuationFields _dtccValuationFields) {
			this.dtccValuationFields = _dtccValuationFields == null ? null : _dtccValuationFields.toBuilder();
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@Override
		public CSAValuationReport build() {
			return new CSAValuationReport.CSAValuationReportImpl(this);
		}
		
		@Override
		public CSAValuationReport.CSAValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder prune() {
			super.prune();
			if (dtccValuationFields!=null && !dtccValuationFields.prune().hasData()) dtccValuationFields = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getDtccValuationFields()!=null && getDtccValuationFields().hasData()) return true;
			if (getUniqueProductIdentifier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAValuationReport.CSAValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CSAValuationReport.CSAValuationReportBuilder o = (CSAValuationReport.CSAValuationReportBuilder) other;
			
			merger.mergeRosetta(getDtccValuationFields(), o.getDtccValuationFields(), this::setDtccValuationFields);
			
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSourceOverriddenAsString);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityIDOverriddenAsString);
			merger.mergeBasic(getUniqueProductIdentifier(), o.getUniqueProductIdentifier(), this::setUniqueProductIdentifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSAValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(dtccValuationFields, _that.getDtccValuationFields())) return false;
			if (!Objects.equals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (dtccValuationFields != null ? dtccValuationFields.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAValuationReportBuilder {" +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"dtccValuationFields=" + this.dtccValuationFields + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier +
			'}' + " " + super.toString();
		}
	}
}
