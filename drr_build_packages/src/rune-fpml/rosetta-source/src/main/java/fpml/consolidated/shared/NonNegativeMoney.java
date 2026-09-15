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
import fpml.consolidated.shared.meta.NonNegativeMoneyMeta;
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
 * Provision A type defining a non negative money amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a non negative money amount.
 *
 */
@RosettaDataType(value="NonNegativeMoney", builder=NonNegativeMoney.NonNegativeMoneyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonNegativeMoney", model="fpml", builder=NonNegativeMoney.NonNegativeMoneyBuilderImpl.class, version="2.1.1")
public interface NonNegativeMoney extends MoneyBase {

	NonNegativeMoneyMeta metaData = new NonNegativeMoneyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The non negative monetary quantity in currency units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The non negative monetary quantity in currency units.
	 *
	 */
	BigDecimal getAmount();

	/*********************** Build Methods  ***********************/
	NonNegativeMoney build();
	
	NonNegativeMoney.NonNegativeMoneyBuilder toBuilder();
	
	static NonNegativeMoney.NonNegativeMoneyBuilder builder() {
		return new NonNegativeMoney.NonNegativeMoneyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeMoney> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativeMoney> getType() {
		return NonNegativeMoney.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeMoneyBuilder extends NonNegativeMoney, MoneyBase.MoneyBaseBuilder {
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder setId(String id);
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder setCurrency(Currency currency);
		NonNegativeMoney.NonNegativeMoneyBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		NonNegativeMoney.NonNegativeMoneyBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeMoney  ***********************/
	class NonNegativeMoneyImpl extends MoneyBase.MoneyBaseImpl implements NonNegativeMoney {
		private final BigDecimal amount;
		
		protected NonNegativeMoneyImpl(NonNegativeMoney.NonNegativeMoneyBuilder builder) {
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
		public NonNegativeMoney build() {
			return this;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder toBuilder() {
			NonNegativeMoney.NonNegativeMoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeMoney.NonNegativeMoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeMoney _that = getType().cast(o);
		
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
			return "NonNegativeMoney {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeMoney  ***********************/
	class NonNegativeMoneyBuilderImpl extends MoneyBase.MoneyBaseBuilderImpl implements NonNegativeMoney.NonNegativeMoneyBuilder {
	
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
		public NonNegativeMoney.NonNegativeMoneyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public NonNegativeMoney build() {
			return new NonNegativeMoney.NonNegativeMoneyImpl(this);
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder prune() {
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
		public NonNegativeMoney.NonNegativeMoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonNegativeMoney.NonNegativeMoneyBuilder o = (NonNegativeMoney.NonNegativeMoneyBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeMoney _that = getType().cast(o);
		
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
			return "NonNegativeMoneyBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
