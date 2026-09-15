package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.DSAKeyValue;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DSAKeyValueOnlyExistsValidator implements ValidatorWithArg<DSAKeyValue, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DSAKeyValue> ValidationResult<DSAKeyValue> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("p", ExistenceChecker.isSet((String) o.getP()))
				.put("q", ExistenceChecker.isSet((String) o.getQ()))
				.put("g", ExistenceChecker.isSet((String) o.getG()))
				.put("y", ExistenceChecker.isSet((String) o.getY()))
				.put("j", ExistenceChecker.isSet((String) o.getJ()))
				.put("seed", ExistenceChecker.isSet((String) o.getSeed()))
				.put("pgenCounter", ExistenceChecker.isSet((String) o.getPgenCounter()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DSAKeyValue", ValidationResult.ValidationType.ONLY_EXISTS, "DSAKeyValue", path, "");
		}
		return failure("DSAKeyValue", ValidationResult.ValidationType.ONLY_EXISTS, "DSAKeyValue", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
