package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CreditSupportAmount;
import cdm.legaldocumentation.csa.CreditSupportAmountEnum;
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

public class CreditSupportAmountOnlyExistsValidator implements ValidatorWithArg<CreditSupportAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportAmount> ValidationResult<CreditSupportAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("creditSupportAmount", ExistenceChecker.isSet((CreditSupportAmountEnum) o.getCreditSupportAmount()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportAmount", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportAmount", path, "");
		}
		return failure("CreditSupportAmount", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
