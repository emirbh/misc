package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustedRelativeDateOffsetOnlyExistsValidator implements ValidatorWithArg<AdjustedRelativeDateOffset, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustedRelativeDateOffset> ValidationResult<AdjustedRelativeDateOffset> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodEnum) o.getPeriod()))
				.put("dayType", ExistenceChecker.isSet((DayTypeEnum) o.getDayType()))
				.put("businessDayConvention", ExistenceChecker.isSet((BusinessDayConventionEnum) o.getBusinessDayConvention()))
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.put("dateRelativeTo", ExistenceChecker.isSet((DateReference) o.getDateRelativeTo()))
				.put("adjustedDate", ExistenceChecker.isSet((IdentifiedDate) o.getAdjustedDate()))
				.put("relativeDateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getRelativeDateAdjustments()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustedRelativeDateOffset", ValidationResult.ValidationType.ONLY_EXISTS, "AdjustedRelativeDateOffset", path, "");
		}
		return failure("AdjustedRelativeDateOffset", ValidationResult.ValidationType.ONLY_EXISTS, "AdjustedRelativeDateOffset", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
