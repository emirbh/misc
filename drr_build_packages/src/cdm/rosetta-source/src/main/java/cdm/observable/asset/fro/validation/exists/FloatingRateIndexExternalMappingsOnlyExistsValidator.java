package cdm.observable.asset.fro.validation.exists;

import cdm.observable.asset.fro.FloatingRateIndexExternalMap;
import cdm.observable.asset.fro.FloatingRateIndexExternalMappings;
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

public class FloatingRateIndexExternalMappingsOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexExternalMappings, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexExternalMappings> ValidationResult<FloatingRateIndexExternalMappings> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isoCode", ExistenceChecker.isSet((FloatingRateIndexExternalMap) o.getIsoCode()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexExternalMappings", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexExternalMappings", path, "");
		}
		return failure("FloatingRateIndexExternalMappings", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexExternalMappings", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
