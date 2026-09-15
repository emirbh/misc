package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalQuantityScheduleOnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalQuantitySchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalQuantitySchedule> ValidationResult<CommodityPhysicalQuantitySchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quantityStep", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getQuantityStep()))
				.put("deliveryPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getDeliveryPeriodsReference()))
				.put("deliveryPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getDeliveryPeriodsScheduleReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalQuantitySchedule", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPhysicalQuantitySchedule", path, "");
		}
		return failure("CommodityPhysicalQuantitySchedule", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPhysicalQuantitySchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
