package cdm.observable.asset.fro.validation.exists;

import cdm.observable.asset.fro.BusinessDayOffset;
import cdm.observable.asset.fro.FloatingRateIndexFixingDetails;
import cdm.observable.asset.fro.FloatingRateIndexFixingTime;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateIndexFixingDetailsOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexFixingDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexFixingDetails> ValidationResult<FloatingRateIndexFixingDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixingTime", ExistenceChecker.isSet((FloatingRateIndexFixingTime) o.getFixingTime()))
				.put("fixingOffset", ExistenceChecker.isSet((BusinessDayOffset) o.getFixingOffset()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexFixingDetails", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexFixingDetails", path, "");
		}
		return failure("FloatingRateIndexFixingDetails", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexFixingDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
