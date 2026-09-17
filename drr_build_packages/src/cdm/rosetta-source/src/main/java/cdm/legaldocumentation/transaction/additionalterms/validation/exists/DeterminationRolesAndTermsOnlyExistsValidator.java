package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.DeterminationRoleEnum;
import cdm.legaldocumentation.transaction.additionalterms.DeterminationRolesAndTerms;
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

public class DeterminationRolesAndTermsOnlyExistsValidator implements ValidatorWithArg<DeterminationRolesAndTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DeterminationRolesAndTerms> ValidationResult<DeterminationRolesAndTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("determinationRole", ExistenceChecker.isSet((DeterminationRoleEnum) o.getDeterminationRole()))
				.put("whoToDetermine", ExistenceChecker.isSet((List<CounterpartyRoleEnum>) o.getWhoToDetermine()))
				.put("disputingParty", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getDisputingParty()))
				.put("fallbackLanguageBespokeTerms", ExistenceChecker.isSet((Clause) o.getFallbackLanguageBespokeTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DeterminationRolesAndTerms", ValidationResult.ValidationType.ONLY_EXISTS, "DeterminationRolesAndTerms", path, "");
		}
		return failure("DeterminationRolesAndTerms", ValidationResult.ValidationType.ONLY_EXISTS, "DeterminationRolesAndTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
