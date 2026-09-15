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
import fpml.consolidated.business.events.meta.OptionExpiryMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.ExerciseProcedureOption;
import java.time.LocalTime;
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
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing an option expiring (i.e. passing its last exercise time and becoming worthless.)
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing an option expiring (i.e. passing its last exercise time and becoming worthless.)
 *
 */
@RosettaDataType(value="OptionExpiry", builder=OptionExpiry.OptionExpiryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionExpiry", model="fpml", builder=OptionExpiry.OptionExpiryBuilderImpl.class, version="2.1.1")
public interface OptionExpiry extends AbstractEvent {

	OptionExpiryMeta metaData = new OptionExpiryMeta();

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
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
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
	ZonedDateTime getDate();
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
	LocalTime getTime();
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
	ExerciseProcedureOption getExerciseProcedure();
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
	ActionOnExpiration getActionOnExpiration();

	/*********************** Build Methods  ***********************/
	OptionExpiry build();
	
	OptionExpiry.OptionExpiryBuilder toBuilder();
	
	static OptionExpiry.OptionExpiryBuilder builder() {
		return new OptionExpiry.OptionExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExpiry> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionExpiry> getType() {
		return OptionExpiry.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedureOption.class, getExerciseProcedure());
		processRosetta(path.newSubPath("actionOnExpiration"), processor, ActionOnExpiration.class, getActionOnExpiration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExpiryBuilder extends OptionExpiry, AbstractEvent.AbstractEventBuilder {
		Trade.TradeBuilder getOrCreateOriginalTrade();
		@Override
		Trade.TradeBuilder getOriginalTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		ExerciseProcedureOption.ExerciseProcedureOptionBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedureOption.ExerciseProcedureOptionBuilder getExerciseProcedure();
		ActionOnExpiration.ActionOnExpirationBuilder getOrCreateActionOnExpiration();
		@Override
		ActionOnExpiration.ActionOnExpirationBuilder getActionOnExpiration();
		@Override
		OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		OptionExpiry.OptionExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		OptionExpiry.OptionExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		OptionExpiry.OptionExpiryBuilder setOriginalTrade(Trade originalTrade);
		OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		OptionExpiry.OptionExpiryBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionExpiry.OptionExpiryBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionExpiry.OptionExpiryBuilder setDate(ZonedDateTime date);
		OptionExpiry.OptionExpiryBuilder setTime(LocalTime time);
		OptionExpiry.OptionExpiryBuilder setExerciseProcedure(ExerciseProcedureOption exerciseProcedure);
		OptionExpiry.OptionExpiryBuilder setActionOnExpiration(ActionOnExpiration actionOnExpiration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedureOption.ExerciseProcedureOptionBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("actionOnExpiration"), processor, ActionOnExpiration.ActionOnExpirationBuilder.class, getActionOnExpiration());
		}
		

		OptionExpiry.OptionExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExpiry  ***********************/
	class OptionExpiryImpl extends AbstractEvent.AbstractEventImpl implements OptionExpiry {
		private final Trade originalTrade;
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final ZonedDateTime date;
		private final LocalTime time;
		private final ExerciseProcedureOption exerciseProcedure;
		private final ActionOnExpiration actionOnExpiration;
		
		protected OptionExpiryImpl(OptionExpiry.OptionExpiryBuilder builder) {
			super(builder);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = builder.getDate();
			this.time = builder.getTime();
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.actionOnExpiration = ofNullable(builder.getActionOnExpiration()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedureOption getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("actionOnExpiration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionOnExpiration")
		public ActionOnExpiration getActionOnExpiration() {
			return actionOnExpiration;
		}
		
		@Override
		public OptionExpiry build() {
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder toBuilder() {
			OptionExpiry.OptionExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExpiry.OptionExpiryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getActionOnExpiration()).ifPresent(builder::setActionOnExpiration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExpiry _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(actionOnExpiration, _that.getActionOnExpiration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (actionOnExpiration != null ? actionOnExpiration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiry {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"actionOnExpiration=" + this.actionOnExpiration +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionExpiry  ***********************/
	class OptionExpiryBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements OptionExpiry.OptionExpiryBuilder {
	
		protected Trade.TradeBuilder originalTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected ZonedDateTime date;
		protected LocalTime time;
		protected ExerciseProcedureOption.ExerciseProcedureOptionBuilder exerciseProcedure;
		protected ActionOnExpiration.ActionOnExpirationBuilder actionOnExpiration;
		
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
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedureOption.ExerciseProcedureOptionBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedureOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("actionOnExpiration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionOnExpiration")
		public ActionOnExpiration.ActionOnExpirationBuilder getActionOnExpiration() {
			return actionOnExpiration;
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder getOrCreateActionOnExpiration() {
			ActionOnExpiration.ActionOnExpirationBuilder result;
			if (actionOnExpiration!=null) {
				result = actionOnExpiration;
			}
			else {
				result = actionOnExpiration = ActionOnExpiration.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public OptionExpiry.OptionExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public OptionExpiry.OptionExpiryBuilder setOriginalTrade(Trade _originalTrade) {
			this.originalTrade = _originalTrade == null ? null : _originalTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public OptionExpiry.OptionExpiryBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public OptionExpiry.OptionExpiryBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public OptionExpiry.OptionExpiryBuilder setTime(LocalTime _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public OptionExpiry.OptionExpiryBuilder setExerciseProcedure(ExerciseProcedureOption _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("actionOnExpiration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionOnExpiration")
		@Override
		public OptionExpiry.OptionExpiryBuilder setActionOnExpiration(ActionOnExpiration _actionOnExpiration) {
			this.actionOnExpiration = _actionOnExpiration == null ? null : _actionOnExpiration.toBuilder();
			return this;
		}
		
		@Override
		public OptionExpiry build() {
			return new OptionExpiry.OptionExpiryImpl(this);
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiry.OptionExpiryBuilder prune() {
			super.prune();
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (actionOnExpiration!=null && !actionOnExpiration.prune().hasData()) actionOnExpiration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getActionOnExpiration()!=null && getActionOnExpiration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiry.OptionExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OptionExpiry.OptionExpiryBuilder o = (OptionExpiry.OptionExpiryBuilder) other;
			
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getActionOnExpiration(), o.getActionOnExpiration(), this::setActionOnExpiration);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExpiry _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(actionOnExpiration, _that.getActionOnExpiration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (actionOnExpiration != null ? actionOnExpiration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiryBuilder {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"actionOnExpiration=" + this.actionOnExpiration +
			'}' + " " + super.toString();
		}
	}
}
