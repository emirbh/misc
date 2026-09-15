package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.WeatherStation;
import fpml.consolidated.com.WeatherStationAirport;
import fpml.consolidated.com.WeatherStationWBAN;
import fpml.consolidated.com.WeatherStationWMO;
import fpml.consolidated.shared.BusinessCenter;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WeatherStationValidator implements Validator<WeatherStation> {

	private List<ComparisonResult> getComparisonResults(WeatherStation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("weatherStationCity", (BusinessCenter) o.getWeatherStationCity() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherStationAirport", (WeatherStationAirport) o.getWeatherStationAirport() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherStationWBAN", (WeatherStationWBAN) o.getWeatherStationWBAN() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherStationWMO", (WeatherStationWMO) o.getWeatherStationWMO() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherStation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherStation", ValidationResult.ValidationType.CARDINALITY, "WeatherStation", path, "", res.getError());
				}
				return success("WeatherStation", ValidationResult.ValidationType.CARDINALITY, "WeatherStation", path, "");
			})
			.collect(toList());
	}

}
