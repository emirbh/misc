package drr.regulation.common.trade.execution.reports;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.ConfirmationEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ConfirmedRule.ConfirmedRuleDefault.class)
public abstract class ConfirmedRule implements ReportFunction<TransactionReportInstruction, ConfirmationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.ConfirmedRule confirmedRule;
	@Inject protected IsCleared isCleared;

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
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(confirmedRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
