package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
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
@RosettaDataRule("AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice")
@ImplementedBy(AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice.Default.class)
public interface AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice extends Validator<AdjustableRelativeOrPeriodicDates> {
	
	String NAME = "AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice";
	String DEFINITION = "required choice adjustableDates, relativeDates, periodicDates";
	
	class Default implements AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice {
	
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
				return choice(MapperS.of(adjustableRelativeOrPeriodicDates), Arrays.asList("adjustableDates", "relativeDates", "periodicDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			return Collections.emptyList();
		}
	}
}
