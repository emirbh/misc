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
import fpml.consolidated.com.meta.CommodityPerformanceSwapMeta;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.IdentifiedCurrency;
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
 * Provision A type describing a commodity performance swap in which one leg pays out based on the return on a reference commodity index or commodity reference price.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a commodity performance swap in which one leg pays out based on the return on a reference commodity index or commodity reference price.
 *
 */
@RosettaDataType(value="CommodityPerformanceSwap", builder=CommodityPerformanceSwap.CommodityPerformanceSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPerformanceSwap", model="fpml", builder=CommodityPerformanceSwap.CommodityPerformanceSwapBuilderImpl.class, version="2.1.1")
public interface CommodityPerformanceSwap extends CommodityPerformanceSwapBase {

	CommodityPerformanceSwapMeta metaData = new CommodityPerformanceSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, for one or for both the parties to the trade, the date prior to the Termination Date from which the contract can be terminated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, for one or for both the parties to the trade, the date prior to the Termination Date from which the contract can be terminated.
	 *
	 */
	List<? extends CommodityPerformanceSwapEarlyTermination> getEarlyTermination();

	/*********************** Build Methods  ***********************/
	CommodityPerformanceSwap build();
	
	CommodityPerformanceSwap.CommodityPerformanceSwapBuilder toBuilder();
	
	static CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder() {
		return new CommodityPerformanceSwap.CommodityPerformanceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPerformanceSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPerformanceSwap> getType() {
		return CommodityPerformanceSwap.class;
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
		processRosetta(path.newSubPath("commodityPerformanceSwapLeg"), processor, CommodityPerformanceSwapLeg.class, getCommodityPerformanceSwapLeg());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
		processRosetta(path.newSubPath("earlyTermination"), processor, CommodityPerformanceSwapEarlyTermination.class, getEarlyTermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPerformanceSwapBuilder extends CommodityPerformanceSwap, CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder {
		CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int index);
		@Override
		List<? extends CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder> getEarlyTermination();
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setId(String id);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductType(ProductType productType);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductId(ProductId productId);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg, int idx);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommonPricing(Boolean commonPricing);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		@Override
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setRounding(Rounding rounding);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination earlyTermination);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination earlyTermination, int idx);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTermination);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTermination);

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
			processRosetta(path.newSubPath("commodityPerformanceSwapLeg"), processor, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder.class, getCommodityPerformanceSwapLeg());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
			processRosetta(path.newSubPath("earlyTermination"), processor, CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder.class, getEarlyTermination());
		}
		

		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPerformanceSwap  ***********************/
	class CommodityPerformanceSwapImpl extends CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseImpl implements CommodityPerformanceSwap {
		private final List<? extends CommodityPerformanceSwapEarlyTermination> earlyTermination;
		
		protected CommodityPerformanceSwapImpl(CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder) {
			super(builder);
			this.earlyTermination = ofNullable(builder.getEarlyTermination()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("earlyTermination")
		public List<? extends CommodityPerformanceSwapEarlyTermination> getEarlyTermination() {
			return earlyTermination;
		}
		
		@Override
		public CommodityPerformanceSwap build() {
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder toBuilder() {
			CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEarlyTermination()).ifPresent(builder::setEarlyTermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwap {" +
				"earlyTermination=" + this.earlyTermination +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPerformanceSwap  ***********************/
	class CommodityPerformanceSwapBuilderImpl extends CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilderImpl implements CommodityPerformanceSwap.CommodityPerformanceSwapBuilder {
	
		protected List<CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder> earlyTermination = new ArrayList<>();
		
		@Override
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("earlyTermination")
		public List<? extends CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder> getEarlyTermination() {
			return earlyTermination;
		}
		
		@Override
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int index) {
			if (earlyTermination==null) {
				this.earlyTermination = new ArrayList<>();
			}
			return getIndex(earlyTermination, index, () -> {
						CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder newEarlyTermination = CommodityPerformanceSwapEarlyTermination.builder();
						return newEarlyTermination;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		@RuneAttribute("effectiveDate")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSettlementCurrency(IdentifiedCurrency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityPerformanceSwapLeg")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityPerformanceSwapLeg")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg _commodityPerformanceSwapLeg) {
			if (_commodityPerformanceSwapLeg != null) {
				this.commodityPerformanceSwapLeg.add(_commodityPerformanceSwapLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg _commodityPerformanceSwapLeg, int idx) {
			getIndex(this.commodityPerformanceSwapLeg, idx, () -> _commodityPerformanceSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLegs) {
			if (commodityPerformanceSwapLegs != null) {
				for (final CommodityPerformanceSwapLeg toAdd : commodityPerformanceSwapLegs) {
					this.commodityPerformanceSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commodityPerformanceSwapLeg")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commodityPerformanceSwapLeg")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLegs) {
			if (commodityPerformanceSwapLegs == null) {
				this.commodityPerformanceSwapLeg = new ArrayList<>();
			} else {
				this.commodityPerformanceSwapLeg = commodityPerformanceSwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commonPricing")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("earlyTermination")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination _earlyTermination) {
			if (_earlyTermination != null) {
				this.earlyTermination.add(_earlyTermination.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination _earlyTermination, int idx) {
			getIndex(this.earlyTermination, idx, () -> _earlyTermination.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations != null) {
				for (final CommodityPerformanceSwapEarlyTermination toAdd : earlyTerminations) {
					this.earlyTermination.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("earlyTermination")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations == null) {
				this.earlyTermination = new ArrayList<>();
			} else {
				this.earlyTermination = earlyTerminations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap build() {
			return new CommodityPerformanceSwap.CommodityPerformanceSwapImpl(this);
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder prune() {
			super.prune();
			earlyTermination = earlyTermination.stream().filter(b->b!=null).<CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEarlyTermination()!=null && getEarlyTermination().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityPerformanceSwap.CommodityPerformanceSwapBuilder o = (CommodityPerformanceSwap.CommodityPerformanceSwapBuilder) other;
			
			merger.mergeRosetta(getEarlyTermination(), o.getEarlyTermination(), this::getOrCreateEarlyTermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwapBuilder {" +
				"earlyTermination=" + this.earlyTermination +
			'}' + " " + super.toString();
		}
	}
}
