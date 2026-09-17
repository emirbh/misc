package cdm.legaldocumentation.transaction.additionalterms;

import cdm.base.math.Quantity;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.legaldocumentation.transaction.additionalterms.meta.EventCurrencyMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the currency referenced as such in any terms related to FX Disruption Events
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.4.(c)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="EventCurrency", builder=EventCurrency.EventCurrencyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EventCurrency", model="cdm", builder=EventCurrency.EventCurrencyBuilderImpl.class, version="6.23.0")
public interface EventCurrency extends RosettaModelObject {

	EventCurrencyMeta metaData = new EventCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the currency referenced as such in any terms related to FX Disruption Events
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.4.(c)"
	 *
	 * Provision 
	 *
	 */
	FieldWithMetaString getEventCurrency();
	/**
	 * Defines the Event Currency Amount to be exchanged on the Settlement Date.
	 */
	Quantity getEventCurrentAmount();
	/**
	 * Unless otherwised specified, the Buyer is the party to which the Event Currency Amount is owed on the Settlement Date and the Seller is the party which owes the Event Currency Amount on the Settlement Date.
	 */
	List<? extends BuyerSeller> getEventCurrencyBuyerSeller();

	/*********************** Build Methods  ***********************/
	EventCurrency build();
	
	EventCurrency.EventCurrencyBuilder toBuilder();
	
	static EventCurrency.EventCurrencyBuilder builder() {
		return new EventCurrency.EventCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventCurrency> getType() {
		return EventCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventCurrency"), processor, FieldWithMetaString.class, getEventCurrency());
		processRosetta(path.newSubPath("eventCurrentAmount"), processor, Quantity.class, getEventCurrentAmount());
		processRosetta(path.newSubPath("eventCurrencyBuyerSeller"), processor, BuyerSeller.class, getEventCurrencyBuyerSeller());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventCurrencyBuilder extends EventCurrency, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEventCurrency();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getEventCurrency();
		Quantity.QuantityBuilder getOrCreateEventCurrentAmount();
		@Override
		Quantity.QuantityBuilder getEventCurrentAmount();
		BuyerSeller.BuyerSellerBuilder getOrCreateEventCurrencyBuyerSeller(int index);
		@Override
		List<? extends BuyerSeller.BuyerSellerBuilder> getEventCurrencyBuyerSeller();
		EventCurrency.EventCurrencyBuilder setEventCurrency(FieldWithMetaString eventCurrency);
		EventCurrency.EventCurrencyBuilder setEventCurrencyValue(String eventCurrency);
		EventCurrency.EventCurrencyBuilder setEventCurrentAmount(Quantity eventCurrentAmount);
		EventCurrency.EventCurrencyBuilder addEventCurrencyBuyerSeller(BuyerSeller eventCurrencyBuyerSeller);
		EventCurrency.EventCurrencyBuilder addEventCurrencyBuyerSeller(BuyerSeller eventCurrencyBuyerSeller, int idx);
		EventCurrency.EventCurrencyBuilder addEventCurrencyBuyerSeller(List<? extends BuyerSeller> eventCurrencyBuyerSeller);
		EventCurrency.EventCurrencyBuilder setEventCurrencyBuyerSeller(List<? extends BuyerSeller> eventCurrencyBuyerSeller);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventCurrency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getEventCurrency());
			processRosetta(path.newSubPath("eventCurrentAmount"), processor, Quantity.QuantityBuilder.class, getEventCurrentAmount());
			processRosetta(path.newSubPath("eventCurrencyBuyerSeller"), processor, BuyerSeller.BuyerSellerBuilder.class, getEventCurrencyBuyerSeller());
		}
		

		EventCurrency.EventCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of EventCurrency  ***********************/
	class EventCurrencyImpl implements EventCurrency {
		private final FieldWithMetaString eventCurrency;
		private final Quantity eventCurrentAmount;
		private final List<? extends BuyerSeller> eventCurrencyBuyerSeller;
		
		protected EventCurrencyImpl(EventCurrency.EventCurrencyBuilder builder) {
			this.eventCurrency = ofNullable(builder.getEventCurrency()).map(f->f.build()).orElse(null);
			this.eventCurrentAmount = ofNullable(builder.getEventCurrentAmount()).map(f->f.build()).orElse(null);
			this.eventCurrencyBuyerSeller = ofNullable(builder.getEventCurrencyBuyerSeller()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventCurrency")
		public FieldWithMetaString getEventCurrency() {
			return eventCurrency;
		}
		
		@Override
		@RosettaAttribute("eventCurrentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventCurrentAmount")
		public Quantity getEventCurrentAmount() {
			return eventCurrentAmount;
		}
		
		@Override
		@RosettaAttribute("eventCurrencyBuyerSeller")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventCurrencyBuyerSeller")
		public List<? extends BuyerSeller> getEventCurrencyBuyerSeller() {
			return eventCurrencyBuyerSeller;
		}
		
		@Override
		public EventCurrency build() {
			return this;
		}
		
		@Override
		public EventCurrency.EventCurrencyBuilder toBuilder() {
			EventCurrency.EventCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventCurrency.EventCurrencyBuilder builder) {
			ofNullable(getEventCurrency()).ifPresent(builder::setEventCurrency);
			ofNullable(getEventCurrentAmount()).ifPresent(builder::setEventCurrentAmount);
			ofNullable(getEventCurrencyBuyerSeller()).ifPresent(builder::setEventCurrencyBuyerSeller);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventCurrency _that = getType().cast(o);
		
			if (!Objects.equals(eventCurrency, _that.getEventCurrency())) return false;
			if (!Objects.equals(eventCurrentAmount, _that.getEventCurrentAmount())) return false;
			if (!ListEquals.listEquals(eventCurrencyBuyerSeller, _that.getEventCurrencyBuyerSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventCurrency != null ? eventCurrency.hashCode() : 0);
			_result = 31 * _result + (eventCurrentAmount != null ? eventCurrentAmount.hashCode() : 0);
			_result = 31 * _result + (eventCurrencyBuyerSeller != null ? eventCurrencyBuyerSeller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventCurrency {" +
				"eventCurrency=" + this.eventCurrency + ", " +
				"eventCurrentAmount=" + this.eventCurrentAmount + ", " +
				"eventCurrencyBuyerSeller=" + this.eventCurrencyBuyerSeller +
			'}';
		}
	}

	/*********************** Builder Implementation of EventCurrency  ***********************/
	class EventCurrencyBuilderImpl implements EventCurrency.EventCurrencyBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder eventCurrency;
		protected Quantity.QuantityBuilder eventCurrentAmount;
		protected List<BuyerSeller.BuyerSellerBuilder> eventCurrencyBuyerSeller = new ArrayList<>();
		
		@Override
		@RosettaAttribute("eventCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventCurrency")
		public FieldWithMetaString.FieldWithMetaStringBuilder getEventCurrency() {
			return eventCurrency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEventCurrency() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (eventCurrency!=null) {
				result = eventCurrency;
			}
			else {
				result = eventCurrency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventCurrentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventCurrentAmount")
		public Quantity.QuantityBuilder getEventCurrentAmount() {
			return eventCurrentAmount;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateEventCurrentAmount() {
			Quantity.QuantityBuilder result;
			if (eventCurrentAmount!=null) {
				result = eventCurrentAmount;
			}
			else {
				result = eventCurrentAmount = Quantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventCurrencyBuyerSeller")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventCurrencyBuyerSeller")
		public List<? extends BuyerSeller.BuyerSellerBuilder> getEventCurrencyBuyerSeller() {
			return eventCurrencyBuyerSeller;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder getOrCreateEventCurrencyBuyerSeller(int index) {
			if (eventCurrencyBuyerSeller==null) {
				this.eventCurrencyBuyerSeller = new ArrayList<>();
			}
			return getIndex(eventCurrencyBuyerSeller, index, () -> {
						BuyerSeller.BuyerSellerBuilder newEventCurrencyBuyerSeller = BuyerSeller.builder();
						return newEventCurrencyBuyerSeller;
					});
		}
		
		@RosettaAttribute("eventCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventCurrency")
		@Override
		public EventCurrency.EventCurrencyBuilder setEventCurrency(FieldWithMetaString _eventCurrency) {
			this.eventCurrency = _eventCurrency == null ? null : _eventCurrency.toBuilder();
			return this;
		}
		
		@Override
		public EventCurrency.EventCurrencyBuilder setEventCurrencyValue(String _eventCurrency) {
			this.getOrCreateEventCurrency().setValue(_eventCurrency);
			return this;
		}
		
		@RosettaAttribute("eventCurrentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventCurrentAmount")
		@Override
		public EventCurrency.EventCurrencyBuilder setEventCurrentAmount(Quantity _eventCurrentAmount) {
			this.eventCurrentAmount = _eventCurrentAmount == null ? null : _eventCurrentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventCurrencyBuyerSeller")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventCurrencyBuyerSeller")
		@Override
		public EventCurrency.EventCurrencyBuilder addEventCurrencyBuyerSeller(BuyerSeller _eventCurrencyBuyerSeller) {
			if (_eventCurrencyBuyerSeller != null) {
				this.eventCurrencyBuyerSeller.add(_eventCurrencyBuyerSeller.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventCurrency.EventCurrencyBuilder addEventCurrencyBuyerSeller(BuyerSeller _eventCurrencyBuyerSeller, int idx) {
			getIndex(this.eventCurrencyBuyerSeller, idx, () -> _eventCurrencyBuyerSeller.toBuilder());
			return this;
		}
		
		@Override
		public EventCurrency.EventCurrencyBuilder addEventCurrencyBuyerSeller(List<? extends BuyerSeller> eventCurrencyBuyerSellers) {
			if (eventCurrencyBuyerSellers != null) {
				for (final BuyerSeller toAdd : eventCurrencyBuyerSellers) {
					this.eventCurrencyBuyerSeller.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventCurrencyBuyerSeller")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventCurrencyBuyerSeller")
		@Override
		public EventCurrency.EventCurrencyBuilder setEventCurrencyBuyerSeller(List<? extends BuyerSeller> eventCurrencyBuyerSellers) {
			if (eventCurrencyBuyerSellers == null) {
				this.eventCurrencyBuyerSeller = new ArrayList<>();
			} else {
				this.eventCurrencyBuyerSeller = eventCurrencyBuyerSellers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EventCurrency build() {
			return new EventCurrency.EventCurrencyImpl(this);
		}
		
		@Override
		public EventCurrency.EventCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventCurrency.EventCurrencyBuilder prune() {
			if (eventCurrency!=null && !eventCurrency.prune().hasData()) eventCurrency = null;
			if (eventCurrentAmount!=null && !eventCurrentAmount.prune().hasData()) eventCurrentAmount = null;
			eventCurrencyBuyerSeller = eventCurrencyBuyerSeller.stream().filter(b->b!=null).<BuyerSeller.BuyerSellerBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventCurrency()!=null) return true;
			if (getEventCurrentAmount()!=null && getEventCurrentAmount().hasData()) return true;
			if (getEventCurrencyBuyerSeller()!=null && getEventCurrencyBuyerSeller().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventCurrency.EventCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventCurrency.EventCurrencyBuilder o = (EventCurrency.EventCurrencyBuilder) other;
			
			merger.mergeRosetta(getEventCurrency(), o.getEventCurrency(), this::setEventCurrency);
			merger.mergeRosetta(getEventCurrentAmount(), o.getEventCurrentAmount(), this::setEventCurrentAmount);
			merger.mergeRosetta(getEventCurrencyBuyerSeller(), o.getEventCurrencyBuyerSeller(), this::getOrCreateEventCurrencyBuyerSeller);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventCurrency _that = getType().cast(o);
		
			if (!Objects.equals(eventCurrency, _that.getEventCurrency())) return false;
			if (!Objects.equals(eventCurrentAmount, _that.getEventCurrentAmount())) return false;
			if (!ListEquals.listEquals(eventCurrencyBuyerSeller, _that.getEventCurrencyBuyerSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventCurrency != null ? eventCurrency.hashCode() : 0);
			_result = 31 * _result + (eventCurrentAmount != null ? eventCurrentAmount.hashCode() : 0);
			_result = 31 * _result + (eventCurrencyBuyerSeller != null ? eventCurrencyBuyerSeller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventCurrencyBuilder {" +
				"eventCurrency=" + this.eventCurrency + ", " +
				"eventCurrentAmount=" + this.eventCurrentAmount + ", " +
				"eventCurrencyBuyerSeller=" + this.eventCurrencyBuyerSeller +
			'}';
		}
	}
}
