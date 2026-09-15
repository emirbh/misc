package drr.regulation.common.trade.payment.reports;

import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.ResetDates;
import cdm.product.common.schedule.ResetFrequency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.functions.ConvertPeriodtoISOFrequencyPeriod;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyPeriodRule.FloatingRateResetFrequencyPeriodRuleDefault.class)
public abstract class FloatingRateResetFrequencyPeriodRule implements ReportFunction<InterestRatePayout, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertPeriodtoISOFrequencyPeriod convertPeriodtoISOFrequencyPeriod;

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

	public static class FloatingRateResetFrequencyPeriodRuleDefault extends FloatingRateResetFrequencyPeriodRule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(InterestRatePayout input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, InterestRatePayout input) {
			output = convertPeriodtoISOFrequencyPeriod.evaluate(MapperS.of(input).<ResetDates>map("getResetDates", interestRatePayout -> interestRatePayout.getResetDates()).<ResetFrequency>map("getResetFrequency", resetDates -> resetDates.getResetFrequency()).<PeriodExtendedEnum>map("getPeriod", resetFrequency -> resetFrequency.getPeriod()).get());
			
			return output;
		}
	}
}
