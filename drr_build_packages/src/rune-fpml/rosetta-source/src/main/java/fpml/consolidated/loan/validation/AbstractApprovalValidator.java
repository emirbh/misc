package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractApproval;
import fpml.consolidated.loan.ApprovalVotes;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractApprovalValidator implements Validator<AbstractApproval> {

	private List<ComparisonResult> getComparisonResults(AbstractApproval o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvalVotes", (ApprovalVotes) o.getApprovalVotes() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalApprovalDate", (ZonedDateTime) o.getFinalApprovalDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractApproval o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractApproval", ValidationResult.ValidationType.CARDINALITY, "AbstractApproval", path, "", res.getError());
				}
				return success("AbstractApproval", ValidationResult.ValidationType.CARDINALITY, "AbstractApproval", path, "");
			})
			.collect(toList());
	}

}
