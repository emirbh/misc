package drr.regulation.common.trade.underlier.reports;

import cdm.base.datetime.Period;
import cdm.observable.asset.FloatingRateIndex;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.functions.RateOption;
import drr.standards.iso.functions.FormatToMax3Number;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRateReferencePeriodMultiplierRule.FloatingRateReferencePeriodMultiplierRuleDefault.class)
public abstract class FloatingRateReferencePeriodMultiplierRule implements ReportFunction<InterestRatePayout, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToMax3Number formatToMax3Number;
	@Inject protected RateOption rateOption;

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

	public static class FloatingRateReferencePeriodMultiplierRuleDefault extends FloatingRateReferencePeriodMultiplierRule {
		@Override
		protected BigDecimal doEvaluate(InterestRatePayout input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, InterestRatePayout input) {
			final MapperS<Integer> thenArg = MapperS.of(rateOption.evaluate(input)).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier());
			final Integer integer = thenArg.get();
			output = MapperS.of(formatToMax3Number.evaluate((integer == null ? null : BigDecimal.valueOf(integer)))).get();
			
			return output;
		}
	}
}
