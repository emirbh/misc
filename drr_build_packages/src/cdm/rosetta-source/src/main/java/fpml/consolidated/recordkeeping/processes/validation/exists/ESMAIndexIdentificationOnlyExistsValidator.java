package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.ESMABenchmarkIndexCode;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ESMAIndexIdentificationOnlyExistsValidator implements ValidatorWithArg<ESMAIndexIdentification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ESMAIndexIdentification> ValidationResult<ESMAIndexIdentification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("code", ExistenceChecker.isSet((ESMABenchmarkIndexCode) o.getCode()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ESMAIndexIdentification", ValidationResult.ValidationType.ONLY_EXISTS, "ESMAIndexIdentification", path, "");
		}
		return failure("ESMAIndexIdentification", ValidationResult.ValidationType.ONLY_EXISTS, "ESMAIndexIdentification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
