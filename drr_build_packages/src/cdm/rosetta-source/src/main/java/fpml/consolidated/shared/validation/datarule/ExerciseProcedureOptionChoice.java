package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ExerciseProcedureOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExerciseProcedureOptionChoice")
@ImplementedBy(ExerciseProcedureOptionChoice.Default.class)
public interface ExerciseProcedureOptionChoice extends Validator<ExerciseProcedureOption> {
	
	String NAME = "ExerciseProcedureOptionChoice";
	String DEFINITION = "one-of";
	
	class Default implements ExerciseProcedureOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedureOption exerciseProcedureOption) {
			ComparisonResult result = executeDataRule(exerciseProcedureOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseProcedureOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseProcedureOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseProcedureOption exerciseProcedureOption) {
			try {
				return choice(MapperS.of(exerciseProcedureOption), Arrays.asList("manualExercise", "automaticExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseProcedureOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedureOption exerciseProcedureOption) {
			return Collections.emptyList();
		}
	}
}
