package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Approval;
import fpml.consolidated.doc.ApprovalId;
import fpml.consolidated.doc.ApprovalType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PersonId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApprovalOnlyExistsValidator implements ValidatorWithArg<Approval, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Approval> ValidationResult<Approval> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("type", ExistenceChecker.isSet((ApprovalType) o._getType()))
				.put("status", ExistenceChecker.isSet((String) o.getStatus()))
				.put("approver", ExistenceChecker.isSet((PersonId) o.getApprover()))
				.put("approvingPartyReference", ExistenceChecker.isSet((PartyReference) o.getApprovingPartyReference()))
				.put("approvedPartyReference", ExistenceChecker.isSet((PartyReference) o.getApprovedPartyReference()))
				.put("approvalId", ExistenceChecker.isSet((ApprovalId) o.getApprovalId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Approval", ValidationResult.ValidationType.ONLY_EXISTS, "Approval", path, "");
		}
		return failure("Approval", ValidationResult.ValidationType.ONLY_EXISTS, "Approval", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
