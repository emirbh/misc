package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.AdditionalTerminationEvent;
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

public class AdditionalTerminationEventOnlyExistsValidator implements ValidatorWithArg<AdditionalTerminationEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdditionalTerminationEvent> ValidationResult<AdditionalTerminationEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("applicableParty", ExistenceChecker.isSet((List<CounterpartyRoleEnum>) o.getApplicableParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdditionalTerminationEvent", ValidationResult.ValidationType.ONLY_EXISTS, "AdditionalTerminationEvent", path, "");
		}
		return failure("AdditionalTerminationEvent", ValidationResult.ValidationType.ONLY_EXISTS, "AdditionalTerminationEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
