package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.FloatingRateReferencePeriodOfLeg2TimePeriodRule;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import javax.inject.Inject;


@ImplementedBy(FloatingRateReferencePeriodOfLeg2MultiplierRule.FloatingRateReferencePeriodOfLeg2MultiplierRuleDefault.class)
public abstract class FloatingRateReferencePeriodOfLeg2MultiplierRule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected drr.regulation.common.emir.reports.FloatingRateReferencePeriodOfLeg2MultiplierRule floatingRateReferencePeriodOfLeg2MultiplierRule;
	@Inject protected FloatingRateReferencePeriodOfLeg2TimePeriodRule floatingRateReferencePeriodOfLeg2TimePeriodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Integer evaluate(TransactionReportInstruction input) {
		Integer output = doEvaluate(input);
		
		return output;
	}

	protected abstract Integer doEvaluate(TransactionReportInstruction input);

	public static class FloatingRateReferencePeriodOfLeg2MultiplierRuleDefault extends FloatingRateReferencePeriodOfLeg2MultiplierRule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			output = MapperS.of(adjustFrequencyPeriod.evaluate(floatingRateReferencePeriodOfLeg2TimePeriodRule.evaluate(input), floatingRateReferencePeriodOfLeg2MultiplierRule.evaluate(input))).<Integer>map("getPeriodMultiplier", quantityFrequency -> quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
