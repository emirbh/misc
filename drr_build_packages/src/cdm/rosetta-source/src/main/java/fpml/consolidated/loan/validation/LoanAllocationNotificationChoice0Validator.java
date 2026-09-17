package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractLoanAllocationEvent;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.LoanAllocationSettlementTask;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNotificationChoice0Validator implements Validator<LoanAllocationNotificationChoice0> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNotificationChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanAllocationEventGroup", (AbstractLoanAllocationEvent) o.getLoanAllocationEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementTask", (LoanAllocationSettlementTask) o.getSettlementTask() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotificationChoice0", path, "", res.getError());
				}
				return success("LoanAllocationNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotificationChoice0", path, "");
			})
			.collect(toList());
	}

}
