package fpml.consolidated.generic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.generic.GenericProductQuotedCurrencyPair;
import fpml.consolidated.shared.Currency;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericProductQuotedCurrencyPairOnlyExistsValidator implements ValidatorWithArg<GenericProductQuotedCurrencyPair, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericProductQuotedCurrencyPair> ValidationResult<GenericProductQuotedCurrencyPair> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency1", ExistenceChecker.isSet((Currency) o.getCurrency1()))
				.put("currency2", ExistenceChecker.isSet((Currency) o.getCurrency2()))
				.put("quoteBasis", ExistenceChecker.isSet((QuoteBasisEnum) o.getQuoteBasis()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericProductQuotedCurrencyPair", ValidationResult.ValidationType.ONLY_EXISTS, "GenericProductQuotedCurrencyPair", path, "");
		}
		return failure("GenericProductQuotedCurrencyPair", ValidationResult.ValidationType.ONLY_EXISTS, "GenericProductQuotedCurrencyPair", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
