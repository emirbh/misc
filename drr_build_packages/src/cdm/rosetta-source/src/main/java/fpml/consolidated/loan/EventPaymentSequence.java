package fpml.consolidated.loan;

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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.EventPaymentSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="EventPaymentSequence", builder=EventPaymentSequence.EventPaymentSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventPaymentSequence", model="fpml", builder=EventPaymentSequence.EventPaymentSequenceBuilderImpl.class, version="2.1.1")
public interface EventPaymentSequence extends RosettaModelObject {

	EventPaymentSequenceMeta metaData = new EventPaymentSequenceMeta();

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
	BusinessEventIdentifier getEventIdentifier();

	/*********************** Build Methods  ***********************/
	EventPaymentSequence build();
	
	EventPaymentSequence.EventPaymentSequenceBuilder toBuilder();
	
	static EventPaymentSequence.EventPaymentSequenceBuilder builder() {
		return new EventPaymentSequence.EventPaymentSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventPaymentSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventPaymentSequence> getType() {
		return EventPaymentSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventPaymentSequenceBuilder extends EventPaymentSequence, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		EventPaymentSequence.EventPaymentSequenceBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		EventPaymentSequence.EventPaymentSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EventPaymentSequence  ***********************/
	class EventPaymentSequenceImpl implements EventPaymentSequence {
		private final BusinessEventIdentifier eventIdentifier;
		
		protected EventPaymentSequenceImpl(EventPaymentSequence.EventPaymentSequenceBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public EventPaymentSequence build() {
			return this;
		}
		
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder toBuilder() {
			EventPaymentSequence.EventPaymentSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventPaymentSequence.EventPaymentSequenceBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventPaymentSequence _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPaymentSequence {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of EventPaymentSequence  ***********************/
	class EventPaymentSequenceBuilderImpl implements EventPaymentSequence.EventPaymentSequenceBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventIdentifier")
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder setEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public EventPaymentSequence build() {
			return new EventPaymentSequence.EventPaymentSequenceImpl(this);
		}
		
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder prune() {
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventPaymentSequence.EventPaymentSequenceBuilder o = (EventPaymentSequence.EventPaymentSequenceBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventPaymentSequence _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPaymentSequenceBuilder {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}
}
