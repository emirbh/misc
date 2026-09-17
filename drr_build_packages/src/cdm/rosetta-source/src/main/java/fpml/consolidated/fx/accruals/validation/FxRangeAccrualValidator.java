package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.FxAdjustedDateAndDateAdjustments;
import fpml.consolidated.fx.accruals.FxExpiryDate;
import fpml.consolidated.fx.accruals.FxRangeAccrual;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxRangeAccrualValidator implements Validator<FxRangeAccrual> {

	private List<ComparisonResult> getComparisonResults(FxRangeAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrual", (FxAccrual) o.getAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (FxExpiryDate) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirySchedule", (FxExpirySchedule) o.getExpirySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (FxAdjustedDateAndDateAdjustments) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementSchedule", (FxSettlementSchedule) o.getSettlementSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRangeAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRangeAccrual", ValidationResult.ValidationType.CARDINALITY, "FxRangeAccrual", path, "", res.getError());
				}
				return success("FxRangeAccrual", ValidationResult.ValidationType.CARDINALITY, "FxRangeAccrual", path, "");
			})
			.collect(toList());
	}

}
