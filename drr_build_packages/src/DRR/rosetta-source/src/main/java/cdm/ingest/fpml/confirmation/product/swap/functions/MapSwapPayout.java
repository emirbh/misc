package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapResolvablePriceQuantityReference;
import cdm.ingest.fpml.confirmation.other.functions.MapDayCountFractionEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.payment.functions.MapPrincipalPayments;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateScheduleToPriceWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxLinkedNotionalScheduleToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalStepScheduleToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapScheduleToInterestRatePriceSchedule;
import cdm.ingest.fpml.confirmation.settlement.functions.MapSettlementProvisionToSettlementTerms;
import cdm.observable.asset.PriceSchedule;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.CalculationPeriodDates;
import fpml.consolidated.ird.Cashflows;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.ird.ResetDates;
import fpml.consolidated.ird.SettlementProvision;
import fpml.consolidated.ird.StubCalculationPeriodAmount;
import fpml.consolidated.shared.AmountSchedule;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FutureValueAmount;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PrincipalExchanges;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSwapPayout.MapSwapPayoutDefault.class)
public abstract class MapSwapPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashflowRepresentation mapCashflowRepresentation;
	@Inject protected MapDayCountFractionEnum mapDayCountFractionEnum;
	@Inject protected MapFixedRateScheduleToPriceWithAddress mapFixedRateScheduleToPriceWithAddress;
	@Inject protected MapFloatingRateSpecification mapFloatingRateSpecification;
	@Inject protected MapFutureValueAmount mapFutureValueAmount;
	@Inject protected MapFxLinkedNotionalScheduleToQuantityWithAddress mapFxLinkedNotionalScheduleToQuantityWithAddress;
	@Inject protected MapInflationRateSpecification mapInflationRateSpecification;
	@Inject protected MapNotionalStepScheduleToQuantityWithAddress mapNotionalStepScheduleToQuantityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapQuantityMultiplier mapQuantityMultiplier;
	@Inject protected MapResolvablePriceQuantityReference mapResolvablePriceQuantityReference;
	@Inject protected MapScheduleToInterestRatePriceSchedule mapScheduleToInterestRatePriceSchedule;
	@Inject protected MapSettlementProvisionToSettlementTerms mapSettlementProvisionToSettlementTerms;
	@Inject protected MapStubCalculationPeriodAmountToStubPeriod mapStubCalculationPeriodAmountToStubPeriod;
	@Inject protected MapSwapCalculationPeriodDates mapSwapCalculationPeriodDates;
	@Inject protected MapSwapPaymentDates mapSwapPaymentDates;
	@Inject protected MapSwapResetDates mapSwapResetDates;

	/**
	* @param fpmlSwapStream 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlSwapStream, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AmountSchedule> notionalAmountScheduleCalculation(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Calculation> notionalStepScheduleCalculation(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Rate> fpmlRateCalculation(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends FloatingRateSpecification> floatingRateSpecification(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends InflationRateSpecification> inflationRateSpecification(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Currency> principalPaymentCurrency(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Schedule> fixedRateSchedule(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwapPayoutDefault extends MapSwapPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlSwapStream, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			final List<PriceSchedule> ifThenElseResult0;
			if (exists(notionalAmountScheduleCalculation(fpmlSwapStream, cdmCounterpartyList)).getOrDefault(false)) {
				final PriceSchedule priceSchedule = mapScheduleToInterestRatePriceSchedule.evaluate(notionalAmountScheduleCalculation(fpmlSwapStream, cdmCounterpartyList).get(), MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<AmountSchedule>map("getKnownAmountSchedule", calculationPeriodAmount -> calculationPeriodAmount.getKnownAmountSchedule()).<Currency>map("getCurrency", amountSchedule -> amountSchedule.getCurrency()).get(), null);
				ifThenElseResult0 = priceSchedule == null ? Collections.<PriceSchedule>emptyList() : Collections.singletonList(priceSchedule);
			} else {
				ifThenElseResult0 = Collections.<PriceSchedule>emptyList();
			}
			final ReferenceWithMetaNonNegativeQuantitySchedule ifThenElseResult1;
			if (exists(notionalStepScheduleCalculation(fpmlSwapStream, cdmCounterpartyList).<Notional>map("getNotionalSchedule", calculation -> calculation.getNotionalSchedule()).<NonNegativeAmountSchedule>map("getNotionalStepSchedule", notional -> notional.getNotionalStepSchedule())).getOrDefault(false)) {
				ifThenElseResult1 = mapNotionalStepScheduleToQuantityWithAddress.evaluate(notionalStepScheduleCalculation(fpmlSwapStream, cdmCounterpartyList).<Notional>map("getNotionalSchedule", calculation -> calculation.getNotionalSchedule()).<NonNegativeAmountSchedule>map("getNotionalStepSchedule", notional -> notional.getNotionalStepSchedule()).get(), fpmlSwapStream);
			} else if (exists(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", calculation -> calculation.getFxLinkedNotionalSchedule())).getOrDefault(false)) {
				ifThenElseResult1 = mapFxLinkedNotionalScheduleToQuantityWithAddress.evaluate(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", calculation -> calculation.getFxLinkedNotionalSchedule()).get(), fpmlSwapStream);
			} else {
				ifThenElseResult1 = ReferenceWithMetaNonNegativeQuantitySchedule.builder().build();
			}
			payout = toBuilder(Payout.builder()
				.setInterestRatePayout(InterestRatePayout.builder()
					.setPrincipalPayment(mapPrincipalPayments.evaluate(MapperS.of(fpmlSwapStream).<PrincipalExchanges>map("getPrincipalExchanges", interestRateStream -> interestRateStream.getPrincipalExchanges()).get(), MapperS.of(fpmlSwapStream).<Cashflows>map("getCashflows", interestRateStream -> interestRateStream.getCashflows()).<PrincipalExchange>mapC("getPrincipalExchange", cashflows -> cashflows.getPrincipalExchange()).getMulti(), principalPaymentCurrency(fpmlSwapStream, cdmCounterpartyList).get(), MapperS.of(fpmlSwapStream).<PartyReference>map("getPayerPartyReference", interestRateStream -> interestRateStream.getPayerPartyReference()).get(), MapperS.of(fpmlSwapStream).<PartyReference>map("getReceiverPartyReference", interestRateStream -> interestRateStream.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlSwapStream).<PartyReference>map("getPayerPartyReference", interestRateStream -> interestRateStream.getPayerPartyReference()).get(), MapperS.of(fpmlSwapStream).<PartyReference>map("getReceiverPartyReference", interestRateStream -> interestRateStream.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setPriceScheduleValue(ifThenElseResult0)
						.setQuantitySchedule(ifThenElseResult1)
						.setQuantityReference(mapResolvablePriceQuantityReference.evaluate(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", calculation -> calculation.getFxLinkedNotionalSchedule()).<NotionalReference>map("getConstantNotionalScheduleReference", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getConstantNotionalScheduleReference()).<String>map("getHref", notionalReference -> notionalReference.getHref()).get()))
						.setQuantityMultiplier(mapQuantityMultiplier.evaluate(notionalStepScheduleCalculation(fpmlSwapStream, cdmCounterpartyList).get()))
						.setFutureValueNotional(mapFutureValueAmount.evaluate(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<FutureValueAmount>map("getFutureValueNotional", calculation -> calculation.getFutureValueNotional()).get()))
						.build())
					.setSettlementTerms(mapSettlementProvisionToSettlementTerms.evaluate(MapperS.of(fpmlSwapStream).<SettlementProvision>map("getSettlementProvision", interestRateStream -> interestRateStream.getSettlementProvision()).get(), MapperS.of(fpmlSwapStream).<PaymentDates>map("getPaymentDates", interestRateStream -> interestRateStream.getPaymentDates()).get()))
					.setCashflowRepresentation(mapCashflowRepresentation.evaluate(MapperS.of(fpmlSwapStream).<Cashflows>map("getCashflows", interestRateStream -> interestRateStream.getCashflows()).get()))
					.setRateSpecification(RateSpecification.builder()
						.setFixedRateSpecification(FixedRateSpecification.builder()
							.setRateSchedule(RateSchedule.builder()
								.setPrice(mapFixedRateScheduleToPriceWithAddress.evaluate(fixedRateSchedule(fpmlSwapStream, cdmCounterpartyList).get(), fpmlSwapStream))
								.build())
							.build())
						.setFloatingRateSpecification(floatingRateSpecification(fpmlSwapStream, cdmCounterpartyList).get())
						.setInflationRateSpecification(inflationRateSpecification(fpmlSwapStream, cdmCounterpartyList).get())
						.build())
					.setDayCountFractionValue(mapDayCountFractionEnum.evaluate(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<DayCountFraction>map("getDayCountFraction", calculation -> calculation.getDayCountFraction()).<String>map("getValue", dayCountFraction -> dayCountFraction.getValue()).get()))
					.setCalculationPeriodDates(mapSwapCalculationPeriodDates.evaluate(MapperS.of(fpmlSwapStream).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRateStream -> interestRateStream.getCalculationPeriodDates()).get()))
					.setCompoundingMethod(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<CompoundingMethodEnum>map("getCompoundingMethod", calculation -> calculation.getCompoundingMethod()).checkedMap("to-enum", e -> cdm.product.asset.CompoundingMethodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setPaymentDates(mapSwapPaymentDates.evaluate(MapperS.of(fpmlSwapStream).<PaymentDates>map("getPaymentDates", interestRateStream -> interestRateStream.getPaymentDates()).get()))
					.setStubPeriod(mapStubCalculationPeriodAmountToStubPeriod.evaluate(MapperS.of(fpmlSwapStream).<StubCalculationPeriodAmount>map("getStubCalculationPeriodAmount", interestRateStream -> interestRateStream.getStubCalculationPeriodAmount()).get()))
					.setResetDates(mapSwapResetDates.evaluate(MapperS.of(fpmlSwapStream).<ResetDates>map("getResetDates", interestRateStream -> interestRateStream.getResetDates()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AmountSchedule> notionalAmountScheduleCalculation(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<AmountSchedule>map("getKnownAmountSchedule", calculationPeriodAmount -> calculationPeriodAmount.getKnownAmountSchedule());
		}
		
		@Override
		protected MapperS<? extends Calculation> notionalStepScheduleCalculation(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation());
		}
		
		@Override
		protected MapperS<? extends Rate> fpmlRateCalculation(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Rate>map("getRateCalculation", calculation -> calculation.getRateCalculation());
		}
		
		@Override
		protected MapperS<? extends FloatingRateSpecification> floatingRateSpecification(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			final Rate switchArgument = fpmlRateCalculation(fpmlSwapStream, cdmCounterpartyList).get();
			if (switchArgument == null) {
				return MapperS.<FloatingRateSpecification>ofNull();
			}
			if (switchArgument instanceof FloatingRateCalculation) {
				final FloatingRateCalculation floatingRateCalculation = (FloatingRateCalculation) switchArgument;
				return MapperS.of(mapFloatingRateSpecification.evaluate(floatingRateCalculation, fpmlSwapStream));
			}
			return MapperS.<FloatingRateSpecification>ofNull();
		}
		
		@Override
		protected MapperS<? extends InflationRateSpecification> inflationRateSpecification(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			final Rate switchArgument = fpmlRateCalculation(fpmlSwapStream, cdmCounterpartyList).get();
			if (switchArgument == null) {
				return MapperS.<InflationRateSpecification>ofNull();
			}
			if (switchArgument instanceof InflationRateCalculation) {
				final InflationRateCalculation inflationRateCalculation = (InflationRateCalculation) switchArgument;
				return MapperS.of(mapInflationRateSpecification.evaluate(inflationRateCalculation, fpmlSwapStream));
			}
			return MapperS.<InflationRateSpecification>ofNull();
		}
		
		@Override
		protected MapperS<? extends Currency> principalPaymentCurrency(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(MapperS.of(fpmlSwapStream).<SettlementProvision>map("getSettlementProvision", interestRateStream -> interestRateStream.getSettlementProvision()).<Currency>map("getSettlementCurrency", settlementProvision -> settlementProvision.getSettlementCurrency()).getOrDefault(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Notional>map("getNotionalSchedule", calculation -> calculation.getNotionalSchedule()).<NonNegativeAmountSchedule>map("getNotionalStepSchedule", notional -> notional.getNotionalStepSchedule()).<Currency>map("getCurrency", nonNegativeAmountSchedule -> nonNegativeAmountSchedule.getCurrency()).get()));
		}
		
		@Override
		protected MapperS<? extends Schedule> fixedRateSchedule(InterestRateStream fpmlSwapStream, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Schedule>map("getFixedRateSchedule", calculation -> calculation.getFixedRateSchedule()).getOrDefault(MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Schedule>map("getFixedRateSchedule", calculation -> calculation.getFixedRateSchedule()).get()));
		}
	}
}
