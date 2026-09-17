package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FallbackRateObservation;
import fpml.consolidated.shared.RateObservation;
import fpml.consolidated.shared.RateReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RateObservationOnlyExistsValidator implements ValidatorWithArg<RateObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RateObservation> ValidationResult<RateObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("resetDate", ExistenceChecker.isSet((ZonedDateTime) o.getResetDate()))
				.put("adjustedFixingDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdjustedFixingDate()))
				.put("observedRate", ExistenceChecker.isSet((BigDecimal) o.getObservedRate()))
				.put("treatedRate", ExistenceChecker.isSet((BigDecimal) o.getTreatedRate()))
				.put("observationWeight", ExistenceChecker.isSet((Integer) o.getObservationWeight()))
				.put("rateReference", ExistenceChecker.isSet((RateReference) o.getRateReference()))
				.put("forecastRate", ExistenceChecker.isSet((BigDecimal) o.getForecastRate()))
				.put("treatedForecastRate", ExistenceChecker.isSet((BigDecimal) o.getTreatedForecastRate()))
				.put("fallback", ExistenceChecker.isSet((FallbackRateObservation) o.getFallback()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RateObservation", ValidationResult.ValidationType.ONLY_EXISTS, "RateObservation", path, "");
		}
		return failure("RateObservation", ValidationResult.ValidationType.ONLY_EXISTS, "RateObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
