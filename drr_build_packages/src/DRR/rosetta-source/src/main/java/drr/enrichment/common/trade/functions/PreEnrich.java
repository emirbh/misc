package drr.enrichment.common.trade.functions;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PreEnrich.PreEnrichDefault.class)
public abstract class PreEnrich implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param workflowStep 
	* @return enrichedWorkflowStep 
	*/
	public WorkflowStep evaluate(WorkflowStep workflowStep) {
		WorkflowStep.WorkflowStepBuilder enrichedWorkflowStepBuilder = doEvaluate(workflowStep);
		
		final WorkflowStep enrichedWorkflowStep;
		if (enrichedWorkflowStepBuilder == null) {
			enrichedWorkflowStep = null;
		} else {
			enrichedWorkflowStep = enrichedWorkflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, enrichedWorkflowStep);
		}
		
		return enrichedWorkflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(WorkflowStep workflowStep);

	public static class PreEnrichDefault extends PreEnrich {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(WorkflowStep workflowStep) {
			WorkflowStep.WorkflowStepBuilder enrichedWorkflowStep = WorkflowStep.builder();
			return assignOutput(enrichedWorkflowStep, workflowStep);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder enrichedWorkflowStep, WorkflowStep workflowStep) {
			enrichedWorkflowStep = toBuilder(workflowStep);
			
			return Optional.ofNullable(enrichedWorkflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
