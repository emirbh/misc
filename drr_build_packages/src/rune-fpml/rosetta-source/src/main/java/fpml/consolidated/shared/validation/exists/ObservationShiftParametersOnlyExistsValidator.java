package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.ObservationPeriodDatesEnum;
import fpml.consolidated.shared.BusinessCentersOrReference;
import fpml.consolidated.shared.ObservationShiftParameters;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObservationShiftParametersOnlyExistsValidator implements ValidatorWithArg<ObservationShiftParameters, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ObservationShiftParameters> ValidationResult<ObservationShiftParameters> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("offsetDays", ExistenceChecker.isSet((Integer) o.getOffsetDays()))
				.put("observationPeriodDates", ExistenceChecker.isSet((ObservationPeriodDatesEnum) o.getObservationPeriodDates()))
				.put("additionalBusinessDays", ExistenceChecker.isSet((BusinessCentersOrReference) o.getAdditionalBusinessDays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ObservationShiftParameters", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationShiftParameters", path, "");
		}
		return failure("ObservationShiftParameters", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationShiftParameters", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
