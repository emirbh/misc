package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification2__1;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification3__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NaturalPersonIdentification3__1OnlyExistsValidator implements ValidatorWithArg<NaturalPersonIdentification3__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NaturalPersonIdentification3__1> ValidationResult<NaturalPersonIdentification3__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((NaturalPersonIdentification2__1) o.getId()))
				.put("ctry", ExistenceChecker.isSet((String) o.getCtry()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NaturalPersonIdentification3__1", ValidationResult.ValidationType.ONLY_EXISTS, "NaturalPersonIdentification3__1", path, "");
		}
		return failure("NaturalPersonIdentification3__1", ValidationResult.ValidationType.ONLY_EXISTS, "NaturalPersonIdentification3__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
