package cdm.observable.asset.fro.validation.exists;

import cdm.observable.asset.fro.FloatingRateIndexMap;
import cdm.observable.asset.fro.FloatingRateIndexMappings;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateIndexMappingsOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexMappings, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexMappings> ValidationResult<FloatingRateIndexMappings> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mapsTo", ExistenceChecker.isSet((FloatingRateIndexMap) o.getMapsTo()))
				.put("mapsFrom", ExistenceChecker.isSet((List<? extends FloatingRateIndexMap>) o.getMapsFrom()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexMappings", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexMappings", path, "");
		}
		return failure("FloatingRateIndexMappings", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexMappings", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
