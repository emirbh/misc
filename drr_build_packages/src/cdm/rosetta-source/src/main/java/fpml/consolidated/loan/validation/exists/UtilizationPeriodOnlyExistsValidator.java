package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.UtilizationAmounts;
import fpml.consolidated.loan.UtilizationPeriod;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UtilizationPeriodOnlyExistsValidator implements ValidatorWithArg<UtilizationPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UtilizationPeriod> ValidationResult<UtilizationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("numberOfDays", ExistenceChecker.isSet((Integer) o.getNumberOfDays()))
				.put("utilizationAmounts", ExistenceChecker.isSet((UtilizationAmounts) o.getUtilizationAmounts()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UtilizationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "UtilizationPeriod", path, "");
		}
		return failure("UtilizationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "UtilizationPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
