package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualStrikeMeta;
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
 * Provision A shared type between accrual forwards and options where the FX accrual strike reference can point to.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A shared type between accrual forwards and options where the FX accrual strike reference can point to.
 *
 */
@RosettaDataType(value="FxAccrualStrike", builder=FxAccrualStrike.FxAccrualStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualStrike", model="fpml", builder=FxAccrualStrike.FxAccrualStrikeBuilderImpl.class, version="2.1.1")
public interface FxAccrualStrike extends Schedule {

	FxAccrualStrikeMeta metaData = new FxAccrualStrikeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxAccrualStrike build();
	
	FxAccrualStrike.FxAccrualStrikeBuilder toBuilder();
	
	static FxAccrualStrike.FxAccrualStrikeBuilder builder() {
		return new FxAccrualStrike.FxAccrualStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualStrike> getType() {
		return FxAccrualStrike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualStrikeBuilder extends FxAccrualStrike, Schedule.ScheduleBuilder {
		@Override
		FxAccrualStrike.FxAccrualStrikeBuilder setId(String id);
		@Override
		FxAccrualStrike.FxAccrualStrikeBuilder setInitialValue(BigDecimal initialValue);
		@Override
		FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step step);
		@Override
		FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step step, int idx);
		@Override
		FxAccrualStrike.FxAccrualStrikeBuilder addStep(List<? extends Step> step);
		@Override
		FxAccrualStrike.FxAccrualStrikeBuilder setStep(List<? extends Step> step);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		

		FxAccrualStrike.FxAccrualStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualStrike  ***********************/
	class FxAccrualStrikeImpl extends Schedule.ScheduleImpl implements FxAccrualStrike {
		
		protected FxAccrualStrikeImpl(FxAccrualStrike.FxAccrualStrikeBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxAccrualStrike build() {
			return this;
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder toBuilder() {
			FxAccrualStrike.FxAccrualStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualStrike.FxAccrualStrikeBuilder builder) {
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
			return "FxAccrualStrike {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualStrike  ***********************/
	class FxAccrualStrikeBuilderImpl extends Schedule.ScheduleBuilderImpl implements FxAccrualStrike.FxAccrualStrikeBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder addStep(List<? extends Step> steps) {
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
		public FxAccrualStrike.FxAccrualStrikeBuilder setStep(List<? extends Step> steps) {
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
		public FxAccrualStrike build() {
			return new FxAccrualStrike.FxAccrualStrikeImpl(this);
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder prune() {
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
		public FxAccrualStrike.FxAccrualStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualStrike.FxAccrualStrikeBuilder o = (FxAccrualStrike.FxAccrualStrikeBuilder) other;
			
			
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
			return "FxAccrualStrikeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
