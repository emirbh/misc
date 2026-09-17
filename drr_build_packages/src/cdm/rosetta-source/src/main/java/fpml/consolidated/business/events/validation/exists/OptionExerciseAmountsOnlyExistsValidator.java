package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.NumberOfOptionsReference;
import fpml.consolidated.shared.NumberOfUnitsReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountsOnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmounts, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmounts> ValidationResult<OptionExerciseAmounts> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalReference", ExistenceChecker.isSet((NotionalReference) o.getNotionalReference()))
				.put("exerciseInNotionalAmount", ExistenceChecker.isSet((Money) o.getExerciseInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((Money) o.getOutstandingNotionalAmount()))
				.put("notionalScheduleReference", ExistenceChecker.isSet((NotionalReference) o.getNotionalScheduleReference()))
				.put("exerciseInNotionalSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getExerciseInNotionalSchedule()))
				.put("outstandingNotionalSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule()))
				.put("numberOfOptionsReference", ExistenceChecker.isSet((NumberOfOptionsReference) o.getNumberOfOptionsReference()))
				.put("exerciseInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.put("numberOfUnitsReference", ExistenceChecker.isSet((NumberOfUnitsReference) o.getNumberOfUnitsReference()))
				.put("exerciseInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmounts", ValidationResult.ValidationType.ONLY_EXISTS, "OptionExerciseAmounts", path, "");
		}
		return failure("OptionExerciseAmounts", ValidationResult.ValidationType.ONLY_EXISTS, "OptionExerciseAmounts", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
