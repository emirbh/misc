package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fx.targets.FxComplexBarrierBaseReference;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.fx.targets.FxLevelReference;
import fpml.consolidated.fx.targets.FxPivotReference;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetLeverageValidator implements Validator<FxTargetLeverage> {

	private List<ComparisonResult> getComparisonResults(FxTargetLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("level", (FxLevel) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeReference", (FxStrikeReference) o.getStrikeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pivotReference", (FxPivotReference) o.getPivotReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrierReference", (FxComplexBarrierBaseReference) o.getBarrierReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelReference", (FxLevelReference) o.getLevelReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("ratio", (Schedule) o.getRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLeverage", ValidationResult.ValidationType.CARDINALITY, "FxTargetLeverage", path, "", res.getError());
				}
				return success("FxTargetLeverage", ValidationResult.ValidationType.CARDINALITY, "FxTargetLeverage", path, "");
			})
			.collect(toList());
	}

}
