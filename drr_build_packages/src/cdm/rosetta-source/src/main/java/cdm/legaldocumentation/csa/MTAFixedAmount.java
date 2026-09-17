package cdm.legaldocumentation.csa;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.MTAFixedAmountMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines that the Minimum Transfer Amount (MTA) is a Fixed Amount.
 * @version 6.23.0
 */
@RosettaDataType(value="MTAFixedAmount", builder=MTAFixedAmount.MTAFixedAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MTAFixedAmount", model="cdm", builder=MTAFixedAmount.MTAFixedAmountBuilderImpl.class, version="6.23.0")
public interface MTAFixedAmount extends RosettaModelObject {

	MTAFixedAmountMeta metaData = new MTAFixedAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party to which the Minimum Transfer Amount (MTA) applies.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The amount value applicable to the Minimum Transfer Amount (MTA).
	 */
	Integer getAmount();
	/**
	 * The minimum transfer amount currency code.
	 */
	ISOCurrencyCodeEnum getCurrency();

	/*********************** Build Methods  ***********************/
	MTAFixedAmount build();
	
	MTAFixedAmount.MTAFixedAmountBuilder toBuilder();
	
	static MTAFixedAmount.MTAFixedAmountBuilder builder() {
		return new MTAFixedAmount.MTAFixedAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MTAFixedAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MTAFixedAmount> getType() {
		return MTAFixedAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MTAFixedAmountBuilder extends MTAFixedAmount, RosettaModelObjectBuilder {
		MTAFixedAmount.MTAFixedAmountBuilder setParty(CounterpartyRoleEnum party);
		MTAFixedAmount.MTAFixedAmountBuilder setAmount(Integer amount);
		MTAFixedAmount.MTAFixedAmountBuilder setCurrency(ISOCurrencyCodeEnum currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		}
		

		MTAFixedAmount.MTAFixedAmountBuilder prune();
	}

	/*********************** Immutable Implementation of MTAFixedAmount  ***********************/
	class MTAFixedAmountImpl implements MTAFixedAmount {
		private final CounterpartyRoleEnum party;
		private final Integer amount;
		private final ISOCurrencyCodeEnum currency;
		
		protected MTAFixedAmountImpl(MTAFixedAmount.MTAFixedAmountBuilder builder) {
			this.party = builder.getParty();
			this.amount = builder.getAmount();
			this.currency = builder.getCurrency();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public Integer getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		public MTAFixedAmount build() {
			return this;
		}
		
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder toBuilder() {
			MTAFixedAmount.MTAFixedAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MTAFixedAmount.MTAFixedAmountBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MTAFixedAmount _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MTAFixedAmount {" +
				"party=" + this.party + ", " +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of MTAFixedAmount  ***********************/
	class MTAFixedAmountBuilderImpl implements MTAFixedAmount.MTAFixedAmountBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Integer amount;
		protected ISOCurrencyCodeEnum currency;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public Integer getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder setAmount(Integer _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@Override
		public MTAFixedAmount build() {
			return new MTAFixedAmount.MTAFixedAmountImpl(this);
		}
		
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getAmount()!=null) return true;
			if (getCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MTAFixedAmount.MTAFixedAmountBuilder o = (MTAFixedAmount.MTAFixedAmountBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MTAFixedAmount _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MTAFixedAmountBuilder {" +
				"party=" + this.party + ", " +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
