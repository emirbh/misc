package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PartialExercise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PartialExerciseChoice")
@ImplementedBy(PartialExerciseChoice.Default.class)
public interface PartialExerciseChoice extends Validator<PartialExercise> {
	
	String NAME = "PartialExerciseChoice";
	String DEFINITION = "optional choice minimumNotionalAmount, minimumNumberOfOptions";
	
	class Default implements PartialExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartialExercise partialExercise) {
			ComparisonResult result = executeDataRule(partialExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartialExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartialExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartialExercise partialExercise) {
			try {
				return choice(MapperS.of(partialExercise), Arrays.asList("minimumNotionalAmount", "minimumNumberOfOptions"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartialExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartialExercise partialExercise) {
			return Collections.emptyList();
		}
	}
}
