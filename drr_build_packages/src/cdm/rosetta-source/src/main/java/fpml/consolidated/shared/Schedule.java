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
import fpml.consolidated.shared.meta.ScheduleMeta;
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
 * Provision A type defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date, the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date, the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 *
 */
@RosettaDataType(value="Schedule", builder=Schedule.ScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Schedule", model="fpml", builder=Schedule.ScheduleBuilderImpl.class, version="2.1.1")
public interface Schedule extends RosettaModelObject {

	ScheduleMeta metaData = new ScheduleMeta();

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
	 * Provision The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getInitialValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The schedule of step date and value pairs. On each step date, the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The schedule of step date and value pairs. On each step date, the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 *
	 */
	List<? extends Step> getStep();

	/*********************** Build Methods  ***********************/
	Schedule build();
	
	Schedule.ScheduleBuilder toBuilder();
	
	static Schedule.ScheduleBuilder builder() {
		return new Schedule.ScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Schedule> getType() {
		return Schedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ScheduleBuilder extends Schedule, RosettaModelObjectBuilder {
		Step.StepBuilder getOrCreateStep(int index);
		@Override
		List<? extends Step.StepBuilder> getStep();
		Schedule.ScheduleBuilder setId(String id);
		Schedule.ScheduleBuilder setInitialValue(BigDecimal initialValue);
		Schedule.ScheduleBuilder addStep(Step step);
		Schedule.ScheduleBuilder addStep(Step step, int idx);
		Schedule.ScheduleBuilder addStep(List<? extends Step> step);
		Schedule.ScheduleBuilder setStep(List<? extends Step> step);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		

		Schedule.ScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of Schedule  ***********************/
	class ScheduleImpl implements Schedule {
		private final String id;
		private final BigDecimal initialValue;
		private final List<? extends Step> step;
		
		protected ScheduleImpl(Schedule.ScheduleBuilder builder) {
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
		public List<? extends Step> getStep() {
			return step;
		}
		
		@Override
		public Schedule build() {
			return this;
		}
		
		@Override
		public Schedule.ScheduleBuilder toBuilder() {
			Schedule.ScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedule.ScheduleBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getInitialValue()).ifPresent(builder::setInitialValue);
			ofNullable(getStep()).ifPresent(builder::setStep);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule _that = getType().cast(o);
		
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
			return "Schedule {" +
				"id=" + this.id + ", " +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedule  ***********************/
	class ScheduleBuilderImpl implements Schedule.ScheduleBuilder {
	
		protected String id;
		protected BigDecimal initialValue;
		protected List<Step.StepBuilder> step = new ArrayList<>();
		
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
		public List<? extends Step.StepBuilder> getStep() {
			return step;
		}
		
		@Override
		public Step.StepBuilder getOrCreateStep(int index) {
			if (step==null) {
				this.step = new ArrayList<>();
			}
			return getIndex(step, index, () -> {
						Step.StepBuilder newStep = Step.builder();
						return newStep;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Schedule.ScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public Schedule.ScheduleBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public Schedule.ScheduleBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public Schedule.ScheduleBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public Schedule.ScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (final Step toAdd : steps) {
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
		public Schedule.ScheduleBuilder setStep(List<? extends Step> steps) {
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
		public Schedule build() {
			return new Schedule.ScheduleImpl(this);
		}
		
		@Override
		public Schedule.ScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule.ScheduleBuilder prune() {
			step = step.stream().filter(b->b!=null).<Step.StepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
		public Schedule.ScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedule.ScheduleBuilder o = (Schedule.ScheduleBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getInitialValue(), o.getInitialValue(), this::setInitialValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule _that = getType().cast(o);
		
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
			return "ScheduleBuilder {" +
				"id=" + this.id + ", " +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step +
			'}';
		}
	}
}
