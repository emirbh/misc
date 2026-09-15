package drr.regulation.common.valuation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import drr.regulation.common.valuation.meta.CommonValuationReportMeta;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Common Valuation Report represents common attributes for the Valuation report
 * @version 7.7.0
 */
@RosettaDataType(value="CommonValuationReport", builder=CommonValuationReport.CommonValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CommonValuationReport", model="drr", builder=CommonValuationReport.CommonValuationReportBuilderImpl.class, version="7.7.0")
public interface CommonValuationReport extends CriticalDataElement {

	CommonValuationReportMeta metaData = new CommonValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	String getTechnicalRecordId();
	String getReportSubmittingEntityID();
	String getEntityResponsibleForReporting();
	String getCounterparty2IdentifierSource();
	Date getNextFloatingReferenceResetDateLeg1();
	Date getNextFloatingReferenceResetDateLeg2();
	String getUniqueTransactionIdentifier();
	String getUniqueTransactionIdentifierProprietary();
	Date getEventDate();
	String getVariationMarginCollateralPortfolioCode();
	String getInitialMarginCollateralPortfolioCode();
	BigDecimal getLastFloatingReferenceValueLeg1();
	BigDecimal getLastFloatingReferenceValueLeg2();
	Date getLastFloatingReferenceResetDateLeg1();
	Date getLastFloatingReferenceResetDateLeg2();

	/*********************** Build Methods  ***********************/
	CommonValuationReport build();
	
	CommonValuationReport.CommonValuationReportBuilder toBuilder();
	
	static CommonValuationReport.CommonValuationReportBuilder builder() {
		return new CommonValuationReport.CommonValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonValuationReport> getType() {
		return CommonValuationReport.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonValuationReportBuilder extends CommonValuationReport, CriticalDataElement.CriticalDataElementBuilder {
		@Override
		CommonValuationReport.CommonValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		CommonValuationReport.CommonValuationReportBuilder setLevel(ReportLevelEnum level);
		CommonValuationReport.CommonValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		CommonValuationReport.CommonValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		CommonValuationReport.CommonValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		CommonValuationReport.CommonValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		CommonValuationReport.CommonValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		CommonValuationReport.CommonValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		CommonValuationReport.CommonValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		CommonValuationReport.CommonValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		CommonValuationReport.CommonValuationReportBuilder setEventDate(Date eventDate);
		CommonValuationReport.CommonValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		CommonValuationReport.CommonValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);

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
		}
		

		CommonValuationReport.CommonValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of CommonValuationReport  ***********************/
	class CommonValuationReportImpl extends CriticalDataElement.CriticalDataElementImpl implements CommonValuationReport {
		private final String technicalRecordId;
		private final String reportSubmittingEntityID;
		private final String entityResponsibleForReporting;
		private final String counterparty2IdentifierSource;
		private final Date nextFloatingReferenceResetDateLeg1;
		private final Date nextFloatingReferenceResetDateLeg2;
		private final String uniqueTransactionIdentifier;
		private final String uniqueTransactionIdentifierProprietary;
		private final Date eventDate;
		private final String variationMarginCollateralPortfolioCode;
		private final String initialMarginCollateralPortfolioCode;
		private final BigDecimal lastFloatingReferenceValueLeg1;
		private final BigDecimal lastFloatingReferenceValueLeg2;
		private final Date lastFloatingReferenceResetDateLeg1;
		private final Date lastFloatingReferenceResetDateLeg2;
		
		protected CommonValuationReportImpl(CommonValuationReport.CommonValuationReportBuilder builder) {
			super(builder);
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
			this.counterparty2IdentifierSource = builder.getCounterparty2IdentifierSource();
			this.nextFloatingReferenceResetDateLeg1 = builder.getNextFloatingReferenceResetDateLeg1();
			this.nextFloatingReferenceResetDateLeg2 = builder.getNextFloatingReferenceResetDateLeg2();
			this.uniqueTransactionIdentifier = builder.getUniqueTransactionIdentifier();
			this.uniqueTransactionIdentifierProprietary = builder.getUniqueTransactionIdentifierProprietary();
			this.eventDate = builder.getEventDate();
			this.variationMarginCollateralPortfolioCode = builder.getVariationMarginCollateralPortfolioCode();
			this.initialMarginCollateralPortfolioCode = builder.getInitialMarginCollateralPortfolioCode();
			this.lastFloatingReferenceValueLeg1 = builder.getLastFloatingReferenceValueLeg1();
			this.lastFloatingReferenceValueLeg2 = builder.getLastFloatingReferenceValueLeg2();
			this.lastFloatingReferenceResetDateLeg1 = builder.getLastFloatingReferenceResetDateLeg1();
			this.lastFloatingReferenceResetDateLeg2 = builder.getLastFloatingReferenceResetDateLeg2();
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		public String getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		public Date getNextFloatingReferenceResetDateLeg1() {
			return nextFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		public Date getNextFloatingReferenceResetDateLeg2() {
			return nextFloatingReferenceResetDateLeg2;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		public BigDecimal getLastFloatingReferenceValueLeg1() {
			return lastFloatingReferenceValueLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		public BigDecimal getLastFloatingReferenceValueLeg2() {
			return lastFloatingReferenceValueLeg2;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		public Date getLastFloatingReferenceResetDateLeg1() {
			return lastFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		public Date getLastFloatingReferenceResetDateLeg2() {
			return lastFloatingReferenceResetDateLeg2;
		}
		
		@Override
		public CommonValuationReport build() {
			return this;
		}
		
		@Override
		public CommonValuationReport.CommonValuationReportBuilder toBuilder() {
			CommonValuationReport.CommonValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonValuationReport.CommonValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordId);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityID);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReporting);
			ofNullable(getCounterparty2IdentifierSource()).ifPresent(builder::setCounterparty2IdentifierSource);
			ofNullable(getNextFloatingReferenceResetDateLeg1()).ifPresent(builder::setNextFloatingReferenceResetDateLeg1);
			ofNullable(getNextFloatingReferenceResetDateLeg2()).ifPresent(builder::setNextFloatingReferenceResetDateLeg2);
			ofNullable(getUniqueTransactionIdentifier()).ifPresent(builder::setUniqueTransactionIdentifier);
			ofNullable(getUniqueTransactionIdentifierProprietary()).ifPresent(builder::setUniqueTransactionIdentifierProprietary);
			ofNullable(getEventDate()).ifPresent(builder::setEventDate);
			ofNullable(getVariationMarginCollateralPortfolioCode()).ifPresent(builder::setVariationMarginCollateralPortfolioCode);
			ofNullable(getInitialMarginCollateralPortfolioCode()).ifPresent(builder::setInitialMarginCollateralPortfolioCode);
			ofNullable(getLastFloatingReferenceValueLeg1()).ifPresent(builder::setLastFloatingReferenceValueLeg1);
			ofNullable(getLastFloatingReferenceValueLeg2()).ifPresent(builder::setLastFloatingReferenceValueLeg2);
			ofNullable(getLastFloatingReferenceResetDateLeg1()).ifPresent(builder::setLastFloatingReferenceResetDateLeg1);
			ofNullable(getLastFloatingReferenceResetDateLeg2()).ifPresent(builder::setLastFloatingReferenceResetDateLeg2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg1, _that.getNextFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg2, _that.getNextFloatingReferenceResetDateLeg2())) return false;
			if (!Objects.equals(uniqueTransactionIdentifier, _that.getUniqueTransactionIdentifier())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg1, _that.getLastFloatingReferenceValueLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg2, _that.getLastFloatingReferenceValueLeg2())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDateLeg1, _that.getLastFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDateLeg2, _that.getLastFloatingReferenceResetDateLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg1 != null ? nextFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg2 != null ? nextFloatingReferenceResetDateLeg2.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifier != null ? uniqueTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg1 != null ? lastFloatingReferenceValueLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg2 != null ? lastFloatingReferenceValueLeg2.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg1 != null ? lastFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg2 != null ? lastFloatingReferenceResetDateLeg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonValuationReport {" +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"nextFloatingReferenceResetDateLeg1=" + this.nextFloatingReferenceResetDateLeg1 + ", " +
				"nextFloatingReferenceResetDateLeg2=" + this.nextFloatingReferenceResetDateLeg2 + ", " +
				"uniqueTransactionIdentifier=" + this.uniqueTransactionIdentifier + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"eventDate=" + this.eventDate + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"lastFloatingReferenceValueLeg1=" + this.lastFloatingReferenceValueLeg1 + ", " +
				"lastFloatingReferenceValueLeg2=" + this.lastFloatingReferenceValueLeg2 + ", " +
				"lastFloatingReferenceResetDateLeg1=" + this.lastFloatingReferenceResetDateLeg1 + ", " +
				"lastFloatingReferenceResetDateLeg2=" + this.lastFloatingReferenceResetDateLeg2 +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommonValuationReport  ***********************/
	class CommonValuationReportBuilderImpl extends CriticalDataElement.CriticalDataElementBuilderImpl implements CommonValuationReport.CommonValuationReportBuilder {
	
		protected String technicalRecordId;
		protected String reportSubmittingEntityID;
		protected String entityResponsibleForReporting;
		protected String counterparty2IdentifierSource;
		protected Date nextFloatingReferenceResetDateLeg1;
		protected Date nextFloatingReferenceResetDateLeg2;
		protected String uniqueTransactionIdentifier;
		protected String uniqueTransactionIdentifierProprietary;
		protected Date eventDate;
		protected String variationMarginCollateralPortfolioCode;
		protected String initialMarginCollateralPortfolioCode;
		protected BigDecimal lastFloatingReferenceValueLeg1;
		protected BigDecimal lastFloatingReferenceValueLeg2;
		protected Date lastFloatingReferenceResetDateLeg1;
		protected Date lastFloatingReferenceResetDateLeg2;
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		public String getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		public Date getNextFloatingReferenceResetDateLeg1() {
			return nextFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		public Date getNextFloatingReferenceResetDateLeg2() {
			return nextFloatingReferenceResetDateLeg2;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		public BigDecimal getLastFloatingReferenceValueLeg1() {
			return lastFloatingReferenceValueLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		public BigDecimal getLastFloatingReferenceValueLeg2() {
			return lastFloatingReferenceValueLeg2;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		public Date getLastFloatingReferenceResetDateLeg1() {
			return lastFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		public Date getLastFloatingReferenceResetDateLeg2() {
			return lastFloatingReferenceResetDateLeg2;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@Override
		public CommonValuationReport build() {
			return new CommonValuationReport.CommonValuationReportImpl(this);
		}
		
		@Override
		public CommonValuationReport.CommonValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getNextFloatingReferenceResetDateLeg1()!=null) return true;
			if (getNextFloatingReferenceResetDateLeg2()!=null) return true;
			if (getUniqueTransactionIdentifier()!=null) return true;
			if (getUniqueTransactionIdentifierProprietary()!=null) return true;
			if (getEventDate()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getInitialMarginCollateralPortfolioCode()!=null) return true;
			if (getLastFloatingReferenceValueLeg1()!=null) return true;
			if (getLastFloatingReferenceValueLeg2()!=null) return true;
			if (getLastFloatingReferenceResetDateLeg1()!=null) return true;
			if (getLastFloatingReferenceResetDateLeg2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonValuationReport.CommonValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommonValuationReport.CommonValuationReportBuilder o = (CommonValuationReport.CommonValuationReportBuilder) other;
			
			
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityID);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSource);
			merger.mergeBasic(getNextFloatingReferenceResetDateLeg1(), o.getNextFloatingReferenceResetDateLeg1(), this::setNextFloatingReferenceResetDateLeg1);
			merger.mergeBasic(getNextFloatingReferenceResetDateLeg2(), o.getNextFloatingReferenceResetDateLeg2(), this::setNextFloatingReferenceResetDateLeg2);
			merger.mergeBasic(getUniqueTransactionIdentifier(), o.getUniqueTransactionIdentifier(), this::setUniqueTransactionIdentifier);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietary(), o.getUniqueTransactionIdentifierProprietary(), this::setUniqueTransactionIdentifierProprietary);
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDate);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCode);
			merger.mergeBasic(getInitialMarginCollateralPortfolioCode(), o.getInitialMarginCollateralPortfolioCode(), this::setInitialMarginCollateralPortfolioCode);
			merger.mergeBasic(getLastFloatingReferenceValueLeg1(), o.getLastFloatingReferenceValueLeg1(), this::setLastFloatingReferenceValueLeg1);
			merger.mergeBasic(getLastFloatingReferenceValueLeg2(), o.getLastFloatingReferenceValueLeg2(), this::setLastFloatingReferenceValueLeg2);
			merger.mergeBasic(getLastFloatingReferenceResetDateLeg1(), o.getLastFloatingReferenceResetDateLeg1(), this::setLastFloatingReferenceResetDateLeg1);
			merger.mergeBasic(getLastFloatingReferenceResetDateLeg2(), o.getLastFloatingReferenceResetDateLeg2(), this::setLastFloatingReferenceResetDateLeg2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg1, _that.getNextFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg2, _that.getNextFloatingReferenceResetDateLeg2())) return false;
			if (!Objects.equals(uniqueTransactionIdentifier, _that.getUniqueTransactionIdentifier())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg1, _that.getLastFloatingReferenceValueLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg2, _that.getLastFloatingReferenceValueLeg2())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDateLeg1, _that.getLastFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDateLeg2, _that.getLastFloatingReferenceResetDateLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg1 != null ? nextFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg2 != null ? nextFloatingReferenceResetDateLeg2.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifier != null ? uniqueTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg1 != null ? lastFloatingReferenceValueLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg2 != null ? lastFloatingReferenceValueLeg2.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg1 != null ? lastFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg2 != null ? lastFloatingReferenceResetDateLeg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonValuationReportBuilder {" +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"nextFloatingReferenceResetDateLeg1=" + this.nextFloatingReferenceResetDateLeg1 + ", " +
				"nextFloatingReferenceResetDateLeg2=" + this.nextFloatingReferenceResetDateLeg2 + ", " +
				"uniqueTransactionIdentifier=" + this.uniqueTransactionIdentifier + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"eventDate=" + this.eventDate + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"lastFloatingReferenceValueLeg1=" + this.lastFloatingReferenceValueLeg1 + ", " +
				"lastFloatingReferenceValueLeg2=" + this.lastFloatingReferenceValueLeg2 + ", " +
				"lastFloatingReferenceResetDateLeg1=" + this.lastFloatingReferenceResetDateLeg1 + ", " +
				"lastFloatingReferenceResetDateLeg2=" + this.lastFloatingReferenceResetDateLeg2 +
			'}' + " " + super.toString();
		}
	}
}
