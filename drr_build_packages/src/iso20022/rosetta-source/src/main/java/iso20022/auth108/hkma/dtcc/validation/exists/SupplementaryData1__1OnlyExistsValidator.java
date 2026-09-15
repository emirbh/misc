package iso20022.auth108.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.SupplementaryData1__1;
import iso20022.auth108.hkma.dtcc.SupplementaryDataEnvelope1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SupplementaryData1__1OnlyExistsValidator implements ValidatorWithArg<SupplementaryData1__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SupplementaryData1__1> ValidationResult<SupplementaryData1__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("envlp", ExistenceChecker.isSet((SupplementaryDataEnvelope1) o.getEnvlp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SupplementaryData1__1", ValidationResult.ValidationType.ONLY_EXISTS, "SupplementaryData1__1", path, "");
		}
		return failure("SupplementaryData1__1", ValidationResult.ValidationType.ONLY_EXISTS, "SupplementaryData1__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
