package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ActionApproval;
import fpml.consolidated.loan.ApprovalParties;
import fpml.consolidated.loan.VoteQuantity;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ActionApprovalValidator implements Validator<ActionApproval> {

	private List<ComparisonResult> getComparisonResults(ActionApproval o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("approvalRequirement", (VoteQuantity) o.getApprovalRequirement() != null ? 1 : 0, 1, 1), 
				checkCardinality("approvalParties", (ApprovalParties) o.getApprovalParties() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvalDeadlineDate", (ZonedDateTime) o.getApprovalDeadlineDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActionApproval o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActionApproval", ValidationResult.ValidationType.CARDINALITY, "ActionApproval", path, "", res.getError());
				}
				return success("ActionApproval", ValidationResult.ValidationType.CARDINALITY, "ActionApproval", path, "");
			})
			.collect(toList());
	}

}
