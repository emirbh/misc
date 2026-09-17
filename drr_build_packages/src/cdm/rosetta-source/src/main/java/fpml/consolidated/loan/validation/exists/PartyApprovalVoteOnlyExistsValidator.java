package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalVoteDecision;
import fpml.consolidated.loan.PartyApprovalVote;
import fpml.consolidated.loan.VoteQuantity;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyApprovalVoteOnlyExistsValidator implements ValidatorWithArg<PartyApprovalVote, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyApprovalVote> ValidationResult<PartyApprovalVote> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("votePartyReference", ExistenceChecker.isSet((PartyReference) o.getVotePartyReference()))
				.put("voteQuantity", ExistenceChecker.isSet((VoteQuantity) o.getVoteQuantity()))
				.put("vote", ExistenceChecker.isSet((ApprovalVoteDecision) o.getVote()))
				.put("voteDate", ExistenceChecker.isSet((ZonedDateTime) o.getVoteDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyApprovalVote", ValidationResult.ValidationType.ONLY_EXISTS, "PartyApprovalVote", path, "");
		}
		return failure("PartyApprovalVote", ValidationResult.ValidationType.ONLY_EXISTS, "PartyApprovalVote", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
