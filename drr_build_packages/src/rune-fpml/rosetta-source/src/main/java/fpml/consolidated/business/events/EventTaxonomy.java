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
import fpml.consolidated.business.events.meta.EventTaxonomyMeta;
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
@RosettaDataType(value="EventTaxonomy", builder=EventTaxonomy.EventTaxonomyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventTaxonomy", model="fpml", builder=EventTaxonomy.EventTaxonomyBuilderImpl.class, version="2.1.1")
public interface EventTaxonomy extends RosettaModelObject {

	EventTaxonomyMeta metaData = new EventTaxonomyMeta();

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
	String getEventTaxonomyScheme();

	/*********************** Build Methods  ***********************/
	EventTaxonomy build();
	
	EventTaxonomy.EventTaxonomyBuilder toBuilder();
	
	static EventTaxonomy.EventTaxonomyBuilder builder() {
		return new EventTaxonomy.EventTaxonomyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventTaxonomy> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventTaxonomy> getType() {
		return EventTaxonomy.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("eventTaxonomyScheme"), String.class, getEventTaxonomyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventTaxonomyBuilder extends EventTaxonomy, RosettaModelObjectBuilder {
		EventTaxonomy.EventTaxonomyBuilder setValue(String value);
		EventTaxonomy.EventTaxonomyBuilder setEventTaxonomyScheme(String eventTaxonomyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("eventTaxonomyScheme"), String.class, getEventTaxonomyScheme(), this);
		}
		

		EventTaxonomy.EventTaxonomyBuilder prune();
	}

	/*********************** Immutable Implementation of EventTaxonomy  ***********************/
	class EventTaxonomyImpl implements EventTaxonomy {
		private final String value;
		private final String eventTaxonomyScheme;
		
		protected EventTaxonomyImpl(EventTaxonomy.EventTaxonomyBuilder builder) {
			this.value = builder.getValue();
			this.eventTaxonomyScheme = builder.getEventTaxonomyScheme();
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
		@RosettaAttribute("eventTaxonomyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTaxonomyScheme")
		public String getEventTaxonomyScheme() {
			return eventTaxonomyScheme;
		}
		
		@Override
		public EventTaxonomy build() {
			return this;
		}
		
		@Override
		public EventTaxonomy.EventTaxonomyBuilder toBuilder() {
			EventTaxonomy.EventTaxonomyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventTaxonomy.EventTaxonomyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEventTaxonomyScheme()).ifPresent(builder::setEventTaxonomyScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventTaxonomy _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventTaxonomyScheme, _that.getEventTaxonomyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventTaxonomyScheme != null ? eventTaxonomyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTaxonomy {" +
				"value=" + this.value + ", " +
				"eventTaxonomyScheme=" + this.eventTaxonomyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EventTaxonomy  ***********************/
	class EventTaxonomyBuilderImpl implements EventTaxonomy.EventTaxonomyBuilder {
	
		protected String value;
		protected String eventTaxonomyScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventTaxonomyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventTaxonomyScheme")
		public String getEventTaxonomyScheme() {
			return eventTaxonomyScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EventTaxonomy.EventTaxonomyBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("eventTaxonomyScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventTaxonomyScheme")
		@Override
		public EventTaxonomy.EventTaxonomyBuilder setEventTaxonomyScheme(String _eventTaxonomyScheme) {
			this.eventTaxonomyScheme = _eventTaxonomyScheme == null ? null : _eventTaxonomyScheme;
			return this;
		}
		
		@Override
		public EventTaxonomy build() {
			return new EventTaxonomy.EventTaxonomyImpl(this);
		}
		
		@Override
		public EventTaxonomy.EventTaxonomyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventTaxonomy.EventTaxonomyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEventTaxonomyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventTaxonomy.EventTaxonomyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventTaxonomy.EventTaxonomyBuilder o = (EventTaxonomy.EventTaxonomyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEventTaxonomyScheme(), o.getEventTaxonomyScheme(), this::setEventTaxonomyScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventTaxonomy _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventTaxonomyScheme, _that.getEventTaxonomyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventTaxonomyScheme != null ? eventTaxonomyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTaxonomyBuilder {" +
				"value=" + this.value + ", " +
				"eventTaxonomyScheme=" + this.eventTaxonomyScheme +
			'}';
		}
	}
}
