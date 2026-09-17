package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradePayment;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInstruction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradePaymentValidator implements Validator<LoanTradePayment> {

	private List<ComparisonResult> getComparisonResults(LoanTradePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentAmount", (NonNegativeMoney) o.getPaymentAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (AdjustableDate) o.getPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeReference", (LoanTradeReference) o.getTradeReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("receiverSettlementInstruction", (SettlementInstruction) o.getReceiverSettlementInstruction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradePayment", ValidationResult.ValidationType.CARDINALITY, "LoanTradePayment", path, "", res.getError());
				}
				return success("LoanTradePayment", ValidationResult.ValidationType.CARDINALITY, "LoanTradePayment", path, "");
			})
			.collect(toList());
	}

}
