package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyPeriodMultiplierLeg1Rule.QuantityFrequencyPeriodMultiplierLeg1RuleDefault.class)
public abstract class QuantityFrequencyPeriodMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected drr.regulation.common.trade.quantity.reports.QuantityFrequencyPeriodMultiplierLeg1Rule quantityFrequencyPeriodMultiplierLeg1Rule;

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

	public static class QuantityFrequencyPeriodMultiplierLeg1RuleDefault extends QuantityFrequencyPeriodMultiplierLeg1Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = MapperS.of(quantityFrequencyPeriodMultiplierLeg1Rule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
