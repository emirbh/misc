package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.reports.QuantityFrequencyPeriodMultiplierLeg2Rule;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyMultiplierLeg2Rule.QuantityFrequencyMultiplierLeg2RuleDefault.class)
public abstract class QuantityFrequencyMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected QuantityFrequencyPeriodMultiplierLeg2Rule quantityFrequencyPeriodMultiplierLeg2Rule;

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

	public static class QuantityFrequencyMultiplierLeg2RuleDefault extends QuantityFrequencyMultiplierLeg2Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(quantityFrequencyPeriodMultiplierLeg2Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
