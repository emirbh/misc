package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.GenericAttribute;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericAttributeOnlyExistsValidator implements ValidatorWithArg<GenericAttribute, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericAttribute> ValidationResult<GenericAttribute> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("attributeScheme", ExistenceChecker.isSet((String) o.getAttributeScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericAttribute", ValidationResult.ValidationType.ONLY_EXISTS, "GenericAttribute", path, "");
		}
		return failure("GenericAttribute", ValidationResult.ValidationType.ONLY_EXISTS, "GenericAttribute", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
