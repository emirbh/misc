package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityFreight4Choice__1;
import iso20022.auth030.fca.FreightCommodityContainerShip2__1;
import iso20022.auth030.fca.FreightCommodityDry3__1;
import iso20022.auth030.fca.FreightCommodityOther2__1;
import iso20022.auth030.fca.FreightCommodityWet3__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityFreight4Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityFreight4Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityFreight4Choice__1> ValidationResult<AssetClassCommodityFreight4Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dry", ExistenceChecker.isSet((FreightCommodityDry3__1) o.getDry()))
				.put("wet", ExistenceChecker.isSet((FreightCommodityWet3__1) o.getWet()))
				.put("cntnrShip", ExistenceChecker.isSet((FreightCommodityContainerShip2__1) o.getCntnrShip()))
				.put("othr", ExistenceChecker.isSet((FreightCommodityOther2__1) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityFreight4Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFreight4Choice__1", path, "");
		}
		return failure("AssetClassCommodityFreight4Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFreight4Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
