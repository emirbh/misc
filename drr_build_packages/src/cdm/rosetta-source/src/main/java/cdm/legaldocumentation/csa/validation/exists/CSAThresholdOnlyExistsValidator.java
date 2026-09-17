package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CSAThreshold;
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

public class CSAThresholdOnlyExistsValidator implements ValidatorWithArg<CSAThreshold, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CSAThreshold> ValidationResult<CSAThreshold> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("thresholdType", ExistenceChecker.isSet((ThresholdType) o.getThresholdType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CSAThreshold", ValidationResult.ValidationType.ONLY_EXISTS, "CSAThreshold", path, "");
		}
		return failure("CSAThreshold", ValidationResult.ValidationType.ONLY_EXISTS, "CSAThreshold", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
