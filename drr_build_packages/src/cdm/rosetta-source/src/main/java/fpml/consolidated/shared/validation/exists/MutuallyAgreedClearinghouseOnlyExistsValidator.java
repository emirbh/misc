package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import fpml.consolidated.shared.OrganizationIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MutuallyAgreedClearinghouseOnlyExistsValidator implements ValidatorWithArg<MutuallyAgreedClearinghouse, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MutuallyAgreedClearinghouse> ValidationResult<MutuallyAgreedClearinghouse> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("identifier", ExistenceChecker.isSet((OrganizationIdentifier) o.getIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MutuallyAgreedClearinghouse", ValidationResult.ValidationType.ONLY_EXISTS, "MutuallyAgreedClearinghouse", path, "");
		}
		return failure("MutuallyAgreedClearinghouse", ValidationResult.ValidationType.ONLY_EXISTS, "MutuallyAgreedClearinghouse", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
