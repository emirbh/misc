package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.LoanAllocationReference;
import fpml.consolidated.loan.LoanAllocationTransferFeeOwed;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationTransferFeeOwedOnlyExistsValidator implements ValidatorWithArg<LoanAllocationTransferFeeOwed, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationTransferFeeOwed> ValidationResult<LoanAllocationTransferFeeOwed> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((ParentEventIdentifier) o.getParentEventIdentifier()))
				.put("previousEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getPreviousEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderPartyReference", ExistenceChecker.isSet((PartyReference) o.getLenderPartyReference()))
				.put("cashPayable", ExistenceChecker.isSet((CashPayable) o.getCashPayable()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("allocationReference", ExistenceChecker.isSet((LoanAllocationReference) o.getAllocationReference()))
				.put("waivedFlag", ExistenceChecker.isSet((Boolean) o.getWaivedFlag()))
				.put("creditAgreementAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getCreditAgreementAmount()))
				.put("agentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getAgentAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationTransferFeeOwed", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationTransferFeeOwed", path, "");
		}
		return failure("LoanAllocationTransferFeeOwed", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationTransferFeeOwed", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
