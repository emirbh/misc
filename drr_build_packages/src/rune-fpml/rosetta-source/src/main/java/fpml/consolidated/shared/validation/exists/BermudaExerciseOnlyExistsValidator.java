package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.BermudaExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.ExerciseFeeSchedule;
import fpml.consolidated.shared.MultipleExercise;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BermudaExerciseOnlyExistsValidator implements ValidatorWithArg<BermudaExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BermudaExercise> ValidationResult<BermudaExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("bermudaExerciseDates", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getBermudaExerciseDates()))
				.put("relevantUnderlyingDate", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getRelevantUnderlyingDate()))
				.put("earliestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getEarliestExerciseTime()))
				.put("latestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExerciseTime()))
				.put("expirationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpirationTime()))
				.put("multipleExercise", ExistenceChecker.isSet((MultipleExercise) o.getMultipleExercise()))
				.put("exerciseFeeSchedule", ExistenceChecker.isSet((ExerciseFeeSchedule) o.getExerciseFeeSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BermudaExercise", ValidationResult.ValidationType.ONLY_EXISTS, "BermudaExercise", path, "");
		}
		return failure("BermudaExercise", ValidationResult.ValidationType.ONLY_EXISTS, "BermudaExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
