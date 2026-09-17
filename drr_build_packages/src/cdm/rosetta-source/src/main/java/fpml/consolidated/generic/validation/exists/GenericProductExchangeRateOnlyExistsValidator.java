package fpml.consolidated.generic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.CrossRate;
import fpml.consolidated.generic.GenericProductExchangeRate;
import fpml.consolidated.generic.GenericProductQuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericProductExchangeRateOnlyExistsValidator implements ValidatorWithArg<GenericProductExchangeRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericProductExchangeRate> ValidationResult<GenericProductExchangeRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quotedCurrencyPair", ExistenceChecker.isSet((GenericProductQuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("forwardPoints", ExistenceChecker.isSet((BigDecimal) o.getForwardPoints()))
				.put("pointValue", ExistenceChecker.isSet((BigDecimal) o.getPointValue()))
				.put("crossRate", ExistenceChecker.isSet((List<? extends CrossRate>) o.getCrossRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericProductExchangeRate", ValidationResult.ValidationType.ONLY_EXISTS, "GenericProductExchangeRate", path, "");
		}
		return failure("GenericProductExchangeRate", ValidationResult.ValidationType.ONLY_EXISTS, "GenericProductExchangeRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
