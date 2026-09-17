package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.LoanAllocationNoSettlePeriod;
import fpml.consolidated.loan.LoanAllocationReference;
import fpml.consolidated.loan.LoanAllocationSettlementDateAvailability;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.DateList;
import fpml.consolidated.shared.PartyReference;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationSettlementDateAvailabilityOnlyExistsValidator implements ValidatorWithArg<LoanAllocationSettlementDateAvailability, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationSettlementDateAvailability> ValidationResult<LoanAllocationSettlementDateAvailability> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((ParentEventIdentifier) o.getParentEventIdentifier()))
				.put("previousEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getPreviousEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderPartyReference", ExistenceChecker.isSet((PartyReference) o.getLenderPartyReference()))
				.put("cashPayable", ExistenceChecker.isSet((CashPayable) o.getCashPayable()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("allocationReference", ExistenceChecker.isSet((LoanAllocationReference) o.getAllocationReference()))
				.put("specificDates", ExistenceChecker.isSet((DateList) o.getSpecificDates()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("onOrAfterDate", ExistenceChecker.isSet((ZonedDateTime) o.getOnOrAfterDate()))
				.put("leadDays", ExistenceChecker.isSet((Integer) o.getLeadDays()))
				.put("cutOffTime", ExistenceChecker.isSet((LocalTime) o.getCutOffTime()))
				.put("noSettlePeriod", ExistenceChecker.isSet((List<? extends LoanAllocationNoSettlePeriod>) o.getNoSettlePeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationSettlementDateAvailability", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationSettlementDateAvailability", path, "");
		}
		return failure("LoanAllocationSettlementDateAvailability", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationSettlementDateAvailability", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
