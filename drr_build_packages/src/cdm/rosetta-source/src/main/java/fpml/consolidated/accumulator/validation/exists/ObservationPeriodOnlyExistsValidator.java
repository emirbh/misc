package fpml.consolidated.accumulator.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.ObservationPeriod;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObservationPeriodOnlyExistsValidator implements ValidatorWithArg<ObservationPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ObservationPeriod> ValidationResult<ObservationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationPeriodStartDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationPeriodStartDate()))
				.put("observationPeriodEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationPeriodEndDate()))
				.put("observationPeriodSettlementDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationPeriodSettlementDate()))
				.put("observationPeriodNoOfTradingDays", ExistenceChecker.isSet((Integer) o.getObservationPeriodNoOfTradingDays()))
				.put("upFrontSettlement", ExistenceChecker.isSet((Boolean) o.getUpFrontSettlement()))
				.put("noOfScheduledTradingDays", ExistenceChecker.isSet((Integer) o.getNoOfScheduledTradingDays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ObservationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationPeriod", path, "");
		}
		return failure("ObservationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
