package cdm.product.template.validation.datarule;

import cdm.product.template.ExerciseFeeSchedule;
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
@RosettaDataRule("ExerciseFeeScheduleExerciseFeeScheduleChoice")
@ImplementedBy(ExerciseFeeScheduleExerciseFeeScheduleChoice.Default.class)
public interface ExerciseFeeScheduleExerciseFeeScheduleChoice extends Validator<ExerciseFeeSchedule> {
	
	String NAME = "ExerciseFeeScheduleExerciseFeeScheduleChoice";
	String DEFINITION = "required choice feeAmountSchedule, feeRateSchedule";
	
	class Default implements ExerciseFeeScheduleExerciseFeeScheduleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFeeSchedule exerciseFeeSchedule) {
			ComparisonResult result = executeDataRule(exerciseFeeSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseFeeSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseFeeSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseFeeSchedule exerciseFeeSchedule) {
			try {
				return choice(MapperS.of(exerciseFeeSchedule), Arrays.asList("feeAmountSchedule", "feeRateSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseFeeScheduleExerciseFeeScheduleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFeeSchedule exerciseFeeSchedule) {
			return Collections.emptyList();
		}
	}
}
