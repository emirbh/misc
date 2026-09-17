package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationIdentifier;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.LoanAllocationSummary;
import fpml.consolidated.loan.LoanAllocationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNotificationChoice1Validator implements Validator<LoanAllocationNotificationChoice1> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNotificationChoice1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocationId", (LoanAllocationIdentifier) o.getAllocationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationSummary", (LoanAllocationSummary) o.getAllocationSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocation", (LoanAllocationType) o.getAllocation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNotificationChoice1", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotificationChoice1", path, "", res.getError());
				}
				return success("LoanAllocationNotificationChoice1", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotificationChoice1", path, "");
			})
			.collect(toList());
	}

}
