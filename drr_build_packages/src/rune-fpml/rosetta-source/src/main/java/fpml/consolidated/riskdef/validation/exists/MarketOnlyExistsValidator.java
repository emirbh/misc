package fpml.consolidated.riskdef.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.riskdef.PricingMethod;
import fpml.consolidated.riskdef.PricingStructureValuation;
import fpml.consolidated.riskdef.QuotedAssetSet;
import fpml.consolidated.shared.PricingStructure;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarketOnlyExistsValidator implements ValidatorWithArg<Market, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Market> ValidationResult<Market> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("benchmarkQuotes", ExistenceChecker.isSet((QuotedAssetSet) o.getBenchmarkQuotes()))
				.put("pricingStructure", ExistenceChecker.isSet((List<? extends PricingStructure>) o.getPricingStructure()))
				.put("pricingStructureValuation", ExistenceChecker.isSet((List<? extends PricingStructureValuation>) o.getPricingStructureValuation()))
				.put("benchmarkPricingMethod", ExistenceChecker.isSet((List<? extends PricingMethod>) o.getBenchmarkPricingMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Market", ValidationResult.ValidationType.ONLY_EXISTS, "Market", path, "");
		}
		return failure("Market", ValidationResult.ValidationType.ONLY_EXISTS, "Market", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
