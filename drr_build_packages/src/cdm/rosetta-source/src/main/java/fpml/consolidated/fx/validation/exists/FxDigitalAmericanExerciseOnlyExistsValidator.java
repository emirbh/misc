package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.CutName;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxDigitalAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<FxDigitalAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDigitalAmericanExercise> ValidationResult<FxDigitalAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCommencementDate()))
				.put("expiryDate", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryDate()))
				.put("expiryTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpiryTime()))
				.put("cutName", ExistenceChecker.isSet((CutName) o.getCutName()))
				.put("latestValueDate", ExistenceChecker.isSet((ZonedDateTime) o.getLatestValueDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDigitalAmericanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "FxDigitalAmericanExercise", path, "");
		}
		return failure("FxDigitalAmericanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "FxDigitalAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
