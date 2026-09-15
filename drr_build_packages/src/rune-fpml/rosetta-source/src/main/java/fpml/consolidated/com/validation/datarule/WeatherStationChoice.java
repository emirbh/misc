package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.WeatherStation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("WeatherStationChoice")
@ImplementedBy(WeatherStationChoice.Default.class)
public interface WeatherStationChoice extends Validator<WeatherStation> {
	
	String NAME = "WeatherStationChoice";
	String DEFINITION = "optional choice weatherStationCity, weatherStationAirport, weatherStationWBAN, weatherStationWMO";
	
	class Default implements WeatherStationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherStation weatherStation) {
			ComparisonResult result = executeDataRule(weatherStation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "WeatherStation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "WeatherStation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(WeatherStation weatherStation) {
			try {
				return choice(MapperS.of(weatherStation), Arrays.asList("weatherStationCity", "weatherStationAirport", "weatherStationWBAN", "weatherStationWMO"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WeatherStationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherStation weatherStation) {
			return Collections.emptyList();
		}
	}
}
