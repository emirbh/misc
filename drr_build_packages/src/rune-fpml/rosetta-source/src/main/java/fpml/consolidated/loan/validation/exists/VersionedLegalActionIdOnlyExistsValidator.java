package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegalActionId;
import fpml.consolidated.loan.VersionedLegalActionId;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VersionedLegalActionIdOnlyExistsValidator implements ValidatorWithArg<VersionedLegalActionId, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VersionedLegalActionId> ValidationResult<VersionedLegalActionId> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("legalActionId", ExistenceChecker.isSet((LegalActionId) o.getLegalActionId()))
				.put("version", ExistenceChecker.isSet((Integer) o.getVersion()))
				.put("effectiveDate", ExistenceChecker.isSet((IdentifiedDate) o.getEffectiveDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VersionedLegalActionId", ValidationResult.ValidationType.ONLY_EXISTS, "VersionedLegalActionId", path, "");
		}
		return failure("VersionedLegalActionId", ValidationResult.ValidationType.ONLY_EXISTS, "VersionedLegalActionId", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
