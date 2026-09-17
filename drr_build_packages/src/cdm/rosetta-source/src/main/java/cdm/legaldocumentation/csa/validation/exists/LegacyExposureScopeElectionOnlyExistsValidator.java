package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ExcludedProducts;
import cdm.legaldocumentation.csa.LegacyExposureScopeElection;
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

public class LegacyExposureScopeElectionOnlyExistsValidator implements ValidatorWithArg<LegacyExposureScopeElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyExposureScopeElection> ValidationResult<LegacyExposureScopeElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("excludedTransactions", ExistenceChecker.isSet((Boolean) o.getExcludedTransactions()))
				.put("excludedProducts", ExistenceChecker.isSet((List<? extends ExcludedProducts>) o.getExcludedProducts()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyExposureScopeElection", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyExposureScopeElection", path, "");
		}
		return failure("LegacyExposureScopeElection", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyExposureScopeElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
