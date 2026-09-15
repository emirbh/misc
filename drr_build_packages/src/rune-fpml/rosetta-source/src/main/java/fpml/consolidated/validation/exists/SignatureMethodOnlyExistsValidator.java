package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureMethod;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignatureMethodOnlyExistsValidator implements ValidatorWithArg<SignatureMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SignatureMethod> ValidationResult<SignatureMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("algorithm", ExistenceChecker.isSet((String) o.getAlgorithm()))
				.put("hmacOutputLength", ExistenceChecker.isSet((Integer) o.getHmacOutputLength()))
				.put("anyContents", ExistenceChecker.isSet((List<String>) o.getAnyContents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SignatureMethod", ValidationResult.ValidationType.ONLY_EXISTS, "SignatureMethod", path, "");
		}
		return failure("SignatureMethod", ValidationResult.ValidationType.ONLY_EXISTS, "SignatureMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
