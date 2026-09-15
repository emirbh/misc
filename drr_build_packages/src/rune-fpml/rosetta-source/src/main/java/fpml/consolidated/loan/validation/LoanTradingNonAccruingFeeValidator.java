package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LoanTradingNonAccruingFeeTypeEnum;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanTradingNonAccruingFee;
import fpml.consolidated.loan.MiscFeeType;
import fpml.consolidated.loan.NonAccruingFeeTypeId;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingNonAccruingFeeValidator implements Validator<LoanTradingNonAccruingFee> {

	private List<ComparisonResult> getComparisonResults(LoanTradingNonAccruingFee o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonAccruingFeeTypeId", (NonAccruingFeeTypeId) o.getNonAccruingFeeTypeId() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonAccruingFeetype", (LoanTradingNonAccruingFeeTypeEnum) o.getNonAccruingFeetype() != null ? 1 : 0, 0, 1), 
				checkCardinality("miscFeeType", (MiscFeeType) o.getMiscFeeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanContractReference", (LoanContractReference) o.getLoanContractReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditReference", (LetterOfCreditReference) o.getLetterOfCreditReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingNonAccruingFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingNonAccruingFee", ValidationResult.ValidationType.CARDINALITY, "LoanTradingNonAccruingFee", path, "", res.getError());
				}
				return success("LoanTradingNonAccruingFee", ValidationResult.ValidationType.CARDINALITY, "LoanTradingNonAccruingFee", path, "");
			})
			.collect(toList());
	}

}
