package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.fpmlenum.PriceExpressionEnum;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ActualPriceOnlyExistsValidator implements ValidatorWithArg<ActualPrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ActualPrice> ValidationResult<ActualPrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("priceExpression", ExistenceChecker.isSet((PriceExpressionEnum) o.getPriceExpression()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ActualPrice", ValidationResult.ValidationType.ONLY_EXISTS, "ActualPrice", path, "");
		}
		return failure("ActualPrice", ValidationResult.ValidationType.ONLY_EXISTS, "ActualPrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
