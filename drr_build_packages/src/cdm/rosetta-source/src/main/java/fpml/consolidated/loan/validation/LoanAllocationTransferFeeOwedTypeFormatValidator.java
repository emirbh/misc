package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationTransferFeeOwed;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class LoanAllocationTransferFeeOwedTypeFormatValidator implements Validator<LoanAllocationTransferFeeOwed> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeOwed o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeOwed o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeOwed", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeOwed", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeOwed", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeOwed", path, "");
			})
			.collect(toList());
	}

}
