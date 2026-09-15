package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.NonNegativeAmountScheduleMeta;
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
 * Provision A type defining a currency amount or a currency amount schedule.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a currency amount or a currency amount schedule.
 *
 */
@RosettaDataType(value="NonNegativeAmountSchedule", builder=NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonNegativeAmountSchedule", model="fpml", builder=NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl.class, version="2.1.1")
public interface NonNegativeAmountSchedule extends NonNegativeSchedule {

	NonNegativeAmountScheduleMeta metaData = new NonNegativeAmountScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	NonNegativeAmountSchedule build();
	
	NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder toBuilder();
	
	static NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder() {
		return new NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeAmountSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativeAmountSchedule> getType() {
		return NonNegativeAmountSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeAmountScheduleBuilder extends NonNegativeAmountSchedule, NonNegativeSchedule.NonNegativeScheduleBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setId(String id);
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setInitialValue(BigDecimal initialValue);
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep step);
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep step, int idx);
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(List<? extends NonNegativeStep> step);
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setStep(List<? extends NonNegativeStep> step);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeAmountSchedule  ***********************/
	class NonNegativeAmountScheduleImpl extends NonNegativeSchedule.NonNegativeScheduleImpl implements NonNegativeAmountSchedule {
		private final Currency currency;
		
		protected NonNegativeAmountScheduleImpl(NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public NonNegativeAmountSchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder toBuilder() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeAmountSchedule _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeAmountSchedule {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeAmountSchedule  ***********************/
	class NonNegativeAmountScheduleBuilderImpl extends NonNegativeSchedule.NonNegativeScheduleBuilderImpl implements NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder {
	
		protected Currency.CurrencyBuilder currency;
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(List<? extends NonNegativeStep> steps) {
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
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setStep(List<? extends NonNegativeStep> steps) {
			if (steps == null) {
				this.step = new ArrayList<>();
			} else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule build() {
			return new NonNegativeAmountSchedule.NonNegativeAmountScheduleImpl(this);
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder o = (NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeAmountSchedule _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeAmountScheduleBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
