package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityFertilizer4Choice__1;
import iso20022.auth030.fca.FertilizerCommodityAmmonia2__1;
import iso20022.auth030.fca.FertilizerCommodityDiammoniumPhosphate2__1;
import iso20022.auth030.fca.FertilizerCommodityOther2__1;
import iso20022.auth030.fca.FertilizerCommodityPotash2__1;
import iso20022.auth030.fca.FertilizerCommoditySulphur2__1;
import iso20022.auth030.fca.FertilizerCommodityUrea2__1;
import iso20022.auth030.fca.FertilizerCommodityUreaAndAmmoniumNitrate2__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityFertilizer4Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityFertilizer4Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityFertilizer4Choice__1> ValidationResult<AssetClassCommodityFertilizer4Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ammn", ExistenceChecker.isSet((FertilizerCommodityAmmonia2__1) o.getAmmn()))
				.put("dmmnmPhspht", ExistenceChecker.isSet((FertilizerCommodityDiammoniumPhosphate2__1) o.getDmmnmPhspht()))
				.put("ptsh", ExistenceChecker.isSet((FertilizerCommodityPotash2__1) o.getPtsh()))
				.put("slphr", ExistenceChecker.isSet((FertilizerCommoditySulphur2__1) o.getSlphr()))
				.put("urea", ExistenceChecker.isSet((FertilizerCommodityUrea2__1) o.getUrea()))
				.put("ureaAndAmmnmNtrt", ExistenceChecker.isSet((FertilizerCommodityUreaAndAmmoniumNitrate2__1) o.getUreaAndAmmnmNtrt()))
				.put("othr", ExistenceChecker.isSet((FertilizerCommodityOther2__1) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityFertilizer4Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFertilizer4Choice__1", path, "");
		}
		return failure("AssetClassCommodityFertilizer4Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFertilizer4Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
