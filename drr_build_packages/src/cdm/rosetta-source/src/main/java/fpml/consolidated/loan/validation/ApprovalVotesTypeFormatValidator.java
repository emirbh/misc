package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalVotes;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalVotesTypeFormatValidator implements Validator<ApprovalVotes> {

	private List<ComparisonResult> getComparisonResults(ApprovalVotes o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalVotes o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApprovalVotes", ValidationResult.ValidationType.TYPE_FORMAT, "ApprovalVotes", path, "", res.getError());
				}
				return success("ApprovalVotes", ValidationResult.ValidationType.TYPE_FORMAT, "ApprovalVotes", path, "");
			})
			.collect(toList());
	}

}
