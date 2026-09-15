package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.reports.QuantityFrequencyPeriodMultiplierLeg1Rule;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyMultiplierLeg1Rule.QuantityFrequencyMultiplierLeg1RuleDefault.class)
public abstract class QuantityFrequencyMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected QuantityFrequencyPeriodMultiplierLeg1Rule quantityFrequencyPeriodMultiplierLeg1Rule;

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

	public static class QuantityFrequencyMultiplierLeg1RuleDefault extends QuantityFrequencyMultiplierLeg1Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(quantityFrequencyPeriodMultiplierLeg1Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
