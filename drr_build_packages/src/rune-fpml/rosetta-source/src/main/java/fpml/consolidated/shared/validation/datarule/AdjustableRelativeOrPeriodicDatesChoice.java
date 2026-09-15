package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableRelativeOrPeriodicDatesChoice")
@ImplementedBy(AdjustableRelativeOrPeriodicDatesChoice.Default.class)
public interface AdjustableRelativeOrPeriodicDatesChoice extends Validator<AdjustableRelativeOrPeriodicDates> {
	
	String NAME = "AdjustableRelativeOrPeriodicDatesChoice";
	String DEFINITION = "required choice adjustableDates, relativeDateSequence, periodicDates";
	
	class Default implements AdjustableRelativeOrPeriodicDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			ComparisonResult result = executeDataRule(adjustableRelativeOrPeriodicDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			try {
				return choice(MapperS.of(adjustableRelativeOrPeriodicDates), Arrays.asList("adjustableDates", "relativeDateSequence", "periodicDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableRelativeOrPeriodicDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			return Collections.emptyList();
		}
	}
}
