package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.SupplementaryDataEnvelope1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SupplementaryDataEnvelope1OnlyExistsValidator implements ValidatorWithArg<SupplementaryDataEnvelope1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SupplementaryDataEnvelope1> ValidationResult<SupplementaryDataEnvelope1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("anyContents", ExistenceChecker.isSet((String) o.getAnyContents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SupplementaryDataEnvelope1", ValidationResult.ValidationType.ONLY_EXISTS, "SupplementaryDataEnvelope1", path, "");
		}
		return failure("SupplementaryDataEnvelope1", ValidationResult.ValidationType.ONLY_EXISTS, "SupplementaryDataEnvelope1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
