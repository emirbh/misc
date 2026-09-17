package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CorrespondentInformation;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RoutingExplicitDetails;
import fpml.consolidated.shared.RoutingIds;
import fpml.consolidated.shared.RoutingIdsAndExplicitDetails;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CorrespondentInformationOnlyExistsValidator implements ValidatorWithArg<CorrespondentInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CorrespondentInformation> ValidationResult<CorrespondentInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("routingIds", ExistenceChecker.isSet((RoutingIds) o.getRoutingIds()))
				.put("routingExplicitDetails", ExistenceChecker.isSet((RoutingExplicitDetails) o.getRoutingExplicitDetails()))
				.put("routingIdsAndExplicitDetails", ExistenceChecker.isSet((RoutingIdsAndExplicitDetails) o.getRoutingIdsAndExplicitDetails()))
				.put("correspondentPartyReference", ExistenceChecker.isSet((PartyReference) o.getCorrespondentPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CorrespondentInformation", ValidationResult.ValidationType.ONLY_EXISTS, "CorrespondentInformation", path, "");
		}
		return failure("CorrespondentInformation", ValidationResult.ValidationType.ONLY_EXISTS, "CorrespondentInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
