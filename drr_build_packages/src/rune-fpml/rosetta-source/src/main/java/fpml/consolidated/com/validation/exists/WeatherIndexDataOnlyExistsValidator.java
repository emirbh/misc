package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.DataProvider;
import fpml.consolidated.com.DisruptionFallback;
import fpml.consolidated.com.ReferenceLevel;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.WeatherStation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WeatherIndexDataOnlyExistsValidator implements ValidatorWithArg<WeatherIndexData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WeatherIndexData> ValidationResult<WeatherIndexData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("referenceLevel", ExistenceChecker.isSet((ReferenceLevel) o.getReferenceLevel()))
				.put("dataProvider", ExistenceChecker.isSet((DataProvider) o.getDataProvider()))
				.put("finalEditedData", ExistenceChecker.isSet((Boolean) o.getFinalEditedData()))
				.put("weatherStation", ExistenceChecker.isSet((WeatherStation) o.getWeatherStation()))
				.put("weatherStationFallback", ExistenceChecker.isSet((WeatherStation) o.getWeatherStationFallback()))
				.put("weatherStationSecondFallback", ExistenceChecker.isSet((WeatherStation) o.getWeatherStationSecondFallback()))
				.put("alternativeDataProvider", ExistenceChecker.isSet((Boolean) o.getAlternativeDataProvider()))
				.put("synopticDataFallback", ExistenceChecker.isSet((Boolean) o.getSynopticDataFallback()))
				.put("adjustmentToFallbackWeatherStation", ExistenceChecker.isSet((Boolean) o.getAdjustmentToFallbackWeatherStation()))
				.put("primaryDisruptionFallbacks", ExistenceChecker.isSet((DisruptionFallback) o.getPrimaryDisruptionFallbacks()))
				.put("secondaryDisruptionFallbacks", ExistenceChecker.isSet((DisruptionFallback) o.getSecondaryDisruptionFallbacks()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WeatherIndexData", ValidationResult.ValidationType.ONLY_EXISTS, "WeatherIndexData", path, "");
		}
		return failure("WeatherIndexData", ValidationResult.ValidationType.ONLY_EXISTS, "WeatherIndexData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
