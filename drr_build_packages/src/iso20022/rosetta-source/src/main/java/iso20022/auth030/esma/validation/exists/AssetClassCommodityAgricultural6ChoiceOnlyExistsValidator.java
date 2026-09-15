package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AgriculturalCommodityDairy2;
import iso20022.auth030.esma.AgriculturalCommodityForestry2;
import iso20022.auth030.esma.AgriculturalCommodityGrain3;
import iso20022.auth030.esma.AgriculturalCommodityLiveStock2;
import iso20022.auth030.esma.AgriculturalCommodityOilSeed2;
import iso20022.auth030.esma.AgriculturalCommodityOliveOil3;
import iso20022.auth030.esma.AgriculturalCommodityOther2;
import iso20022.auth030.esma.AgriculturalCommodityPotato2;
import iso20022.auth030.esma.AgriculturalCommoditySeafood2;
import iso20022.auth030.esma.AgriculturalCommoditySoft2;
import iso20022.auth030.esma.AssetClassCommodityAgricultural6Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityAgricultural6ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityAgricultural6Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityAgricultural6Choice> ValidationResult<AssetClassCommodityAgricultural6Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("grnOilSeed", ExistenceChecker.isSet((AgriculturalCommodityOilSeed2) o.getGrnOilSeed()))
				.put("soft", ExistenceChecker.isSet((AgriculturalCommoditySoft2) o.getSoft()))
				.put("ptt", ExistenceChecker.isSet((AgriculturalCommodityPotato2) o.getPtt()))
				.put("olvOil", ExistenceChecker.isSet((AgriculturalCommodityOliveOil3) o.getOlvOil()))
				.put("dairy", ExistenceChecker.isSet((AgriculturalCommodityDairy2) o.getDairy()))
				.put("frstry", ExistenceChecker.isSet((AgriculturalCommodityForestry2) o.getFrstry()))
				.put("sfd", ExistenceChecker.isSet((AgriculturalCommoditySeafood2) o.getSfd()))
				.put("liveStock", ExistenceChecker.isSet((AgriculturalCommodityLiveStock2) o.getLiveStock()))
				.put("grn", ExistenceChecker.isSet((AgriculturalCommodityGrain3) o.getGrn()))
				.put("othr", ExistenceChecker.isSet((AgriculturalCommodityOther2) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityAgricultural6Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityAgricultural6Choice", path, "");
		}
		return failure("AssetClassCommodityAgricultural6Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityAgricultural6Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
