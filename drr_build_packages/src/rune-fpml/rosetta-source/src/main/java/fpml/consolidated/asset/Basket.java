package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.BasketMeta;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
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
 * Provision A type describing the underlyer features of a basket swap. Each of the basket constituents are described through an embedded component, the basketConstituentsType.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the underlyer features of a basket swap. Each of the basket constituents are described through an embedded component, the basketConstituentsType.
 *
 */
@RosettaDataType(value="Basket", builder=Basket.BasketBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Basket", model="fpml", builder=Basket.BasketBuilderImpl.class, version="2.1.1")
public interface Basket extends Asset {

	BasketMeta metaData = new BasketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 *
	 */
	BigDecimal getOpenUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes each of the components of the basket.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes each of the components of the basket.
	 *
	 */
	List<? extends BasketConstituent> getBasketConstituent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the basket divisor amount. This value is normally used to adjust the constituent weight for pricing or to adjust for dividends, or other corporate actions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the basket divisor amount. This value is normally used to adjust the constituent weight for pricing or to adjust for dividends, or other corporate actions.
	 *
	 */
	BigDecimal getBasketDivisor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Basket version, used to record changes in basket composition or weights
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Basket version, used to record changes in basket composition or weights
	 *
	 */
	Integer getBasketVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 *
	 */
	BasketName getBasketName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A basket identifier
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A basket identifier
	 *
	 */
	List<? extends BasketId> getBasketId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the currency for this basket.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the currency for this basket.
	 *
	 */
	Currency getBasketCurrency();

	/*********************** Build Methods  ***********************/
	Basket build();
	
	Basket.BasketBuilder toBuilder();
	
	static Basket.BasketBuilder builder() {
		return new Basket.BasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Basket> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Basket> getType() {
		return Basket.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
		processRosetta(path.newSubPath("basketConstituent"), processor, BasketConstituent.class, getBasketConstituent());
		processor.processBasic(path.newSubPath("basketDivisor"), BigDecimal.class, getBasketDivisor(), this);
		processor.processBasic(path.newSubPath("basketVersion"), Integer.class, getBasketVersion(), this);
		processRosetta(path.newSubPath("basketName"), processor, BasketName.class, getBasketName());
		processRosetta(path.newSubPath("basketId"), processor, BasketId.class, getBasketId());
		processRosetta(path.newSubPath("basketCurrency"), processor, Currency.class, getBasketCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketBuilder extends Basket, Asset.AssetBuilder {
		BasketConstituent.BasketConstituentBuilder getOrCreateBasketConstituent(int index);
		@Override
		List<? extends BasketConstituent.BasketConstituentBuilder> getBasketConstituent();
		BasketName.BasketNameBuilder getOrCreateBasketName();
		@Override
		BasketName.BasketNameBuilder getBasketName();
		BasketId.BasketIdBuilder getOrCreateBasketId(int index);
		@Override
		List<? extends BasketId.BasketIdBuilder> getBasketId();
		Currency.CurrencyBuilder getOrCreateBasketCurrency();
		@Override
		Currency.CurrencyBuilder getBasketCurrency();
		@Override
		Basket.BasketBuilder setId(String id);
		Basket.BasketBuilder setOpenUnits(BigDecimal openUnits);
		Basket.BasketBuilder addBasketConstituent(BasketConstituent basketConstituent);
		Basket.BasketBuilder addBasketConstituent(BasketConstituent basketConstituent, int idx);
		Basket.BasketBuilder addBasketConstituent(List<? extends BasketConstituent> basketConstituent);
		Basket.BasketBuilder setBasketConstituent(List<? extends BasketConstituent> basketConstituent);
		Basket.BasketBuilder setBasketDivisor(BigDecimal basketDivisor);
		Basket.BasketBuilder setBasketVersion(Integer basketVersion);
		Basket.BasketBuilder setBasketName(BasketName basketName);
		Basket.BasketBuilder addBasketId(BasketId basketId);
		Basket.BasketBuilder addBasketId(BasketId basketId, int idx);
		Basket.BasketBuilder addBasketId(List<? extends BasketId> basketId);
		Basket.BasketBuilder setBasketId(List<? extends BasketId> basketId);
		Basket.BasketBuilder setBasketCurrency(Currency basketCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
			processRosetta(path.newSubPath("basketConstituent"), processor, BasketConstituent.BasketConstituentBuilder.class, getBasketConstituent());
			processor.processBasic(path.newSubPath("basketDivisor"), BigDecimal.class, getBasketDivisor(), this);
			processor.processBasic(path.newSubPath("basketVersion"), Integer.class, getBasketVersion(), this);
			processRosetta(path.newSubPath("basketName"), processor, BasketName.BasketNameBuilder.class, getBasketName());
			processRosetta(path.newSubPath("basketId"), processor, BasketId.BasketIdBuilder.class, getBasketId());
			processRosetta(path.newSubPath("basketCurrency"), processor, Currency.CurrencyBuilder.class, getBasketCurrency());
		}
		

		Basket.BasketBuilder prune();
	}

	/*********************** Immutable Implementation of Basket  ***********************/
	class BasketImpl extends Asset.AssetImpl implements Basket {
		private final BigDecimal openUnits;
		private final List<? extends BasketConstituent> basketConstituent;
		private final BigDecimal basketDivisor;
		private final Integer basketVersion;
		private final BasketName basketName;
		private final List<? extends BasketId> basketId;
		private final Currency basketCurrency;
		
		protected BasketImpl(Basket.BasketBuilder builder) {
			super(builder);
			this.openUnits = builder.getOpenUnits();
			this.basketConstituent = ofNullable(builder.getBasketConstituent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.basketDivisor = builder.getBasketDivisor();
			this.basketVersion = builder.getBasketVersion();
			this.basketName = ofNullable(builder.getBasketName()).map(f->f.build()).orElse(null);
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.basketCurrency = ofNullable(builder.getBasketCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		public List<? extends BasketConstituent> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		@RosettaAttribute("basketDivisor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketDivisor")
		public BigDecimal getBasketDivisor() {
			return basketDivisor;
		}
		
		@Override
		@RosettaAttribute("basketVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketVersion")
		public Integer getBasketVersion() {
			return basketVersion;
		}
		
		@Override
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketName")
		public BasketName getBasketName() {
			return basketName;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketId")
		public List<? extends BasketId> getBasketId() {
			return basketId;
		}
		
		@Override
		@RosettaAttribute("basketCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketCurrency")
		public Currency getBasketCurrency() {
			return basketCurrency;
		}
		
		@Override
		public Basket build() {
			return this;
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			Basket.BasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Basket.BasketBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOpenUnits()).ifPresent(builder::setOpenUnits);
			ofNullable(getBasketConstituent()).ifPresent(builder::setBasketConstituent);
			ofNullable(getBasketDivisor()).ifPresent(builder::setBasketDivisor);
			ofNullable(getBasketVersion()).ifPresent(builder::setBasketVersion);
			ofNullable(getBasketName()).ifPresent(builder::setBasketName);
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
			ofNullable(getBasketCurrency()).ifPresent(builder::setBasketCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			if (!Objects.equals(basketDivisor, _that.getBasketDivisor())) return false;
			if (!Objects.equals(basketVersion, _that.getBasketVersion())) return false;
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(basketCurrency, _that.getBasketCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			_result = 31 * _result + (basketDivisor != null ? basketDivisor.hashCode() : 0);
			_result = 31 * _result + (basketVersion != null ? basketVersion.hashCode() : 0);
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (basketCurrency != null ? basketCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Basket {" +
				"openUnits=" + this.openUnits + ", " +
				"basketConstituent=" + this.basketConstituent + ", " +
				"basketDivisor=" + this.basketDivisor + ", " +
				"basketVersion=" + this.basketVersion + ", " +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"basketCurrency=" + this.basketCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Basket  ***********************/
	class BasketBuilderImpl extends Asset.AssetBuilderImpl implements Basket.BasketBuilder {
	
		protected BigDecimal openUnits;
		protected List<BasketConstituent.BasketConstituentBuilder> basketConstituent = new ArrayList<>();
		protected BigDecimal basketDivisor;
		protected Integer basketVersion;
		protected BasketName.BasketNameBuilder basketName;
		protected List<BasketId.BasketIdBuilder> basketId = new ArrayList<>();
		protected Currency.CurrencyBuilder basketCurrency;
		
		@Override
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		public List<? extends BasketConstituent.BasketConstituentBuilder> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder getOrCreateBasketConstituent(int index) {
			if (basketConstituent==null) {
				this.basketConstituent = new ArrayList<>();
			}
			return getIndex(basketConstituent, index, () -> {
						BasketConstituent.BasketConstituentBuilder newBasketConstituent = BasketConstituent.builder();
						return newBasketConstituent;
					});
		}
		
		@Override
		@RosettaAttribute("basketDivisor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketDivisor")
		public BigDecimal getBasketDivisor() {
			return basketDivisor;
		}
		
		@Override
		@RosettaAttribute("basketVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketVersion")
		public Integer getBasketVersion() {
			return basketVersion;
		}
		
		@Override
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketName")
		public BasketName.BasketNameBuilder getBasketName() {
			return basketName;
		}
		
		@Override
		public BasketName.BasketNameBuilder getOrCreateBasketName() {
			BasketName.BasketNameBuilder result;
			if (basketName!=null) {
				result = basketName;
			}
			else {
				result = basketName = BasketName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketId")
		public List<? extends BasketId.BasketIdBuilder> getBasketId() {
			return basketId;
		}
		
		@Override
		public BasketId.BasketIdBuilder getOrCreateBasketId(int index) {
			if (basketId==null) {
				this.basketId = new ArrayList<>();
			}
			return getIndex(basketId, index, () -> {
						BasketId.BasketIdBuilder newBasketId = BasketId.builder();
						return newBasketId;
					});
		}
		
		@Override
		@RosettaAttribute("basketCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketCurrency")
		public Currency.CurrencyBuilder getBasketCurrency() {
			return basketCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateBasketCurrency() {
			Currency.CurrencyBuilder result;
			if (basketCurrency!=null) {
				result = basketCurrency;
			}
			else {
				result = basketCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Basket.BasketBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("openUnits")
		@Override
		public Basket.BasketBuilder setOpenUnits(BigDecimal _openUnits) {
			this.openUnits = _openUnits == null ? null : _openUnits;
			return this;
		}
		
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		@Override
		public Basket.BasketBuilder addBasketConstituent(BasketConstituent _basketConstituent) {
			if (_basketConstituent != null) {
				this.basketConstituent.add(_basketConstituent.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(BasketConstituent _basketConstituent, int idx) {
			getIndex(this.basketConstituent, idx, () -> _basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (final BasketConstituent toAdd : basketConstituents) {
					this.basketConstituent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		@Override
		public Basket.BasketBuilder setBasketConstituent(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents == null) {
				this.basketConstituent = new ArrayList<>();
			} else {
				this.basketConstituent = basketConstituents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("basketDivisor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketDivisor")
		@Override
		public Basket.BasketBuilder setBasketDivisor(BigDecimal _basketDivisor) {
			this.basketDivisor = _basketDivisor == null ? null : _basketDivisor;
			return this;
		}
		
		@RosettaAttribute("basketVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketVersion")
		@Override
		public Basket.BasketBuilder setBasketVersion(Integer _basketVersion) {
			this.basketVersion = _basketVersion == null ? null : _basketVersion;
			return this;
		}
		
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketName")
		@Override
		public Basket.BasketBuilder setBasketName(BasketName _basketName) {
			this.basketName = _basketName == null ? null : _basketName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketId")
		@Override
		public Basket.BasketBuilder addBasketId(BasketId _basketId) {
			if (_basketId != null) {
				this.basketId.add(_basketId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketId(BasketId _basketId, int idx) {
			getIndex(this.basketId, idx, () -> _basketId.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketId(List<? extends BasketId> basketIds) {
			if (basketIds != null) {
				for (final BasketId toAdd : basketIds) {
					this.basketId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketId")
		@Override
		public Basket.BasketBuilder setBasketId(List<? extends BasketId> basketIds) {
			if (basketIds == null) {
				this.basketId = new ArrayList<>();
			} else {
				this.basketId = basketIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("basketCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketCurrency")
		@Override
		public Basket.BasketBuilder setBasketCurrency(Currency _basketCurrency) {
			this.basketCurrency = _basketCurrency == null ? null : _basketCurrency.toBuilder();
			return this;
		}
		
		@Override
		public Basket build() {
			return new Basket.BasketImpl(this);
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder prune() {
			super.prune();
			basketConstituent = basketConstituent.stream().filter(b->b!=null).<BasketConstituent.BasketConstituentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (basketName!=null && !basketName.prune().hasData()) basketName = null;
			basketId = basketId.stream().filter(b->b!=null).<BasketId.BasketIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (basketCurrency!=null && !basketCurrency.prune().hasData()) basketCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOpenUnits()!=null) return true;
			if (getBasketConstituent()!=null && getBasketConstituent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBasketDivisor()!=null) return true;
			if (getBasketVersion()!=null) return true;
			if (getBasketName()!=null && getBasketName().hasData()) return true;
			if (getBasketId()!=null && getBasketId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBasketCurrency()!=null && getBasketCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Basket.BasketBuilder o = (Basket.BasketBuilder) other;
			
			merger.mergeRosetta(getBasketConstituent(), o.getBasketConstituent(), this::getOrCreateBasketConstituent);
			merger.mergeRosetta(getBasketName(), o.getBasketName(), this::setBasketName);
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			merger.mergeRosetta(getBasketCurrency(), o.getBasketCurrency(), this::setBasketCurrency);
			
			merger.mergeBasic(getOpenUnits(), o.getOpenUnits(), this::setOpenUnits);
			merger.mergeBasic(getBasketDivisor(), o.getBasketDivisor(), this::setBasketDivisor);
			merger.mergeBasic(getBasketVersion(), o.getBasketVersion(), this::setBasketVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			if (!Objects.equals(basketDivisor, _that.getBasketDivisor())) return false;
			if (!Objects.equals(basketVersion, _that.getBasketVersion())) return false;
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(basketCurrency, _that.getBasketCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			_result = 31 * _result + (basketDivisor != null ? basketDivisor.hashCode() : 0);
			_result = 31 * _result + (basketVersion != null ? basketVersion.hashCode() : 0);
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (basketCurrency != null ? basketCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketBuilder {" +
				"openUnits=" + this.openUnits + ", " +
				"basketConstituent=" + this.basketConstituent + ", " +
				"basketDivisor=" + this.basketDivisor + ", " +
				"basketVersion=" + this.basketVersion + ", " +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"basketCurrency=" + this.basketCurrency +
			'}' + " " + super.toString();
		}
	}
}
