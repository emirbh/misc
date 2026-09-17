package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.VoteDecisionEnum;
import fpml.consolidated.loan.ApprovalVoteDecision;
import fpml.consolidated.loan.DocumentVoteDecisionType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApprovalVoteDecisionOnlyExistsValidator implements ValidatorWithArg<ApprovalVoteDecision, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApprovalVoteDecision> ValidationResult<ApprovalVoteDecision> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("voteDecision", ExistenceChecker.isSet((VoteDecisionEnum) o.getVoteDecision()))
				.put("documentVoteDecision", ExistenceChecker.isSet((DocumentVoteDecisionType) o.getDocumentVoteDecision()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApprovalVoteDecision", ValidationResult.ValidationType.ONLY_EXISTS, "ApprovalVoteDecision", path, "");
		}
		return failure("ApprovalVoteDecision", ValidationResult.ValidationType.ONLY_EXISTS, "ApprovalVoteDecision", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
