package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import cdm.legaldocumentation.csa.SecuredPartyRightsEventElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecuredPartyRightsEventOnlyExistsValidator implements ValidatorWithArg<SecuredPartyRightsEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecuredPartyRightsEvent> ValidationResult<SecuredPartyRightsEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("securedPartyRightsEventElection", ExistenceChecker.isSet((List<? extends SecuredPartyRightsEventElection>) o.getSecuredPartyRightsEventElection()))
				.put("earlyTerminationDateOptionalLanguage", ExistenceChecker.isSet((Boolean) o.getEarlyTerminationDateOptionalLanguage()))
				.put("failureToPayEarlyTermination", ExistenceChecker.isSet((Boolean) o.getFailureToPayEarlyTermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecuredPartyRightsEvent", ValidationResult.ValidationType.ONLY_EXISTS, "SecuredPartyRightsEvent", path, "");
		}
		return failure("SecuredPartyRightsEvent", ValidationResult.ValidationType.ONLY_EXISTS, "SecuredPartyRightsEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
