package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.BuyerSellerAmounts;
import fpml.consolidated.loan.LoanTradingCostOfCarry;
import fpml.consolidated.loan.LoanTradingCounterpartySettlementFundingFactors;
import fpml.consolidated.loan.LoanTradingDelayedCompensation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingCounterpartySettlementFundingFactorsValidator implements Validator<LoanTradingCounterpartySettlementFundingFactors> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCounterpartySettlementFundingFactors o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("delayedCompensation", (LoanTradingDelayedCompensation) o.getDelayedCompensation() != null ? 1 : 0, 0, 1), 
				checkCardinality("costOfCarry", (LoanTradingCostOfCarry) o.getCostOfCarry() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferFeeAmounts", (BuyerSellerAmounts) o.getTransferFeeAmounts() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCounterpartySettlementFundingFactors o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCounterpartySettlementFundingFactors", ValidationResult.ValidationType.CARDINALITY, "LoanTradingCounterpartySettlementFundingFactors", path, "", res.getError());
				}
				return success("LoanTradingCounterpartySettlementFundingFactors", ValidationResult.ValidationType.CARDINALITY, "LoanTradingCounterpartySettlementFundingFactors", path, "");
			})
			.collect(toList());
	}

}
