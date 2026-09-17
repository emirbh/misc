package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CalculationParameters;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CalculationParametersChoice")
@ImplementedBy(CalculationParametersChoice.Default.class)
public interface CalculationParametersChoice extends Validator<CalculationParameters> {
	
	String NAME = "CalculationParametersChoice";
	String DEFINITION = "optional choice lookback, observationShift, lockout";
	
	class Default implements CalculationParametersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationParameters calculationParameters) {
			ComparisonResult result = executeDataRule(calculationParameters);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationParameters", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationParameters", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationParameters calculationParameters) {
			try {
				return choice(MapperS.of(calculationParameters), Arrays.asList("lookback", "observationShift", "lockout"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationParametersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationParameters calculationParameters) {
			return Collections.emptyList();
		}
	}
}
