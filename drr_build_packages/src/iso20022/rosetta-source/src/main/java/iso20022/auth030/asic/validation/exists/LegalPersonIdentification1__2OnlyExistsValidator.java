package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.LegalPersonIdentification1__2;
import iso20022.auth030.asic.OrganisationIdentification15Choice__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LegalPersonIdentification1__2OnlyExistsValidator implements ValidatorWithArg<LegalPersonIdentification1__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegalPersonIdentification1__2> ValidationResult<LegalPersonIdentification1__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((OrganisationIdentification15Choice__2) o.getId()))
				.put("ctry", ExistenceChecker.isSet((String) o.getCtry()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegalPersonIdentification1__2", ValidationResult.ValidationType.ONLY_EXISTS, "LegalPersonIdentification1__2", path, "");
		}
		return failure("LegalPersonIdentification1__2", ValidationResult.ValidationType.ONLY_EXISTS, "LegalPersonIdentification1__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
