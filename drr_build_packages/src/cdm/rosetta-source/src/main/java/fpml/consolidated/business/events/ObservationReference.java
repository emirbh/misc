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
import fpml.consolidated.business.events.meta.ObservationReferenceMeta;
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
 * Provision Reference to the observation details of a particular rate observation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to the observation details of a particular rate observation.
 *
 */
@RosettaDataType(value="ObservationReference", builder=ObservationReference.ObservationReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservationReference", model="fpml", builder=ObservationReference.ObservationReferenceBuilderImpl.class, version="2.1.1")
public interface ObservationReference extends AbstractEvent {

	ObservationReferenceMeta metaData = new ObservationReferenceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObservationReference build();
	
	ObservationReference.ObservationReferenceBuilder toBuilder();
	
	static ObservationReference.ObservationReferenceBuilder builder() {
		return new ObservationReference.ObservationReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationReference> getType() {
		return ObservationReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationReferenceBuilder extends ObservationReference, AbstractEvent.AbstractEventBuilder {
		@Override
		ObservationReference.ObservationReferenceBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		ObservationReference.ObservationReferenceBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		ObservationReference.ObservationReferenceBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		ObservationReference.ObservationReferenceBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		ObservationReference.ObservationReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationReference  ***********************/
	class ObservationReferenceImpl extends AbstractEvent.AbstractEventImpl implements ObservationReference {
		
		protected ObservationReferenceImpl(ObservationReference.ObservationReferenceBuilder builder) {
			super(builder);
		}
		
		@Override
		public ObservationReference build() {
			return this;
		}
		
		@Override
		public ObservationReference.ObservationReferenceBuilder toBuilder() {
			ObservationReference.ObservationReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationReference.ObservationReferenceBuilder builder) {
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
			return "ObservationReference {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObservationReference  ***********************/
	class ObservationReferenceBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements ObservationReference.ObservationReferenceBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ObservationReference.ObservationReferenceBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ObservationReference.ObservationReferenceBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ObservationReference.ObservationReferenceBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public ObservationReference.ObservationReferenceBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public ObservationReference build() {
			return new ObservationReference.ObservationReferenceImpl(this);
		}
		
		@Override
		public ObservationReference.ObservationReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationReference.ObservationReferenceBuilder prune() {
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
		public ObservationReference.ObservationReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ObservationReference.ObservationReferenceBuilder o = (ObservationReference.ObservationReferenceBuilder) other;
			
			
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
			return "ObservationReferenceBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
