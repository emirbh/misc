package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.GasPhysicalQuantity;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasPhysicalQuantityOnlyExistsValidator implements ValidatorWithArg<GasPhysicalQuantity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasPhysicalQuantity> ValidationResult<GasPhysicalQuantity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("physicalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getPhysicalQuantity()))
				.put("physicalQuantitySchedule", ExistenceChecker.isSet((CommodityPhysicalQuantitySchedule) o.getPhysicalQuantitySchedule()))
				.put("totalPhysicalQuantity", ExistenceChecker.isSet((UnitQuantity) o.getTotalPhysicalQuantity()))
				.put("minPhysicalQuantity", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getMinPhysicalQuantity()))
				.put("maxPhysicalQuantity", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getMaxPhysicalQuantity()))
				.put("electingParty", ExistenceChecker.isSet((PartyReference) o.getElectingParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasPhysicalQuantity", ValidationResult.ValidationType.ONLY_EXISTS, "GasPhysicalQuantity", path, "");
		}
		return failure("GasPhysicalQuantity", ValidationResult.ValidationType.ONLY_EXISTS, "GasPhysicalQuantity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
