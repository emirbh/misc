package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.GasDelivery;
import fpml.consolidated.com.GasDeliveryPeriods;
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.com.GasPhysicalQuantity;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasPhysicalLegOnlyExistsValidator implements ValidatorWithArg<GasPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasPhysicalLeg> ValidationResult<GasPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commodityClassification", ExistenceChecker.isSet((List<? extends CommodityClassification>) o.getCommodityClassification()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("deliveryPeriods", ExistenceChecker.isSet((GasDeliveryPeriods) o.getDeliveryPeriods()))
				.put("gas", ExistenceChecker.isSet((GasProduct) o.getGas()))
				.put("deliveryConditions", ExistenceChecker.isSet((GasDelivery) o.getDeliveryConditions()))
				.put("deliveryQuantity", ExistenceChecker.isSet((GasPhysicalQuantity) o.getDeliveryQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "GasPhysicalLeg", path, "");
		}
		return failure("GasPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "GasPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
