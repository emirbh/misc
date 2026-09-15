package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.event.reports.AllocationTypeRule;
import javax.inject.Inject;


@ImplementedBy(AllocationIndicatorRule.AllocationIndicatorRuleDefault.class)
public abstract class AllocationIndicatorRule implements ReportFunction<TransactionReportInstruction, AllocationIndicatorEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AllocationTypeRule allocationTypeRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AllocationIndicatorEnum evaluate(TransactionReportInstruction input) {
		AllocationIndicatorEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AllocationIndicatorEnum doEvaluate(TransactionReportInstruction input);

	public static class AllocationIndicatorRuleDefault extends AllocationIndicatorRule {
		@Override
		protected AllocationIndicatorEnum doEvaluate(TransactionReportInstruction input) {
			AllocationIndicatorEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AllocationIndicatorEnum assignOutput(AllocationIndicatorEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(allocationTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
