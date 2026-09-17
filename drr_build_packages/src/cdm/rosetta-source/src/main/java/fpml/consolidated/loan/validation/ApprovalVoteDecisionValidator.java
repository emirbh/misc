package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.VoteDecisionEnum;
import fpml.consolidated.loan.ApprovalVoteDecision;
import fpml.consolidated.loan.DocumentVoteDecisionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalVoteDecisionValidator implements Validator<ApprovalVoteDecision> {

	private List<ComparisonResult> getComparisonResults(ApprovalVoteDecision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("voteDecision", (VoteDecisionEnum) o.getVoteDecision() != null ? 1 : 0, 1, 1), 
				checkCardinality("documentVoteDecision", (DocumentVoteDecisionType) o.getDocumentVoteDecision() != null ? 1 : 0, 0, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalVoteDecision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApprovalVoteDecision", ValidationResult.ValidationType.CARDINALITY, "ApprovalVoteDecision", path, "", res.getError());
				}
				return success("ApprovalVoteDecision", ValidationResult.ValidationType.CARDINALITY, "ApprovalVoteDecision", path, "");
			})
			.collect(toList());
	}

}
