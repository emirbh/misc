package fpml.consolidated.msg.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceProcessingStep;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ServiceProcessingStepOnlyExistsValidator implements ValidatorWithArg<ServiceProcessingStep, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ServiceProcessingStep> ValidationResult<ServiceProcessingStep> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("serviceProcessingStep", ExistenceChecker.isSet((String) o.getServiceProcessingStep()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ServiceProcessingStep", ValidationResult.ValidationType.ONLY_EXISTS, "ServiceProcessingStep", path, "");
		}
		return failure("ServiceProcessingStep", ValidationResult.ValidationType.ONLY_EXISTS, "ServiceProcessingStep", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
