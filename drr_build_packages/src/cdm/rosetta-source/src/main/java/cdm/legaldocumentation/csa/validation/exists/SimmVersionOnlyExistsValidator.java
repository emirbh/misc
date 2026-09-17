package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.SimmVersion;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SimmVersionOnlyExistsValidator implements ValidatorWithArg<SimmVersion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SimmVersion> ValidationResult<SimmVersion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isSpecified", ExistenceChecker.isSet((Boolean) o.getIsSpecified()))
				.put("partyVersion", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getPartyVersion()))
				.put("asSpecified", ExistenceChecker.isSet((String) o.getAsSpecified()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SimmVersion", ValidationResult.ValidationType.ONLY_EXISTS, "SimmVersion", path, "");
		}
		return failure("SimmVersion", ValidationResult.ValidationType.ONLY_EXISTS, "SimmVersion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
