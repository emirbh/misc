package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.fx.targets.FxStrike;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetLinearPayoffRegionValidator implements Validator<FxTargetLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangedCurrency1", (FxExchangedCurrency) o.getExchangedCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangedCurrency2", (FxExchangedCurrency) o.getExchangedCurrency2() != null ? 1 : 0, 1, 1), 
				checkCardinality("strike", (FxStrike) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (NonNegativeAmountSchedule) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (FxTargetRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (FxTargetRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (FxTargetLeverage) o.getLeverage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLinearPayoffRegion", ValidationResult.ValidationType.CARDINALITY, "FxTargetLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxTargetLinearPayoffRegion", ValidationResult.ValidationType.CARDINALITY, "FxTargetLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
