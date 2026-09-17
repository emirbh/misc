package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationIdentifier;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.LoanAllocationSummary;
import fpml.consolidated.loan.LoanAllocationType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationNotificationChoice1OnlyExistsValidator implements ValidatorWithArg<LoanAllocationNotificationChoice1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationNotificationChoice1> ValidationResult<LoanAllocationNotificationChoice1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocationId", ExistenceChecker.isSet((LoanAllocationIdentifier) o.getAllocationId()))
				.put("allocationSummary", ExistenceChecker.isSet((LoanAllocationSummary) o.getAllocationSummary()))
				.put("allocation", ExistenceChecker.isSet((LoanAllocationType) o.getAllocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationNotificationChoice1", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationNotificationChoice1", path, "");
		}
		return failure("LoanAllocationNotificationChoice1", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationNotificationChoice1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
