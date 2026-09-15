package drr.regulation.common.trade.underlier.reports;

import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.functions.FloatingReferencePeriod;
import drr.regulation.common.functions.RateOption;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(FloatingRateReferencePeriodRule.FloatingRateReferencePeriodRuleDefault.class)
public abstract class FloatingRateReferencePeriodRule implements ReportFunction<InterestRatePayout, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingReferencePeriod floatingReferencePeriod;
	@Inject protected RateOption rateOption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(InterestRatePayout input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(InterestRatePayout input);

	public static class FloatingRateReferencePeriodRuleDefault extends FloatingRateReferencePeriodRule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(InterestRatePayout input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, InterestRatePayout input) {
			final MapperS<PeriodEnum> thenArg = MapperS.of(rateOption.evaluate(input)).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(floatingReferencePeriod.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
