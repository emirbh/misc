package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityFreight4Choice;
import iso20022.auth030.hkma.dtcc.FreightCommodityContainerShip2;
import iso20022.auth030.hkma.dtcc.FreightCommodityDry3;
import iso20022.auth030.hkma.dtcc.FreightCommodityOther2;
import iso20022.auth030.hkma.dtcc.FreightCommodityWet3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityFreight4ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityFreight4Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityFreight4Choice> ValidationResult<AssetClassCommodityFreight4Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dry", ExistenceChecker.isSet((FreightCommodityDry3) o.getDry()))
				.put("wet", ExistenceChecker.isSet((FreightCommodityWet3) o.getWet()))
				.put("cntnrShip", ExistenceChecker.isSet((FreightCommodityContainerShip2) o.getCntnrShip()))
				.put("othr", ExistenceChecker.isSet((FreightCommodityOther2) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityFreight4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFreight4Choice", path, "");
		}
		return failure("AssetClassCommodityFreight4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFreight4Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
