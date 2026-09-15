package drr.regulation.hkma.rewrite.margin;

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
import drr.regulation.common.margin.CommonMarginReport;
import drr.regulation.hkma.rewrite.margin.meta.HKMAMarginReportMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="HKMAMarginReport", builder=HKMAMarginReport.HKMAMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="HKMAMarginReport", model="drr", builder=HKMAMarginReport.HKMAMarginReportBuilderImpl.class, version="7.7.0")
public interface HKMAMarginReport extends CommonMarginReport {

	HKMAMarginReportMeta metaData = new HKMAMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * dataElement "7" * field "Counterparty 2"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction.
	         For Party ID SWIFTBIC and BRN, party should input the first eight digits only. 
	         e.g. SwiftBIC: HKMAHKHHXXX should be inputted as HKMAHKHH
	             BRN: 12345678 - 000 - 04 - 11 - A should be inputted as 12345678.
	 
	         For Party ID CICR, party should input all character(s) and digits.
	         e.g. For Local company (CI): Seven digits such as 9999999 .
	             For Non-local company (CR): Character(s) plus seven digits 
	                 such as X9999999 or XX9999999.
	 *
	 */
	@Override
	String getCounterparty2();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
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
	 * Corpus Dissemination Margin   
	 * field "Event date (Non Reportable)"
	 *
	 * Provision Date on which the reportable event relating to the derivative contract and captured by the report took place. In the case of collateral update - the date for which the information contained in the report is provided.
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * dataElement "199" * field "Number records"
	 *
	 * Provision Indicates the number of trade action in the request file.
	 *
	 */
	BigDecimal getNumberRecords();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * dataElement "200" * field "Technical record identification"
	 *
	 * Provision Unique identifier of a trade action used as part of error management and status advice message.
	 *
	 */
	String getTechnicalRecordId();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * dataElement "8" * field "Counterparty 2 name"
	 *
	 * Provision If the identifier reported for Counterparty 2 is not an LEI, or SWIFTBIC, the legal name of Counterparty 2.
	 *
	 */
	String getCounterparty2Name();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * field "Counterparty 2 Identifier Format (Non Reportable)"
	 *
	 * Provision Determines the identifier format of Counterparty 2 based on role or identifier type
	 *
	 */
	PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * dataElement "151" * field "Portfolio containing nonreportable component indicator"
	 *
	 * Provision If collateral is reported on a portfolio basis, indicator of whether the collateral portfolio includes swap transactions exempt from reporting., if applicable.
	 *
	 */
	Boolean getPortfolioContainingNonReportableComponentIndicator();
	/**
	 *
	 * Body HKMA
	 * Corpus Dissemination Margin   
	 * dataElement "154" * field "Entity responsible for reporting"
	 *
	 * Provision Identification code of the Reporting Party who has the obligation to report the transaction.
	 *
	 */
	String getEntityResponsibleForReporting();

	/*********************** Build Methods  ***********************/
	HKMAMarginReport build();
	
	HKMAMarginReport.HKMAMarginReportBuilder toBuilder();
	
	static HKMAMarginReport.HKMAMarginReportBuilder builder() {
		return new HKMAMarginReport.HKMAMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HKMAMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HKMAMarginReport> getType() {
		return HKMAMarginReport.class;
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
		processor.processBasic(path.newSubPath("numberRecords"), BigDecimal.class, getNumberRecords(), this);
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierFormat"), PartyIdentifierFormat2Enum.class, getCounterparty2IdentifierFormat(), this);
		processor.processBasic(path.newSubPath("portfolioContainingNonReportableComponentIndicator"), Boolean.class, getPortfolioContainingNonReportableComponentIndicator(), this);
		processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface HKMAMarginReportBuilder extends HKMAMarginReport, CommonMarginReport.CommonMarginReportBuilder {
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setUti(String uti);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setActionType(MarginActionEnum actionType);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setEventDate(Date eventDate);
		@Override
		HKMAMarginReport.HKMAMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2OverriddenAsString(String counterparty2);
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean counterparty2IdentifierType);
		HKMAMarginReport.HKMAMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		HKMAMarginReport.HKMAMarginReportBuilder setNumberRecords(BigDecimal numberRecords);
		HKMAMarginReport.HKMAMarginReportBuilder setTechnicalRecordId(String technicalRecordId);
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2Name(String counterparty2Name);
		HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2IdentifierFormat(PartyIdentifierFormat2Enum counterparty2IdentifierFormat);
		HKMAMarginReport.HKMAMarginReportBuilder setPortfolioContainingNonReportableComponentIndicator(Boolean portfolioContainingNonReportableComponentIndicator);
		HKMAMarginReport.HKMAMarginReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);

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
			processor.processBasic(path.newSubPath("numberRecords"), BigDecimal.class, getNumberRecords(), this);
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
			processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierFormat"), PartyIdentifierFormat2Enum.class, getCounterparty2IdentifierFormat(), this);
			processor.processBasic(path.newSubPath("portfolioContainingNonReportableComponentIndicator"), Boolean.class, getPortfolioContainingNonReportableComponentIndicator(), this);
			processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
		}
		

		HKMAMarginReport.HKMAMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of HKMAMarginReport  ***********************/
	class HKMAMarginReportImpl extends CommonMarginReport.CommonMarginReportImpl implements HKMAMarginReport {
		private final String counterparty2;
		private final Boolean counterparty2IdentifierType;
		private final ZonedDateTime eventTimestamp;
		private final BigDecimal numberRecords;
		private final String technicalRecordId;
		private final String counterparty2Name;
		private final PartyIdentifierFormat2Enum counterparty2IdentifierFormat;
		private final Boolean portfolioContainingNonReportableComponentIndicator;
		private final String entityResponsibleForReporting;
		
		protected HKMAMarginReportImpl(HKMAMarginReport.HKMAMarginReportBuilder builder) {
			super(builder);
			this.counterparty2 = builder.getCounterparty2();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.eventTimestamp = builder.getEventTimestamp();
			this.numberRecords = builder.getNumberRecords();
			this.technicalRecordId = builder.getTechnicalRecordId();
			this.counterparty2Name = builder.getCounterparty2Name();
			this.counterparty2IdentifierFormat = builder.getCounterparty2IdentifierFormat();
			this.portfolioContainingNonReportableComponentIndicator = builder.getPortfolioContainingNonReportableComponentIndicator();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
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
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("numberRecords")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberRecords")
		public BigDecimal getNumberRecords() {
			return numberRecords;
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
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2Name")
		public String getCounterparty2Name() {
			return counterparty2Name;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		public PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat() {
			return counterparty2IdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("portfolioContainingNonReportableComponentIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("portfolioContainingNonReportableComponentIndicator")
		public Boolean getPortfolioContainingNonReportableComponentIndicator() {
			return portfolioContainingNonReportableComponentIndicator;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		public HKMAMarginReport build() {
			return this;
		}
		
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder toBuilder() {
			HKMAMarginReport.HKMAMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HKMAMarginReport.HKMAMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2OverriddenAsString);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getNumberRecords()).ifPresent(builder::setNumberRecords);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordId);
			ofNullable(getCounterparty2Name()).ifPresent(builder::setCounterparty2Name);
			ofNullable(getCounterparty2IdentifierFormat()).ifPresent(builder::setCounterparty2IdentifierFormat);
			ofNullable(getPortfolioContainingNonReportableComponentIndicator()).ifPresent(builder::setPortfolioContainingNonReportableComponentIndicator);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReporting);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			HKMAMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(numberRecords, _that.getNumberRecords())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(counterparty2Name, _that.getCounterparty2Name())) return false;
			if (!Objects.equals(counterparty2IdentifierFormat, _that.getCounterparty2IdentifierFormat())) return false;
			if (!Objects.equals(portfolioContainingNonReportableComponentIndicator, _that.getPortfolioContainingNonReportableComponentIndicator())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (numberRecords != null ? numberRecords.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (counterparty2Name != null ? counterparty2Name.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierFormat != null ? counterparty2IdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (portfolioContainingNonReportableComponentIndicator != null ? portfolioContainingNonReportableComponentIndicator.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMAMarginReport {" +
				"counterparty2=" + this.counterparty2 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"numberRecords=" + this.numberRecords + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"counterparty2Name=" + this.counterparty2Name + ", " +
				"counterparty2IdentifierFormat=" + this.counterparty2IdentifierFormat + ", " +
				"portfolioContainingNonReportableComponentIndicator=" + this.portfolioContainingNonReportableComponentIndicator + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of HKMAMarginReport  ***********************/
	class HKMAMarginReportBuilderImpl extends CommonMarginReport.CommonMarginReportBuilderImpl implements HKMAMarginReport.HKMAMarginReportBuilder {
	
		protected String counterparty2;
		protected Boolean counterparty2IdentifierType;
		protected ZonedDateTime eventTimestamp;
		protected BigDecimal numberRecords;
		protected String technicalRecordId;
		protected String counterparty2Name;
		protected PartyIdentifierFormat2Enum counterparty2IdentifierFormat;
		protected Boolean portfolioContainingNonReportableComponentIndicator;
		protected String entityResponsibleForReporting;
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
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
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
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
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
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
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		public PartyIdentifierFormat2Enum getCounterparty2IdentifierFormat() {
			return counterparty2IdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("portfolioContainingNonReportableComponentIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("portfolioContainingNonReportableComponentIndicator")
		public Boolean getPortfolioContainingNonReportableComponentIndicator() {
			return portfolioContainingNonReportableComponentIndicator;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2IdentifierTypeOverriddenAsBoolean(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			return setCounterparty2IdentifierTypeOverriddenAsBoolean(_counterparty2IdentifierType);
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2OverriddenAsString(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2(String _counterparty2) {
			return setCounterparty2OverriddenAsString(_counterparty2);
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("numberRecords")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberRecords")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setNumberRecords(BigDecimal _numberRecords) {
			this.numberRecords = _numberRecords == null ? null : _numberRecords;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("technicalRecordId")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2Name")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierFormat")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setCounterparty2IdentifierFormat(PartyIdentifierFormat2Enum _counterparty2IdentifierFormat) {
			this.counterparty2IdentifierFormat = _counterparty2IdentifierFormat == null ? null : _counterparty2IdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("portfolioContainingNonReportableComponentIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("portfolioContainingNonReportableComponentIndicator")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setPortfolioContainingNonReportableComponentIndicator(Boolean _portfolioContainingNonReportableComponentIndicator) {
			this.portfolioContainingNonReportableComponentIndicator = _portfolioContainingNonReportableComponentIndicator == null ? null : _portfolioContainingNonReportableComponentIndicator;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@Override
		public HKMAMarginReport build() {
			return new HKMAMarginReport.HKMAMarginReportImpl(this);
		}
		
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty2()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getNumberRecords()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getCounterparty2Name()!=null) return true;
			if (getCounterparty2IdentifierFormat()!=null) return true;
			if (getPortfolioContainingNonReportableComponentIndicator()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMAMarginReport.HKMAMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			HKMAMarginReport.HKMAMarginReportBuilder o = (HKMAMarginReport.HKMAMarginReportBuilder) other;
			
			
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2OverriddenAsString);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierTypeOverriddenAsBoolean);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getNumberRecords(), o.getNumberRecords(), this::setNumberRecords);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			merger.mergeBasic(getCounterparty2Name(), o.getCounterparty2Name(), this::setCounterparty2Name);
			merger.mergeBasic(getCounterparty2IdentifierFormat(), o.getCounterparty2IdentifierFormat(), this::setCounterparty2IdentifierFormat);
			merger.mergeBasic(getPortfolioContainingNonReportableComponentIndicator(), o.getPortfolioContainingNonReportableComponentIndicator(), this::setPortfolioContainingNonReportableComponentIndicator);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			HKMAMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(numberRecords, _that.getNumberRecords())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(counterparty2Name, _that.getCounterparty2Name())) return false;
			if (!Objects.equals(counterparty2IdentifierFormat, _that.getCounterparty2IdentifierFormat())) return false;
			if (!Objects.equals(portfolioContainingNonReportableComponentIndicator, _that.getPortfolioContainingNonReportableComponentIndicator())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (numberRecords != null ? numberRecords.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (counterparty2Name != null ? counterparty2Name.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierFormat != null ? counterparty2IdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (portfolioContainingNonReportableComponentIndicator != null ? portfolioContainingNonReportableComponentIndicator.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMAMarginReportBuilder {" +
				"counterparty2=" + this.counterparty2 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"numberRecords=" + this.numberRecords + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"counterparty2Name=" + this.counterparty2Name + ", " +
				"counterparty2IdentifierFormat=" + this.counterparty2IdentifierFormat + ", " +
				"portfolioContainingNonReportableComponentIndicator=" + this.portfolioContainingNonReportableComponentIndicator + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting +
			'}' + " " + super.toString();
		}
	}
}
