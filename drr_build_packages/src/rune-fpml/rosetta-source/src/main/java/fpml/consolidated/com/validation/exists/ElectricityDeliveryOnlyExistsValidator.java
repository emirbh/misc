package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.ElectricityDelivery;
import fpml.consolidated.com.ElectricityDeliveryPoint;
import fpml.consolidated.com.ElectricityDeliveryType;
import fpml.consolidated.com.ElectricityTransmissionContingency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityDeliveryOnlyExistsValidator implements ValidatorWithArg<ElectricityDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityDelivery> ValidationResult<ElectricityDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryPoint", ExistenceChecker.isSet((ElectricityDeliveryPoint) o.getDeliveryPoint()))
				.put("deliveryType", ExistenceChecker.isSet((ElectricityDeliveryType) o.getDeliveryType()))
				.put("transmissionContingency", ExistenceChecker.isSet((ElectricityTransmissionContingency) o.getTransmissionContingency()))
				.put("interconnectionPoint", ExistenceChecker.isSet((InterconnectionPoint) o.getInterconnectionPoint()))
				.put("deliveryZone", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getDeliveryZone()))
				.put("electingPartyReference", ExistenceChecker.isSet((PartyReference) o.getElectingPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "ElectricityDelivery", path, "");
		}
		return failure("ElectricityDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "ElectricityDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
