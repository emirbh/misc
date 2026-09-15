package fpml.consolidated.com;

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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.com.meta.CommodityMarketDisruptionMeta;
import fpml.consolidated.fpmlenum.DisruptionFallbacksEnum;
import fpml.consolidated.fpmlenum.MarketDisruptionEventsEnum;
import java.math.BigDecimal;
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
 * Provision ISDA 1993 or 2005 commodity market disruption elements.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision ISDA 1993 or 2005 commodity market disruption elements.
 *
 */
@RosettaDataType(value="CommodityMarketDisruption", builder=CommodityMarketDisruption.CommodityMarketDisruptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityMarketDisruption", model="fpml", builder=CommodityMarketDisruption.CommodityMarketDisruptionBuilderImpl.class, version="2.1.1")
public interface CommodityMarketDisruption extends RosettaModelObject {

	CommodityMarketDisruptionMeta metaData = new CommodityMarketDisruptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If Market disruption Events are stated to be Applicable then the default Market Disruption Events of Section 7.4(d)(i) of the ISDA Commodity Definitions shall apply unless specific Market Disruption Events are stated hereunder, in which case these shall override the ISDA defaults. If Market Disruption Events are stated to be Not Applicable, Market Disruption Events are not applicable to the trade at all. It is also possible to reference the Market Disruption Events set out in the relevant Master Agreement governing the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If Market disruption Events are stated to be Applicable then the default Market Disruption Events of Section 7.4(d)(i) of the ISDA Commodity Definitions shall apply unless specific Market Disruption Events are stated hereunder, in which case these shall override the ISDA defaults. If Market Disruption Events are stated to be Not Applicable, Market Disruption Events are not applicable to the trade at all. It is also possible to reference the Market Disruption Events set out in the relevant Master Agreement governing the trade.
	 *
	 */
	MarketDisruptionEventsEnum getMarketDisruptionEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision To be used when marketDisruptionEvents is set to "Applicable" and additional market disruption events(s) apply to the default market disruption events of Section 7.4(d)(i) of the ISDA Commodity Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision To be used when marketDisruptionEvents is set to "Applicable" and additional market disruption events(s) apply to the default market disruption events of Section 7.4(d)(i) of the ISDA Commodity Definitions.
	 *
	 */
	List<? extends MarketDisruptionEvent> getAdditionalMarketDisruptionEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Market disruption event(s) that apply. Note that these should only be specified if the default market disruption events of Section 7.4(d)(i) of the ISDA Commodity Definitions are to be overridden.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Market disruption event(s) that apply. Note that these should only be specified if the default market disruption events of Section 7.4(d)(i) of the ISDA Commodity Definitions are to be overridden.
	 *
	 */
	List<? extends MarketDisruptionEvent> getMarketDisruptionEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision To be used where disruption fallbacks are set out in the relevant Master Agreement governing the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision To be used where disruption fallbacks are set out in the relevant Master Agreement governing the trade.
	 *
	 */
	DisruptionFallbacksEnum getDisruptionFallbacks();
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
	List<? extends SequencedDisruptionFallback> getDisruptionFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fallback commodity reference price for use when relying on Disruption Fallbacks in Section 7.5(d)(i) of the ISDA Commodity Definitions or have selected "Fallback Reference Price" as a disruptionFallback.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fallback commodity reference price for use when relying on Disruption Fallbacks in Section 7.5(d)(i) of the ISDA Commodity Definitions or have selected "Fallback Reference Price" as a disruptionFallback.
	 *
	 */
	Underlyer getFallbackReferencePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 2005 Commodity Definitions only. If omitted , the number of days specified in Section 7.6(a) of the Definitions will apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 2005 Commodity Definitions only. If omitted , the number of days specified in Section 7.6(a) of the Definitions will apply.
	 *
	 */
	Integer getMaximumNumberOfDaysOfDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 2005 Commodity Definitions only. To be used where a price materiality percentage applies to the "Price Source Disruption" event and this event has been specified by setting marketDisruption to true or including it in additionalMarketDisruptionEvent. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 2005 Commodity Definitions only. To be used where a price materiality percentage applies to the "Price Source Disruption" event and this event has been specified by setting marketDisruption to true or including it in additionalMarketDisruptionEvent. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getPriceMaterialityPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 1993 Commodity Definitions only. Specifies the Mimum Futures Contracts level that dictates whether or not a "De Minimis Trading" event has occurred. Only relevant if 'De Minimis Trading' has been specified in marketDisruptionEvent or additionalMarketDisruptionEvent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 1993 Commodity Definitions only. Specifies the Mimum Futures Contracts level that dictates whether or not a "De Minimis Trading" event has occurred. Only relevant if 'De Minimis Trading' has been specified in marketDisruptionEvent or additionalMarketDisruptionEvent.
	 *
	 */
	Integer getMinimumFuturesContracts();

	/*********************** Build Methods  ***********************/
	CommodityMarketDisruption build();
	
	CommodityMarketDisruption.CommodityMarketDisruptionBuilder toBuilder();
	
	static CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder() {
		return new CommodityMarketDisruption.CommodityMarketDisruptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMarketDisruption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityMarketDisruption> getType() {
		return CommodityMarketDisruption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marketDisruptionEvents"), MarketDisruptionEventsEnum.class, getMarketDisruptionEvents(), this);
		processRosetta(path.newSubPath("additionalMarketDisruptionEvent"), processor, MarketDisruptionEvent.class, getAdditionalMarketDisruptionEvent());
		processRosetta(path.newSubPath("marketDisruptionEvent"), processor, MarketDisruptionEvent.class, getMarketDisruptionEvent());
		processor.processBasic(path.newSubPath("disruptionFallbacks"), DisruptionFallbacksEnum.class, getDisruptionFallbacks(), this);
		processRosetta(path.newSubPath("disruptionFallback"), processor, SequencedDisruptionFallback.class, getDisruptionFallback());
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, Underlyer.class, getFallbackReferencePrice());
		processor.processBasic(path.newSubPath("maximumNumberOfDaysOfDisruption"), Integer.class, getMaximumNumberOfDaysOfDisruption(), this);
		processor.processBasic(path.newSubPath("priceMaterialityPercentage"), BigDecimal.class, getPriceMaterialityPercentage(), this);
		processor.processBasic(path.newSubPath("minimumFuturesContracts"), Integer.class, getMinimumFuturesContracts(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMarketDisruptionBuilder extends CommodityMarketDisruption, RosettaModelObjectBuilder {
		MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateAdditionalMarketDisruptionEvent(int index);
		@Override
		List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getAdditionalMarketDisruptionEvent();
		MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateMarketDisruptionEvent(int index);
		@Override
		List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getMarketDisruptionEvent();
		SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder getOrCreateDisruptionFallback(int index);
		@Override
		List<? extends SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder> getDisruptionFallback();
		Underlyer.UnderlyerBuilder getOrCreateFallbackReferencePrice();
		@Override
		Underlyer.UnderlyerBuilder getFallbackReferencePrice();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMarketDisruptionEvents(MarketDisruptionEventsEnum marketDisruptionEvents);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent additionalMarketDisruptionEvent);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent additionalMarketDisruptionEvent, int idx);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvent);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvent);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent marketDisruptionEvent);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent marketDisruptionEvent, int idx);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(List<? extends MarketDisruptionEvent> marketDisruptionEvent);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMarketDisruptionEvent(List<? extends MarketDisruptionEvent> marketDisruptionEvent);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallbacks(DisruptionFallbacksEnum disruptionFallbacks);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback disruptionFallback);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback disruptionFallback, int idx);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(List<? extends SequencedDisruptionFallback> disruptionFallback);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallback(List<? extends SequencedDisruptionFallback> disruptionFallback);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setFallbackReferencePrice(Underlyer fallbackReferencePrice);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMaximumNumberOfDaysOfDisruption(Integer maximumNumberOfDaysOfDisruption);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setPriceMaterialityPercentage(BigDecimal priceMaterialityPercentage);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMinimumFuturesContracts(Integer minimumFuturesContracts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("marketDisruptionEvents"), MarketDisruptionEventsEnum.class, getMarketDisruptionEvents(), this);
			processRosetta(path.newSubPath("additionalMarketDisruptionEvent"), processor, MarketDisruptionEvent.MarketDisruptionEventBuilder.class, getAdditionalMarketDisruptionEvent());
			processRosetta(path.newSubPath("marketDisruptionEvent"), processor, MarketDisruptionEvent.MarketDisruptionEventBuilder.class, getMarketDisruptionEvent());
			processor.processBasic(path.newSubPath("disruptionFallbacks"), DisruptionFallbacksEnum.class, getDisruptionFallbacks(), this);
			processRosetta(path.newSubPath("disruptionFallback"), processor, SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder.class, getDisruptionFallback());
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, Underlyer.UnderlyerBuilder.class, getFallbackReferencePrice());
			processor.processBasic(path.newSubPath("maximumNumberOfDaysOfDisruption"), Integer.class, getMaximumNumberOfDaysOfDisruption(), this);
			processor.processBasic(path.newSubPath("priceMaterialityPercentage"), BigDecimal.class, getPriceMaterialityPercentage(), this);
			processor.processBasic(path.newSubPath("minimumFuturesContracts"), Integer.class, getMinimumFuturesContracts(), this);
		}
		

		CommodityMarketDisruption.CommodityMarketDisruptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMarketDisruption  ***********************/
	class CommodityMarketDisruptionImpl implements CommodityMarketDisruption {
		private final MarketDisruptionEventsEnum marketDisruptionEvents;
		private final List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvent;
		private final List<? extends MarketDisruptionEvent> marketDisruptionEvent;
		private final DisruptionFallbacksEnum disruptionFallbacks;
		private final List<? extends SequencedDisruptionFallback> disruptionFallback;
		private final Underlyer fallbackReferencePrice;
		private final Integer maximumNumberOfDaysOfDisruption;
		private final BigDecimal priceMaterialityPercentage;
		private final Integer minimumFuturesContracts;
		
		protected CommodityMarketDisruptionImpl(CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder) {
			this.marketDisruptionEvents = builder.getMarketDisruptionEvents();
			this.additionalMarketDisruptionEvent = ofNullable(builder.getAdditionalMarketDisruptionEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.marketDisruptionEvent = ofNullable(builder.getMarketDisruptionEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.disruptionFallbacks = builder.getDisruptionFallbacks();
			this.disruptionFallback = ofNullable(builder.getDisruptionFallback()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
			this.maximumNumberOfDaysOfDisruption = builder.getMaximumNumberOfDaysOfDisruption();
			this.priceMaterialityPercentage = builder.getPriceMaterialityPercentage();
			this.minimumFuturesContracts = builder.getMinimumFuturesContracts();
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruptionEvents")
		public MarketDisruptionEventsEnum getMarketDisruptionEvents() {
			return marketDisruptionEvents;
		}
		
		@Override
		@RosettaAttribute("additionalMarketDisruptionEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalMarketDisruptionEvent")
		public List<? extends MarketDisruptionEvent> getAdditionalMarketDisruptionEvent() {
			return additionalMarketDisruptionEvent;
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("marketDisruptionEvent")
		public List<? extends MarketDisruptionEvent> getMarketDisruptionEvent() {
			return marketDisruptionEvent;
		}
		
		@Override
		@RosettaAttribute("disruptionFallbacks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disruptionFallbacks")
		public DisruptionFallbacksEnum getDisruptionFallbacks() {
			return disruptionFallbacks;
		}
		
		@Override
		@RosettaAttribute("disruptionFallback")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("disruptionFallback")
		public List<? extends SequencedDisruptionFallback> getDisruptionFallback() {
			return disruptionFallback;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public Underlyer getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNumberOfDaysOfDisruption")
		public Integer getMaximumNumberOfDaysOfDisruption() {
			return maximumNumberOfDaysOfDisruption;
		}
		
		@Override
		@RosettaAttribute("priceMaterialityPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceMaterialityPercentage")
		public BigDecimal getPriceMaterialityPercentage() {
			return priceMaterialityPercentage;
		}
		
		@Override
		@RosettaAttribute("minimumFuturesContracts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumFuturesContracts")
		public Integer getMinimumFuturesContracts() {
			return minimumFuturesContracts;
		}
		
		@Override
		public CommodityMarketDisruption build() {
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder toBuilder() {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder) {
			ofNullable(getMarketDisruptionEvents()).ifPresent(builder::setMarketDisruptionEvents);
			ofNullable(getAdditionalMarketDisruptionEvent()).ifPresent(builder::setAdditionalMarketDisruptionEvent);
			ofNullable(getMarketDisruptionEvent()).ifPresent(builder::setMarketDisruptionEvent);
			ofNullable(getDisruptionFallbacks()).ifPresent(builder::setDisruptionFallbacks);
			ofNullable(getDisruptionFallback()).ifPresent(builder::setDisruptionFallback);
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
			ofNullable(getMaximumNumberOfDaysOfDisruption()).ifPresent(builder::setMaximumNumberOfDaysOfDisruption);
			ofNullable(getPriceMaterialityPercentage()).ifPresent(builder::setPriceMaterialityPercentage);
			ofNullable(getMinimumFuturesContracts()).ifPresent(builder::setMinimumFuturesContracts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMarketDisruption _that = getType().cast(o);
		
			if (!Objects.equals(marketDisruptionEvents, _that.getMarketDisruptionEvents())) return false;
			if (!ListEquals.listEquals(additionalMarketDisruptionEvent, _that.getAdditionalMarketDisruptionEvent())) return false;
			if (!ListEquals.listEquals(marketDisruptionEvent, _that.getMarketDisruptionEvent())) return false;
			if (!Objects.equals(disruptionFallbacks, _that.getDisruptionFallbacks())) return false;
			if (!ListEquals.listEquals(disruptionFallback, _that.getDisruptionFallback())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(maximumNumberOfDaysOfDisruption, _that.getMaximumNumberOfDaysOfDisruption())) return false;
			if (!Objects.equals(priceMaterialityPercentage, _that.getPriceMaterialityPercentage())) return false;
			if (!Objects.equals(minimumFuturesContracts, _that.getMinimumFuturesContracts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marketDisruptionEvents != null ? marketDisruptionEvents.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalMarketDisruptionEvent != null ? additionalMarketDisruptionEvent.hashCode() : 0);
			_result = 31 * _result + (marketDisruptionEvent != null ? marketDisruptionEvent.hashCode() : 0);
			_result = 31 * _result + (disruptionFallbacks != null ? disruptionFallbacks.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (disruptionFallback != null ? disruptionFallback.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfDaysOfDisruption != null ? maximumNumberOfDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (priceMaterialityPercentage != null ? priceMaterialityPercentage.hashCode() : 0);
			_result = 31 * _result + (minimumFuturesContracts != null ? minimumFuturesContracts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMarketDisruption {" +
				"marketDisruptionEvents=" + this.marketDisruptionEvents + ", " +
				"additionalMarketDisruptionEvent=" + this.additionalMarketDisruptionEvent + ", " +
				"marketDisruptionEvent=" + this.marketDisruptionEvent + ", " +
				"disruptionFallbacks=" + this.disruptionFallbacks + ", " +
				"disruptionFallback=" + this.disruptionFallback + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"maximumNumberOfDaysOfDisruption=" + this.maximumNumberOfDaysOfDisruption + ", " +
				"priceMaterialityPercentage=" + this.priceMaterialityPercentage + ", " +
				"minimumFuturesContracts=" + this.minimumFuturesContracts +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMarketDisruption  ***********************/
	class CommodityMarketDisruptionBuilderImpl implements CommodityMarketDisruption.CommodityMarketDisruptionBuilder {
	
		protected MarketDisruptionEventsEnum marketDisruptionEvents;
		protected List<MarketDisruptionEvent.MarketDisruptionEventBuilder> additionalMarketDisruptionEvent = new ArrayList<>();
		protected List<MarketDisruptionEvent.MarketDisruptionEventBuilder> marketDisruptionEvent = new ArrayList<>();
		protected DisruptionFallbacksEnum disruptionFallbacks;
		protected List<SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder> disruptionFallback = new ArrayList<>();
		protected Underlyer.UnderlyerBuilder fallbackReferencePrice;
		protected Integer maximumNumberOfDaysOfDisruption;
		protected BigDecimal priceMaterialityPercentage;
		protected Integer minimumFuturesContracts;
		
		@Override
		@RosettaAttribute("marketDisruptionEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruptionEvents")
		public MarketDisruptionEventsEnum getMarketDisruptionEvents() {
			return marketDisruptionEvents;
		}
		
		@Override
		@RosettaAttribute("additionalMarketDisruptionEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalMarketDisruptionEvent")
		public List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getAdditionalMarketDisruptionEvent() {
			return additionalMarketDisruptionEvent;
		}
		
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateAdditionalMarketDisruptionEvent(int index) {
			if (additionalMarketDisruptionEvent==null) {
				this.additionalMarketDisruptionEvent = new ArrayList<>();
			}
			return getIndex(additionalMarketDisruptionEvent, index, () -> {
						MarketDisruptionEvent.MarketDisruptionEventBuilder newAdditionalMarketDisruptionEvent = MarketDisruptionEvent.builder();
						return newAdditionalMarketDisruptionEvent;
					});
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("marketDisruptionEvent")
		public List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getMarketDisruptionEvent() {
			return marketDisruptionEvent;
		}
		
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateMarketDisruptionEvent(int index) {
			if (marketDisruptionEvent==null) {
				this.marketDisruptionEvent = new ArrayList<>();
			}
			return getIndex(marketDisruptionEvent, index, () -> {
						MarketDisruptionEvent.MarketDisruptionEventBuilder newMarketDisruptionEvent = MarketDisruptionEvent.builder();
						return newMarketDisruptionEvent;
					});
		}
		
		@Override
		@RosettaAttribute("disruptionFallbacks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disruptionFallbacks")
		public DisruptionFallbacksEnum getDisruptionFallbacks() {
			return disruptionFallbacks;
		}
		
		@Override
		@RosettaAttribute("disruptionFallback")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("disruptionFallback")
		public List<? extends SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder> getDisruptionFallback() {
			return disruptionFallback;
		}
		
		@Override
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder getOrCreateDisruptionFallback(int index) {
			if (disruptionFallback==null) {
				this.disruptionFallback = new ArrayList<>();
			}
			return getIndex(disruptionFallback, index, () -> {
						SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder newDisruptionFallback = SequencedDisruptionFallback.builder();
						return newDisruptionFallback;
					});
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public Underlyer.UnderlyerBuilder getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateFallbackReferencePrice() {
			Underlyer.UnderlyerBuilder result;
			if (fallbackReferencePrice!=null) {
				result = fallbackReferencePrice;
			}
			else {
				result = fallbackReferencePrice = Underlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNumberOfDaysOfDisruption")
		public Integer getMaximumNumberOfDaysOfDisruption() {
			return maximumNumberOfDaysOfDisruption;
		}
		
		@Override
		@RosettaAttribute("priceMaterialityPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceMaterialityPercentage")
		public BigDecimal getPriceMaterialityPercentage() {
			return priceMaterialityPercentage;
		}
		
		@Override
		@RosettaAttribute("minimumFuturesContracts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumFuturesContracts")
		public Integer getMinimumFuturesContracts() {
			return minimumFuturesContracts;
		}
		
		@RosettaAttribute("marketDisruptionEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruptionEvents")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMarketDisruptionEvents(MarketDisruptionEventsEnum _marketDisruptionEvents) {
			this.marketDisruptionEvents = _marketDisruptionEvents == null ? null : _marketDisruptionEvents;
			return this;
		}
		
		@RosettaAttribute("additionalMarketDisruptionEvent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalMarketDisruptionEvent")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent _additionalMarketDisruptionEvent) {
			if (_additionalMarketDisruptionEvent != null) {
				this.additionalMarketDisruptionEvent.add(_additionalMarketDisruptionEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent _additionalMarketDisruptionEvent, int idx) {
			getIndex(this.additionalMarketDisruptionEvent, idx, () -> _additionalMarketDisruptionEvent.toBuilder());
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvents) {
			if (additionalMarketDisruptionEvents != null) {
				for (final MarketDisruptionEvent toAdd : additionalMarketDisruptionEvents) {
					this.additionalMarketDisruptionEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalMarketDisruptionEvent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalMarketDisruptionEvent")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvents) {
			if (additionalMarketDisruptionEvents == null) {
				this.additionalMarketDisruptionEvent = new ArrayList<>();
			} else {
				this.additionalMarketDisruptionEvent = additionalMarketDisruptionEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("marketDisruptionEvent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("marketDisruptionEvent")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent _marketDisruptionEvent) {
			if (_marketDisruptionEvent != null) {
				this.marketDisruptionEvent.add(_marketDisruptionEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent _marketDisruptionEvent, int idx) {
			getIndex(this.marketDisruptionEvent, idx, () -> _marketDisruptionEvent.toBuilder());
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(List<? extends MarketDisruptionEvent> _marketDisruptionEvents) {
			if (_marketDisruptionEvents != null) {
				for (final MarketDisruptionEvent toAdd : _marketDisruptionEvents) {
					this.marketDisruptionEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("marketDisruptionEvent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("marketDisruptionEvent")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMarketDisruptionEvent(List<? extends MarketDisruptionEvent> _marketDisruptionEvents) {
			if (_marketDisruptionEvents == null) {
				this.marketDisruptionEvent = new ArrayList<>();
			} else {
				this.marketDisruptionEvent = _marketDisruptionEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("disruptionFallbacks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disruptionFallbacks")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallbacks(DisruptionFallbacksEnum _disruptionFallbacks) {
			this.disruptionFallbacks = _disruptionFallbacks == null ? null : _disruptionFallbacks;
			return this;
		}
		
		@RosettaAttribute("disruptionFallback")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("disruptionFallback")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback _disruptionFallback) {
			if (_disruptionFallback != null) {
				this.disruptionFallback.add(_disruptionFallback.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback _disruptionFallback, int idx) {
			getIndex(this.disruptionFallback, idx, () -> _disruptionFallback.toBuilder());
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(List<? extends SequencedDisruptionFallback> _disruptionFallbacks) {
			if (_disruptionFallbacks != null) {
				for (final SequencedDisruptionFallback toAdd : _disruptionFallbacks) {
					this.disruptionFallback.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("disruptionFallback")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("disruptionFallback")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallback(List<? extends SequencedDisruptionFallback> _disruptionFallbacks) {
			if (_disruptionFallbacks == null) {
				this.disruptionFallback = new ArrayList<>();
			} else {
				this.disruptionFallback = _disruptionFallbacks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackReferencePrice")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setFallbackReferencePrice(Underlyer _fallbackReferencePrice) {
			this.fallbackReferencePrice = _fallbackReferencePrice == null ? null : _fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maximumNumberOfDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNumberOfDaysOfDisruption")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMaximumNumberOfDaysOfDisruption(Integer _maximumNumberOfDaysOfDisruption) {
			this.maximumNumberOfDaysOfDisruption = _maximumNumberOfDaysOfDisruption == null ? null : _maximumNumberOfDaysOfDisruption;
			return this;
		}
		
		@RosettaAttribute("priceMaterialityPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceMaterialityPercentage")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setPriceMaterialityPercentage(BigDecimal _priceMaterialityPercentage) {
			this.priceMaterialityPercentage = _priceMaterialityPercentage == null ? null : _priceMaterialityPercentage;
			return this;
		}
		
		@RosettaAttribute("minimumFuturesContracts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumFuturesContracts")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMinimumFuturesContracts(Integer _minimumFuturesContracts) {
			this.minimumFuturesContracts = _minimumFuturesContracts == null ? null : _minimumFuturesContracts;
			return this;
		}
		
		@Override
		public CommodityMarketDisruption build() {
			return new CommodityMarketDisruption.CommodityMarketDisruptionImpl(this);
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder prune() {
			additionalMarketDisruptionEvent = additionalMarketDisruptionEvent.stream().filter(b->b!=null).<MarketDisruptionEvent.MarketDisruptionEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			marketDisruptionEvent = marketDisruptionEvent.stream().filter(b->b!=null).<MarketDisruptionEvent.MarketDisruptionEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			disruptionFallback = disruptionFallback.stream().filter(b->b!=null).<SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarketDisruptionEvents()!=null) return true;
			if (getAdditionalMarketDisruptionEvent()!=null && getAdditionalMarketDisruptionEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarketDisruptionEvent()!=null && getMarketDisruptionEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDisruptionFallbacks()!=null) return true;
			if (getDisruptionFallback()!=null && getDisruptionFallback().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			if (getMaximumNumberOfDaysOfDisruption()!=null) return true;
			if (getPriceMaterialityPercentage()!=null) return true;
			if (getMinimumFuturesContracts()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder o = (CommodityMarketDisruption.CommodityMarketDisruptionBuilder) other;
			
			merger.mergeRosetta(getAdditionalMarketDisruptionEvent(), o.getAdditionalMarketDisruptionEvent(), this::getOrCreateAdditionalMarketDisruptionEvent);
			merger.mergeRosetta(getMarketDisruptionEvent(), o.getMarketDisruptionEvent(), this::getOrCreateMarketDisruptionEvent);
			merger.mergeRosetta(getDisruptionFallback(), o.getDisruptionFallback(), this::getOrCreateDisruptionFallback);
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			
			merger.mergeBasic(getMarketDisruptionEvents(), o.getMarketDisruptionEvents(), this::setMarketDisruptionEvents);
			merger.mergeBasic(getDisruptionFallbacks(), o.getDisruptionFallbacks(), this::setDisruptionFallbacks);
			merger.mergeBasic(getMaximumNumberOfDaysOfDisruption(), o.getMaximumNumberOfDaysOfDisruption(), this::setMaximumNumberOfDaysOfDisruption);
			merger.mergeBasic(getPriceMaterialityPercentage(), o.getPriceMaterialityPercentage(), this::setPriceMaterialityPercentage);
			merger.mergeBasic(getMinimumFuturesContracts(), o.getMinimumFuturesContracts(), this::setMinimumFuturesContracts);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMarketDisruption _that = getType().cast(o);
		
			if (!Objects.equals(marketDisruptionEvents, _that.getMarketDisruptionEvents())) return false;
			if (!ListEquals.listEquals(additionalMarketDisruptionEvent, _that.getAdditionalMarketDisruptionEvent())) return false;
			if (!ListEquals.listEquals(marketDisruptionEvent, _that.getMarketDisruptionEvent())) return false;
			if (!Objects.equals(disruptionFallbacks, _that.getDisruptionFallbacks())) return false;
			if (!ListEquals.listEquals(disruptionFallback, _that.getDisruptionFallback())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(maximumNumberOfDaysOfDisruption, _that.getMaximumNumberOfDaysOfDisruption())) return false;
			if (!Objects.equals(priceMaterialityPercentage, _that.getPriceMaterialityPercentage())) return false;
			if (!Objects.equals(minimumFuturesContracts, _that.getMinimumFuturesContracts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marketDisruptionEvents != null ? marketDisruptionEvents.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalMarketDisruptionEvent != null ? additionalMarketDisruptionEvent.hashCode() : 0);
			_result = 31 * _result + (marketDisruptionEvent != null ? marketDisruptionEvent.hashCode() : 0);
			_result = 31 * _result + (disruptionFallbacks != null ? disruptionFallbacks.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (disruptionFallback != null ? disruptionFallback.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfDaysOfDisruption != null ? maximumNumberOfDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (priceMaterialityPercentage != null ? priceMaterialityPercentage.hashCode() : 0);
			_result = 31 * _result + (minimumFuturesContracts != null ? minimumFuturesContracts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMarketDisruptionBuilder {" +
				"marketDisruptionEvents=" + this.marketDisruptionEvents + ", " +
				"additionalMarketDisruptionEvent=" + this.additionalMarketDisruptionEvent + ", " +
				"marketDisruptionEvent=" + this.marketDisruptionEvent + ", " +
				"disruptionFallbacks=" + this.disruptionFallbacks + ", " +
				"disruptionFallback=" + this.disruptionFallback + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"maximumNumberOfDaysOfDisruption=" + this.maximumNumberOfDaysOfDisruption + ", " +
				"priceMaterialityPercentage=" + this.priceMaterialityPercentage + ", " +
				"minimumFuturesContracts=" + this.minimumFuturesContracts +
			'}';
		}
	}
}
