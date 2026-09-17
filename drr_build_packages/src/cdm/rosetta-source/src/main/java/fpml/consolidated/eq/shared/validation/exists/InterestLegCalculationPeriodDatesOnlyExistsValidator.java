package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDates;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestLegCalculationPeriodDatesOnlyExistsValidator implements ValidatorWithArg<InterestLegCalculationPeriodDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestLegCalculationPeriodDates> ValidationResult<InterestLegCalculationPeriodDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("interestLegResetDates", ExistenceChecker.isSet((InterestLegResetDates) o.getInterestLegResetDates()))
				.put("interestLegPaymentDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates2) o.getInterestLegPaymentDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestLegCalculationPeriodDates", ValidationResult.ValidationType.ONLY_EXISTS, "InterestLegCalculationPeriodDates", path, "");
		}
		return failure("InterestLegCalculationPeriodDates", ValidationResult.ValidationType.ONLY_EXISTS, "InterestLegCalculationPeriodDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
