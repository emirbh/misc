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
import fpml.consolidated.com.meta.CommoditySwapMeta;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision The commodity swap product model is designed to support fixed-float swaps, float-float swaps, fixed vs. physical swaps, float vs. physical swaps as well as, weather specific swaps. Its design is fully compatible with other FpML products and the product reuses standard common types.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The commodity swap product model is designed to support fixed-float swaps, float-float swaps, fixed vs. physical swaps, float vs. physical swaps as well as, weather specific swaps. Its design is fully compatible with other FpML products and the product reuses standard common types.
 *
 */
@RosettaDataType(value="CommoditySwap", builder=CommoditySwap.CommoditySwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommoditySwap", model="fpml", builder=CommoditySwap.CommoditySwapBuilderImpl.class, version="2.1.1")
public interface CommoditySwap extends Product {

	CommoditySwapMeta metaData = new CommoditySwapMeta();

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
	CommoditySwap build();
	
	CommoditySwap.CommoditySwapBuilder toBuilder();
	
	static CommoditySwap.CommoditySwapBuilder builder() {
		return new CommoditySwap.CommoditySwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommoditySwap> getType() {
		return CommoditySwap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
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
	interface CommoditySwapBuilder extends CommoditySwap, Product.ProductBuilder {
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
		@Override
		CommoditySwap.CommoditySwapBuilder setId(String id);
		@Override
		CommoditySwap.CommoditySwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommoditySwap.CommoditySwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommoditySwap.CommoditySwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommoditySwap.CommoditySwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommoditySwap.CommoditySwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommoditySwap.CommoditySwapBuilder addProductType(ProductType productType);
		@Override
		CommoditySwap.CommoditySwapBuilder addProductType(ProductType productType, int idx);
		@Override
		CommoditySwap.CommoditySwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommoditySwap.CommoditySwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommoditySwap.CommoditySwapBuilder addProductId(ProductId productId);
		@Override
		CommoditySwap.CommoditySwapBuilder addProductId(ProductId productId, int idx);
		@Override
		CommoditySwap.CommoditySwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommoditySwap.CommoditySwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommoditySwap.CommoditySwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommoditySwap.CommoditySwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommoditySwap.CommoditySwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommoditySwap.CommoditySwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommoditySwap.CommoditySwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommoditySwap.CommoditySwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommoditySwap.CommoditySwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommoditySwap.CommoditySwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CommoditySwap.CommoditySwapBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommoditySwap.CommoditySwapBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommoditySwap.CommoditySwapBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommoditySwap.CommoditySwapBuilder addCommoditySwapLeg(CommodityLeg commoditySwapLeg);
		CommoditySwap.CommoditySwapBuilder addCommoditySwapLeg(CommodityLeg commoditySwapLeg, int idx);
		CommoditySwap.CommoditySwapBuilder addCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLeg);
		CommoditySwap.CommoditySwapBuilder setCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLeg);
		CommoditySwap.CommoditySwapBuilder addWeatherLeg(WeatherLeg weatherLeg);
		CommoditySwap.CommoditySwapBuilder addWeatherLeg(WeatherLeg weatherLeg, int idx);
		CommoditySwap.CommoditySwapBuilder addWeatherLeg(List<? extends WeatherLeg> weatherLeg);
		CommoditySwap.CommoditySwapBuilder setWeatherLeg(List<? extends WeatherLeg> weatherLeg);
		CommoditySwap.CommoditySwapBuilder setCommonPricing(Boolean commonPricing);
		CommoditySwap.CommoditySwapBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommoditySwap.CommoditySwapBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommoditySwap.CommoditySwapBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
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
		

		CommoditySwap.CommoditySwapBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwap  ***********************/
	class CommoditySwapImpl extends Product.ProductImpl implements CommoditySwap {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final IdentifiedCurrency settlementCurrency;
		private final List<? extends CommodityLeg> commoditySwapLeg;
		private final List<? extends WeatherLeg> weatherLeg;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommoditySwapImpl(CommoditySwap.CommoditySwapBuilder builder) {
			super(builder);
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
		public CommoditySwap build() {
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder toBuilder() {
			CommoditySwap.CommoditySwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwap.CommoditySwapBuilder builder) {
			super.setBuilderFields(builder);
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
			if (!super.equals(o)) return false;
		
			CommoditySwap _that = getType().cast(o);
		
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
			int _result = super.hashCode();
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
			return "CommoditySwap {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commoditySwapLeg=" + this.commoditySwapLeg + ", " +
				"weatherLeg=" + this.weatherLeg + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySwap  ***********************/
	class CommoditySwapBuilderImpl extends Product.ProductBuilderImpl implements CommoditySwap.CommoditySwapBuilder {
	
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommoditySwap.CommoditySwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommoditySwap.CommoditySwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommoditySwap.CommoditySwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommoditySwap.CommoditySwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public CommoditySwap.CommoditySwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public CommoditySwap.CommoditySwapBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public CommoditySwap.CommoditySwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public CommoditySwap.CommoditySwapBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public CommoditySwap.CommoditySwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public CommoditySwap.CommoditySwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public CommoditySwap.CommoditySwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public CommoditySwap.CommoditySwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public CommoditySwap.CommoditySwapBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("terminationDate")
		@Override
		public CommoditySwap.CommoditySwapBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CommoditySwap.CommoditySwapBuilder setSettlementCurrency(IdentifiedCurrency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commoditySwapLeg")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commoditySwapLeg")
		@Override
		public CommoditySwap.CommoditySwapBuilder addCommoditySwapLeg(CommodityLeg _commoditySwapLeg) {
			if (_commoditySwapLeg != null) {
				this.commoditySwapLeg.add(_commoditySwapLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addCommoditySwapLeg(CommodityLeg _commoditySwapLeg, int idx) {
			getIndex(this.commoditySwapLeg, idx, () -> _commoditySwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLegs) {
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
		public CommoditySwap.CommoditySwapBuilder setCommoditySwapLeg(List<? extends CommodityLeg> commoditySwapLegs) {
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
		public CommoditySwap.CommoditySwapBuilder addWeatherLeg(WeatherLeg _weatherLeg) {
			if (_weatherLeg != null) {
				this.weatherLeg.add(_weatherLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addWeatherLeg(WeatherLeg _weatherLeg, int idx) {
			getIndex(this.weatherLeg, idx, () -> _weatherLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder addWeatherLeg(List<? extends WeatherLeg> weatherLegs) {
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
		public CommoditySwap.CommoditySwapBuilder setWeatherLeg(List<? extends WeatherLeg> weatherLegs) {
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
		public CommoditySwap.CommoditySwapBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommoditySwap.CommoditySwapBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommoditySwap.CommoditySwapBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommoditySwap.CommoditySwapBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwap build() {
			return new CommoditySwap.CommoditySwapImpl(this);
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwap.CommoditySwapBuilder prune() {
			super.prune();
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
			if (super.hasData()) return true;
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
		public CommoditySwap.CommoditySwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommoditySwap.CommoditySwapBuilder o = (CommoditySwap.CommoditySwapBuilder) other;
			
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
			if (!super.equals(o)) return false;
		
			CommoditySwap _that = getType().cast(o);
		
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
			int _result = super.hashCode();
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
			return "CommoditySwapBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commoditySwapLeg=" + this.commoditySwapLeg + ", " +
				"weatherLeg=" + this.weatherLeg + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}
}
