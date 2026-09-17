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
import fpml.consolidated.shared.meta.NotionalAmountMeta;
import java.math.BigDecimal;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A complex type to specify the notional amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to specify the notional amount.
 *
 */
@RosettaDataType(value="NotionalAmount", builder=NotionalAmount.NotionalAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NotionalAmount", model="fpml", builder=NotionalAmount.NotionalAmountBuilderImpl.class, version="2.1.1")
public interface NotionalAmount extends NonNegativeMoney {

	NotionalAmountMeta metaData = new NotionalAmountMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NotionalAmount build();
	
	NotionalAmount.NotionalAmountBuilder toBuilder();
	
	static NotionalAmount.NotionalAmountBuilder builder() {
		return new NotionalAmount.NotionalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalAmount> getType() {
		return NotionalAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmountBuilder extends NotionalAmount, NonNegativeMoney.NonNegativeMoneyBuilder {
		@Override
		NotionalAmount.NotionalAmountBuilder setId(String id);
		@Override
		NotionalAmount.NotionalAmountBuilder setCurrency(Currency currency);
		@Override
		NotionalAmount.NotionalAmountBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		NotionalAmount.NotionalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalAmount  ***********************/
	class NotionalAmountImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements NotionalAmount {
		
		protected NotionalAmountImpl(NotionalAmount.NotionalAmountBuilder builder) {
			super(builder);
		}
		
		@Override
		public NotionalAmount build() {
			return this;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder toBuilder() {
			NotionalAmount.NotionalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmount.NotionalAmountBuilder builder) {
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
			return "NotionalAmount {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NotionalAmount  ***********************/
	class NotionalAmountBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl implements NotionalAmount.NotionalAmountBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NotionalAmount.NotionalAmountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public NotionalAmount.NotionalAmountBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public NotionalAmount.NotionalAmountBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public NotionalAmount build() {
			return new NotionalAmount.NotionalAmountImpl(this);
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount.NotionalAmountBuilder prune() {
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
		public NotionalAmount.NotionalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NotionalAmount.NotionalAmountBuilder o = (NotionalAmount.NotionalAmountBuilder) other;
			
			
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
			return "NotionalAmountBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
