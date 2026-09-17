package cdm.product.template.validation.datarule;

import cdm.product.template.ExerciseTerms;
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
@RosettaDataRule("ExerciseTermsExerciseDateExpirationDateChoice")
@ImplementedBy(ExerciseTermsExerciseDateExpirationDateChoice.Default.class)
public interface ExerciseTermsExerciseDateExpirationDateChoice extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsExerciseDateExpirationDateChoice";
	String DEFINITION = "required choice exerciseDates, expirationDate";
	
	class Default implements ExerciseTermsExerciseDateExpirationDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseTerms exerciseTerms) {
			ComparisonResult result = executeDataRule(exerciseTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseTerms exerciseTerms) {
			try {
				return choice(MapperS.of(exerciseTerms), Arrays.asList("exerciseDates", "expirationDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsExerciseDateExpirationDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseTerms exerciseTerms) {
			return Collections.emptyList();
		}
	}
}
