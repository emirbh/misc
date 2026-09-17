package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.legaldocumentation.common.SpecifiedEntityClauseEnum;
import cdm.legaldocumentation.master.isda.SpecifiedEntities;
import cdm.legaldocumentation.master.isda.SpecifiedEntity;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SpecifiedEntitiesOnlyExistsValidator implements ValidatorWithArg<SpecifiedEntities, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SpecifiedEntities> ValidationResult<SpecifiedEntities> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("specifiedEntityClause", ExistenceChecker.isSet((SpecifiedEntityClauseEnum) o.getSpecifiedEntityClause()))
				.put("specifiedEntity", ExistenceChecker.isSet((List<? extends SpecifiedEntity>) o.getSpecifiedEntity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SpecifiedEntities", ValidationResult.ValidationType.ONLY_EXISTS, "SpecifiedEntities", path, "");
		}
		return failure("SpecifiedEntities", ValidationResult.ValidationType.ONLY_EXISTS, "SpecifiedEntities", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
