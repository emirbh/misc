package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FxRegionUpperBoundDirectionEnum;
import fpml.consolidated.fx.targets.FxComplexBarrierBaseReference;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.fx.targets.FxLevelReference;
import fpml.consolidated.fx.targets.FxPivotReference;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetRegionUpperBoundValidator implements Validator<FxTargetRegionUpperBound> {

	private List<ComparisonResult> getComparisonResults(FxTargetRegionUpperBound o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (FxRegionUpperBoundDirectionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("level", (FxLevel) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeReference", (FxStrikeReference) o.getStrikeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pivotReference", (FxPivotReference) o.getPivotReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrierReference", (FxComplexBarrierBaseReference) o.getBarrierReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelReference", (FxLevelReference) o.getLevelReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRegionUpperBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRegionUpperBound", ValidationResult.ValidationType.CARDINALITY, "FxTargetRegionUpperBound", path, "", res.getError());
				}
				return success("FxTargetRegionUpperBound", ValidationResult.ValidationType.CARDINALITY, "FxTargetRegionUpperBound", path, "");
			})
			.collect(toList());
	}

}
