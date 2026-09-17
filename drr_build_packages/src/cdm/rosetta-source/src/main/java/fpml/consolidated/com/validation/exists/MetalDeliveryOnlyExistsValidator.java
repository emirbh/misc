package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.CommodityDeliveryRisk;
import fpml.consolidated.com.MetalDelivery;
import fpml.consolidated.fpmlenum.MetalTitleEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MetalDeliveryOnlyExistsValidator implements ValidatorWithArg<MetalDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MetalDelivery> ValidationResult<MetalDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryLocation", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getDeliveryLocation()))
				.put("risk", ExistenceChecker.isSet((CommodityDeliveryRisk) o.getRisk()))
				.put("totalQuantityTolerance", ExistenceChecker.isSet((BigDecimal) o.getTotalQuantityTolerance()))
				.put("periodQuantityTolerance", ExistenceChecker.isSet((BigDecimal) o.getPeriodQuantityTolerance()))
				.put("title", ExistenceChecker.isSet((MetalTitleEnum) o.getTitle()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MetalDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "MetalDelivery", path, "");
		}
		return failure("MetalDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "MetalDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
