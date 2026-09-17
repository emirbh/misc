package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.consolidated.com.SettlementPeriodsReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityPhysicalDeliveryQuantityScheduleOnlyExistsValidator implements ValidatorWithArg<ElectricityPhysicalDeliveryQuantitySchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityPhysicalDeliveryQuantitySchedule> ValidationResult<ElectricityPhysicalDeliveryQuantitySchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quantityStep", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getQuantityStep()))
				.put("deliveryPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getDeliveryPeriodsReference()))
				.put("deliveryPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getDeliveryPeriodsScheduleReference()))
				.put("settlementPeriodsReference", ExistenceChecker.isSet((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityPhysicalDeliveryQuantitySchedule", ValidationResult.ValidationType.ONLY_EXISTS, "ElectricityPhysicalDeliveryQuantitySchedule", path, "");
		}
		return failure("ElectricityPhysicalDeliveryQuantitySchedule", ValidationResult.ValidationType.ONLY_EXISTS, "ElectricityPhysicalDeliveryQuantitySchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
