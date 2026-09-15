package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CovenantObligationIdOnlyExistsValidator implements ValidatorWithArg<CovenantObligationId, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CovenantObligationId> ValidationResult<CovenantObligationId> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("covenantObligationIdScheme", ExistenceChecker.isSet((String) o.getCovenantObligationIdScheme()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CovenantObligationId", ValidationResult.ValidationType.ONLY_EXISTS, "CovenantObligationId", path, "");
		}
		return failure("CovenantObligationId", ValidationResult.ValidationType.ONLY_EXISTS, "CovenantObligationId", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
