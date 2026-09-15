package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityOther1;
import iso20022.auth030.hkma.dtcc.AssetClassProductType15Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityOther1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityOther1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityOther1> ValidationResult<AssetClassCommodityOther1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType15Code) o.getBasePdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityOther1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityOther1", path, "");
		}
		return failure("AssetClassCommodityOther1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityOther1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
