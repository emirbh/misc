package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignaturePropertyType;
import fpml.consolidated.SignaturePropertyTypeChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignaturePropertyTypeOnlyExistsValidator implements ValidatorWithArg<SignaturePropertyType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SignaturePropertyType> ValidationResult<SignaturePropertyType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("target", ExistenceChecker.isSet((String) o.getTarget()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("signaturePropertyTypeChoice", ExistenceChecker.isSet((List<? extends SignaturePropertyTypeChoice>) o.getSignaturePropertyTypeChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SignaturePropertyType", ValidationResult.ValidationType.ONLY_EXISTS, "SignaturePropertyType", path, "");
		}
		return failure("SignaturePropertyType", ValidationResult.ValidationType.ONLY_EXISTS, "SignaturePropertyType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
