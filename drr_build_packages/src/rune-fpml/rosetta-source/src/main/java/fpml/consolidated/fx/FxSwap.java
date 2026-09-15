package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxSwapMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision A type defining either a spot/forward or forward/forward FX swap transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining either a spot/forward or forward/forward FX swap transaction.
 *
 */
@RosettaDataType(value="FxSwap", builder=FxSwap.FxSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxSwap", model="fpml", builder=FxSwap.FxSwapBuilderImpl.class, version="2.1.1")
public interface FxSwap extends Product {

	FxSwapMeta metaData = new FxSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The FX transaction with the earliest value date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The FX transaction with the earliest value date.
	 *
	 */
	FxSwapLeg getNearLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The FX transaction with the latest value date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The FX transaction with the latest value date.
	 *
	 */
	FxSwapLeg getFarLeg();

	/*********************** Build Methods  ***********************/
	FxSwap build();
	
	FxSwap.FxSwapBuilder toBuilder();
	
	static FxSwap.FxSwapBuilder builder() {
		return new FxSwap.FxSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxSwap> getType() {
		return FxSwap.class;
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
		processRosetta(path.newSubPath("nearLeg"), processor, FxSwapLeg.class, getNearLeg());
		processRosetta(path.newSubPath("farLeg"), processor, FxSwapLeg.class, getFarLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSwapBuilder extends FxSwap, Product.ProductBuilder {
		FxSwapLeg.FxSwapLegBuilder getOrCreateNearLeg();
		@Override
		FxSwapLeg.FxSwapLegBuilder getNearLeg();
		FxSwapLeg.FxSwapLegBuilder getOrCreateFarLeg();
		@Override
		FxSwapLeg.FxSwapLegBuilder getFarLeg();
		@Override
		FxSwap.FxSwapBuilder setId(String id);
		@Override
		FxSwap.FxSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxSwap.FxSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxSwap.FxSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxSwap.FxSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxSwap.FxSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxSwap.FxSwapBuilder addProductType(ProductType productType);
		@Override
		FxSwap.FxSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		FxSwap.FxSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxSwap.FxSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxSwap.FxSwapBuilder addProductId(ProductId productId);
		@Override
		FxSwap.FxSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		FxSwap.FxSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxSwap.FxSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxSwap.FxSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxSwap.FxSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxSwap.FxSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxSwap.FxSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxSwap.FxSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxSwap.FxSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxSwap.FxSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxSwap.FxSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxSwap.FxSwapBuilder setNearLeg(FxSwapLeg nearLeg);
		FxSwap.FxSwapBuilder setFarLeg(FxSwapLeg farLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("nearLeg"), processor, FxSwapLeg.FxSwapLegBuilder.class, getNearLeg());
			processRosetta(path.newSubPath("farLeg"), processor, FxSwapLeg.FxSwapLegBuilder.class, getFarLeg());
		}
		

		FxSwap.FxSwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxSwap  ***********************/
	class FxSwapImpl extends Product.ProductImpl implements FxSwap {
		private final FxSwapLeg nearLeg;
		private final FxSwapLeg farLeg;
		
		protected FxSwapImpl(FxSwap.FxSwapBuilder builder) {
			super(builder);
			this.nearLeg = ofNullable(builder.getNearLeg()).map(f->f.build()).orElse(null);
			this.farLeg = ofNullable(builder.getFarLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nearLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nearLeg")
		public FxSwapLeg getNearLeg() {
			return nearLeg;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("farLeg")
		public FxSwapLeg getFarLeg() {
			return farLeg;
		}
		
		@Override
		public FxSwap build() {
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder toBuilder() {
			FxSwap.FxSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSwap.FxSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNearLeg()).ifPresent(builder::setNearLeg);
			ofNullable(getFarLeg()).ifPresent(builder::setFarLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSwap _that = getType().cast(o);
		
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSwap {" +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSwap  ***********************/
	class FxSwapBuilderImpl extends Product.ProductBuilderImpl implements FxSwap.FxSwapBuilder {
	
		protected FxSwapLeg.FxSwapLegBuilder nearLeg;
		protected FxSwapLeg.FxSwapLegBuilder farLeg;
		
		@Override
		@RosettaAttribute("nearLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nearLeg")
		public FxSwapLeg.FxSwapLegBuilder getNearLeg() {
			return nearLeg;
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder getOrCreateNearLeg() {
			FxSwapLeg.FxSwapLegBuilder result;
			if (nearLeg!=null) {
				result = nearLeg;
			}
			else {
				result = nearLeg = FxSwapLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("farLeg")
		public FxSwapLeg.FxSwapLegBuilder getFarLeg() {
			return farLeg;
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder getOrCreateFarLeg() {
			FxSwapLeg.FxSwapLegBuilder result;
			if (farLeg!=null) {
				result = farLeg;
			}
			else {
				result = farLeg = FxSwapLeg.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxSwap.FxSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxSwap.FxSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxSwap.FxSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxSwap.FxSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxSwap.FxSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxSwap.FxSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxSwap.FxSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxSwap.FxSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxSwap.FxSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxSwap.FxSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxSwap.FxSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxSwap.FxSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("nearLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nearLeg")
		@Override
		public FxSwap.FxSwapBuilder setNearLeg(FxSwapLeg _nearLeg) {
			this.nearLeg = _nearLeg == null ? null : _nearLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("farLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("farLeg")
		@Override
		public FxSwap.FxSwapBuilder setFarLeg(FxSwapLeg _farLeg) {
			this.farLeg = _farLeg == null ? null : _farLeg.toBuilder();
			return this;
		}
		
		@Override
		public FxSwap build() {
			return new FxSwap.FxSwapImpl(this);
		}
		
		@Override
		public FxSwap.FxSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSwap.FxSwapBuilder prune() {
			super.prune();
			if (nearLeg!=null && !nearLeg.prune().hasData()) nearLeg = null;
			if (farLeg!=null && !farLeg.prune().hasData()) farLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNearLeg()!=null && getNearLeg().hasData()) return true;
			if (getFarLeg()!=null && getFarLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSwap.FxSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxSwap.FxSwapBuilder o = (FxSwap.FxSwapBuilder) other;
			
			merger.mergeRosetta(getNearLeg(), o.getNearLeg(), this::setNearLeg);
			merger.mergeRosetta(getFarLeg(), o.getFarLeg(), this::setFarLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSwap _that = getType().cast(o);
		
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSwapBuilder {" +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg +
			'}' + " " + super.toString();
		}
	}
}
