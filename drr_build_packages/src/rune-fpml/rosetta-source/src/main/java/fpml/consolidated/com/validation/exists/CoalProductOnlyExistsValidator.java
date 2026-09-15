package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalProduct;
import fpml.consolidated.com.CoalProductSource;
import fpml.consolidated.com.CoalProductSpecifications;
import fpml.consolidated.com.CoalProductType;
import fpml.consolidated.com.CoalQualityAdjustments;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalProductOnlyExistsValidator implements ValidatorWithArg<CoalProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalProduct> ValidationResult<CoalProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("type", ExistenceChecker.isSet((CoalProductType) o._getType()))
				.put("coalProductSpecifications", ExistenceChecker.isSet((CoalProductSpecifications) o.getCoalProductSpecifications()))
				.put("source", ExistenceChecker.isSet((List<? extends CoalProductSource>) o.getSource()))
				.put("sCoTASpecifications", ExistenceChecker.isSet((Boolean) o.getSCoTASpecifications()))
				.put("btuQualityAdjustment", ExistenceChecker.isSet((CoalQualityAdjustments) o.getBtuQualityAdjustment()))
				.put("so2QualityAdjustment", ExistenceChecker.isSet((CoalQualityAdjustments) o.getSo2QualityAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalProduct", ValidationResult.ValidationType.ONLY_EXISTS, "CoalProduct", path, "");
		}
		return failure("CoalProduct", ValidationResult.ValidationType.ONLY_EXISTS, "CoalProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
