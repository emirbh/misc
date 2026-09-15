package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ESMAPartyInformationOnlyExistsValidator implements ValidatorWithArg<ESMAPartyInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ESMAPartyInformation> ValidationResult<ESMAPartyInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("natureOfParty", ExistenceChecker.isSet((NatureOfPartyEnum) o.getNatureOfParty()))
				.put("corporateSector", ExistenceChecker.isSet((CorporateSector) o.getCorporateSector()))
				.put("exceedsClearingThreshold", ExistenceChecker.isSet((Boolean) o.getExceedsClearingThreshold()))
				.put("directlyLinkedActivity", ExistenceChecker.isSet((Boolean) o.getDirectlyLinkedActivity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ESMAPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "ESMAPartyInformation", path, "");
		}
		return failure("ESMAPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "ESMAPartyInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
