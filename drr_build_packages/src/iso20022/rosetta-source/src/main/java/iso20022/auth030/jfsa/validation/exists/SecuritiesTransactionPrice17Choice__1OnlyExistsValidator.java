package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.AmountAndDirection106__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecuritiesTransactionPrice17Choice__1OnlyExistsValidator implements ValidatorWithArg<SecuritiesTransactionPrice17Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecuritiesTransactionPrice17Choice__1> ValidationResult<SecuritiesTransactionPrice17Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mntryVal", ExistenceChecker.isSet((AmountAndDirection106__1) o.getMntryVal()))
				.put("dcml", ExistenceChecker.isSet((BigDecimal) o.getDcml()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecuritiesTransactionPrice17Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "SecuritiesTransactionPrice17Choice__1", path, "");
		}
		return failure("SecuritiesTransactionPrice17Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "SecuritiesTransactionPrice17Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
