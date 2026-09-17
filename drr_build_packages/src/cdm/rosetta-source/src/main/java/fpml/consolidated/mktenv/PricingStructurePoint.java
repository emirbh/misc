package fpml.consolidated.mktenv;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.asset.PricingModel;
import fpml.consolidated.asset.QuoteTiming;
import fpml.consolidated.asset.ReportingCurrencyType;
import fpml.consolidated.fpmlenum.QuotationSideEnum;
import fpml.consolidated.mktenv.meta.PricingStructurePointMeta;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CashflowType;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.InformationSource;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A single valued point with a set of coordinates that define an arbitrary number of indentifying indexes (0 or more). Note that the collection of coordinates/coordinate references for a PricingStructurePoint must not define a given dimension (other than "generic") more than once. This is to avoid ambiguity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A single valued point with a set of coordinates that define an arbitrary number of indentifying indexes (0 or more). Note that the collection of coordinates/coordinate references for a PricingStructurePoint must not define a given dimension (other than "generic") more than once. This is to avoid ambiguity.
 *
 */
@RosettaDataType(value="PricingStructurePoint", builder=PricingStructurePoint.PricingStructurePointBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingStructurePoint", model="fpml", builder=PricingStructurePoint.PricingStructurePointBuilderImpl.class, version="2.1.1")
public interface PricingStructurePoint extends RosettaModelObject {

	PricingStructurePointMeta metaData = new PricingStructurePointMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends PricingStructurePointChoice> getPricingStructurePointChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Asset getUnderlyingAsset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to an underlying asset that defines the meaning of the value, i.e. the product that the value corresponds to. For example, this could be a caplet or simple european swaption.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to an underlying asset that defines the meaning of the value, i.e. the product that the value corresponds to. For example, this could be a caplet or simple european swaption.
	 *
	 */
	AssetReference getUnderlyingAssetReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value of the the quotation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value of the the quotation.
	 *
	 */
	BigDecimal getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of the value that is measured. This could be an NPV, a cash flow, a clean price, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the value that is measured. This could be an NPV, a cash flow, a clean price, etc.
	 *
	 */
	AssetMeasureType getMeasureType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The optional units that the measure is expressed in. If not supplied, this is assumed to be a price/value in currency units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The optional units that the measure is expressed in. If not supplied, this is assumed to be a price/value in currency units.
	 *
	 */
	PriceQuoteUnits getQuoteUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The side (bid/mid/ask) of the measure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The side (bid/mid/ask) of the measure.
	 *
	 */
	QuotationSideEnum getSide();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The optional currency that the measure is expressed in. If not supplied, this is defaulted from the reportingCurrency in the valuationScenarioDefinition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The optional currency that the measure is expressed in. If not supplied, this is defaulted from the reportingCurrency in the valuationScenarioDefinition.
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The optional currency that the measure is expressed in. If not supplied, this is defaulted from the reportingCurrency in the valuationScenarioDefinition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The optional currency that the measure is expressed in. If not supplied, this is defaulted from the reportingCurrency in the valuationScenarioDefinition.
	 *
	 */
	ReportingCurrencyType getCurrencyType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When during a day the quote is for. Typically, if this element is supplied, the QuoteLocation needs also to be supplied.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When during a day the quote is for. Typically, if this element is supplied, the QuoteLocation needs also to be supplied.
	 *
	 */
	QuoteTiming getTiming();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A city or other business center.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A city or other business center.
	 *
	 */
	BusinessCenter getBusinessCenter();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The exchange (e.g. stock or futures exchange) from which the quote is obtained.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The exchange (e.g. stock or futures exchange) from which the quote is obtained.
	 *
	 */
	ExchangeId getExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 */
	List<? extends InformationSource> getInformationSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision .
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision .
	 *
	 */
	PricingModel getPricingModel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When the quote was observed or when a calculated value was generated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When the quote was observed or when a calculated value was generated.
	 *
	 */
	ZonedDateTime getTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When the quote was computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When the quote was computed.
	 *
	 */
	ZonedDateTime getValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When does the quote cease to be valid.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When does the quote cease to be valid.
	 *
	 */
	ZonedDateTime getExpiryTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For cash flows, the type of the cash flows. Examples include: Coupon payment, Premium Fee, Settlement Fee, Brokerage Fee, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For cash flows, the type of the cash flows. Examples include: Coupon payment, Premium Fee, Settlement Fee, Brokerage Fee, etc.
	 *
	 */
	CashflowType getCashflowType();

	/*********************** Build Methods  ***********************/
	PricingStructurePoint build();
	
	PricingStructurePoint.PricingStructurePointBuilder toBuilder();
	
	static PricingStructurePoint.PricingStructurePointBuilder builder() {
		return new PricingStructurePoint.PricingStructurePointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructurePoint> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingStructurePoint> getType() {
		return PricingStructurePoint.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("pricingStructurePointChoice"), processor, PricingStructurePointChoice.class, getPricingStructurePointChoice());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("underlyingAssetReference"), processor, AssetReference.class, getUnderlyingAssetReference());
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("measureType"), processor, AssetMeasureType.class, getMeasureType());
		processRosetta(path.newSubPath("quoteUnits"), processor, PriceQuoteUnits.class, getQuoteUnits());
		processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("currencyType"), processor, ReportingCurrencyType.class, getCurrencyType());
		processRosetta(path.newSubPath("timing"), processor, QuoteTiming.class, getTiming());
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("pricingModel"), processor, PricingModel.class, getPricingModel());
		processor.processBasic(path.newSubPath("time"), ZonedDateTime.class, getTime(), this);
		processor.processBasic(path.newSubPath("valuationDate"), ZonedDateTime.class, getValuationDate(), this);
		processor.processBasic(path.newSubPath("expiryTime"), ZonedDateTime.class, getExpiryTime(), this);
		processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.class, getCashflowType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructurePointBuilder extends PricingStructurePoint, RosettaModelObjectBuilder {
		PricingStructurePointChoice.PricingStructurePointChoiceBuilder getOrCreatePricingStructurePointChoice(int index);
		@Override
		List<? extends PricingStructurePointChoice.PricingStructurePointChoiceBuilder> getPricingStructurePointChoice();
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		@Override
		Asset.AssetBuilder getUnderlyingAsset();
		AssetReference.AssetReferenceBuilder getOrCreateUnderlyingAssetReference();
		@Override
		AssetReference.AssetReferenceBuilder getUnderlyingAssetReference();
		AssetMeasureType.AssetMeasureTypeBuilder getOrCreateMeasureType();
		@Override
		AssetMeasureType.AssetMeasureTypeBuilder getMeasureType();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateQuoteUnits();
		@Override
		PriceQuoteUnits.PriceQuoteUnitsBuilder getQuoteUnits();
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		ReportingCurrencyType.ReportingCurrencyTypeBuilder getOrCreateCurrencyType();
		@Override
		ReportingCurrencyType.ReportingCurrencyTypeBuilder getCurrencyType();
		QuoteTiming.QuoteTimingBuilder getOrCreateTiming();
		@Override
		QuoteTiming.QuoteTimingBuilder getTiming();
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter();
		@Override
		BusinessCenter.BusinessCenterBuilder getBusinessCenter();
		ExchangeId.ExchangeIdBuilder getOrCreateExchangeId();
		@Override
		ExchangeId.ExchangeIdBuilder getExchangeId();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index);
		@Override
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		PricingModel.PricingModelBuilder getOrCreatePricingModel();
		@Override
		PricingModel.PricingModelBuilder getPricingModel();
		CashflowType.CashflowTypeBuilder getOrCreateCashflowType();
		@Override
		CashflowType.CashflowTypeBuilder getCashflowType();
		PricingStructurePoint.PricingStructurePointBuilder setId(String id);
		PricingStructurePoint.PricingStructurePointBuilder addPricingStructurePointChoice(PricingStructurePointChoice pricingStructurePointChoice);
		PricingStructurePoint.PricingStructurePointBuilder addPricingStructurePointChoice(PricingStructurePointChoice pricingStructurePointChoice, int idx);
		PricingStructurePoint.PricingStructurePointBuilder addPricingStructurePointChoice(List<? extends PricingStructurePointChoice> pricingStructurePointChoice);
		PricingStructurePoint.PricingStructurePointBuilder setPricingStructurePointChoice(List<? extends PricingStructurePointChoice> pricingStructurePointChoice);
		PricingStructurePoint.PricingStructurePointBuilder setUnderlyingAsset(Asset underlyingAsset);
		PricingStructurePoint.PricingStructurePointBuilder setUnderlyingAssetReference(AssetReference underlyingAssetReference);
		PricingStructurePoint.PricingStructurePointBuilder setValue(BigDecimal value);
		PricingStructurePoint.PricingStructurePointBuilder setMeasureType(AssetMeasureType measureType);
		PricingStructurePoint.PricingStructurePointBuilder setQuoteUnits(PriceQuoteUnits quoteUnits);
		PricingStructurePoint.PricingStructurePointBuilder setSide(QuotationSideEnum side);
		PricingStructurePoint.PricingStructurePointBuilder setCurrency(Currency currency);
		PricingStructurePoint.PricingStructurePointBuilder setCurrencyType(ReportingCurrencyType currencyType);
		PricingStructurePoint.PricingStructurePointBuilder setTiming(QuoteTiming timing);
		PricingStructurePoint.PricingStructurePointBuilder setBusinessCenter(BusinessCenter businessCenter);
		PricingStructurePoint.PricingStructurePointBuilder setExchangeId(ExchangeId exchangeId);
		PricingStructurePoint.PricingStructurePointBuilder addInformationSource(InformationSource informationSource);
		PricingStructurePoint.PricingStructurePointBuilder addInformationSource(InformationSource informationSource, int idx);
		PricingStructurePoint.PricingStructurePointBuilder addInformationSource(List<? extends InformationSource> informationSource);
		PricingStructurePoint.PricingStructurePointBuilder setInformationSource(List<? extends InformationSource> informationSource);
		PricingStructurePoint.PricingStructurePointBuilder setPricingModel(PricingModel pricingModel);
		PricingStructurePoint.PricingStructurePointBuilder setTime(ZonedDateTime time);
		PricingStructurePoint.PricingStructurePointBuilder setValuationDate(ZonedDateTime valuationDate);
		PricingStructurePoint.PricingStructurePointBuilder setExpiryTime(ZonedDateTime expiryTime);
		PricingStructurePoint.PricingStructurePointBuilder setCashflowType(CashflowType cashflowType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("pricingStructurePointChoice"), processor, PricingStructurePointChoice.PricingStructurePointChoiceBuilder.class, getPricingStructurePointChoice());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("underlyingAssetReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyingAssetReference());
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("measureType"), processor, AssetMeasureType.AssetMeasureTypeBuilder.class, getMeasureType());
			processRosetta(path.newSubPath("quoteUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getQuoteUnits());
			processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("currencyType"), processor, ReportingCurrencyType.ReportingCurrencyTypeBuilder.class, getCurrencyType());
			processRosetta(path.newSubPath("timing"), processor, QuoteTiming.QuoteTimingBuilder.class, getTiming());
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("pricingModel"), processor, PricingModel.PricingModelBuilder.class, getPricingModel());
			processor.processBasic(path.newSubPath("time"), ZonedDateTime.class, getTime(), this);
			processor.processBasic(path.newSubPath("valuationDate"), ZonedDateTime.class, getValuationDate(), this);
			processor.processBasic(path.newSubPath("expiryTime"), ZonedDateTime.class, getExpiryTime(), this);
			processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.CashflowTypeBuilder.class, getCashflowType());
		}
		

		PricingStructurePoint.PricingStructurePointBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructurePoint  ***********************/
	class PricingStructurePointImpl implements PricingStructurePoint {
		private final String id;
		private final List<? extends PricingStructurePointChoice> pricingStructurePointChoice;
		private final Asset underlyingAsset;
		private final AssetReference underlyingAssetReference;
		private final BigDecimal value;
		private final AssetMeasureType measureType;
		private final PriceQuoteUnits quoteUnits;
		private final QuotationSideEnum side;
		private final Currency currency;
		private final ReportingCurrencyType currencyType;
		private final QuoteTiming timing;
		private final BusinessCenter businessCenter;
		private final ExchangeId exchangeId;
		private final List<? extends InformationSource> informationSource;
		private final PricingModel pricingModel;
		private final ZonedDateTime time;
		private final ZonedDateTime valuationDate;
		private final ZonedDateTime expiryTime;
		private final CashflowType cashflowType;
		
		protected PricingStructurePointImpl(PricingStructurePoint.PricingStructurePointBuilder builder) {
			this.id = builder.getId();
			this.pricingStructurePointChoice = ofNullable(builder.getPricingStructurePointChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.underlyingAssetReference = ofNullable(builder.getUnderlyingAssetReference()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
			this.measureType = ofNullable(builder.getMeasureType()).map(f->f.build()).orElse(null);
			this.quoteUnits = ofNullable(builder.getQuoteUnits()).map(f->f.build()).orElse(null);
			this.side = builder.getSide();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.currencyType = ofNullable(builder.getCurrencyType()).map(f->f.build()).orElse(null);
			this.timing = ofNullable(builder.getTiming()).map(f->f.build()).orElse(null);
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.pricingModel = ofNullable(builder.getPricingModel()).map(f->f.build()).orElse(null);
			this.time = builder.getTime();
			this.valuationDate = builder.getValuationDate();
			this.expiryTime = builder.getExpiryTime();
			this.cashflowType = ofNullable(builder.getCashflowType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("pricingStructurePointChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingStructurePointChoice")
		public List<? extends PricingStructurePointChoice> getPricingStructurePointChoice() {
			return pricingStructurePointChoice;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetReference")
		public AssetReference getUnderlyingAssetReference() {
			return underlyingAssetReference;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("measureType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("measureType")
		public AssetMeasureType getMeasureType() {
			return measureType;
		}
		
		@Override
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quoteUnits")
		public PriceQuoteUnits getQuoteUnits() {
			return quoteUnits;
		}
		
		@Override
		@RosettaAttribute("side")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("side")
		public QuotationSideEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("currencyType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyType")
		public ReportingCurrencyType getCurrencyType() {
			return currencyType;
		}
		
		@Override
		@RosettaAttribute("timing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timing")
		public QuoteTiming getTiming() {
			return timing;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenter")
		public BusinessCenter getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeId")
		public ExchangeId getExchangeId() {
			return exchangeId;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("pricingModel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingModel")
		public PricingModel getPricingModel() {
			return pricingModel;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public ZonedDateTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public ZonedDateTime getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public ZonedDateTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowType")
		public CashflowType getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public PricingStructurePoint build() {
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder toBuilder() {
			PricingStructurePoint.PricingStructurePointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructurePoint.PricingStructurePointBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPricingStructurePointChoice()).ifPresent(builder::setPricingStructurePointChoice);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getUnderlyingAssetReference()).ifPresent(builder::setUnderlyingAssetReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeasureType()).ifPresent(builder::setMeasureType);
			ofNullable(getQuoteUnits()).ifPresent(builder::setQuoteUnits);
			ofNullable(getSide()).ifPresent(builder::setSide);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getCurrencyType()).ifPresent(builder::setCurrencyType);
			ofNullable(getTiming()).ifPresent(builder::setTiming);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getPricingModel()).ifPresent(builder::setPricingModel);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructurePoint _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(pricingStructurePointChoice, _that.getPricingStructurePointChoice())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(underlyingAssetReference, _that.getUnderlyingAssetReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(measureType, _that.getMeasureType())) return false;
			if (!Objects.equals(quoteUnits, _that.getQuoteUnits())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(currencyType, _that.getCurrencyType())) return false;
			if (!Objects.equals(timing, _that.getTiming())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(pricingModel, _that.getPricingModel())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (pricingStructurePointChoice != null ? pricingStructurePointChoice.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetReference != null ? underlyingAssetReference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (measureType != null ? measureType.hashCode() : 0);
			_result = 31 * _result + (quoteUnits != null ? quoteUnits.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (currencyType != null ? currencyType.hashCode() : 0);
			_result = 31 * _result + (timing != null ? timing.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (pricingModel != null ? pricingModel.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructurePoint {" +
				"id=" + this.id + ", " +
				"pricingStructurePointChoice=" + this.pricingStructurePointChoice + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"underlyingAssetReference=" + this.underlyingAssetReference + ", " +
				"value=" + this.value + ", " +
				"measureType=" + this.measureType + ", " +
				"quoteUnits=" + this.quoteUnits + ", " +
				"side=" + this.side + ", " +
				"currency=" + this.currency + ", " +
				"currencyType=" + this.currencyType + ", " +
				"timing=" + this.timing + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"informationSource=" + this.informationSource + ", " +
				"pricingModel=" + this.pricingModel + ", " +
				"time=" + this.time + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingStructurePoint  ***********************/
	class PricingStructurePointBuilderImpl implements PricingStructurePoint.PricingStructurePointBuilder {
	
		protected String id;
		protected List<PricingStructurePointChoice.PricingStructurePointChoiceBuilder> pricingStructurePointChoice = new ArrayList<>();
		protected Asset.AssetBuilder underlyingAsset;
		protected AssetReference.AssetReferenceBuilder underlyingAssetReference;
		protected BigDecimal value;
		protected AssetMeasureType.AssetMeasureTypeBuilder measureType;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder quoteUnits;
		protected QuotationSideEnum side;
		protected Currency.CurrencyBuilder currency;
		protected ReportingCurrencyType.ReportingCurrencyTypeBuilder currencyType;
		protected QuoteTiming.QuoteTimingBuilder timing;
		protected BusinessCenter.BusinessCenterBuilder businessCenter;
		protected ExchangeId.ExchangeIdBuilder exchangeId;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected PricingModel.PricingModelBuilder pricingModel;
		protected ZonedDateTime time;
		protected ZonedDateTime valuationDate;
		protected ZonedDateTime expiryTime;
		protected CashflowType.CashflowTypeBuilder cashflowType;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("pricingStructurePointChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingStructurePointChoice")
		public List<? extends PricingStructurePointChoice.PricingStructurePointChoiceBuilder> getPricingStructurePointChoice() {
			return pricingStructurePointChoice;
		}
		
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder getOrCreatePricingStructurePointChoice(int index) {
			if (pricingStructurePointChoice==null) {
				this.pricingStructurePointChoice = new ArrayList<>();
			}
			return getIndex(pricingStructurePointChoice, index, () -> {
						PricingStructurePointChoice.PricingStructurePointChoiceBuilder newPricingStructurePointChoice = PricingStructurePointChoice.builder();
						return newPricingStructurePointChoice;
					});
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetReference")
		public AssetReference.AssetReferenceBuilder getUnderlyingAssetReference() {
			return underlyingAssetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateUnderlyingAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (underlyingAssetReference!=null) {
				result = underlyingAssetReference;
			}
			else {
				result = underlyingAssetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("measureType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("measureType")
		public AssetMeasureType.AssetMeasureTypeBuilder getMeasureType() {
			return measureType;
		}
		
		@Override
		public AssetMeasureType.AssetMeasureTypeBuilder getOrCreateMeasureType() {
			AssetMeasureType.AssetMeasureTypeBuilder result;
			if (measureType!=null) {
				result = measureType;
			}
			else {
				result = measureType = AssetMeasureType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quoteUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getQuoteUnits() {
			return quoteUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateQuoteUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (quoteUnits!=null) {
				result = quoteUnits;
			}
			else {
				result = quoteUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("side")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("side")
		public QuotationSideEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyType")
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder getCurrencyType() {
			return currencyType;
		}
		
		@Override
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder getOrCreateCurrencyType() {
			ReportingCurrencyType.ReportingCurrencyTypeBuilder result;
			if (currencyType!=null) {
				result = currencyType;
			}
			else {
				result = currencyType = ReportingCurrencyType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timing")
		public QuoteTiming.QuoteTimingBuilder getTiming() {
			return timing;
		}
		
		@Override
		public QuoteTiming.QuoteTimingBuilder getOrCreateTiming() {
			QuoteTiming.QuoteTimingBuilder result;
			if (timing!=null) {
				result = timing;
			}
			else {
				result = timing = QuoteTiming.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenter")
		public BusinessCenter.BusinessCenterBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeId")
		public ExchangeId.ExchangeIdBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateExchangeId() {
			ExchangeId.ExchangeIdBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = ExchangeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index) {
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			return getIndex(informationSource, index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@Override
		@RosettaAttribute("pricingModel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingModel")
		public PricingModel.PricingModelBuilder getPricingModel() {
			return pricingModel;
		}
		
		@Override
		public PricingModel.PricingModelBuilder getOrCreatePricingModel() {
			PricingModel.PricingModelBuilder result;
			if (pricingModel!=null) {
				result = pricingModel;
			}
			else {
				result = pricingModel = PricingModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public ZonedDateTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public ZonedDateTime getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public ZonedDateTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowType")
		public CashflowType.CashflowTypeBuilder getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder getOrCreateCashflowType() {
			CashflowType.CashflowTypeBuilder result;
			if (cashflowType!=null) {
				result = cashflowType;
			}
			else {
				result = cashflowType = CashflowType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("pricingStructurePointChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("pricingStructurePointChoice")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addPricingStructurePointChoice(PricingStructurePointChoice _pricingStructurePointChoice) {
			if (_pricingStructurePointChoice != null) {
				this.pricingStructurePointChoice.add(_pricingStructurePointChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addPricingStructurePointChoice(PricingStructurePointChoice _pricingStructurePointChoice, int idx) {
			getIndex(this.pricingStructurePointChoice, idx, () -> _pricingStructurePointChoice.toBuilder());
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addPricingStructurePointChoice(List<? extends PricingStructurePointChoice> pricingStructurePointChoices) {
			if (pricingStructurePointChoices != null) {
				for (final PricingStructurePointChoice toAdd : pricingStructurePointChoices) {
					this.pricingStructurePointChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("pricingStructurePointChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("pricingStructurePointChoice")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setPricingStructurePointChoice(List<? extends PricingStructurePointChoice> pricingStructurePointChoices) {
			if (pricingStructurePointChoices == null) {
				this.pricingStructurePointChoice = new ArrayList<>();
			} else {
				this.pricingStructurePointChoice = pricingStructurePointChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAsset")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setUnderlyingAsset(Asset _underlyingAsset) {
			this.underlyingAsset = _underlyingAsset == null ? null : _underlyingAsset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAssetReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetReference")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setUnderlyingAssetReference(AssetReference _underlyingAssetReference) {
			this.underlyingAssetReference = _underlyingAssetReference == null ? null : _underlyingAssetReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("measureType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("measureType")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setMeasureType(AssetMeasureType _measureType) {
			this.measureType = _measureType == null ? null : _measureType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteUnits")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setQuoteUnits(PriceQuoteUnits _quoteUnits) {
			this.quoteUnits = _quoteUnits == null ? null : _quoteUnits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("side")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("side")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setSide(QuotationSideEnum _side) {
			this.side = _side == null ? null : _side;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currencyType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyType")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setCurrencyType(ReportingCurrencyType _currencyType) {
			this.currencyType = _currencyType == null ? null : _currencyType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("timing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timing")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setTiming(QuoteTiming _timing) {
			this.timing = _timing == null ? null : _timing.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenter")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setBusinessCenter(BusinessCenter _businessCenter) {
			this.businessCenter = _businessCenter == null ? null : _businessCenter.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addInformationSource(InformationSource _informationSource) {
			if (_informationSource != null) {
				this.informationSource.add(_informationSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addInformationSource(InformationSource _informationSource, int idx) {
			getIndex(this.informationSource, idx, () -> _informationSource.toBuilder());
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (final InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null) {
				this.informationSource = new ArrayList<>();
			} else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("pricingModel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingModel")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setPricingModel(PricingModel _pricingModel) {
			this.pricingModel = _pricingModel == null ? null : _pricingModel.toBuilder();
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setTime(ZonedDateTime _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setValuationDate(ZonedDateTime _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate;
			return this;
		}
		
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTime")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setExpiryTime(ZonedDateTime _expiryTime) {
			this.expiryTime = _expiryTime == null ? null : _expiryTime;
			return this;
		}
		
		@RosettaAttribute("cashflowType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflowType")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder setCashflowType(CashflowType _cashflowType) {
			this.cashflowType = _cashflowType == null ? null : _cashflowType.toBuilder();
			return this;
		}
		
		@Override
		public PricingStructurePoint build() {
			return new PricingStructurePoint.PricingStructurePointImpl(this);
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder prune() {
			pricingStructurePointChoice = pricingStructurePointChoice.stream().filter(b->b!=null).<PricingStructurePointChoice.PricingStructurePointChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (underlyingAssetReference!=null && !underlyingAssetReference.prune().hasData()) underlyingAssetReference = null;
			if (measureType!=null && !measureType.prune().hasData()) measureType = null;
			if (quoteUnits!=null && !quoteUnits.prune().hasData()) quoteUnits = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (currencyType!=null && !currencyType.prune().hasData()) currencyType = null;
			if (timing!=null && !timing.prune().hasData()) timing = null;
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (pricingModel!=null && !pricingModel.prune().hasData()) pricingModel = null;
			if (cashflowType!=null && !cashflowType.prune().hasData()) cashflowType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPricingStructurePointChoice()!=null && getPricingStructurePointChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getUnderlyingAssetReference()!=null && getUnderlyingAssetReference().hasData()) return true;
			if (getValue()!=null) return true;
			if (getMeasureType()!=null && getMeasureType().hasData()) return true;
			if (getQuoteUnits()!=null && getQuoteUnits().hasData()) return true;
			if (getSide()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getCurrencyType()!=null && getCurrencyType().hasData()) return true;
			if (getTiming()!=null && getTiming().hasData()) return true;
			if (getBusinessCenter()!=null && getBusinessCenter().hasData()) return true;
			if (getExchangeId()!=null && getExchangeId().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPricingModel()!=null && getPricingModel().hasData()) return true;
			if (getTime()!=null) return true;
			if (getValuationDate()!=null) return true;
			if (getExpiryTime()!=null) return true;
			if (getCashflowType()!=null && getCashflowType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingStructurePoint.PricingStructurePointBuilder o = (PricingStructurePoint.PricingStructurePointBuilder) other;
			
			merger.mergeRosetta(getPricingStructurePointChoice(), o.getPricingStructurePointChoice(), this::getOrCreatePricingStructurePointChoice);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getUnderlyingAssetReference(), o.getUnderlyingAssetReference(), this::setUnderlyingAssetReference);
			merger.mergeRosetta(getMeasureType(), o.getMeasureType(), this::setMeasureType);
			merger.mergeRosetta(getQuoteUnits(), o.getQuoteUnits(), this::setQuoteUnits);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getCurrencyType(), o.getCurrencyType(), this::setCurrencyType);
			merger.mergeRosetta(getTiming(), o.getTiming(), this::setTiming);
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			merger.mergeRosetta(getPricingModel(), o.getPricingModel(), this::setPricingModel);
			merger.mergeRosetta(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSide(), o.getSide(), this::setSide);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			merger.mergeBasic(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeBasic(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructurePoint _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(pricingStructurePointChoice, _that.getPricingStructurePointChoice())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(underlyingAssetReference, _that.getUnderlyingAssetReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(measureType, _that.getMeasureType())) return false;
			if (!Objects.equals(quoteUnits, _that.getQuoteUnits())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(currencyType, _that.getCurrencyType())) return false;
			if (!Objects.equals(timing, _that.getTiming())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(pricingModel, _that.getPricingModel())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (pricingStructurePointChoice != null ? pricingStructurePointChoice.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetReference != null ? underlyingAssetReference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (measureType != null ? measureType.hashCode() : 0);
			_result = 31 * _result + (quoteUnits != null ? quoteUnits.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (currencyType != null ? currencyType.hashCode() : 0);
			_result = 31 * _result + (timing != null ? timing.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (pricingModel != null ? pricingModel.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructurePointBuilder {" +
				"id=" + this.id + ", " +
				"pricingStructurePointChoice=" + this.pricingStructurePointChoice + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"underlyingAssetReference=" + this.underlyingAssetReference + ", " +
				"value=" + this.value + ", " +
				"measureType=" + this.measureType + ", " +
				"quoteUnits=" + this.quoteUnits + ", " +
				"side=" + this.side + ", " +
				"currency=" + this.currency + ", " +
				"currencyType=" + this.currencyType + ", " +
				"timing=" + this.timing + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"informationSource=" + this.informationSource + ", " +
				"pricingModel=" + this.pricingModel + ", " +
				"time=" + this.time + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}
}
