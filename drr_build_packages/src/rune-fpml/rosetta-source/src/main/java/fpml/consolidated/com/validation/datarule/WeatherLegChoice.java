package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.WeatherLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("WeatherLegChoice")
@ImplementedBy(WeatherLegChoice.Default.class)
public interface WeatherLegChoice extends Validator<WeatherLeg> {
	
	String NAME = "WeatherLegChoice";
	String DEFINITION = "required choice weatherCalculationPeriods, weatherCalculationPeriodsReference";
	
	class Default implements WeatherLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherLeg weatherLeg) {
			ComparisonResult result = executeDataRule(weatherLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "WeatherLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "WeatherLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(WeatherLeg weatherLeg) {
			try {
				return choice(MapperS.of(weatherLeg), Arrays.asList("weatherCalculationPeriods", "weatherCalculationPeriodsReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WeatherLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherLeg weatherLeg) {
			return Collections.emptyList();
		}
	}
}
