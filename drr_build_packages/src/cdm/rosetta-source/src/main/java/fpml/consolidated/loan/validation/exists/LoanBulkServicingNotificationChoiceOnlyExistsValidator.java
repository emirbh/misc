package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.AbstractLcEvent;
import fpml.consolidated.loan.AbstractLoanServicingEvent;
import fpml.consolidated.loan.LoanBulkServicingNotificationChoice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanBulkServicingNotificationChoiceOnlyExistsValidator implements ValidatorWithArg<LoanBulkServicingNotificationChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanBulkServicingNotificationChoice> ValidationResult<LoanBulkServicingNotificationChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityEventGroup", ExistenceChecker.isSet((AbstractFacilityEvent) o.getFacilityEventGroup()))
				.put("lcEventGroup", ExistenceChecker.isSet((AbstractLcEvent) o.getLcEventGroup()))
				.put("loanContractEventGroup", ExistenceChecker.isSet((AbstractLoanServicingEvent) o.getLoanContractEventGroup()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanBulkServicingNotificationChoice", ValidationResult.ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoice", path, "");
		}
		return failure("LoanBulkServicingNotificationChoice", ValidationResult.ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
