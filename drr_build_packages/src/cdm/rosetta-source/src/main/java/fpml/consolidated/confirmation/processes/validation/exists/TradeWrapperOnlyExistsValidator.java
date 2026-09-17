package fpml.consolidated.confirmation.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.confirmation.processes.TradeWrapper;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeWrapperOnlyExistsValidator implements ValidatorWithArg<TradeWrapper, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeWrapper> ValidationResult<TradeWrapper> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("tradeReferenceInformation", ExistenceChecker.isSet((TradeReferenceInformation) o.getTradeReferenceInformation()))
				.put("tradePackage", ExistenceChecker.isSet((TradePackage) o.getTradePackage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeWrapper", ValidationResult.ValidationType.ONLY_EXISTS, "TradeWrapper", path, "");
		}
		return failure("TradeWrapper", ValidationResult.ValidationType.ONLY_EXISTS, "TradeWrapper", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
