package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ChangeEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Abstract base type for non-negotiated trade change descriptions
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base type for non-negotiated trade change descriptions
 *
 */
@RosettaDataType(value="ChangeEvent", builder=ChangeEvent.ChangeEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ChangeEvent", model="fpml", builder=ChangeEvent.ChangeEventBuilderImpl.class, version="2.1.1")
public interface ChangeEvent extends AbstractEvent {

	ChangeEventMeta metaData = new ChangeEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ChangeEvent build();
	
	ChangeEvent.ChangeEventBuilder toBuilder();
	
	static ChangeEvent.ChangeEventBuilder builder() {
		return new ChangeEvent.ChangeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ChangeEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ChangeEvent> getType() {
		return ChangeEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ChangeEventBuilder extends ChangeEvent, AbstractEvent.AbstractEventBuilder {
		@Override
		ChangeEvent.ChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		ChangeEvent.ChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		ChangeEvent.ChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		ChangeEvent.ChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		ChangeEvent.ChangeEventBuilder prune();
	}

	/*********************** Immutable Implementation of ChangeEvent  ***********************/
	class ChangeEventImpl extends AbstractEvent.AbstractEventImpl implements ChangeEvent {
		
		protected ChangeEventImpl(ChangeEvent.ChangeEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public ChangeEvent build() {
			return this;
		}
		
		@Override
		public ChangeEvent.ChangeEventBuilder toBuilder() {
			ChangeEvent.ChangeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ChangeEvent.ChangeEventBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ChangeEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ChangeEvent  ***********************/
	class ChangeEventBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements ChangeEvent.ChangeEventBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ChangeEvent.ChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ChangeEvent.ChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ChangeEvent.ChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public ChangeEvent.ChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public ChangeEvent build() {
			return new ChangeEvent.ChangeEventImpl(this);
		}
		
		@Override
		public ChangeEvent.ChangeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ChangeEvent.ChangeEventBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ChangeEvent.ChangeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ChangeEvent.ChangeEventBuilder o = (ChangeEvent.ChangeEventBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ChangeEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
