package cdm.observable.asset.fro.validation.exists;

import cdm.observable.asset.fro.FloatingRateIndexExternalMap;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateIndexExternalMapOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexExternalMap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexExternalMap> ValidationResult<FloatingRateIndexExternalMap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("externalId", ExistenceChecker.isSet((String) o.getExternalId()))
				.put("externalStandard", ExistenceChecker.isSet((String) o.getExternalStandard()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexExternalMap", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexExternalMap", path, "");
		}
		return failure("FloatingRateIndexExternalMap", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexExternalMap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
