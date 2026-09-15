package fpml.consolidated.valuation.fpmlreporting.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyPortfolioName;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.shared.TradeId;
import fpml.consolidated.valuation.fpmlreporting.Portfolio;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioOnlyExistsValidator implements ValidatorWithArg<Portfolio, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Portfolio> ValidationResult<Portfolio> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("partyPortfolioName", ExistenceChecker.isSet((PartyPortfolioName) o.getPartyPortfolioName()))
				.put("tradeId", ExistenceChecker.isSet((List<? extends TradeId>) o.getTradeId()))
				.put("partyTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()))
				.put("portfolio", ExistenceChecker.isSet((List<? extends Portfolio>) o.getPortfolio()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Portfolio", ValidationResult.ValidationType.ONLY_EXISTS, "Portfolio", path, "");
		}
		return failure("Portfolio", ValidationResult.ValidationType.ONLY_EXISTS, "Portfolio", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
