package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.FrenchLawAddendum;
import cdm.legaldocumentation.csa.JapaneseSecuritiesProvisions;
import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
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

public class JurisdictionRelatedTermsOnlyExistsValidator implements ValidatorWithArg<JurisdictionRelatedTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends JurisdictionRelatedTerms> ValidationResult<JurisdictionRelatedTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("japaneseSecuritiesProvisions", ExistenceChecker.isSet((JapaneseSecuritiesProvisions) o.getJapaneseSecuritiesProvisions()))
				.put("exclusiveJurisdiction", ExistenceChecker.isSet((Boolean) o.getExclusiveJurisdiction()))
				.put("juryWaiver", ExistenceChecker.isSet((Boolean) o.getJuryWaiver()))
				.put("frenchLawAddendum", ExistenceChecker.isSet((FrenchLawAddendum) o.getFrenchLawAddendum()))
				.put("belgianLawSecurityAgreement", ExistenceChecker.isSet((Boolean) o.getBelgianLawSecurityAgreement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("JurisdictionRelatedTerms", ValidationResult.ValidationType.ONLY_EXISTS, "JurisdictionRelatedTerms", path, "");
		}
		return failure("JurisdictionRelatedTerms", ValidationResult.ValidationType.ONLY_EXISTS, "JurisdictionRelatedTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
