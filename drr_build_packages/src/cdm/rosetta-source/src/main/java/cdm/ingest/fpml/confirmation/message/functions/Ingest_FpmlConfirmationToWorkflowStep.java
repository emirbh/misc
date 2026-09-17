package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.workflow.WorkflowStep;
import cdm.ingest.fpml.confirmation.message.labels.Ingest_FpmlConfirmationToWorkflowStepLabelProvider;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.confirmation.processes.ClearingConfirmed;
import fpml.consolidated.confirmation.processes.ExecutionAdvice;
import fpml.consolidated.confirmation.processes.ExecutionAdviceRetracted;
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.confirmation.processes.RequestClearing;
import fpml.consolidated.confirmation.processes.TradeChangeAdvice;
import fpml.consolidated.doc.Document;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Ingest_FpmlConfirmationToWorkflowStepLabelProvider.class)
@ImplementedBy(Ingest_FpmlConfirmationToWorkflowStep.Ingest_FpmlConfirmationToWorkflowStepDefault.class)
public abstract class Ingest_FpmlConfirmationToWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapClearingConfirmedToWorkflowStep mapClearingConfirmedToWorkflowStep;
	@Inject protected MapExecutionAdviceRetractedToWorkflowStep mapExecutionAdviceRetractedToWorkflowStep;
	@Inject protected MapExecutionAdviceToWorkflowStep mapExecutionAdviceToWorkflowStep;
	@Inject protected MapExecutionNotificationToWorkflowStep mapExecutionNotificationToWorkflowStep;
	@Inject protected MapRequestClearingToWorkflowStep mapRequestClearingToWorkflowStep;
	@Inject protected MapTradeChangeAdviceToWorkflowStep mapTradeChangeAdviceToWorkflowStep;

	/**
	* @param fpmlDocument 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(Document fpmlDocument) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlDocument);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(Document fpmlDocument);

	public static class Ingest_FpmlConfirmationToWorkflowStepDefault extends Ingest_FpmlConfirmationToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(Document fpmlDocument) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlDocument);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, Document fpmlDocument) {
			if (fpmlDocument == null) {
				workflowStep = null;
			} else if (fpmlDocument instanceof ClearingConfirmed) {
				final ClearingConfirmed clearingConfirmed = (ClearingConfirmed) fpmlDocument;
				workflowStep = toBuilder(mapClearingConfirmedToWorkflowStep.evaluate(clearingConfirmed));
			} else if (fpmlDocument instanceof ExecutionAdvice) {
				final ExecutionAdvice executionAdvice = (ExecutionAdvice) fpmlDocument;
				workflowStep = toBuilder(mapExecutionAdviceToWorkflowStep.evaluate(executionAdvice));
			} else if (fpmlDocument instanceof ExecutionAdviceRetracted) {
				final ExecutionAdviceRetracted executionAdviceRetracted = (ExecutionAdviceRetracted) fpmlDocument;
				workflowStep = toBuilder(mapExecutionAdviceRetractedToWorkflowStep.evaluate(executionAdviceRetracted));
			} else if (fpmlDocument instanceof ExecutionNotification) {
				final ExecutionNotification executionNotification = (ExecutionNotification) fpmlDocument;
				workflowStep = toBuilder(mapExecutionNotificationToWorkflowStep.evaluate(executionNotification));
			} else if (fpmlDocument instanceof RequestClearing) {
				final RequestClearing requestClearing = (RequestClearing) fpmlDocument;
				workflowStep = toBuilder(mapRequestClearingToWorkflowStep.evaluate(requestClearing));
			} else if (fpmlDocument instanceof TradeChangeAdvice) {
				final TradeChangeAdvice tradeChangeAdvice = (TradeChangeAdvice) fpmlDocument;
				workflowStep = toBuilder(mapTradeChangeAdviceToWorkflowStep.evaluate(tradeChangeAdvice));
			} else {
				workflowStep = null;
			}
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
