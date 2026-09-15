package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetAccumulationRegion;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetAccumulationRegionValidator implements Validator<FxTargetAccumulationRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetAccumulationRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("upperBound", (FxTargetRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (FxTargetRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetAccumulationRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetAccumulationRegion", ValidationResult.ValidationType.CARDINALITY, "FxTargetAccumulationRegion", path, "", res.getError());
				}
				return success("FxTargetAccumulationRegion", ValidationResult.ValidationType.CARDINALITY, "FxTargetAccumulationRegion", path, "");
			})
			.collect(toList());
	}

}
