package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanAllocationEvent;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.LoanAllocationSettlementTask;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationNotificationChoice0OnlyExistsValidator implements ValidatorWithArg<LoanAllocationNotificationChoice0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationNotificationChoice0> ValidationResult<LoanAllocationNotificationChoice0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("loanAllocationEventGroup", ExistenceChecker.isSet((AbstractLoanAllocationEvent) o.getLoanAllocationEventGroup()))
				.put("settlementTask", ExistenceChecker.isSet((LoanAllocationSettlementTask) o.getSettlementTask()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationNotificationChoice0", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationNotificationChoice0", path, "");
		}
		return failure("LoanAllocationNotificationChoice0", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationNotificationChoice0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
