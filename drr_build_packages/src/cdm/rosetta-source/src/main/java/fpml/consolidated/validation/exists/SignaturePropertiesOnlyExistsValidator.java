package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureProperties;
import fpml.consolidated.SignaturePropertyType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignaturePropertiesOnlyExistsValidator implements ValidatorWithArg<SignatureProperties, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SignatureProperties> ValidationResult<SignatureProperties> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("signatureProperty", ExistenceChecker.isSet((List<? extends SignaturePropertyType>) o.getSignatureProperty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SignatureProperties", ValidationResult.ValidationType.ONLY_EXISTS, "SignatureProperties", path, "");
		}
		return failure("SignatureProperties", ValidationResult.ValidationType.ONLY_EXISTS, "SignatureProperties", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
