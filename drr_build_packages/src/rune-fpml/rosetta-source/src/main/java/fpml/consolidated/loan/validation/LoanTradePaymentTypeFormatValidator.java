package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradePaymentTypeFormatValidator implements Validator<LoanTradePayment> {

	private List<ComparisonResult> getComparisonResults(LoanTradePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradePayment", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradePayment", path, "", res.getError());
				}
				return success("LoanTradePayment", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradePayment", path, "");
			})
			.collect(toList());
	}

}
