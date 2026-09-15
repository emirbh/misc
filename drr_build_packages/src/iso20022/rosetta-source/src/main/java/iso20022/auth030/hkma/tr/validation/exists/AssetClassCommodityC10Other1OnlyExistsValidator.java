package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityC10Other1;
import iso20022.auth030.hkma.tr.AssetClassProductType11Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityC10Other1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityC10Other1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityC10Other1> ValidationResult<AssetClassCommodityC10Other1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType11Code) o.getBasePdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityC10Other1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityC10Other1", path, "");
		}
		return failure("AssetClassCommodityC10Other1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityC10Other1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
