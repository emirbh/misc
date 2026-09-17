package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.CommodityRelativeExpirationDates;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.PrevailingTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalAmericanExercise> ValidationResult<CommodityPhysicalAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commencementDates", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getCommencementDates()))
				.put("expirationDates", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getExpirationDates()))
				.put("relativeCommencementDates", ExistenceChecker.isSet((CommodityRelativeExpirationDates) o.getRelativeCommencementDates()))
				.put("relativeExpirationDates", ExistenceChecker.isSet((CommodityRelativeExpirationDates) o.getRelativeExpirationDates()))
				.put("latestExerciseTime", ExistenceChecker.isSet((PrevailingTime) o.getLatestExerciseTime()))
				.put("expirationTime", ExistenceChecker.isSet((PrevailingTime) o.getExpirationTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalAmericanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExercise", path, "");
		}
		return failure("CommodityPhysicalAmericanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
