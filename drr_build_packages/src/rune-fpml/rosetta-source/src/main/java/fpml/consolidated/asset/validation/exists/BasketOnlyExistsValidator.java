package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.BasketId;
import fpml.consolidated.asset.BasketName;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BasketOnlyExistsValidator implements ValidatorWithArg<Basket, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Basket> ValidationResult<Basket> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("openUnits", ExistenceChecker.isSet((BigDecimal) o.getOpenUnits()))
				.put("basketConstituent", ExistenceChecker.isSet((List<? extends BasketConstituent>) o.getBasketConstituent()))
				.put("basketDivisor", ExistenceChecker.isSet((BigDecimal) o.getBasketDivisor()))
				.put("basketVersion", ExistenceChecker.isSet((Integer) o.getBasketVersion()))
				.put("basketName", ExistenceChecker.isSet((BasketName) o.getBasketName()))
				.put("basketId", ExistenceChecker.isSet((List<? extends BasketId>) o.getBasketId()))
				.put("basketCurrency", ExistenceChecker.isSet((Currency) o.getBasketCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Basket", ValidationResult.ValidationType.ONLY_EXISTS, "Basket", path, "");
		}
		return failure("Basket", ValidationResult.ValidationType.ONLY_EXISTS, "Basket", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
