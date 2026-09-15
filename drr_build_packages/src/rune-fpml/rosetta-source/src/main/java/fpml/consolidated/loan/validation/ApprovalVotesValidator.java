package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalVotes;
import fpml.consolidated.loan.VoteQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalVotesValidator implements Validator<ApprovalVotes> {

	private List<ComparisonResult> getComparisonResults(ApprovalVotes o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("forVotesQuantity", (VoteQuantity) o.getForVotesQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalVotes o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApprovalVotes", ValidationResult.ValidationType.CARDINALITY, "ApprovalVotes", path, "", res.getError());
				}
				return success("ApprovalVotes", ValidationResult.ValidationType.CARDINALITY, "ApprovalVotes", path, "");
			})
			.collect(toList());
	}

}
