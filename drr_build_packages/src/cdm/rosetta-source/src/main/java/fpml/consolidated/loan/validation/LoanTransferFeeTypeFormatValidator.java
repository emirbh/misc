package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTransferFee;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTransferFeeTypeFormatValidator implements Validator<LoanTransferFee> {

	private List<ComparisonResult> getComparisonResults(LoanTransferFee o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTransferFee", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTransferFee", path, "", res.getError());
				}
				return success("LoanTransferFee", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTransferFee", path, "");
			})
			.collect(toList());
	}

}
