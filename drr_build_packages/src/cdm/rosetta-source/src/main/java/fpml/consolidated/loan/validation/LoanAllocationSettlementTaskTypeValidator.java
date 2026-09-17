package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationSettlementTaskType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationSettlementTaskTypeValidator implements Validator<LoanAllocationSettlementTaskType> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementTaskType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("allocationSettlementTaskTypeScheme", (String) o.getAllocationSettlementTaskTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementTaskType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementTaskType", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationSettlementTaskType", path, "", res.getError());
				}
				return success("LoanAllocationSettlementTaskType", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationSettlementTaskType", path, "");
			})
			.collect(toList());
	}

}
