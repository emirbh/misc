package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetAccumulationRegion;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetAccumulationRegionOnlyExistsValidator implements ValidatorWithArg<FxTargetAccumulationRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetAccumulationRegion> ValidationResult<FxTargetAccumulationRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("upperBound", ExistenceChecker.isSet((FxTargetRegionUpperBound) o.getUpperBound()))
				.put("lowerBound", ExistenceChecker.isSet((FxTargetRegionLowerBound) o.getLowerBound()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetAccumulationRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetAccumulationRegion", path, "");
		}
		return failure("FxTargetAccumulationRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetAccumulationRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
