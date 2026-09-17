package fpml.consolidated.fx;

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
import fpml.consolidated.fpmlenum.PayoutEnum;
import fpml.consolidated.fx.meta.FxOptionPayoutMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.SettlementInformation;
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
 * Provision A type that contains full details of a predefined fixed payout which may occur (or not) in a Barrier Option or Digital Option when a trigger event occurs (or not).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that contains full details of a predefined fixed payout which may occur (or not) in a Barrier Option or Digital Option when a trigger event occurs (or not).
 *
 */
@RosettaDataType(value="FxOptionPayout", builder=FxOptionPayout.FxOptionPayoutBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxOptionPayout", model="fpml", builder=FxOptionPayout.FxOptionPayoutBuilderImpl.class, version="2.1.1")
public interface FxOptionPayout extends NonNegativeMoney {

	FxOptionPayoutMeta metaData = new FxOptionPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trigger event and payout may be asynchonous. A payout may become due on the trigger event, or the payout may (by agreeement at initiation) be deferred (for example) to the maturity date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trigger event and payout may be asynchonous. A payout may become due on the trigger event, or the payout may (by agreeement at initiation) be deferred (for example) to the maturity date.
	 *
	 */
	PayoutEnum getPayoutStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information required to settle a currency payment that results from a trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information required to settle a currency payment that results from a trade.
	 *
	 */
	SettlementInformation getSettlementInformation();

	/*********************** Build Methods  ***********************/
	FxOptionPayout build();
	
	FxOptionPayout.FxOptionPayoutBuilder toBuilder();
	
	static FxOptionPayout.FxOptionPayoutBuilder builder() {
		return new FxOptionPayout.FxOptionPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionPayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxOptionPayout> getType() {
		return FxOptionPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("payoutStyle"), PayoutEnum.class, getPayoutStyle(), this);
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionPayoutBuilder extends FxOptionPayout, NonNegativeMoney.NonNegativeMoneyBuilder {
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		@Override
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		@Override
		FxOptionPayout.FxOptionPayoutBuilder setId(String id);
		@Override
		FxOptionPayout.FxOptionPayoutBuilder setCurrency(Currency currency);
		@Override
		FxOptionPayout.FxOptionPayoutBuilder setAmount(BigDecimal amount);
		FxOptionPayout.FxOptionPayoutBuilder setPayoutStyle(PayoutEnum payoutStyle);
		FxOptionPayout.FxOptionPayoutBuilder setSettlementInformation(SettlementInformation settlementInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("payoutStyle"), PayoutEnum.class, getPayoutStyle(), this);
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
		}
		

		FxOptionPayout.FxOptionPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionPayout  ***********************/
	class FxOptionPayoutImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements FxOptionPayout {
		private final PayoutEnum payoutStyle;
		private final SettlementInformation settlementInformation;
		
		protected FxOptionPayoutImpl(FxOptionPayout.FxOptionPayoutBuilder builder) {
			super(builder);
			this.payoutStyle = builder.getPayoutStyle();
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payoutStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoutStyle")
		public PayoutEnum getPayoutStyle() {
			return payoutStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public FxOptionPayout build() {
			return this;
		}
		
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder toBuilder() {
			FxOptionPayout.FxOptionPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionPayout.FxOptionPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayoutStyle()).ifPresent(builder::setPayoutStyle);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(payoutStyle, _that.getPayoutStyle())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoutStyle != null ? payoutStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPayout {" +
				"payoutStyle=" + this.payoutStyle + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOptionPayout  ***********************/
	class FxOptionPayoutBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl implements FxOptionPayout.FxOptionPayoutBuilder {
	
		protected PayoutEnum payoutStyle;
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
		
		@Override
		@RosettaAttribute("payoutStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoutStyle")
		public PayoutEnum getPayoutStyle() {
			return payoutStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation.SettlementInformationBuilder getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation() {
			SettlementInformation.SettlementInformationBuilder result;
			if (settlementInformation!=null) {
				result = settlementInformation;
			}
			else {
				result = settlementInformation = SettlementInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("payoutStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payoutStyle")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder setPayoutStyle(PayoutEnum _payoutStyle) {
			this.payoutStyle = _payoutStyle == null ? null : _payoutStyle;
			return this;
		}
		
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementInformation")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder setSettlementInformation(SettlementInformation _settlementInformation) {
			this.settlementInformation = _settlementInformation == null ? null : _settlementInformation.toBuilder();
			return this;
		}
		
		@Override
		public FxOptionPayout build() {
			return new FxOptionPayout.FxOptionPayoutImpl(this);
		}
		
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder prune() {
			super.prune();
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayoutStyle()!=null) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxOptionPayout.FxOptionPayoutBuilder o = (FxOptionPayout.FxOptionPayoutBuilder) other;
			
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			
			merger.mergeBasic(getPayoutStyle(), o.getPayoutStyle(), this::setPayoutStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(payoutStyle, _that.getPayoutStyle())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoutStyle != null ? payoutStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPayoutBuilder {" +
				"payoutStyle=" + this.payoutStyle + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}
}
