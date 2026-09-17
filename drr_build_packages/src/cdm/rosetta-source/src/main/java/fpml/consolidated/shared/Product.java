package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.ProductMeta;
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
 * Provision The base type which all FpML products extend.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The base type which all FpML products extend.
 *
 */
@RosettaDataType(value="Product", builder=Product.ProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Product", model="fpml", builder=Product.ProductBuilderImpl.class, version="2.1.1")
public interface Product extends RosettaModelObject {

	ProductMeta metaData = new ProductMeta();

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
	 * Provision A classification of the most important risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A classification of the most important risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 */
	AssetClass getPrimaryAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of additional risk classes of the trade, if any. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A classification of additional risk classes of the trade, if any. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 */
	List<? extends AssetClass> getSecondaryAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of the type of product. FpML defines a simple product categorization using a coding scheme.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A classification of the type of product. FpML defines a simple product categorization using a coding scheme.
	 *
	 */
	List<? extends ProductType> getProductType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A product reference identifier. The product ID is an identifier that describes the key economic characteristics of the trade type, with the exception of concepts such as size (notional, quantity, number of units) and price (fixed rate, strike, etc.) that are negotiated for each transaction. It can be used to hold identifiers such as the "UPI" (universal product identifier) required by certain regulatory reporting rules. It can also be used to hold identifiers of benchmark products or product temnplates used by certain trading systems or facilities. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A product reference identifier. The product ID is an identifier that describes the key economic characteristics of the trade type, with the exception of concepts such as size (notional, quantity, number of units) and price (fixed rate, strike, etc.) that are negotiated for each transaction. It can be used to hold identifiers such as the "UPI" (universal product identifier) required by certain regulatory reporting rules. It can also be used to hold identifiers of benchmark products or product temnplates used by certain trading systems or facilities. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
	 *
	 */
	List<? extends ProductId> getProductId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the type of any embedded optionality in the transaction that might not otherwise be apparent. Can be used to represent embedded optionality such as early termination provisions, extendible provisions, or cancelable provisions, etc., where applicable. If omitted, no embedded optionality is applicable.
	 *
	 */
	List<? extends EmbeddedOptionType> getEmbeddedOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A classification of the risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 */
	List<? extends AssetClass> getAssetClass();

	/*********************** Build Methods  ***********************/
	Product build();
	
	Product.ProductBuilder toBuilder();
	
	static Product.ProductBuilder builder() {
		return new Product.ProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Product> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Product> getType() {
		return Product.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductBuilder extends Product, RosettaModelObjectBuilder {
		AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass();
		@Override
		AssetClass.AssetClassBuilder getPrimaryAssetClass();
		AssetClass.AssetClassBuilder getOrCreateSecondaryAssetClass(int index);
		@Override
		List<? extends AssetClass.AssetClassBuilder> getSecondaryAssetClass();
		ProductType.ProductTypeBuilder getOrCreateProductType(int index);
		@Override
		List<? extends ProductType.ProductTypeBuilder> getProductType();
		ProductId.ProductIdBuilder getOrCreateProductId(int index);
		@Override
		List<? extends ProductId.ProductIdBuilder> getProductId();
		EmbeddedOptionType.EmbeddedOptionTypeBuilder getOrCreateEmbeddedOptionType(int index);
		@Override
		List<? extends EmbeddedOptionType.EmbeddedOptionTypeBuilder> getEmbeddedOptionType();
		AssetClass.AssetClassBuilder getOrCreateAssetClass(int index);
		@Override
		List<? extends AssetClass.AssetClassBuilder> getAssetClass();
		Product.ProductBuilder setId(String id);
		Product.ProductBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		Product.ProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		Product.ProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		Product.ProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		Product.ProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		Product.ProductBuilder addProductType(ProductType productType);
		Product.ProductBuilder addProductType(ProductType productType, int idx);
		Product.ProductBuilder addProductType(List<? extends ProductType> productType);
		Product.ProductBuilder setProductType(List<? extends ProductType> productType);
		Product.ProductBuilder addProductId(ProductId productId);
		Product.ProductBuilder addProductId(ProductId productId, int idx);
		Product.ProductBuilder addProductId(List<? extends ProductId> productId);
		Product.ProductBuilder setProductId(List<? extends ProductId> productId);
		Product.ProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		Product.ProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		Product.ProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		Product.ProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		Product.ProductBuilder addAssetClass(AssetClass assetClass);
		Product.ProductBuilder addAssetClass(AssetClass assetClass, int idx);
		Product.ProductBuilder addAssetClass(List<? extends AssetClass> assetClass);
		Product.ProductBuilder setAssetClass(List<? extends AssetClass> assetClass);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
		}
		

		Product.ProductBuilder prune();
	}

	/*********************** Immutable Implementation of Product  ***********************/
	class ProductImpl implements Product {
		private final String id;
		private final AssetClass primaryAssetClass;
		private final List<? extends AssetClass> secondaryAssetClass;
		private final List<? extends ProductType> productType;
		private final List<? extends ProductId> productId;
		private final List<? extends EmbeddedOptionType> embeddedOptionType;
		private final List<? extends AssetClass> assetClass;
		
		protected ProductImpl(Product.ProductBuilder builder) {
			this.id = builder.getId();
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.secondaryAssetClass = ofNullable(builder.getSecondaryAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productType = ofNullable(builder.getProductType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productId = ofNullable(builder.getProductId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.embeddedOptionType = ofNullable(builder.getEmbeddedOptionType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.assetClass = ofNullable(builder.getAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		public List<? extends AssetClass> getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productType")
		public List<? extends ProductType> getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("productId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productId")
		public List<? extends ProductId> getProductId() {
			return productId;
		}
		
		@Override
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		public List<? extends EmbeddedOptionType> getEmbeddedOptionType() {
			return embeddedOptionType;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetClass")
		public List<? extends AssetClass> getAssetClass() {
			return assetClass;
		}
		
		@Override
		public Product build() {
			return this;
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			Product.ProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Product.ProductBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getSecondaryAssetClass()).ifPresent(builder::setSecondaryAssetClass);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getProductId()).ifPresent(builder::setProductId);
			ofNullable(getEmbeddedOptionType()).ifPresent(builder::setEmbeddedOptionType);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!ListEquals.listEquals(productId, _that.getProductId())) return false;
			if (!ListEquals.listEquals(embeddedOptionType, _that.getEmbeddedOptionType())) return false;
			if (!ListEquals.listEquals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (embeddedOptionType != null ? embeddedOptionType.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Product {" +
				"id=" + this.id + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId + ", " +
				"embeddedOptionType=" + this.embeddedOptionType + ", " +
				"assetClass=" + this.assetClass +
			'}';
		}
	}

	/*********************** Builder Implementation of Product  ***********************/
	class ProductBuilderImpl implements Product.ProductBuilder {
	
		protected String id;
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected List<AssetClass.AssetClassBuilder> secondaryAssetClass = new ArrayList<>();
		protected List<ProductType.ProductTypeBuilder> productType = new ArrayList<>();
		protected List<ProductId.ProductIdBuilder> productId = new ArrayList<>();
		protected List<EmbeddedOptionType.EmbeddedOptionTypeBuilder> embeddedOptionType = new ArrayList<>();
		protected List<AssetClass.AssetClassBuilder> assetClass = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass.AssetClassBuilder getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass() {
			AssetClass.AssetClassBuilder result;
			if (primaryAssetClass!=null) {
				result = primaryAssetClass;
			}
			else {
				result = primaryAssetClass = AssetClass.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		public List<? extends AssetClass.AssetClassBuilder> getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreateSecondaryAssetClass(int index) {
			if (secondaryAssetClass==null) {
				this.secondaryAssetClass = new ArrayList<>();
			}
			return getIndex(secondaryAssetClass, index, () -> {
						AssetClass.AssetClassBuilder newSecondaryAssetClass = AssetClass.builder();
						return newSecondaryAssetClass;
					});
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productType")
		public List<? extends ProductType.ProductTypeBuilder> getProductType() {
			return productType;
		}
		
		@Override
		public ProductType.ProductTypeBuilder getOrCreateProductType(int index) {
			if (productType==null) {
				this.productType = new ArrayList<>();
			}
			return getIndex(productType, index, () -> {
						ProductType.ProductTypeBuilder newProductType = ProductType.builder();
						return newProductType;
					});
		}
		
		@Override
		@RosettaAttribute("productId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productId")
		public List<? extends ProductId.ProductIdBuilder> getProductId() {
			return productId;
		}
		
		@Override
		public ProductId.ProductIdBuilder getOrCreateProductId(int index) {
			if (productId==null) {
				this.productId = new ArrayList<>();
			}
			return getIndex(productId, index, () -> {
						ProductId.ProductIdBuilder newProductId = ProductId.builder();
						return newProductId;
					});
		}
		
		@Override
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		public List<? extends EmbeddedOptionType.EmbeddedOptionTypeBuilder> getEmbeddedOptionType() {
			return embeddedOptionType;
		}
		
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder getOrCreateEmbeddedOptionType(int index) {
			if (embeddedOptionType==null) {
				this.embeddedOptionType = new ArrayList<>();
			}
			return getIndex(embeddedOptionType, index, () -> {
						EmbeddedOptionType.EmbeddedOptionTypeBuilder newEmbeddedOptionType = EmbeddedOptionType.builder();
						return newEmbeddedOptionType;
					});
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetClass")
		public List<? extends AssetClass.AssetClassBuilder> getAssetClass() {
			return assetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreateAssetClass(int index) {
			if (assetClass==null) {
				this.assetClass = new ArrayList<>();
			}
			return getIndex(assetClass, index, () -> {
						AssetClass.AssetClassBuilder newAssetClass = AssetClass.builder();
						return newAssetClass;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Product.ProductBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Product.ProductBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Product.ProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Product.ProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public Product.ProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Product.ProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Product.ProductBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Product.ProductBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public Product.ProductBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public Product.ProductBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public Product.ProductBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Product.ProductBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public Product.ProductBuilder addProductId(List<? extends ProductId> productIds) {
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
		public Product.ProductBuilder setProductId(List<? extends ProductId> productIds) {
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
		public Product.ProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Product.ProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public Product.ProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Product.ProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Product.ProductBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Product.ProductBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public Product.ProductBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public Product.ProductBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Product build() {
			return new Product.ProductImpl(this);
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder prune() {
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			secondaryAssetClass = secondaryAssetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productType = productType.stream().filter(b->b!=null).<ProductType.ProductTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productId = productId.stream().filter(b->b!=null).<ProductId.ProductIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			embeddedOptionType = embeddedOptionType.stream().filter(b->b!=null).<EmbeddedOptionType.EmbeddedOptionTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			assetClass = assetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPrimaryAssetClass()!=null && getPrimaryAssetClass().hasData()) return true;
			if (getSecondaryAssetClass()!=null && getSecondaryAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductType()!=null && getProductType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductId()!=null && getProductId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEmbeddedOptionType()!=null && getEmbeddedOptionType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAssetClass()!=null && getAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Product.ProductBuilder o = (Product.ProductBuilder) other;
			
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getSecondaryAssetClass(), o.getSecondaryAssetClass(), this::getOrCreateSecondaryAssetClass);
			merger.mergeRosetta(getProductType(), o.getProductType(), this::getOrCreateProductType);
			merger.mergeRosetta(getProductId(), o.getProductId(), this::getOrCreateProductId);
			merger.mergeRosetta(getEmbeddedOptionType(), o.getEmbeddedOptionType(), this::getOrCreateEmbeddedOptionType);
			merger.mergeRosetta(getAssetClass(), o.getAssetClass(), this::getOrCreateAssetClass);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!ListEquals.listEquals(productId, _that.getProductId())) return false;
			if (!ListEquals.listEquals(embeddedOptionType, _that.getEmbeddedOptionType())) return false;
			if (!ListEquals.listEquals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (embeddedOptionType != null ? embeddedOptionType.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductBuilder {" +
				"id=" + this.id + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId + ", " +
				"embeddedOptionType=" + this.embeddedOptionType + ", " +
				"assetClass=" + this.assetClass +
			'}';
		}
	}
}
