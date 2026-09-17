package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriod;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodPayoff;
import fpml.consolidated.fx.targets.FxSettlementPeriodBarrier;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodValidator implements Validator<FxAccrualSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expiryDate", (ZonedDateTime) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (ZonedDateTime) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("payoff", (List<? extends FxAccrualSettlementPeriodPayoff>) o.getPayoff() == null ? 0 : o.getPayoff().size(), 1, 0), 
				checkCardinality("accrualFactor", (BigDecimal) o.getAccrualFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrier", (FxSettlementPeriodBarrier) o.getBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualFixingDates", (SettlementPeriodFixingDates) o.getAccrualFixingDates() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriod", ValidationResult.ValidationType.CARDINALITY, "FxAccrualSettlementPeriod", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriod", ValidationResult.ValidationType.CARDINALITY, "FxAccrualSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
