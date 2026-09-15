package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DividendAdjustment;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.option.shared.Asian;
import fpml.consolidated.option.shared.Barrier;
import fpml.consolidated.option.shared.Knock;
import fpml.consolidated.option.shared.PassThrough;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionFeaturesOnlyExistsValidator implements ValidatorWithArg<OptionFeatures, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionFeatures> ValidationResult<OptionFeatures> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("asian", ExistenceChecker.isSet((Asian) o.getAsian()))
				.put("barrier", ExistenceChecker.isSet((Barrier) o.getBarrier()))
				.put("knock", ExistenceChecker.isSet((Knock) o.getKnock()))
				.put("passThrough", ExistenceChecker.isSet((PassThrough) o.getPassThrough()))
				.put("dividendAdjustment", ExistenceChecker.isSet((DividendAdjustment) o.getDividendAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionFeatures", ValidationResult.ValidationType.ONLY_EXISTS, "OptionFeatures", path, "");
		}
		return failure("OptionFeatures", ValidationResult.ValidationType.ONLY_EXISTS, "OptionFeatures", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
