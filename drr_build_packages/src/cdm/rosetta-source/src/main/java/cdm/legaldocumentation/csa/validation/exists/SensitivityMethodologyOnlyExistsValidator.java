package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.SensitivitiesEnum;
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

public class SensitivityMethodologyOnlyExistsValidator implements ValidatorWithArg<SensitivityMethodology, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SensitivityMethodology> ValidationResult<SensitivityMethodology> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("specifiedMethodology", ExistenceChecker.isSet((SensitivitiesEnum) o.getSpecifiedMethodology()))
				.put("customMethodology", ExistenceChecker.isSet((String) o.getCustomMethodology()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SensitivityMethodology", ValidationResult.ValidationType.ONLY_EXISTS, "SensitivityMethodology", path, "");
		}
		return failure("SensitivityMethodology", ValidationResult.ValidationType.ONLY_EXISTS, "SensitivityMethodology", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
