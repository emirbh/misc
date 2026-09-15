package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.daycount.DayCountFractionEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.other.functions.MapPeriodExtendedEnum;
import cdm.ingest.fpml.confirmation.party.functions.FlipPayerAndReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateToPriceScheduleWithAddress;
import cdm.product.asset.DiscountingMethod;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraToFixedInterestRatePayout.MapFraToFixedInterestRatePayoutDefault.class)
public abstract class MapFraToFixedInterestRatePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;
	@Inject protected FixedLeg fixedLeg;
	@Inject protected FlipPayerAndReceiver flipPayerAndReceiver;
	@Inject protected MapFixedRateToPriceScheduleWithAddress mapFixedRateToPriceScheduleWithAddress;
	@Inject protected MapPeriodExtendedEnum mapPeriodExtendedEnum;

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

	public static class MapFraToFixedInterestRatePayoutDefault extends MapFraToFixedInterestRatePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(Fra fpmlFra, PayerReceiver floatingPayerReceiver, DayCountFractionEnum dayCountFraction, CalculationPeriodDates calculationPeriodDates, AdjustableDate paymentDate, DiscountingMethod discountingMethod) {
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFra, floatingPayerReceiver, dayCountFraction, calculationPeriodDates, paymentDate, discountingMethod);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, Fra fpmlFra, PayerReceiver floatingPayerReceiver, DayCountFractionEnum dayCountFraction, CalculationPeriodDates calculationPeriodDates, AdjustableDate paymentDate, DiscountingMethod discountingMethod) {
			payout = toBuilder(Payout.builder()
				.setInterestRatePayout(InterestRatePayout.builder()
					.setPayerReceiver(flipPayerAndReceiver.evaluate(floatingPayerReceiver))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(createQuantityWithAddress.evaluate(createQuantityKey.evaluate(null, fixedLeg.evaluate())))
						.build())
					.setRateSpecification(RateSpecification.builder()
						.setFixedRateSpecification(FixedRateSpecification.builder()
							.setRateSchedule(RateSchedule.builder()
								.setPrice(mapFixedRateToPriceScheduleWithAddress.evaluate(MapperS.of(fpmlFra).<IdentifiedRate>map("getFixedRate", fra -> fra.getFixedRate()).<BigDecimal>map("getValue", identifiedRate -> identifiedRate.getValue()).get(), fixedLeg.evaluate()))
								.build())
							.build())
						.build())
					.setCalculationPeriodDates(calculationPeriodDates)
					.setDayCountFractionValue(dayCountFraction)
					.setPaymentDates(PaymentDates.builder()
						.setPaymentFrequency(MapperS.of(fpmlFra).<Period>mapC("getIndexTenor", fra -> fra.getIndexTenor())
							.first()
							.mapSingleToItem(item -> MapperS.of(Frequency.builder()
								.setPeriodMultiplier(item.<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get())
								.setPeriod(mapPeriodExtendedEnum.evaluate(item.<PeriodEnum>map("getPeriod", period -> period.getPeriod()).map("to-string", PeriodEnum::toDisplayString).get()))
								.build())).get())
						.build())
					.setPaymentDate(paymentDate)
					.setDiscountingMethod(discountingMethod)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
