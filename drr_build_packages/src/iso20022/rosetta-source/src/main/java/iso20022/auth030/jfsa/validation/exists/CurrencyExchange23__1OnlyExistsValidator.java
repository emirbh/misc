package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.CurrencyExchange23__1;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CurrencyExchange23__1OnlyExistsValidator implements ValidatorWithArg<CurrencyExchange23__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CurrencyExchange23__1> ValidationResult<CurrencyExchange23__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ccy", ExistenceChecker.isSet((String) o.getCcy()))
				.put("fxgDt", ExistenceChecker.isSet((ZonedDateTime) o.getFxgDt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CurrencyExchange23__1", ValidationResult.ValidationType.ONLY_EXISTS, "CurrencyExchange23__1", path, "");
		}
		return failure("CurrencyExchange23__1", ValidationResult.ValidationType.ONLY_EXISTS, "CurrencyExchange23__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
