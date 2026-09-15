package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(ExecutionAgentCounterparty1Rule.ExecutionAgentCounterparty1RuleDefault.class)
public abstract class ExecutionAgentCounterparty1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty1Rule executionAgentCounterparty1Rule;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
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

	public static class ExecutionAgentCounterparty1RuleDefault extends ExecutionAgentCounterparty1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForASIC.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeEROR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePRTO.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeVALU.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(executionAgentCounterparty1Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
