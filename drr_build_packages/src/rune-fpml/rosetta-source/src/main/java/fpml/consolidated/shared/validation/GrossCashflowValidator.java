package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.CashflowId;
import fpml.consolidated.shared.CashflowType;
import fpml.consolidated.shared.GrossCashflow;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PartyTradeIdentifierReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GrossCashflowValidator implements Validator<GrossCashflow> {

	private List<ComparisonResult> getComparisonResults(GrossCashflow o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashflowId", (CashflowId) o.getCashflowId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyTradeIdentifierReference", (PartyTradeIdentifierReference) o.getPartyTradeIdentifierReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflowAmount", (Money) o.getCashflowAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflowType", (CashflowType) o.getCashflowType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GrossCashflow o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GrossCashflow", ValidationResult.ValidationType.CARDINALITY, "GrossCashflow", path, "", res.getError());
				}
				return success("GrossCashflow", ValidationResult.ValidationType.CARDINALITY, "GrossCashflow", path, "");
			})
			.collect(toList());
	}

}
