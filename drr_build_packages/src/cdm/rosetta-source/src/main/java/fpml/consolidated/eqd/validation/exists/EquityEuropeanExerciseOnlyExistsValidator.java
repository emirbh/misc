package fpml.consolidated.eqd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityEuropeanExerciseOnlyExistsValidator implements ValidatorWithArg<EquityEuropeanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityEuropeanExercise> ValidationResult<EquityEuropeanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getExpirationDate()))
				.put("equityExpirationTimeType", ExistenceChecker.isSet((TimeTypeEnum) o.getEquityExpirationTimeType()))
				.put("equityExpirationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getEquityExpirationTime()))
				.put("expirationTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getExpirationTimeDetermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityEuropeanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "EquityEuropeanExercise", path, "");
		}
		return failure("EquityEuropeanExercise", ValidationResult.ValidationType.ONLY_EXISTS, "EquityEuropeanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
