package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.FloatingRateReferencePeriodOfLeg2MultiplierRule;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(FloatingRateReferencePeriodOfLeg2TimePeriodRule.FloatingRateReferencePeriodOfLeg2TimePeriodRuleDefault.class)
public abstract class FloatingRateReferencePeriodOfLeg2TimePeriodRule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected FloatingRateReferencePeriodOfLeg2MultiplierRule floatingRateReferencePeriodOfLeg2MultiplierRule;
	@Inject protected drr.regulation.common.emir.reports.FloatingRateReferencePeriodOfLeg2TimePeriodRule floatingRateReferencePeriodOfLeg2TimePeriodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(TransactionReportInstruction input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input);

	public static class FloatingRateReferencePeriodOfLeg2TimePeriodRuleDefault extends FloatingRateReferencePeriodOfLeg2TimePeriodRule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			output = MapperS.of(adjustFrequencyPeriod.evaluate(floatingRateReferencePeriodOfLeg2TimePeriodRule.evaluate(input), floatingRateReferencePeriodOfLeg2MultiplierRule.evaluate(input))).<FrequencyPeriodEnum>map("getPeriod", quantityFrequency -> quantityFrequency.getPeriod()).get();
			
			return output;
		}
	}
}
