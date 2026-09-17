package cdm.legaldocumentation.csa;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.ThresholdFixedAmountMeta;
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
 * Defines that the Threshold is based on a Fixed Amount.
 * @version 6.23.0
 */
@RosettaDataType(value="ThresholdFixedAmount", builder=ThresholdFixedAmount.ThresholdFixedAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ThresholdFixedAmount", model="cdm", builder=ThresholdFixedAmount.ThresholdFixedAmountBuilderImpl.class, version="6.23.0")
public interface ThresholdFixedAmount extends RosettaModelObject {

	ThresholdFixedAmountMeta metaData = new ThresholdFixedAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party to which the threshold applies.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The amount value applicable to the Threshold.
	 */
	Integer getAmount();
	/**
	 * The Threshold currency code.
	 */
	ISOCurrencyCodeEnum getCurrency();
	/**
	 * Flag detailing whether the collateral Threshold Amount is set to infinity for a particular party.
	 */
	Boolean getAmountIsInfinity();

	/*********************** Build Methods  ***********************/
	ThresholdFixedAmount build();
	
	ThresholdFixedAmount.ThresholdFixedAmountBuilder toBuilder();
	
	static ThresholdFixedAmount.ThresholdFixedAmountBuilder builder() {
		return new ThresholdFixedAmount.ThresholdFixedAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ThresholdFixedAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ThresholdFixedAmount> getType() {
		return ThresholdFixedAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		processor.processBasic(path.newSubPath("amountIsInfinity"), Boolean.class, getAmountIsInfinity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ThresholdFixedAmountBuilder extends ThresholdFixedAmount, RosettaModelObjectBuilder {
		ThresholdFixedAmount.ThresholdFixedAmountBuilder setParty(CounterpartyRoleEnum party);
		ThresholdFixedAmount.ThresholdFixedAmountBuilder setAmount(Integer amount);
		ThresholdFixedAmount.ThresholdFixedAmountBuilder setCurrency(ISOCurrencyCodeEnum currency);
		ThresholdFixedAmount.ThresholdFixedAmountBuilder setAmountIsInfinity(Boolean amountIsInfinity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
			processor.processBasic(path.newSubPath("amountIsInfinity"), Boolean.class, getAmountIsInfinity(), this);
		}
		

		ThresholdFixedAmount.ThresholdFixedAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ThresholdFixedAmount  ***********************/
	class ThresholdFixedAmountImpl implements ThresholdFixedAmount {
		private final CounterpartyRoleEnum party;
		private final Integer amount;
		private final ISOCurrencyCodeEnum currency;
		private final Boolean amountIsInfinity;
		
		protected ThresholdFixedAmountImpl(ThresholdFixedAmount.ThresholdFixedAmountBuilder builder) {
			this.party = builder.getParty();
			this.amount = builder.getAmount();
			this.currency = builder.getCurrency();
			this.amountIsInfinity = builder.getAmountIsInfinity();
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
		@RosettaAttribute("amountIsInfinity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountIsInfinity")
		public Boolean getAmountIsInfinity() {
			return amountIsInfinity;
		}
		
		@Override
		public ThresholdFixedAmount build() {
			return this;
		}
		
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder toBuilder() {
			ThresholdFixedAmount.ThresholdFixedAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ThresholdFixedAmount.ThresholdFixedAmountBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getAmountIsInfinity()).ifPresent(builder::setAmountIsInfinity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ThresholdFixedAmount _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(amountIsInfinity, _that.getAmountIsInfinity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amountIsInfinity != null ? amountIsInfinity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ThresholdFixedAmount {" +
				"party=" + this.party + ", " +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency + ", " +
				"amountIsInfinity=" + this.amountIsInfinity +
			'}';
		}
	}

	/*********************** Builder Implementation of ThresholdFixedAmount  ***********************/
	class ThresholdFixedAmountBuilderImpl implements ThresholdFixedAmount.ThresholdFixedAmountBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Integer amount;
		protected ISOCurrencyCodeEnum currency;
		protected Boolean amountIsInfinity;
		
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
		@RosettaAttribute("amountIsInfinity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountIsInfinity")
		public Boolean getAmountIsInfinity() {
			return amountIsInfinity;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder setAmount(Integer _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@RosettaAttribute("amountIsInfinity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountIsInfinity")
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder setAmountIsInfinity(Boolean _amountIsInfinity) {
			this.amountIsInfinity = _amountIsInfinity == null ? null : _amountIsInfinity;
			return this;
		}
		
		@Override
		public ThresholdFixedAmount build() {
			return new ThresholdFixedAmount.ThresholdFixedAmountImpl(this);
		}
		
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getAmount()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getAmountIsInfinity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ThresholdFixedAmount.ThresholdFixedAmountBuilder o = (ThresholdFixedAmount.ThresholdFixedAmountBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeBasic(getAmountIsInfinity(), o.getAmountIsInfinity(), this::setAmountIsInfinity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ThresholdFixedAmount _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(amountIsInfinity, _that.getAmountIsInfinity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amountIsInfinity != null ? amountIsInfinity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ThresholdFixedAmountBuilder {" +
				"party=" + this.party + ", " +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency + ", " +
				"amountIsInfinity=" + this.amountIsInfinity +
			'}';
		}
	}
}
