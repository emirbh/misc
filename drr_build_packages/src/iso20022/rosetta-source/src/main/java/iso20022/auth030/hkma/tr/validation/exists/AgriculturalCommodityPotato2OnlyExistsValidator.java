package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AgriculturalCommodityPotato2;
import iso20022.auth030.hkma.tr.AssetClassProductType1Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType45Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AgriculturalCommodityPotato2OnlyExistsValidator implements ValidatorWithArg<AgriculturalCommodityPotato2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AgriculturalCommodityPotato2> ValidationResult<AgriculturalCommodityPotato2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType1Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType45Code) o.getSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgriculturalCommodityPotato2", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityPotato2", path, "");
		}
		return failure("AgriculturalCommodityPotato2", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityPotato2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
