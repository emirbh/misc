package cdm.observable.asset;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.meta.PriceQuantityMeta;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.annotations.RuneScopedAttributeKey;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a settlement as an exchange between two parties of a specified quantity of an asset (the quantity) against a specified quantity of another asset (the price). The settlement is optional and can be either cash or physical. The quantity can additionally be specified in terms of one or more currency amounts. In the case of non-cash products, the settlement of the price/quantity would not be specified here and instead would be delegated to the product mechanics, as parameterised by the price/quantity values.
 * @version 6.23.0
 */
@RosettaDataType(value="PriceQuantity", builder=PriceQuantity.PriceQuantityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PriceQuantity", model="cdm", builder=PriceQuantity.PriceQuantityBuilderImpl.class, version="6.23.0")
public interface PriceQuantity extends RosettaModelObject, GlobalKey {

	PriceQuantityMeta metaData = new PriceQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a price to be used for trade amounts and other purposes.
	 */
	List<? extends FieldWithMetaPriceSchedule> getPrice();
	/**
	 * Specifies a quantity to be associated with an event, for example a trade amount.
	 */
	List<? extends FieldWithMetaNonNegativeQuantitySchedule> getQuantity();
	/**
	 * Specifies the object to be observed for a price, it could be an asset or an index. The cardinality is optional as some quantity / price cases have no observable (e.g. a fixed rate in a given currency).
	 */
	FieldWithMetaObservable getObservable();
	/**
	 * Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	PriceQuantity build();
	
	PriceQuantity.PriceQuantityBuilder toBuilder();
	
	static PriceQuantity.PriceQuantityBuilder builder() {
		return new PriceQuantity.PriceQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceQuantity> getType() {
		return PriceQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("price"), processor, FieldWithMetaPriceSchedule.class, getPrice());
		processRosetta(path.newSubPath("quantity"), processor, FieldWithMetaNonNegativeQuantitySchedule.class, getQuantity());
		processRosetta(path.newSubPath("observable"), processor, FieldWithMetaObservable.class, getObservable());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceQuantityBuilder extends PriceQuantity, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder getOrCreatePrice(int index);
		@Override
		List<? extends FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> getPrice();
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder getOrCreateQuantity(int index);
		@Override
		List<? extends FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> getQuantity();
		FieldWithMetaObservable.FieldWithMetaObservableBuilder getOrCreateObservable();
		@Override
		FieldWithMetaObservable.FieldWithMetaObservableBuilder getObservable();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPriceSchedule price);
		PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPriceSchedule price, int idx);
		PriceQuantity.PriceQuantityBuilder addPriceValue(PriceSchedule price);
		PriceQuantity.PriceQuantityBuilder addPriceValue(PriceSchedule price, int idx);
		PriceQuantity.PriceQuantityBuilder addPrice(List<? extends FieldWithMetaPriceSchedule> price);
		PriceQuantity.PriceQuantityBuilder setPrice(List<? extends FieldWithMetaPriceSchedule> price);
		PriceQuantity.PriceQuantityBuilder addPriceValue(List<? extends PriceSchedule> price);
		PriceQuantity.PriceQuantityBuilder setPriceValue(List<? extends PriceSchedule> price);
		PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaNonNegativeQuantitySchedule quantity);
		PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaNonNegativeQuantitySchedule quantity, int idx);
		PriceQuantity.PriceQuantityBuilder addQuantityValue(NonNegativeQuantitySchedule quantity);
		PriceQuantity.PriceQuantityBuilder addQuantityValue(NonNegativeQuantitySchedule quantity, int idx);
		PriceQuantity.PriceQuantityBuilder addQuantity(List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantity);
		PriceQuantity.PriceQuantityBuilder setQuantity(List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantity);
		PriceQuantity.PriceQuantityBuilder addQuantityValue(List<? extends NonNegativeQuantitySchedule> quantity);
		PriceQuantity.PriceQuantityBuilder setQuantityValue(List<? extends NonNegativeQuantitySchedule> quantity);
		PriceQuantity.PriceQuantityBuilder setObservable(FieldWithMetaObservable observable);
		PriceQuantity.PriceQuantityBuilder setObservableValue(Observable observable);
		PriceQuantity.PriceQuantityBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		PriceQuantity.PriceQuantityBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("price"), processor, FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder.class, getPrice());
			processRosetta(path.newSubPath("quantity"), processor, FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder.class, getQuantity());
			processRosetta(path.newSubPath("observable"), processor, FieldWithMetaObservable.FieldWithMetaObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		PriceQuantity.PriceQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of PriceQuantity  ***********************/
	class PriceQuantityImpl implements PriceQuantity {
		private final List<? extends FieldWithMetaPriceSchedule> price;
		private final List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantity;
		private final FieldWithMetaObservable observable;
		private final AdjustableOrRelativeDate effectiveDate;
		private final MetaFields meta;
		
		protected PriceQuantityImpl(PriceQuantity.PriceQuantityBuilder builder) {
			this.price = ofNullable(builder.getPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.observable = ofNullable(builder.getObservable()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("price")
		@RuneScopedAttributeKey
		public List<? extends FieldWithMetaPriceSchedule> getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantity")
		@RuneScopedAttributeKey
		public List<? extends FieldWithMetaNonNegativeQuantitySchedule> getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("observable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observable")
		@RuneScopedAttributeKey
		public FieldWithMetaObservable getObservable() {
			return observable;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PriceQuantity build() {
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder toBuilder() {
			PriceQuantity.PriceQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceQuantity.PriceQuantityBuilder builder) {
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(price, _that.getPrice())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceQuantity {" +
				"price=" + this.price + ", " +
				"quantity=" + this.quantity + ", " +
				"observable=" + this.observable + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceQuantity  ***********************/
	class PriceQuantityBuilderImpl implements PriceQuantity.PriceQuantityBuilder {
	
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> price = new ArrayList<>();
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantity = new ArrayList<>();
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder observable;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("price")
		@RuneScopedAttributeKey
		public List<? extends FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> getPrice() {
			return price;
		}
		
		@Override
		public FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder getOrCreatePrice(int index) {
			if (price==null) {
				this.price = new ArrayList<>();
			}
			return getIndex(price, index, () -> {
						FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder newPrice = FieldWithMetaPriceSchedule.builder();
						newPrice.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newPrice;
					});
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantity")
		@RuneScopedAttributeKey
		public List<? extends FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> getQuantity() {
			return quantity;
		}
		
		@Override
		public FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder getOrCreateQuantity(int index) {
			if (quantity==null) {
				this.quantity = new ArrayList<>();
			}
			return getIndex(quantity, index, () -> {
						FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder newQuantity = FieldWithMetaNonNegativeQuantitySchedule.builder();
						newQuantity.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("observable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observable")
		@RuneScopedAttributeKey
		public FieldWithMetaObservable.FieldWithMetaObservableBuilder getObservable() {
			return observable;
		}
		
		@Override
		public FieldWithMetaObservable.FieldWithMetaObservableBuilder getOrCreateObservable() {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder result;
			if (observable!=null) {
				result = observable;
			}
			else {
				result = observable = FieldWithMetaObservable.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("price")
		@RuneScopedAttributeKey
		@Override
		public PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPriceSchedule _price) {
			if (_price != null) {
				this.price.add(_price.toBuilder());
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPriceSchedule _price, int idx) {
			getIndex(this.price, idx, () -> _price.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPriceValue(PriceSchedule _price) {
			this.getOrCreatePrice(-1).setValue(_price.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPriceValue(PriceSchedule _price, int idx) {
			this.getOrCreatePrice(idx).setValue(_price.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPrice(List<? extends FieldWithMetaPriceSchedule> prices) {
			if (prices != null) {
				for (final FieldWithMetaPriceSchedule toAdd : prices) {
					this.price.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("price")
		@RuneScopedAttributeKey
		@Override
		public PriceQuantity.PriceQuantityBuilder setPrice(List<? extends FieldWithMetaPriceSchedule> prices) {
			if (prices == null) {
				this.price = new ArrayList<>();
			} else {
				this.price = prices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPriceValue(List<? extends PriceSchedule> prices) {
			if (prices != null) {
				for (final PriceSchedule toAdd : prices) {
					this.addPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder setPriceValue(List<? extends PriceSchedule> prices) {
			this.price.clear();
			if (prices != null) {
				prices.forEach(this::addPriceValue);
			}
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quantity")
		@RuneScopedAttributeKey
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaNonNegativeQuantitySchedule _quantity) {
			if (_quantity != null) {
				this.quantity.add(_quantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaNonNegativeQuantitySchedule _quantity, int idx) {
			getIndex(this.quantity, idx, () -> _quantity.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantityValue(NonNegativeQuantitySchedule _quantity) {
			this.getOrCreateQuantity(-1).setValue(_quantity.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantityValue(NonNegativeQuantitySchedule _quantity, int idx) {
			this.getOrCreateQuantity(idx).setValue(_quantity.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantity(List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantitys) {
			if (quantitys != null) {
				for (final FieldWithMetaNonNegativeQuantitySchedule toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quantity")
		@RuneScopedAttributeKey
		@Override
		public PriceQuantity.PriceQuantityBuilder setQuantity(List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantitys) {
			if (quantitys == null) {
				this.quantity = new ArrayList<>();
			} else {
				this.quantity = quantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantityValue(List<? extends NonNegativeQuantitySchedule> quantitys) {
			if (quantitys != null) {
				for (final NonNegativeQuantitySchedule toAdd : quantitys) {
					this.addQuantityValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder setQuantityValue(List<? extends NonNegativeQuantitySchedule> quantitys) {
			this.quantity.clear();
			if (quantitys != null) {
				quantitys.forEach(this::addQuantityValue);
			}
			return this;
		}
		
		@RosettaAttribute("observable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observable")
		@RuneScopedAttributeKey
		@Override
		public PriceQuantity.PriceQuantityBuilder setObservable(FieldWithMetaObservable _observable) {
			this.observable = _observable == null ? null : _observable.toBuilder();
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder setObservableValue(Observable _observable) {
			this.getOrCreateObservable().setValue(_observable);
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public PriceQuantity.PriceQuantityBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public PriceQuantity.PriceQuantityBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public PriceQuantity build() {
			return new PriceQuantity.PriceQuantityImpl(this);
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceQuantity.PriceQuantityBuilder prune() {
			price = price.stream().filter(b->b!=null).<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			quantity = quantity.stream().filter(b->b!=null).<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (observable!=null && !observable.prune().hasData()) observable = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrice()!=null && getPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQuantity()!=null && getQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getObservable()!=null && getObservable().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceQuantity.PriceQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceQuantity.PriceQuantityBuilder o = (PriceQuantity.PriceQuantityBuilder) other;
			
			merger.mergeRosetta(getPrice(), o.getPrice(), this::getOrCreatePrice);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			merger.mergeRosetta(getObservable(), o.getObservable(), this::setObservable);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(price, _that.getPrice())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceQuantityBuilder {" +
				"price=" + this.price + ", " +
				"quantity=" + this.quantity + ", " +
				"observable=" + this.observable + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
