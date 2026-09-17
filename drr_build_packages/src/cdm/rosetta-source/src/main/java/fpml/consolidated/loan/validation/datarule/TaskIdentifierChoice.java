package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.TaskIdentifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TaskIdentifierChoice")
@ImplementedBy(TaskIdentifierChoice.Default.class)
public interface TaskIdentifierChoice extends Validator<TaskIdentifier> {
	
	String NAME = "TaskIdentifierChoice";
	String DEFINITION = "required choice taskId, versionedTaskId";
	
	class Default implements TaskIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaskIdentifier taskIdentifier) {
			ComparisonResult result = executeDataRule(taskIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TaskIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TaskIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TaskIdentifier taskIdentifier) {
			try {
				return choice(MapperS.of(taskIdentifier), Arrays.asList("taskId", "versionedTaskId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TaskIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaskIdentifier taskIdentifier) {
			return Collections.emptyList();
		}
	}
}
