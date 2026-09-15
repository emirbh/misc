package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.GenericIdentification185__1;
import iso20022.auth030.hkma.tr.UniqueProductIdentifier2Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UniqueProductIdentifier2Choice__1OnlyExistsValidator implements ValidatorWithArg<UniqueProductIdentifier2Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UniqueProductIdentifier2Choice__1> ValidationResult<UniqueProductIdentifier2Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("prtry", ExistenceChecker.isSet((GenericIdentification185__1) o.getPrtry()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UniqueProductIdentifier2Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "UniqueProductIdentifier2Choice__1", path, "");
		}
		return failure("UniqueProductIdentifier2Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "UniqueProductIdentifier2Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
