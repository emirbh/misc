package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.common.OtherAgreementTerms;
import cdm.legaldocumentation.csa.OtherAgreements;
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

public class OtherAgreementsOnlyExistsValidator implements ValidatorWithArg<OtherAgreements, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OtherAgreements> ValidationResult<OtherAgreements> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("otherCsa", ExistenceChecker.isSet((OtherAgreementTerms) o.getOtherCsa()))
				.put("japaneseLawCsa", ExistenceChecker.isSet((OtherAgreementTerms) o.getJapaneseLawCsa()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OtherAgreements", ValidationResult.ValidationType.ONLY_EXISTS, "OtherAgreements", path, "");
		}
		return failure("OtherAgreements", ValidationResult.ValidationType.ONLY_EXISTS, "OtherAgreements", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
