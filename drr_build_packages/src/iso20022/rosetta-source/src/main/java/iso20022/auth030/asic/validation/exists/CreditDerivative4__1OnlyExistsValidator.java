package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.CreditDerivative4__1;
import iso20022.auth030.asic.TrancheIndicator3Choice__1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditDerivative4__1OnlyExistsValidator implements ValidatorWithArg<CreditDerivative4__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditDerivative4__1> ValidationResult<CreditDerivative4__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("indxFctr", ExistenceChecker.isSet((BigDecimal) o.getIndxFctr()))
				.put("trch", ExistenceChecker.isSet((TrancheIndicator3Choice__1) o.getTrch()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditDerivative4__1", ValidationResult.ValidationType.ONLY_EXISTS, "CreditDerivative4__1", path, "");
		}
		return failure("CreditDerivative4__1", ValidationResult.ValidationType.ONLY_EXISTS, "CreditDerivative4__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
