package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.datetime.Frequency;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.functions.FormatToMax3Number;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(PaymentFrequencyPeriodMultiplierRule.PaymentFrequencyPeriodMultiplierRuleDefault.class)
public abstract class PaymentFrequencyPeriodMultiplierRule implements ReportFunction<InterestRatePayout, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToMax3Number formatToMax3Number;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(InterestRatePayout input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(InterestRatePayout input);

	public static class PaymentFrequencyPeriodMultiplierRuleDefault extends PaymentFrequencyPeriodMultiplierRule {
		@Override
		protected BigDecimal doEvaluate(InterestRatePayout input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, InterestRatePayout input) {
			final MapperS<Integer> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier()));
			final Integer integer = thenArg.get();
			output = MapperS.of(formatToMax3Number.evaluate((integer == null ? null : BigDecimal.valueOf(integer)))).get();
			
			return output;
		}
	}
}
