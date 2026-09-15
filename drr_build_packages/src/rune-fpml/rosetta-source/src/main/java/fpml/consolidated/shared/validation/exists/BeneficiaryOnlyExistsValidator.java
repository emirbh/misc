package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Beneficiary;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RoutingExplicitDetails;
import fpml.consolidated.shared.RoutingIds;
import fpml.consolidated.shared.RoutingIdsAndExplicitDetails;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BeneficiaryOnlyExistsValidator implements ValidatorWithArg<Beneficiary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Beneficiary> ValidationResult<Beneficiary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("routingIds", ExistenceChecker.isSet((RoutingIds) o.getRoutingIds()))
				.put("routingExplicitDetails", ExistenceChecker.isSet((RoutingExplicitDetails) o.getRoutingExplicitDetails()))
				.put("routingIdsAndExplicitDetails", ExistenceChecker.isSet((RoutingIdsAndExplicitDetails) o.getRoutingIdsAndExplicitDetails()))
				.put("beneficiaryPartyReference", ExistenceChecker.isSet((PartyReference) o.getBeneficiaryPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Beneficiary", ValidationResult.ValidationType.ONLY_EXISTS, "Beneficiary", path, "");
		}
		return failure("Beneficiary", ValidationResult.ValidationType.ONLY_EXISTS, "Beneficiary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
