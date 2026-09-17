package cdm.product.template.validation.datarule;

import cdm.product.template.OptionStrike;
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
@RosettaDataRule("OptionStrikeOneOf0")
@ImplementedBy(OptionStrikeOneOf0.Default.class)
public interface OptionStrikeOneOf0 extends Validator<OptionStrike> {
	
	String NAME = "OptionStrikeOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements OptionStrikeOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionStrike optionStrike) {
			ComparisonResult result = executeDataRule(optionStrike);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionStrike", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionStrike", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionStrike optionStrike) {
			try {
				return choice(MapperS.of(optionStrike), Arrays.asList("strikePrice", "strikeReference", "referenceSwapCurve", "averagingStrikeFeature"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionStrikeOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionStrike optionStrike) {
			return Collections.emptyList();
		}
	}
}
