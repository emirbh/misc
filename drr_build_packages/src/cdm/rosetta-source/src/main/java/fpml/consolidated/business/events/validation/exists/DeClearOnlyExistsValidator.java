package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.DeclearReason;
import fpml.consolidated.doc.PartyTradeIdentifier;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DeClearOnlyExistsValidator implements ValidatorWithArg<DeClear, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DeClear> ValidationResult<DeClear> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("reason", ExistenceChecker.isSet((DeclearReason) o.getReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DeClear", ValidationResult.ValidationType.ONLY_EXISTS, "DeClear", path, "");
		}
		return failure("DeClear", ValidationResult.ValidationType.ONLY_EXISTS, "DeClear", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
