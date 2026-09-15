package drr.regulation.sec.rewrite.trade.reports;

import cdm.event.common.BusinessEvent;
import cdm.event.qualification.functions.Qualify_PartialTermination;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventTypeRule.EventTypeRuleDefault.class)
public abstract class EventTypeRule implements ReportFunction<TransactionReportInstruction, EventTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.event.reports.EventTypeRule eventTypeRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected Qualify_PartialTermination qualify_PartialTermination;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EventTypeEnum evaluate(TransactionReportInstruction input) {
		EventTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract EventTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class EventTypeRuleDefault extends EventTypeRule {
		@Override
		protected EventTypeEnum doEvaluate(TransactionReportInstruction input) {
			EventTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected EventTypeEnum assignOutput(EventTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			final MapperS<EventTypeEnum> ifThenElseResult;
			if (areEqual(MapperS.of(qualify_PartialTermination.evaluate(thenArg.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(thenArg.get())), MapperS.of(EventTypeEnum.ETRM), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(EventTypeEnum.TRAD);
			} else {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> MapperS.of(eventTypeRule.evaluate(item.get())));
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
