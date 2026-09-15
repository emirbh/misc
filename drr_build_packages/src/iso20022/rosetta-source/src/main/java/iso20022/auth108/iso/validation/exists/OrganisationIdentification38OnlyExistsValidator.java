package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.GenericIdentification175;
import iso20022.auth108.iso.OrganisationIdentification38;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OrganisationIdentification38OnlyExistsValidator implements ValidatorWithArg<OrganisationIdentification38, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OrganisationIdentification38> ValidationResult<OrganisationIdentification38> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((GenericIdentification175) o.getId()))
				.put("nm", ExistenceChecker.isSet((String) o.getNm()))
				.put("dmcl", ExistenceChecker.isSet((String) o.getDmcl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OrganisationIdentification38", ValidationResult.ValidationType.ONLY_EXISTS, "OrganisationIdentification38", path, "");
		}
		return failure("OrganisationIdentification38", ValidationResult.ValidationType.ONLY_EXISTS, "OrganisationIdentification38", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
