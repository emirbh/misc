package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CollateralValueMethod;
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

public class CollateralValueMethodOnlyExistsValidator implements ValidatorWithArg<CollateralValueMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralValueMethod> ValidationResult<CollateralValueMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashCollateral", ExistenceChecker.isSet((ValueCashEnum) o.getCashCollateral()))
				.put("securitiesCollateral", ExistenceChecker.isSet((ValueSecuritiesEnum) o.getSecuritiesCollateral()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralValueMethod", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralValueMethod", path, "");
		}
		return failure("CollateralValueMethod", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralValueMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
