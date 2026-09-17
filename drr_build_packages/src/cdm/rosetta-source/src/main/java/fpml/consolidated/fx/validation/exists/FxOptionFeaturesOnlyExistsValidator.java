package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxAsianFeature;
import fpml.consolidated.fx.FxBarrierFeature;
import fpml.consolidated.fx.FxOptionFeatures;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxOptionFeaturesOnlyExistsValidator implements ValidatorWithArg<FxOptionFeatures, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxOptionFeatures> ValidationResult<FxOptionFeatures> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("asian", ExistenceChecker.isSet((FxAsianFeature) o.getAsian()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxBarrierFeature>) o.getBarrier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxOptionFeatures", ValidationResult.ValidationType.ONLY_EXISTS, "FxOptionFeatures", path, "");
		}
		return failure("FxOptionFeatures", ValidationResult.ValidationType.ONLY_EXISTS, "FxOptionFeatures", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
