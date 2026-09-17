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
import fpml.consolidated.business.events.meta.AbstractEventMeta;
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
 * Provision Abstract base type for all events.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base type for all events.
 *
 */
@RosettaDataType(value="AbstractEvent", builder=AbstractEvent.AbstractEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractEvent", model="fpml", builder=AbstractEvent.AbstractEventBuilderImpl.class, version="2.1.1")
public interface AbstractEvent extends RosettaModelObject {

	AbstractEventMeta metaData = new AbstractEventMeta();

	/*********************** Getter Methods  ***********************/
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
	List<? extends BusinessEventIdentifier> getEventIdentifier();

	/*********************** Build Methods  ***********************/
	AbstractEvent build();
	
	AbstractEvent.AbstractEventBuilder toBuilder();
	
	static AbstractEvent.AbstractEventBuilder builder() {
		return new AbstractEvent.AbstractEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractEvent> getType() {
		return AbstractEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractEventBuilder extends AbstractEvent, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index);
		@Override
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier();
		AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		AbstractEvent.AbstractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		AbstractEvent.AbstractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		AbstractEvent.AbstractEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractEvent  ***********************/
	class AbstractEventImpl implements AbstractEvent {
		private final List<? extends BusinessEventIdentifier> eventIdentifier;
		
		protected AbstractEventImpl(AbstractEvent.AbstractEventBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public AbstractEvent build() {
			return this;
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder toBuilder() {
			AbstractEvent.AbstractEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractEvent.AbstractEventBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
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
			return "AbstractEvent {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractEvent  ***********************/
	class AbstractEventBuilderImpl implements AbstractEvent.AbstractEventBuilder {
	
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> eventIdentifier = new ArrayList<>();
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index) {
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			return getIndex(eventIdentifier, index, () -> {
						BusinessEventIdentifier.BusinessEventIdentifierBuilder newEventIdentifier = BusinessEventIdentifier.builder();
						return newEventIdentifier;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractEvent.AbstractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractEvent build() {
			return new AbstractEvent.AbstractEventImpl(this);
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractEvent.AbstractEventBuilder prune() {
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<BusinessEventIdentifier.BusinessEventIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractEvent.AbstractEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractEvent.AbstractEventBuilder o = (AbstractEvent.AbstractEventBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
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
			return "AbstractEventBuilder {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}
}
