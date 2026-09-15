package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ExerciseProcedure;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExerciseProcedureChoice")
@ImplementedBy(ExerciseProcedureChoice.Default.class)
public interface ExerciseProcedureChoice extends Validator<ExerciseProcedure> {
	
	String NAME = "ExerciseProcedureChoice";
	String DEFINITION = "required choice manualExercise, automaticExercise";
	
	class Default implements ExerciseProcedureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedure exerciseProcedure) {
			ComparisonResult result = executeDataRule(exerciseProcedure);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseProcedure", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseProcedure", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseProcedure exerciseProcedure) {
			try {
				return choice(MapperS.of(exerciseProcedure), Arrays.asList("manualExercise", "automaticExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseProcedureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedure exerciseProcedure) {
			return Collections.emptyList();
		}
	}
}
