package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.cd.FloatingAmountCalculation;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.DayCountFraction;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingAmountCalculationOnlyExistsValidator implements ValidatorWithArg<FloatingAmountCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingAmountCalculation> ValidationResult<FloatingAmountCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationAmount", ExistenceChecker.isSet((CalculationAmount) o.getCalculationAmount()))
				.put("floatingRate", ExistenceChecker.isSet((FloatingRateCalculation) o.getFloatingRate()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("initialFixingDate", ExistenceChecker.isSet((ZonedDateTime) o.getInitialFixingDate()))
				.put("finalFixingDate", ExistenceChecker.isSet((AdjustableDate) o.getFinalFixingDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingAmountCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingAmountCalculation", path, "");
		}
		return failure("FloatingAmountCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingAmountCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
