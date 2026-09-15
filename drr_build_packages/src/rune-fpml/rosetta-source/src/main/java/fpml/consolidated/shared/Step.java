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
import fpml.consolidated.shared.meta.StepMeta;
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
 * Provision A type defining a step date and step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a step date and step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 *
 */
@RosettaDataType(value="Step", builder=Step.StepBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Step", model="fpml", builder=Step.StepBuilderImpl.class, version="2.1.1")
public interface Step extends StepBase {

	StepMeta metaData = new StepMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getStepValue();

	/*********************** Build Methods  ***********************/
	Step build();
	
	Step.StepBuilder toBuilder();
	
	static Step.StepBuilder builder() {
		return new Step.StepBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Step> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Step> getType() {
		return Step.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("stepDate"), ZonedDateTime.class, getStepDate(), this);
		processor.processBasic(path.newSubPath("stepValue"), BigDecimal.class, getStepValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StepBuilder extends Step, StepBase.StepBaseBuilder {
		@Override
		Step.StepBuilder setId(String id);
		@Override
		Step.StepBuilder setStepDate(ZonedDateTime stepDate);
		Step.StepBuilder setStepValue(BigDecimal stepValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("stepDate"), ZonedDateTime.class, getStepDate(), this);
			processor.processBasic(path.newSubPath("stepValue"), BigDecimal.class, getStepValue(), this);
		}
		

		Step.StepBuilder prune();
	}

	/*********************** Immutable Implementation of Step  ***********************/
	class StepImpl extends StepBase.StepBaseImpl implements Step {
		private final BigDecimal stepValue;
		
		protected StepImpl(Step.StepBuilder builder) {
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
		public Step build() {
			return this;
		}
		
		@Override
		public Step.StepBuilder toBuilder() {
			Step.StepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Step.StepBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStepValue()).ifPresent(builder::setStepValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Step _that = getType().cast(o);
		
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
			return "Step {" +
				"stepValue=" + this.stepValue +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Step  ***********************/
	class StepBuilderImpl extends StepBase.StepBaseBuilderImpl implements Step.StepBuilder {
	
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
		public Step.StepBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("stepDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepDate")
		@Override
		public Step.StepBuilder setStepDate(ZonedDateTime _stepDate) {
			this.stepDate = _stepDate == null ? null : _stepDate;
			return this;
		}
		
		@RosettaAttribute("stepValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepValue")
		@Override
		public Step.StepBuilder setStepValue(BigDecimal _stepValue) {
			this.stepValue = _stepValue == null ? null : _stepValue;
			return this;
		}
		
		@Override
		public Step build() {
			return new Step.StepImpl(this);
		}
		
		@Override
		public Step.StepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Step.StepBuilder prune() {
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
		public Step.StepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Step.StepBuilder o = (Step.StepBuilder) other;
			
			
			merger.mergeBasic(getStepValue(), o.getStepValue(), this::setStepValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Step _that = getType().cast(o);
		
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
			return "StepBuilder {" +
				"stepValue=" + this.stepValue +
			'}' + " " + super.toString();
		}
	}
}
