package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.GeneralSimmElections;
import cdm.legaldocumentation.csa.SimmCalculationCurrency;
import cdm.legaldocumentation.csa.SimmVersion;
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

public class GeneralSimmElectionsOnlyExistsValidator implements ValidatorWithArg<GeneralSimmElections, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GeneralSimmElections> ValidationResult<GeneralSimmElections> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("simmVersion", ExistenceChecker.isSet((SimmVersion) o.getSimmVersion()))
				.put("simmCalculationCurrency", ExistenceChecker.isSet((SimmCalculationCurrency) o.getSimmCalculationCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GeneralSimmElections", ValidationResult.ValidationType.ONLY_EXISTS, "GeneralSimmElections", path, "");
		}
		return failure("GeneralSimmElections", ValidationResult.ValidationType.ONLY_EXISTS, "GeneralSimmElections", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
