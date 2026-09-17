package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ResetCalculationPeriod;
import fpml.consolidated.shared.DayCountFraction;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ResetCalculationPeriodOnlyExistsValidator implements ValidatorWithArg<ResetCalculationPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ResetCalculationPeriod> ValidationResult<ResetCalculationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("adjustedStartDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdjustedStartDate()))
				.put("adjustedEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdjustedEndDate()))
				.put("numberOfDays", ExistenceChecker.isSet((Integer) o.getNumberOfDays()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("dayCountYearFraction", ExistenceChecker.isSet((BigDecimal) o.getDayCountYearFraction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetCalculationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "ResetCalculationPeriod", path, "");
		}
		return failure("ResetCalculationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "ResetCalculationPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
