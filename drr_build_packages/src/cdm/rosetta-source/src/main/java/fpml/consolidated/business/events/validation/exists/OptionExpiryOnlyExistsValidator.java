package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ActionOnExpiration;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.ExerciseProcedureOption;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExpiryOnlyExistsValidator implements ValidatorWithArg<OptionExpiry, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExpiry> ValidationResult<OptionExpiry> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("originalTrade", ExistenceChecker.isSet((Trade) o.getOriginalTrade()))
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()))
				.put("date", ExistenceChecker.isSet((ZonedDateTime) o.getDate()))
				.put("time", ExistenceChecker.isSet((LocalTime) o.getTime()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedureOption) o.getExerciseProcedure()))
				.put("actionOnExpiration", ExistenceChecker.isSet((ActionOnExpiration) o.getActionOnExpiration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExpiry", ValidationResult.ValidationType.ONLY_EXISTS, "OptionExpiry", path, "");
		}
		return failure("OptionExpiry", ValidationResult.ValidationType.ONLY_EXISTS, "OptionExpiry", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
