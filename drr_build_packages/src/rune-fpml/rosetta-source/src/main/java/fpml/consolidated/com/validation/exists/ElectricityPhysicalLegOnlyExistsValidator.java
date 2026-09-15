package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.com.ElectricityDelivery;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.com.ElectricityPhysicalQuantity;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.com.SettlementPeriodsSchedule;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityPhysicalLegOnlyExistsValidator implements ValidatorWithArg<ElectricityPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityPhysicalLeg> ValidationResult<ElectricityPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commodityClassification", ExistenceChecker.isSet((List<? extends CommodityClassification>) o.getCommodityClassification()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("deliveryPeriods", ExistenceChecker.isSet((CommodityDeliveryPeriods) o.getDeliveryPeriods()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends SettlementPeriods>) o.getSettlementPeriods()))
				.put("settlementPeriodsSchedule", ExistenceChecker.isSet((SettlementPeriodsSchedule) o.getSettlementPeriodsSchedule()))
				.put("loadType", ExistenceChecker.isSet((LoadTypeEnum) o.getLoadType()))
				.put("electricity", ExistenceChecker.isSet((ElectricityProduct) o.getElectricity()))
				.put("deliveryConditions", ExistenceChecker.isSet((ElectricityDelivery) o.getDeliveryConditions()))
				.put("deliveryQuantity", ExistenceChecker.isSet((ElectricityPhysicalQuantity) o.getDeliveryQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "ElectricityPhysicalLeg", path, "");
		}
		return failure("ElectricityPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "ElectricityPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
