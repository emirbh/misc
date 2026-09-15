package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityEnvironmental3Choice__1;
import iso20022.auth030.fca.EnvironmentCommodityOther2__1;
import iso20022.auth030.fca.EnvironmentalCommodityCarbonRelated2__1;
import iso20022.auth030.fca.EnvironmentalCommodityEmission3__1;
import iso20022.auth030.fca.EnvironmentalCommodityWeather2__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityEnvironmental3Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityEnvironmental3Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityEnvironmental3Choice__1> ValidationResult<AssetClassCommodityEnvironmental3Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("emssns", ExistenceChecker.isSet((EnvironmentalCommodityEmission3__1) o.getEmssns()))
				.put("wthr", ExistenceChecker.isSet((EnvironmentalCommodityWeather2__1) o.getWthr()))
				.put("crbnRltd", ExistenceChecker.isSet((EnvironmentalCommodityCarbonRelated2__1) o.getCrbnRltd()))
				.put("othr", ExistenceChecker.isSet((EnvironmentCommodityOther2__1) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityEnvironmental3Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnvironmental3Choice__1", path, "");
		}
		return failure("AssetClassCommodityEnvironmental3Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnvironmental3Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
