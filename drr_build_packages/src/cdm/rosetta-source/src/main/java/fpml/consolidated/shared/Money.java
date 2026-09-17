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
import fpml.consolidated.shared.meta.MoneyMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a currency amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a currency amount.
 *
 */
@RosettaDataType(value="Money", builder=Money.MoneyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Money", model="fpml", builder=Money.MoneyBuilderImpl.class, version="2.1.1")
public interface Money extends MoneyBase {

	MoneyMeta metaData = new MoneyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The monetary quantity in currency units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The monetary quantity in currency units.
	 *
	 */
	BigDecimal getAmount();

	/*********************** Build Methods  ***********************/
	Money build();
	
	Money.MoneyBuilder toBuilder();
	
	static Money.MoneyBuilder builder() {
		return new Money.MoneyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Money> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Money> getType() {
		return Money.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyBuilder extends Money, MoneyBase.MoneyBaseBuilder {
		@Override
		Money.MoneyBuilder setId(String id);
		@Override
		Money.MoneyBuilder setCurrency(Currency currency);
		Money.MoneyBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		Money.MoneyBuilder prune();
	}

	/*********************** Immutable Implementation of Money  ***********************/
	class MoneyImpl extends MoneyBase.MoneyBaseImpl implements Money {
		private final BigDecimal amount;
		
		protected MoneyImpl(Money.MoneyBuilder builder) {
			super(builder);
			this.amount = builder.getAmount();
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public Money build() {
			return this;
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			Money.MoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Money.MoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Money {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Money  ***********************/
	class MoneyBuilderImpl extends MoneyBase.MoneyBaseBuilderImpl implements Money.MoneyBuilder {
	
		protected BigDecimal amount;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Money.MoneyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public Money.MoneyBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public Money.MoneyBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public Money build() {
			return new Money.MoneyImpl(this);
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Money.MoneyBuilder o = (Money.MoneyBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
