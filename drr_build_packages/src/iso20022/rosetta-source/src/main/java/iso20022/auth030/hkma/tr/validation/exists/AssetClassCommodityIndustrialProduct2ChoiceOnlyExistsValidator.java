package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.hkma.tr.IndustrialProductCommodityConstruction2;
import iso20022.auth030.hkma.tr.IndustrialProductCommodityManufacturing2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityIndustrialProduct2ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityIndustrialProduct2Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityIndustrialProduct2Choice> ValidationResult<AssetClassCommodityIndustrialProduct2Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cnstrctn", ExistenceChecker.isSet((IndustrialProductCommodityConstruction2) o.getCnstrctn()))
				.put("manfctg", ExistenceChecker.isSet((IndustrialProductCommodityManufacturing2) o.getManfctg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityIndustrialProduct2Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityIndustrialProduct2Choice", path, "");
		}
		return failure("AssetClassCommodityIndustrialProduct2Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityIndustrialProduct2Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
