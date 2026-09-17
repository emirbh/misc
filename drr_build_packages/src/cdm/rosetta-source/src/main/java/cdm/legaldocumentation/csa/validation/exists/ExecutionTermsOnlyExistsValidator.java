package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.ExecutionLanguage;
import cdm.legaldocumentation.csa.ExecutionLocation;
import cdm.legaldocumentation.csa.ExecutionTerms;
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

public class ExecutionTermsOnlyExistsValidator implements ValidatorWithArg<ExecutionTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExecutionTerms> ValidationResult<ExecutionTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("executionLanguage", ExistenceChecker.isSet((ExecutionLanguage) o.getExecutionLanguage()))
				.put("executionLocation", ExistenceChecker.isSet((ExecutionLocation) o.getExecutionLocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExecutionTerms", ValidationResult.ValidationType.ONLY_EXISTS, "ExecutionTerms", path, "");
		}
		return failure("ExecutionTerms", ValidationResult.ValidationType.ONLY_EXISTS, "ExecutionTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
