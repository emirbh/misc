package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.LegacyValuationAgent;
import cdm.legaldocumentation.csa.LegacyValuationAgentEnum;
import cdm.legaldocumentation.csa.ValuationAgentPartyEnum;
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

public class LegacyValuationAgentOnlyExistsValidator implements ValidatorWithArg<LegacyValuationAgent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyValuationAgent> ValidationResult<LegacyValuationAgent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((ValuationAgentPartyEnum) o.getParty()))
				.put("valuationAgent", ExistenceChecker.isSet((LegacyValuationAgentEnum) o.getValuationAgent()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyValuationAgent", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyValuationAgent", path, "");
		}
		return failure("LegacyValuationAgent", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyValuationAgent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
