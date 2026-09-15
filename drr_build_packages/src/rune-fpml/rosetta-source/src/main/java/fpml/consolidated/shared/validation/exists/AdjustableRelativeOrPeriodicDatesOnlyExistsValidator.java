package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.PeriodicDates;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustableRelativeOrPeriodicDatesOnlyExistsValidator implements ValidatorWithArg<AdjustableRelativeOrPeriodicDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustableRelativeOrPeriodicDates> ValidationResult<AdjustableRelativeOrPeriodicDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("adjustableDates", ExistenceChecker.isSet((AdjustableDates) o.getAdjustableDates()))
				.put("relativeDateSequence", ExistenceChecker.isSet((RelativeDateSequence) o.getRelativeDateSequence()))
				.put("periodicDates", ExistenceChecker.isSet((PeriodicDates) o.getPeriodicDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustableRelativeOrPeriodicDates", ValidationResult.ValidationType.ONLY_EXISTS, "AdjustableRelativeOrPeriodicDates", path, "");
		}
		return failure("AdjustableRelativeOrPeriodicDates", ValidationResult.ValidationType.ONLY_EXISTS, "AdjustableRelativeOrPeriodicDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
