package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd20Amount;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ActiveOrHistoricCurrencyAnd20AmountOnlyExistsValidator implements ValidatorWithArg<ActiveOrHistoricCurrencyAnd20Amount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ActiveOrHistoricCurrencyAnd20Amount> ValidationResult<ActiveOrHistoricCurrencyAnd20Amount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((BigDecimal) o.getValue()))
				.put("ccy", ExistenceChecker.isSet((String) o.getCcy()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ActiveOrHistoricCurrencyAnd20Amount", ValidationResult.ValidationType.ONLY_EXISTS, "ActiveOrHistoricCurrencyAnd20Amount", path, "");
		}
		return failure("ActiveOrHistoricCurrencyAnd20Amount", ValidationResult.ValidationType.ONLY_EXISTS, "ActiveOrHistoricCurrencyAnd20Amount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
