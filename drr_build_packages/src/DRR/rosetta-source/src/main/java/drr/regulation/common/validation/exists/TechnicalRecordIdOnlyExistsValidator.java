package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TechnicalRecordId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TechnicalRecordIdOnlyExistsValidator implements ValidatorWithArg<TechnicalRecordId, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TechnicalRecordId> ValidationResult<TechnicalRecordId> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((FieldWithMetaString) o.getId()))
				.put("isUnique", ExistenceChecker.isSet((Boolean) o.getIsUnique()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TechnicalRecordId", ValidationResult.ValidationType.ONLY_EXISTS, "TechnicalRecordId", path, "");
		}
		return failure("TechnicalRecordId", ValidationResult.ValidationType.ONLY_EXISTS, "TechnicalRecordId", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
