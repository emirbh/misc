package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDate;
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
@RosettaDataRule("AdjustableOrRelativeDateAdjustableOrRelativeDateChoice")
@ImplementedBy(AdjustableOrRelativeDateAdjustableOrRelativeDateChoice.Default.class)
public interface AdjustableOrRelativeDateAdjustableOrRelativeDateChoice extends Validator<AdjustableOrRelativeDate> {
	
	String NAME = "AdjustableOrRelativeDateAdjustableOrRelativeDateChoice";
	String DEFINITION = "required choice adjustableDate, relativeDate";
	
	class Default implements AdjustableOrRelativeDateAdjustableOrRelativeDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrRelativeDate adjustableOrRelativeDate) {
			ComparisonResult result = executeDataRule(adjustableOrRelativeDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrRelativeDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrRelativeDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableOrRelativeDate adjustableOrRelativeDate) {
			try {
				return choice(MapperS.of(adjustableOrRelativeDate), Arrays.asList("adjustableDate", "relativeDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableOrRelativeDateAdjustableOrRelativeDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrRelativeDate adjustableOrRelativeDate) {
			return Collections.emptyList();
		}
	}
}
