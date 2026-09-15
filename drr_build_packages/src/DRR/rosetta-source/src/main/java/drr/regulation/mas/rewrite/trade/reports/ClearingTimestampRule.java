package drr.regulation.mas.rewrite.trade.reports;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingTimestampRule.ClearingTimestampRuleDefault.class)
public abstract class ClearingTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;

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
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperC<EventTimestamp> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp()));
			final MapperC<EventTimestamp> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.CLEARING_DATE_TIME), CardinalityOperator.All).get());
			final MapperS<EventTimestamp> thenArg3 = MapperS.of(thenArg2.get());
			output = thenArg3
				.mapSingleToItem(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime())).get();
			
			return output;
		}
	}
}
