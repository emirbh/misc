package fpml.consolidated.fpmlstandard;

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
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.fpmlstandard.meta.StandardProductMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CashflowNotional;
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
 * Provision Simple product representation providing key information about a variety of different products. Standard products - for use in Transparency reporting to define a product that represents a standardized OTC derivative transaction whose economics do not need to be fully described using an FpML schema because they are implied by the product ID. In other views, standard products are present for convenience to support internal messaging and workflows that are cross-product. Standard products are not full trade representations as such they are not intended to be used for confirming trades.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Simple product representation providing key information about a variety of different products. Standard products - for use in Transparency reporting to define a product that represents a standardized OTC derivative transaction whose economics do not need to be fully described using an FpML schema because they are implied by the product ID. In other views, standard products are present for convenience to support internal messaging and workflows that are cross-product. Standard products are not full trade representations as such they are not intended to be used for confirming trades.
 *
 */
@RosettaDataType(value="StandardProduct", builder=StandardProduct.StandardProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StandardProduct", model="fpml", builder=StandardProduct.StandardProductBuilderImpl.class, version="2.1.1")
public interface StandardProduct extends Product {

	StandardProductMeta metaData = new StandardProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional amount that was traded.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount that was traded.
	 *
	 */
	CashflowNotional getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Pricing information for the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Pricing information for the trade.
	 *
	 */
	List<? extends BasicQuotation> getQuote();

	/*********************** Build Methods  ***********************/
	StandardProduct build();
	
	StandardProduct.StandardProductBuilder toBuilder();
	
	static StandardProduct.StandardProductBuilder builder() {
		return new StandardProduct.StandardProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StandardProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StandardProduct> getType() {
		return StandardProduct.class;
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
		processRosetta(path.newSubPath("notional"), processor, CashflowNotional.class, getNotional());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StandardProductBuilder extends StandardProduct, Product.ProductBuilder {
		CashflowNotional.CashflowNotionalBuilder getOrCreateNotional();
		@Override
		CashflowNotional.CashflowNotionalBuilder getNotional();
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		@Override
		StandardProduct.StandardProductBuilder setId(String id);
		@Override
		StandardProduct.StandardProductBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		StandardProduct.StandardProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		StandardProduct.StandardProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		StandardProduct.StandardProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		StandardProduct.StandardProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		StandardProduct.StandardProductBuilder addProductType(ProductType productType);
		@Override
		StandardProduct.StandardProductBuilder addProductType(ProductType productType, int idx);
		@Override
		StandardProduct.StandardProductBuilder addProductType(List<? extends ProductType> productType);
		@Override
		StandardProduct.StandardProductBuilder setProductType(List<? extends ProductType> productType);
		@Override
		StandardProduct.StandardProductBuilder addProductId(ProductId productId);
		@Override
		StandardProduct.StandardProductBuilder addProductId(ProductId productId, int idx);
		@Override
		StandardProduct.StandardProductBuilder addProductId(List<? extends ProductId> productId);
		@Override
		StandardProduct.StandardProductBuilder setProductId(List<? extends ProductId> productId);
		@Override
		StandardProduct.StandardProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		StandardProduct.StandardProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		StandardProduct.StandardProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		StandardProduct.StandardProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		StandardProduct.StandardProductBuilder addAssetClass(AssetClass assetClass);
		@Override
		StandardProduct.StandardProductBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		StandardProduct.StandardProductBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		StandardProduct.StandardProductBuilder setAssetClass(List<? extends AssetClass> assetClass);
		StandardProduct.StandardProductBuilder setNotional(CashflowNotional notional);
		StandardProduct.StandardProductBuilder addQuote(BasicQuotation quote);
		StandardProduct.StandardProductBuilder addQuote(BasicQuotation quote, int idx);
		StandardProduct.StandardProductBuilder addQuote(List<? extends BasicQuotation> quote);
		StandardProduct.StandardProductBuilder setQuote(List<? extends BasicQuotation> quote);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("notional"), processor, CashflowNotional.CashflowNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
		}
		

		StandardProduct.StandardProductBuilder prune();
	}

	/*********************** Immutable Implementation of StandardProduct  ***********************/
	class StandardProductImpl extends Product.ProductImpl implements StandardProduct {
		private final CashflowNotional notional;
		private final List<? extends BasicQuotation> quote;
		
		protected StandardProductImpl(StandardProduct.StandardProductBuilder builder) {
			super(builder);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public CashflowNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		public StandardProduct build() {
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder toBuilder() {
			StandardProduct.StandardProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StandardProduct.StandardProductBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StandardProduct _that = getType().cast(o);
		
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardProduct {" +
				"notional=" + this.notional + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StandardProduct  ***********************/
	class StandardProductBuilderImpl extends Product.ProductBuilderImpl implements StandardProduct.StandardProductBuilder {
	
		protected CashflowNotional.CashflowNotionalBuilder notional;
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public CashflowNotional.CashflowNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder getOrCreateNotional() {
			CashflowNotional.CashflowNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = CashflowNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public StandardProduct.StandardProductBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public StandardProduct.StandardProductBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public StandardProduct.StandardProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public StandardProduct.StandardProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public StandardProduct.StandardProductBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public StandardProduct.StandardProductBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public StandardProduct.StandardProductBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addProductId(List<? extends ProductId> productIds) {
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
		public StandardProduct.StandardProductBuilder setProductId(List<? extends ProductId> productIds) {
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
		public StandardProduct.StandardProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public StandardProduct.StandardProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public StandardProduct.StandardProductBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public StandardProduct.StandardProductBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public StandardProduct.StandardProductBuilder setNotional(CashflowNotional _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public StandardProduct.StandardProductBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public StandardProduct.StandardProductBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public StandardProduct build() {
			return new StandardProduct.StandardProductImpl(this);
		}
		
		@Override
		public StandardProduct.StandardProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardProduct.StandardProductBuilder prune() {
			super.prune();
			if (notional!=null && !notional.prune().hasData()) notional = null;
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardProduct.StandardProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			StandardProduct.StandardProductBuilder o = (StandardProduct.StandardProductBuilder) other;
			
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StandardProduct _that = getType().cast(o);
		
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardProductBuilder {" +
				"notional=" + this.notional + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}
}
