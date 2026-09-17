package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ChangeEvent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Payment;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeChangeContentOnlyExistsValidator implements ValidatorWithArg<TradeChangeContent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeChangeContent> ValidationResult<TradeChangeContent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("oldTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getOldTradeIdentifier()))
				.put("oldTrade", ExistenceChecker.isSet((Trade) o.getOldTrade()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("changeEvent", ExistenceChecker.isSet((ChangeEvent) o.getChangeEvent()))
				.put("payment", ExistenceChecker.isSet((List<? extends Payment>) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeChangeContent", ValidationResult.ValidationType.ONLY_EXISTS, "TradeChangeContent", path, "");
		}
		return failure("TradeChangeContent", ValidationResult.ValidationType.ONLY_EXISTS, "TradeChangeContent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
