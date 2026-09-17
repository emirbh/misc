package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxStraddlePremium;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxStraddlePremiumValidator implements Validator<FxStraddlePremium> {

	private List<ComparisonResult> getComparisonResults(FxStraddlePremium o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDate", (AdjustableOrRelativeDate) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentCurrency", (IdentifiedCurrency) o.getPaymentCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementInformation", (SettlementInformation) o.getSettlementInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxStraddlePremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxStraddlePremium", ValidationResult.ValidationType.CARDINALITY, "FxStraddlePremium", path, "", res.getError());
				}
				return success("FxStraddlePremium", ValidationResult.ValidationType.CARDINALITY, "FxStraddlePremium", path, "");
			})
			.collect(toList());
	}

}
