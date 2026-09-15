package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(ClearingMemberRule.ClearingMemberRuleDefault.class)
public abstract class ClearingMemberRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.ClearingMemberRule clearingMemberRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class ClearingMemberRuleDefault extends ClearingMemberRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(clearingMemberRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
