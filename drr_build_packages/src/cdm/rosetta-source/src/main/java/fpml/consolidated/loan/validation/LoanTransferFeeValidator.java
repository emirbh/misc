package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LoanTransferFeePaidByEnum;
import fpml.consolidated.loan.BuyerSellerAmounts;
import fpml.consolidated.loan.LoanTransferFee;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTransferFeeValidator implements Validator<LoanTransferFee> {

	private List<ComparisonResult> getComparisonResults(LoanTransferFee o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paidBy", (LoanTransferFeePaidByEnum) o.getPaidBy() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalAmount", (NonNegativeMoney) o.getTotalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferFeeAmounts", (BuyerSellerAmounts) o.getTransferFeeAmounts() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTransferFee", ValidationResult.ValidationType.CARDINALITY, "LoanTransferFee", path, "", res.getError());
				}
				return success("LoanTransferFee", ValidationResult.ValidationType.CARDINALITY, "LoanTransferFee", path, "");
			})
			.collect(toList());
	}

}
