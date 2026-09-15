package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.hkma.tr.EnvironmentCommodityOther2;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityCarbonRelated2;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityEmission3;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityWeather2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityEnvironmental3ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityEnvironmental3Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityEnvironmental3Choice> ValidationResult<AssetClassCommodityEnvironmental3Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("emssns", ExistenceChecker.isSet((EnvironmentalCommodityEmission3) o.getEmssns()))
				.put("wthr", ExistenceChecker.isSet((EnvironmentalCommodityWeather2) o.getWthr()))
				.put("crbnRltd", ExistenceChecker.isSet((EnvironmentalCommodityCarbonRelated2) o.getCrbnRltd()))
				.put("othr", ExistenceChecker.isSet((EnvironmentCommodityOther2) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityEnvironmental3Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnvironmental3Choice", path, "");
		}
		return failure("AssetClassCommodityEnvironmental3Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnvironmental3Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
