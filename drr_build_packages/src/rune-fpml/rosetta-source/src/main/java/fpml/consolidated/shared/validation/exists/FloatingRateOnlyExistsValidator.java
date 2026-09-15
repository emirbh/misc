package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.SpreadSchedule;
import fpml.consolidated.shared.StrikeSchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateOnlyExistsValidator implements ValidatorWithArg<FloatingRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRate> ValidationResult<FloatingRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("floatingRateIndex", ExistenceChecker.isSet((FloatingRateIndex) o.getFloatingRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet((Period) o.getIndexTenor()))
				.put("calculationParameters", ExistenceChecker.isSet((CalculationParameters) o.getCalculationParameters()))
				.put("fallbackRate", ExistenceChecker.isSet((FallbackRate) o.getFallbackRate()))
				.put("floatingRateMultiplierSchedule", ExistenceChecker.isSet((Schedule) o.getFloatingRateMultiplierSchedule()))
				.put("spreadSchedule", ExistenceChecker.isSet((List<? extends SpreadSchedule>) o.getSpreadSchedule()))
				.put("rateTreatment", ExistenceChecker.isSet((RateTreatmentEnum) o.getRateTreatment()))
				.put("capRateSchedule", ExistenceChecker.isSet((List<? extends StrikeSchedule>) o.getCapRateSchedule()))
				.put("floorRateSchedule", ExistenceChecker.isSet((List<? extends StrikeSchedule>) o.getFloorRateSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRate", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRate", path, "");
		}
		return failure("FloatingRate", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
