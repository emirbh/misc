package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityExercisePeriods;
import fpml.consolidated.com.CommodityMultipleExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.Frequency;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityAmericanExercise> ValidationResult<CommodityAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("exercisePeriod", ExistenceChecker.isSet((List<? extends CommodityExercisePeriods>) o.getExercisePeriod()))
				.put("exerciseFrequency", ExistenceChecker.isSet((Frequency) o.getExerciseFrequency()))
				.put("latestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExerciseTime()))
				.put("latestExerciseTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getLatestExerciseTimeDetermination()))
				.put("expirationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpirationTime()))
				.put("multipleExercise", ExistenceChecker.isSet((CommodityMultipleExercise) o.getMultipleExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityAmericanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityAmericanExercise", path, "");
		}
		return failure("CommodityAmericanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
