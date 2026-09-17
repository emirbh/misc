package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.FloatingLegCalculation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FloatingLegCalculationChoice")
@ImplementedBy(FloatingLegCalculationChoice.Default.class)
public interface FloatingLegCalculationChoice extends Validator<FloatingLegCalculation> {
	
	String NAME = "FloatingLegCalculationChoice";
	String DEFINITION = "optional choice spread, spreadSchedule, spreadPercentage";
	
	class Default implements FloatingLegCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingLegCalculation floatingLegCalculation) {
			ComparisonResult result = executeDataRule(floatingLegCalculation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingLegCalculation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingLegCalculation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FloatingLegCalculation floatingLegCalculation) {
			try {
				return choice(MapperS.of(floatingLegCalculation), Arrays.asList("spread", "spreadSchedule", "spreadPercentage"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingLegCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingLegCalculation floatingLegCalculation) {
			return Collections.emptyList();
		}
	}
}
