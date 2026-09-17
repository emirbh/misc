package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.CommodityHub;
import fpml.consolidated.com.GasDelivery;
import fpml.consolidated.com.GasDeliveryPoint;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.DeliveryTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasDeliveryOnlyExistsValidator implements ValidatorWithArg<GasDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasDelivery> ValidationResult<GasDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryPoint", ExistenceChecker.isSet((GasDeliveryPoint) o.getDeliveryPoint()))
				.put("entryPoint", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getEntryPoint()))
				.put("withdrawalPoint", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getWithdrawalPoint()))
				.put("deliveryType", ExistenceChecker.isSet((DeliveryTypeEnum) o.getDeliveryType()))
				.put("interconnectionPoint", ExistenceChecker.isSet((InterconnectionPoint) o.getInterconnectionPoint()))
				.put("buyerHub", ExistenceChecker.isSet((CommodityHub) o.getBuyerHub()))
				.put("sellerHub", ExistenceChecker.isSet((CommodityHub) o.getSellerHub()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "GasDelivery", path, "");
		}
		return failure("GasDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "GasDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
