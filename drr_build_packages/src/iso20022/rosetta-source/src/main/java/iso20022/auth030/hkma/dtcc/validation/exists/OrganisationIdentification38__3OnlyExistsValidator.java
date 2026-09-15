package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.GenericIdentification175__3;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification38__3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OrganisationIdentification38__3OnlyExistsValidator implements ValidatorWithArg<OrganisationIdentification38__3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OrganisationIdentification38__3> ValidationResult<OrganisationIdentification38__3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((GenericIdentification175__3) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OrganisationIdentification38__3", ValidationResult.ValidationType.ONLY_EXISTS, "OrganisationIdentification38__3", path, "");
		}
		return failure("OrganisationIdentification38__3", ValidationResult.ValidationType.ONLY_EXISTS, "OrganisationIdentification38__3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
