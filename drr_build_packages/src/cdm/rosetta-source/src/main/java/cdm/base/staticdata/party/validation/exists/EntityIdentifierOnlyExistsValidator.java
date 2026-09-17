package cdm.base.staticdata.party.validation.exists;

import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EntityIdentifierOnlyExistsValidator implements ValidatorWithArg<EntityIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EntityIdentifier> ValidationResult<EntityIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((FieldWithMetaString) o.getIdentifier()))
				.put("identifierType", ExistenceChecker.isSet((EntityIdentifierTypeEnum) o.getIdentifierType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EntityIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "EntityIdentifier", path, "");
		}
		return failure("EntityIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "EntityIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
