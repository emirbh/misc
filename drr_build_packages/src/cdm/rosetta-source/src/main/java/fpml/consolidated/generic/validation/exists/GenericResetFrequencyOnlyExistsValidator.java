package fpml.consolidated.generic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.generic.GenericResetFrequency;
import fpml.consolidated.generic.UnderlyerReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericResetFrequencyOnlyExistsValidator implements ValidatorWithArg<GenericResetFrequency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericResetFrequency> ValidationResult<GenericResetFrequency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodExtendedEnum) o.getPeriod()))
				.put("underlyerReference", ExistenceChecker.isSet((UnderlyerReference) o.getUnderlyerReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericResetFrequency", ValidationResult.ValidationType.ONLY_EXISTS, "GenericResetFrequency", path, "");
		}
		return failure("GenericResetFrequency", ValidationResult.ValidationType.ONLY_EXISTS, "GenericResetFrequency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
