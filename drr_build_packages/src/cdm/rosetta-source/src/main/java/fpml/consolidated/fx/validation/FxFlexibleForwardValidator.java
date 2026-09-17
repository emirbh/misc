package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFlexibleForward;
import fpml.consolidated.fx.FxFlexibleForwardExecutionPeriod;
import fpml.consolidated.fx.FxFlexibleForwardRate;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardValidator implements Validator<FxFlexibleForward> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("putCurrency", (Currency) o.getPutCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("callCurrency", (Currency) o.getCallCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NonNegativeMoney) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("minimumExecutionAmount", (PositiveMoney) o.getMinimumExecutionAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementAmount", (NonNegativeMoney) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionPeriodDates", (FxFlexibleForwardExecutionPeriod) o.getExecutionPeriodDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("earliestExecutionTime", (BusinessCenterTime) o.getEarliestExecutionTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExecutionTime", (BusinessCenterTime) o.getLatestExecutionTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDateOffset", (RelativeDateOffset) o.getSettlementDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalSettlementDate", (ZonedDateTime) o.getFinalSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("forwardRate", (FxFlexibleForwardRate) o.getForwardRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalPayment", (Payment) o.getAdditionalPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForward", ValidationResult.ValidationType.CARDINALITY, "FxFlexibleForward", path, "", res.getError());
				}
				return success("FxFlexibleForward", ValidationResult.ValidationType.CARDINALITY, "FxFlexibleForward", path, "");
			})
			.collect(toList());
	}

}
