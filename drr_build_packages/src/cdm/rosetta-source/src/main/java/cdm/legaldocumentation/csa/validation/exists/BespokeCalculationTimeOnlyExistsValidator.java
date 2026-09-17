package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.BespokeCalculationTime;
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

public class BespokeCalculationTimeOnlyExistsValidator implements ValidatorWithArg<BespokeCalculationTime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BespokeCalculationTime> ValidationResult<BespokeCalculationTime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("asCalculationAgent", ExistenceChecker.isSet((Boolean) o.getAsCalculationAgent()))
				.put("bespokeCalculationTimeTerms", ExistenceChecker.isSet((String) o.getBespokeCalculationTimeTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BespokeCalculationTime", ValidationResult.ValidationType.ONLY_EXISTS, "BespokeCalculationTime", path, "");
		}
		return failure("BespokeCalculationTime", ValidationResult.ValidationType.ONLY_EXISTS, "BespokeCalculationTime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
