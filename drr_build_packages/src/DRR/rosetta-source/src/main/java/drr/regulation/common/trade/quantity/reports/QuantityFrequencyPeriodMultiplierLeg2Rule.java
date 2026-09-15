package drr.regulation.common.trade.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.QuantityFrequency;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyPeriodMultiplierLeg2Rule.QuantityFrequencyPeriodMultiplierLeg2RuleDefault.class)
public abstract class QuantityFrequencyPeriodMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected QuantityFrequency quantityFrequency;

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

	public static class QuantityFrequencyPeriodMultiplierLeg2RuleDefault extends QuantityFrequencyPeriodMultiplierLeg2Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			output = MapperS.of(quantityFrequency.evaluate(payoutLeg2Rule.evaluate(input))).<Integer>map("getPeriodMultiplier", _quantityFrequency -> _quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
