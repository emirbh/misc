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
import fpml.consolidated.fx.targets.meta.FxStrikeMeta;
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
 * Provision Strike is expressed as Schedule, with an initial value and optional steps.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Strike is expressed as Schedule, with an initial value and optional steps.
 *
 */
@RosettaDataType(value="FxStrike", builder=FxStrike.FxStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxStrike", model="fpml", builder=FxStrike.FxStrikeBuilderImpl.class, version="2.1.1")
public interface FxStrike extends Schedule {

	FxStrikeMeta metaData = new FxStrikeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxStrike build();
	
	FxStrike.FxStrikeBuilder toBuilder();
	
	static FxStrike.FxStrikeBuilder builder() {
		return new FxStrike.FxStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxStrike> getType() {
		return FxStrike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStrikeBuilder extends FxStrike, Schedule.ScheduleBuilder {
		@Override
		FxStrike.FxStrikeBuilder setId(String id);
		@Override
		FxStrike.FxStrikeBuilder setInitialValue(BigDecimal initialValue);
		@Override
		FxStrike.FxStrikeBuilder addStep(Step step);
		@Override
		FxStrike.FxStrikeBuilder addStep(Step step, int idx);
		@Override
		FxStrike.FxStrikeBuilder addStep(List<? extends Step> step);
		@Override
		FxStrike.FxStrikeBuilder setStep(List<? extends Step> step);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		

		FxStrike.FxStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of FxStrike  ***********************/
	class FxStrikeImpl extends Schedule.ScheduleImpl implements FxStrike {
		
		protected FxStrikeImpl(FxStrike.FxStrikeBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxStrike build() {
			return this;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder toBuilder() {
			FxStrike.FxStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStrike.FxStrikeBuilder builder) {
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
			return "FxStrike {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxStrike  ***********************/
	class FxStrikeBuilderImpl extends Schedule.ScheduleBuilderImpl implements FxStrike.FxStrikeBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxStrike.FxStrikeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public FxStrike.FxStrikeBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxStrike.FxStrikeBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder addStep(List<? extends Step> steps) {
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
		public FxStrike.FxStrikeBuilder setStep(List<? extends Step> steps) {
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
		public FxStrike build() {
			return new FxStrike.FxStrikeImpl(this);
		}
		
		@Override
		public FxStrike.FxStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStrike.FxStrikeBuilder prune() {
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
		public FxStrike.FxStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxStrike.FxStrikeBuilder o = (FxStrike.FxStrikeBuilder) other;
			
			
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
			return "FxStrikeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
