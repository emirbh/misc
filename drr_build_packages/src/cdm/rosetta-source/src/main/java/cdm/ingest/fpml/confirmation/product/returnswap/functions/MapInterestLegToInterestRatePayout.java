package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.other.functions.MapDayCountFractionEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateToPriceScheduleWithAddress;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapFloatingRateSpecification;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.Compounding;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDates;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.eq.shared.StubCalculationPeriod;
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapInterestLegToInterestRatePayout.MapInterestLegToInterestRatePayoutDefault.class)
public abstract class MapInterestLegToInterestRatePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDayCountFractionEnum mapDayCountFractionEnum;
	@Inject protected MapFixedRateToPriceScheduleWithAddress mapFixedRateToPriceScheduleWithAddress;
	@Inject protected MapFloatingRateSpecification mapFloatingRateSpecification;
	@Inject protected MapInterestLegCalculationPeriodDates mapInterestLegCalculationPeriodDates;
	@Inject protected MapInterestLegPaymentDates mapInterestLegPaymentDates;
	@Inject protected MapInterestLegResetDates mapInterestLegResetDates;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapStubCalculationPeriodToStubPeriod mapStubCalculationPeriodToStubPeriod;

	/**
	* @param fpmlInterestLeg 
	* @param cdmCounterpartyList 
	* @param fpmlReturnLeg 
	* @return payout 
	*/
	public Payout evaluate(InterestLeg fpmlInterestLeg, List<? extends Counterparty> cdmCounterpartyList, ReturnLeg fpmlReturnLeg) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlInterestLeg, cdmCounterpartyList, fpmlReturnLeg);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(InterestLeg fpmlInterestLeg, List<? extends Counterparty> cdmCounterpartyList, ReturnLeg fpmlReturnLeg);

	protected abstract MapperS<? extends FloatingRateCalculation> fpmlFloatingRateCalculation(InterestLeg fpmlInterestLeg, List<? extends Counterparty> cdmCounterpartyList, ReturnLeg fpmlReturnLeg);

	public static class MapInterestLegToInterestRatePayoutDefault extends MapInterestLegToInterestRatePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(InterestLeg fpmlInterestLeg, List<? extends Counterparty> cdmCounterpartyList, ReturnLeg fpmlReturnLeg) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlInterestLeg, cdmCounterpartyList, fpmlReturnLeg);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, InterestLeg fpmlInterestLeg, List<? extends Counterparty> cdmCounterpartyList, ReturnLeg fpmlReturnLeg) {
			FloatingRateSpecification ifThenElseResult = null;
			if (exists(fpmlFloatingRateCalculation(fpmlInterestLeg, cdmCounterpartyList, fpmlReturnLeg)).getOrDefault(false)) {
				ifThenElseResult = mapFloatingRateSpecification.evaluate(fpmlFloatingRateCalculation(fpmlInterestLeg, cdmCounterpartyList, fpmlReturnLeg).get(), fpmlInterestLeg);
			}
			payout = toBuilder(Payout.builder()
				.setInterestRatePayout(InterestRatePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlInterestLeg).<PartyReference>map("getPayerPartyReference", interestLeg -> interestLeg.getPayerPartyReference()).get(), MapperS.of(fpmlInterestLeg).<PartyReference>map("getReceiverPartyReference", interestLeg -> interestLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(mapResolvablePriceQuantity.evaluate(MapperS.of(fpmlInterestLeg).<ReturnSwapNotional>map("getNotional", interestLeg -> interestLeg.getNotional()).get(), null, fpmlInterestLeg, MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).get(), fpmlReturnLeg))
					.setRateSpecification(RateSpecification.builder()
						.setFixedRateSpecification(FixedRateSpecification.builder()
							.setRateSchedule(RateSchedule.builder()
								.setPrice(mapFixedRateToPriceScheduleWithAddress.evaluate(MapperS.of(fpmlInterestLeg).<InterestCalculation>map("getInterestCalculation", interestLeg -> interestLeg.getInterestCalculation()).<BigDecimal>map("getFixedRate", interestCalculation -> interestCalculation.getFixedRate()).get(), fpmlInterestLeg))
								.build())
							.build())
						.setFloatingRateSpecification(ifThenElseResult)
						.build())
					.setDayCountFractionValue(mapDayCountFractionEnum.evaluate(MapperS.of(fpmlInterestLeg).<InterestCalculation>map("getInterestCalculation", interestLeg -> interestLeg.getInterestCalculation()).<DayCountFraction>map("getDayCountFraction", interestCalculation -> interestCalculation.getDayCountFraction()).<String>map("getValue", dayCountFraction -> dayCountFraction.getValue()).get()))
					.setCalculationPeriodDates(mapInterestLegCalculationPeriodDates.evaluate(MapperS.of(fpmlInterestLeg).<InterestLegCalculationPeriodDates>map("getInterestLegCalculationPeriodDates", interestLeg -> interestLeg.getInterestLegCalculationPeriodDates()).get()))
					.setCompoundingMethod(MapperS.of(fpmlInterestLeg).<InterestCalculation>map("getInterestCalculation", interestLeg -> interestLeg.getInterestCalculation()).<Compounding>map("getCompounding", interestCalculation -> interestCalculation.getCompounding()).<CompoundingMethodEnum>map("getCompoundingMethod", compounding -> compounding.getCompoundingMethod()).checkedMap("to-enum", e -> cdm.product.asset.CompoundingMethodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setPaymentDates(mapInterestLegPaymentDates.evaluate(MapperS.of(fpmlInterestLeg).<InterestLegCalculationPeriodDates>map("getInterestLegCalculationPeriodDates", interestLeg -> interestLeg.getInterestLegCalculationPeriodDates()).<AdjustableRelativeOrPeriodicDates2>map("getInterestLegPaymentDates", interestLegCalculationPeriodDates -> interestLegCalculationPeriodDates.getInterestLegPaymentDates()).get()))
					.setStubPeriod(mapStubCalculationPeriodToStubPeriod.evaluate(MapperS.of(fpmlInterestLeg).<StubCalculationPeriod>map("getStubCalculationPeriod", interestLeg -> interestLeg.getStubCalculationPeriod()).get()))
					.setResetDates(mapInterestLegResetDates.evaluate(MapperS.of(fpmlInterestLeg).<InterestLegCalculationPeriodDates>map("getInterestLegCalculationPeriodDates", interestLeg -> interestLeg.getInterestLegCalculationPeriodDates()).<InterestLegResetDates>map("getInterestLegResetDates", interestLegCalculationPeriodDates -> interestLegCalculationPeriodDates.getInterestLegResetDates()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FloatingRateCalculation> fpmlFloatingRateCalculation(InterestLeg fpmlInterestLeg, List<? extends Counterparty> cdmCounterpartyList, ReturnLeg fpmlReturnLeg) {
			return MapperS.of(fpmlInterestLeg).<InterestCalculation>map("getInterestCalculation", interestLeg -> interestLeg.getInterestCalculation()).<FloatingRateCalculation>map("getFloatingRateCalculation", interestCalculation -> interestCalculation.getFloatingRateCalculation());
		}
	}
}
