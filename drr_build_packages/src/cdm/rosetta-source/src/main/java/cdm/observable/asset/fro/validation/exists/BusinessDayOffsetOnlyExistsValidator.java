package cdm.observable.asset.fro.validation.exists;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.PeriodEnum;
import cdm.observable.asset.fro.BusinessDayOffset;
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

public class BusinessDayOffsetOnlyExistsValidator implements ValidatorWithArg<BusinessDayOffset, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BusinessDayOffset> ValidationResult<BusinessDayOffset> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodEnum) o.getPeriod()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.put("fixingOffsetDefinition", ExistenceChecker.isSet((String) o.getFixingOffsetDefinition()))
				.put("fixingOffsetReason", ExistenceChecker.isSet((String) o.getFixingOffsetReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BusinessDayOffset", ValidationResult.ValidationType.ONLY_EXISTS, "BusinessDayOffset", path, "");
		}
		return failure("BusinessDayOffset", ValidationResult.ValidationType.ONLY_EXISTS, "BusinessDayOffset", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
