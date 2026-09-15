package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTerminationAdjustedDates;
import fpml.consolidated.ird.SinglePartyOption;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionalEarlyTerminationOnlyExistsValidator implements ValidatorWithArg<OptionalEarlyTermination, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionalEarlyTermination> ValidationResult<OptionalEarlyTermination> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("singlePartyOption", ExistenceChecker.isSet((SinglePartyOption) o.getSinglePartyOption()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseNotice", ExistenceChecker.isSet((List<? extends ExerciseNotice>) o.getExerciseNotice()))
				.put("followUpConfirmation", ExistenceChecker.isSet((Boolean) o.getFollowUpConfirmation()))
				.put("calculationAgent", ExistenceChecker.isSet((CalculationAgent) o.getCalculationAgent()))
				.put("cashSettlement", ExistenceChecker.isSet((CashSettlement) o.getCashSettlement()))
				.put("optionalEarlyTerminationAdjustedDates", ExistenceChecker.isSet((OptionalEarlyTerminationAdjustedDates) o.getOptionalEarlyTerminationAdjustedDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionalEarlyTermination", ValidationResult.ValidationType.ONLY_EXISTS, "OptionalEarlyTermination", path, "");
		}
		return failure("OptionalEarlyTermination", ValidationResult.ValidationType.ONLY_EXISTS, "OptionalEarlyTermination", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
