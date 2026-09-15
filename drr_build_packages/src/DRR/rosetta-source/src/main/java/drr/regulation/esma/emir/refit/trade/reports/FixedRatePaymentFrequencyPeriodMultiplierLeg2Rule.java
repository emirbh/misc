package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.FixedRatePaymentFrequencyPeriodLeg2Rule;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import javax.inject.Inject;


@ImplementedBy(FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.FixedRatePaymentFrequencyPeriodMultiplierLeg2RuleDefault.class)
public abstract class FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected FixedRatePaymentFrequencyPeriodLeg2Rule fixedRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected drr.regulation.common.emir.reports.FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule;

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

	public static class FixedRatePaymentFrequencyPeriodMultiplierLeg2RuleDefault extends FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			output = MapperS.of(adjustFrequencyPeriod.evaluate(fixedRatePaymentFrequencyPeriodLeg2Rule.evaluate(input), fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input))).<Integer>map("getPeriodMultiplier", quantityFrequency -> quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
