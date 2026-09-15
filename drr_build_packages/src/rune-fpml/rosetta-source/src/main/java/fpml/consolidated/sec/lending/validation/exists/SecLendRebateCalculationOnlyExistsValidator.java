package fpml.consolidated.sec.lending.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecLendRebateCalculationOnlyExistsValidator implements ValidatorWithArg<SecLendRebateCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecLendRebateCalculation> ValidationResult<SecLendRebateCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateSchedule", ExistenceChecker.isSet((Schedule) o.getFixedRateSchedule()))
				.put("floatingRateCalculation", ExistenceChecker.isSet((FloatingRateCalculation) o.getFloatingRateCalculation()))
				.put("resetFrequency", ExistenceChecker.isSet((Frequency) o.getResetFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecLendRebateCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendRebateCalculation", path, "");
		}
		return failure("SecLendRebateCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendRebateCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
