package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MultipleExercise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("MultipleExerciseChoice0")
@ImplementedBy(MultipleExerciseChoice0.Default.class)
public interface MultipleExerciseChoice0 extends Validator<MultipleExercise> {
	
	String NAME = "MultipleExerciseChoice0";
	String DEFINITION = "optional choice maximumNotionalAmount, maximumNumberOfOptions";
	
	class Default implements MultipleExerciseChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise multipleExercise) {
			ComparisonResult result = executeDataRule(multipleExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MultipleExercise multipleExercise) {
			try {
				return choice(MapperS.of(multipleExercise), Arrays.asList("maximumNotionalAmount", "maximumNumberOfOptions"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MultipleExerciseChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise multipleExercise) {
			return Collections.emptyList();
		}
	}
}
