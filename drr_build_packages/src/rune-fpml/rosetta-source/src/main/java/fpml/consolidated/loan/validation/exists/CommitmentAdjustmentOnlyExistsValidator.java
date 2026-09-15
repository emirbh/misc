package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.Adjustment;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.CommitmentAdjustment;
import fpml.consolidated.loan.CommitmentSchedule;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommitmentAdjustmentOnlyExistsValidator implements ValidatorWithArg<CommitmentAdjustment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommitmentAdjustment> ValidationResult<CommitmentAdjustment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((ParentEventIdentifier) o.getParentEventIdentifier()))
				.put("previousEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getPreviousEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderPartyReference", ExistenceChecker.isSet((PartyReference) o.getLenderPartyReference()))
				.put("cashPayable", ExistenceChecker.isSet((CashPayable) o.getCashPayable()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("agentPartyReference", ExistenceChecker.isSet((PartyReference) o.getAgentPartyReference()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBorrowerPartyReference()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("legalActionReference", ExistenceChecker.isSet((LoanLegalActionReference) o.getLegalActionReference()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("refusalAllowed", ExistenceChecker.isSet((Boolean) o.getRefusalAllowed()))
				.put("scheduled", ExistenceChecker.isSet((Boolean) o.getScheduled()))
				.put("pik", ExistenceChecker.isSet((Boolean) o.getPik()))
				.put("facilityCommitment", ExistenceChecker.isSet((FacilityCommitment) o.getFacilityCommitment()))
				.put("adjustment", ExistenceChecker.isSet((Adjustment) o.getAdjustment()))
				.put("commitmentSchedule", ExistenceChecker.isSet((CommitmentSchedule) o.getCommitmentSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommitmentAdjustment", ValidationResult.ValidationType.ONLY_EXISTS, "CommitmentAdjustment", path, "");
		}
		return failure("CommitmentAdjustment", ValidationResult.ValidationType.ONLY_EXISTS, "CommitmentAdjustment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
