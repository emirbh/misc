package cdm.event.workflow.validation.datarule;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice")
@ImplementedBy(WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice.Default.class)
public interface WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice extends Validator<WorkflowStep> {
	
	String NAME = "WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice";
	String DEFINITION = "required choice counterpartyPositionBusinessEvent, businessEvent";
	
	class Default implements WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice {
	
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
				return choice(MapperS.of(workflowStep), Arrays.asList("counterpartyPositionBusinessEvent", "businessEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WorkflowStep workflowStep) {
			return Collections.emptyList();
		}
	}
}
