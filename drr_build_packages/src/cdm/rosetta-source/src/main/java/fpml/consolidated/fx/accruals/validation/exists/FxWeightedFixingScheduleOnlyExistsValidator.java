package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.accruals.FxFixingObservation;
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
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

public class FxWeightedFixingScheduleOnlyExistsValidator implements ValidatorWithArg<FxWeightedFixingSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxWeightedFixingSchedule> ValidationResult<FxWeightedFixingSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("fixing", ExistenceChecker.isSet((List<? extends FxFixingObservation>) o.getFixing()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("observationFrequency", ExistenceChecker.isSet((ObservationFrequency) o.getObservationFrequency()))
				.put("dayType", ExistenceChecker.isSet((DayTypeEnum) o.getDayType()))
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.put("numberOfFixings", ExistenceChecker.isSet((Integer) o.getNumberOfFixings()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxWeightedFixingSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "FxWeightedFixingSchedule", path, "");
		}
		return failure("FxWeightedFixingSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "FxWeightedFixingSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
