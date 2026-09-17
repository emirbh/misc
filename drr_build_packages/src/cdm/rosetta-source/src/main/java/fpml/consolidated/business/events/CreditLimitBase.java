package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CreditLimitBaseMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Period;
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
 * version "confirmation-5.13"
 *
 * Provision A structure describing a basic credit limit.
 *
 */
@RosettaDataType(value="CreditLimitBase", builder=CreditLimitBase.CreditLimitBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditLimitBase", model="fpml", builder=CreditLimitBase.CreditLimitBaseBuilderImpl.class, version="2.1.1")
public interface CreditLimitBase extends RosettaModelObject {

	CreditLimitBaseMeta metaData = new CreditLimitBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LimitId getLimitId();
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision A classification of the risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 */
	List<? extends AssetClass> getAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum allowed tenor for a trade under this limit. When this structure is used as part of a suspendCredit message, this tenor imposes a temporary tenor limit on allowed trade types.
	 *
	 */
	Period getTenor();

	/*********************** Build Methods  ***********************/
	CreditLimitBase build();
	
	CreditLimitBase.CreditLimitBaseBuilder toBuilder();
	
	static CreditLimitBase.CreditLimitBaseBuilder builder() {
		return new CreditLimitBase.CreditLimitBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditLimitBase> getType() {
		return CreditLimitBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("limitId"), processor, LimitId.class, getLimitId());
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitBaseBuilder extends CreditLimitBase, RosettaModelObjectBuilder {
		LimitId.LimitIdBuilder getOrCreateLimitId();
		@Override
		LimitId.LimitIdBuilder getLimitId();
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
		AssetClass.AssetClassBuilder getOrCreateAssetClass(int index);
		@Override
		List<? extends AssetClass.AssetClassBuilder> getAssetClass();
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		Period.PeriodBuilder getOrCreateTenor();
		@Override
		Period.PeriodBuilder getTenor();
		CreditLimitBase.CreditLimitBaseBuilder setLimitId(LimitId limitId);
		CreditLimitBase.CreditLimitBaseBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		CreditLimitBase.CreditLimitBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		CreditLimitBase.CreditLimitBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		CreditLimitBase.CreditLimitBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		CreditLimitBase.CreditLimitBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		CreditLimitBase.CreditLimitBaseBuilder addProductType(ProductType productType);
		CreditLimitBase.CreditLimitBaseBuilder addProductType(ProductType productType, int idx);
		CreditLimitBase.CreditLimitBaseBuilder addProductType(List<? extends ProductType> productType);
		CreditLimitBase.CreditLimitBaseBuilder setProductType(List<? extends ProductType> productType);
		CreditLimitBase.CreditLimitBaseBuilder addProductId(ProductId productId);
		CreditLimitBase.CreditLimitBaseBuilder addProductId(ProductId productId, int idx);
		CreditLimitBase.CreditLimitBaseBuilder addProductId(List<? extends ProductId> productId);
		CreditLimitBase.CreditLimitBaseBuilder setProductId(List<? extends ProductId> productId);
		CreditLimitBase.CreditLimitBaseBuilder addAssetClass(AssetClass assetClass);
		CreditLimitBase.CreditLimitBaseBuilder addAssetClass(AssetClass assetClass, int idx);
		CreditLimitBase.CreditLimitBaseBuilder addAssetClass(List<? extends AssetClass> assetClass);
		CreditLimitBase.CreditLimitBaseBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CreditLimitBase.CreditLimitBaseBuilder setCurrency(Currency currency);
		CreditLimitBase.CreditLimitBaseBuilder setTenor(Period tenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("limitId"), processor, LimitId.LimitIdBuilder.class, getLimitId());
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
		}
		

		CreditLimitBase.CreditLimitBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitBase  ***********************/
	class CreditLimitBaseImpl implements CreditLimitBase {
		private final LimitId limitId;
		private final AssetClass primaryAssetClass;
		private final List<? extends AssetClass> secondaryAssetClass;
		private final List<? extends ProductType> productType;
		private final List<? extends ProductId> productId;
		private final List<? extends AssetClass> assetClass;
		private final Currency currency;
		private final Period tenor;
		
		protected CreditLimitBaseImpl(CreditLimitBase.CreditLimitBaseBuilder builder) {
			this.limitId = ofNullable(builder.getLimitId()).map(f->f.build()).orElse(null);
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.secondaryAssetClass = ofNullable(builder.getSecondaryAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productType = ofNullable(builder.getProductType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productId = ofNullable(builder.getProductId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.assetClass = ofNullable(builder.getAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.tenor = ofNullable(builder.getTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("limitId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("limitId")
		public LimitId getLimitId() {
			return limitId;
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
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetClass")
		public List<? extends AssetClass> getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tenor")
		public Period getTenor() {
			return tenor;
		}
		
		@Override
		public CreditLimitBase build() {
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder toBuilder() {
			CreditLimitBase.CreditLimitBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitBase.CreditLimitBaseBuilder builder) {
			ofNullable(getLimitId()).ifPresent(builder::setLimitId);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getSecondaryAssetClass()).ifPresent(builder::setSecondaryAssetClass);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getProductId()).ifPresent(builder::setProductId);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getTenor()).ifPresent(builder::setTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitBase _that = getType().cast(o);
		
			if (!Objects.equals(limitId, _that.getLimitId())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!ListEquals.listEquals(productId, _that.getProductId())) return false;
			if (!ListEquals.listEquals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitId != null ? limitId.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitBase {" +
				"limitId=" + this.limitId + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId + ", " +
				"assetClass=" + this.assetClass + ", " +
				"currency=" + this.currency + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitBase  ***********************/
	class CreditLimitBaseBuilderImpl implements CreditLimitBase.CreditLimitBaseBuilder {
	
		protected LimitId.LimitIdBuilder limitId;
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected List<AssetClass.AssetClassBuilder> secondaryAssetClass = new ArrayList<>();
		protected List<ProductType.ProductTypeBuilder> productType = new ArrayList<>();
		protected List<ProductId.ProductIdBuilder> productId = new ArrayList<>();
		protected List<AssetClass.AssetClassBuilder> assetClass = new ArrayList<>();
		protected Currency.CurrencyBuilder currency;
		protected Period.PeriodBuilder tenor;
		
		@Override
		@RosettaAttribute("limitId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("limitId")
		public LimitId.LimitIdBuilder getLimitId() {
			return limitId;
		}
		
		@Override
		public LimitId.LimitIdBuilder getOrCreateLimitId() {
			LimitId.LimitIdBuilder result;
			if (limitId!=null) {
				result = limitId;
			}
			else {
				result = limitId = LimitId.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tenor")
		public Period.PeriodBuilder getTenor() {
			return tenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenor() {
			Period.PeriodBuilder result;
			if (tenor!=null) {
				result = tenor;
			}
			else {
				result = tenor = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("limitId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("limitId")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder setLimitId(LimitId _limitId) {
			this.limitId = _limitId == null ? null : _limitId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditLimitBase.CreditLimitBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditLimitBase.CreditLimitBaseBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CreditLimitBase.CreditLimitBaseBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CreditLimitBase.CreditLimitBaseBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CreditLimitBase.CreditLimitBaseBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
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
		public CreditLimitBase.CreditLimitBaseBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CreditLimitBase.CreditLimitBaseBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tenor")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder setTenor(Period _tenor) {
			this.tenor = _tenor == null ? null : _tenor.toBuilder();
			return this;
		}
		
		@Override
		public CreditLimitBase build() {
			return new CreditLimitBase.CreditLimitBaseImpl(this);
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder prune() {
			if (limitId!=null && !limitId.prune().hasData()) limitId = null;
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			secondaryAssetClass = secondaryAssetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productType = productType.stream().filter(b->b!=null).<ProductType.ProductTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productId = productId.stream().filter(b->b!=null).<ProductId.ProductIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			assetClass = assetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (tenor!=null && !tenor.prune().hasData()) tenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLimitId()!=null && getLimitId().hasData()) return true;
			if (getPrimaryAssetClass()!=null && getPrimaryAssetClass().hasData()) return true;
			if (getSecondaryAssetClass()!=null && getSecondaryAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductType()!=null && getProductType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductId()!=null && getProductId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAssetClass()!=null && getAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getTenor()!=null && getTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitBase.CreditLimitBaseBuilder o = (CreditLimitBase.CreditLimitBaseBuilder) other;
			
			merger.mergeRosetta(getLimitId(), o.getLimitId(), this::setLimitId);
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getSecondaryAssetClass(), o.getSecondaryAssetClass(), this::getOrCreateSecondaryAssetClass);
			merger.mergeRosetta(getProductType(), o.getProductType(), this::getOrCreateProductType);
			merger.mergeRosetta(getProductId(), o.getProductId(), this::getOrCreateProductId);
			merger.mergeRosetta(getAssetClass(), o.getAssetClass(), this::getOrCreateAssetClass);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getTenor(), o.getTenor(), this::setTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitBase _that = getType().cast(o);
		
			if (!Objects.equals(limitId, _that.getLimitId())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!ListEquals.listEquals(productId, _that.getProductId())) return false;
			if (!ListEquals.listEquals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitId != null ? limitId.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitBaseBuilder {" +
				"limitId=" + this.limitId + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId + ", " +
				"assetClass=" + this.assetClass + ", " +
				"currency=" + this.currency + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}
}
