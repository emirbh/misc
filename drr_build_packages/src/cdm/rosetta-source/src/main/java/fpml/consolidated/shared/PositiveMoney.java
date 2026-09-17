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
import fpml.consolidated.shared.meta.PositiveMoneyMeta;
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
 * Provision A type defining a positive money amount
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a positive money amount
 *
 */
@RosettaDataType(value="PositiveMoney", builder=PositiveMoney.PositiveMoneyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PositiveMoney", model="fpml", builder=PositiveMoney.PositiveMoneyBuilderImpl.class, version="2.1.1")
public interface PositiveMoney extends MoneyBase {

	PositiveMoneyMeta metaData = new PositiveMoneyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The positive monetary quantity in currency units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The positive monetary quantity in currency units.
	 *
	 */
	BigDecimal getAmount();

	/*********************** Build Methods  ***********************/
	PositiveMoney build();
	
	PositiveMoney.PositiveMoneyBuilder toBuilder();
	
	static PositiveMoney.PositiveMoneyBuilder builder() {
		return new PositiveMoney.PositiveMoneyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PositiveMoney> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PositiveMoney> getType() {
		return PositiveMoney.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PositiveMoneyBuilder extends PositiveMoney, MoneyBase.MoneyBaseBuilder {
		@Override
		PositiveMoney.PositiveMoneyBuilder setId(String id);
		@Override
		PositiveMoney.PositiveMoneyBuilder setCurrency(Currency currency);
		PositiveMoney.PositiveMoneyBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		PositiveMoney.PositiveMoneyBuilder prune();
	}

	/*********************** Immutable Implementation of PositiveMoney  ***********************/
	class PositiveMoneyImpl extends MoneyBase.MoneyBaseImpl implements PositiveMoney {
		private final BigDecimal amount;
		
		protected PositiveMoneyImpl(PositiveMoney.PositiveMoneyBuilder builder) {
			super(builder);
			this.amount = builder.getAmount();
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public PositiveMoney build() {
			return this;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder toBuilder() {
			PositiveMoney.PositiveMoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PositiveMoney.PositiveMoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PositiveMoney _that = getType().cast(o);
		
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
			return "PositiveMoney {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PositiveMoney  ***********************/
	class PositiveMoneyBuilderImpl extends MoneyBase.MoneyBaseBuilderImpl implements PositiveMoney.PositiveMoneyBuilder {
	
		protected BigDecimal amount;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PositiveMoney.PositiveMoneyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public PositiveMoney.PositiveMoneyBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public PositiveMoney.PositiveMoneyBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public PositiveMoney build() {
			return new PositiveMoney.PositiveMoneyImpl(this);
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PositiveMoney.PositiveMoneyBuilder prune() {
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
		public PositiveMoney.PositiveMoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PositiveMoney.PositiveMoneyBuilder o = (PositiveMoney.PositiveMoneyBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PositiveMoney _that = getType().cast(o);
		
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
			return "PositiveMoneyBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
