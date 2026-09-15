package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ObservationEventMeta;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.shared.TimeZone;
import java.math.BigDecimal;
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
@RosettaDataType(value="ObservationEvent", builder=ObservationEvent.ObservationEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservationEvent", model="fpml", builder=ObservationEvent.ObservationEventBuilderImpl.class, version="2.1.1")
public interface ObservationEvent extends AbstractEvent {

	ObservationEventMeta metaData = new ObservationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date of observation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date of observation.
	 *
	 */
	ZonedDateTime getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The observation time, with a possible indication of the timezone dimension.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The observation time, with a possible indication of the timezone dimension.
	 *
	 */
	TimeZone getTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The side (bid/mid/ask) of the observation, when applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The side (bid/mid/ask) of the observation, when applicable.
	 *
	 */
	QuotationRateTypeEnum getSide();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The observation value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The observation value.
	 *
	 */
	BigDecimal getObservedValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The observation source.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The observation source.
	 *
	 */
	ObservationSource getSource();

	/*********************** Build Methods  ***********************/
	ObservationEvent build();
	
	ObservationEvent.ObservationEventBuilder toBuilder();
	
	static ObservationEvent.ObservationEventBuilder builder() {
		return new ObservationEvent.ObservationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationEvent> getType() {
		return ObservationEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processRosetta(path.newSubPath("time"), processor, TimeZone.class, getTime());
		processor.processBasic(path.newSubPath("side"), QuotationRateTypeEnum.class, getSide(), this);
		processor.processBasic(path.newSubPath("observedValue"), BigDecimal.class, getObservedValue(), this);
		processRosetta(path.newSubPath("source"), processor, ObservationSource.class, getSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationEventBuilder extends ObservationEvent, AbstractEvent.AbstractEventBuilder {
		TimeZone.TimeZoneBuilder getOrCreateTime();
		@Override
		TimeZone.TimeZoneBuilder getTime();
		ObservationSource.ObservationSourceBuilder getOrCreateSource();
		@Override
		ObservationSource.ObservationSourceBuilder getSource();
		@Override
		ObservationEvent.ObservationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		ObservationEvent.ObservationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		ObservationEvent.ObservationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		ObservationEvent.ObservationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		ObservationEvent.ObservationEventBuilder setDate(ZonedDateTime date);
		ObservationEvent.ObservationEventBuilder setTime(TimeZone time);
		ObservationEvent.ObservationEventBuilder setSide(QuotationRateTypeEnum side);
		ObservationEvent.ObservationEventBuilder setObservedValue(BigDecimal observedValue);
		ObservationEvent.ObservationEventBuilder setSource(ObservationSource source);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processRosetta(path.newSubPath("time"), processor, TimeZone.TimeZoneBuilder.class, getTime());
			processor.processBasic(path.newSubPath("side"), QuotationRateTypeEnum.class, getSide(), this);
			processor.processBasic(path.newSubPath("observedValue"), BigDecimal.class, getObservedValue(), this);
			processRosetta(path.newSubPath("source"), processor, ObservationSource.ObservationSourceBuilder.class, getSource());
		}
		

		ObservationEvent.ObservationEventBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationEvent  ***********************/
	class ObservationEventImpl extends AbstractEvent.AbstractEventImpl implements ObservationEvent {
		private final ZonedDateTime date;
		private final TimeZone time;
		private final QuotationRateTypeEnum side;
		private final BigDecimal observedValue;
		private final ObservationSource source;
		
		protected ObservationEventImpl(ObservationEvent.ObservationEventBuilder builder) {
			super(builder);
			this.date = builder.getDate();
			this.time = ofNullable(builder.getTime()).map(f->f.build()).orElse(null);
			this.side = builder.getSide();
			this.observedValue = builder.getObservedValue();
			this.source = ofNullable(builder.getSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public TimeZone getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("side")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("side")
		public QuotationRateTypeEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("observedValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observedValue")
		public BigDecimal getObservedValue() {
			return observedValue;
		}
		
		@Override
		@RosettaAttribute("source")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("source")
		public ObservationSource getSource() {
			return source;
		}
		
		@Override
		public ObservationEvent build() {
			return this;
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder toBuilder() {
			ObservationEvent.ObservationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationEvent.ObservationEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getSide()).ifPresent(builder::setSide);
			ofNullable(getObservedValue()).ifPresent(builder::setObservedValue);
			ofNullable(getSource()).ifPresent(builder::setSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationEvent _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			if (!Objects.equals(observedValue, _that.getObservedValue())) return false;
			if (!Objects.equals(source, _that.getSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (observedValue != null ? observedValue.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationEvent {" +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"side=" + this.side + ", " +
				"observedValue=" + this.observedValue + ", " +
				"source=" + this.source +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObservationEvent  ***********************/
	class ObservationEventBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements ObservationEvent.ObservationEventBuilder {
	
		protected ZonedDateTime date;
		protected TimeZone.TimeZoneBuilder time;
		protected QuotationRateTypeEnum side;
		protected BigDecimal observedValue;
		protected ObservationSource.ObservationSourceBuilder source;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public TimeZone.TimeZoneBuilder getTime() {
			return time;
		}
		
		@Override
		public TimeZone.TimeZoneBuilder getOrCreateTime() {
			TimeZone.TimeZoneBuilder result;
			if (time!=null) {
				result = time;
			}
			else {
				result = time = TimeZone.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("side")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("side")
		public QuotationRateTypeEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("observedValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observedValue")
		public BigDecimal getObservedValue() {
			return observedValue;
		}
		
		@Override
		@RosettaAttribute("source")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("source")
		public ObservationSource.ObservationSourceBuilder getSource() {
			return source;
		}
		
		@Override
		public ObservationSource.ObservationSourceBuilder getOrCreateSource() {
			ObservationSource.ObservationSourceBuilder result;
			if (source!=null) {
				result = source;
			}
			else {
				result = source = ObservationSource.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ObservationEvent.ObservationEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public ObservationEvent.ObservationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("date")
		@Override
		public ObservationEvent.ObservationEventBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public ObservationEvent.ObservationEventBuilder setTime(TimeZone _time) {
			this.time = _time == null ? null : _time.toBuilder();
			return this;
		}
		
		@RosettaAttribute("side")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("side")
		@Override
		public ObservationEvent.ObservationEventBuilder setSide(QuotationRateTypeEnum _side) {
			this.side = _side == null ? null : _side;
			return this;
		}
		
		@RosettaAttribute("observedValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("observedValue")
		@Override
		public ObservationEvent.ObservationEventBuilder setObservedValue(BigDecimal _observedValue) {
			this.observedValue = _observedValue == null ? null : _observedValue;
			return this;
		}
		
		@RosettaAttribute("source")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("source")
		@Override
		public ObservationEvent.ObservationEventBuilder setSource(ObservationSource _source) {
			this.source = _source == null ? null : _source.toBuilder();
			return this;
		}
		
		@Override
		public ObservationEvent build() {
			return new ObservationEvent.ObservationEventImpl(this);
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationEvent.ObservationEventBuilder prune() {
			super.prune();
			if (time!=null && !time.prune().hasData()) time = null;
			if (source!=null && !source.prune().hasData()) source = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null && getTime().hasData()) return true;
			if (getSide()!=null) return true;
			if (getObservedValue()!=null) return true;
			if (getSource()!=null && getSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationEvent.ObservationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ObservationEvent.ObservationEventBuilder o = (ObservationEvent.ObservationEventBuilder) other;
			
			merger.mergeRosetta(getTime(), o.getTime(), this::setTime);
			merger.mergeRosetta(getSource(), o.getSource(), this::setSource);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getSide(), o.getSide(), this::setSide);
			merger.mergeBasic(getObservedValue(), o.getObservedValue(), this::setObservedValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationEvent _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			if (!Objects.equals(observedValue, _that.getObservedValue())) return false;
			if (!Objects.equals(source, _that.getSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (observedValue != null ? observedValue.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationEventBuilder {" +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"side=" + this.side + ", " +
				"observedValue=" + this.observedValue + ", " +
				"source=" + this.source +
			'}' + " " + super.toString();
		}
	}
}
