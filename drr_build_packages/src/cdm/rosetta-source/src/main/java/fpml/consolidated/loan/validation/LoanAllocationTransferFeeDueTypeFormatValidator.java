package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationTransferFeeDue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class LoanAllocationTransferFeeDueTypeFormatValidator implements Validator<LoanAllocationTransferFeeDue> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeDue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeDue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeDue", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDue", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeDue", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDue", path, "");
			})
			.collect(toList());
	}

}
