package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.LegacyConsentEnum;
import cdm.legaldocumentation.csa.Substitution;
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

public class SubstitutionOnlyExistsValidator implements ValidatorWithArg<Substitution, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Substitution> ValidationResult<Substitution> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("needsConsent", ExistenceChecker.isSet((Boolean) o.getNeedsConsent()))
				.put("substitutionDateLanguage", ExistenceChecker.isSet((String) o.getSubstitutionDateLanguage()))
				.put("specificConsentLanguage", ExistenceChecker.isSet((String) o.getSpecificConsentLanguage()))
				.put("legacyConsent", ExistenceChecker.isSet((LegacyConsentEnum) o.getLegacyConsent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Substitution", ValidationResult.ValidationType.ONLY_EXISTS, "Substitution", path, "");
		}
		return failure("Substitution", ValidationResult.ValidationType.ONLY_EXISTS, "Substitution", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
