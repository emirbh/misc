package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.GasDeliveryPeriods;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.PrevailingTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasDeliveryPeriodsOnlyExistsValidator implements ValidatorWithArg<GasDeliveryPeriods, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasDeliveryPeriods> ValidationResult<GasDeliveryPeriods> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("periods", ExistenceChecker.isSet((AdjustableDates) o.getPeriods()))
				.put("periodsSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getPeriodsSchedule()))
				.put("calculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getCalculationPeriodsReference()))
				.put("calculationPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference()))
				.put("calculationPeriodsDatesReference", ExistenceChecker.isSet((CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference()))
				.put("supplyStartTime", ExistenceChecker.isSet((PrevailingTime) o.getSupplyStartTime()))
				.put("supplyEndTime", ExistenceChecker.isSet((PrevailingTime) o.getSupplyEndTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasDeliveryPeriods", ValidationResult.ValidationType.ONLY_EXISTS, "GasDeliveryPeriods", path, "");
		}
		return failure("GasDeliveryPeriods", ValidationResult.ValidationType.ONLY_EXISTS, "GasDeliveryPeriods", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
