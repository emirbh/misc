package drr.standards.iosco.cde.version1.payment.reports;

import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.payment.PeriodicPayment;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PeriodicPaymentRule.PeriodicPaymentRuleDefault.class)
public abstract class PeriodicPaymentRule implements ReportFunction<InterestRatePayout, PeriodicPayment> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected DayCountConventionRule dayCountConventionRule;
	@Inject protected PaymentFrequencyPeriodMultiplierRule paymentFrequencyPeriodMultiplierRule;
	@Inject protected PaymentFrequencyPeriodRule paymentFrequencyPeriodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PeriodicPayment evaluate(InterestRatePayout input) {
		PeriodicPayment.PeriodicPaymentBuilder outputBuilder = doEvaluate(input);
		
		final PeriodicPayment output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PeriodicPayment.class, output);
		}
		
		return output;
	}

	protected abstract PeriodicPayment.PeriodicPaymentBuilder doEvaluate(InterestRatePayout input);

	public static class PeriodicPaymentRuleDefault extends PeriodicPaymentRule {
		@Override
		protected PeriodicPayment.PeriodicPaymentBuilder doEvaluate(InterestRatePayout input) {
			PeriodicPayment.PeriodicPaymentBuilder output = PeriodicPayment.builder();
			return assignOutput(output, input);
		}
		
		protected PeriodicPayment.PeriodicPaymentBuilder assignOutput(PeriodicPayment.PeriodicPaymentBuilder output, InterestRatePayout input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToItem(item -> {
					final MapperS<InterestRatePayout> thenArg0 = item
						.filterSingleNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
					final MapperS<InterestRatePayout> thenArg1 = item
						.filterSingleNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()))).get());
					final MapperS<InterestRatePayout> thenArg2 = item
						.filterSingleNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
					final MapperS<InterestRatePayout> thenArg3 = item
						.filterSingleNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()))).get());
					final MapperS<InterestRatePayout> thenArg4 = item
						.filterSingleNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
					final BigDecimal bigDecimal0 = thenArg4
						.mapSingleToItem(_item -> MapperS.of(paymentFrequencyPeriodMultiplierRule.evaluate(_item.get()))).get();
					final MapperS<InterestRatePayout> thenArg5 = item
						.filterSingleNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()))).get());
					final BigDecimal bigDecimal1 = thenArg5
						.mapSingleToItem(_item -> MapperS.of(paymentFrequencyPeriodMultiplierRule.evaluate(_item.get()))).get();
					return MapperS.of(PeriodicPayment.builder()
						.setFixedRateDayCountConvention(thenArg0
							.mapSingleToItem(_item -> MapperS.of(dayCountConventionRule.evaluate(_item.get()))).get())
						.setFloatingRateDayCountConvention(thenArg1
							.mapSingleToItem(_item -> MapperS.of(dayCountConventionRule.evaluate(_item.get()))).get())
						.setFixedRatePaymentFrequencyPeriod(thenArg2
							.mapSingleToItem(_item -> MapperS.of(paymentFrequencyPeriodRule.evaluate(_item.get()))).get())
						.setFloatingRatePaymentFrequencyPeriod(thenArg3
							.mapSingleToItem(_item -> MapperS.of(paymentFrequencyPeriodRule.evaluate(_item.get()))).get())
						.setFixedRatePaymentFrequencyPeriodMultiplier((bigDecimal0 == null ? null : bigDecimal0.intValueExact()))
						.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal1 == null ? null : bigDecimal1.intValueExact()))
						.build());
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
