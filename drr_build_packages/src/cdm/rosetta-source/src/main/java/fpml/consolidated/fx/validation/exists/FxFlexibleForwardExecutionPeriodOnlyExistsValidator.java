package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFlexibleForwardExecutionPeriod;
import fpml.consolidated.shared.BusinessCenters;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFlexibleForwardExecutionPeriodOnlyExistsValidator implements ValidatorWithArg<FxFlexibleForwardExecutionPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFlexibleForwardExecutionPeriod> ValidationResult<FxFlexibleForwardExecutionPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("expiryDate", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryDate()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFlexibleForwardExecutionPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "FxFlexibleForwardExecutionPeriod", path, "");
		}
		return failure("FxFlexibleForwardExecutionPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "FxFlexibleForwardExecutionPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
