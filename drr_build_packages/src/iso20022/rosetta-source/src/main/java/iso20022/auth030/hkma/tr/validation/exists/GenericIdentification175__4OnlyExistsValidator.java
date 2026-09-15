package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.GenericIdentification175__4;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericIdentification175__4OnlyExistsValidator implements ValidatorWithArg<GenericIdentification175__4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericIdentification175__4> ValidationResult<GenericIdentification175__4> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("schmeNm", ExistenceChecker.isSet((String) o.getSchmeNm()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericIdentification175__4", ValidationResult.ValidationType.ONLY_EXISTS, "GenericIdentification175__4", path, "");
		}
		return failure("GenericIdentification175__4", ValidationResult.ValidationType.ONLY_EXISTS, "GenericIdentification175__4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
