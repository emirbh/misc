package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFixedPriceOnlyExistsValidator implements ValidatorWithArg<CommodityFixedPrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFixedPrice> ValidationResult<CommodityFixedPrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("price", ExistenceChecker.isSet((BigDecimal) o.getPrice()))
				.put("priceCurrency", ExistenceChecker.isSet((Currency) o.getPriceCurrency()))
				.put("priceUnit", ExistenceChecker.isSet((QuantityUnit) o.getPriceUnit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFixedPrice", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityFixedPrice", path, "");
		}
		return failure("CommodityFixedPrice", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityFixedPrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
