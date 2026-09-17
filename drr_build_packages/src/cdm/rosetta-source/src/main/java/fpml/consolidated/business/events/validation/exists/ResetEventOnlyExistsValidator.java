package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.ResetCalculationDetails;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.RequiredIdentifierDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ResetEventOnlyExistsValidator implements ValidatorWithArg<ResetEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ResetEvent> ValidationResult<ResetEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("tradeReference", ExistenceChecker.isSet((PartyTradeIdentifiers) o.getTradeReference()))
				.put("legIdentifier", ExistenceChecker.isSet((List<? extends LegIdentifier>) o.getLegIdentifier()))
				.put("date", ExistenceChecker.isSet((RequiredIdentifierDate) o.getDate()))
				.put("resetValue", ExistenceChecker.isSet((IdentifiedRate) o.getResetValue()))
				.put("calculationDetails", ExistenceChecker.isSet((ResetCalculationDetails) o.getCalculationDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetEvent", ValidationResult.ValidationType.ONLY_EXISTS, "ResetEvent", path, "");
		}
		return failure("ResetEvent", ValidationResult.ValidationType.ONLY_EXISTS, "ResetEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
