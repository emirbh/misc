package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.OrganisationIdentification38;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OrganisationIdentification15ChoiceOnlyExistsValidator implements ValidatorWithArg<OrganisationIdentification15Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OrganisationIdentification15Choice> ValidationResult<OrganisationIdentification15Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lei", ExistenceChecker.isSet((String) o.getLei()))
				.put("othr", ExistenceChecker.isSet((OrganisationIdentification38) o.getOthr()))
				.put("anyBIC", ExistenceChecker.isSet((String) o.getAnyBIC()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OrganisationIdentification15Choice", ValidationResult.ValidationType.ONLY_EXISTS, "OrganisationIdentification15Choice", path, "");
		}
		return failure("OrganisationIdentification15Choice", ValidationResult.ValidationType.ONLY_EXISTS, "OrganisationIdentification15Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
