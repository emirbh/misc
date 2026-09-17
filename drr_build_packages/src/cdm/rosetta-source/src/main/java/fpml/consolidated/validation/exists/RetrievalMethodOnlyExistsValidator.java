package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.RetrievalMethod;
import fpml.consolidated.TransformsType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RetrievalMethodOnlyExistsValidator implements ValidatorWithArg<RetrievalMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RetrievalMethod> ValidationResult<RetrievalMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("uri", ExistenceChecker.isSet((String) o.getUri()))
				.put("type", ExistenceChecker.isSet((String) o._getType()))
				.put("transforms", ExistenceChecker.isSet((TransformsType) o.getTransforms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RetrievalMethod", ValidationResult.ValidationType.ONLY_EXISTS, "RetrievalMethod", path, "");
		}
		return failure("RetrievalMethod", ValidationResult.ValidationType.ONLY_EXISTS, "RetrievalMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
