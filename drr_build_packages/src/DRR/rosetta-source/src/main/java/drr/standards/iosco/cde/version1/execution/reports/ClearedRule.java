package drr.standards.iosco.cde.version1.execution.reports;

import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsCleared;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.ClearedEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearedRule.ClearedRuleDefault.class)
public abstract class ClearedRule implements ReportFunction<TransactionReportInstructionBase, ClearedEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCleared isCleared;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearedEnum evaluate(TransactionReportInstructionBase input) {
		ClearedEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearedEnum doEvaluate(TransactionReportInstructionBase input);

	public static class ClearedRuleDefault extends ClearedRule {
		@Override
		protected ClearedEnum doEvaluate(TransactionReportInstructionBase input) {
			ClearedEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearedEnum assignOutput(ClearedEnum output, TransactionReportInstructionBase input) {
			final Boolean _boolean = isCleared.evaluate(MapperS.of(input).<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).get());
			if ((_boolean == null ? false : _boolean)) {
				output = ClearedEnum.Y;
			} else if (areEqual(MapperS.of(input).<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<EventInstruction>map("getNextEvent", workflowStep -> workflowStep.getNextEvent()).<EventIntentEnum>map("getIntent", eventInstruction -> eventInstruction.getIntent()), MapperS.of(EventIntentEnum.CLEARING), CardinalityOperator.All).getOrDefault(false)) {
				output = ClearedEnum.I;
			} else {
				output = ClearedEnum.N;
			}
			
			return output;
		}
	}
}
