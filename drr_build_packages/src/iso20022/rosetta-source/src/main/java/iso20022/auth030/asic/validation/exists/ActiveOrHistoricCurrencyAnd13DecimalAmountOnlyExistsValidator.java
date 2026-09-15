package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ActiveOrHistoricCurrencyAnd13DecimalAmountOnlyExistsValidator implements ValidatorWithArg<ActiveOrHistoricCurrencyAnd13DecimalAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ActiveOrHistoricCurrencyAnd13DecimalAmount> ValidationResult<ActiveOrHistoricCurrencyAnd13DecimalAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
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
			return success("ActiveOrHistoricCurrencyAnd13DecimalAmount", ValidationResult.ValidationType.ONLY_EXISTS, "ActiveOrHistoricCurrencyAnd13DecimalAmount", path, "");
		}
		return failure("ActiveOrHistoricCurrencyAnd13DecimalAmount", ValidationResult.ValidationType.ONLY_EXISTS, "ActiveOrHistoricCurrencyAnd13DecimalAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
