package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxKnockoutCount;
import fpml.consolidated.fx.targets.FxKnockoutLevel;
import fpml.consolidated.fx.targets.FxTarget;
import fpml.consolidated.fx.targets.FxTargetAccumulationRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetValidator implements Validator<FxTarget> {

	private List<ComparisonResult> getComparisonResults(FxTarget o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("accumulationRegion", (List<? extends FxTargetAccumulationRegion>) o.getAccumulationRegion() == null ? 0 : o.getAccumulationRegion().size(), 1, 2), 
				checkCardinality("knockoutLevel", (FxKnockoutLevel) o.getKnockoutLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockoutCount", (FxKnockoutCount) o.getKnockoutCount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTarget o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTarget", ValidationResult.ValidationType.CARDINALITY, "FxTarget", path, "", res.getError());
				}
				return success("FxTarget", ValidationResult.ValidationType.CARDINALITY, "FxTarget", path, "");
			})
			.collect(toList());
	}

}
