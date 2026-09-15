package drr.regulation.common.emir.reports;

import cdm.event.common.BusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventDateRule.EventDateRuleDefault.class)
public abstract class EventDateRule implements ReportFunction<TransactionReportInstruction, Date> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class EventDateRuleDefault extends EventDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent())).getOrDefault(false)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Date>map("getEventDate", businessEvent -> businessEvent.getEventDate());
					}
					return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<Date>map("getEventDate", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getEventDate());
				}).get();
			
			return output;
		}
	}
}
