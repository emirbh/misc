package drr.regulation.cftc.rewrite.trade.reports;

import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NonStandardizedTermIndicatorRule.NonStandardizedTermIndicatorRuleDefault.class)
public abstract class NonStandardizedTermIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected IsCleared isCleared;
	@Inject protected drr.regulation.common.trade.contract.reports.NonStandardizedTermIndicatorRule nonStandardizedTermIndicatorRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class NonStandardizedTermIndicatorRuleDefault extends NonStandardizedTermIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(notEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<EventInstruction>map("getNextEvent", workflowStep -> workflowStep.getNextEvent()).<EventIntentEnum>map("getIntent", eventInstruction -> eventInstruction.getIntent()), MapperS.of(EventIntentEnum.CLEARING), CardinalityOperator.Any)).getOrDefault(false)) {
						return MapperS.of(nonStandardizedTermIndicatorRule.evaluate(item.get()));
					}
					return MapperS.<Boolean>ofNull();
				}).get();
			
			return output;
		}
	}
}
