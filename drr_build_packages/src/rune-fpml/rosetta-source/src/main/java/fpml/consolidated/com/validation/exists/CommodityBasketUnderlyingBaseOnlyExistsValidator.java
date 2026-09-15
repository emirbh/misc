package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityBasketUnderlyingBase;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketUnderlyingBaseOnlyExistsValidator implements ValidatorWithArg<CommodityBasketUnderlyingBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketUnderlyingBase> ValidationResult<CommodityBasketUnderlyingBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("direction", ExistenceChecker.isSet((PayerReceiverEnum) o.getDirection()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("pricingDates", ExistenceChecker.isSet((CommodityPricingDates) o.getPricingDates()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasketUnderlyingBase", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketUnderlyingBase", path, "");
		}
		return failure("CommodityBasketUnderlyingBase", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketUnderlyingBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
