package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalVotes;
import fpml.consolidated.loan.LoanLegalActionApprovalStatus;
import fpml.consolidated.loan.LoanLegalActionApprovalStatusType;
import fpml.consolidated.loan.LoanLegalActionReference;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionApprovalStatusOnlyExistsValidator implements ValidatorWithArg<LoanLegalActionApprovalStatus, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionApprovalStatus> ValidationResult<LoanLegalActionApprovalStatus> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("approvalVotes", ExistenceChecker.isSet((ApprovalVotes) o.getApprovalVotes()))
				.put("finalApprovalDate", ExistenceChecker.isSet((ZonedDateTime) o.getFinalApprovalDate()))
				.put("legalActionReference", ExistenceChecker.isSet((LoanLegalActionReference) o.getLegalActionReference()))
				.put("type", ExistenceChecker.isSet((LoanLegalActionApprovalStatusType) o._getType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionApprovalStatus", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionApprovalStatus", path, "");
		}
		return failure("LoanLegalActionApprovalStatus", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionApprovalStatus", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
