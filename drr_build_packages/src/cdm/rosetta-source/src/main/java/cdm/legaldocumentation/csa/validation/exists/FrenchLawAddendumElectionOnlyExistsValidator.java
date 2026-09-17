package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.FrenchLawAddendumElection;
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

public class FrenchLawAddendumElectionOnlyExistsValidator implements ValidatorWithArg<FrenchLawAddendumElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FrenchLawAddendumElection> ValidationResult<FrenchLawAddendumElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("isApplicable", ExistenceChecker.isSet((Boolean) o.getIsApplicable()))
				.put("addendumLanguage", ExistenceChecker.isSet((String) o.getAddendumLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FrenchLawAddendumElection", ValidationResult.ValidationType.ONLY_EXISTS, "FrenchLawAddendumElection", path, "");
		}
		return failure("FrenchLawAddendumElection", ValidationResult.ValidationType.ONLY_EXISTS, "FrenchLawAddendumElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
