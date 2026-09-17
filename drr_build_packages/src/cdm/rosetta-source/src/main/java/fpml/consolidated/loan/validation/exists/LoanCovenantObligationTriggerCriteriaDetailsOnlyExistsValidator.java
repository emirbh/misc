package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetails;
import fpml.consolidated.loan.LoanCovenantObligationHybridDetails;
import fpml.consolidated.loan.LoanCovenantObligationMetric;
import fpml.consolidated.loan.LoanCovenantObligationTriggerCriteriaDetails;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationTriggerCriteriaDetailsOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationTriggerCriteriaDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationTriggerCriteriaDetails> ValidationResult<LoanCovenantObligationTriggerCriteriaDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("date", ExistenceChecker.isSet((List<? extends LoanCovenantObligationDateTriggerDetails>) o.getDate()))
				.put("metric", ExistenceChecker.isSet((LoanCovenantObligationMetric) o.getMetric()))
				.put("hybridCriteria", ExistenceChecker.isSet((LoanCovenantObligationHybridDetails) o.getHybridCriteria()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationTriggerCriteriaDetails", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationTriggerCriteriaDetails", path, "");
		}
		return failure("LoanCovenantObligationTriggerCriteriaDetails", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationTriggerCriteriaDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
