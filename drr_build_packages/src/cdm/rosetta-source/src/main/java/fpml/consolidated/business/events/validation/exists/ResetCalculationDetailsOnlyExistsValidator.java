package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.Observation;
import fpml.consolidated.business.events.ResetCalculationDetails;
import fpml.consolidated.business.events.ResetCalculationElements;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ResetCalculationDetailsOnlyExistsValidator implements ValidatorWithArg<ResetCalculationDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ResetCalculationDetails> ValidationResult<ResetCalculationDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observation", ExistenceChecker.isSet((List<? extends Observation>) o.getObservation()))
				.put("calculationElements", ExistenceChecker.isSet((ResetCalculationElements) o.getCalculationElements()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetCalculationDetails", ValidationResult.ValidationType.ONLY_EXISTS, "ResetCalculationDetails", path, "");
		}
		return failure("ResetCalculationDetails", ValidationResult.ValidationType.ONLY_EXISTS, "ResetCalculationDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
