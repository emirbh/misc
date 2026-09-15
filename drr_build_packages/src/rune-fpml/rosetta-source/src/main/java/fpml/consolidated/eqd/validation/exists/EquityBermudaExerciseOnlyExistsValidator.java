package fpml.consolidated.eqd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.eqd.EquityMultipleExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DateList;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityBermudaExerciseOnlyExistsValidator implements ValidatorWithArg<EquityBermudaExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityBermudaExercise> ValidationResult<EquityBermudaExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCommencementDate()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getExpirationDate()))
				.put("latestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExerciseTime()))
				.put("latestExerciseTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getLatestExerciseTimeDetermination()))
				.put("bermudaExerciseDates", ExistenceChecker.isSet((DateList) o.getBermudaExerciseDates()))
				.put("latestExerciseTimeType", ExistenceChecker.isSet((TimeTypeEnum) o.getLatestExerciseTimeType()))
				.put("equityExpirationTimeType", ExistenceChecker.isSet((TimeTypeEnum) o.getEquityExpirationTimeType()))
				.put("equityExpirationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getEquityExpirationTime()))
				.put("expirationTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getExpirationTimeDetermination()))
				.put("equityMultipleExercise", ExistenceChecker.isSet((EquityMultipleExercise) o.getEquityMultipleExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityBermudaExercise", ValidationResult.ValidationType.ONLY_EXISTS, "EquityBermudaExercise", path, "");
		}
		return failure("EquityBermudaExercise", ValidationResult.ValidationType.ONLY_EXISTS, "EquityBermudaExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
