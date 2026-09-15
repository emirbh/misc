package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.DataProvider;
import fpml.consolidated.com.DisruptionFallback;
import fpml.consolidated.com.ReferenceLevel;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.WeatherStation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WeatherIndexDataValidator implements Validator<WeatherIndexData> {

	private List<ComparisonResult> getComparisonResults(WeatherIndexData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceLevel", (ReferenceLevel) o.getReferenceLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("dataProvider", (DataProvider) o.getDataProvider() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalEditedData", (Boolean) o.getFinalEditedData() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherStation", (WeatherStation) o.getWeatherStation() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherStationFallback", (WeatherStation) o.getWeatherStationFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherStationSecondFallback", (WeatherStation) o.getWeatherStationSecondFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("alternativeDataProvider", (Boolean) o.getAlternativeDataProvider() != null ? 1 : 0, 0, 1), 
				checkCardinality("synopticDataFallback", (Boolean) o.getSynopticDataFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustmentToFallbackWeatherStation", (Boolean) o.getAdjustmentToFallbackWeatherStation() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryDisruptionFallbacks", (DisruptionFallback) o.getPrimaryDisruptionFallbacks() != null ? 1 : 0, 0, 1), 
				checkCardinality("secondaryDisruptionFallbacks", (DisruptionFallback) o.getSecondaryDisruptionFallbacks() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherIndexData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherIndexData", ValidationResult.ValidationType.CARDINALITY, "WeatherIndexData", path, "", res.getError());
				}
				return success("WeatherIndexData", ValidationResult.ValidationType.CARDINALITY, "WeatherIndexData", path, "");
			})
			.collect(toList());
	}

}
