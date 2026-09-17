package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetConstantPayoff;
import fpml.consolidated.fx.targets.FxTargetConstantPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetPhysicalSettlement;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetConstantPayoffRegionValidator implements Validator<FxTargetConstantPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetConstantPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (FxTargetRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (FxTargetRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoff", (FxTargetConstantPayoff) o.getPayoff() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (FxTargetPhysicalSettlement) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetConstantPayoffRegion", ValidationResult.ValidationType.CARDINALITY, "FxTargetConstantPayoffRegion", path, "", res.getError());
				}
				return success("FxTargetConstantPayoffRegion", ValidationResult.ValidationType.CARDINALITY, "FxTargetConstantPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
