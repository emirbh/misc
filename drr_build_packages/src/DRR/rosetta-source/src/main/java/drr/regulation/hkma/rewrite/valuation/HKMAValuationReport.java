package drr.regulation.hkma.rewrite.valuation;

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
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.common.valuation.CommonValuationReport;
import drr.regulation.hkma.rewrite.valuation.meta.HKMAValuationReportMeta;
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
@RosettaDataType(value="HKMAValuationReport", builder=HKMAValuationReport.HKMAValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="HKMAValuationReport", model="drr", builder=HKMAValuationReport.HKMAValuationReportBuilderImpl.class, version="7.7.0")
public interface HKMAValuationReport extends CommonValuationReport {

	HKMAValuationReportMeta metaData = new HKMAValuationReportMeta();

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
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * dataElement "9" * field "Counterparty 2 identifier type indicator"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2.
	 *
	 */
	@Override
	Boolean getCounterparty2IdentifierType();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * dataElement "200" * field "Technical record identification"
	 *
	 * Provision Unique identifier of a trade action used as part of error management and status advice message.
	 *
	 */
	@Override
	String getTechnicalRecordId();
	@Override
	String getReportSubmittingEntityID();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * dataElement "8" * field "Counterparty 2 name"
	 *
	 * Provision If the identifier reported for Counterparty 2 is not an LEI, or SWIFTBIC, the legal name of Counterparty 2.
	 *
	 */
	String getCounterparty2Name();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * dataElement "153" * field "Submitter Identifier"
	 *
	 * Provision Identifier of the entity submitting the OTC derivative transaction to the Trade Repository.
	 *
	 */
	String getSubmitterIdentifier();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * dataElement "199" * field "Number records"
	 *
	 * Provision Indicates the number of trade action in the request file.
	 *
	 */
	BigDecimal getNumberRecords();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * dataElement "201" * field "Remarks"
	 *
	 * Provision A TR Trade Reference generated by the HKTR for post-trade action correlation, if applicable, when the designated trade cannot be correlated by using the UTI.
	 *
	 */
	String getRemarks();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * field "Counterparty 2 Identifier Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format of Counterparty 2 based on role or identifier type
	 *
	 */
	PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * field "Counterparty 2 Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when identifier format is 'Other' for Counterparty 2
	 *
	 */
	HKTRPartyScheme getCounterparty2SchemeName();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Valuation   
	 * field "Unique Transaction Identifier Proprietary Scheme Name (Non Reportable)"
	 *
	 * Provision Provides the scheme name when Unique Transaction Identifier is proprietary
	 *
	 */
	UTIProprietarySchemeNameEnum getUniqueTransactionIdentifierProprietarySchemeName();

	/*********************** Build Methods  ***********************/
	HKMAValuationReport build();
	
	HKMAValuationReport.HKMAValuationReportBuilder toBuilder();
	
	static HKMAValuationReport.HKMAValuationReportBuilder builder() {
		return new HKMAValuationReport.HKMAValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HKMAValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HKMAValuationReport> getType() {
		return HKMAValuationReport.class;
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
		processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
		processor.processBasic(path.newSubPath("submitterIdentifier"), String.class, getSubmitterIdentifier(), this);
		processor.processBasic(path.newSubPath("numberRecords"), BigDecimal.class, getNumberRecords(), this);
		processor.processBasic(path.newSubPath("remarks"), String.class, getRemarks(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierFormat"), PartyIdentifierFormat2Enum.class, getCounterparty2IdentifierFormat(), this);
		processor.processBasic(path.newSubPath("counterparty2SchemeName"), HKTRPartyScheme.class, getCounterparty2SchemeName(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietarySchemeName"), UTIProprietarySchemeNameEnum.class, getUniqueTransactionIdentifierProprietarySchemeName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface HKMAValuationReportBuilder extends HKMAValuationReport, CommonValuationReport.CommonValuationReportBuilder {
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setLevel(ReportLevelEnum level);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setEventDate(Date eventDate);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		@Override
		HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		HKMAValuationReport.HKMAValuationReportBuilder setTechnicalRecordIdOverriddenAsString(String technicalRecordId);
		HKMAValuationReport.HKMAValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String reportSubmittingEntityID);
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2Name(String counterparty2Name);
		HKMAValuationReport.HKMAValuationReportBuilder setSubmitterIdentifier(String submitterIdentifier);
		HKMAValuationReport.HKMAValuationReportBuilder setNumberRecords(BigDecimal numberRecords);
		HKMAValuationReport.HKMAValuationReportBuilder setRemarks(String remarks);
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierFormat(PartyIdentifierFormat2Enum counterparty2IdentifierFormat);
		HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2SchemeName(HKTRPartyScheme counterparty2SchemeName);
		HKMAValuationReport.HKMAValuationReportBuilder setUniqueTransactionIdentifierProprietarySchemeName(UTIProprietarySchemeNameEnum uniqueTransactionIdentifierProprietarySchemeName);

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
			processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
			processor.processBasic(path.newSubPath("submitterIdentifier"), String.class, getSubmitterIdentifier(), this);
			processor.processBasic(path.newSubPath("numberRecords"), BigDecimal.class, getNumberRecords(), this);
			processor.processBasic(path.newSubPath("remarks"), String.class, getRemarks(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierFormat"), PartyIdentifierFormat2Enum.class, getCounterparty2IdentifierFormat(), this);
			processor.processBasic(path.newSubPath("counterparty2SchemeName"), HKTRPartyScheme.class, getCounterparty2SchemeName(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietarySchemeName"), UTIProprietarySchemeNameEnum.class, getUniqueTransactionIdentifierProprietarySchemeName(), this);
		}
		

		HKMAValuationReport.HKMAValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of HKMAValuationReport  ***********************/
	class HKMAValuationReportImpl extends CommonValuationReport.CommonValuationReportImpl implements HKMAValuationReport {
		private final Boolean counterparty2IdentifierType;
		private final String technicalRecordId;
		private final String reportSubmittingEntityID;
		private final String counterparty2Name;
		private final String submitterIdentifier;
		private final BigDecimal numberRecords;
		private final String remarks;
		private final PartyIdentifierFormat2Enum counterparty2IdentifierFormat;
		private final HKTRPartyScheme counterparty2SchemeName;
		private final UTIProprietarySchemeNameEnum uniqueTransactionIdentifierProprietarySchemeName;
		
		protected HKMAValuationReportImpl(HKMAValuationReport.HKMAValuationReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.counterparty2Name = builder.getCounterparty2Name();
			this.submitterIdentifier = builder.getSubmitterIdentifier();
			this.numberRecords = builder.getNumberRecords();
			this.remarks = builder.getRemarks();
			this.counterparty2IdentifierFormat = builder.getCounterparty2IdentifierFormat();
			this.counterparty2SchemeName = builder.getCounterparty2SchemeName();
			this.uniqueTransactionIdentifierProprietarySchemeName = builder.getUniqueTransactionIdentifierProprietarySchemeName();
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
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
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
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2Name")
		public String getCounterparty2Name() {
			return counterparty2Name;
		}
		
		@Override
		@RosettaAttribute("submitterIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submitterIdentifier")
		public String getSubmitterIdentifier() {
			return submitterIdentifier;
		}
		
		@Override
		@RosettaAttribute("numberRecords")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberRecords")
		public BigDecimal getNumberRecords() {
			return numberRecords;
		}
		
		@Override
		@RosettaAttribute("remarks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks")
		public String getRemarks() {
			return remarks;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		public PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat() {
			return counterparty2IdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("counterparty2SchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2SchemeName")
		public HKTRPartyScheme getCounterparty2SchemeName() {
			return counterparty2SchemeName;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		public UTIProprietarySchemeNameEnum getUniqueTransactionIdentifierProprietarySchemeName() {
			return uniqueTransactionIdentifierProprietarySchemeName;
		}
		
		@Override
		public HKMAValuationReport build() {
			return this;
		}
		
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder toBuilder() {
			HKMAValuationReport.HKMAValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HKMAValuationReport.HKMAValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordIdOverriddenAsString);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityIDOverriddenAsString);
			ofNullable(getCounterparty2Name()).ifPresent(builder::setCounterparty2Name);
			ofNullable(getSubmitterIdentifier()).ifPresent(builder::setSubmitterIdentifier);
			ofNullable(getNumberRecords()).ifPresent(builder::setNumberRecords);
			ofNullable(getRemarks()).ifPresent(builder::setRemarks);
			ofNullable(getCounterparty2IdentifierFormat()).ifPresent(builder::setCounterparty2IdentifierFormat);
			ofNullable(getCounterparty2SchemeName()).ifPresent(builder::setCounterparty2SchemeName);
			ofNullable(getUniqueTransactionIdentifierProprietarySchemeName()).ifPresent(builder::setUniqueTransactionIdentifierProprietarySchemeName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			HKMAValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(counterparty2Name, _that.getCounterparty2Name())) return false;
			if (!Objects.equals(submitterIdentifier, _that.getSubmitterIdentifier())) return false;
			if (!Objects.equals(numberRecords, _that.getNumberRecords())) return false;
			if (!Objects.equals(remarks, _that.getRemarks())) return false;
			if (!Objects.equals(counterparty2IdentifierFormat, _that.getCounterparty2IdentifierFormat())) return false;
			if (!Objects.equals(counterparty2SchemeName, _that.getCounterparty2SchemeName())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietarySchemeName, _that.getUniqueTransactionIdentifierProprietarySchemeName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (counterparty2Name != null ? counterparty2Name.hashCode() : 0);
			_result = 31 * _result + (submitterIdentifier != null ? submitterIdentifier.hashCode() : 0);
			_result = 31 * _result + (numberRecords != null ? numberRecords.hashCode() : 0);
			_result = 31 * _result + (remarks != null ? remarks.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierFormat != null ? counterparty2IdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2SchemeName != null ? counterparty2SchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietarySchemeName != null ? uniqueTransactionIdentifierProprietarySchemeName.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMAValuationReport {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"counterparty2Name=" + this.counterparty2Name + ", " +
				"submitterIdentifier=" + this.submitterIdentifier + ", " +
				"numberRecords=" + this.numberRecords + ", " +
				"remarks=" + this.remarks + ", " +
				"counterparty2IdentifierFormat=" + this.counterparty2IdentifierFormat + ", " +
				"counterparty2SchemeName=" + this.counterparty2SchemeName + ", " +
				"uniqueTransactionIdentifierProprietarySchemeName=" + this.uniqueTransactionIdentifierProprietarySchemeName +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of HKMAValuationReport  ***********************/
	class HKMAValuationReportBuilderImpl extends CommonValuationReport.CommonValuationReportBuilderImpl implements HKMAValuationReport.HKMAValuationReportBuilder {
	
		protected Boolean counterparty2IdentifierType;
		protected String technicalRecordId;
		protected String reportSubmittingEntityID;
		protected String counterparty2Name;
		protected String submitterIdentifier;
		protected BigDecimal numberRecords;
		protected String remarks;
		protected PartyIdentifierFormat2Enum counterparty2IdentifierFormat;
		protected HKTRPartyScheme counterparty2SchemeName;
		protected UTIProprietarySchemeNameEnum uniqueTransactionIdentifierProprietarySchemeName;
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2Name")
		public String getCounterparty2Name() {
			return counterparty2Name;
		}
		
		@Override
		@RosettaAttribute("submitterIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submitterIdentifier")
		public String getSubmitterIdentifier() {
			return submitterIdentifier;
		}
		
		@Override
		@RosettaAttribute("numberRecords")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberRecords")
		public BigDecimal getNumberRecords() {
			return numberRecords;
		}
		
		@Override
		@RosettaAttribute("remarks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remarks")
		public String getRemarks() {
			return remarks;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		public PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat() {
			return counterparty2IdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("counterparty2SchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2SchemeName")
		public HKTRPartyScheme getCounterparty2SchemeName() {
			return counterparty2SchemeName;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		public UTIProprietarySchemeNameEnum getUniqueTransactionIdentifierProprietarySchemeName() {
			return uniqueTransactionIdentifierProprietarySchemeName;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setTechnicalRecordIdOverriddenAsString(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			return setTechnicalRecordIdOverriddenAsString(_technicalRecordId);
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			return setReportSubmittingEntityIDOverriddenAsString(_reportSubmittingEntityID);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2Name")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("submitterIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submitterIdentifier")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setSubmitterIdentifier(String _submitterIdentifier) {
			this.submitterIdentifier = _submitterIdentifier == null ? null : _submitterIdentifier;
			return this;
		}
		
		@RosettaAttribute("numberRecords")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberRecords")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setNumberRecords(BigDecimal _numberRecords) {
			this.numberRecords = _numberRecords == null ? null : _numberRecords;
			return this;
		}
		
		@RosettaAttribute("remarks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remarks")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setRemarks(String _remarks) {
			this.remarks = _remarks == null ? null : _remarks;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2IdentifierFormat(PartyIdentifierFormat2Enum _counterparty2IdentifierFormat) {
			this.counterparty2IdentifierFormat = _counterparty2IdentifierFormat == null ? null : _counterparty2IdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("counterparty2SchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2SchemeName")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setCounterparty2SchemeName(HKTRPartyScheme _counterparty2SchemeName) {
			this.counterparty2SchemeName = _counterparty2SchemeName == null ? null : _counterparty2SchemeName;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietarySchemeName")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder setUniqueTransactionIdentifierProprietarySchemeName(UTIProprietarySchemeNameEnum _uniqueTransactionIdentifierProprietarySchemeName) {
			this.uniqueTransactionIdentifierProprietarySchemeName = _uniqueTransactionIdentifierProprietarySchemeName == null ? null : _uniqueTransactionIdentifierProprietarySchemeName;
			return this;
		}
		
		@Override
		public HKMAValuationReport build() {
			return new HKMAValuationReport.HKMAValuationReportImpl(this);
		}
		
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getCounterparty2Name()!=null) return true;
			if (getSubmitterIdentifier()!=null) return true;
			if (getNumberRecords()!=null) return true;
			if (getRemarks()!=null) return true;
			if (getCounterparty2IdentifierFormat()!=null) return true;
			if (getCounterparty2SchemeName()!=null) return true;
			if (getUniqueTransactionIdentifierProprietarySchemeName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMAValuationReport.HKMAValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			HKMAValuationReport.HKMAValuationReportBuilder o = (HKMAValuationReport.HKMAValuationReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordIdOverriddenAsString);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityIDOverriddenAsString);
			merger.mergeBasic(getCounterparty2Name(), o.getCounterparty2Name(), this::setCounterparty2Name);
			merger.mergeBasic(getSubmitterIdentifier(), o.getSubmitterIdentifier(), this::setSubmitterIdentifier);
			merger.mergeBasic(getNumberRecords(), o.getNumberRecords(), this::setNumberRecords);
			merger.mergeBasic(getRemarks(), o.getRemarks(), this::setRemarks);
			merger.mergeBasic(getCounterparty2IdentifierFormat(), o.getCounterparty2IdentifierFormat(), this::setCounterparty2IdentifierFormat);
			merger.mergeBasic(getCounterparty2SchemeName(), o.getCounterparty2SchemeName(), this::setCounterparty2SchemeName);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietarySchemeName(), o.getUniqueTransactionIdentifierProprietarySchemeName(), this::setUniqueTransactionIdentifierProprietarySchemeName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			HKMAValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(counterparty2Name, _that.getCounterparty2Name())) return false;
			if (!Objects.equals(submitterIdentifier, _that.getSubmitterIdentifier())) return false;
			if (!Objects.equals(numberRecords, _that.getNumberRecords())) return false;
			if (!Objects.equals(remarks, _that.getRemarks())) return false;
			if (!Objects.equals(counterparty2IdentifierFormat, _that.getCounterparty2IdentifierFormat())) return false;
			if (!Objects.equals(counterparty2SchemeName, _that.getCounterparty2SchemeName())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietarySchemeName, _that.getUniqueTransactionIdentifierProprietarySchemeName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (counterparty2Name != null ? counterparty2Name.hashCode() : 0);
			_result = 31 * _result + (submitterIdentifier != null ? submitterIdentifier.hashCode() : 0);
			_result = 31 * _result + (numberRecords != null ? numberRecords.hashCode() : 0);
			_result = 31 * _result + (remarks != null ? remarks.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierFormat != null ? counterparty2IdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2SchemeName != null ? counterparty2SchemeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietarySchemeName != null ? uniqueTransactionIdentifierProprietarySchemeName.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMAValuationReportBuilder {" +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"counterparty2Name=" + this.counterparty2Name + ", " +
				"submitterIdentifier=" + this.submitterIdentifier + ", " +
				"numberRecords=" + this.numberRecords + ", " +
				"remarks=" + this.remarks + ", " +
				"counterparty2IdentifierFormat=" + this.counterparty2IdentifierFormat + ", " +
				"counterparty2SchemeName=" + this.counterparty2SchemeName + ", " +
				"uniqueTransactionIdentifierProprietarySchemeName=" + this.uniqueTransactionIdentifierProprietarySchemeName +
			'}' + " " + super.toString();
		}
	}
}
