package fpml.consolidated.valuation.fpmlreporting.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.valuation.ValuationSet;
import fpml.consolidated.valuation.fpmlreporting.TradeValuationItem;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeValuationItemOnlyExistsValidator implements ValidatorWithArg<TradeValuationItem, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeValuationItem> ValidationResult<TradeValuationItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("valuationSet", ExistenceChecker.isSet((ValuationSet) o.getValuationSet()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeValuationItem", ValidationResult.ValidationType.ONLY_EXISTS, "TradeValuationItem", path, "");
		}
		return failure("TradeValuationItem", ValidationResult.ValidationType.ONLY_EXISTS, "TradeValuationItem", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
