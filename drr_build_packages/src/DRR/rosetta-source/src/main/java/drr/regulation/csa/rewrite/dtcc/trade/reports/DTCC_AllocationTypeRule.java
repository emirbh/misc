package drr.regulation.csa.rewrite.dtcc.trade.reports;

import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.qualification.functions.Qualify_Allocation;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_AllocationTypeRule.DTCC_AllocationTypeRuleDefault.class)
public abstract class DTCC_AllocationTypeRule implements ReportFunction<TransactionReportInstruction, AllocationIndicatorEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected Qualify_Allocation qualify_Allocation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AllocationIndicatorEnum evaluate(TransactionReportInstruction input) {
		AllocationIndicatorEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AllocationIndicatorEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_AllocationTypeRuleDefault extends DTCC_AllocationTypeRule {
		@Override
		protected AllocationIndicatorEnum doEvaluate(TransactionReportInstruction input) {
			AllocationIndicatorEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AllocationIndicatorEnum assignOutput(AllocationIndicatorEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Allocation.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get()))).orNullSafe(areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.ALLOCATION), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(AllocationIndicatorEnum.POST);
					}
					if (areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<EventInstruction>map("getNextEvent", workflowStep -> workflowStep.getNextEvent()).<EventIntentEnum>map("getIntent", eventInstruction -> eventInstruction.getIntent()), MapperS.of(EventIntentEnum.ALLOCATION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(AllocationIndicatorEnum.PREA);
					}
					return MapperS.of(AllocationIndicatorEnum.UNAL);
				}).get();
			
			return output;
		}
	}
}
