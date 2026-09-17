package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.shared.meta.FutureValueAmountMeta;
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
 * Provision A type defining a currency amount as at a future value date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a currency amount as at a future value date.
 *
 */
@RosettaDataType(value="FutureValueAmount", builder=FutureValueAmount.FutureValueAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FutureValueAmount", model="fpml", builder=FutureValueAmount.FutureValueAmountBuilderImpl.class, version="2.1.1")
public interface FutureValueAmount extends NonNegativeMoney {

	FutureValueAmountMeta metaData = new FutureValueAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
	 *
	 */
	Integer getCalculationPeriodNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Adjusted value date of the future value amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Adjusted value date of the future value amount.
	 *
	 */
	ZonedDateTime getValueDate();

	/*********************** Build Methods  ***********************/
	FutureValueAmount build();
	
	FutureValueAmount.FutureValueAmountBuilder toBuilder();
	
	static FutureValueAmount.FutureValueAmountBuilder builder() {
		return new FutureValueAmount.FutureValueAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FutureValueAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FutureValueAmount> getType() {
		return FutureValueAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
		processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FutureValueAmountBuilder extends FutureValueAmount, NonNegativeMoney.NonNegativeMoneyBuilder {
		@Override
		FutureValueAmount.FutureValueAmountBuilder setId(String id);
		@Override
		FutureValueAmount.FutureValueAmountBuilder setCurrency(Currency currency);
		@Override
		FutureValueAmount.FutureValueAmountBuilder setAmount(BigDecimal amount);
		FutureValueAmount.FutureValueAmountBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays);
		FutureValueAmount.FutureValueAmountBuilder setValueDate(ZonedDateTime valueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
			processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
		}
		

		FutureValueAmount.FutureValueAmountBuilder prune();
	}

	/*********************** Immutable Implementation of FutureValueAmount  ***********************/
	class FutureValueAmountImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements FutureValueAmount {
		private final Integer calculationPeriodNumberOfDays;
		private final ZonedDateTime valueDate;
		
		protected FutureValueAmountImpl(FutureValueAmount.FutureValueAmountBuilder builder) {
			super(builder);
			this.calculationPeriodNumberOfDays = builder.getCalculationPeriodNumberOfDays();
			this.valueDate = builder.getValueDate();
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@Override
		public FutureValueAmount build() {
			return this;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder toBuilder() {
			FutureValueAmount.FutureValueAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FutureValueAmount.FutureValueAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCalculationPeriodNumberOfDays()).ifPresent(builder::setCalculationPeriodNumberOfDays);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FutureValueAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureValueAmount {" +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FutureValueAmount  ***********************/
	class FutureValueAmountBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl implements FutureValueAmount.FutureValueAmountBuilder {
	
		protected Integer calculationPeriodNumberOfDays;
		protected ZonedDateTime valueDate;
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setCalculationPeriodNumberOfDays(Integer _calculationPeriodNumberOfDays) {
			this.calculationPeriodNumberOfDays = _calculationPeriodNumberOfDays == null ? null : _calculationPeriodNumberOfDays;
			return this;
		}
		
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valueDate")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setValueDate(ZonedDateTime _valueDate) {
			this.valueDate = _valueDate == null ? null : _valueDate;
			return this;
		}
		
		@Override
		public FutureValueAmount build() {
			return new FutureValueAmount.FutureValueAmountImpl(this);
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCalculationPeriodNumberOfDays()!=null) return true;
			if (getValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FutureValueAmount.FutureValueAmountBuilder o = (FutureValueAmount.FutureValueAmountBuilder) other;
			
			
			merger.mergeBasic(getCalculationPeriodNumberOfDays(), o.getCalculationPeriodNumberOfDays(), this::setCalculationPeriodNumberOfDays);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FutureValueAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureValueAmountBuilder {" +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}
}
