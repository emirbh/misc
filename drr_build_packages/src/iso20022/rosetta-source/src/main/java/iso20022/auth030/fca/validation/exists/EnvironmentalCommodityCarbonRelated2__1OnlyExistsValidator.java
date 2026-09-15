package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassProductType3Code;
import iso20022.auth030.fca.AssetClassSubProductType29Code;
import iso20022.auth030.fca.EnvironmentalCommodityCarbonRelated2__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnvironmentalCommodityCarbonRelated2__1OnlyExistsValidator implements ValidatorWithArg<EnvironmentalCommodityCarbonRelated2__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnvironmentalCommodityCarbonRelated2__1> ValidationResult<EnvironmentalCommodityCarbonRelated2__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType3Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType29Code) o.getSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnvironmentalCommodityCarbonRelated2__1", ValidationResult.ValidationType.ONLY_EXISTS, "EnvironmentalCommodityCarbonRelated2__1", path, "");
		}
		return failure("EnvironmentalCommodityCarbonRelated2__1", ValidationResult.ValidationType.ONLY_EXISTS, "EnvironmentalCommodityCarbonRelated2__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
