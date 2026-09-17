package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualPayoffRegionReference;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodPayoff;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodPayoffValidator implements Validator<FxAccrualSettlementPeriodPayoff> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payoffRegionReference", (FxAccrualPayoffRegionReference) o.getPayoffRegionReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterCurrencyAmount", (BigDecimal) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrikeFixingDates", (SettlementPeriodFixingDates) o.getAverageStrikeFixingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageRateFixingDates", (SettlementPeriodFixingDates) o.getAverageRateFixingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (BigDecimal) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (BigDecimal) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (SettlementPeriodLeverage) o.getLeverage() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoffCap", (BigDecimal) o.getPayoffCap() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodPayoff", ValidationResult.ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoff", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodPayoff", ValidationResult.ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoff", path, "");
			})
			.collect(toList());
	}

}
