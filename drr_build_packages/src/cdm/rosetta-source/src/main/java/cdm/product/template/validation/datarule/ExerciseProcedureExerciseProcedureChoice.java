package cdm.product.template.validation.datarule;

import cdm.product.template.ExerciseProcedure;
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
@RosettaDataRule("ExerciseProcedureExerciseProcedureChoice")
@ImplementedBy(ExerciseProcedureExerciseProcedureChoice.Default.class)
public interface ExerciseProcedureExerciseProcedureChoice extends Validator<ExerciseProcedure> {
	
	String NAME = "ExerciseProcedureExerciseProcedureChoice";
	String DEFINITION = "required choice manualExercise, automaticExercise";
	
	class Default implements ExerciseProcedureExerciseProcedureChoice {
	
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
	class NoOp implements ExerciseProcedureExerciseProcedureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedure exerciseProcedure) {
			return Collections.emptyList();
		}
	}
}
