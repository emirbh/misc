package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DueDateAdjustment;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetails;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetailsChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationDateTriggerDetailsOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationDateTriggerDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationDateTriggerDetails> ValidationResult<LoanCovenantObligationDateTriggerDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("loanCovenantObligationDateTriggerDetailsChoice", ExistenceChecker.isSet((List<? extends LoanCovenantObligationDateTriggerDetailsChoice>) o.getLoanCovenantObligationDateTriggerDetailsChoice()))
				.put("dueDateAdjustment", ExistenceChecker.isSet((DueDateAdjustment) o.getDueDateAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationDateTriggerDetails", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationDateTriggerDetails", path, "");
		}
		return failure("LoanCovenantObligationDateTriggerDetails", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationDateTriggerDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
