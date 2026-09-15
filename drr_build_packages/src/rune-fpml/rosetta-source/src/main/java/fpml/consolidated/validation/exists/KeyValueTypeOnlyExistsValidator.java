package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.DSAKeyValueType;
import fpml.consolidated.KeyValueType;
import fpml.consolidated.RSAKeyValueType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class KeyValueTypeOnlyExistsValidator implements ValidatorWithArg<KeyValueType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends KeyValueType> ValidationResult<KeyValueType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dsaKeyValue", ExistenceChecker.isSet((DSAKeyValueType) o.getDsaKeyValue()))
				.put("rsaKeyValue", ExistenceChecker.isSet((RSAKeyValueType) o.getRsaKeyValue()))
				.put("anyContents", ExistenceChecker.isSet((String) o.getAnyContents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("KeyValueType", ValidationResult.ValidationType.ONLY_EXISTS, "KeyValueType", path, "");
		}
		return failure("KeyValueType", ValidationResult.ValidationType.ONLY_EXISTS, "KeyValueType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
