package iso20022.auth108.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.asic.GenericIdentification175__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericIdentification175__1OnlyExistsValidator implements ValidatorWithArg<GenericIdentification175__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericIdentification175__1> ValidationResult<GenericIdentification175__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericIdentification175__1", ValidationResult.ValidationType.ONLY_EXISTS, "GenericIdentification175__1", path, "");
		}
		return failure("GenericIdentification175__1", ValidationResult.ValidationType.ONLY_EXISTS, "GenericIdentification175__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
