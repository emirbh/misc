package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.Observation;
import fpml.consolidated.business.events.ObservationReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObservationOnlyExistsValidator implements ValidatorWithArg<Observation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Observation> ValidationResult<Observation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationReference", ExistenceChecker.isSet((ObservationReference) o.getObservationReference()))
				.put("weight", ExistenceChecker.isSet((BigDecimal) o.getWeight()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Observation", ValidationResult.ValidationType.ONLY_EXISTS, "Observation", path, "");
		}
		return failure("Observation", ValidationResult.ValidationType.ONLY_EXISTS, "Observation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
