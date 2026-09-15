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
import drr.regulation.common.margin.meta.CriticalDataElementMeta;
import drr.standards.iso.CollateralisationType3Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Critical Data Elements for the Margin report
 * @version 7.7.0
 */
@RosettaDataType(value="CriticalDataElement", builder=CriticalDataElement.CriticalDataElementBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CriticalDataElement", model="drr", builder=CriticalDataElement.CriticalDataElementBuilderImpl.class, version="7.7.0")
public interface CriticalDataElement extends RosettaModelObject {

	CriticalDataElementMeta metaData = new CriticalDataElementMeta();

	/*********************** Getter Methods  ***********************/
	ZonedDateTime getReportingTimestamp();
	String getCounterparty1();
	Boolean getCounterparty2IdentifierType();
	String getCounterparty2();
	String getCollateralPortfolioCode();
	Boolean getCollateralPortfolioIndicator();
	String getUti();
	CollateralisationType3Code getCollateralisationCategory();
	BigDecimal getInitialMarginPostedByTheCounterparty1PreHaircut();
	BigDecimal getInitialMarginPostedByTheCounterparty1PostHaircut();
	ISOCurrencyCodeEnum getInitialMarginPostedByCounterparty1Currency();
	BigDecimal getVariationMarginPostedByTheCounterparty1PreHaircut();
	BigDecimal getVariationMarginPostedByTheCounterparty1PostHaircut();
	ISOCurrencyCodeEnum getVariationMarginPostedByCounterparty1Currency();
	BigDecimal getInitialMarginCollectedByCounterparty1PreHaircut();
	BigDecimal getInitialMarginCollectedByCounterparty1PostHaircut();
	ISOCurrencyCodeEnum getInitialMarginCollectedByCounterparty1Currency();
	BigDecimal getVariationMarginCollectedByTheCounterparty1PreHaircut();
	BigDecimal getVariationMarginCollectedByTheCounterparty1PostHaircut();
	ISOCurrencyCodeEnum getVariationMarginCollectedByCounterparty1Currency();
	BigDecimal getExcessCollateralPostedByTheCounterparty1();
	String getCurrencyOfTheExcessCollateralPosted();
	BigDecimal getExcessCollateralCollectedByTheCounterparty1();
	String getCurrencyOfTheExcessCollateralCollected();

	/*********************** Build Methods  ***********************/
	CriticalDataElement build();
	
	CriticalDataElement.CriticalDataElementBuilder toBuilder();
	
	static CriticalDataElement.CriticalDataElementBuilder builder() {
		return new CriticalDataElement.CriticalDataElementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CriticalDataElement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CriticalDataElement> getType() {
		return CriticalDataElement.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CriticalDataElementBuilder extends CriticalDataElement, RosettaModelObjectBuilder {
		CriticalDataElement.CriticalDataElementBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		CriticalDataElement.CriticalDataElementBuilder setCounterparty1(String counterparty1);
		CriticalDataElement.CriticalDataElementBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		CriticalDataElement.CriticalDataElementBuilder setCounterparty2(String counterparty2);
		CriticalDataElement.CriticalDataElementBuilder setCollateralPortfolioCode(String collateralPortfolioCode);
		CriticalDataElement.CriticalDataElementBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		CriticalDataElement.CriticalDataElementBuilder setUti(String uti);
		CriticalDataElement.CriticalDataElementBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);
		CriticalDataElement.CriticalDataElementBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal initialMarginPostedByTheCounterparty1PreHaircut);
		CriticalDataElement.CriticalDataElementBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal initialMarginPostedByTheCounterparty1PostHaircut);
		CriticalDataElement.CriticalDataElementBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency);
		CriticalDataElement.CriticalDataElementBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal variationMarginPostedByTheCounterparty1PreHaircut);
		CriticalDataElement.CriticalDataElementBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal variationMarginPostedByTheCounterparty1PostHaircut);
		CriticalDataElement.CriticalDataElementBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency);
		CriticalDataElement.CriticalDataElementBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal initialMarginCollectedByCounterparty1PreHaircut);
		CriticalDataElement.CriticalDataElementBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal initialMarginCollectedByCounterparty1PostHaircut);
		CriticalDataElement.CriticalDataElementBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency);
		CriticalDataElement.CriticalDataElementBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut);
		CriticalDataElement.CriticalDataElementBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut);
		CriticalDataElement.CriticalDataElementBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency);
		CriticalDataElement.CriticalDataElementBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal excessCollateralPostedByTheCounterparty1);
		CriticalDataElement.CriticalDataElementBuilder setCurrencyOfTheExcessCollateralPosted(String currencyOfTheExcessCollateralPosted);
		CriticalDataElement.CriticalDataElementBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal excessCollateralCollectedByTheCounterparty1);
		CriticalDataElement.CriticalDataElementBuilder setCurrencyOfTheExcessCollateralCollected(String currencyOfTheExcessCollateralCollected);

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
		}
		

		CriticalDataElement.CriticalDataElementBuilder prune();
	}

	/*********************** Immutable Implementation of CriticalDataElement  ***********************/
	class CriticalDataElementImpl implements CriticalDataElement {
		private final ZonedDateTime reportingTimestamp;
		private final String counterparty1;
		private final Boolean counterparty2IdentifierType;
		private final String counterparty2;
		private final String collateralPortfolioCode;
		private final Boolean collateralPortfolioIndicator;
		private final String uti;
		private final CollateralisationType3Code collateralisationCategory;
		private final BigDecimal initialMarginPostedByTheCounterparty1PreHaircut;
		private final BigDecimal initialMarginPostedByTheCounterparty1PostHaircut;
		private final ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency;
		private final BigDecimal variationMarginPostedByTheCounterparty1PreHaircut;
		private final BigDecimal variationMarginPostedByTheCounterparty1PostHaircut;
		private final ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency;
		private final BigDecimal initialMarginCollectedByCounterparty1PreHaircut;
		private final BigDecimal initialMarginCollectedByCounterparty1PostHaircut;
		private final ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency;
		private final BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut;
		private final BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut;
		private final ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency;
		private final BigDecimal excessCollateralPostedByTheCounterparty1;
		private final String currencyOfTheExcessCollateralPosted;
		private final BigDecimal excessCollateralCollectedByTheCounterparty1;
		private final String currencyOfTheExcessCollateralCollected;
		
		protected CriticalDataElementImpl(CriticalDataElement.CriticalDataElementBuilder builder) {
			this.reportingTimestamp = builder.getReportingTimestamp();
			this.counterparty1 = builder.getCounterparty1();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.counterparty2 = builder.getCounterparty2();
			this.collateralPortfolioCode = builder.getCollateralPortfolioCode();
			this.collateralPortfolioIndicator = builder.getCollateralPortfolioIndicator();
			this.uti = builder.getUti();
			this.collateralisationCategory = builder.getCollateralisationCategory();
			this.initialMarginPostedByTheCounterparty1PreHaircut = builder.getInitialMarginPostedByTheCounterparty1PreHaircut();
			this.initialMarginPostedByTheCounterparty1PostHaircut = builder.getInitialMarginPostedByTheCounterparty1PostHaircut();
			this.initialMarginPostedByCounterparty1Currency = builder.getInitialMarginPostedByCounterparty1Currency();
			this.variationMarginPostedByTheCounterparty1PreHaircut = builder.getVariationMarginPostedByTheCounterparty1PreHaircut();
			this.variationMarginPostedByTheCounterparty1PostHaircut = builder.getVariationMarginPostedByTheCounterparty1PostHaircut();
			this.variationMarginPostedByCounterparty1Currency = builder.getVariationMarginPostedByCounterparty1Currency();
			this.initialMarginCollectedByCounterparty1PreHaircut = builder.getInitialMarginCollectedByCounterparty1PreHaircut();
			this.initialMarginCollectedByCounterparty1PostHaircut = builder.getInitialMarginCollectedByCounterparty1PostHaircut();
			this.initialMarginCollectedByCounterparty1Currency = builder.getInitialMarginCollectedByCounterparty1Currency();
			this.variationMarginCollectedByTheCounterparty1PreHaircut = builder.getVariationMarginCollectedByTheCounterparty1PreHaircut();
			this.variationMarginCollectedByTheCounterparty1PostHaircut = builder.getVariationMarginCollectedByTheCounterparty1PostHaircut();
			this.variationMarginCollectedByCounterparty1Currency = builder.getVariationMarginCollectedByCounterparty1Currency();
			this.excessCollateralPostedByTheCounterparty1 = builder.getExcessCollateralPostedByTheCounterparty1();
			this.currencyOfTheExcessCollateralPosted = builder.getCurrencyOfTheExcessCollateralPosted();
			this.excessCollateralCollectedByTheCounterparty1 = builder.getExcessCollateralCollectedByTheCounterparty1();
			this.currencyOfTheExcessCollateralCollected = builder.getCurrencyOfTheExcessCollateralCollected();
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioCode")
		public String getCollateralPortfolioCode() {
			return collateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		public Boolean getCollateralPortfolioIndicator() {
			return collateralPortfolioIndicator;
		}
		
		@Override
		@RosettaAttribute("uti")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uti")
		public String getUti() {
			return uti;
		}
		
		@Override
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralisationCategory")
		public CollateralisationType3Code getCollateralisationCategory() {
			return collateralisationCategory;
		}
		
		@Override
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		public BigDecimal getInitialMarginPostedByTheCounterparty1PreHaircut() {
			return initialMarginPostedByTheCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		public BigDecimal getInitialMarginPostedByTheCounterparty1PostHaircut() {
			return initialMarginPostedByTheCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getInitialMarginPostedByCounterparty1Currency() {
			return initialMarginPostedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		public BigDecimal getVariationMarginPostedByTheCounterparty1PreHaircut() {
			return variationMarginPostedByTheCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		public BigDecimal getVariationMarginPostedByTheCounterparty1PostHaircut() {
			return variationMarginPostedByTheCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getVariationMarginPostedByCounterparty1Currency() {
			return variationMarginPostedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		public BigDecimal getInitialMarginCollectedByCounterparty1PreHaircut() {
			return initialMarginCollectedByCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		public BigDecimal getInitialMarginCollectedByCounterparty1PostHaircut() {
			return initialMarginCollectedByCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getInitialMarginCollectedByCounterparty1Currency() {
			return initialMarginCollectedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		public BigDecimal getVariationMarginCollectedByTheCounterparty1PreHaircut() {
			return variationMarginCollectedByTheCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		public BigDecimal getVariationMarginCollectedByTheCounterparty1PostHaircut() {
			return variationMarginCollectedByTheCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getVariationMarginCollectedByCounterparty1Currency() {
			return variationMarginCollectedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		public BigDecimal getExcessCollateralPostedByTheCounterparty1() {
			return excessCollateralPostedByTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		public String getCurrencyOfTheExcessCollateralPosted() {
			return currencyOfTheExcessCollateralPosted;
		}
		
		@Override
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		public BigDecimal getExcessCollateralCollectedByTheCounterparty1() {
			return excessCollateralCollectedByTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		public String getCurrencyOfTheExcessCollateralCollected() {
			return currencyOfTheExcessCollateralCollected;
		}
		
		@Override
		public CriticalDataElement build() {
			return this;
		}
		
		@Override
		public CriticalDataElement.CriticalDataElementBuilder toBuilder() {
			CriticalDataElement.CriticalDataElementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CriticalDataElement.CriticalDataElementBuilder builder) {
			ofNullable(getReportingTimestamp()).ifPresent(builder::setReportingTimestamp);
			ofNullable(getCounterparty1()).ifPresent(builder::setCounterparty1);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierType);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2);
			ofNullable(getCollateralPortfolioCode()).ifPresent(builder::setCollateralPortfolioCode);
			ofNullable(getCollateralPortfolioIndicator()).ifPresent(builder::setCollateralPortfolioIndicator);
			ofNullable(getUti()).ifPresent(builder::setUti);
			ofNullable(getCollateralisationCategory()).ifPresent(builder::setCollateralisationCategory);
			ofNullable(getInitialMarginPostedByTheCounterparty1PreHaircut()).ifPresent(builder::setInitialMarginPostedByTheCounterparty1PreHaircut);
			ofNullable(getInitialMarginPostedByTheCounterparty1PostHaircut()).ifPresent(builder::setInitialMarginPostedByTheCounterparty1PostHaircut);
			ofNullable(getInitialMarginPostedByCounterparty1Currency()).ifPresent(builder::setInitialMarginPostedByCounterparty1Currency);
			ofNullable(getVariationMarginPostedByTheCounterparty1PreHaircut()).ifPresent(builder::setVariationMarginPostedByTheCounterparty1PreHaircut);
			ofNullable(getVariationMarginPostedByTheCounterparty1PostHaircut()).ifPresent(builder::setVariationMarginPostedByTheCounterparty1PostHaircut);
			ofNullable(getVariationMarginPostedByCounterparty1Currency()).ifPresent(builder::setVariationMarginPostedByCounterparty1Currency);
			ofNullable(getInitialMarginCollectedByCounterparty1PreHaircut()).ifPresent(builder::setInitialMarginCollectedByCounterparty1PreHaircut);
			ofNullable(getInitialMarginCollectedByCounterparty1PostHaircut()).ifPresent(builder::setInitialMarginCollectedByCounterparty1PostHaircut);
			ofNullable(getInitialMarginCollectedByCounterparty1Currency()).ifPresent(builder::setInitialMarginCollectedByCounterparty1Currency);
			ofNullable(getVariationMarginCollectedByTheCounterparty1PreHaircut()).ifPresent(builder::setVariationMarginCollectedByTheCounterparty1PreHaircut);
			ofNullable(getVariationMarginCollectedByTheCounterparty1PostHaircut()).ifPresent(builder::setVariationMarginCollectedByTheCounterparty1PostHaircut);
			ofNullable(getVariationMarginCollectedByCounterparty1Currency()).ifPresent(builder::setVariationMarginCollectedByCounterparty1Currency);
			ofNullable(getExcessCollateralPostedByTheCounterparty1()).ifPresent(builder::setExcessCollateralPostedByTheCounterparty1);
			ofNullable(getCurrencyOfTheExcessCollateralPosted()).ifPresent(builder::setCurrencyOfTheExcessCollateralPosted);
			ofNullable(getExcessCollateralCollectedByTheCounterparty1()).ifPresent(builder::setExcessCollateralCollectedByTheCounterparty1);
			ofNullable(getCurrencyOfTheExcessCollateralCollected()).ifPresent(builder::setCurrencyOfTheExcessCollateralCollected);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElement _that = getType().cast(o);
		
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(collateralPortfolioCode, _that.getCollateralPortfolioCode())) return false;
			if (!Objects.equals(collateralPortfolioIndicator, _that.getCollateralPortfolioIndicator())) return false;
			if (!Objects.equals(uti, _that.getUti())) return false;
			if (!Objects.equals(collateralisationCategory, _that.getCollateralisationCategory())) return false;
			if (!Objects.equals(initialMarginPostedByTheCounterparty1PreHaircut, _that.getInitialMarginPostedByTheCounterparty1PreHaircut())) return false;
			if (!Objects.equals(initialMarginPostedByTheCounterparty1PostHaircut, _that.getInitialMarginPostedByTheCounterparty1PostHaircut())) return false;
			if (!Objects.equals(initialMarginPostedByCounterparty1Currency, _that.getInitialMarginPostedByCounterparty1Currency())) return false;
			if (!Objects.equals(variationMarginPostedByTheCounterparty1PreHaircut, _that.getVariationMarginPostedByTheCounterparty1PreHaircut())) return false;
			if (!Objects.equals(variationMarginPostedByTheCounterparty1PostHaircut, _that.getVariationMarginPostedByTheCounterparty1PostHaircut())) return false;
			if (!Objects.equals(variationMarginPostedByCounterparty1Currency, _that.getVariationMarginPostedByCounterparty1Currency())) return false;
			if (!Objects.equals(initialMarginCollectedByCounterparty1PreHaircut, _that.getInitialMarginCollectedByCounterparty1PreHaircut())) return false;
			if (!Objects.equals(initialMarginCollectedByCounterparty1PostHaircut, _that.getInitialMarginCollectedByCounterparty1PostHaircut())) return false;
			if (!Objects.equals(initialMarginCollectedByCounterparty1Currency, _that.getInitialMarginCollectedByCounterparty1Currency())) return false;
			if (!Objects.equals(variationMarginCollectedByTheCounterparty1PreHaircut, _that.getVariationMarginCollectedByTheCounterparty1PreHaircut())) return false;
			if (!Objects.equals(variationMarginCollectedByTheCounterparty1PostHaircut, _that.getVariationMarginCollectedByTheCounterparty1PostHaircut())) return false;
			if (!Objects.equals(variationMarginCollectedByCounterparty1Currency, _that.getVariationMarginCollectedByCounterparty1Currency())) return false;
			if (!Objects.equals(excessCollateralPostedByTheCounterparty1, _that.getExcessCollateralPostedByTheCounterparty1())) return false;
			if (!Objects.equals(currencyOfTheExcessCollateralPosted, _that.getCurrencyOfTheExcessCollateralPosted())) return false;
			if (!Objects.equals(excessCollateralCollectedByTheCounterparty1, _that.getExcessCollateralCollectedByTheCounterparty1())) return false;
			if (!Objects.equals(currencyOfTheExcessCollateralCollected, _that.getCurrencyOfTheExcessCollateralCollected())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioCode != null ? collateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIndicator != null ? collateralPortfolioIndicator.hashCode() : 0);
			_result = 31 * _result + (uti != null ? uti.hashCode() : 0);
			_result = 31 * _result + (collateralisationCategory != null ? collateralisationCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (initialMarginPostedByTheCounterparty1PreHaircut != null ? initialMarginPostedByTheCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginPostedByTheCounterparty1PostHaircut != null ? initialMarginPostedByTheCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginPostedByCounterparty1Currency != null ? initialMarginPostedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (variationMarginPostedByTheCounterparty1PreHaircut != null ? variationMarginPostedByTheCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginPostedByTheCounterparty1PostHaircut != null ? variationMarginPostedByTheCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginPostedByCounterparty1Currency != null ? variationMarginPostedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (initialMarginCollectedByCounterparty1PreHaircut != null ? initialMarginCollectedByCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollectedByCounterparty1PostHaircut != null ? initialMarginCollectedByCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollectedByCounterparty1Currency != null ? initialMarginCollectedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (variationMarginCollectedByTheCounterparty1PreHaircut != null ? variationMarginCollectedByTheCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollectedByTheCounterparty1PostHaircut != null ? variationMarginCollectedByTheCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollectedByCounterparty1Currency != null ? variationMarginCollectedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (excessCollateralPostedByTheCounterparty1 != null ? excessCollateralPostedByTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (currencyOfTheExcessCollateralPosted != null ? currencyOfTheExcessCollateralPosted.hashCode() : 0);
			_result = 31 * _result + (excessCollateralCollectedByTheCounterparty1 != null ? excessCollateralCollectedByTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (currencyOfTheExcessCollateralCollected != null ? currencyOfTheExcessCollateralCollected.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElement {" +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"collateralPortfolioCode=" + this.collateralPortfolioCode + ", " +
				"collateralPortfolioIndicator=" + this.collateralPortfolioIndicator + ", " +
				"uti=" + this.uti + ", " +
				"collateralisationCategory=" + this.collateralisationCategory + ", " +
				"initialMarginPostedByTheCounterparty1PreHaircut=" + this.initialMarginPostedByTheCounterparty1PreHaircut + ", " +
				"initialMarginPostedByTheCounterparty1PostHaircut=" + this.initialMarginPostedByTheCounterparty1PostHaircut + ", " +
				"initialMarginPostedByCounterparty1Currency=" + this.initialMarginPostedByCounterparty1Currency + ", " +
				"variationMarginPostedByTheCounterparty1PreHaircut=" + this.variationMarginPostedByTheCounterparty1PreHaircut + ", " +
				"variationMarginPostedByTheCounterparty1PostHaircut=" + this.variationMarginPostedByTheCounterparty1PostHaircut + ", " +
				"variationMarginPostedByCounterparty1Currency=" + this.variationMarginPostedByCounterparty1Currency + ", " +
				"initialMarginCollectedByCounterparty1PreHaircut=" + this.initialMarginCollectedByCounterparty1PreHaircut + ", " +
				"initialMarginCollectedByCounterparty1PostHaircut=" + this.initialMarginCollectedByCounterparty1PostHaircut + ", " +
				"initialMarginCollectedByCounterparty1Currency=" + this.initialMarginCollectedByCounterparty1Currency + ", " +
				"variationMarginCollectedByTheCounterparty1PreHaircut=" + this.variationMarginCollectedByTheCounterparty1PreHaircut + ", " +
				"variationMarginCollectedByTheCounterparty1PostHaircut=" + this.variationMarginCollectedByTheCounterparty1PostHaircut + ", " +
				"variationMarginCollectedByCounterparty1Currency=" + this.variationMarginCollectedByCounterparty1Currency + ", " +
				"excessCollateralPostedByTheCounterparty1=" + this.excessCollateralPostedByTheCounterparty1 + ", " +
				"currencyOfTheExcessCollateralPosted=" + this.currencyOfTheExcessCollateralPosted + ", " +
				"excessCollateralCollectedByTheCounterparty1=" + this.excessCollateralCollectedByTheCounterparty1 + ", " +
				"currencyOfTheExcessCollateralCollected=" + this.currencyOfTheExcessCollateralCollected +
			'}';
		}
	}

	/*********************** Builder Implementation of CriticalDataElement  ***********************/
	class CriticalDataElementBuilderImpl implements CriticalDataElement.CriticalDataElementBuilder {
	
		protected ZonedDateTime reportingTimestamp;
		protected String counterparty1;
		protected Boolean counterparty2IdentifierType;
		protected String counterparty2;
		protected String collateralPortfolioCode;
		protected Boolean collateralPortfolioIndicator;
		protected String uti;
		protected CollateralisationType3Code collateralisationCategory;
		protected BigDecimal initialMarginPostedByTheCounterparty1PreHaircut;
		protected BigDecimal initialMarginPostedByTheCounterparty1PostHaircut;
		protected ISOCurrencyCodeEnum initialMarginPostedByCounterparty1Currency;
		protected BigDecimal variationMarginPostedByTheCounterparty1PreHaircut;
		protected BigDecimal variationMarginPostedByTheCounterparty1PostHaircut;
		protected ISOCurrencyCodeEnum variationMarginPostedByCounterparty1Currency;
		protected BigDecimal initialMarginCollectedByCounterparty1PreHaircut;
		protected BigDecimal initialMarginCollectedByCounterparty1PostHaircut;
		protected ISOCurrencyCodeEnum initialMarginCollectedByCounterparty1Currency;
		protected BigDecimal variationMarginCollectedByTheCounterparty1PreHaircut;
		protected BigDecimal variationMarginCollectedByTheCounterparty1PostHaircut;
		protected ISOCurrencyCodeEnum variationMarginCollectedByCounterparty1Currency;
		protected BigDecimal excessCollateralPostedByTheCounterparty1;
		protected String currencyOfTheExcessCollateralPosted;
		protected BigDecimal excessCollateralCollectedByTheCounterparty1;
		protected String currencyOfTheExcessCollateralCollected;
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioCode")
		public String getCollateralPortfolioCode() {
			return collateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		public Boolean getCollateralPortfolioIndicator() {
			return collateralPortfolioIndicator;
		}
		
		@Override
		@RosettaAttribute("uti")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uti")
		public String getUti() {
			return uti;
		}
		
		@Override
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralisationCategory")
		public CollateralisationType3Code getCollateralisationCategory() {
			return collateralisationCategory;
		}
		
		@Override
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		public BigDecimal getInitialMarginPostedByTheCounterparty1PreHaircut() {
			return initialMarginPostedByTheCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		public BigDecimal getInitialMarginPostedByTheCounterparty1PostHaircut() {
			return initialMarginPostedByTheCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getInitialMarginPostedByCounterparty1Currency() {
			return initialMarginPostedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		public BigDecimal getVariationMarginPostedByTheCounterparty1PreHaircut() {
			return variationMarginPostedByTheCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		public BigDecimal getVariationMarginPostedByTheCounterparty1PostHaircut() {
			return variationMarginPostedByTheCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getVariationMarginPostedByCounterparty1Currency() {
			return variationMarginPostedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		public BigDecimal getInitialMarginCollectedByCounterparty1PreHaircut() {
			return initialMarginCollectedByCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		public BigDecimal getInitialMarginCollectedByCounterparty1PostHaircut() {
			return initialMarginCollectedByCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getInitialMarginCollectedByCounterparty1Currency() {
			return initialMarginCollectedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		public BigDecimal getVariationMarginCollectedByTheCounterparty1PreHaircut() {
			return variationMarginCollectedByTheCounterparty1PreHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		public BigDecimal getVariationMarginCollectedByTheCounterparty1PostHaircut() {
			return variationMarginCollectedByTheCounterparty1PostHaircut;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		public ISOCurrencyCodeEnum getVariationMarginCollectedByCounterparty1Currency() {
			return variationMarginCollectedByCounterparty1Currency;
		}
		
		@Override
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		public BigDecimal getExcessCollateralPostedByTheCounterparty1() {
			return excessCollateralPostedByTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		public String getCurrencyOfTheExcessCollateralPosted() {
			return currencyOfTheExcessCollateralPosted;
		}
		
		@Override
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		public BigDecimal getExcessCollateralCollectedByTheCounterparty1() {
			return excessCollateralCollectedByTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		public String getCurrencyOfTheExcessCollateralCollected() {
			return currencyOfTheExcessCollateralCollected;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioCode")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCollateralPortfolioCode(String _collateralPortfolioCode) {
			this.collateralPortfolioCode = _collateralPortfolioCode == null ? null : _collateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("uti")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uti")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setUti(String _uti) {
			this.uti = _uti == null ? null : _uti;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralisationCategory")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setInitialMarginPostedByTheCounterparty1PreHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PreHaircut) {
			this.initialMarginPostedByTheCounterparty1PreHaircut = _initialMarginPostedByTheCounterparty1PreHaircut == null ? null : _initialMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setInitialMarginPostedByTheCounterparty1PostHaircut(BigDecimal _initialMarginPostedByTheCounterparty1PostHaircut) {
			this.initialMarginPostedByTheCounterparty1PostHaircut = _initialMarginPostedByTheCounterparty1PostHaircut == null ? null : _initialMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginPostedByCounterparty1Currency")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setInitialMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginPostedByCounterparty1Currency) {
			this.initialMarginPostedByCounterparty1Currency = _initialMarginPostedByCounterparty1Currency == null ? null : _initialMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PreHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setVariationMarginPostedByTheCounterparty1PreHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PreHaircut) {
			this.variationMarginPostedByTheCounterparty1PreHaircut = _variationMarginPostedByTheCounterparty1PreHaircut == null ? null : _variationMarginPostedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByTheCounterparty1PostHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setVariationMarginPostedByTheCounterparty1PostHaircut(BigDecimal _variationMarginPostedByTheCounterparty1PostHaircut) {
			this.variationMarginPostedByTheCounterparty1PostHaircut = _variationMarginPostedByTheCounterparty1PostHaircut == null ? null : _variationMarginPostedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginPostedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginPostedByCounterparty1Currency")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setVariationMarginPostedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginPostedByCounterparty1Currency) {
			this.variationMarginPostedByCounterparty1Currency = _variationMarginPostedByCounterparty1Currency == null ? null : _variationMarginPostedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PreHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setInitialMarginCollectedByCounterparty1PreHaircut(BigDecimal _initialMarginCollectedByCounterparty1PreHaircut) {
			this.initialMarginCollectedByCounterparty1PreHaircut = _initialMarginCollectedByCounterparty1PreHaircut == null ? null : _initialMarginCollectedByCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1PostHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setInitialMarginCollectedByCounterparty1PostHaircut(BigDecimal _initialMarginCollectedByCounterparty1PostHaircut) {
			this.initialMarginCollectedByCounterparty1PostHaircut = _initialMarginCollectedByCounterparty1PostHaircut == null ? null : _initialMarginCollectedByCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollectedByCounterparty1Currency")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setInitialMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _initialMarginCollectedByCounterparty1Currency) {
			this.initialMarginCollectedByCounterparty1Currency = _initialMarginCollectedByCounterparty1Currency == null ? null : _initialMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PreHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setVariationMarginCollectedByTheCounterparty1PreHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PreHaircut) {
			this.variationMarginCollectedByTheCounterparty1PreHaircut = _variationMarginCollectedByTheCounterparty1PreHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PreHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByTheCounterparty1PostHaircut")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setVariationMarginCollectedByTheCounterparty1PostHaircut(BigDecimal _variationMarginCollectedByTheCounterparty1PostHaircut) {
			this.variationMarginCollectedByTheCounterparty1PostHaircut = _variationMarginCollectedByTheCounterparty1PostHaircut == null ? null : _variationMarginCollectedByTheCounterparty1PostHaircut;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollectedByCounterparty1Currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollectedByCounterparty1Currency")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setVariationMarginCollectedByCounterparty1Currency(ISOCurrencyCodeEnum _variationMarginCollectedByCounterparty1Currency) {
			this.variationMarginCollectedByCounterparty1Currency = _variationMarginCollectedByCounterparty1Currency == null ? null : _variationMarginCollectedByCounterparty1Currency;
			return this;
		}
		
		@RosettaAttribute("excessCollateralPostedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralPostedByTheCounterparty1")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setExcessCollateralPostedByTheCounterparty1(BigDecimal _excessCollateralPostedByTheCounterparty1) {
			this.excessCollateralPostedByTheCounterparty1 = _excessCollateralPostedByTheCounterparty1 == null ? null : _excessCollateralPostedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralPosted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralPosted")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCurrencyOfTheExcessCollateralPosted(String _currencyOfTheExcessCollateralPosted) {
			this.currencyOfTheExcessCollateralPosted = _currencyOfTheExcessCollateralPosted == null ? null : _currencyOfTheExcessCollateralPosted;
			return this;
		}
		
		@RosettaAttribute("excessCollateralCollectedByTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessCollateralCollectedByTheCounterparty1")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setExcessCollateralCollectedByTheCounterparty1(BigDecimal _excessCollateralCollectedByTheCounterparty1) {
			this.excessCollateralCollectedByTheCounterparty1 = _excessCollateralCollectedByTheCounterparty1 == null ? null : _excessCollateralCollectedByTheCounterparty1;
			return this;
		}
		
		@RosettaAttribute("currencyOfTheExcessCollateralCollected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfTheExcessCollateralCollected")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCurrencyOfTheExcessCollateralCollected(String _currencyOfTheExcessCollateralCollected) {
			this.currencyOfTheExcessCollateralCollected = _currencyOfTheExcessCollateralCollected == null ? null : _currencyOfTheExcessCollateralCollected;
			return this;
		}
		
		@Override
		public CriticalDataElement build() {
			return new CriticalDataElement.CriticalDataElementImpl(this);
		}
		
		@Override
		public CriticalDataElement.CriticalDataElementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportingTimestamp()!=null) return true;
			if (getCounterparty1()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getCounterparty2()!=null) return true;
			if (getCollateralPortfolioCode()!=null) return true;
			if (getCollateralPortfolioIndicator()!=null) return true;
			if (getUti()!=null) return true;
			if (getCollateralisationCategory()!=null) return true;
			if (getInitialMarginPostedByTheCounterparty1PreHaircut()!=null) return true;
			if (getInitialMarginPostedByTheCounterparty1PostHaircut()!=null) return true;
			if (getInitialMarginPostedByCounterparty1Currency()!=null) return true;
			if (getVariationMarginPostedByTheCounterparty1PreHaircut()!=null) return true;
			if (getVariationMarginPostedByTheCounterparty1PostHaircut()!=null) return true;
			if (getVariationMarginPostedByCounterparty1Currency()!=null) return true;
			if (getInitialMarginCollectedByCounterparty1PreHaircut()!=null) return true;
			if (getInitialMarginCollectedByCounterparty1PostHaircut()!=null) return true;
			if (getInitialMarginCollectedByCounterparty1Currency()!=null) return true;
			if (getVariationMarginCollectedByTheCounterparty1PreHaircut()!=null) return true;
			if (getVariationMarginCollectedByTheCounterparty1PostHaircut()!=null) return true;
			if (getVariationMarginCollectedByCounterparty1Currency()!=null) return true;
			if (getExcessCollateralPostedByTheCounterparty1()!=null) return true;
			if (getCurrencyOfTheExcessCollateralPosted()!=null) return true;
			if (getExcessCollateralCollectedByTheCounterparty1()!=null) return true;
			if (getCurrencyOfTheExcessCollateralCollected()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CriticalDataElement.CriticalDataElementBuilder o = (CriticalDataElement.CriticalDataElementBuilder) other;
			
			
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierType);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2);
			merger.mergeBasic(getCollateralPortfolioCode(), o.getCollateralPortfolioCode(), this::setCollateralPortfolioCode);
			merger.mergeBasic(getCollateralPortfolioIndicator(), o.getCollateralPortfolioIndicator(), this::setCollateralPortfolioIndicator);
			merger.mergeBasic(getUti(), o.getUti(), this::setUti);
			merger.mergeBasic(getCollateralisationCategory(), o.getCollateralisationCategory(), this::setCollateralisationCategory);
			merger.mergeBasic(getInitialMarginPostedByTheCounterparty1PreHaircut(), o.getInitialMarginPostedByTheCounterparty1PreHaircut(), this::setInitialMarginPostedByTheCounterparty1PreHaircut);
			merger.mergeBasic(getInitialMarginPostedByTheCounterparty1PostHaircut(), o.getInitialMarginPostedByTheCounterparty1PostHaircut(), this::setInitialMarginPostedByTheCounterparty1PostHaircut);
			merger.mergeBasic(getInitialMarginPostedByCounterparty1Currency(), o.getInitialMarginPostedByCounterparty1Currency(), this::setInitialMarginPostedByCounterparty1Currency);
			merger.mergeBasic(getVariationMarginPostedByTheCounterparty1PreHaircut(), o.getVariationMarginPostedByTheCounterparty1PreHaircut(), this::setVariationMarginPostedByTheCounterparty1PreHaircut);
			merger.mergeBasic(getVariationMarginPostedByTheCounterparty1PostHaircut(), o.getVariationMarginPostedByTheCounterparty1PostHaircut(), this::setVariationMarginPostedByTheCounterparty1PostHaircut);
			merger.mergeBasic(getVariationMarginPostedByCounterparty1Currency(), o.getVariationMarginPostedByCounterparty1Currency(), this::setVariationMarginPostedByCounterparty1Currency);
			merger.mergeBasic(getInitialMarginCollectedByCounterparty1PreHaircut(), o.getInitialMarginCollectedByCounterparty1PreHaircut(), this::setInitialMarginCollectedByCounterparty1PreHaircut);
			merger.mergeBasic(getInitialMarginCollectedByCounterparty1PostHaircut(), o.getInitialMarginCollectedByCounterparty1PostHaircut(), this::setInitialMarginCollectedByCounterparty1PostHaircut);
			merger.mergeBasic(getInitialMarginCollectedByCounterparty1Currency(), o.getInitialMarginCollectedByCounterparty1Currency(), this::setInitialMarginCollectedByCounterparty1Currency);
			merger.mergeBasic(getVariationMarginCollectedByTheCounterparty1PreHaircut(), o.getVariationMarginCollectedByTheCounterparty1PreHaircut(), this::setVariationMarginCollectedByTheCounterparty1PreHaircut);
			merger.mergeBasic(getVariationMarginCollectedByTheCounterparty1PostHaircut(), o.getVariationMarginCollectedByTheCounterparty1PostHaircut(), this::setVariationMarginCollectedByTheCounterparty1PostHaircut);
			merger.mergeBasic(getVariationMarginCollectedByCounterparty1Currency(), o.getVariationMarginCollectedByCounterparty1Currency(), this::setVariationMarginCollectedByCounterparty1Currency);
			merger.mergeBasic(getExcessCollateralPostedByTheCounterparty1(), o.getExcessCollateralPostedByTheCounterparty1(), this::setExcessCollateralPostedByTheCounterparty1);
			merger.mergeBasic(getCurrencyOfTheExcessCollateralPosted(), o.getCurrencyOfTheExcessCollateralPosted(), this::setCurrencyOfTheExcessCollateralPosted);
			merger.mergeBasic(getExcessCollateralCollectedByTheCounterparty1(), o.getExcessCollateralCollectedByTheCounterparty1(), this::setExcessCollateralCollectedByTheCounterparty1);
			merger.mergeBasic(getCurrencyOfTheExcessCollateralCollected(), o.getCurrencyOfTheExcessCollateralCollected(), this::setCurrencyOfTheExcessCollateralCollected);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElement _that = getType().cast(o);
		
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(collateralPortfolioCode, _that.getCollateralPortfolioCode())) return false;
			if (!Objects.equals(collateralPortfolioIndicator, _that.getCollateralPortfolioIndicator())) return false;
			if (!Objects.equals(uti, _that.getUti())) return false;
			if (!Objects.equals(collateralisationCategory, _that.getCollateralisationCategory())) return false;
			if (!Objects.equals(initialMarginPostedByTheCounterparty1PreHaircut, _that.getInitialMarginPostedByTheCounterparty1PreHaircut())) return false;
			if (!Objects.equals(initialMarginPostedByTheCounterparty1PostHaircut, _that.getInitialMarginPostedByTheCounterparty1PostHaircut())) return false;
			if (!Objects.equals(initialMarginPostedByCounterparty1Currency, _that.getInitialMarginPostedByCounterparty1Currency())) return false;
			if (!Objects.equals(variationMarginPostedByTheCounterparty1PreHaircut, _that.getVariationMarginPostedByTheCounterparty1PreHaircut())) return false;
			if (!Objects.equals(variationMarginPostedByTheCounterparty1PostHaircut, _that.getVariationMarginPostedByTheCounterparty1PostHaircut())) return false;
			if (!Objects.equals(variationMarginPostedByCounterparty1Currency, _that.getVariationMarginPostedByCounterparty1Currency())) return false;
			if (!Objects.equals(initialMarginCollectedByCounterparty1PreHaircut, _that.getInitialMarginCollectedByCounterparty1PreHaircut())) return false;
			if (!Objects.equals(initialMarginCollectedByCounterparty1PostHaircut, _that.getInitialMarginCollectedByCounterparty1PostHaircut())) return false;
			if (!Objects.equals(initialMarginCollectedByCounterparty1Currency, _that.getInitialMarginCollectedByCounterparty1Currency())) return false;
			if (!Objects.equals(variationMarginCollectedByTheCounterparty1PreHaircut, _that.getVariationMarginCollectedByTheCounterparty1PreHaircut())) return false;
			if (!Objects.equals(variationMarginCollectedByTheCounterparty1PostHaircut, _that.getVariationMarginCollectedByTheCounterparty1PostHaircut())) return false;
			if (!Objects.equals(variationMarginCollectedByCounterparty1Currency, _that.getVariationMarginCollectedByCounterparty1Currency())) return false;
			if (!Objects.equals(excessCollateralPostedByTheCounterparty1, _that.getExcessCollateralPostedByTheCounterparty1())) return false;
			if (!Objects.equals(currencyOfTheExcessCollateralPosted, _that.getCurrencyOfTheExcessCollateralPosted())) return false;
			if (!Objects.equals(excessCollateralCollectedByTheCounterparty1, _that.getExcessCollateralCollectedByTheCounterparty1())) return false;
			if (!Objects.equals(currencyOfTheExcessCollateralCollected, _that.getCurrencyOfTheExcessCollateralCollected())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioCode != null ? collateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIndicator != null ? collateralPortfolioIndicator.hashCode() : 0);
			_result = 31 * _result + (uti != null ? uti.hashCode() : 0);
			_result = 31 * _result + (collateralisationCategory != null ? collateralisationCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (initialMarginPostedByTheCounterparty1PreHaircut != null ? initialMarginPostedByTheCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginPostedByTheCounterparty1PostHaircut != null ? initialMarginPostedByTheCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginPostedByCounterparty1Currency != null ? initialMarginPostedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (variationMarginPostedByTheCounterparty1PreHaircut != null ? variationMarginPostedByTheCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginPostedByTheCounterparty1PostHaircut != null ? variationMarginPostedByTheCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginPostedByCounterparty1Currency != null ? variationMarginPostedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (initialMarginCollectedByCounterparty1PreHaircut != null ? initialMarginCollectedByCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollectedByCounterparty1PostHaircut != null ? initialMarginCollectedByCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollectedByCounterparty1Currency != null ? initialMarginCollectedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (variationMarginCollectedByTheCounterparty1PreHaircut != null ? variationMarginCollectedByTheCounterparty1PreHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollectedByTheCounterparty1PostHaircut != null ? variationMarginCollectedByTheCounterparty1PostHaircut.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollectedByCounterparty1Currency != null ? variationMarginCollectedByCounterparty1Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (excessCollateralPostedByTheCounterparty1 != null ? excessCollateralPostedByTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (currencyOfTheExcessCollateralPosted != null ? currencyOfTheExcessCollateralPosted.hashCode() : 0);
			_result = 31 * _result + (excessCollateralCollectedByTheCounterparty1 != null ? excessCollateralCollectedByTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (currencyOfTheExcessCollateralCollected != null ? currencyOfTheExcessCollateralCollected.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElementBuilder {" +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"collateralPortfolioCode=" + this.collateralPortfolioCode + ", " +
				"collateralPortfolioIndicator=" + this.collateralPortfolioIndicator + ", " +
				"uti=" + this.uti + ", " +
				"collateralisationCategory=" + this.collateralisationCategory + ", " +
				"initialMarginPostedByTheCounterparty1PreHaircut=" + this.initialMarginPostedByTheCounterparty1PreHaircut + ", " +
				"initialMarginPostedByTheCounterparty1PostHaircut=" + this.initialMarginPostedByTheCounterparty1PostHaircut + ", " +
				"initialMarginPostedByCounterparty1Currency=" + this.initialMarginPostedByCounterparty1Currency + ", " +
				"variationMarginPostedByTheCounterparty1PreHaircut=" + this.variationMarginPostedByTheCounterparty1PreHaircut + ", " +
				"variationMarginPostedByTheCounterparty1PostHaircut=" + this.variationMarginPostedByTheCounterparty1PostHaircut + ", " +
				"variationMarginPostedByCounterparty1Currency=" + this.variationMarginPostedByCounterparty1Currency + ", " +
				"initialMarginCollectedByCounterparty1PreHaircut=" + this.initialMarginCollectedByCounterparty1PreHaircut + ", " +
				"initialMarginCollectedByCounterparty1PostHaircut=" + this.initialMarginCollectedByCounterparty1PostHaircut + ", " +
				"initialMarginCollectedByCounterparty1Currency=" + this.initialMarginCollectedByCounterparty1Currency + ", " +
				"variationMarginCollectedByTheCounterparty1PreHaircut=" + this.variationMarginCollectedByTheCounterparty1PreHaircut + ", " +
				"variationMarginCollectedByTheCounterparty1PostHaircut=" + this.variationMarginCollectedByTheCounterparty1PostHaircut + ", " +
				"variationMarginCollectedByCounterparty1Currency=" + this.variationMarginCollectedByCounterparty1Currency + ", " +
				"excessCollateralPostedByTheCounterparty1=" + this.excessCollateralPostedByTheCounterparty1 + ", " +
				"currencyOfTheExcessCollateralPosted=" + this.currencyOfTheExcessCollateralPosted + ", " +
				"excessCollateralCollectedByTheCounterparty1=" + this.excessCollateralCollectedByTheCounterparty1 + ", " +
				"currencyOfTheExcessCollateralCollected=" + this.currencyOfTheExcessCollateralCollected +
			'}';
		}
	}
}
