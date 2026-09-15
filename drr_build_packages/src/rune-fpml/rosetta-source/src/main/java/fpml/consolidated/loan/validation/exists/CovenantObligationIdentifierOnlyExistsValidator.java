package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationId;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.VersionedCovenantObligationId;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CovenantObligationIdentifierOnlyExistsValidator implements ValidatorWithArg<CovenantObligationIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CovenantObligationIdentifier> ValidationResult<CovenantObligationIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("covenantObligationId", ExistenceChecker.isSet((List<? extends CovenantObligationId>) o.getCovenantObligationId()))
				.put("versionedCovenantObligationId", ExistenceChecker.isSet((List<? extends VersionedCovenantObligationId>) o.getVersionedCovenantObligationId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CovenantObligationIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "CovenantObligationIdentifier", path, "");
		}
		return failure("CovenantObligationIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "CovenantObligationIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
