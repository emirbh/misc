package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.LegacyResolutionValue;
import cdm.legaldocumentation.csa.ValueCashEnum;
import cdm.legaldocumentation.csa.ValueSecuritiesEnum;
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

public class LegacyResolutionValueOnlyExistsValidator implements ValidatorWithArg<LegacyResolutionValue, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyResolutionValue> ValidationResult<LegacyResolutionValue> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cash", ExistenceChecker.isSet((ValueCashEnum) o.getCash()))
				.put("securities", ExistenceChecker.isSet((ValueSecuritiesEnum) o.getSecurities()))
				.put("fallback", ExistenceChecker.isSet((Boolean) o.getFallback()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyResolutionValue", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyResolutionValue", path, "");
		}
		return failure("LegacyResolutionValue", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyResolutionValue", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
