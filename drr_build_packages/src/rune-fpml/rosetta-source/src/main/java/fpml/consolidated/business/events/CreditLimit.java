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
import fpml.consolidated.business.events.meta.CreditLimitMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.time.ZonedDateTime;
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
 * Provision A structure describing a credit limit with applicability constraints.
 *
 */
@RosettaDataType(value="CreditLimit", builder=CreditLimit.CreditLimitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditLimit", model="fpml", builder=CreditLimit.CreditLimitBuilderImpl.class, version="2.1.1")
public interface CreditLimit extends CreditLimitBase {

	CreditLimitMeta metaData = new CreditLimitMeta();

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
	List<? extends LimitApplicable> getLimitApplicable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getExpirationDate();

	/*********************** Build Methods  ***********************/
	CreditLimit build();
	
	CreditLimit.CreditLimitBuilder toBuilder();
	
	static CreditLimit.CreditLimitBuilder builder() {
		return new CreditLimit.CreditLimitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditLimit> getType() {
		return CreditLimit.class;
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
		processRosetta(path.newSubPath("limitApplicable"), processor, LimitApplicable.class, getLimitApplicable());
		processor.processBasic(path.newSubPath("expirationDate"), ZonedDateTime.class, getExpirationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitBuilder extends CreditLimit, CreditLimitBase.CreditLimitBaseBuilder {
		LimitApplicable.LimitApplicableBuilder getOrCreateLimitApplicable(int index);
		@Override
		List<? extends LimitApplicable.LimitApplicableBuilder> getLimitApplicable();
		@Override
		CreditLimit.CreditLimitBuilder setLimitId(LimitId limitId);
		@Override
		CreditLimit.CreditLimitBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CreditLimit.CreditLimitBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CreditLimit.CreditLimitBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CreditLimit.CreditLimitBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CreditLimit.CreditLimitBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CreditLimit.CreditLimitBuilder addProductType(ProductType productType);
		@Override
		CreditLimit.CreditLimitBuilder addProductType(ProductType productType, int idx);
		@Override
		CreditLimit.CreditLimitBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CreditLimit.CreditLimitBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CreditLimit.CreditLimitBuilder addProductId(ProductId productId);
		@Override
		CreditLimit.CreditLimitBuilder addProductId(ProductId productId, int idx);
		@Override
		CreditLimit.CreditLimitBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CreditLimit.CreditLimitBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CreditLimit.CreditLimitBuilder addAssetClass(AssetClass assetClass);
		@Override
		CreditLimit.CreditLimitBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CreditLimit.CreditLimitBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CreditLimit.CreditLimitBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CreditLimit.CreditLimitBuilder setCurrency(Currency currency);
		@Override
		CreditLimit.CreditLimitBuilder setTenor(Period tenor);
		CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable limitApplicable);
		CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable limitApplicable, int idx);
		CreditLimit.CreditLimitBuilder addLimitApplicable(List<? extends LimitApplicable> limitApplicable);
		CreditLimit.CreditLimitBuilder setLimitApplicable(List<? extends LimitApplicable> limitApplicable);
		CreditLimit.CreditLimitBuilder setExpirationDate(ZonedDateTime expirationDate);

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
			processRosetta(path.newSubPath("limitApplicable"), processor, LimitApplicable.LimitApplicableBuilder.class, getLimitApplicable());
			processor.processBasic(path.newSubPath("expirationDate"), ZonedDateTime.class, getExpirationDate(), this);
		}
		

		CreditLimit.CreditLimitBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimit  ***********************/
	class CreditLimitImpl extends CreditLimitBase.CreditLimitBaseImpl implements CreditLimit {
		private final List<? extends LimitApplicable> limitApplicable;
		private final ZonedDateTime expirationDate;
		
		protected CreditLimitImpl(CreditLimit.CreditLimitBuilder builder) {
			super(builder);
			this.limitApplicable = ofNullable(builder.getLimitApplicable()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.expirationDate = builder.getExpirationDate();
		}
		
		@Override
		@RosettaAttribute("limitApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("limitApplicable")
		public List<? extends LimitApplicable> getLimitApplicable() {
			return limitApplicable;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public ZonedDateTime getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public CreditLimit build() {
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder toBuilder() {
			CreditLimit.CreditLimitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimit.CreditLimitBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLimitApplicable()).ifPresent(builder::setLimitApplicable);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditLimit _that = getType().cast(o);
		
			if (!ListEquals.listEquals(limitApplicable, _that.getLimitApplicable())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitApplicable != null ? limitApplicable.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimit {" +
				"limitApplicable=" + this.limitApplicable + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditLimit  ***********************/
	class CreditLimitBuilderImpl extends CreditLimitBase.CreditLimitBaseBuilderImpl implements CreditLimit.CreditLimitBuilder {
	
		protected List<LimitApplicable.LimitApplicableBuilder> limitApplicable = new ArrayList<>();
		protected ZonedDateTime expirationDate;
		
		@Override
		@RosettaAttribute("limitApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("limitApplicable")
		public List<? extends LimitApplicable.LimitApplicableBuilder> getLimitApplicable() {
			return limitApplicable;
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder getOrCreateLimitApplicable(int index) {
			if (limitApplicable==null) {
				this.limitApplicable = new ArrayList<>();
			}
			return getIndex(limitApplicable, index, () -> {
						LimitApplicable.LimitApplicableBuilder newLimitApplicable = LimitApplicable.builder();
						return newLimitApplicable;
					});
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public ZonedDateTime getExpirationDate() {
			return expirationDate;
		}
		
		@RosettaAttribute("limitId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("limitId")
		@Override
		public CreditLimit.CreditLimitBuilder setLimitId(LimitId _limitId) {
			this.limitId = _limitId == null ? null : _limitId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CreditLimit.CreditLimitBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CreditLimit.CreditLimitBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditLimit.CreditLimitBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditLimit.CreditLimitBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CreditLimit.CreditLimitBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CreditLimit.CreditLimitBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CreditLimit.CreditLimitBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CreditLimit.CreditLimitBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CreditLimit.CreditLimitBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CreditLimit.CreditLimitBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tenor")
		@Override
		public CreditLimit.CreditLimitBuilder setTenor(Period _tenor) {
			this.tenor = _tenor == null ? null : _tenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("limitApplicable")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("limitApplicable")
		@Override
		public CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable _limitApplicable) {
			if (_limitApplicable != null) {
				this.limitApplicable.add(_limitApplicable.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable _limitApplicable, int idx) {
			getIndex(this.limitApplicable, idx, () -> _limitApplicable.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addLimitApplicable(List<? extends LimitApplicable> limitApplicables) {
			if (limitApplicables != null) {
				for (final LimitApplicable toAdd : limitApplicables) {
					this.limitApplicable.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("limitApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("limitApplicable")
		@Override
		public CreditLimit.CreditLimitBuilder setLimitApplicable(List<? extends LimitApplicable> limitApplicables) {
			if (limitApplicables == null) {
				this.limitApplicable = new ArrayList<>();
			} else {
				this.limitApplicable = limitApplicables.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public CreditLimit.CreditLimitBuilder setExpirationDate(ZonedDateTime _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@Override
		public CreditLimit build() {
			return new CreditLimit.CreditLimitImpl(this);
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimit.CreditLimitBuilder prune() {
			super.prune();
			limitApplicable = limitApplicable.stream().filter(b->b!=null).<LimitApplicable.LimitApplicableBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLimitApplicable()!=null && getLimitApplicable().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExpirationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimit.CreditLimitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditLimit.CreditLimitBuilder o = (CreditLimit.CreditLimitBuilder) other;
			
			merger.mergeRosetta(getLimitApplicable(), o.getLimitApplicable(), this::getOrCreateLimitApplicable);
			
			merger.mergeBasic(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditLimit _that = getType().cast(o);
		
			if (!ListEquals.listEquals(limitApplicable, _that.getLimitApplicable())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitApplicable != null ? limitApplicable.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitBuilder {" +
				"limitApplicable=" + this.limitApplicable + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}
}
