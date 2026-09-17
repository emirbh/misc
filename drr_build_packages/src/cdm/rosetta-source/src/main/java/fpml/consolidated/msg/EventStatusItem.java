package fpml.consolidated.msg;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.msg.meta.EventStatusItemMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type used in event status enquiry messages which relates an event identifier to its current status value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type used in event status enquiry messages which relates an event identifier to its current status value.
 *
 */
@RosettaDataType(value="EventStatusItem", builder=EventStatusItem.EventStatusItemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventStatusItem", model="fpml", builder=EventStatusItem.EventStatusItemBuilderImpl.class, version="2.1.1")
public interface EventStatusItem extends RosettaModelObject {

	EventStatusItemMeta metaData = new EventStatusItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An instance of a unique event identifier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An instance of a unique event identifier.
	 *
	 */
	EventIdentifier getEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An event status value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An event status value.
	 *
	 */
	EventStatus getStatus();

	/*********************** Build Methods  ***********************/
	EventStatusItem build();
	
	EventStatusItem.EventStatusItemBuilder toBuilder();
	
	static EventStatusItem.EventStatusItemBuilder builder() {
		return new EventStatusItem.EventStatusItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventStatusItem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventStatusItem> getType() {
		return EventStatusItem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, EventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("status"), processor, EventStatus.class, getStatus());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventStatusItemBuilder extends EventStatusItem, RosettaModelObjectBuilder {
		EventIdentifier.EventIdentifierBuilder getOrCreateEventIdentifier();
		@Override
		EventIdentifier.EventIdentifierBuilder getEventIdentifier();
		EventStatus.EventStatusBuilder getOrCreateStatus();
		@Override
		EventStatus.EventStatusBuilder getStatus();
		EventStatusItem.EventStatusItemBuilder setEventIdentifier(EventIdentifier eventIdentifier);
		EventStatusItem.EventStatusItemBuilder setStatus(EventStatus status);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, EventIdentifier.EventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("status"), processor, EventStatus.EventStatusBuilder.class, getStatus());
		}
		

		EventStatusItem.EventStatusItemBuilder prune();
	}

	/*********************** Immutable Implementation of EventStatusItem  ***********************/
	class EventStatusItemImpl implements EventStatusItem {
		private final EventIdentifier eventIdentifier;
		private final EventStatus status;
		
		protected EventStatusItemImpl(EventStatusItem.EventStatusItemBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public EventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public EventStatus getStatus() {
			return status;
		}
		
		@Override
		public EventStatusItem build() {
			return this;
		}
		
		@Override
		public EventStatusItem.EventStatusItemBuilder toBuilder() {
			EventStatusItem.EventStatusItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventStatusItem.EventStatusItemBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventStatusItem _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventStatusItem {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"status=" + this.status +
			'}';
		}
	}

	/*********************** Builder Implementation of EventStatusItem  ***********************/
	class EventStatusItemBuilderImpl implements EventStatusItem.EventStatusItemBuilder {
	
		protected EventIdentifier.EventIdentifierBuilder eventIdentifier;
		protected EventStatus.EventStatusBuilder status;
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public EventIdentifier.EventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder getOrCreateEventIdentifier() {
			EventIdentifier.EventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = EventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public EventStatus.EventStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public EventStatus.EventStatusBuilder getOrCreateStatus() {
			EventStatus.EventStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = EventStatus.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public EventStatusItem.EventStatusItemBuilder setEventIdentifier(EventIdentifier _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("status")
		@Override
		public EventStatusItem.EventStatusItemBuilder setStatus(EventStatus _status) {
			this.status = _status == null ? null : _status.toBuilder();
			return this;
		}
		
		@Override
		public EventStatusItem build() {
			return new EventStatusItem.EventStatusItemImpl(this);
		}
		
		@Override
		public EventStatusItem.EventStatusItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatusItem.EventStatusItemBuilder prune() {
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (status!=null && !status.prune().hasData()) status = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatusItem.EventStatusItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventStatusItem.EventStatusItemBuilder o = (EventStatusItem.EventStatusItemBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventStatusItem _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventStatusItemBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"status=" + this.status +
			'}';
		}
	}
}
