package fpml.consolidated.credit.event.notification.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.AffectedTransactionsChoice;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import fpml.consolidated.doc.Trade;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AffectedTransactionsChoiceOnlyExistsValidator implements ValidatorWithArg<AffectedTransactionsChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AffectedTransactionsChoice> ValidationResult<AffectedTransactionsChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("tradeReference", ExistenceChecker.isSet((PartyTradeIdentifiers) o.getTradeReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AffectedTransactionsChoice", ValidationResult.ValidationType.ONLY_EXISTS, "AffectedTransactionsChoice", path, "");
		}
		return failure("AffectedTransactionsChoice", ValidationResult.ValidationType.ONLY_EXISTS, "AffectedTransactionsChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
