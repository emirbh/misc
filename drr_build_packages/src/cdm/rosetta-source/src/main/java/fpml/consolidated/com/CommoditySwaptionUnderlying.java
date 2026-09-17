package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.com.meta.CommoditySwaptionUnderlyingMeta;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.Rounding;
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
@RosettaDataType(value="CommoditySwaptionUnderlying", builder=CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommoditySwaptionUnderlying", model="fpml", builder=CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilderImpl.class, version="2.1.1")
public interface CommoditySwaptionUnderlying extends RosettaModelObject {

	CommoditySwaptionUnderlyingMeta metaData = new CommoditySwaptionUnderlyingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the effective date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the effective date of the other leg of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the effective date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the effective date of the other leg of the swap.
	 *
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the termination date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the termination date of the other leg of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the termination date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the termination date of the other leg of the swap.
	 *
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency into which the Commodity Swap Transaction will settle. If this is not the same as the currency in which the Commodity Reference Price is quoted on a given floating leg of the Commodity Swap Transaction, then an FX rate should also be specified for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency into which the Commodity Swap Transaction will settle. If this is not the same as the currency in which the Commodity Reference Price is quoted on a given floating leg of the Commodity Swap Transaction, then an FX rate should also be specified for that leg.
	 *
	 */
	IdentifiedCurrency getSettlementCurrency();
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
	List<? extends CommodityLeg> getCommoditySwapLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A weather leg element of a Commodity Swap defines Weather Index Swap transactions. Weather Index Swap transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature, precipitation and other weather-related measurements at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Swap transactions result in a cash flow to one of the two counterparties each Calculation Period depending on the relationship between the Settlement Level and the Weather Index Level. A Weather Index swap transaction always consists of a commodity swap element as a parent to two weatherLeg elements.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A weather leg element of a Commodity Swap defines Weather Index Swap transactions. Weather Index Swap transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature, precipitation and other weather-related measurements at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Swap transactions result in a cash flow to one of the two counterparties each Calculation Period depending on the relationship between the Settlement Level and the Weather Index Level. A Weather Index swap transaction always consists of a commodity swap element as a parent to two weatherLeg elements.
	 *
	 */
	List<? extends WeatherLeg> getWeatherLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 *
	 */
	Boolean getCommonPricing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 *
	 */
	CommodityMarketDisruption getMarketDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 *
	 */
	CommodityBullionSettlementDisruptionEnum getSettlementDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rounding direction and precision for amounts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rounding direction and precision for amounts.
	 *
	 */
	Rounding getRounding();

	/*********************** Build Methods  ***********************/
	CommoditySwaptionUnderlying build();
	
	CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder toBuilder();
	
	static CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder() {
		return new CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwaptionUnderlying> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommoditySwaptionUnderlying> getType() {
		return CommoditySwaptionUnderlying.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("commoditySwapLeg"), processor, CommodityLeg.class, getCommoditySwapLeg());
		processRosetta(path.newSubPath("weatherLeg"), processor, WeatherLeg.class, getWeatherLeg());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwaptionUnderlyingBuilder extends CommoditySwaptionUnderlying, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency();
		CommodityLeg.CommodityLegBuilder getOrCreateCommoditySwapLeg(int index);
		@Override
		List<? extends CommodityLeg.CommodityLegBuilder> getCommoditySwapLeg();
		WeatherLeg.WeatherLegBuilder getOrCreateWeatherLeg(int index);
		@Override
		List<? extends WeatherLeg.WeatherLegBuilder> getWeatherLeg();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption();
		@Override
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption();
		Rounding.RoundingBuilder getOrCreateRounding();
		@Override
		Rounding.RoundingBuilder getRounding();
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addCommoditySwapLeg(CommodityLeg commoditySwapLeg);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addCommoditySwapLeg(CommodityLeg commoditySwapLeg, int idx);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLeg);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLeg);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addWeatherLeg(WeatherLeg weatherLeg);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addWeatherLeg(WeatherLeg weatherLeg, int idx);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addWeatherLeg(List<? extends WeatherLeg> weatherLeg);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setWeatherLeg(List<? extends WeatherLeg> weatherLeg);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setCommonPricing(Boolean commonPricing);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("commoditySwapLeg"), processor, CommodityLeg.CommodityLegBuilder.class, getCommoditySwapLeg());
			processRosetta(path.newSubPath("weatherLeg"), processor, WeatherLeg.WeatherLegBuilder.class, getWeatherLeg());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwaptionUnderlying  ***********************/
	class CommoditySwaptionUnderlyingImpl implements CommoditySwaptionUnderlying {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final IdentifiedCurrency settlementCurrency;
		private final List<? extends CommodityLeg> commoditySwapLeg;
		private final List<? extends WeatherLeg> weatherLeg;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommoditySwaptionUnderlyingImpl(CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.commoditySwapLeg = ofNullable(builder.getCommoditySwapLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.weatherLeg = ofNullable(builder.getWeatherLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commonPricing = builder.getCommonPricing();
			this.marketDisruption = ofNullable(builder.getMarketDisruption()).map(f->f.build()).orElse(null);
			this.settlementDisruption = builder.getSettlementDisruption();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public IdentifiedCurrency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("commoditySwapLeg")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("commoditySwapLeg")
		public List<? extends CommodityLeg> getCommoditySwapLeg() {
			return commoditySwapLeg;
		}
		
		@Override
		@RosettaAttribute("weatherLeg")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("weatherLeg")
		public List<? extends WeatherLeg> getWeatherLeg() {
			return weatherLeg;
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruption")
		public CommodityMarketDisruption getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public CommoditySwaptionUnderlying build() {
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder toBuilder() {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getCommoditySwapLeg()).ifPresent(builder::setCommoditySwapLeg);
			ofNullable(getWeatherLeg()).ifPresent(builder::setWeatherLeg);
			ofNullable(getCommonPricing()).ifPresent(builder::setCommonPricing);
			ofNullable(getMarketDisruption()).ifPresent(builder::setMarketDisruption);
			ofNullable(getSettlementDisruption()).ifPresent(builder::setSettlementDisruption);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySwaptionUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!ListEquals.listEquals(commoditySwapLeg, _that.getCommoditySwapLeg())) return false;
			if (!ListEquals.listEquals(weatherLeg, _that.getWeatherLeg())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commoditySwapLeg != null ? commoditySwapLeg.hashCode() : 0);
			_result = 31 * _result + (weatherLeg != null ? weatherLeg.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaptionUnderlying {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commoditySwapLeg=" + this.commoditySwapLeg + ", " +
				"weatherLeg=" + this.weatherLeg + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySwaptionUnderlying  ***********************/
	class CommoditySwaptionUnderlyingBuilderImpl implements CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder settlementCurrency;
		protected List<CommodityLeg.CommodityLegBuilder> commoditySwapLeg = new ArrayList<>();
		protected List<WeatherLeg.WeatherLegBuilder> weatherLeg = new ArrayList<>();
		protected Boolean commonPricing;
		protected CommodityMarketDisruption.CommodityMarketDisruptionBuilder marketDisruption;
		protected CommodityBullionSettlementDisruptionEnum settlementDisruption;
		protected Rounding.RoundingBuilder rounding;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commoditySwapLeg")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("commoditySwapLeg")
		public List<? extends CommodityLeg.CommodityLegBuilder> getCommoditySwapLeg() {
			return commoditySwapLeg;
		}
		
		@Override
		public CommodityLeg.CommodityLegBuilder getOrCreateCommoditySwapLeg(int index) {
			if (commoditySwapLeg==null) {
				this.commoditySwapLeg = new ArrayList<>();
			}
			return getIndex(commoditySwapLeg, index, () -> {
						CommodityLeg.CommodityLegBuilder newCommoditySwapLeg = CommodityLeg.builder();
						return newCommoditySwapLeg;
					});
		}
		
		@Override
		@RosettaAttribute("weatherLeg")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("weatherLeg")
		public List<? extends WeatherLeg.WeatherLegBuilder> getWeatherLeg() {
			return weatherLeg;
		}
		
		@Override
		public WeatherLeg.WeatherLegBuilder getOrCreateWeatherLeg(int index) {
			if (weatherLeg==null) {
				this.weatherLeg = new ArrayList<>();
			}
			return getIndex(weatherLeg, index, () -> {
						WeatherLeg.WeatherLegBuilder newWeatherLeg = WeatherLeg.builder();
						return newWeatherLeg;
					});
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruption")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption() {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder result;
			if (marketDisruption!=null) {
				result = marketDisruption;
			}
			else {
				result = marketDisruption = CommodityMarketDisruption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("terminationDate")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setSettlementCurrency(IdentifiedCurrency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commoditySwapLeg")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commoditySwapLeg")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addCommoditySwapLeg(CommodityLeg _commoditySwapLeg) {
			if (_commoditySwapLeg != null) {
				this.commoditySwapLeg.add(_commoditySwapLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addCommoditySwapLeg(CommodityLeg _commoditySwapLeg, int idx) {
			getIndex(this.commoditySwapLeg, idx, () -> _commoditySwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLegs) {
			if (commoditySwapLegs != null) {
				for (final CommodityLeg toAdd : commoditySwapLegs) {
					this.commoditySwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commoditySwapLeg")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commoditySwapLeg")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLegs) {
			if (commoditySwapLegs == null) {
				this.commoditySwapLeg = new ArrayList<>();
			} else {
				this.commoditySwapLeg = commoditySwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("weatherLeg")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("weatherLeg")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addWeatherLeg(WeatherLeg _weatherLeg) {
			if (_weatherLeg != null) {
				this.weatherLeg.add(_weatherLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addWeatherLeg(WeatherLeg _weatherLeg, int idx) {
			getIndex(this.weatherLeg, idx, () -> _weatherLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder addWeatherLeg(List<? extends WeatherLeg> weatherLegs) {
			if (weatherLegs != null) {
				for (final WeatherLeg toAdd : weatherLegs) {
					this.weatherLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("weatherLeg")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("weatherLeg")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setWeatherLeg(List<? extends WeatherLeg> weatherLegs) {
			if (weatherLegs == null) {
				this.weatherLeg = new ArrayList<>();
			} else {
				this.weatherLeg = weatherLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commonPricing")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying build() {
			return new CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingImpl(this);
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			commoditySwapLeg = commoditySwapLeg.stream().filter(b->b!=null).<CommodityLeg.CommodityLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			weatherLeg = weatherLeg.stream().filter(b->b!=null).<WeatherLeg.WeatherLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (marketDisruption!=null && !marketDisruption.prune().hasData()) marketDisruption = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getCommoditySwapLeg()!=null && getCommoditySwapLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWeatherLeg()!=null && getWeatherLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommonPricing()!=null) return true;
			if (getMarketDisruption()!=null && getMarketDisruption().hasData()) return true;
			if (getSettlementDisruption()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder o = (CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getCommoditySwapLeg(), o.getCommoditySwapLeg(), this::getOrCreateCommoditySwapLeg);
			merger.mergeRosetta(getWeatherLeg(), o.getWeatherLeg(), this::getOrCreateWeatherLeg);
			merger.mergeRosetta(getMarketDisruption(), o.getMarketDisruption(), this::setMarketDisruption);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getCommonPricing(), o.getCommonPricing(), this::setCommonPricing);
			merger.mergeBasic(getSettlementDisruption(), o.getSettlementDisruption(), this::setSettlementDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySwaptionUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!ListEquals.listEquals(commoditySwapLeg, _that.getCommoditySwapLeg())) return false;
			if (!ListEquals.listEquals(weatherLeg, _that.getWeatherLeg())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commoditySwapLeg != null ? commoditySwapLeg.hashCode() : 0);
			_result = 31 * _result + (weatherLeg != null ? weatherLeg.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaptionUnderlyingBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commoditySwapLeg=" + this.commoditySwapLeg + ", " +
				"weatherLeg=" + this.weatherLeg + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}
}
