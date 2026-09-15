package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodityPolypropylene4Choice;
import iso20022.auth030.esma.PolypropyleneCommodityOther2;
import iso20022.auth030.esma.PolypropyleneCommodityPlastic2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityPolypropylene4ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityPolypropylene4Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityPolypropylene4Choice> ValidationResult<AssetClassCommodityPolypropylene4Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("plstc", ExistenceChecker.isSet((PolypropyleneCommodityPlastic2) o.getPlstc()))
				.put("othr", ExistenceChecker.isSet((PolypropyleneCommodityOther2) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityPolypropylene4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityPolypropylene4Choice", path, "");
		}
		return failure("AssetClassCommodityPolypropylene4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityPolypropylene4Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
