package cdm.observable.asset.fro.validation.exists;

import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.observable.asset.fro.FloatingRateIndexFixingTime;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateIndexFixingTimeOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexFixingTime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexFixingTime> ValidationResult<FloatingRateIndexFixingTime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("hourMinuteTime", ExistenceChecker.isSet((LocalTime) o.getHourMinuteTime()))
				.put("businessCenter", ExistenceChecker.isSet((FieldWithMetaBusinessCenterEnum) o.getBusinessCenter()))
				.put("designatedMaturity", ExistenceChecker.isSet((String) o.getDesignatedMaturity()))
				.put("fixingTimeDefinition", ExistenceChecker.isSet((String) o.getFixingTimeDefinition()))
				.put("fixingReason", ExistenceChecker.isSet((String) o.getFixingReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexFixingTime", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexFixingTime", path, "");
		}
		return failure("FloatingRateIndexFixingTime", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexFixingTime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
