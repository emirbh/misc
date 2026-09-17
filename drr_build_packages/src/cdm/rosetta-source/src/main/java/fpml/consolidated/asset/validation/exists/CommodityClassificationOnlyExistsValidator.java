package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.asset.CommodityClassificationLayer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityClassificationOnlyExistsValidator implements ValidatorWithArg<CommodityClassification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityClassification> ValidationResult<CommodityClassification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("code", ExistenceChecker.isSet((List<? extends CommodityClassificationLayer>) o.getCode()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityClassification", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityClassification", path, "");
		}
		return failure("CommodityClassification", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityClassification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
