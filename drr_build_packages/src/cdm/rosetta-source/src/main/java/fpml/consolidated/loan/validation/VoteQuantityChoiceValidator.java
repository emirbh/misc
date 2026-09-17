package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.VoteQuantityChoice;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VoteQuantityChoiceValidator implements Validator<VoteQuantityChoice> {

	private List<ComparisonResult> getComparisonResults(VoteQuantityChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("voteCount", (Integer) o.getVoteCount() != null ? 1 : 0, 0, 1), 
				checkCardinality("votePercent", (BigDecimal) o.getVotePercent() != null ? 1 : 0, 0, 1), 
				checkCardinality("voteAmount", (NonNegativeMoney) o.getVoteAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VoteQuantityChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VoteQuantityChoice", ValidationResult.ValidationType.CARDINALITY, "VoteQuantityChoice", path, "", res.getError());
				}
				return success("VoteQuantityChoice", ValidationResult.ValidationType.CARDINALITY, "VoteQuantityChoice", path, "");
			})
			.collect(toList());
	}

}
