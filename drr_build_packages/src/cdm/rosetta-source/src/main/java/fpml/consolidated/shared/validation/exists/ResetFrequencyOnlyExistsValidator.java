package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.fpmlenum.WeeklyRollConventionEnum;
import fpml.consolidated.shared.ResetFrequency;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ResetFrequencyOnlyExistsValidator implements ValidatorWithArg<ResetFrequency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ResetFrequency> ValidationResult<ResetFrequency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodExtendedEnum) o.getPeriod()))
				.put("weeklyRollConvention", ExistenceChecker.isSet((WeeklyRollConventionEnum) o.getWeeklyRollConvention()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetFrequency", ValidationResult.ValidationType.ONLY_EXISTS, "ResetFrequency", path, "");
		}
		return failure("ResetFrequency", ValidationResult.ValidationType.ONLY_EXISTS, "ResetFrequency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
