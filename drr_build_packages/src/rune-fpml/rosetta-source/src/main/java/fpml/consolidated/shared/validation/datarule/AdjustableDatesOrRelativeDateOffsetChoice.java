package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableDatesOrRelativeDateOffsetChoice")
@ImplementedBy(AdjustableDatesOrRelativeDateOffsetChoice.Default.class)
public interface AdjustableDatesOrRelativeDateOffsetChoice extends Validator<AdjustableDatesOrRelativeDateOffset> {
	
	String NAME = "AdjustableDatesOrRelativeDateOffsetChoice";
	String DEFINITION = "one-of";
	
	class Default implements AdjustableDatesOrRelativeDateOffsetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDatesOrRelativeDateOffset adjustableDatesOrRelativeDateOffset) {
			ComparisonResult result = executeDataRule(adjustableDatesOrRelativeDateOffset);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDatesOrRelativeDateOffset", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDatesOrRelativeDateOffset", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableDatesOrRelativeDateOffset adjustableDatesOrRelativeDateOffset) {
			try {
				return choice(MapperS.of(adjustableDatesOrRelativeDateOffset), Arrays.asList("adjustableDates", "relativeDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableDatesOrRelativeDateOffsetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDatesOrRelativeDateOffset adjustableDatesOrRelativeDateOffset) {
			return Collections.emptyList();
		}
	}
}
