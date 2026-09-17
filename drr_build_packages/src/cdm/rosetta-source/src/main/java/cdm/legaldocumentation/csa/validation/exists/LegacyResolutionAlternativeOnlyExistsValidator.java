package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.LegacyResolutionAlternative;
import cdm.legaldocumentation.csa.LegacyResolutionAlternativeEnum;
import cdm.observable.asset.Money;
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

public class LegacyResolutionAlternativeOnlyExistsValidator implements ValidatorWithArg<LegacyResolutionAlternative, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyResolutionAlternative> ValidationResult<LegacyResolutionAlternative> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("resolutionAlternative", ExistenceChecker.isSet((LegacyResolutionAlternativeEnum) o.getResolutionAlternative()))
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyResolutionAlternative", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyResolutionAlternative", path, "");
		}
		return failure("LegacyResolutionAlternative", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyResolutionAlternative", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
