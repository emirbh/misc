package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityForwardMeta;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
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
 * Provision Commodity Forward
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Commodity Forward
 *
 */
@RosettaDataType(value="CommodityForward", builder=CommodityForward.CommodityForwardBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityForward", model="fpml", builder=CommodityForward.CommodityForwardBuilderImpl.class, version="2.1.1")
public interface CommodityForward extends Product {

	CommodityForwardMeta metaData = new CommodityForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the value date of the Commodity Forward Transaction. This is the day on which both the cash and the physical commodity settle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the value date of the Commodity Forward Transaction. This is the day on which both the cash and the physical commodity settle.
	 *
	 */
	AdjustableOrRelativeDate getValueDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fixed leg of a Commodity Forward Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fixed leg of a Commodity Forward Transaction.
	 *
	 */
	NonPeriodicFixedPriceLeg getFixedLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the calculated floating price leg of a Commodity Forward Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the calculated floating price leg of a Commodity Forward Transaction.
	 *
	 */
	AveragePriceLeg getAveragePriceLeg();
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
	PhysicalLegBase getPhysicalCommodityForwardLeg();
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
	CommodityForward build();
	
	CommodityForward.CommodityForwardBuilder toBuilder();
	
	static CommodityForward.CommodityForwardBuilder builder() {
		return new CommodityForward.CommodityForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityForward> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityForward> getType() {
		return CommodityForward.class;
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
		processRosetta(path.newSubPath("valueDate"), processor, AdjustableOrRelativeDate.class, getValueDate());
		processRosetta(path.newSubPath("fixedLeg"), processor, NonPeriodicFixedPriceLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("averagePriceLeg"), processor, AveragePriceLeg.class, getAveragePriceLeg());
		processRosetta(path.newSubPath("physicalCommodityForwardLeg"), processor, PhysicalLegBase.class, getPhysicalCommodityForwardLeg());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityForwardBuilder extends CommodityForward, Product.ProductBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValueDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValueDate();
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getOrCreateFixedLeg();
		@Override
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getFixedLeg();
		AveragePriceLeg.AveragePriceLegBuilder getOrCreateAveragePriceLeg();
		@Override
		AveragePriceLeg.AveragePriceLegBuilder getAveragePriceLeg();
		PhysicalLegBase.PhysicalLegBaseBuilder getOrCreatePhysicalCommodityForwardLeg();
		@Override
		PhysicalLegBase.PhysicalLegBaseBuilder getPhysicalCommodityForwardLeg();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption();
		@Override
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption();
		Rounding.RoundingBuilder getOrCreateRounding();
		@Override
		Rounding.RoundingBuilder getRounding();
		@Override
		CommodityForward.CommodityForwardBuilder setId(String id);
		@Override
		CommodityForward.CommodityForwardBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommodityForward.CommodityForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommodityForward.CommodityForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommodityForward.CommodityForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityForward.CommodityForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityForward.CommodityForwardBuilder addProductType(ProductType productType);
		@Override
		CommodityForward.CommodityForwardBuilder addProductType(ProductType productType, int idx);
		@Override
		CommodityForward.CommodityForwardBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommodityForward.CommodityForwardBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommodityForward.CommodityForwardBuilder addProductId(ProductId productId);
		@Override
		CommodityForward.CommodityForwardBuilder addProductId(ProductId productId, int idx);
		@Override
		CommodityForward.CommodityForwardBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommodityForward.CommodityForwardBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommodityForward.CommodityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommodityForward.CommodityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommodityForward.CommodityForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityForward.CommodityForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityForward.CommodityForwardBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommodityForward.CommodityForwardBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommodityForward.CommodityForwardBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityForward.CommodityForwardBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CommodityForward.CommodityForwardBuilder setValueDate(AdjustableOrRelativeDate valueDate);
		CommodityForward.CommodityForwardBuilder setFixedLeg(NonPeriodicFixedPriceLeg fixedLeg);
		CommodityForward.CommodityForwardBuilder setAveragePriceLeg(AveragePriceLeg averagePriceLeg);
		CommodityForward.CommodityForwardBuilder setPhysicalCommodityForwardLeg(PhysicalLegBase physicalCommodityForwardLeg);
		CommodityForward.CommodityForwardBuilder setCommonPricing(Boolean commonPricing);
		CommodityForward.CommodityForwardBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommodityForward.CommodityForwardBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommodityForward.CommodityForwardBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("valueDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getValueDate());
			processRosetta(path.newSubPath("fixedLeg"), processor, NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("averagePriceLeg"), processor, AveragePriceLeg.AveragePriceLegBuilder.class, getAveragePriceLeg());
			processRosetta(path.newSubPath("physicalCommodityForwardLeg"), processor, PhysicalLegBase.PhysicalLegBaseBuilder.class, getPhysicalCommodityForwardLeg());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommodityForward.CommodityForwardBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityForward  ***********************/
	class CommodityForwardImpl extends Product.ProductImpl implements CommodityForward {
		private final AdjustableOrRelativeDate valueDate;
		private final NonPeriodicFixedPriceLeg fixedLeg;
		private final AveragePriceLeg averagePriceLeg;
		private final PhysicalLegBase physicalCommodityForwardLeg;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommodityForwardImpl(CommodityForward.CommodityForwardBuilder builder) {
			super(builder);
			this.valueDate = ofNullable(builder.getValueDate()).map(f->f.build()).orElse(null);
			this.fixedLeg = ofNullable(builder.getFixedLeg()).map(f->f.build()).orElse(null);
			this.averagePriceLeg = ofNullable(builder.getAveragePriceLeg()).map(f->f.build()).orElse(null);
			this.physicalCommodityForwardLeg = ofNullable(builder.getPhysicalCommodityForwardLeg()).map(f->f.build()).orElse(null);
			this.commonPricing = builder.getCommonPricing();
			this.marketDisruption = ofNullable(builder.getMarketDisruption()).map(f->f.build()).orElse(null);
			this.settlementDisruption = builder.getSettlementDisruption();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public AdjustableOrRelativeDate getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedLeg")
		public NonPeriodicFixedPriceLeg getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		@RosettaAttribute("averagePriceLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagePriceLeg")
		public AveragePriceLeg getAveragePriceLeg() {
			return averagePriceLeg;
		}
		
		@Override
		@RosettaAttribute("physicalCommodityForwardLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalCommodityForwardLeg")
		public PhysicalLegBase getPhysicalCommodityForwardLeg() {
			return physicalCommodityForwardLeg;
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
		public CommodityForward build() {
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder toBuilder() {
			CommodityForward.CommodityForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityForward.CommodityForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
			ofNullable(getFixedLeg()).ifPresent(builder::setFixedLeg);
			ofNullable(getAveragePriceLeg()).ifPresent(builder::setAveragePriceLeg);
			ofNullable(getPhysicalCommodityForwardLeg()).ifPresent(builder::setPhysicalCommodityForwardLeg);
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
		
			CommodityForward _that = getType().cast(o);
		
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(averagePriceLeg, _that.getAveragePriceLeg())) return false;
			if (!Objects.equals(physicalCommodityForwardLeg, _that.getPhysicalCommodityForwardLeg())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (averagePriceLeg != null ? averagePriceLeg.hashCode() : 0);
			_result = 31 * _result + (physicalCommodityForwardLeg != null ? physicalCommodityForwardLeg.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityForward {" +
				"valueDate=" + this.valueDate + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"averagePriceLeg=" + this.averagePriceLeg + ", " +
				"physicalCommodityForwardLeg=" + this.physicalCommodityForwardLeg + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityForward  ***********************/
	class CommodityForwardBuilderImpl extends Product.ProductBuilderImpl implements CommodityForward.CommodityForwardBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder valueDate;
		protected NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder fixedLeg;
		protected AveragePriceLeg.AveragePriceLegBuilder averagePriceLeg;
		protected PhysicalLegBase.PhysicalLegBaseBuilder physicalCommodityForwardLeg;
		protected Boolean commonPricing;
		protected CommodityMarketDisruption.CommodityMarketDisruptionBuilder marketDisruption;
		protected CommodityBullionSettlementDisruptionEnum settlementDisruption;
		protected Rounding.RoundingBuilder rounding;
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValueDate() {
			return valueDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValueDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (valueDate!=null) {
				result = valueDate;
			}
			else {
				result = valueDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedLeg")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getOrCreateFixedLeg() {
			NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder result;
			if (fixedLeg!=null) {
				result = fixedLeg;
			}
			else {
				result = fixedLeg = NonPeriodicFixedPriceLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagePriceLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagePriceLeg")
		public AveragePriceLeg.AveragePriceLegBuilder getAveragePriceLeg() {
			return averagePriceLeg;
		}
		
		@Override
		public AveragePriceLeg.AveragePriceLegBuilder getOrCreateAveragePriceLeg() {
			AveragePriceLeg.AveragePriceLegBuilder result;
			if (averagePriceLeg!=null) {
				result = averagePriceLeg;
			}
			else {
				result = averagePriceLeg = AveragePriceLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalCommodityForwardLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalCommodityForwardLeg")
		public PhysicalLegBase.PhysicalLegBaseBuilder getPhysicalCommodityForwardLeg() {
			return physicalCommodityForwardLeg;
		}
		
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder getOrCreatePhysicalCommodityForwardLeg() {
			PhysicalLegBase.PhysicalLegBaseBuilder result;
			if (physicalCommodityForwardLeg!=null) {
				result = physicalCommodityForwardLeg;
			}
			else {
				result = physicalCommodityForwardLeg = PhysicalLegBase.builder();
			}
			
			return result;
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
		public CommodityForward.CommodityForwardBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommodityForward.CommodityForwardBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommodityForward.CommodityForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityForward.CommodityForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityForward.CommodityForwardBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CommodityForward.CommodityForwardBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CommodityForward.CommodityForwardBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CommodityForward.CommodityForwardBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CommodityForward.CommodityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityForward.CommodityForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityForward.CommodityForwardBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommodityForward.CommodityForwardBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valueDate")
		@Override
		public CommodityForward.CommodityForwardBuilder setValueDate(AdjustableOrRelativeDate _valueDate) {
			this.valueDate = _valueDate == null ? null : _valueDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedLeg")
		@Override
		public CommodityForward.CommodityForwardBuilder setFixedLeg(NonPeriodicFixedPriceLeg _fixedLeg) {
			this.fixedLeg = _fixedLeg == null ? null : _fixedLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagePriceLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagePriceLeg")
		@Override
		public CommodityForward.CommodityForwardBuilder setAveragePriceLeg(AveragePriceLeg _averagePriceLeg) {
			this.averagePriceLeg = _averagePriceLeg == null ? null : _averagePriceLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalCommodityForwardLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalCommodityForwardLeg")
		@Override
		public CommodityForward.CommodityForwardBuilder setPhysicalCommodityForwardLeg(PhysicalLegBase _physicalCommodityForwardLeg) {
			this.physicalCommodityForwardLeg = _physicalCommodityForwardLeg == null ? null : _physicalCommodityForwardLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commonPricing")
		@Override
		public CommodityForward.CommodityForwardBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommodityForward.CommodityForwardBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommodityForward.CommodityForwardBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommodityForward.CommodityForwardBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommodityForward build() {
			return new CommodityForward.CommodityForwardImpl(this);
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityForward.CommodityForwardBuilder prune() {
			super.prune();
			if (valueDate!=null && !valueDate.prune().hasData()) valueDate = null;
			if (fixedLeg!=null && !fixedLeg.prune().hasData()) fixedLeg = null;
			if (averagePriceLeg!=null && !averagePriceLeg.prune().hasData()) averagePriceLeg = null;
			if (physicalCommodityForwardLeg!=null && !physicalCommodityForwardLeg.prune().hasData()) physicalCommodityForwardLeg = null;
			if (marketDisruption!=null && !marketDisruption.prune().hasData()) marketDisruption = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValueDate()!=null && getValueDate().hasData()) return true;
			if (getFixedLeg()!=null && getFixedLeg().hasData()) return true;
			if (getAveragePriceLeg()!=null && getAveragePriceLeg().hasData()) return true;
			if (getPhysicalCommodityForwardLeg()!=null && getPhysicalCommodityForwardLeg().hasData()) return true;
			if (getCommonPricing()!=null) return true;
			if (getMarketDisruption()!=null && getMarketDisruption().hasData()) return true;
			if (getSettlementDisruption()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityForward.CommodityForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityForward.CommodityForwardBuilder o = (CommodityForward.CommodityForwardBuilder) other;
			
			merger.mergeRosetta(getValueDate(), o.getValueDate(), this::setValueDate);
			merger.mergeRosetta(getFixedLeg(), o.getFixedLeg(), this::setFixedLeg);
			merger.mergeRosetta(getAveragePriceLeg(), o.getAveragePriceLeg(), this::setAveragePriceLeg);
			merger.mergeRosetta(getPhysicalCommodityForwardLeg(), o.getPhysicalCommodityForwardLeg(), this::setPhysicalCommodityForwardLeg);
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
		
			CommodityForward _that = getType().cast(o);
		
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(averagePriceLeg, _that.getAveragePriceLeg())) return false;
			if (!Objects.equals(physicalCommodityForwardLeg, _that.getPhysicalCommodityForwardLeg())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (averagePriceLeg != null ? averagePriceLeg.hashCode() : 0);
			_result = 31 * _result + (physicalCommodityForwardLeg != null ? physicalCommodityForwardLeg.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityForwardBuilder {" +
				"valueDate=" + this.valueDate + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"averagePriceLeg=" + this.averagePriceLeg + ", " +
				"physicalCommodityForwardLeg=" + this.physicalCommodityForwardLeg + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}
}
