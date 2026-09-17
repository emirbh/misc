package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetPayoffRegionReference;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodPayoff;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetSettlementPeriodPayoffValidator implements Validator<FxTargetSettlementPeriodPayoff> {

	private List<ComparisonResult> getComparisonResults(FxTargetSettlementPeriodPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payoffRegionReference", (FxTargetPayoffRegionReference) o.getPayoffRegionReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (BigDecimal) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (BigDecimal) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (BigDecimal) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (SettlementPeriodLeverage) o.getLeverage() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoffCap", (BigDecimal) o.getPayoffCap() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetSettlementPeriodPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetSettlementPeriodPayoff", ValidationResult.ValidationType.CARDINALITY, "FxTargetSettlementPeriodPayoff", path, "", res.getError());
				}
				return success("FxTargetSettlementPeriodPayoff", ValidationResult.ValidationType.CARDINALITY, "FxTargetSettlementPeriodPayoff", path, "");
			})
			.collect(toList());
	}

}
