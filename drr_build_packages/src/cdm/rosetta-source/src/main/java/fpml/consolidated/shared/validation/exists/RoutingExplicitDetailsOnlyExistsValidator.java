package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Address;
import fpml.consolidated.shared.RoutingExplicitDetails;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RoutingExplicitDetailsOnlyExistsValidator implements ValidatorWithArg<RoutingExplicitDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RoutingExplicitDetails> ValidationResult<RoutingExplicitDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("routingName", ExistenceChecker.isSet((String) o.getRoutingName()))
				.put("routingAddress", ExistenceChecker.isSet((Address) o.getRoutingAddress()))
				.put("routingAccountNumber", ExistenceChecker.isSet((String) o.getRoutingAccountNumber()))
				.put("routingReferenceText", ExistenceChecker.isSet((List<String>) o.getRoutingReferenceText()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RoutingExplicitDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RoutingExplicitDetails", path, "");
		}
		return failure("RoutingExplicitDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RoutingExplicitDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
