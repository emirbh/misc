package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NonNegativeStep;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonNegativeStepOnlyExistsValidator implements ValidatorWithArg<NonNegativeStep, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonNegativeStep> ValidationResult<NonNegativeStep> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("stepDate", ExistenceChecker.isSet((ZonedDateTime) o.getStepDate()))
				.put("stepValue", ExistenceChecker.isSet((BigDecimal) o.getStepValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonNegativeStep", ValidationResult.ValidationType.ONLY_EXISTS, "NonNegativeStep", path, "");
		}
		return failure("NonNegativeStep", ValidationResult.ValidationType.ONLY_EXISTS, "NonNegativeStep", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
