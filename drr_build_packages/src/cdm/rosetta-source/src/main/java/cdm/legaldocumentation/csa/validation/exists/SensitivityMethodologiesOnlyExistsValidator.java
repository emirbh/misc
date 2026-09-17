package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.SensitivityMethodologies;
import cdm.legaldocumentation.csa.SensitivityMethodology;
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

public class SensitivityMethodologiesOnlyExistsValidator implements ValidatorWithArg<SensitivityMethodologies, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SensitivityMethodologies> ValidationResult<SensitivityMethodologies> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sensitivityToEquity", ExistenceChecker.isSet((SensitivityMethodology) o.getSensitivityToEquity()))
				.put("sensitivityToCommodity", ExistenceChecker.isSet((SensitivityMethodology) o.getSensitivityToCommodity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SensitivityMethodologies", ValidationResult.ValidationType.ONLY_EXISTS, "SensitivityMethodologies", path, "");
		}
		return failure("SensitivityMethodologies", ValidationResult.ValidationType.ONLY_EXISTS, "SensitivityMethodologies", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
