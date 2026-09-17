package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.RecalculationOfValueElection;
import cdm.legaldocumentation.csa.RecalculationOfValueElectionEnum;
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

public class RecalculationOfValueElectionOnlyExistsValidator implements ValidatorWithArg<RecalculationOfValueElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RecalculationOfValueElection> ValidationResult<RecalculationOfValueElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("recalculationOfValueElection", ExistenceChecker.isSet((RecalculationOfValueElectionEnum) o.getRecalculationOfValueElection()))
				.put("recalculationOfValueTerms", ExistenceChecker.isSet((String) o.getRecalculationOfValueTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RecalculationOfValueElection", ValidationResult.ValidationType.ONLY_EXISTS, "RecalculationOfValueElection", path, "");
		}
		return failure("RecalculationOfValueElection", ValidationResult.ValidationType.ONLY_EXISTS, "RecalculationOfValueElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
