package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxKnockoutCount;
import fpml.consolidated.fx.targets.FxKnockoutLevel;
import fpml.consolidated.fx.targets.FxTarget;
import fpml.consolidated.fx.targets.FxTargetAccumulationRegion;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetOnlyExistsValidator implements ValidatorWithArg<FxTarget, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTarget> ValidationResult<FxTarget> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("accumulationRegion", ExistenceChecker.isSet((List<? extends FxTargetAccumulationRegion>) o.getAccumulationRegion()))
				.put("knockoutLevel", ExistenceChecker.isSet((FxKnockoutLevel) o.getKnockoutLevel()))
				.put("knockoutCount", ExistenceChecker.isSet((FxKnockoutCount) o.getKnockoutCount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTarget", ValidationResult.ValidationType.ONLY_EXISTS, "FxTarget", path, "");
		}
		return failure("FxTarget", ValidationResult.ValidationType.ONLY_EXISTS, "FxTarget", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
