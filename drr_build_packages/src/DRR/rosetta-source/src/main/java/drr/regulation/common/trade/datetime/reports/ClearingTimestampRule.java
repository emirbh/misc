package drr.regulation.common.trade.datetime.reports;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingTimestampRule.ClearingTimestampRuleDefault.class)
public abstract class ClearingTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstruction input);

	public static class ClearingTimestampRuleDefault extends ClearingTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperC<EventTimestamp> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp()));
			final MapperC<EventTimestamp> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.CLEARING_DATE_TIME), CardinalityOperator.All).get());
			final MapperS<EventTimestamp> thenArg2 = MapperS.of(thenArg1.get());
			output = thenArg2
				.mapSingleToItem(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime())).get();
			
			return output;
		}
	}
}
