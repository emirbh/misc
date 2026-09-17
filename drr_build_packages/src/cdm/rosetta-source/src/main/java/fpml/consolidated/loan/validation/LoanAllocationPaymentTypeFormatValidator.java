package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationPaymentTypeFormatValidator implements Validator<LoanAllocationPayment> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationPayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationPayment", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationPayment", path, "", res.getError());
				}
				return success("LoanAllocationPayment", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationPayment", path, "");
			})
			.collect(toList());
	}

}
