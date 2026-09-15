package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityAmmonia2;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityDiammoniumPhosphate2;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityOther2;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityPotash2;
import iso20022.auth030.hkma.dtcc.FertilizerCommoditySulphur2;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityUrea2;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityUreaAndAmmoniumNitrate2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityFertilizer4ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityFertilizer4Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityFertilizer4Choice> ValidationResult<AssetClassCommodityFertilizer4Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ammn", ExistenceChecker.isSet((FertilizerCommodityAmmonia2) o.getAmmn()))
				.put("dmmnmPhspht", ExistenceChecker.isSet((FertilizerCommodityDiammoniumPhosphate2) o.getDmmnmPhspht()))
				.put("ptsh", ExistenceChecker.isSet((FertilizerCommodityPotash2) o.getPtsh()))
				.put("slphr", ExistenceChecker.isSet((FertilizerCommoditySulphur2) o.getSlphr()))
				.put("urea", ExistenceChecker.isSet((FertilizerCommodityUrea2) o.getUrea()))
				.put("ureaAndAmmnmNtrt", ExistenceChecker.isSet((FertilizerCommodityUreaAndAmmoniumNitrate2) o.getUreaAndAmmnmNtrt()))
				.put("othr", ExistenceChecker.isSet((FertilizerCommodityOther2) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityFertilizer4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFertilizer4Choice", path, "");
		}
		return failure("AssetClassCommodityFertilizer4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityFertilizer4Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
