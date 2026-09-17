package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CalculationPeriod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CalculationPeriodChoice1")
@ImplementedBy(CalculationPeriodChoice1.Default.class)
public interface CalculationPeriodChoice1 extends Validator<CalculationPeriod> {
	
	String NAME = "CalculationPeriodChoice1";
	String DEFINITION = "optional choice floatingRateDefinition, fixedRate";
	
	class Default implements CalculationPeriodChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriod calculationPeriod) {
			ComparisonResult result = executeDataRule(calculationPeriod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationPeriod calculationPeriod) {
			try {
				return choice(MapperS.of(calculationPeriod), Arrays.asList("floatingRateDefinition", "fixedRate"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationPeriodChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriod calculationPeriod) {
			return Collections.emptyList();
		}
	}
}
