package drr.regulation.common.trade.datetime.reports;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.TransactionReportInstruction;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ConfirmationTimestampRule.ConfirmationTimestampRuleDefault.class)
public abstract class ConfirmationTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCleared isCleared;

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

	public static class ConfirmationTimestampRuleDefault extends ConfirmationTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperC<EventTimestamp> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> {
					if (areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp());
					}
					return MapperC.<EventTimestamp>ofNull();
				});
			final MapperC<EventTimestamp> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.CONFIRMATION_DATE_TIME), CardinalityOperator.All).get());
			final MapperS<EventTimestamp> thenArg2 = MapperS.of(distinctIgnoringPrecision(thenArg1).get());
			output = thenArg2
				.mapSingleToItem(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime())).get();
			
			return output;
		}
	}
}
