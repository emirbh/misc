package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.shared.meta.NonNegativeScheduleMeta;
import java.math.BigDecimal;
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
 * Provision A type defining a schedule of non-negative rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a schedule of non-negative rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 *
 */
@RosettaDataType(value="NonNegativeSchedule", builder=NonNegativeSchedule.NonNegativeScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonNegativeSchedule", model="fpml", builder=NonNegativeSchedule.NonNegativeScheduleBuilderImpl.class, version="2.1.1")
public interface NonNegativeSchedule extends RosettaModelObject {

	NonNegativeScheduleMeta metaData = new NonNegativeScheduleMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The non-negative initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The non-negative initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getInitialValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The schedule of step date and non-negative value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The schedule of step date and non-negative value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 *
	 */
	List<? extends NonNegativeStep> getStep();

	/*********************** Build Methods  ***********************/
	NonNegativeSchedule build();
	
	NonNegativeSchedule.NonNegativeScheduleBuilder toBuilder();
	
	static NonNegativeSchedule.NonNegativeScheduleBuilder builder() {
		return new NonNegativeSchedule.NonNegativeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativeSchedule> getType() {
		return NonNegativeSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeScheduleBuilder extends NonNegativeSchedule, RosettaModelObjectBuilder {
		NonNegativeStep.NonNegativeStepBuilder getOrCreateStep(int index);
		@Override
		List<? extends NonNegativeStep.NonNegativeStepBuilder> getStep();
		NonNegativeSchedule.NonNegativeScheduleBuilder setId(String id);
		NonNegativeSchedule.NonNegativeScheduleBuilder setInitialValue(BigDecimal initialValue);
		NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep step);
		NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep step, int idx);
		NonNegativeSchedule.NonNegativeScheduleBuilder addStep(List<? extends NonNegativeStep> step);
		NonNegativeSchedule.NonNegativeScheduleBuilder setStep(List<? extends NonNegativeStep> step);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
		}
		

		NonNegativeSchedule.NonNegativeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeSchedule  ***********************/
	class NonNegativeScheduleImpl implements NonNegativeSchedule {
		private final String id;
		private final BigDecimal initialValue;
		private final List<? extends NonNegativeStep> step;
		
		protected NonNegativeScheduleImpl(NonNegativeSchedule.NonNegativeScheduleBuilder builder) {
			this.id = builder.getId();
			this.initialValue = builder.getInitialValue();
			this.step = ofNullable(builder.getStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("step")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("step")
		public List<? extends NonNegativeStep> getStep() {
			return step;
		}
		
		@Override
		public NonNegativeSchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder toBuilder() {
			NonNegativeSchedule.NonNegativeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeSchedule.NonNegativeScheduleBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getInitialValue()).ifPresent(builder::setInitialValue);
			ofNullable(getStep()).ifPresent(builder::setStep);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeSchedule {" +
				"id=" + this.id + ", " +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step +
			'}';
		}
	}

	/*********************** Builder Implementation of NonNegativeSchedule  ***********************/
	class NonNegativeScheduleBuilderImpl implements NonNegativeSchedule.NonNegativeScheduleBuilder {
	
		protected String id;
		protected BigDecimal initialValue;
		protected List<NonNegativeStep.NonNegativeStepBuilder> step = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("step")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("step")
		public List<? extends NonNegativeStep.NonNegativeStepBuilder> getStep() {
			return step;
		}
		
		@Override
		public NonNegativeStep.NonNegativeStepBuilder getOrCreateStep(int index) {
			if (step==null) {
				this.step = new ArrayList<>();
			}
			return getIndex(step, index, () -> {
						NonNegativeStep.NonNegativeStepBuilder newStep = NonNegativeStep.builder();
						return newStep;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder addStep(List<? extends NonNegativeStep> steps) {
			if (steps != null) {
				for (final NonNegativeStep toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("step")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder setStep(List<? extends NonNegativeStep> steps) {
			if (steps == null) {
				this.step = new ArrayList<>();
			} else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public NonNegativeSchedule build() {
			return new NonNegativeSchedule.NonNegativeScheduleImpl(this);
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder prune() {
			step = step.stream().filter(b->b!=null).<NonNegativeStep.NonNegativeStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getInitialValue()!=null) return true;
			if (getStep()!=null && getStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonNegativeSchedule.NonNegativeScheduleBuilder o = (NonNegativeSchedule.NonNegativeScheduleBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getInitialValue(), o.getInitialValue(), this::setInitialValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeScheduleBuilder {" +
				"id=" + this.id + ", " +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step +
			'}';
		}
	}
}
