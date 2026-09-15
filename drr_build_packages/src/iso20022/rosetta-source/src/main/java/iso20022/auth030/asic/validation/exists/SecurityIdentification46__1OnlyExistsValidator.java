package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.SecurityIdentification46__1;
import iso20022.auth030.asic.UniqueProductIdentifier2Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecurityIdentification46__1OnlyExistsValidator implements ValidatorWithArg<SecurityIdentification46__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecurityIdentification46__1> ValidationResult<SecurityIdentification46__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unqPdctIdr", ExistenceChecker.isSet((UniqueProductIdentifier2Choice__1) o.getUnqPdctIdr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityIdentification46__1", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityIdentification46__1", path, "");
		}
		return failure("SecurityIdentification46__1", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityIdentification46__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
