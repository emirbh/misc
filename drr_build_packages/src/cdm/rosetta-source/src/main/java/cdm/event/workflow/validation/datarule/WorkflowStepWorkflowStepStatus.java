package cdm.event.workflow.validation.datarule;

import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("WorkflowStepWorkflowStepStatus")
@ImplementedBy(WorkflowStepWorkflowStepStatus.Default.class)
public interface WorkflowStepWorkflowStepStatus extends Validator<WorkflowStep> {
	
	String NAME = "WorkflowStepWorkflowStepStatus";
	String DEFINITION = "(businessEvent exists and nextEvent -> instruction is absent and rejected is absent) or (nextEvent -> instruction exists and businessEvent is absent and rejected is absent) or (rejected exists and businessEvent is absent and nextEvent is absent) or (proposedEvent exists and nextEvent is absent and rejected is absent) or (previousWorkflowStep exists and action = ActionEnum -> Cancel)";
	
	class Default implements WorkflowStepWorkflowStepStatus {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WorkflowStep workflowStep) {
			ComparisonResult result = executeDataRule(workflowStep);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "WorkflowStep", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "WorkflowStep", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(WorkflowStep workflowStep) {
			try {
				return exists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent())).andNullSafe(notExists(MapperS.of(workflowStep).<EventInstruction>map("getNextEvent", _workflowStep -> _workflowStep.getNextEvent()).<Instruction>mapC("getInstruction", eventInstruction -> eventInstruction.getInstruction()))).andNullSafe(notExists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected()))).orNullSafe(exists(MapperS.of(workflowStep).<EventInstruction>map("getNextEvent", _workflowStep -> _workflowStep.getNextEvent()).<Instruction>mapC("getInstruction", eventInstruction -> eventInstruction.getInstruction())).andNullSafe(notExists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()))).andNullSafe(notExists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected())))).orNullSafe(exists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected())).andNullSafe(notExists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()))).andNullSafe(notExists(MapperS.of(workflowStep).<EventInstruction>map("getNextEvent", _workflowStep -> _workflowStep.getNextEvent())))).orNullSafe(exists(MapperS.of(workflowStep).<EventInstruction>map("getProposedEvent", _workflowStep -> _workflowStep.getProposedEvent())).andNullSafe(notExists(MapperS.of(workflowStep).<EventInstruction>map("getNextEvent", _workflowStep -> _workflowStep.getNextEvent()))).andNullSafe(notExists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected())))).orNullSafe(exists(MapperS.of(workflowStep).<ReferenceWithMetaWorkflowStep>map("getPreviousWorkflowStep", _workflowStep -> _workflowStep.getPreviousWorkflowStep())).andNullSafe(areEqual(MapperS.of(workflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.CANCEL), CardinalityOperator.All)));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WorkflowStepWorkflowStepStatus {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WorkflowStep workflowStep) {
			return Collections.emptyList();
		}
	}
}
