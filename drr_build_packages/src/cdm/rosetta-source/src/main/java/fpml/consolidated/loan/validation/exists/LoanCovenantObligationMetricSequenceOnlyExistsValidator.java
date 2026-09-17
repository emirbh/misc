package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.LoanCovenantObligationMetricValueTypeEnum;
import fpml.consolidated.loan.LoanCovenantObligationMetricSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationMetricSequenceOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationMetricSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationMetricSequence> ValidationResult<LoanCovenantObligationMetricSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((BigDecimal) o.getValue()))
				.put("valueType", ExistenceChecker.isSet((LoanCovenantObligationMetricValueTypeEnum) o.getValueType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationMetricSequence", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationMetricSequence", path, "");
		}
		return failure("LoanCovenantObligationMetricSequence", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationMetricSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
