package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.FxAccrualForward;
import fpml.consolidated.fx.accruals.FxAccrualLinearPayoffRegion;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodSchedule;
import fpml.consolidated.fx.accruals.FxAdjustedDateAndDateAdjustments;
import fpml.consolidated.fx.accruals.FxAverageRate;
import fpml.consolidated.fx.accruals.FxExpiryDate;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualForwardValidator implements Validator<FxAccrualForward> {

	private List<ComparisonResult> getComparisonResults(FxAccrualForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrual", (FxAccrual) o.getAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (FxExpiryDate) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirySchedule", (FxExpirySchedule) o.getExpirySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (FxAdjustedDateAndDateAdjustments) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementSchedule", (FxSettlementSchedule) o.getSettlementSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("linearPayoffRegion", (List<? extends FxAccrualLinearPayoffRegion>) o.getLinearPayoffRegion() == null ? 0 : o.getLinearPayoffRegion().size(), 1, 0), 
				checkCardinality("averageRate", (FxAverageRate) o.getAverageRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodSchedule", (FxAccrualSettlementPeriodSchedule) o.getSettlementPeriodSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualForward", ValidationResult.ValidationType.CARDINALITY, "FxAccrualForward", path, "", res.getError());
				}
				return success("FxAccrualForward", ValidationResult.ValidationType.CARDINALITY, "FxAccrualForward", path, "");
			})
			.collect(toList());
	}

}
