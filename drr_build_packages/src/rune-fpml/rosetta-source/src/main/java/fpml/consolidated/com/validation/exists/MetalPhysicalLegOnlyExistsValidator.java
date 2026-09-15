package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.Metal;
import fpml.consolidated.com.MetalDelivery;
import fpml.consolidated.com.MetalPhysicalLeg;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MetalPhysicalLegOnlyExistsValidator implements ValidatorWithArg<MetalPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MetalPhysicalLeg> ValidationResult<MetalPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commodityClassification", ExistenceChecker.isSet((List<? extends CommodityClassification>) o.getCommodityClassification()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("metal", ExistenceChecker.isSet((Metal) o.getMetal()))
				.put("deliveryPeriods", ExistenceChecker.isSet((CommodityDeliveryPeriods) o.getDeliveryPeriods()))
				.put("deliveryConditions", ExistenceChecker.isSet((MetalDelivery) o.getDeliveryConditions()))
				.put("physicalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getPhysicalQuantity()))
				.put("physicalQuantitySchedule", ExistenceChecker.isSet((CommodityPhysicalQuantitySchedule) o.getPhysicalQuantitySchedule()))
				.put("totalPhysicalQuantity", ExistenceChecker.isSet((UnitQuantity) o.getTotalPhysicalQuantity()))
				.put("conversionFactor", ExistenceChecker.isSet((BigDecimal) o.getConversionFactor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MetalPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "MetalPhysicalLeg", path, "");
		}
		return failure("MetalPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "MetalPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
