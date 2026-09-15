package fpml.consolidated.accumulator.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.Gearing;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GearingOnlyExistsValidator implements ValidatorWithArg<Gearing, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Gearing> ValidationResult<Gearing> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("gearingFactor", ExistenceChecker.isSet((BigDecimal) o.getGearingFactor()))
				.put("leverageTriggerPrice", ExistenceChecker.isSet((BigDecimal) o.getLeverageTriggerPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Gearing", ValidationResult.ValidationType.ONLY_EXISTS, "Gearing", path, "");
		}
		return failure("Gearing", ValidationResult.ValidationType.ONLY_EXISTS, "Gearing", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
