package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.OptionEventMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
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
@RosettaDataType(value="OptionEvent", builder=OptionEvent.OptionEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionEvent", model="fpml", builder=OptionEvent.OptionEventBuilderImpl.class, version="2.1.1")
public interface OptionEvent extends AbstractEvent {

	OptionEventMeta metaData = new OptionEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fully describes the original trade (prior to the exercise).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fully describes the original trade (prior to the exercise).
	 *
	 */
	Trade getOriginalTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identified the trade to which the option event applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identified the trade to which the option event applies.
	 *
	 */
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing a barrier knock in event
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing a barrier knock in event
	 *
	 */
	TriggerRateObservation getKnockIn();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing a barrier knock out event
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing a barrier knock out event
	 *
	 */
	KnockOutRateObservation getKnockOut();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing a touch event
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing a touch event
	 *
	 */
	List<? extends TouchRateObservation> getTouch();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing the outcome of an option having no touch events
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing the outcome of an option having no touch events
	 *
	 */
	NoTouchRateObservation getNoTouch();

	/*********************** Build Methods  ***********************/
	OptionEvent build();
	
	OptionEvent.OptionEventBuilder toBuilder();
	
	static OptionEvent.OptionEventBuilder builder() {
		return new OptionEvent.OptionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionEvent> getType() {
		return OptionEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("knockIn"), processor, TriggerRateObservation.class, getKnockIn());
		processRosetta(path.newSubPath("knockOut"), processor, KnockOutRateObservation.class, getKnockOut());
		processRosetta(path.newSubPath("touch"), processor, TouchRateObservation.class, getTouch());
		processRosetta(path.newSubPath("noTouch"), processor, NoTouchRateObservation.class, getNoTouch());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionEventBuilder extends OptionEvent, AbstractEvent.AbstractEventBuilder {
		Trade.TradeBuilder getOrCreateOriginalTrade();
		@Override
		Trade.TradeBuilder getOriginalTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		TriggerRateObservation.TriggerRateObservationBuilder getOrCreateKnockIn();
		@Override
		TriggerRateObservation.TriggerRateObservationBuilder getKnockIn();
		KnockOutRateObservation.KnockOutRateObservationBuilder getOrCreateKnockOut();
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder getKnockOut();
		TouchRateObservation.TouchRateObservationBuilder getOrCreateTouch(int index);
		@Override
		List<? extends TouchRateObservation.TouchRateObservationBuilder> getTouch();
		NoTouchRateObservation.NoTouchRateObservationBuilder getOrCreateNoTouch();
		@Override
		NoTouchRateObservation.NoTouchRateObservationBuilder getNoTouch();
		@Override
		OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		OptionEvent.OptionEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		OptionEvent.OptionEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		OptionEvent.OptionEventBuilder setOriginalTrade(Trade originalTrade);
		OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		OptionEvent.OptionEventBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionEvent.OptionEventBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionEvent.OptionEventBuilder setKnockIn(TriggerRateObservation knockIn);
		OptionEvent.OptionEventBuilder setKnockOut(KnockOutRateObservation knockOut);
		OptionEvent.OptionEventBuilder addTouch(TouchRateObservation touch);
		OptionEvent.OptionEventBuilder addTouch(TouchRateObservation touch, int idx);
		OptionEvent.OptionEventBuilder addTouch(List<? extends TouchRateObservation> touch);
		OptionEvent.OptionEventBuilder setTouch(List<? extends TouchRateObservation> touch);
		OptionEvent.OptionEventBuilder setNoTouch(NoTouchRateObservation noTouch);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("knockIn"), processor, TriggerRateObservation.TriggerRateObservationBuilder.class, getKnockIn());
			processRosetta(path.newSubPath("knockOut"), processor, KnockOutRateObservation.KnockOutRateObservationBuilder.class, getKnockOut());
			processRosetta(path.newSubPath("touch"), processor, TouchRateObservation.TouchRateObservationBuilder.class, getTouch());
			processRosetta(path.newSubPath("noTouch"), processor, NoTouchRateObservation.NoTouchRateObservationBuilder.class, getNoTouch());
		}
		

		OptionEvent.OptionEventBuilder prune();
	}

	/*********************** Immutable Implementation of OptionEvent  ***********************/
	class OptionEventImpl extends AbstractEvent.AbstractEventImpl implements OptionEvent {
		private final Trade originalTrade;
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final TriggerRateObservation knockIn;
		private final KnockOutRateObservation knockOut;
		private final List<? extends TouchRateObservation> touch;
		private final NoTouchRateObservation noTouch;
		
		protected OptionEventImpl(OptionEvent.OptionEventBuilder builder) {
			super(builder);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.knockIn = ofNullable(builder.getKnockIn()).map(f->f.build()).orElse(null);
			this.knockOut = ofNullable(builder.getKnockOut()).map(f->f.build()).orElse(null);
			this.touch = ofNullable(builder.getTouch()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.noTouch = ofNullable(builder.getNoTouch()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalTrade")
		public Trade getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockIn")
		public TriggerRateObservation getKnockIn() {
			return knockIn;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockOut")
		public KnockOutRateObservation getKnockOut() {
			return knockOut;
		}
		
		@Override
		@RosettaAttribute("touch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("touch")
		public List<? extends TouchRateObservation> getTouch() {
			return touch;
		}
		
		@Override
		@RosettaAttribute("noTouch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noTouch")
		public NoTouchRateObservation getNoTouch() {
			return noTouch;
		}
		
		@Override
		public OptionEvent build() {
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder toBuilder() {
			OptionEvent.OptionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionEvent.OptionEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getKnockIn()).ifPresent(builder::setKnockIn);
			ofNullable(getKnockOut()).ifPresent(builder::setKnockOut);
			ofNullable(getTouch()).ifPresent(builder::setTouch);
			ofNullable(getNoTouch()).ifPresent(builder::setNoTouch);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionEvent _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(knockIn, _that.getKnockIn())) return false;
			if (!Objects.equals(knockOut, _that.getKnockOut())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			if (!Objects.equals(noTouch, _that.getNoTouch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (knockIn != null ? knockIn.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			_result = 31 * _result + (noTouch != null ? noTouch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionEvent {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"knockIn=" + this.knockIn + ", " +
				"knockOut=" + this.knockOut + ", " +
				"touch=" + this.touch + ", " +
				"noTouch=" + this.noTouch +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionEvent  ***********************/
	class OptionEventBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements OptionEvent.OptionEventBuilder {
	
		protected Trade.TradeBuilder originalTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected TriggerRateObservation.TriggerRateObservationBuilder knockIn;
		protected KnockOutRateObservation.KnockOutRateObservationBuilder knockOut;
		protected List<TouchRateObservation.TouchRateObservationBuilder> touch = new ArrayList<>();
		protected NoTouchRateObservation.NoTouchRateObservationBuilder noTouch;
		
		@Override
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalTrade")
		public Trade.TradeBuilder getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOriginalTrade() {
			Trade.TradeBuilder result;
			if (originalTrade!=null) {
				result = originalTrade;
			}
			else {
				result = originalTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockIn")
		public TriggerRateObservation.TriggerRateObservationBuilder getKnockIn() {
			return knockIn;
		}
		
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder getOrCreateKnockIn() {
			TriggerRateObservation.TriggerRateObservationBuilder result;
			if (knockIn!=null) {
				result = knockIn;
			}
			else {
				result = knockIn = TriggerRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockOut")
		public KnockOutRateObservation.KnockOutRateObservationBuilder getKnockOut() {
			return knockOut;
		}
		
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder getOrCreateKnockOut() {
			KnockOutRateObservation.KnockOutRateObservationBuilder result;
			if (knockOut!=null) {
				result = knockOut;
			}
			else {
				result = knockOut = KnockOutRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("touch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("touch")
		public List<? extends TouchRateObservation.TouchRateObservationBuilder> getTouch() {
			return touch;
		}
		
		@Override
		public TouchRateObservation.TouchRateObservationBuilder getOrCreateTouch(int index) {
			if (touch==null) {
				this.touch = new ArrayList<>();
			}
			return getIndex(touch, index, () -> {
						TouchRateObservation.TouchRateObservationBuilder newTouch = TouchRateObservation.builder();
						return newTouch;
					});
		}
		
		@Override
		@RosettaAttribute("noTouch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noTouch")
		public NoTouchRateObservation.NoTouchRateObservationBuilder getNoTouch() {
			return noTouch;
		}
		
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder getOrCreateNoTouch() {
			NoTouchRateObservation.NoTouchRateObservationBuilder result;
			if (noTouch!=null) {
				result = noTouch;
			}
			else {
				result = noTouch = NoTouchRateObservation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public OptionEvent.OptionEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalTrade")
		@Override
		public OptionEvent.OptionEventBuilder setOriginalTrade(Trade _originalTrade) {
			this.originalTrade = _originalTrade == null ? null : _originalTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public OptionEvent.OptionEventBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knockIn")
		@Override
		public OptionEvent.OptionEventBuilder setKnockIn(TriggerRateObservation _knockIn) {
			this.knockIn = _knockIn == null ? null : _knockIn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knockOut")
		@Override
		public OptionEvent.OptionEventBuilder setKnockOut(KnockOutRateObservation _knockOut) {
			this.knockOut = _knockOut == null ? null : _knockOut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("touch")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("touch")
		@Override
		public OptionEvent.OptionEventBuilder addTouch(TouchRateObservation _touch) {
			if (_touch != null) {
				this.touch.add(_touch.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addTouch(TouchRateObservation _touch, int idx) {
			getIndex(this.touch, idx, () -> _touch.toBuilder());
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addTouch(List<? extends TouchRateObservation> touchs) {
			if (touchs != null) {
				for (final TouchRateObservation toAdd : touchs) {
					this.touch.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("touch")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("touch")
		@Override
		public OptionEvent.OptionEventBuilder setTouch(List<? extends TouchRateObservation> touchs) {
			if (touchs == null) {
				this.touch = new ArrayList<>();
			} else {
				this.touch = touchs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noTouch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noTouch")
		@Override
		public OptionEvent.OptionEventBuilder setNoTouch(NoTouchRateObservation _noTouch) {
			this.noTouch = _noTouch == null ? null : _noTouch.toBuilder();
			return this;
		}
		
		@Override
		public OptionEvent build() {
			return new OptionEvent.OptionEventImpl(this);
		}
		
		@Override
		public OptionEvent.OptionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionEvent.OptionEventBuilder prune() {
			super.prune();
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (knockIn!=null && !knockIn.prune().hasData()) knockIn = null;
			if (knockOut!=null && !knockOut.prune().hasData()) knockOut = null;
			touch = touch.stream().filter(b->b!=null).<TouchRateObservation.TouchRateObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (noTouch!=null && !noTouch.prune().hasData()) noTouch = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getKnockIn()!=null && getKnockIn().hasData()) return true;
			if (getKnockOut()!=null && getKnockOut().hasData()) return true;
			if (getTouch()!=null && getTouch().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNoTouch()!=null && getNoTouch().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionEvent.OptionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OptionEvent.OptionEventBuilder o = (OptionEvent.OptionEventBuilder) other;
			
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getKnockIn(), o.getKnockIn(), this::setKnockIn);
			merger.mergeRosetta(getKnockOut(), o.getKnockOut(), this::setKnockOut);
			merger.mergeRosetta(getTouch(), o.getTouch(), this::getOrCreateTouch);
			merger.mergeRosetta(getNoTouch(), o.getNoTouch(), this::setNoTouch);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionEvent _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(knockIn, _that.getKnockIn())) return false;
			if (!Objects.equals(knockOut, _that.getKnockOut())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			if (!Objects.equals(noTouch, _that.getNoTouch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (knockIn != null ? knockIn.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			_result = 31 * _result + (noTouch != null ? noTouch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionEventBuilder {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"knockIn=" + this.knockIn + ", " +
				"knockOut=" + this.knockOut + ", " +
				"touch=" + this.touch + ", " +
				"noTouch=" + this.noTouch +
			'}' + " " + super.toString();
		}
	}
}
