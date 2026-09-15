package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ActionOnExpiration;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.fpmlenum.ExerciseActionEnum;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ActionOnExpirationOnlyExistsValidator implements ValidatorWithArg<ActionOnExpiration, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ActionOnExpiration> ValidationResult<ActionOnExpiration> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exerciseAction", ExistenceChecker.isSet((ExerciseActionEnum) o.getExerciseAction()))
				.put("expiry", ExistenceChecker.isSet((Boolean) o.getExpiry()))
				.put("fullExercise", ExistenceChecker.isSet((Boolean) o.getFullExercise()))
				.put("exerciseInNotionalAmount", ExistenceChecker.isSet((Money) o.getExerciseInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((Money) o.getOutstandingNotionalAmount()))
				.put("exerciseInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.put("exerciseInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.put("specifiedExercise", ExistenceChecker.isSet((List<? extends OptionExerciseAmounts>) o.getSpecifiedExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ActionOnExpiration", ValidationResult.ValidationType.ONLY_EXISTS, "ActionOnExpiration", path, "");
		}
		return failure("ActionOnExpiration", ValidationResult.ValidationType.ONLY_EXISTS, "ActionOnExpiration", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
