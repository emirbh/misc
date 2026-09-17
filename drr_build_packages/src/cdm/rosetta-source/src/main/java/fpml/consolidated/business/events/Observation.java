package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ObservationMeta;
import java.math.BigDecimal;
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
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="Observation", builder=Observation.ObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Observation", model="fpml", builder=Observation.ObservationBuilderImpl.class, version="2.1.1")
public interface Observation extends RosettaModelObject {

	ObservationMeta metaData = new ObservationMeta();

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
	ObservationReference getObservationReference();
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
	BigDecimal getWeight();

	/*********************** Build Methods  ***********************/
	Observation build();
	
	Observation.ObservationBuilder toBuilder();
	
	static Observation.ObservationBuilder builder() {
		return new Observation.ObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Observation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Observation> getType() {
		return Observation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observationReference"), processor, ObservationReference.class, getObservationReference());
		processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationBuilder extends Observation, RosettaModelObjectBuilder {
		ObservationReference.ObservationReferenceBuilder getOrCreateObservationReference();
		@Override
		ObservationReference.ObservationReferenceBuilder getObservationReference();
		Observation.ObservationBuilder setObservationReference(ObservationReference observationReference);
		Observation.ObservationBuilder setWeight(BigDecimal weight);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observationReference"), processor, ObservationReference.ObservationReferenceBuilder.class, getObservationReference());
			processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
		}
		

		Observation.ObservationBuilder prune();
	}

	/*********************** Immutable Implementation of Observation  ***********************/
	class ObservationImpl implements Observation {
		private final ObservationReference observationReference;
		private final BigDecimal weight;
		
		protected ObservationImpl(Observation.ObservationBuilder builder) {
			this.observationReference = ofNullable(builder.getObservationReference()).map(f->f.build()).orElse(null);
			this.weight = builder.getWeight();
		}
		
		@Override
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationReference")
		public ObservationReference getObservationReference() {
			return observationReference;
		}
		
		@Override
		@RosettaAttribute("weight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		public Observation build() {
			return this;
		}
		
		@Override
		public Observation.ObservationBuilder toBuilder() {
			Observation.ObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Observation.ObservationBuilder builder) {
			ofNullable(getObservationReference()).ifPresent(builder::setObservationReference);
			ofNullable(getWeight()).ifPresent(builder::setWeight);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observation _that = getType().cast(o);
		
			if (!Objects.equals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Observation {" +
				"observationReference=" + this.observationReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}

	/*********************** Builder Implementation of Observation  ***********************/
	class ObservationBuilderImpl implements Observation.ObservationBuilder {
	
		protected ObservationReference.ObservationReferenceBuilder observationReference;
		protected BigDecimal weight;
		
		@Override
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationReference")
		public ObservationReference.ObservationReferenceBuilder getObservationReference() {
			return observationReference;
		}
		
		@Override
		public ObservationReference.ObservationReferenceBuilder getOrCreateObservationReference() {
			ObservationReference.ObservationReferenceBuilder result;
			if (observationReference!=null) {
				result = observationReference;
			}
			else {
				result = observationReference = ObservationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationReference")
		@Override
		public Observation.ObservationBuilder setObservationReference(ObservationReference _observationReference) {
			this.observationReference = _observationReference == null ? null : _observationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weight")
		@Override
		public Observation.ObservationBuilder setWeight(BigDecimal _weight) {
			this.weight = _weight == null ? null : _weight;
			return this;
		}
		
		@Override
		public Observation build() {
			return new Observation.ObservationImpl(this);
		}
		
		@Override
		public Observation.ObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observation.ObservationBuilder prune() {
			if (observationReference!=null && !observationReference.prune().hasData()) observationReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationReference()!=null && getObservationReference().hasData()) return true;
			if (getWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observation.ObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Observation.ObservationBuilder o = (Observation.ObservationBuilder) other;
			
			merger.mergeRosetta(getObservationReference(), o.getObservationReference(), this::setObservationReference);
			
			merger.mergeBasic(getWeight(), o.getWeight(), this::setWeight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observation _that = getType().cast(o);
		
			if (!Objects.equals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationBuilder {" +
				"observationReference=" + this.observationReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}
}
