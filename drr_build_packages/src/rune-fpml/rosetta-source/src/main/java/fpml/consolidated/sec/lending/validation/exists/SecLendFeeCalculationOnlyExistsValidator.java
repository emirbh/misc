package fpml.consolidated.sec.lending.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.sec.lending.SecLendFeeCalculation;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecLendFeeCalculationOnlyExistsValidator implements ValidatorWithArg<SecLendFeeCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecLendFeeCalculation> ValidationResult<SecLendFeeCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateSchedule", ExistenceChecker.isSet((Schedule) o.getFixedRateSchedule()))
				.put("floatingRateCalculation", ExistenceChecker.isSet((FloatingRateCalculation) o.getFloatingRateCalculation()))
				.put("resetFrequency", ExistenceChecker.isSet((Frequency) o.getResetFrequency()))
				.put("minimumFee", ExistenceChecker.isSet((PositiveMoney) o.getMinimumFee()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecLendFeeCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendFeeCalculation", path, "");
		}
		return failure("SecLendFeeCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendFeeCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
