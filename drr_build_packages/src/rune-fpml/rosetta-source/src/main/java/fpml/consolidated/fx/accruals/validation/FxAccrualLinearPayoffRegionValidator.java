package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.accruals.FxAccrualLinearPayoffRegion;
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxForwardStrikePrice;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualLinearPayoffRegionValidator implements Validator<FxAccrualLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangedCurrency1", (FxExchangedCurrency) o.getExchangedCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangedCurrency2", (FxExchangedCurrency) o.getExchangedCurrency2() != null ? 1 : 0, 1, 1), 
				checkCardinality("strike", (FxForwardStrikePrice) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterCurrencyAmount", (NonNegativeAmountSchedule) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrike", (FxAverageStrike) o.getAverageStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (FxAccrualRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (FxAccrualRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (FxAccrualLeverage) o.getLeverage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLinearPayoffRegion", ValidationResult.ValidationType.CARDINALITY, "FxAccrualLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxAccrualLinearPayoffRegion", ValidationResult.ValidationType.CARDINALITY, "FxAccrualLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
