package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.BasketId;
import fpml.consolidated.asset.BasketName;
import fpml.consolidated.com.CommodityBasket;
import fpml.consolidated.com.CommodityBasketByNotional;
import fpml.consolidated.com.CommodityBasketByPercentage;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketOnlyExistsValidator implements ValidatorWithArg<CommodityBasket, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasket> ValidationResult<CommodityBasket> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basketName", ExistenceChecker.isSet((BasketName) o.getBasketName()))
				.put("basketId", ExistenceChecker.isSet((List<? extends BasketId>) o.getBasketId()))
				.put("notionalQuantityBasket", ExistenceChecker.isSet((CommodityBasketByNotional) o.getNotionalQuantityBasket()))
				.put("notionalAmountBasket", ExistenceChecker.isSet((CommodityBasketByPercentage) o.getNotionalAmountBasket()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasket", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasket", path, "");
		}
		return failure("CommodityBasket", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasket", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
