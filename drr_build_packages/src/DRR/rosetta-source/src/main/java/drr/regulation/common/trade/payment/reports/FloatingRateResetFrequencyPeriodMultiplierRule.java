package drr.regulation.common.trade.payment.reports;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.ResetDates;
import cdm.product.common.schedule.ResetFrequency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.functions.FormatToMax3Number;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyPeriodMultiplierRule.FloatingRateResetFrequencyPeriodMultiplierRuleDefault.class)
public abstract class FloatingRateResetFrequencyPeriodMultiplierRule implements ReportFunction<InterestRatePayout, BigDecimal> {
	
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

	public static class FloatingRateResetFrequencyPeriodMultiplierRuleDefault extends FloatingRateResetFrequencyPeriodMultiplierRule {
		@Override
		protected BigDecimal doEvaluate(InterestRatePayout input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, InterestRatePayout input) {
			final MapperS<Integer> thenArg = MapperS.of(input).<ResetDates>map("getResetDates", interestRatePayout -> interestRatePayout.getResetDates()).<ResetFrequency>map("getResetFrequency", resetDates -> resetDates.getResetFrequency()).<Integer>map("getPeriodMultiplier", resetFrequency -> resetFrequency.getPeriodMultiplier());
			final Integer integer = thenArg.get();
			output = MapperS.of(formatToMax3Number.evaluate((integer == null ? null : BigDecimal.valueOf(integer)))).get();
			
			return output;
		}
	}
}
