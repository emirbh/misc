package fpml.consolidated.option.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.Asian;
import fpml.consolidated.option.shared.Barrier;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.Knock;
import fpml.consolidated.option.shared.OptionFeature;
import fpml.consolidated.option.shared.PassThrough;
import fpml.consolidated.option.shared.StrategyFeature;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionFeatureOnlyExistsValidator implements ValidatorWithArg<OptionFeature, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionFeature> ValidationResult<OptionFeature> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxFeature", ExistenceChecker.isSet((FxFeature) o.getFxFeature()))
				.put("strategyFeature", ExistenceChecker.isSet((StrategyFeature) o.getStrategyFeature()))
				.put("asian", ExistenceChecker.isSet((Asian) o.getAsian()))
				.put("barrier", ExistenceChecker.isSet((Barrier) o.getBarrier()))
				.put("knock", ExistenceChecker.isSet((Knock) o.getKnock()))
				.put("passThrough", ExistenceChecker.isSet((PassThrough) o.getPassThrough()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionFeature", ValidationResult.ValidationType.ONLY_EXISTS, "OptionFeature", path, "");
		}
		return failure("OptionFeature", ValidationResult.ValidationType.ONLY_EXISTS, "OptionFeature", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
