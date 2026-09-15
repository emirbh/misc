package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalProductSpecifications;
import fpml.consolidated.com.CoalStandardQuality;
import fpml.consolidated.com.CoalStandardQualitySchedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalProductSpecificationsOnlyExistsValidator implements ValidatorWithArg<CoalProductSpecifications, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalProductSpecifications> ValidationResult<CoalProductSpecifications> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("standardQuality", ExistenceChecker.isSet((CoalStandardQuality) o.getStandardQuality()))
				.put("standardQualitySchedule", ExistenceChecker.isSet((CoalStandardQualitySchedule) o.getStandardQualitySchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalProductSpecifications", ValidationResult.ValidationType.ONLY_EXISTS, "CoalProductSpecifications", path, "");
		}
		return failure("CoalProductSpecifications", ValidationResult.ValidationType.ONLY_EXISTS, "CoalProductSpecifications", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
