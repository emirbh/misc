package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iso.ConfirmationEnum;
import javax.inject.Inject;


@ImplementedBy(ConfirmedRule.ConfirmedRuleDefault.class)
public abstract class ConfirmedRule implements ReportFunction<TransactionReportInstruction, ConfirmationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.execution.reports.ConfirmedRule confirmedRule;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ConfirmationEnum evaluate(TransactionReportInstruction input) {
		ConfirmationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ConfirmationEnum doEvaluate(TransactionReportInstruction input);

	public static class ConfirmedRuleDefault extends ConfirmedRule {
		@Override
		protected ConfirmationEnum doEvaluate(TransactionReportInstruction input) {
			ConfirmationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ConfirmationEnum assignOutput(ConfirmationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			output = MapperS.of(confirmedRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
