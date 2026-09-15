package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.Adjustment;
import fpml.consolidated.loan.CommitmentChange;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommitmentChangeValidator implements Validator<CommitmentChange> {

	private List<ComparisonResult> getComparisonResults(CommitmentChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustment", (Adjustment) o.getAdjustment() != null ? 1 : 0, 1, 1), 
				checkCardinality("remaining", (MoneyWithParticipantShare) o.getRemaining() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommitmentChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommitmentChange", ValidationResult.ValidationType.CARDINALITY, "CommitmentChange", path, "", res.getError());
				}
				return success("CommitmentChange", ValidationResult.ValidationType.CARDINALITY, "CommitmentChange", path, "");
			})
			.collect(toList());
	}

}
