package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(FixedRatePaymentFrequencyPeriodLeg2Rule.FixedRatePaymentFrequencyPeriodLeg2RuleDefault.class)
public abstract class FixedRatePaymentFrequencyPeriodLeg2Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected drr.regulation.common.emir.reports.FixedRatePaymentFrequencyPeriodLeg2Rule fixedRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule;

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

	public static class FixedRatePaymentFrequencyPeriodLeg2RuleDefault extends FixedRatePaymentFrequencyPeriodLeg2Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			output = MapperS.of(adjustFrequencyPeriod.evaluate(fixedRatePaymentFrequencyPeriodLeg2Rule.evaluate(input), fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input))).<FrequencyPeriodEnum>map("getPeriod", quantityFrequency -> quantityFrequency.getPeriod()).get();
			
			return output;
		}
	}
}
