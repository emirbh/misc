package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.SecuritiesTransactionPrice5;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecuritiesTransactionPrice5OnlyExistsValidator implements ValidatorWithArg<SecuritiesTransactionPrice5, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecuritiesTransactionPrice5> ValidationResult<SecuritiesTransactionPrice5> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("val", ExistenceChecker.isSet((BigDecimal) o.getVal()))
				.put("tp", ExistenceChecker.isSet((String) o.getTp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecuritiesTransactionPrice5", ValidationResult.ValidationType.ONLY_EXISTS, "SecuritiesTransactionPrice5", path, "");
		}
		return failure("SecuritiesTransactionPrice5", ValidationResult.ValidationType.ONLY_EXISTS, "SecuritiesTransactionPrice5", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
