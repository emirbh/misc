package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxLevelMeta;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
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
 * Provision Level is expressed as Schedule, with an initial value and optional steps.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Level is expressed as Schedule, with an initial value and optional steps.
 *
 */
@RosettaDataType(value="FxLevel", builder=FxLevel.FxLevelBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxLevel", model="fpml", builder=FxLevel.FxLevelBuilderImpl.class, version="2.1.1")
public interface FxLevel extends Schedule {

	FxLevelMeta metaData = new FxLevelMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxLevel build();
	
	FxLevel.FxLevelBuilder toBuilder();
	
	static FxLevel.FxLevelBuilder builder() {
		return new FxLevel.FxLevelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxLevel> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxLevel> getType() {
		return FxLevel.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxLevelBuilder extends FxLevel, Schedule.ScheduleBuilder {
		@Override
		FxLevel.FxLevelBuilder setId(String id);
		@Override
		FxLevel.FxLevelBuilder setInitialValue(BigDecimal initialValue);
		@Override
		FxLevel.FxLevelBuilder addStep(Step step);
		@Override
		FxLevel.FxLevelBuilder addStep(Step step, int idx);
		@Override
		FxLevel.FxLevelBuilder addStep(List<? extends Step> step);
		@Override
		FxLevel.FxLevelBuilder setStep(List<? extends Step> step);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		

		FxLevel.FxLevelBuilder prune();
	}

	/*********************** Immutable Implementation of FxLevel  ***********************/
	class FxLevelImpl extends Schedule.ScheduleImpl implements FxLevel {
		
		protected FxLevelImpl(FxLevel.FxLevelBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxLevel build() {
			return this;
		}
		
		@Override
		public FxLevel.FxLevelBuilder toBuilder() {
			FxLevel.FxLevelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxLevel.FxLevelBuilder builder) {
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
			return "FxLevel {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxLevel  ***********************/
	class FxLevelBuilderImpl extends Schedule.ScheduleBuilderImpl implements FxLevel.FxLevelBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxLevel.FxLevelBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public FxLevel.FxLevelBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxLevel.FxLevelBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxLevel.FxLevelBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public FxLevel.FxLevelBuilder addStep(List<? extends Step> steps) {
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
		public FxLevel.FxLevelBuilder setStep(List<? extends Step> steps) {
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
		public FxLevel build() {
			return new FxLevel.FxLevelImpl(this);
		}
		
		@Override
		public FxLevel.FxLevelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLevel.FxLevelBuilder prune() {
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
		public FxLevel.FxLevelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxLevel.FxLevelBuilder o = (FxLevel.FxLevelBuilder) other;
			
			
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
			return "FxLevelBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
