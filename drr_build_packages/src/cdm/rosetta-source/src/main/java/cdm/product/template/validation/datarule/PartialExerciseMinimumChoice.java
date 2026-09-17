package cdm.product.template.validation.datarule;

import cdm.product.template.PartialExercise;
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
@RosettaDataRule("PartialExerciseMinimumChoice")
@ImplementedBy(PartialExerciseMinimumChoice.Default.class)
public interface PartialExerciseMinimumChoice extends Validator<PartialExercise> {
	
	String NAME = "PartialExerciseMinimumChoice";
	String DEFINITION = "required choice minimumNotionalAmount, minimumNumberOfOptions";
	
	class Default implements PartialExerciseMinimumChoice {
	
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
				return choice(MapperS.of(partialExercise), Arrays.asList("minimumNotionalAmount", "minimumNumberOfOptions"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartialExerciseMinimumChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartialExercise partialExercise) {
			return Collections.emptyList();
		}
	}
}
