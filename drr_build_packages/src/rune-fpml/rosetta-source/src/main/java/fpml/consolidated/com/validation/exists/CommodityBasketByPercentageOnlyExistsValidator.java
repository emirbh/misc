package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketByPercentage;
import fpml.consolidated.com.CommodityBasketUnderlyingByPercentage;
import fpml.consolidated.shared.NotionalAmount;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketByPercentageOnlyExistsValidator implements ValidatorWithArg<CommodityBasketByPercentage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketByPercentage> ValidationResult<CommodityBasketByPercentage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("underlying", ExistenceChecker.isSet((List<? extends CommodityBasketUnderlyingByPercentage>) o.getUnderlying()))
				.put("notionalAmount", ExistenceChecker.isSet((NotionalAmount) o.getNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasketByPercentage", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketByPercentage", path, "");
		}
		return failure("CommodityBasketByPercentage", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketByPercentage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
