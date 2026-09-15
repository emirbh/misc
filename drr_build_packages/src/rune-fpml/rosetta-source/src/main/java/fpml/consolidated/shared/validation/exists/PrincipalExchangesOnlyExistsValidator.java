package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PrincipalExchanges;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrincipalExchangesOnlyExistsValidator implements ValidatorWithArg<PrincipalExchanges, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PrincipalExchanges> ValidationResult<PrincipalExchanges> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("initialExchange", ExistenceChecker.isSet((Boolean) o.getInitialExchange()))
				.put("finalExchange", ExistenceChecker.isSet((Boolean) o.getFinalExchange()))
				.put("intermediateExchange", ExistenceChecker.isSet((Boolean) o.getIntermediateExchange()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrincipalExchanges", ValidationResult.ValidationType.ONLY_EXISTS, "PrincipalExchanges", path, "");
		}
		return failure("PrincipalExchanges", ValidationResult.ValidationType.ONLY_EXISTS, "PrincipalExchanges", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
