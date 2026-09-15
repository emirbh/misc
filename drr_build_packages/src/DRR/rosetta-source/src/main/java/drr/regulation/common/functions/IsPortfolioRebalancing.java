package drr.regulation.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.qualification.functions.Qualify_PortfolioRebalancing;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsPortfolioRebalancing.IsPortfolioRebalancingDefault.class)
public abstract class IsPortfolioRebalancing implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_PortfolioRebalancing qualify_PortfolioRebalancing;

	/**
	* @param originatingWorkflowStep 
	* @return result 
	*/
	public Boolean evaluate(WorkflowStep originatingWorkflowStep) {
		Boolean result = doEvaluate(originatingWorkflowStep);
		
		return result;
	}

	protected abstract Boolean doEvaluate(WorkflowStep originatingWorkflowStep);

	public static class IsPortfolioRebalancingDefault extends IsPortfolioRebalancing {
		@Override
		protected Boolean doEvaluate(WorkflowStep originatingWorkflowStep) {
			Boolean result = null;
			return assignOutput(result, originatingWorkflowStep);
		}
		
		protected Boolean assignOutput(Boolean result, WorkflowStep originatingWorkflowStep) {
			result = areEqual(MapperS.of(qualify_PortfolioRebalancing.evaluate(MapperS.of(originatingWorkflowStep).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(originatingWorkflowStep).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.PORTFOLIO_REBALANCING), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
