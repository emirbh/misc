package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetConstantPayoff;
import fpml.consolidated.fx.targets.FxTargetConstantPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetPhysicalSettlement;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetConstantPayoffRegionOnlyExistsValidator implements ValidatorWithArg<FxTargetConstantPayoffRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetConstantPayoffRegion> ValidationResult<FxTargetConstantPayoffRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("upperBound", ExistenceChecker.isSet((FxTargetRegionUpperBound) o.getUpperBound()))
				.put("lowerBound", ExistenceChecker.isSet((FxTargetRegionLowerBound) o.getLowerBound()))
				.put("payoff", ExistenceChecker.isSet((FxTargetConstantPayoff) o.getPayoff()))
				.put("physicalSettlement", ExistenceChecker.isSet((FxTargetPhysicalSettlement) o.getPhysicalSettlement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetConstantPayoffRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetConstantPayoffRegion", path, "");
		}
		return failure("FxTargetConstantPayoffRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetConstantPayoffRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
