package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AgriculturalCommodityDairy2__1;
import iso20022.auth030.fca.AgriculturalCommodityForestry2__1;
import iso20022.auth030.fca.AgriculturalCommodityGrain3__1;
import iso20022.auth030.fca.AgriculturalCommodityLiveStock2__1;
import iso20022.auth030.fca.AgriculturalCommodityOilSeed2__1;
import iso20022.auth030.fca.AgriculturalCommodityOliveOil3__1;
import iso20022.auth030.fca.AgriculturalCommodityOther2__1;
import iso20022.auth030.fca.AgriculturalCommodityPotato2__1;
import iso20022.auth030.fca.AgriculturalCommoditySeafood2__1;
import iso20022.auth030.fca.AgriculturalCommoditySoft2__1;
import iso20022.auth030.fca.AssetClassCommodityAgricultural6Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityAgricultural6Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityAgricultural6Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityAgricultural6Choice__1> ValidationResult<AssetClassCommodityAgricultural6Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("grnOilSeed", ExistenceChecker.isSet((AgriculturalCommodityOilSeed2__1) o.getGrnOilSeed()))
				.put("soft", ExistenceChecker.isSet((AgriculturalCommoditySoft2__1) o.getSoft()))
				.put("ptt", ExistenceChecker.isSet((AgriculturalCommodityPotato2__1) o.getPtt()))
				.put("olvOil", ExistenceChecker.isSet((AgriculturalCommodityOliveOil3__1) o.getOlvOil()))
				.put("dairy", ExistenceChecker.isSet((AgriculturalCommodityDairy2__1) o.getDairy()))
				.put("frstry", ExistenceChecker.isSet((AgriculturalCommodityForestry2__1) o.getFrstry()))
				.put("sfd", ExistenceChecker.isSet((AgriculturalCommoditySeafood2__1) o.getSfd()))
				.put("liveStock", ExistenceChecker.isSet((AgriculturalCommodityLiveStock2__1) o.getLiveStock()))
				.put("grn", ExistenceChecker.isSet((AgriculturalCommodityGrain3__1) o.getGrn()))
				.put("othr", ExistenceChecker.isSet((AgriculturalCommodityOther2__1) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityAgricultural6Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityAgricultural6Choice__1", path, "");
		}
		return failure("AssetClassCommodityAgricultural6Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityAgricultural6Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
