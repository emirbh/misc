package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AgriculturalCommodityLiveStock2;
import iso20022.auth030.hkma.tr.AssetClassProductType1Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType22Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AgriculturalCommodityLiveStock2OnlyExistsValidator implements ValidatorWithArg<AgriculturalCommodityLiveStock2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AgriculturalCommodityLiveStock2> ValidationResult<AgriculturalCommodityLiveStock2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType1Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType22Code) o.getSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgriculturalCommodityLiveStock2", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityLiveStock2", path, "");
		}
		return failure("AgriculturalCommodityLiveStock2", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityLiveStock2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
