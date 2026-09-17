package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.StrategyMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductReference;
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
 * Provision A type defining a group of products making up a single trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a group of products making up a single trade.
 *
 */
@RosettaDataType(value="Strategy", builder=Strategy.StrategyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Strategy", model="fpml", builder=Strategy.StrategyBuilderImpl.class, version="2.1.1")
public interface Strategy extends Product {

	StrategyMeta metaData = new StrategyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides distinct identification for a component of a strategy.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides distinct identification for a component of a strategy.
	 *
	 */
	List<? extends StrategyComponentIdentification> getStrategyComponentIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates which product within a strategy represents the premium payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates which product within a strategy represents the premium payment.
	 *
	 */
	ProductReference getPremiumProductReference();
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
	List<? extends Product> getProduct();

	/*********************** Build Methods  ***********************/
	Strategy build();
	
	Strategy.StrategyBuilder toBuilder();
	
	static Strategy.StrategyBuilder builder() {
		return new Strategy.StrategyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Strategy> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Strategy> getType() {
		return Strategy.class;
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
		processRosetta(path.newSubPath("strategyComponentIdentifier"), processor, StrategyComponentIdentification.class, getStrategyComponentIdentifier());
		processRosetta(path.newSubPath("premiumProductReference"), processor, ProductReference.class, getPremiumProductReference());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrategyBuilder extends Strategy, Product.ProductBuilder {
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder getOrCreateStrategyComponentIdentifier(int index);
		@Override
		List<? extends StrategyComponentIdentification.StrategyComponentIdentificationBuilder> getStrategyComponentIdentifier();
		ProductReference.ProductReferenceBuilder getOrCreatePremiumProductReference();
		@Override
		ProductReference.ProductReferenceBuilder getPremiumProductReference();
		Product.ProductBuilder getOrCreateProduct(int index);
		@Override
		List<? extends Product.ProductBuilder> getProduct();
		@Override
		Strategy.StrategyBuilder setId(String id);
		@Override
		Strategy.StrategyBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		Strategy.StrategyBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		Strategy.StrategyBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		Strategy.StrategyBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Strategy.StrategyBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Strategy.StrategyBuilder addProductType(ProductType productType);
		@Override
		Strategy.StrategyBuilder addProductType(ProductType productType, int idx);
		@Override
		Strategy.StrategyBuilder addProductType(List<? extends ProductType> productType);
		@Override
		Strategy.StrategyBuilder setProductType(List<? extends ProductType> productType);
		@Override
		Strategy.StrategyBuilder addProductId(ProductId productId);
		@Override
		Strategy.StrategyBuilder addProductId(ProductId productId, int idx);
		@Override
		Strategy.StrategyBuilder addProductId(List<? extends ProductId> productId);
		@Override
		Strategy.StrategyBuilder setProductId(List<? extends ProductId> productId);
		@Override
		Strategy.StrategyBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		Strategy.StrategyBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		Strategy.StrategyBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Strategy.StrategyBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Strategy.StrategyBuilder addAssetClass(AssetClass assetClass);
		@Override
		Strategy.StrategyBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		Strategy.StrategyBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		Strategy.StrategyBuilder setAssetClass(List<? extends AssetClass> assetClass);
		Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification strategyComponentIdentifier);
		Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification strategyComponentIdentifier, int idx);
		Strategy.StrategyBuilder addStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifier);
		Strategy.StrategyBuilder setStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifier);
		Strategy.StrategyBuilder setPremiumProductReference(ProductReference premiumProductReference);
		Strategy.StrategyBuilder addProduct(Product product);
		Strategy.StrategyBuilder addProduct(Product product, int idx);
		Strategy.StrategyBuilder addProduct(List<? extends Product> product);
		Strategy.StrategyBuilder setProduct(List<? extends Product> product);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("strategyComponentIdentifier"), processor, StrategyComponentIdentification.StrategyComponentIdentificationBuilder.class, getStrategyComponentIdentifier());
			processRosetta(path.newSubPath("premiumProductReference"), processor, ProductReference.ProductReferenceBuilder.class, getPremiumProductReference());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
		}
		

		Strategy.StrategyBuilder prune();
	}

	/*********************** Immutable Implementation of Strategy  ***********************/
	class StrategyImpl extends Product.ProductImpl implements Strategy {
		private final List<? extends StrategyComponentIdentification> strategyComponentIdentifier;
		private final ProductReference premiumProductReference;
		private final List<? extends Product> product;
		
		protected StrategyImpl(Strategy.StrategyBuilder builder) {
			super(builder);
			this.strategyComponentIdentifier = ofNullable(builder.getStrategyComponentIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premiumProductReference = ofNullable(builder.getPremiumProductReference()).map(f->f.build()).orElse(null);
			this.product = ofNullable(builder.getProduct()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strategyComponentIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strategyComponentIdentifier")
		public List<? extends StrategyComponentIdentification> getStrategyComponentIdentifier() {
			return strategyComponentIdentifier;
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumProductReference")
		public ProductReference getPremiumProductReference() {
			return premiumProductReference;
		}
		
		@Override
		@RosettaAttribute("product")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("product")
		public List<? extends Product> getProduct() {
			return product;
		}
		
		@Override
		public Strategy build() {
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder toBuilder() {
			Strategy.StrategyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Strategy.StrategyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrategyComponentIdentifier()).ifPresent(builder::setStrategyComponentIdentifier);
			ofNullable(getPremiumProductReference()).ifPresent(builder::setPremiumProductReference);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Strategy _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strategyComponentIdentifier, _that.getStrategyComponentIdentifier())) return false;
			if (!Objects.equals(premiumProductReference, _that.getPremiumProductReference())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strategyComponentIdentifier != null ? strategyComponentIdentifier.hashCode() : 0);
			_result = 31 * _result + (premiumProductReference != null ? premiumProductReference.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Strategy {" +
				"strategyComponentIdentifier=" + this.strategyComponentIdentifier + ", " +
				"premiumProductReference=" + this.premiumProductReference + ", " +
				"product=" + this.product +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Strategy  ***********************/
	class StrategyBuilderImpl extends Product.ProductBuilderImpl implements Strategy.StrategyBuilder {
	
		protected List<StrategyComponentIdentification.StrategyComponentIdentificationBuilder> strategyComponentIdentifier = new ArrayList<>();
		protected ProductReference.ProductReferenceBuilder premiumProductReference;
		protected List<Product.ProductBuilder> product = new ArrayList<>();
		
		@Override
		@RosettaAttribute("strategyComponentIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strategyComponentIdentifier")
		public List<? extends StrategyComponentIdentification.StrategyComponentIdentificationBuilder> getStrategyComponentIdentifier() {
			return strategyComponentIdentifier;
		}
		
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder getOrCreateStrategyComponentIdentifier(int index) {
			if (strategyComponentIdentifier==null) {
				this.strategyComponentIdentifier = new ArrayList<>();
			}
			return getIndex(strategyComponentIdentifier, index, () -> {
						StrategyComponentIdentification.StrategyComponentIdentificationBuilder newStrategyComponentIdentifier = StrategyComponentIdentification.builder();
						return newStrategyComponentIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumProductReference")
		public ProductReference.ProductReferenceBuilder getPremiumProductReference() {
			return premiumProductReference;
		}
		
		@Override
		public ProductReference.ProductReferenceBuilder getOrCreatePremiumProductReference() {
			ProductReference.ProductReferenceBuilder result;
			if (premiumProductReference!=null) {
				result = premiumProductReference;
			}
			else {
				result = premiumProductReference = ProductReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("product")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("product")
		public List<? extends Product.ProductBuilder> getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct(int index) {
			if (product==null) {
				this.product = new ArrayList<>();
			}
			return getIndex(product, index, () -> {
						Product.ProductBuilder newProduct = Product.builder();
						return newProduct;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Strategy.StrategyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Strategy.StrategyBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Strategy.StrategyBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Strategy.StrategyBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Strategy.StrategyBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public Strategy.StrategyBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public Strategy.StrategyBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProductId(List<? extends ProductId> productIds) {
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
		public Strategy.StrategyBuilder setProductId(List<? extends ProductId> productIds) {
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
		public Strategy.StrategyBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Strategy.StrategyBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Strategy.StrategyBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public Strategy.StrategyBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strategyComponentIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strategyComponentIdentifier")
		@Override
		public Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification _strategyComponentIdentifier) {
			if (_strategyComponentIdentifier != null) {
				this.strategyComponentIdentifier.add(_strategyComponentIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification _strategyComponentIdentifier, int idx) {
			getIndex(this.strategyComponentIdentifier, idx, () -> _strategyComponentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifiers) {
			if (strategyComponentIdentifiers != null) {
				for (final StrategyComponentIdentification toAdd : strategyComponentIdentifiers) {
					this.strategyComponentIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strategyComponentIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strategyComponentIdentifier")
		@Override
		public Strategy.StrategyBuilder setStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifiers) {
			if (strategyComponentIdentifiers == null) {
				this.strategyComponentIdentifier = new ArrayList<>();
			} else {
				this.strategyComponentIdentifier = strategyComponentIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("premiumProductReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premiumProductReference")
		@Override
		public Strategy.StrategyBuilder setPremiumProductReference(ProductReference _premiumProductReference) {
			this.premiumProductReference = _premiumProductReference == null ? null : _premiumProductReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("product")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("product")
		@Override
		public Strategy.StrategyBuilder addProduct(Product _product) {
			if (_product != null) {
				this.product.add(_product.toBuilder());
			}
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProduct(Product _product, int idx) {
			getIndex(this.product, idx, () -> _product.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProduct(List<? extends Product> products) {
			if (products != null) {
				for (final Product toAdd : products) {
					this.product.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("product")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("product")
		@Override
		public Strategy.StrategyBuilder setProduct(List<? extends Product> products) {
			if (products == null) {
				this.product = new ArrayList<>();
			} else {
				this.product = products.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Strategy build() {
			return new Strategy.StrategyImpl(this);
		}
		
		@Override
		public Strategy.StrategyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strategy.StrategyBuilder prune() {
			super.prune();
			strategyComponentIdentifier = strategyComponentIdentifier.stream().filter(b->b!=null).<StrategyComponentIdentification.StrategyComponentIdentificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (premiumProductReference!=null && !premiumProductReference.prune().hasData()) premiumProductReference = null;
			product = product.stream().filter(b->b!=null).<Product.ProductBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrategyComponentIdentifier()!=null && getStrategyComponentIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremiumProductReference()!=null && getPremiumProductReference().hasData()) return true;
			if (getProduct()!=null && getProduct().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strategy.StrategyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Strategy.StrategyBuilder o = (Strategy.StrategyBuilder) other;
			
			merger.mergeRosetta(getStrategyComponentIdentifier(), o.getStrategyComponentIdentifier(), this::getOrCreateStrategyComponentIdentifier);
			merger.mergeRosetta(getPremiumProductReference(), o.getPremiumProductReference(), this::setPremiumProductReference);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::getOrCreateProduct);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Strategy _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strategyComponentIdentifier, _that.getStrategyComponentIdentifier())) return false;
			if (!Objects.equals(premiumProductReference, _that.getPremiumProductReference())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strategyComponentIdentifier != null ? strategyComponentIdentifier.hashCode() : 0);
			_result = 31 * _result + (premiumProductReference != null ? premiumProductReference.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrategyBuilder {" +
				"strategyComponentIdentifier=" + this.strategyComponentIdentifier + ", " +
				"premiumProductReference=" + this.premiumProductReference + ", " +
				"product=" + this.product +
			'}' + " " + super.toString();
		}
	}
}
