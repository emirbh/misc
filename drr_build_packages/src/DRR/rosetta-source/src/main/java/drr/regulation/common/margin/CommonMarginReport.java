package drr.regulation.common.margin;

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
import drr.regulation.common.margin.meta.CommonMarginReportMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Common Valuation Report represents common attributes for the Valuation report
 * @version 7.7.0
 */
@RosettaDataType(value="CommonMarginReport", builder=CommonMarginReport.CommonMarginReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CommonMarginReport", model="drr", builder=CommonMarginReport.CommonMarginReportBuilderImpl.class, version="7.7.0")
public interface CommonMarginReport extends CriticalDataElement {

	CommonMarginReportMeta metaData = new CommonMarginReportMeta();

	/*********************** Getter Methods  ***********************/
	ZonedDateTime getCollateralTimestamp();
	String getVariationMarginCollateralPortfolioCode();
	String getInitialMarginCollateralPortfolioCode();
	String getReportSubmittingEntityID();
	MarginActionEnum getActionType();
	Date getEventDate();
	ZonedDateTime getEventTimestamp();

	/*********************** Build Methods  ***********************/
	CommonMarginReport build();
	
	CommonMarginReport.CommonMarginReportBuilder toBuilder();
	
	static CommonMarginReport.CommonMarginReportBuilder builder() {
		return new CommonMarginReport.CommonMarginReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonMarginReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonMarginReport> getType() {
		return CommonMarginReport.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonMarginReportBuilder extends CommonMarginReport, CriticalDataElement.CriticalDataElementBuilder {
		@Override
		CommonMarginReport.CommonMarginReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCounterparty1(String counterparty1);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCounterparty2(String counterparty2);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setUti(String uti);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		@Override
		CommonMarginReport.CommonMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);
		CommonMarginReport.CommonMarginReportBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		CommonMarginReport.CommonMarginReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		CommonMarginReport.CommonMarginReportBuilder setActionType(MarginActionEnum actionType);
		CommonMarginReport.CommonMarginReportBuilder setEventDate(Date eventDate);
		CommonMarginReport.CommonMarginReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);

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
		}
		

		CommonMarginReport.CommonMarginReportBuilder prune();
	}

	/*********************** Immutable Implementation of CommonMarginReport  ***********************/
	class CommonMarginReportImpl extends CriticalDataElement.CriticalDataElementImpl implements CommonMarginReport {
		private final ZonedDateTime collateralTimestamp;
		private final String variationMarginCollateralPortfolioCode;
		private final String initialMarginCollateralPortfolioCode;
		private final String reportSubmittingEntityID;
		private final MarginActionEnum actionType;
		private final Date eventDate;
		private final ZonedDateTime eventTimestamp;
		
		protected CommonMarginReportImpl(CommonMarginReport.CommonMarginReportBuilder builder) {
			super(builder);
			this.collateralTimestamp = builder.getCollateralTimestamp();
			this.variationMarginCollateralPortfolioCode = builder.getVariationMarginCollateralPortfolioCode();
			this.initialMarginCollateralPortfolioCode = builder.getInitialMarginCollateralPortfolioCode();
			this.reportSubmittingEntityID = builder.getReportSubmittingEntityID();
			this.actionType = builder.getActionType();
			this.eventDate = builder.getEventDate();
			this.eventTimestamp = builder.getEventTimestamp();
		}
		
		@Override
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralTimestamp")
		public ZonedDateTime getCollateralTimestamp() {
			return collateralTimestamp;
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
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public MarginActionEnum getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		public CommonMarginReport build() {
			return this;
		}
		
		@Override
		public CommonMarginReport.CommonMarginReportBuilder toBuilder() {
			CommonMarginReport.CommonMarginReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonMarginReport.CommonMarginReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCollateralTimestamp()).ifPresent(builder::setCollateralTimestamp);
			ofNullable(getVariationMarginCollateralPortfolioCode()).ifPresent(builder::setVariationMarginCollateralPortfolioCode);
			ofNullable(getInitialMarginCollateralPortfolioCode()).ifPresent(builder::setInitialMarginCollateralPortfolioCode);
			ofNullable(getReportSubmittingEntityID()).ifPresent(builder::setReportSubmittingEntityID);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getEventDate()).ifPresent(builder::setEventDate);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestamp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(collateralTimestamp, _that.getCollateralTimestamp())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralTimestamp != null ? collateralTimestamp.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonMarginReport {" +
				"collateralTimestamp=" + this.collateralTimestamp + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"actionType=" + this.actionType + ", " +
				"eventDate=" + this.eventDate + ", " +
				"eventTimestamp=" + this.eventTimestamp +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommonMarginReport  ***********************/
	class CommonMarginReportBuilderImpl extends CriticalDataElement.CriticalDataElementBuilderImpl implements CommonMarginReport.CommonMarginReportBuilder {
	
		protected ZonedDateTime collateralTimestamp;
		protected String variationMarginCollateralPortfolioCode;
		protected String initialMarginCollateralPortfolioCode;
		protected String reportSubmittingEntityID;
		protected MarginActionEnum actionType;
		protected Date eventDate;
		protected ZonedDateTime eventTimestamp;
		
		@Override
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralTimestamp")
		public ZonedDateTime getCollateralTimestamp() {
			return collateralTimestamp;
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
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public MarginActionEnum getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTimestamp")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setActionType(MarginActionEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDate")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTimestamp")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@Override
		public CommonMarginReport build() {
			return new CommonMarginReport.CommonMarginReportImpl(this);
		}
		
		@Override
		public CommonMarginReport.CommonMarginReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCollateralTimestamp()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getInitialMarginCollateralPortfolioCode()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getActionType()!=null) return true;
			if (getEventDate()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonMarginReport.CommonMarginReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommonMarginReport.CommonMarginReportBuilder o = (CommonMarginReport.CommonMarginReportBuilder) other;
			
			
			merger.mergeBasic(getCollateralTimestamp(), o.getCollateralTimestamp(), this::setCollateralTimestamp);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCode);
			merger.mergeBasic(getInitialMarginCollateralPortfolioCode(), o.getInitialMarginCollateralPortfolioCode(), this::setInitialMarginCollateralPortfolioCode);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityID);
			merger.mergeBasic(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDate);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestamp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonMarginReport _that = getType().cast(o);
		
			if (!Objects.equals(collateralTimestamp, _that.getCollateralTimestamp())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralTimestamp != null ? collateralTimestamp.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonMarginReportBuilder {" +
				"collateralTimestamp=" + this.collateralTimestamp + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"actionType=" + this.actionType + ", " +
				"eventDate=" + this.eventDate + ", " +
				"eventTimestamp=" + this.eventTimestamp +
			'}' + " " + super.toString();
		}
	}
}
