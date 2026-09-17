package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.StubPeriodTypeEnum;
import fpml.consolidated.ird.CalculationPeriodDates;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationPeriodDatesOnlyExistsValidator implements ValidatorWithArg<CalculationPeriodDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationPeriodDates> ValidationResult<CalculationPeriodDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableDate) o.getEffectiveDate()))
				.put("relativeEffectiveDate", ExistenceChecker.isSet((AdjustedRelativeDateOffset) o.getRelativeEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableDate) o.getTerminationDate()))
				.put("relativeTerminationDate", ExistenceChecker.isSet((RelativeDateOffset) o.getRelativeTerminationDate()))
				.put("calculationPeriodDatesAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments()))
				.put("firstPeriodStartDate", ExistenceChecker.isSet((AdjustableDate) o.getFirstPeriodStartDate()))
				.put("firstRegularPeriodStartDate", ExistenceChecker.isSet((ZonedDateTime) o.getFirstRegularPeriodStartDate()))
				.put("firstCompoundingPeriodEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getFirstCompoundingPeriodEndDate()))
				.put("lastRegularPeriodEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getLastRegularPeriodEndDate()))
				.put("stubPeriodType", ExistenceChecker.isSet((StubPeriodTypeEnum) o.getStubPeriodType()))
				.put("calculationPeriodFrequency", ExistenceChecker.isSet((CalculationPeriodFrequency) o.getCalculationPeriodFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationPeriodDates", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationPeriodDates", path, "");
		}
		return failure("CalculationPeriodDates", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationPeriodDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
