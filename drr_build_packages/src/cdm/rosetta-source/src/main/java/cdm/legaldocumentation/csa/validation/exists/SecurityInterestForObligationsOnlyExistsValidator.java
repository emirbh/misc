package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.SecurityInterestForObligations;
import cdm.legaldocumentation.csa.SecurityInterestObligationsEnum;
import cdm.legaldocumentation.csa.SecurityInterestObligeeEnum;
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

public class SecurityInterestForObligationsOnlyExistsValidator implements ValidatorWithArg<SecurityInterestForObligations, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecurityInterestForObligations> ValidationResult<SecurityInterestForObligations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((List<CounterpartyRoleEnum>) o.getParty()))
				.put("obligations", ExistenceChecker.isSet((SecurityInterestObligationsEnum) o.getObligations()))
				.put("obligee", ExistenceChecker.isSet((SecurityInterestObligeeEnum) o.getObligee()))
				.put("other", ExistenceChecker.isSet((String) o.getOther()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityInterestForObligations", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityInterestForObligations", path, "");
		}
		return failure("SecurityInterestForObligations", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityInterestForObligations", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
