package fpml.consolidated.business.events;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.business.events.meta.EventTypeMeta;
import java.util.Objects;

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
 */
@RosettaDataType(value="EventType", builder=EventType.EventTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventType", model="fpml", builder=EventType.EventTypeBuilderImpl.class, version="2.1.1")
public interface EventType extends RosettaModelObject {

	EventTypeMeta metaData = new EventTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getEventTypeScheme();

	/*********************** Build Methods  ***********************/
	EventType build();
	
	EventType.EventTypeBuilder toBuilder();
	
	static EventType.EventTypeBuilder builder() {
		return new EventType.EventTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventType> getType() {
		return EventType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("eventTypeScheme"), String.class, getEventTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventTypeBuilder extends EventType, RosettaModelObjectBuilder {
		EventType.EventTypeBuilder setValue(String value);
		EventType.EventTypeBuilder setEventTypeScheme(String eventTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("eventTypeScheme"), String.class, getEventTypeScheme(), this);
		}
		

		EventType.EventTypeBuilder prune();
	}

	/*********************** Immutable Implementation of EventType  ***********************/
	class EventTypeImpl implements EventType {
		private final String value;
		private final String eventTypeScheme;
		
		protected EventTypeImpl(EventType.EventTypeBuilder builder) {
			this.value = builder.getValue();
			this.eventTypeScheme = builder.getEventTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTypeScheme")
		public String getEventTypeScheme() {
			return eventTypeScheme;
		}
		
		@Override
		public EventType build() {
			return this;
		}
		
		@Override
		public EventType.EventTypeBuilder toBuilder() {
			EventType.EventTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventType.EventTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEventTypeScheme()).ifPresent(builder::setEventTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventTypeScheme, _that.getEventTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventTypeScheme != null ? eventTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventType {" +
				"value=" + this.value + ", " +
				"eventTypeScheme=" + this.eventTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EventType  ***********************/
	class EventTypeBuilderImpl implements EventType.EventTypeBuilder {
	
		protected String value;
		protected String eventTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTypeScheme")
		public String getEventTypeScheme() {
			return eventTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EventType.EventTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("eventTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTypeScheme")
		@Override
		public EventType.EventTypeBuilder setEventTypeScheme(String _eventTypeScheme) {
			this.eventTypeScheme = _eventTypeScheme == null ? null : _eventTypeScheme;
			return this;
		}
		
		@Override
		public EventType build() {
			return new EventType.EventTypeImpl(this);
		}
		
		@Override
		public EventType.EventTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventType.EventTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEventTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventType.EventTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventType.EventTypeBuilder o = (EventType.EventTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEventTypeScheme(), o.getEventTypeScheme(), this::setEventTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventTypeScheme, _that.getEventTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventTypeScheme != null ? eventTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTypeBuilder {" +
				"value=" + this.value + ", " +
				"eventTypeScheme=" + this.eventTypeScheme +
			'}';
		}
	}
}
