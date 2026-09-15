package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.VoteQuantity;
import fpml.consolidated.loan.VoteQuantityChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VoteQuantityValidator implements Validator<VoteQuantity> {

	private List<ComparisonResult> getComparisonResults(VoteQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("voteQuantityChoice", (List<? extends VoteQuantityChoice>) o.getVoteQuantityChoice() == null ? 0 : o.getVoteQuantityChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VoteQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VoteQuantity", ValidationResult.ValidationType.CARDINALITY, "VoteQuantity", path, "", res.getError());
				}
				return success("VoteQuantity", ValidationResult.ValidationType.CARDINALITY, "VoteQuantity", path, "");
			})
			.collect(toList());
	}

}
