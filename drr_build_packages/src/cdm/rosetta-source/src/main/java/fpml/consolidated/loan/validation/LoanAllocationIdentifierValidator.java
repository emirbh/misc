package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationIdentifier;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationIdentifierValidator implements Validator<LoanAllocationIdentifier> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuer", (IssuerId) o.getIssuer() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanTradeReference", (LoanTradeReference) o.getLoanTradeReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationIdentifier", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationIdentifier", path, "", res.getError());
				}
				return success("LoanAllocationIdentifier", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationIdentifier", path, "");
			})
			.collect(toList());
	}

}
