package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.common.ExecutionLocationEnum;
import cdm.legaldocumentation.csa.ExecutionLocation;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExecutionLocationOnlyExistsValidator implements ValidatorWithArg<ExecutionLocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExecutionLocation> ValidationResult<ExecutionLocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("executionLocation", ExistenceChecker.isSet((ExecutionLocationEnum) o.getExecutionLocation()))
				.put("otherLanguage", ExistenceChecker.isSet((String) o.getOtherLanguage()))
				.put("dutyPayer", ExistenceChecker.isSet((String) o.getDutyPayer()))
				.put("dutyPayerLanguage", ExistenceChecker.isSet((String) o.getDutyPayerLanguage()))
				.put("dutyPaymentDate", ExistenceChecker.isSet((Date) o.getDutyPaymentDate()))
				.put("dutyPaymentLanguage", ExistenceChecker.isSet((String) o.getDutyPaymentLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExecutionLocation", ValidationResult.ValidationType.ONLY_EXISTS, "ExecutionLocation", path, "");
		}
		return failure("ExecutionLocation", ValidationResult.ValidationType.ONLY_EXISTS, "ExecutionLocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
