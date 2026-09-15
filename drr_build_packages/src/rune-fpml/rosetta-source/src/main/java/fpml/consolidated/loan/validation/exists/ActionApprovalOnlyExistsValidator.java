package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ActionApproval;
import fpml.consolidated.loan.ApprovalParties;
import fpml.consolidated.loan.VoteQuantity;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ActionApprovalOnlyExistsValidator implements ValidatorWithArg<ActionApproval, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ActionApproval> ValidationResult<ActionApproval> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("approvalRequirement", ExistenceChecker.isSet((VoteQuantity) o.getApprovalRequirement()))
				.put("approvalParties", ExistenceChecker.isSet((ApprovalParties) o.getApprovalParties()))
				.put("approvalDeadlineDate", ExistenceChecker.isSet((ZonedDateTime) o.getApprovalDeadlineDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ActionApproval", ValidationResult.ValidationType.ONLY_EXISTS, "ActionApproval", path, "");
		}
		return failure("ActionApproval", ValidationResult.ValidationType.ONLY_EXISTS, "ActionApproval", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
