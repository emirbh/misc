package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SharedAmericanExercise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SharedAmericanExerciseChoice")
@ImplementedBy(SharedAmericanExerciseChoice.Default.class)
public interface SharedAmericanExerciseChoice extends Validator<SharedAmericanExercise> {
	
	String NAME = "SharedAmericanExerciseChoice";
	String DEFINITION = "optional choice latestExerciseTime, latestExerciseTimeDetermination";
	
	class Default implements SharedAmericanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SharedAmericanExercise sharedAmericanExercise) {
			ComparisonResult result = executeDataRule(sharedAmericanExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SharedAmericanExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SharedAmericanExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SharedAmericanExercise sharedAmericanExercise) {
			try {
				return choice(MapperS.of(sharedAmericanExercise), Arrays.asList("latestExerciseTime", "latestExerciseTimeDetermination"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SharedAmericanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SharedAmericanExercise sharedAmericanExercise) {
			return Collections.emptyList();
		}
	}
}
