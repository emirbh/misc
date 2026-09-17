package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LoanTradingLetterOfCreditFeeTypeEnum;
import fpml.consolidated.loan.LcFeeTypeId;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanTradingLetterOfCreditAccrual;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingLetterOfCreditAccrualValidator implements Validator<LoanTradingLetterOfCreditAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingLetterOfCreditAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("lcFeeTypeId", (LcFeeTypeId) o.getLcFeeTypeId() != null ? 1 : 0, 1, 1), 
				checkCardinality("lcFeeType", (LoanTradingLetterOfCreditFeeTypeEnum) o.getLcFeeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditReference", (LetterOfCreditReference) o.getLetterOfCreditReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingLetterOfCreditAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingLetterOfCreditAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanTradingLetterOfCreditAccrual", path, "", res.getError());
				}
				return success("LoanTradingLetterOfCreditAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanTradingLetterOfCreditAccrual", path, "");
			})
			.collect(toList());
	}

}
