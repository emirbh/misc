package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.RetrospectiveEffect;
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

public class RetrospectiveEffectOnlyExistsValidator implements ValidatorWithArg<RetrospectiveEffect, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RetrospectiveEffect> ValidationResult<RetrospectiveEffect> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("standardisedException", ExistenceChecker.isSet((ExceptionEnum) o.getStandardisedException()))
				.put("asSpecified", ExistenceChecker.isSet((String) o.getAsSpecified()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RetrospectiveEffect", ValidationResult.ValidationType.ONLY_EXISTS, "RetrospectiveEffect", path, "");
		}
		return failure("RetrospectiveEffect", ValidationResult.ValidationType.ONLY_EXISTS, "RetrospectiveEffect", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
