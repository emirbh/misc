package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.Compounding;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.fpmlenum.InterpolationPeriodEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.InterpolationMethod;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestCalculationOnlyExistsValidator implements ValidatorWithArg<InterestCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestCalculation> ValidationResult<InterestCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingRateCalculation", ExistenceChecker.isSet((FloatingRateCalculation) o.getFloatingRateCalculation()))
				.put("fixedRate", ExistenceChecker.isSet((BigDecimal) o.getFixedRate()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("compounding", ExistenceChecker.isSet((Compounding) o.getCompounding()))
				.put("interpolationMethod", ExistenceChecker.isSet((InterpolationMethod) o.getInterpolationMethod()))
				.put("interpolationPeriod", ExistenceChecker.isSet((InterpolationPeriodEnum) o.getInterpolationPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "InterestCalculation", path, "");
		}
		return failure("InterestCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "InterestCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
