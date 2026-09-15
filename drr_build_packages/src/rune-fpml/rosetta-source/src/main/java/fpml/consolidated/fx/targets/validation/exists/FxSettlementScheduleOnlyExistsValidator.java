package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.targets.FxDateOffset;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxSettlementScheduleOnlyExistsValidator implements ValidatorWithArg<FxSettlementSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxSettlementSchedule> ValidationResult<FxSettlementSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("adjustedDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getAdjustedDate()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("observationFrequency", ExistenceChecker.isSet((ObservationFrequency) o.getObservationFrequency()))
				.put("dayType", ExistenceChecker.isSet((DayTypeEnum) o.getDayType()))
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.put("dateOffset", ExistenceChecker.isSet((FxDateOffset) o.getDateOffset()))
				.put("finalSettlementDate", ExistenceChecker.isSet((ZonedDateTime) o.getFinalSettlementDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxSettlementSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "FxSettlementSchedule", path, "");
		}
		return failure("FxSettlementSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "FxSettlementSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
