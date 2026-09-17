package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExchangeTradedContractUnderlyerOnlyExistsValidator implements ValidatorWithArg<ExchangeTradedContractUnderlyer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExchangeTradedContractUnderlyer> ValidationResult<ExchangeTradedContractUnderlyer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingRateIndex", ExistenceChecker.isSet((FloatingRateIndex) o.getFloatingRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet((Period) o.getIndexTenor()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("underlyingAsset", ExistenceChecker.isSet((List<? extends Asset>) o.getUnderlyingAsset()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExchangeTradedContractUnderlyer", ValidationResult.ValidationType.ONLY_EXISTS, "ExchangeTradedContractUnderlyer", path, "");
		}
		return failure("ExchangeTradedContractUnderlyer", ValidationResult.ValidationType.ONLY_EXISTS, "ExchangeTradedContractUnderlyer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
