package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ErrorOnlyExistsValidator implements ValidatorWithArg<iso20022.dtcc.rds.harmonized.Error, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends iso20022.dtcc.rds.harmonized.Error> ValidationResult<iso20022.dtcc.rds.harmonized.Error> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("errorCode", ExistenceChecker.isSet((String) o.getErrorCode()))
				.put("errorReason", ExistenceChecker.isSet((String) o.getErrorReason()))
				.put("errorJurisdiction", ExistenceChecker.isSet((String) o.getErrorJurisdiction()))
				.put("errorFor", ExistenceChecker.isSet((String) o.getErrorFor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Error", ValidationResult.ValidationType.ONLY_EXISTS, "Error", path, "");
		}
		return failure("Error", ValidationResult.ValidationType.ONLY_EXISTS, "Error", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
