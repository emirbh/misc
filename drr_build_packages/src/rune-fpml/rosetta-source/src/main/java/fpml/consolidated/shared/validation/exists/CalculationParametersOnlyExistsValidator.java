package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.CalculationMethodEnum;
import fpml.consolidated.shared.BusinessCentersOrReference;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.ObservationOffset;
import fpml.consolidated.shared.ObservationShiftParameters;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationParametersOnlyExistsValidator implements ValidatorWithArg<CalculationParameters, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationParameters> ValidationResult<CalculationParameters> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationMethod", ExistenceChecker.isSet((CalculationMethodEnum) o.getCalculationMethod()))
				.put("applicableBusinessDays", ExistenceChecker.isSet((BusinessCentersOrReference) o.getApplicableBusinessDays()))
				.put("lookback", ExistenceChecker.isSet((ObservationOffset) o.getLookback()))
				.put("observationShift", ExistenceChecker.isSet((ObservationShiftParameters) o.getObservationShift()))
				.put("lockout", ExistenceChecker.isSet((ObservationOffset) o.getLockout()))
				.put("observationCapRate", ExistenceChecker.isSet((BigDecimal) o.getObservationCapRate()))
				.put("observationFloorRate", ExistenceChecker.isSet((BigDecimal) o.getObservationFloorRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationParameters", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationParameters", path, "");
		}
		return failure("CalculationParameters", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationParameters", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
