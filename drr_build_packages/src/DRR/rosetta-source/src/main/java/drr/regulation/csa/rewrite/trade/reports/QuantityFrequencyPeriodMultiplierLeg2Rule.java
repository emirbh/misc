package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.QuantityFrequency;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutLeg2;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyPeriodMultiplierLeg2Rule.QuantityFrequencyPeriodMultiplierLeg2RuleDefault.class)
public abstract class QuantityFrequencyPeriodMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected PayoutLeg2 payoutLeg2;
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
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = MapperS.of(quantityFrequency.evaluate(payoutLeg2.evaluate(thenArg.get()))).<Integer>map("getPeriodMultiplier", _quantityFrequency -> _quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
