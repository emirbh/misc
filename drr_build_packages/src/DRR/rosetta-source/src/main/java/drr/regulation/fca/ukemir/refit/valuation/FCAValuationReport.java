package drr.regulation.fca.ukemir.refit.valuation;

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
import drr.regulation.fca.ukemir.refit.valuation.meta.FCAValuationReportMeta;
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
@RosettaDataType(value="FCAValuationReport", builder=FCAValuationReport.FCAValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="FCAValuationReport", model="drr", builder=FCAValuationReport.FCAValuationReportBuilderImpl.class, version="7.7.0")
public interface FCAValuationReport extends CommonValuationReport {

	FCAValuationReportMeta metaData = new FCAValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Valuation   
	 * table "1" * dataElement "2" * field "Report Submitting entity ID"
	 *
	 * Provision In the case where the entity responsible for reporting has delegated the submission of the report to a third party or to the other counterparty, that entity has to be identified in this field by a unique code. Otherwise the entity responsible for reporting should be identified in this field.
	 *
	 */
	@Override
	String getReportSubmittingEntityID();
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
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Valuation   
	 * table "1" * dataElement "8" * field "Counterparty 2 Identifier Type"
	 *
	 * Provision Indicator of whether LEI was used to identify counterparty 2.
	 *
	 */
	@Override
	Boolean getCounterparty2IdentifierType();
	/**
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Valuation   
	 * table "2" * dataElement "153" * field "Event date"
	 *
	 * Provision Date on which the reportable event relating to the derivative contract and captured by the report took place or, in case of a modification when the modification become effective.
	 *
	 */
	@Override
	Date getEventDate();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "112"
	 *
	 * Provision Indication whether the report is done at trade or position level. Position level report can be used as a supplement to trade level reporting to report post trade events and if individual trades have been replaced by the position.
	 *
	 *
	 * Body FCA
	 * Corpus FCA_BoEPolicyStatement UKEMIR PS23/2 "Policy Statement PS23/2: Changes to reporting requirements, procedures for data quality and registration of Trade Repositories under UK EMIR  feedback on CP21/31 and our final rules and guidance"  * Corpus Dissemination Valuation   
	 * table "2" * dataElement "154" * field "Level"
	 *
	 * Provision Indication whether the report is done at trade or position level. Position level report can be used only as a supplement to trade level reporting to report post- trade events and only if individual trades in fungible products have been replaced by the position.
	 *
	 */
	@Override
	ReportLevelEnum getLevel();
	NonReportable getNonReportable();

	/*********************** Build Methods  ***********************/
	FCAValuationReport build();
	
	FCAValuationReport.FCAValuationReportBuilder toBuilder();
	
	static FCAValuationReport.FCAValuationReportBuilder builder() {
		return new FCAValuationReport.FCAValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FCAValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FCAValuationReport> getType() {
		return FCAValuationReport.class;
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
		processRosetta(path.newSubPath("nonReportable"), processor, NonReportable.class, getNonReportable());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FCAValuationReportBuilder extends FCAValuationReport, CommonValuationReport.CommonValuationReportBuilder {
		NonReportable.NonReportableBuilder getOrCreateNonReportable();
		@Override
		NonReportable.NonReportableBuilder getNonReportable();
		@Override
		FCAValuationReport.FCAValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setLevel(ReportLevelEnum level);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setEventDate(Date eventDate);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		@Override
		FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		FCAValuationReport.FCAValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String reportSubmittingEntityID);
		FCAValuationReport.FCAValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		FCAValuationReport.FCAValuationReportBuilder setEventDateOverriddenAsDate(Date eventDate);
		FCAValuationReport.FCAValuationReportBuilder setLevelOverriddenAsReportLevelEnum(ReportLevelEnum level);
		FCAValuationReport.FCAValuationReportBuilder setNonReportable(NonReportable nonReportable);

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
			processRosetta(path.newSubPath("nonReportable"), processor, NonReportable.NonReportableBuilder.class, getNonReportable());
		}
		

		FCAValuationReport.FCAValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of FCAValuationReport  ***********************/
	class FCAValuationReportImpl extends CommonValuationReport.CommonValuationReportImpl implements FCAValuationReport {
		private final String reportSubmittingEntityID;
		private final Boolean counterparty2IdentifierType;
		private final Date eventDate;
		private final ReportLevelEnum level;
		private final NonReportable nonReportable;
		
		protected FCAValuationReportImpl(FCAValuationReport.FCAValuationReportBuilder builder) {
			super(builder);
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.eventDate = builder.getEventDate();
			this.level = builder.getLevel();
			this.nonReportable = ofNullable(builder.getNonReportable()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public NonReportable getNonReportable() {
			return nonReportable;
		}
		
		@Override
		public FCAValuationReport build() {
			return this;
		}
		
		@Override
		public FCAValuationReport.FCAValuationReportBuilder toBuilder() {
			FCAValuationReport.FCAValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FCAValuationReport.FCAValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityIDOverriddenAsString);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getEventDate()).ifPresent(builder::setEventDateOverriddenAsDate);
			ofNullable(getLevel()).ifPresent(builder::setLevelOverriddenAsReportLevelEnum);
			ofNullable(getNonReportable()).ifPresent(builder::setNonReportable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAValuationReport {" +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"eventDate=" + this.eventDate + ", " +
				"level=" + this.level + ", " +
				"nonReportable=" + this.nonReportable +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FCAValuationReport  ***********************/
	class FCAValuationReportBuilderImpl extends CommonValuationReport.CommonValuationReportBuilderImpl implements FCAValuationReport.FCAValuationReportBuilder {
	
		protected String reportSubmittingEntityID;
		protected Boolean counterparty2IdentifierType;
		protected Date eventDate;
		protected ReportLevelEnum level;
		protected NonReportable.NonReportableBuilder nonReportable;
		
		@Override
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
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
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public NonReportable.NonReportableBuilder getNonReportable() {
			return nonReportable;
		}
		
		@Override
		public NonReportable.NonReportableBuilder getOrCreateNonReportable() {
			NonReportable.NonReportableBuilder result;
			if (nonReportable!=null) {
				result = nonReportable;
			}
			else {
				result = nonReportable = NonReportable.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("level")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setLevelOverriddenAsReportLevelEnum(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setLevel(ReportLevelEnum _level) {
			return setLevelOverriddenAsReportLevelEnum(_level);
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			return setReportSubmittingEntityIDOverriddenAsString(_reportSubmittingEntityID);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventDate")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setEventDateOverriddenAsDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setEventDate(Date _eventDate) {
			return setEventDateOverriddenAsDate(_eventDate);
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder setNonReportable(NonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@Override
		public FCAValuationReport build() {
			return new FCAValuationReport.FCAValuationReportImpl(this);
		}
		
		@Override
		public FCAValuationReport.FCAValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder prune() {
			super.prune();
			if (nonReportable!=null && !nonReportable.prune().hasData()) nonReportable = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getEventDate()!=null) return true;
			if (getLevel()!=null) return true;
			if (getNonReportable()!=null && getNonReportable().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAValuationReport.FCAValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FCAValuationReport.FCAValuationReportBuilder o = (FCAValuationReport.FCAValuationReportBuilder) other;
			
			merger.mergeRosetta(getNonReportable(), o.getNonReportable(), this::setNonReportable);
			
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityIDOverriddenAsString);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDateOverriddenAsDate);
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevelOverriddenAsReportLevelEnum);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAValuationReportBuilder {" +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"eventDate=" + this.eventDate + ", " +
				"level=" + this.level + ", " +
				"nonReportable=" + this.nonReportable +
			'}' + " " + super.toString();
		}
	}
}
