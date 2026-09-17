package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ScheduledDateBase;
import fpml.consolidated.shared.ScheduledDateType;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ScheduledDateBaseOnlyExistsValidator implements ValidatorWithArg<ScheduledDateBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ScheduledDateBase> ValidationResult<ScheduledDateBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unadjustedDate", ExistenceChecker.isSet((ZonedDateTime) o.getUnadjustedDate()))
				.put("adjustedDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdjustedDate()))
				.put("type", ExistenceChecker.isSet((ScheduledDateType) o._getType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ScheduledDateBase", ValidationResult.ValidationType.ONLY_EXISTS, "ScheduledDateBase", path, "");
		}
		return failure("ScheduledDateBase", ValidationResult.ValidationType.ONLY_EXISTS, "ScheduledDateBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
