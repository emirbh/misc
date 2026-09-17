package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CalculationDateLocation;
import cdm.legaldocumentation.csa.CalculationDateLocationElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationDateLocationOnlyExistsValidator implements ValidatorWithArg<CalculationDateLocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationDateLocation> ValidationResult<CalculationDateLocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyElection", ExistenceChecker.isSet((List<? extends CalculationDateLocationElection>) o.getPartyElection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationDateLocation", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationDateLocation", path, "");
		}
		return failure("CalculationDateLocation", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationDateLocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
