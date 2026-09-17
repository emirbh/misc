package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.ReturnSwapLegUnderlyer;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapLegUnderlyerValidator implements Validator<ReturnSwapLegUnderlyer> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapLegUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeDate", (AdjustableOrRelativeDate) o.getStrikeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementAmount", (Money) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapLegUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapLegUnderlyer", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapLegUnderlyer", path, "", res.getError());
				}
				return success("ReturnSwapLegUnderlyer", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapLegUnderlyer", path, "");
			})
			.collect(toList());
	}

}
