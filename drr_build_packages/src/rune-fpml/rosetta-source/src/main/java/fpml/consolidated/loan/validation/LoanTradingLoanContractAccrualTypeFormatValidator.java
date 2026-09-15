package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradingLoanContractAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingLoanContractAccrualTypeFormatValidator implements Validator<LoanTradingLoanContractAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingLoanContractAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingLoanContractAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingLoanContractAccrual", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradingLoanContractAccrual", path, "", res.getError());
				}
				return success("LoanTradingLoanContractAccrual", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradingLoanContractAccrual", path, "");
			})
			.collect(toList());
	}

}
