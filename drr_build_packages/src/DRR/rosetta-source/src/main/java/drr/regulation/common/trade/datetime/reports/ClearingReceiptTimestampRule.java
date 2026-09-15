package drr.regulation.common.trade.datetime.reports;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IntendedToClear;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iso.EventTypeEnum;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingReceiptTimestampRule.ClearingReceiptTimestampRuleDefault.class)
public abstract class ClearingReceiptTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected IntendedToClear intendedToClear;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
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

	public static class ClearingReceiptTimestampRuleDefault extends ClearingReceiptTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperC<EventTimestamp> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(intendedToClear.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get()))))).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(item.get())), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp());
					}
					return MapperC.<EventTimestamp>ofNull();
				});
			final MapperC<EventTimestamp> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.CLEARING_RECEIPT_DATE_TIME), CardinalityOperator.All).get());
			final MapperS<EventTimestamp> thenArg2 = MapperS.of(thenArg1.get());
			output = thenArg2
				.mapSingleToItem(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime())).get();
			
			return output;
		}
	}
}
