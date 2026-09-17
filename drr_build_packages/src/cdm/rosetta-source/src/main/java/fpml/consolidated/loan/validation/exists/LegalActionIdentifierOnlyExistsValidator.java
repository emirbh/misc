package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegalActionId;
import fpml.consolidated.loan.LegalActionIdentifier;
import fpml.consolidated.loan.VersionedLegalActionId;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LegalActionIdentifierOnlyExistsValidator implements ValidatorWithArg<LegalActionIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegalActionIdentifier> ValidationResult<LegalActionIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("legalActionId", ExistenceChecker.isSet((List<? extends LegalActionId>) o.getLegalActionId()))
				.put("versionedLegalActionId", ExistenceChecker.isSet((List<? extends VersionedLegalActionId>) o.getVersionedLegalActionId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegalActionIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "LegalActionIdentifier", path, "");
		}
		return failure("LegalActionIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "LegalActionIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
