package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.LegacyDeliveryReturnAmountEnum;
import cdm.legaldocumentation.csa.LegacyReturnAmount;
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

public class LegacyReturnAmountOnlyExistsValidator implements ValidatorWithArg<LegacyReturnAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyReturnAmount> ValidationResult<LegacyReturnAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("legacyReturnAmount", ExistenceChecker.isSet((LegacyDeliveryReturnAmountEnum) o.getLegacyReturnAmount()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyReturnAmount", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyReturnAmount", path, "");
		}
		return failure("LegacyReturnAmount", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyReturnAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
