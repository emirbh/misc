package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityIndustrialProduct2Choice__1;
import iso20022.auth030.fca.IndustrialProductCommodityConstruction2__1;
import iso20022.auth030.fca.IndustrialProductCommodityManufacturing2__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityIndustrialProduct2Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityIndustrialProduct2Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityIndustrialProduct2Choice__1> ValidationResult<AssetClassCommodityIndustrialProduct2Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cnstrctn", ExistenceChecker.isSet((IndustrialProductCommodityConstruction2__1) o.getCnstrctn()))
				.put("manfctg", ExistenceChecker.isSet((IndustrialProductCommodityManufacturing2__1) o.getManfctg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityIndustrialProduct2Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityIndustrialProduct2Choice__1", path, "");
		}
		return failure("AssetClassCommodityIndustrialProduct2Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityIndustrialProduct2Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
