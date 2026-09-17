package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PartyRole;
import fpml.consolidated.shared.PartyRoleType;
import fpml.consolidated.shared.RelatedParty;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RelatedPartyOnlyExistsValidator implements ValidatorWithArg<RelatedParty, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RelatedParty> ValidationResult<RelatedParty> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("role", ExistenceChecker.isSet((PartyRole) o.getRole()))
				.put("type", ExistenceChecker.isSet((PartyRoleType) o._getType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RelatedParty", ValidationResult.ValidationType.ONLY_EXISTS, "RelatedParty", path, "");
		}
		return failure("RelatedParty", ValidationResult.ValidationType.ONLY_EXISTS, "RelatedParty", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
