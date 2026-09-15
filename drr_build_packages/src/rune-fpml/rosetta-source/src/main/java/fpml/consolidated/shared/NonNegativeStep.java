package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.NonNegativeStepMeta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 *
 */
@RosettaDataType(value="NonNegativeStep", builder=NonNegativeStep.NonNegativeStepBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonNegativeStep", model="fpml", builder=NonNegativeStep.NonNegativeStepBuilderImpl.class, version="2.1.1")
public interface NonNegativeStep extends StepBase {

	NonNegativeStepMeta metaData = new NonNegativeStepMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getStepValue();

	/*********************** Build Methods  ***********************/
	NonNegativeStep build();
	
	NonNegativeStep.NonNegativeStepBuilder toBuilder();
	
	static NonNegativeStep.NonNegativeStepBuilder builder() {
		return new NonNegativeStep.NonNegativeStepBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeStep> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativeStep> getType() {
		return NonNegativeStep.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("stepDate"), ZonedDateTime.class, getStepDate(), this);
		processor.processBasic(path.newSubPath("stepValue"), BigDecimal.class, getStepValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeStepBuilder extends NonNegativeStep, StepBase.StepBaseBuilder {
		@Override
		NonNegativeStep.NonNegativeStepBuilder setId(String id);
		@Override
		NonNegativeStep.NonNegativeStepBuilder setStepDate(ZonedDateTime stepDate);
		NonNegativeStep.NonNegativeStepBuilder setStepValue(BigDecimal stepValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("stepDate"), ZonedDateTime.class, getStepDate(), this);
			processor.processBasic(path.newSubPath("stepValue"), BigDecimal.class, getStepValue(), this);
		}
		

		NonNegativeStep.NonNegativeStepBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeStep  ***********************/
	class NonNegativeStepImpl extends StepBase.StepBaseImpl implements NonNegativeStep {
		private final BigDecimal stepValue;
		
		protected NonNegativeStepImpl(NonNegativeStep.NonNegativeStepBuilder builder) {
			super(builder);
			this.stepValue = builder.getStepValue();
		}
		
		@Override
		@RosettaAttribute("stepValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepValue")
		public BigDecimal getStepValue() {
			return stepValue;
		}
		
		@Override
		public NonNegativeStep build() {
			return this;
		}
		
		@Override
		public NonNegativeStep.NonNegativeStepBuilder toBuilder() {
			NonNegativeStep.NonNegativeStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeStep.NonNegativeStepBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStepValue()).ifPresent(builder::setStepValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeStep _that = getType().cast(o);
		
			if (!Objects.equals(stepValue, _that.getStepValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (stepValue != null ? stepValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeStep {" +
				"stepValue=" + this.stepValue +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeStep  ***********************/
	class NonNegativeStepBuilderImpl extends StepBase.StepBaseBuilderImpl implements NonNegativeStep.NonNegativeStepBuilder {
	
		protected BigDecimal stepValue;
		
		@Override
		@RosettaAttribute("stepValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepValue")
		public BigDecimal getStepValue() {
			return stepValue;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("stepDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepDate")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder setStepDate(ZonedDateTime _stepDate) {
			this.stepDate = _stepDate == null ? null : _stepDate;
			return this;
		}
		
		@RosettaAttribute("stepValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepValue")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder setStepValue(BigDecimal _stepValue) {
			this.stepValue = _stepValue == null ? null : _stepValue;
			return this;
		}
		
		@Override
		public NonNegativeStep build() {
			return new NonNegativeStep.NonNegativeStepImpl(this);
		}
		
		@Override
		public NonNegativeStep.NonNegativeStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStepValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonNegativeStep.NonNegativeStepBuilder o = (NonNegativeStep.NonNegativeStepBuilder) other;
			
			
			merger.mergeBasic(getStepValue(), o.getStepValue(), this::setStepValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeStep _that = getType().cast(o);
		
			if (!Objects.equals(stepValue, _that.getStepValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (stepValue != null ? stepValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeStepBuilder {" +
				"stepValue=" + this.stepValue +
			'}' + " " + super.toString();
		}
	}
}
