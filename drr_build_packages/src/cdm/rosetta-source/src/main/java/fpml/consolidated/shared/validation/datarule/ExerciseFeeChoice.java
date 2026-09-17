package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ExerciseFee;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExerciseFeeChoice")
@ImplementedBy(ExerciseFeeChoice.Default.class)
public interface ExerciseFeeChoice extends Validator<ExerciseFee> {
	
	String NAME = "ExerciseFeeChoice";
	String DEFINITION = "optional choice feeAmount, feeRate";
	
	class Default implements ExerciseFeeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFee exerciseFee) {
			ComparisonResult result = executeDataRule(exerciseFee);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseFee", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseFee", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseFee exerciseFee) {
			try {
				return choice(MapperS.of(exerciseFee), Arrays.asList("feeAmount", "feeRate"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseFeeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFee exerciseFee) {
			return Collections.emptyList();
		}
	}
}
