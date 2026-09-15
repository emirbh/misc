package drr.regulation.cftc.rewrite.valuation;

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
import drr.regulation.cftc.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.cftc.rewrite.valuation.meta.CFTCValuationReportMeta;
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
@RosettaDataType(value="CFTCValuationReport", builder=CFTCValuationReport.CFTCValuationReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CFTCValuationReport", model="drr", builder=CFTCValuationReport.CFTCValuationReportBuilderImpl.class, version="7.7.0")
public interface CFTCValuationReport extends CommonValuationReport {

	CFTCValuationReportMeta metaData = new CFTCValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "15" * field "Counterparty 2 Identifier Source"
	 *
	 * Provision Source used to identify the Counterparty 2.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "15" * field "Counterparty 2 Identifier Source" * footnote "30"
	 *
	 * Provision Throughout this Technical Specification, for references to 'Privacy Law Identifiers', refer to DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf
	 *
	 */
	@Override
	String getCounterparty2IdentifierSource();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "22" * field "Submitter Identifier"
	 *
	 * Provision Identifier of the entity submitting the data to the swap data repository (SDR). The Submitter identifier will be the same as the reporting counterparty or swap execution facility (SEF), unless they use a third-party service provider to submit the data to SDR in which case, report the identifier of the third-party service provider.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220309"
	 *
	 * Provision Check whether trade is executed in a SEF first. If it is, SEF is obliged to be the Submitter. Then check for Reporting Party and Data Submitter.
	 *
	 */
	@Override
	String getReportSubmittingEntityID();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "116" * field "Initial Margin Collateral Portfolio Code"
	 *
	 * Provision If collateral is reported on a portfolio basis, a unique code assigned by the reporting counterparty to the portfolio that tracks the aggregate initial margin of a set of open swap transactions. This data element is not applicable if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement, or if no collateral is posted or received. The portfolio code is required for both collateral reporting and valuation reporting in order to link the 2 data sets.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "116" * field "Initial Margin Collateral Portfolio Code" * footnote "82"
	 *
	 * Provision If collateralization was performed on a transaction level basis, 'TRANSACTION-LEVEL' is accepted. “NOTAPPLICABLE” is accepted if (i) collateralization was performed on a portfolio basis and there is no IM portfolio code, or (ii) it is a submission from a DCO. 
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "116" * field "Initial Margin Collateral Portfolio Code" * footnote "83"
	 *
	 * Provision  The M in the Part 43/45 Asset Class column is for collateral and valuation reporting only.
	 *
	 */
	@Override
	String getInitialMarginCollateralPortfolioCode();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "124" * field "Variation Margin Collateral Portfolio Code"
	 *
	 * Provision If collateral is reported on a portfolio basis, a unique code assigned by the reporting counterparty to the portfolio that tracks the aggregate variation margin related to a set of open swap transactions. This data element is not applicable if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement, or if no collateral is posted or received. The portfolio code is required for both collateral reporting and valuation reporting in order to link the 2 data sets.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "124" * field "Variation Margin Collateral Portfolio Code" * footnote "90"
	 *
	 * Provision If collateralization was performed on a transaction level basis, 'TRANSACTION-LEVEL' is accepted. “NOTAPPLICABLE” is accepted if (i) collateralization was performed on a portfolio basis and there is no VM portfolio code, or (ii) it is a submission from a DCO.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "124" * field "Variation Margin Collateral Portfolio Code" * footnote "91"
	 *
	 * Provision The 'M' in the 'Part 43/45 Asset Class' column is for collateral and valuation reporting only.
	 *
	 */
	@Override
	String getVariationMarginCollateralPortfolioCode();
	DTCCAdditionalValuationFields getDtccValuationFields();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "87" * field "Unique Product Identifier"
	 *
	 * Provision A unique set of characters that represents a particular OTC derivative. The Commission will designate a UPI pursuant to part 45.7.
	 				   Note: A Unique product identifier short name (D4), defined as, 'When the Commission designates a UPI pursuant to part 45, a humanly readable description made available by the UPI issuer corresponding to the UPI'.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "87" * field "Unique Product Identifier" * footnote "68"
	 *
	 * Provision Until the Commission designates a UPI for the commodity asset class pursuant to part 45, continue reporting product data elements according to the internal product identifier or product description used by the swap data repository to which the swap is reported. When the Commission designates a UPI for the commodity asset class pursuant to part 45, report the UPI.
	 *
	 */
	String getUniqueProductIdentifier();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "102" * field "Unique Swap Identifier (USI)"
	 *
	 * Provision The USI is a unique identifier assigned to all swap transactions which identifies the transaction (the swap and its counterparties) uniquely throughout its duration. It consists of a namespace and a transaction identifier.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Valuation   
	 * appendix "1" * dataElement "102" * field "Unique Swap Identifier (USI)" * footnote "76"
	 *
	 * Provision Throughout this Technical Specification, references to 'CFTC USI Data Standard' should refer to the USI Data Standard, https://www.cftc.gov/sites/default/files/idc/groups/public/@swaps/documents/dfsubmission/usidatastandards100112.pdf
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220309"
	 *
	 * Provision Rule does not model UTI > USI priority defined in CFTC specification.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220309"
	 *
	 * Provision Firms do expect to report USI/UTI in both formats: as a single identifier field as well as using Issuer + identifier. The functional model needs to handle both scenarios.
	 *
	 */
	String getUniqueSwapIdentifier();

	/*********************** Build Methods  ***********************/
	CFTCValuationReport build();
	
	CFTCValuationReport.CFTCValuationReportBuilder toBuilder();
	
	static CFTCValuationReport.CFTCValuationReportBuilder builder() {
		return new CFTCValuationReport.CFTCValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CFTCValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CFTCValuationReport> getType() {
		return CFTCValuationReport.class;
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
		processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CFTCValuationReportBuilder extends CFTCValuationReport, CommonValuationReport.CommonValuationReportBuilder {
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder getOrCreateDtccValuationFields();
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder getDtccValuationFields();
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setCounterparty1(String counterparty1);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2(String counterparty2);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setDelta(BigDecimal delta);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setLevel(ReportLevelEnum level);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2IdentifierSource(String counterparty2IdentifierSource);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setEventDate(Date eventDate);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		@Override
		CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2IdentifierSourceOverriddenAsString(String counterparty2IdentifierSource);
		CFTCValuationReport.CFTCValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String reportSubmittingEntityID);
		CFTCValuationReport.CFTCValuationReportBuilder setInitialMarginCollateralPortfolioCodeOverriddenAsString(String initialMarginCollateralPortfolioCode);
		CFTCValuationReport.CFTCValuationReportBuilder setVariationMarginCollateralPortfolioCodeOverriddenAsString(String variationMarginCollateralPortfolioCode);
		CFTCValuationReport.CFTCValuationReportBuilder setDtccValuationFields(DTCCAdditionalValuationFields dtccValuationFields);
		CFTCValuationReport.CFTCValuationReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		CFTCValuationReport.CFTCValuationReportBuilder setUniqueSwapIdentifier(String uniqueSwapIdentifier);

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
			processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
		}
		

		CFTCValuationReport.CFTCValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of CFTCValuationReport  ***********************/
	class CFTCValuationReportImpl extends CommonValuationReport.CommonValuationReportImpl implements CFTCValuationReport {
		private final String counterparty2IdentifierSource;
		private final String reportSubmittingEntityID;
		private final String initialMarginCollateralPortfolioCode;
		private final String variationMarginCollateralPortfolioCode;
		private final DTCCAdditionalValuationFields dtccValuationFields;
		private final String uniqueProductIdentifier;
		private final String uniqueSwapIdentifier;
		
		protected CFTCValuationReportImpl(CFTCValuationReport.CFTCValuationReportBuilder builder) {
			super(builder);
			this.counterparty2IdentifierSource = builder.getCounterparty2IdentifierSource();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.initialMarginCollateralPortfolioCode = builder.getInitialMarginCollateralPortfolioCode();
			this.variationMarginCollateralPortfolioCode = builder.getVariationMarginCollateralPortfolioCode();
			this.dtccValuationFields = ofNullable(builder.getDtccValuationFields()).map(f->f.build()).orElse(null);
			this.uniqueProductIdentifier = builder.getUniqueProductIdentifier();
			this.uniqueSwapIdentifier = builder.getUniqueSwapIdentifier();
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
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
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
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public String getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		public CFTCValuationReport build() {
			return this;
		}
		
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder toBuilder() {
			CFTCValuationReport.CFTCValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CFTCValuationReport.CFTCValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2IdentifierSource()).ifPresent(builder::setCounterparty2IdentifierSourceOverriddenAsString);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityIDOverriddenAsString);
			ofNullable(getInitialMarginCollateralPortfolioCode()).ifPresent(builder::setInitialMarginCollateralPortfolioCodeOverriddenAsString);
			ofNullable(getVariationMarginCollateralPortfolioCode()).ifPresent(builder::setVariationMarginCollateralPortfolioCodeOverriddenAsString);
			ofNullable(getDtccValuationFields()).ifPresent(builder::setDtccValuationFields);
			ofNullable(getUniqueProductIdentifier()).ifPresent(builder::setUniqueProductIdentifier);
			ofNullable(getUniqueSwapIdentifier()).ifPresent(builder::setUniqueSwapIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(dtccValuationFields, _that.getDtccValuationFields())) return false;
			if (!Objects.equals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (dtccValuationFields != null ? dtccValuationFields.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCValuationReport {" +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"dtccValuationFields=" + this.dtccValuationFields + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier + ", " +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CFTCValuationReport  ***********************/
	class CFTCValuationReportBuilderImpl extends CommonValuationReport.CommonValuationReportBuilderImpl implements CFTCValuationReport.CFTCValuationReportBuilder {
	
		protected String counterparty2IdentifierSource;
		protected String reportSubmittingEntityID;
		protected String initialMarginCollateralPortfolioCode;
		protected String variationMarginCollateralPortfolioCode;
		protected DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder dtccValuationFields;
		protected String uniqueProductIdentifier;
		protected String uniqueSwapIdentifier;
		
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
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
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
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public String getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setReportSubmittingEntityIDOverriddenAsString(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			return setReportSubmittingEntityIDOverriddenAsString(_reportSubmittingEntityID);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2IdentifierSourceOverriddenAsString(String _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setCounterparty2IdentifierSource(String _counterparty2IdentifierSource) {
			return setCounterparty2IdentifierSourceOverriddenAsString(_counterparty2IdentifierSource);
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setVariationMarginCollateralPortfolioCodeOverriddenAsString(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			return setVariationMarginCollateralPortfolioCodeOverriddenAsString(_variationMarginCollateralPortfolioCode);
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setInitialMarginCollateralPortfolioCodeOverriddenAsString(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			return setInitialMarginCollateralPortfolioCodeOverriddenAsString(_initialMarginCollateralPortfolioCode);
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("dtccValuationFields")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtccValuationFields")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setDtccValuationFields(DTCCAdditionalValuationFields _dtccValuationFields) {
			this.dtccValuationFields = _dtccValuationFields == null ? null : _dtccValuationFields.toBuilder();
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder setUniqueSwapIdentifier(String _uniqueSwapIdentifier) {
			this.uniqueSwapIdentifier = _uniqueSwapIdentifier == null ? null : _uniqueSwapIdentifier;
			return this;
		}
		
		@Override
		public CFTCValuationReport build() {
			return new CFTCValuationReport.CFTCValuationReportImpl(this);
		}
		
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder prune() {
			super.prune();
			if (dtccValuationFields!=null && !dtccValuationFields.prune().hasData()) dtccValuationFields = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getInitialMarginCollateralPortfolioCode()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getDtccValuationFields()!=null && getDtccValuationFields().hasData()) return true;
			if (getUniqueProductIdentifier()!=null) return true;
			if (getUniqueSwapIdentifier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCValuationReport.CFTCValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CFTCValuationReport.CFTCValuationReportBuilder o = (CFTCValuationReport.CFTCValuationReportBuilder) other;
			
			merger.mergeRosetta(getDtccValuationFields(), o.getDtccValuationFields(), this::setDtccValuationFields);
			
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSourceOverriddenAsString);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityIDOverriddenAsString);
			merger.mergeBasic(getInitialMarginCollateralPortfolioCode(), o.getInitialMarginCollateralPortfolioCode(), this::setInitialMarginCollateralPortfolioCodeOverriddenAsString);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCodeOverriddenAsString);
			merger.mergeBasic(getUniqueProductIdentifier(), o.getUniqueProductIdentifier(), this::setUniqueProductIdentifier);
			merger.mergeBasic(getUniqueSwapIdentifier(), o.getUniqueSwapIdentifier(), this::setUniqueSwapIdentifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(dtccValuationFields, _that.getDtccValuationFields())) return false;
			if (!Objects.equals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (dtccValuationFields != null ? dtccValuationFields.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCValuationReportBuilder {" +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"dtccValuationFields=" + this.dtccValuationFields + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier + ", " +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier +
			'}' + " " + super.toString();
		}
	}
}
