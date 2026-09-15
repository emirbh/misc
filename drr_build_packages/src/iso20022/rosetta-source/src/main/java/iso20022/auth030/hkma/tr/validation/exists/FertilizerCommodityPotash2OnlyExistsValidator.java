package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassProductType5Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType41Code;
import iso20022.auth030.hkma.tr.FertilizerCommodityPotash2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FertilizerCommodityPotash2OnlyExistsValidator implements ValidatorWithArg<FertilizerCommodityPotash2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FertilizerCommodityPotash2> ValidationResult<FertilizerCommodityPotash2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType5Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType41Code) o.getSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FertilizerCommodityPotash2", ValidationResult.ValidationType.ONLY_EXISTS, "FertilizerCommodityPotash2", path, "");
		}
		return failure("FertilizerCommodityPotash2", ValidationResult.ValidationType.ONLY_EXISTS, "FertilizerCommodityPotash2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
