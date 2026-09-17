package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.math.RoundingModeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.legaldocumentation.csa.CollateralRounding;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralRoundingOnlyExistsValidator implements ValidatorWithArg<CollateralRounding, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralRounding> ValidationResult<CollateralRounding> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryAmount", ExistenceChecker.isSet((BigDecimal) o.getDeliveryAmount()))
				.put("deliveryDirection", ExistenceChecker.isSet((RoundingModeEnum) o.getDeliveryDirection()))
				.put("returnAmount", ExistenceChecker.isSet((BigDecimal) o.getReturnAmount()))
				.put("returnDirection", ExistenceChecker.isSet((RoundingModeEnum) o.getReturnDirection()))
				.put("currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getCurrency()))
				.put("other", ExistenceChecker.isSet((String) o.getOther()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralRounding", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralRounding", path, "");
		}
		return failure("CollateralRounding", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralRounding", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
