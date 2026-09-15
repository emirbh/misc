package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableRelativeOrPeriodicDates2Choice")
@ImplementedBy(AdjustableRelativeOrPeriodicDates2Choice.Default.class)
public interface AdjustableRelativeOrPeriodicDates2Choice extends Validator<AdjustableRelativeOrPeriodicDates2> {
	
	String NAME = "AdjustableRelativeOrPeriodicDates2Choice";
	String DEFINITION = "required choice adjustableDates, relativeDates, periodicDates";
	
	class Default implements AdjustableRelativeOrPeriodicDates2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates2 adjustableRelativeOrPeriodicDates2) {
			ComparisonResult result = executeDataRule(adjustableRelativeOrPeriodicDates2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableRelativeOrPeriodicDates2 adjustableRelativeOrPeriodicDates2) {
			try {
				return choice(MapperS.of(adjustableRelativeOrPeriodicDates2), Arrays.asList("adjustableDates", "relativeDates", "periodicDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableRelativeOrPeriodicDates2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates2 adjustableRelativeOrPeriodicDates2) {
			return Collections.emptyList();
		}
	}
}
