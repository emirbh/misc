package drr.regulation.jfsa.rewrite.margin;

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
import drr.regulation.jfsa.rewrite.margin.meta.JFSAMarginReportMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="JFSAMarginReport", builder=JFSAMarginReport.JFSAMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="JFSAMarginReport", model="drr", builder=JFSAMarginReport.JFSAMarginReportBuilderImpl.class, version="7.7.0")
public interface JFSAMarginReport extends CommonMarginReport {

	JFSAMarginReportMeta metaData = new JFSAMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body JFSA
	 * Corpus Dissemination Margin   
	 * dataElement "104" * field "Event timestamp"
	 *
	 * Provision Date and time of occurrence of the event as determined by the reporting counterparty or a service provider. In the case of a clearing event, date and time when the original swap is accepted by the derivative clearing organization (DCO) for clearing and recorded by the DCOs system should be reported in this data element. The time element is as specific as technologically practicable.
	 *
	 *
	 * Body JFSA
	 * Corpus Dissemination Margin   
	 * dataElement "104" * field "Event timestamp - Remark"
	 *
	 * Provision System input time, data generation time, and system connection time are to be considered as acceptable values. In addition, if determining the time up to the seconds is impossible due to system restrictions, setting the seconds to '00' shall be acceptable.
	         Cancellation report of alpha - transactions by financial institutions do not necessarily have to match the date and time recorded by the central counterparty's system.
	         The date and time recorded by the central counterparty's system will be submitted by the central counterparty when they report their  and  transactions.
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body JFSA
	 * Corpus Dissemination Margin   
	 * dataElement "6" * field "Entity responsible for reporting"
	 *
	 * Provision The identifier of the financial institution that has the reporting obligation.
	 *
	 *
	 * Body JFSA
	 * Corpus Dissemination Margin   
	 * dataElement "6" * field "Entity responsible for reporting - Remark"
	 *
	 * Provision Reporting party of the trades will be determined based on the identifier reported for 'Entity responsible for reporting' and by 'Submitter identifier'. Examples of who the reporting party is:
	         [Case 1] Where a party to a transaction is other than a fund (normal case):
	         'Entity responsible for reporting' = Financial institution with reporting obligation and involved in the transaction as Counterparty 1
	         'Counterparty 1 (reporting counterparty)' = Same as above
	         'Submitter identifier' = Same as above
	         [Case 2] Where a trading party is a fund:
	         'Entity responsible for reporting' = Trust Bank LEI
	         'Counterparty 1 (reporting counterparty)' = Fund LEI
	         'Submitter identifier' = Trust bank LEI 
	         [Case 3] Reporting party is an agent, etc. (where a regional bank requests the Trust Bank, etc. to report):
	         'Entity responsible for reporting' = Financial institution with reporting obligation and involved in the transaction as Counterparty 1
	         'Counterparty 1 (reporting counterparty)' = Same as above
	         'Submitter identifier' = LEI of the agent acting as the service provider for reporting
	 *
	 */
	String getEntityResponsibleForReporting();
	/**
	 *
	 * Body JFSA
	 * Corpus Dissemination Margin   
	 * dataElement "[Internal]" * field "Technical Record Id (ISO)"
	 *
	 * Provision Unique technical identification of the original data for which the status is provided for the BDR. Not sent to JFSA.
	 *
	 */
	String getTechnicalRecordId();

	/*********************** Build Methods  ***********************/
	JFSAMarginReport build();
	
	JFSAMarginReport.JFSAMarginReportBuilder toBuilder();
	
	static JFSAMarginReport.JFSAMarginReportBuilder builder() {
		return new JFSAMarginReport.JFSAMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends JFSAMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends JFSAMarginReport> getType() {
		return JFSAMarginReport.class;
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
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface JFSAMarginReportBuilder extends JFSAMarginReport, CommonMarginReport.CommonMarginReportBuilder {
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setUti(String uti);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setActionType(MarginActionEnum actionType);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setEventDate(Date eventDate);
		@Override
		JFSAMarginReport.JFSAMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		JFSAMarginReport.JFSAMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		JFSAMarginReport.JFSAMarginReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		JFSAMarginReport.JFSAMarginReportBuilder setTechnicalRecordId(String technicalRecordId);

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
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		}
		

		JFSAMarginReport.JFSAMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of JFSAMarginReport  ***********************/
	class JFSAMarginReportImpl extends CommonMarginReport.CommonMarginReportImpl implements JFSAMarginReport {
		private final ZonedDateTime eventTimestamp;
		private final String entityResponsibleForReporting;
		private final String technicalRecordId;
		
		protected JFSAMarginReportImpl(JFSAMarginReport.JFSAMarginReportBuilder builder) {
			super(builder);
			this.eventTimestamp = builder.getEventTimestamp();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
			this.technicalRecordId = builder.getTechnicalRecordId();
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
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		public JFSAMarginReport build() {
			return this;
		}
		
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder toBuilder() {
			JFSAMarginReport.JFSAMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(JFSAMarginReport.JFSAMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReporting);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			JFSAMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JFSAMarginReport {" +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"technicalRecordId=" + this.technicalRecordId +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of JFSAMarginReport  ***********************/
	class JFSAMarginReportBuilderImpl extends CommonMarginReport.CommonMarginReportBuilderImpl implements JFSAMarginReport.JFSAMarginReportBuilder {
	
		protected ZonedDateTime eventTimestamp;
		protected String entityResponsibleForReporting;
		protected String technicalRecordId;
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@Override
		public JFSAMarginReport build() {
			return new JFSAMarginReport.JFSAMarginReportImpl(this);
		}
		
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventTimestamp()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JFSAMarginReport.JFSAMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			JFSAMarginReport.JFSAMarginReportBuilder o = (JFSAMarginReport.JFSAMarginReportBuilder) other;
			
			
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			JFSAMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JFSAMarginReportBuilder {" +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"technicalRecordId=" + this.technicalRecordId +
			'}' + " " + super.toString();
		}
	}
}
