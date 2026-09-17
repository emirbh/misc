package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.WeightedPartialDerivativeMeta;
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
 * Provision A partial derivative multiplied by a weighting factor.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A partial derivative multiplied by a weighting factor.
 *
 */
@RosettaDataType(value="WeightedPartialDerivative", builder=WeightedPartialDerivative.WeightedPartialDerivativeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeightedPartialDerivative", model="fpml", builder=WeightedPartialDerivative.WeightedPartialDerivativeBuilderImpl.class, version="2.1.1")
public interface WeightedPartialDerivative extends RosettaModelObject {

	WeightedPartialDerivativeMeta metaData = new WeightedPartialDerivativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to a partial derivative defined in the ComputedDerivative.model, i.e. defined as part of this sensitivity definition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a partial derivative defined in the ComputedDerivative.model, i.e. defined as part of this sensitivity definition.
	 *
	 */
	PricingParameterDerivativeReference getPartialDerivativeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The weight factor to be applied to the partial derivative, e.g. 1 or -1, or some other scaling value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The weight factor to be applied to the partial derivative, e.g. 1 or -1, or some other scaling value.
	 *
	 */
	BigDecimal getWeight();

	/*********************** Build Methods  ***********************/
	WeightedPartialDerivative build();
	
	WeightedPartialDerivative.WeightedPartialDerivativeBuilder toBuilder();
	
	static WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder() {
		return new WeightedPartialDerivative.WeightedPartialDerivativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeightedPartialDerivative> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeightedPartialDerivative> getType() {
		return WeightedPartialDerivative.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.class, getPartialDerivativeReference());
		processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeightedPartialDerivativeBuilder extends WeightedPartialDerivative, RosettaModelObjectBuilder {
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference();
		@Override
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getPartialDerivativeReference();
		WeightedPartialDerivative.WeightedPartialDerivativeBuilder setPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference);
		WeightedPartialDerivative.WeightedPartialDerivativeBuilder setWeight(BigDecimal weight);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder.class, getPartialDerivativeReference());
			processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
		}
		

		WeightedPartialDerivative.WeightedPartialDerivativeBuilder prune();
	}

	/*********************** Immutable Implementation of WeightedPartialDerivative  ***********************/
	class WeightedPartialDerivativeImpl implements WeightedPartialDerivative {
		private final PricingParameterDerivativeReference partialDerivativeReference;
		private final BigDecimal weight;
		
		protected WeightedPartialDerivativeImpl(WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder) {
			this.partialDerivativeReference = ofNullable(builder.getPartialDerivativeReference()).map(f->f.build()).orElse(null);
			this.weight = builder.getWeight();
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partialDerivativeReference")
		public PricingParameterDerivativeReference getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		@RosettaAttribute("weight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		public WeightedPartialDerivative build() {
			return this;
		}
		
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder toBuilder() {
			WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder) {
			ofNullable(getPartialDerivativeReference()).ifPresent(builder::setPartialDerivativeReference);
			ofNullable(getWeight()).ifPresent(builder::setWeight);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeightedPartialDerivative _that = getType().cast(o);
		
			if (!Objects.equals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeightedPartialDerivative {" +
				"partialDerivativeReference=" + this.partialDerivativeReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}

	/*********************** Builder Implementation of WeightedPartialDerivative  ***********************/
	class WeightedPartialDerivativeBuilderImpl implements WeightedPartialDerivative.WeightedPartialDerivativeBuilder {
	
		protected PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder partialDerivativeReference;
		protected BigDecimal weight;
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partialDerivativeReference")
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference() {
			PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder result;
			if (partialDerivativeReference!=null) {
				result = partialDerivativeReference;
			}
			else {
				result = partialDerivativeReference = PricingParameterDerivativeReference.builder();
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
		
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partialDerivativeReference")
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder setPartialDerivativeReference(PricingParameterDerivativeReference _partialDerivativeReference) {
			this.partialDerivativeReference = _partialDerivativeReference == null ? null : _partialDerivativeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weight")
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder setWeight(BigDecimal _weight) {
			this.weight = _weight == null ? null : _weight;
			return this;
		}
		
		@Override
		public WeightedPartialDerivative build() {
			return new WeightedPartialDerivative.WeightedPartialDerivativeImpl(this);
		}
		
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder prune() {
			if (partialDerivativeReference!=null && !partialDerivativeReference.prune().hasData()) partialDerivativeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartialDerivativeReference()!=null && getPartialDerivativeReference().hasData()) return true;
			if (getWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeightedPartialDerivative.WeightedPartialDerivativeBuilder o = (WeightedPartialDerivative.WeightedPartialDerivativeBuilder) other;
			
			merger.mergeRosetta(getPartialDerivativeReference(), o.getPartialDerivativeReference(), this::setPartialDerivativeReference);
			
			merger.mergeBasic(getWeight(), o.getWeight(), this::setWeight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeightedPartialDerivative _that = getType().cast(o);
		
			if (!Objects.equals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeightedPartialDerivativeBuilder {" +
				"partialDerivativeReference=" + this.partialDerivativeReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}
}
