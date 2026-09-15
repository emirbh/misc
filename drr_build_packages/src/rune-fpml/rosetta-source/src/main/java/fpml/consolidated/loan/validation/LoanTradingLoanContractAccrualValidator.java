package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanTradingLoanContractAccrual;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingLoanContractAccrualValidator implements Validator<LoanTradingLoanContractAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingLoanContractAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanContractReference", (LoanContractReference) o.getLoanContractReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingLoanContractAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingLoanContractAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanTradingLoanContractAccrual", path, "", res.getError());
				}
				return success("LoanTradingLoanContractAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanTradingLoanContractAccrual", path, "");
			})
			.collect(toList());
	}

}
