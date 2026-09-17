package fpml.consolidated.valuation.fpmlreporting.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.ValuationSet;
import fpml.consolidated.valuation.fpmlreporting.Portfolio;
import fpml.consolidated.valuation.fpmlreporting.PortfolioValuationItem;
import fpml.consolidated.valuation.fpmlreporting.TradeValuationItem;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioValuationItemOnlyExistsValidator implements ValidatorWithArg<PortfolioValuationItem, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PortfolioValuationItem> ValidationResult<PortfolioValuationItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("portfolio", ExistenceChecker.isSet((Portfolio) o.getPortfolio()))
				.put("tradeValuationItem", ExistenceChecker.isSet((List<? extends TradeValuationItem>) o.getTradeValuationItem()))
				.put("valuationSet", ExistenceChecker.isSet((ValuationSet) o.getValuationSet()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PortfolioValuationItem", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioValuationItem", path, "");
		}
		return failure("PortfolioValuationItem", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioValuationItem", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
