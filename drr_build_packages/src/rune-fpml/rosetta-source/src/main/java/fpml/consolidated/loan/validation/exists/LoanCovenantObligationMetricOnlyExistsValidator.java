package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationMetric;
import fpml.consolidated.loan.LoanCovenantObligationMetricAdjustment;
import fpml.consolidated.loan.LoanCovenantObligationMetricCalculationDetails;
import fpml.consolidated.loan.LoanCovenantObligationMetricSequence;
import fpml.consolidated.loan.LoanCovenantObligationMetricType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationMetricOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationMetric, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationMetric> ValidationResult<LoanCovenantObligationMetric> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("loanCovenantObligationMetricSequence", ExistenceChecker.isSet((List<? extends LoanCovenantObligationMetricSequence>) o.getLoanCovenantObligationMetricSequence()))
				.put("metricType", ExistenceChecker.isSet((LoanCovenantObligationMetricType) o.getMetricType()))
				.put("metricAdjustment", ExistenceChecker.isSet((LoanCovenantObligationMetricAdjustment) o.getMetricAdjustment()))
				.put("calculationDetails", ExistenceChecker.isSet((LoanCovenantObligationMetricCalculationDetails) o.getCalculationDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationMetric", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationMetric", path, "");
		}
		return failure("LoanCovenantObligationMetric", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationMetric", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
