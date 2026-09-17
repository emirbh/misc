package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableOrRelativeDatesChoice")
@ImplementedBy(AdjustableOrRelativeDatesChoice.Default.class)
public interface AdjustableOrRelativeDatesChoice extends Validator<AdjustableOrRelativeDates> {
	
	String NAME = "AdjustableOrRelativeDatesChoice";
	String DEFINITION = "required choice adjustableDates, relativeDates";
	
	class Default implements AdjustableOrRelativeDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrRelativeDates adjustableOrRelativeDates) {
			ComparisonResult result = executeDataRule(adjustableOrRelativeDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrRelativeDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrRelativeDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableOrRelativeDates adjustableOrRelativeDates) {
			try {
				return choice(MapperS.of(adjustableOrRelativeDates), Arrays.asList("adjustableDates", "relativeDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableOrRelativeDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrRelativeDates adjustableOrRelativeDates) {
			return Collections.emptyList();
		}
	}
}
