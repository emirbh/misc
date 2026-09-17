package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExercise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionExerciseChoice1")
@ImplementedBy(OptionExerciseChoice1.Default.class)
public interface OptionExerciseChoice1 extends Validator<OptionExercise> {
	
	String NAME = "OptionExerciseChoice1";
	String DEFINITION = "optional choice settlementType, cashSettlement, physicalSettlement";
	
	class Default implements OptionExerciseChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise optionExercise) {
			ComparisonResult result = executeDataRule(optionExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionExercise optionExercise) {
			try {
				return choice(MapperS.of(optionExercise), Arrays.asList("settlementType", "cashSettlement", "physicalSettlement"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise optionExercise) {
			return Collections.emptyList();
		}
	}
}
