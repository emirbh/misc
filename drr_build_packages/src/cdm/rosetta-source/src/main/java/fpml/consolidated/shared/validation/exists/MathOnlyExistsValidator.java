package fpml.consolidated.shared.validation.exists;

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

public class MathOnlyExistsValidator implements ValidatorWithArg<fpml.consolidated.shared.Math, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends fpml.consolidated.shared.Math> ValidationResult<fpml.consolidated.shared.Math> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("anyContents", ExistenceChecker.isSet((List<String>) o.getAnyContents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Math", ValidationResult.ValidationType.ONLY_EXISTS, "Math", path, "");
		}
		return failure("Math", ValidationResult.ValidationType.ONLY_EXISTS, "Math", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
