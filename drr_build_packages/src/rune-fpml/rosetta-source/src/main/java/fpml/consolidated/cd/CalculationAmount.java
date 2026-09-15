package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.CalculationAmountMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Step;
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
@RosettaDataType(value="CalculationAmount", builder=CalculationAmount.CalculationAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationAmount", model="fpml", builder=CalculationAmount.CalculationAmountBuilderImpl.class, version="2.1.1")
public interface CalculationAmount extends Money {

	CalculationAmountMeta metaData = new CalculationAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 *
	 */
	List<? extends Step> getStep();

	/*********************** Build Methods  ***********************/
	CalculationAmount build();
	
	CalculationAmount.CalculationAmountBuilder toBuilder();
	
	static CalculationAmount.CalculationAmountBuilder builder() {
		return new CalculationAmount.CalculationAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationAmount> getType() {
		return CalculationAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationAmountBuilder extends CalculationAmount, Money.MoneyBuilder {
		Step.StepBuilder getOrCreateStep(int index);
		@Override
		List<? extends Step.StepBuilder> getStep();
		@Override
		CalculationAmount.CalculationAmountBuilder setId(String id);
		@Override
		CalculationAmount.CalculationAmountBuilder setCurrency(Currency currency);
		@Override
		CalculationAmount.CalculationAmountBuilder setAmount(BigDecimal amount);
		CalculationAmount.CalculationAmountBuilder addStep(Step step);
		CalculationAmount.CalculationAmountBuilder addStep(Step step, int idx);
		CalculationAmount.CalculationAmountBuilder addStep(List<? extends Step> step);
		CalculationAmount.CalculationAmountBuilder setStep(List<? extends Step> step);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		

		CalculationAmount.CalculationAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationAmount  ***********************/
	class CalculationAmountImpl extends Money.MoneyImpl implements CalculationAmount {
		private final List<? extends Step> step;
		
		protected CalculationAmountImpl(CalculationAmount.CalculationAmountBuilder builder) {
			super(builder);
			this.step = ofNullable(builder.getStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public CalculationAmount build() {
			return this;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder toBuilder() {
			CalculationAmount.CalculationAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAmount.CalculationAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStep()).ifPresent(builder::setStep);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAmount {" +
				"step=" + this.step +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationAmount  ***********************/
	class CalculationAmountBuilderImpl extends Money.MoneyBuilderImpl implements CalculationAmount.CalculationAmountBuilder {
	
		protected List<Step.StepBuilder> step = new ArrayList<>();
		
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
		public CalculationAmount.CalculationAmountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public CalculationAmount.CalculationAmountBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public CalculationAmount.CalculationAmountBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public CalculationAmount.CalculationAmountBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder addStep(List<? extends Step> steps) {
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
		public CalculationAmount.CalculationAmountBuilder setStep(List<? extends Step> steps) {
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
		public CalculationAmount build() {
			return new CalculationAmount.CalculationAmountImpl(this);
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAmount.CalculationAmountBuilder prune() {
			super.prune();
			step = step.stream().filter(b->b!=null).<Step.StepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStep()!=null && getStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAmount.CalculationAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CalculationAmount.CalculationAmountBuilder o = (CalculationAmount.CalculationAmountBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAmountBuilder {" +
				"step=" + this.step +
			'}' + " " + super.toString();
		}
	}
}
