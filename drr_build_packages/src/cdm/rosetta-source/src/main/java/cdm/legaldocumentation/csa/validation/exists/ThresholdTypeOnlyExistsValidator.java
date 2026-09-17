package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.Infinity;
import cdm.legaldocumentation.csa.ThresholdFixedAmount;
import cdm.legaldocumentation.csa.ThresholdRatingsBased;
import cdm.legaldocumentation.csa.ThresholdType;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ThresholdTypeOnlyExistsValidator implements ValidatorWithArg<ThresholdType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ThresholdType> ValidationResult<ThresholdType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedAmount", ExistenceChecker.isSet((ThresholdFixedAmount) o.getFixedAmount()))
				.put("ratingsBased", ExistenceChecker.isSet((ThresholdRatingsBased) o.getRatingsBased()))
				.put("infinity", ExistenceChecker.isSet((Infinity) o.getInfinity()))
				.put("other", ExistenceChecker.isSet((String) o.getOther()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ThresholdType", ValidationResult.ValidationType.ONLY_EXISTS, "ThresholdType", path, "");
		}
		return failure("ThresholdType", ValidationResult.ValidationType.ONLY_EXISTS, "ThresholdType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
