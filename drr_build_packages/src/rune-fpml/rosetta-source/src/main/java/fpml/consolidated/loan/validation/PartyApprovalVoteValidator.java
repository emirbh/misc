package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalVoteDecision;
import fpml.consolidated.loan.PartyApprovalVote;
import fpml.consolidated.loan.VoteQuantity;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyApprovalVoteValidator implements Validator<PartyApprovalVote> {

	private List<ComparisonResult> getComparisonResults(PartyApprovalVote o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("votePartyReference", (PartyReference) o.getVotePartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("voteQuantity", (VoteQuantity) o.getVoteQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("vote", (ApprovalVoteDecision) o.getVote() != null ? 1 : 0, 1, 1), 
				checkCardinality("voteDate", (ZonedDateTime) o.getVoteDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyApprovalVote o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyApprovalVote", ValidationResult.ValidationType.CARDINALITY, "PartyApprovalVote", path, "", res.getError());
				}
				return success("PartyApprovalVote", ValidationResult.ValidationType.CARDINALITY, "PartyApprovalVote", path, "");
			})
			.collect(toList());
	}

}
