package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.loan.Repayment;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RepaymentOnlyExistsValidator implements ValidatorWithArg<Repayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Repayment> ValidationResult<Repayment> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("loanContractReference", ExistenceChecker.isSet((LoanContractReference) o.getLoanContractReference()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("price", ExistenceChecker.isSet((BigDecimal) o.getPrice()))
				.put("refusalAllowed", ExistenceChecker.isSet((Boolean) o.getRefusalAllowed()))
				.put("borrowerMandatory", ExistenceChecker.isSet((Boolean) o.getBorrowerMandatory()))
				.put("scheduledRepayment", ExistenceChecker.isSet((Boolean) o.getScheduledRepayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Repayment", ValidationResult.ValidationType.ONLY_EXISTS, "Repayment", path, "");
		}
		return failure("Repayment", ValidationResult.ValidationType.ONLY_EXISTS, "Repayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
