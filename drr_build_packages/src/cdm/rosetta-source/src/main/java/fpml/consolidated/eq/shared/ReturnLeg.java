package fpml.consolidated.eq.shared;

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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.meta.ReturnLegMeta;
import fpml.consolidated.fpmlenum.NotionalAdjustmentEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.AveragingPeriod;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A type describing the return leg of a return type swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the return leg of a return type swap.
 *
 */
@RosettaDataType(value="ReturnLeg", builder=ReturnLeg.ReturnLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnLeg", model="fpml", builder=ReturnLeg.ReturnLegBuilderImpl.class, version="2.1.1")
public interface ReturnLeg extends ReturnSwapLegUnderlyer {

	ReturnLegMeta metaData = new ReturnLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the terms of the initial price of the return type swap and of the subsequent valuations of the underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the terms of the initial price of the return type swap and of the subsequent valuations of the underlyer.
	 *
	 */
	ReturnLegValuation getRateOfReturn();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the notional of a return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the notional of a return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
	 *
	 */
	ReturnSwapNotional getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, in relation to each Payment Date, the amount to which the Payment Date relates. For return swaps this element is equivalent to the Equity Amount term as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, in relation to each Payment Date, the amount to which the Payment Date relates. For return swaps this element is equivalent to the Equity Amount term as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	ReturnSwapAmount getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the conditions under which dividend affecting the underlyer will be paid to the receiver of the amounts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the conditions under which dividend affecting the underlyer will be paid to the receiver of the amounts.
	 *
	 */
	Return getReturn();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the conditions that govern the adjustment to the number of units of the return swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the conditions that govern the adjustment to the number of units of the return swap.
	 *
	 */
	NotionalAdjustmentEnum getNotionalAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A quanto or composite FX feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A quanto or composite FX feature.
	 *
	 */
	FxFeature getFxFeature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Averaging Dates used in the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Averaging Dates used in the swap.
	 *
	 */
	AveragingPeriod getAveragingDates();

	/*********************** Build Methods  ***********************/
	ReturnLeg build();
	
	ReturnLeg.ReturnLegBuilder toBuilder();
	
	static ReturnLeg.ReturnLegBuilder builder() {
		return new ReturnLeg.ReturnLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnLeg> getType() {
		return ReturnLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.class, getStrikeDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("rateOfReturn"), processor, ReturnLegValuation.class, getRateOfReturn());
		processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.class, getNotional());
		processRosetta(path.newSubPath("amount"), processor, ReturnSwapAmount.class, getAmount());
		processRosetta(path.newSubPath("return"), processor, Return.class, getReturn());
		processor.processBasic(path.newSubPath("notionalAdjustments"), NotionalAdjustmentEnum.class, getNotionalAdjustments(), this);
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("averagingDates"), processor, AveragingPeriod.class, getAveragingDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnLegBuilder extends ReturnLeg, ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder {
		ReturnLegValuation.ReturnLegValuationBuilder getOrCreateRateOfReturn();
		@Override
		ReturnLegValuation.ReturnLegValuationBuilder getRateOfReturn();
		ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional();
		@Override
		ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional();
		ReturnSwapAmount.ReturnSwapAmountBuilder getOrCreateAmount();
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder getAmount();
		Return.ReturnBuilder getOrCreateReturn();
		@Override
		Return.ReturnBuilder getReturn();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		@Override
		FxFeature.FxFeatureBuilder getFxFeature();
		AveragingPeriod.AveragingPeriodBuilder getOrCreateAveragingDates();
		@Override
		AveragingPeriod.AveragingPeriodBuilder getAveragingDates();
		@Override
		ReturnLeg.ReturnLegBuilder setId(String id);
		@Override
		ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		ReturnLeg.ReturnLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		ReturnLeg.ReturnLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		ReturnLeg.ReturnLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		ReturnLeg.ReturnLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		ReturnLeg.ReturnLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		ReturnLeg.ReturnLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		ReturnLeg.ReturnLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		ReturnLeg.ReturnLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		@Override
		ReturnLeg.ReturnLegBuilder setStrikeDate(AdjustableOrRelativeDate strikeDate);
		@Override
		ReturnLeg.ReturnLegBuilder setUnderlyer(Underlyer underlyer);
		@Override
		ReturnLeg.ReturnLegBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		ReturnLeg.ReturnLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		ReturnLeg.ReturnLegBuilder setSettlementAmount(Money settlementAmount);
		@Override
		ReturnLeg.ReturnLegBuilder setSettlementCurrency(Currency settlementCurrency);
		ReturnLeg.ReturnLegBuilder setRateOfReturn(ReturnLegValuation rateOfReturn);
		ReturnLeg.ReturnLegBuilder setNotional(ReturnSwapNotional notional);
		ReturnLeg.ReturnLegBuilder setAmount(ReturnSwapAmount amount);
		ReturnLeg.ReturnLegBuilder setReturn(Return _return);
		ReturnLeg.ReturnLegBuilder setNotionalAdjustments(NotionalAdjustmentEnum notionalAdjustments);
		ReturnLeg.ReturnLegBuilder setFxFeature(FxFeature fxFeature);
		ReturnLeg.ReturnLegBuilder setAveragingDates(AveragingPeriod averagingDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("rateOfReturn"), processor, ReturnLegValuation.ReturnLegValuationBuilder.class, getRateOfReturn());
			processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.ReturnSwapNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("amount"), processor, ReturnSwapAmount.ReturnSwapAmountBuilder.class, getAmount());
			processRosetta(path.newSubPath("return"), processor, Return.ReturnBuilder.class, getReturn());
			processor.processBasic(path.newSubPath("notionalAdjustments"), NotionalAdjustmentEnum.class, getNotionalAdjustments(), this);
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("averagingDates"), processor, AveragingPeriod.AveragingPeriodBuilder.class, getAveragingDates());
		}
		

		ReturnLeg.ReturnLegBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnLeg  ***********************/
	class ReturnLegImpl extends ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerImpl implements ReturnLeg {
		private final ReturnLegValuation rateOfReturn;
		private final ReturnSwapNotional notional;
		private final ReturnSwapAmount amount;
		private final Return _return;
		private final NotionalAdjustmentEnum notionalAdjustments;
		private final FxFeature fxFeature;
		private final AveragingPeriod averagingDates;
		
		protected ReturnLegImpl(ReturnLeg.ReturnLegBuilder builder) {
			super(builder);
			this.rateOfReturn = ofNullable(builder.getRateOfReturn()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this._return = ofNullable(builder.getReturn()).map(f->f.build()).orElse(null);
			this.notionalAdjustments = builder.getNotionalAdjustments();
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.averagingDates = ofNullable(builder.getAveragingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rateOfReturn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rateOfReturn")
		public ReturnLegValuation getRateOfReturn() {
			return rateOfReturn;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public ReturnSwapNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public ReturnSwapAmount getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("return")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("return")
		public Return getReturn() {
			return _return;
		}
		
		@Override
		@RosettaAttribute("notionalAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAdjustments")
		public NotionalAdjustmentEnum getNotionalAdjustments() {
			return notionalAdjustments;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("averagingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingDates")
		public AveragingPeriod getAveragingDates() {
			return averagingDates;
		}
		
		@Override
		public ReturnLeg build() {
			return this;
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder toBuilder() {
			ReturnLeg.ReturnLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnLeg.ReturnLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRateOfReturn()).ifPresent(builder::setRateOfReturn);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getReturn()).ifPresent(builder::setReturn);
			ofNullable(getNotionalAdjustments()).ifPresent(builder::setNotionalAdjustments);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getAveragingDates()).ifPresent(builder::setAveragingDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(rateOfReturn, _that.getRateOfReturn())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(_return, _that.getReturn())) return false;
			if (!Objects.equals(notionalAdjustments, _that.getNotionalAdjustments())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(averagingDates, _that.getAveragingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rateOfReturn != null ? rateOfReturn.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (_return != null ? _return.hashCode() : 0);
			_result = 31 * _result + (notionalAdjustments != null ? notionalAdjustments.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (averagingDates != null ? averagingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLeg {" +
				"rateOfReturn=" + this.rateOfReturn + ", " +
				"notional=" + this.notional + ", " +
				"amount=" + this.amount + ", " +
				"return=" + this._return + ", " +
				"notionalAdjustments=" + this.notionalAdjustments + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"averagingDates=" + this.averagingDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnLeg  ***********************/
	class ReturnLegBuilderImpl extends ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl implements ReturnLeg.ReturnLegBuilder {
	
		protected ReturnLegValuation.ReturnLegValuationBuilder rateOfReturn;
		protected ReturnSwapNotional.ReturnSwapNotionalBuilder notional;
		protected ReturnSwapAmount.ReturnSwapAmountBuilder amount;
		protected Return.ReturnBuilder _return;
		protected NotionalAdjustmentEnum notionalAdjustments;
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected AveragingPeriod.AveragingPeriodBuilder averagingDates;
		
		@Override
		@RosettaAttribute("rateOfReturn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rateOfReturn")
		public ReturnLegValuation.ReturnLegValuationBuilder getRateOfReturn() {
			return rateOfReturn;
		}
		
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder getOrCreateRateOfReturn() {
			ReturnLegValuation.ReturnLegValuationBuilder result;
			if (rateOfReturn!=null) {
				result = rateOfReturn;
			}
			else {
				result = rateOfReturn = ReturnLegValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional() {
			ReturnSwapNotional.ReturnSwapNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = ReturnSwapNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public ReturnSwapAmount.ReturnSwapAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder getOrCreateAmount() {
			ReturnSwapAmount.ReturnSwapAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = ReturnSwapAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("return")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("return")
		public Return.ReturnBuilder getReturn() {
			return _return;
		}
		
		@Override
		public Return.ReturnBuilder getOrCreateReturn() {
			Return.ReturnBuilder result;
			if (_return!=null) {
				result = _return;
			}
			else {
				result = _return = Return.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAdjustments")
		public NotionalAdjustmentEnum getNotionalAdjustments() {
			return notionalAdjustments;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingDates")
		public AveragingPeriod.AveragingPeriodBuilder getAveragingDates() {
			return averagingDates;
		}
		
		@Override
		public AveragingPeriod.AveragingPeriodBuilder getOrCreateAveragingDates() {
			AveragingPeriod.AveragingPeriodBuilder result;
			if (averagingDates!=null) {
				result = averagingDates;
			}
			else {
				result = averagingDates = AveragingPeriod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnLeg.ReturnLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (final LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public ReturnLeg.ReturnLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null) {
				this.legIdentifier = new ArrayList<>();
			} else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public ReturnLeg.ReturnLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ReturnLeg.ReturnLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ReturnLeg.ReturnLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ReturnLeg.ReturnLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public ReturnLeg.ReturnLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public ReturnLeg.ReturnLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeDate")
		@Override
		public ReturnLeg.ReturnLegBuilder setStrikeDate(AdjustableOrRelativeDate _strikeDate) {
			this.strikeDate = _strikeDate == null ? null : _strikeDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public ReturnLeg.ReturnLegBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public ReturnLeg.ReturnLegBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public ReturnLeg.ReturnLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public ReturnLeg.ReturnLegBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public ReturnLeg.ReturnLegBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateOfReturn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rateOfReturn")
		@Override
		public ReturnLeg.ReturnLegBuilder setRateOfReturn(ReturnLegValuation _rateOfReturn) {
			this.rateOfReturn = _rateOfReturn == null ? null : _rateOfReturn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public ReturnLeg.ReturnLegBuilder setNotional(ReturnSwapNotional _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public ReturnLeg.ReturnLegBuilder setAmount(ReturnSwapAmount _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("return")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("return")
		@Override
		public ReturnLeg.ReturnLegBuilder setReturn(Return __return) {
			this._return = __return == null ? null : __return.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAdjustments")
		@Override
		public ReturnLeg.ReturnLegBuilder setNotionalAdjustments(NotionalAdjustmentEnum _notionalAdjustments) {
			this.notionalAdjustments = _notionalAdjustments == null ? null : _notionalAdjustments;
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public ReturnLeg.ReturnLegBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingDates")
		@Override
		public ReturnLeg.ReturnLegBuilder setAveragingDates(AveragingPeriod _averagingDates) {
			this.averagingDates = _averagingDates == null ? null : _averagingDates.toBuilder();
			return this;
		}
		
		@Override
		public ReturnLeg build() {
			return new ReturnLeg.ReturnLegImpl(this);
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLeg.ReturnLegBuilder prune() {
			super.prune();
			if (rateOfReturn!=null && !rateOfReturn.prune().hasData()) rateOfReturn = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (_return!=null && !_return.prune().hasData()) _return = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (averagingDates!=null && !averagingDates.prune().hasData()) averagingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRateOfReturn()!=null && getRateOfReturn().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getReturn()!=null && getReturn().hasData()) return true;
			if (getNotionalAdjustments()!=null) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getAveragingDates()!=null && getAveragingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLeg.ReturnLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnLeg.ReturnLegBuilder o = (ReturnLeg.ReturnLegBuilder) other;
			
			merger.mergeRosetta(getRateOfReturn(), o.getRateOfReturn(), this::setRateOfReturn);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getReturn(), o.getReturn(), this::setReturn);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getAveragingDates(), o.getAveragingDates(), this::setAveragingDates);
			
			merger.mergeBasic(getNotionalAdjustments(), o.getNotionalAdjustments(), this::setNotionalAdjustments);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(rateOfReturn, _that.getRateOfReturn())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(_return, _that.getReturn())) return false;
			if (!Objects.equals(notionalAdjustments, _that.getNotionalAdjustments())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(averagingDates, _that.getAveragingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rateOfReturn != null ? rateOfReturn.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (_return != null ? _return.hashCode() : 0);
			_result = 31 * _result + (notionalAdjustments != null ? notionalAdjustments.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (averagingDates != null ? averagingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegBuilder {" +
				"rateOfReturn=" + this.rateOfReturn + ", " +
				"notional=" + this.notional + ", " +
				"amount=" + this.amount + ", " +
				"return=" + this._return + ", " +
				"notionalAdjustments=" + this.notionalAdjustments + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"averagingDates=" + this.averagingDates +
			'}' + " " + super.toString();
		}
	}
}
