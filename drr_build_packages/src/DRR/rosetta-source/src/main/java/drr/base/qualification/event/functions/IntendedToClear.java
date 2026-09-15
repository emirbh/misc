package drr.base.qualification.event.functions;

import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IntendedToClear.IntendedToClearDefault.class)
public abstract class IntendedToClear implements RosettaFunction {

	/**
	* @param originatingWorkflowStep 
	* @return isIntendedToClear 
	*/
	public Boolean evaluate(WorkflowStep originatingWorkflowStep) {
		Boolean isIntendedToClear = doEvaluate(originatingWorkflowStep);
		
		return isIntendedToClear;
	}

	protected abstract Boolean doEvaluate(WorkflowStep originatingWorkflowStep);

	public static class IntendedToClearDefault extends IntendedToClear {
		@Override
		protected Boolean doEvaluate(WorkflowStep originatingWorkflowStep) {
			Boolean isIntendedToClear = null;
			return assignOutput(isIntendedToClear, originatingWorkflowStep);
		}
		
		protected Boolean assignOutput(Boolean isIntendedToClear, WorkflowStep originatingWorkflowStep) {
			if (areEqual(MapperS.of(originatingWorkflowStep).<EventInstruction>map("getNextEvent", workflowStep -> workflowStep.getNextEvent()).<EventIntentEnum>map("getIntent", eventInstruction -> eventInstruction.getIntent()), MapperS.of(EventIntentEnum.CLEARING), CardinalityOperator.All).getOrDefault(false)) {
				isIntendedToClear = true;
			} else {
				isIntendedToClear = false;
			}
			
			return isIntendedToClear;
		}
	}
}
