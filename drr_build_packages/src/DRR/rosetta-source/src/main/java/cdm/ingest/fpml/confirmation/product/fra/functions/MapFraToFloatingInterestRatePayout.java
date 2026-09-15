package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.daycount.DayCountFractionEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFloatingRateIndexToRateOptionWithAddress;
import cdm.product.asset.DiscountingMethod;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraToFloatingInterestRatePayout.MapFraToFloatingInterestRatePayoutDefault.class)
public abstract class MapFraToFloatingInterestRatePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;
	@Inject protected FloatingLeg floatingLeg;
	@Inject protected MapFloatingRateIndexToRateOptionWithAddress mapFloatingRateIndexToRateOptionWithAddress;
	@Inject protected MapFraResetDates mapFraResetDates;

	/**
	* @param fpmlFra 
	* @param floatingPayerReceiver 
	* @param dayCountFraction 
	* @param calculationPeriodDates 
	* @param paymentDate 
	* @param discountingMethod 
	* @return payout 
	*/
	public Payout evaluate(Fra fpmlFra, PayerReceiver floatingPayerReceiver, DayCountFractionEnum dayCountFraction, CalculationPeriodDates calculationPeriodDates, AdjustableDate paymentDate, DiscountingMethod discountingMethod) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFra, floatingPayerReceiver, dayCountFraction, calculationPeriodDates, paymentDate, discountingMethod);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(Fra fpmlFra, PayerReceiver floatingPayerReceiver, DayCountFractionEnum dayCountFraction, CalculationPeriodDates calculationPeriodDates, AdjustableDate paymentDate, DiscountingMethod discountingMethod);

	public static class MapFraToFloatingInterestRatePayoutDefault extends MapFraToFloatingInterestRatePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(Fra fpmlFra, PayerReceiver floatingPayerReceiver, DayCountFractionEnum dayCountFraction, CalculationPeriodDates calculationPeriodDates, AdjustableDate paymentDate, DiscountingMethod discountingMethod) {
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFra, floatingPayerReceiver, dayCountFraction, calculationPeriodDates, paymentDate, discountingMethod);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, Fra fpmlFra, PayerReceiver floatingPayerReceiver, DayCountFractionEnum dayCountFraction, CalculationPeriodDates calculationPeriodDates, AdjustableDate paymentDate, DiscountingMethod discountingMethod) {
			payout = toBuilder(Payout.builder()
				.setInterestRatePayout(InterestRatePayout.builder()
					.setPayerReceiver(floatingPayerReceiver)
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(createQuantityWithAddress.evaluate(createQuantityKey.evaluate(null, floatingLeg.evaluate())))
						.build())
					.setRateSpecification(RateSpecification.builder()
						.setFloatingRateSpecification(FloatingRateSpecification.builder()
							.setRateOption(mapFloatingRateIndexToRateOptionWithAddress.evaluate(MapperS.of(fpmlFra).<FloatingRateIndex>map("getFloatingRateIndex", fra -> fra.getFloatingRateIndex()).get(), MapperS.of(fpmlFra).<Period>mapC("getIndexTenor", fra -> fra.getIndexTenor())
								.first().get(), floatingLeg.evaluate()))
							.build())
						.build())
					.setDayCountFractionValue(dayCountFraction)
					.setCalculationPeriodDates(calculationPeriodDates)
					.setPaymentDate(paymentDate)
					.setResetDates(mapFraResetDates.evaluate(MapperS.of(fpmlFra).<RelativeDateOffset>map("getFixingDateOffset", fra -> fra.getFixingDateOffset()).get()))
					.setDiscountingMethod(discountingMethod)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
