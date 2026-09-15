package drr.enrichment.common.trade.functions;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(IsEligible.IsEligibleDefault.class)
public abstract class IsEligible implements RosettaFunction {

	/**
	* @param tradeState 
	* @param enrichedWorkflowStep 
	* @return isEligible 
	*/
	public Boolean evaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
		Boolean isEligible = doEvaluate(tradeState, enrichedWorkflowStep);
		
		return isEligible;
	}

	protected abstract Boolean doEvaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep);

	public static class IsEligibleDefault extends IsEligible {
		@Override
		protected Boolean doEvaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
			Boolean isEligible = null;
			return assignOutput(isEligible, tradeState, enrichedWorkflowStep);
		}
		
		protected Boolean assignOutput(Boolean isEligible, TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
			isEligible = true;
			
			return isEligible;
		}
	}
}
