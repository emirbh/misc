package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.cd.FixedAmountCalculation;
import fpml.consolidated.cd.FixedRate;
import fpml.consolidated.shared.DayCountFraction;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedAmountCalculationOnlyExistsValidator implements ValidatorWithArg<FixedAmountCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedAmountCalculation> ValidationResult<FixedAmountCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationAmount", ExistenceChecker.isSet((CalculationAmount) o.getCalculationAmount()))
				.put("fixedRate", ExistenceChecker.isSet((FixedRate) o.getFixedRate()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedAmountCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "FixedAmountCalculation", path, "");
		}
		return failure("FixedAmountCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "FixedAmountCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
