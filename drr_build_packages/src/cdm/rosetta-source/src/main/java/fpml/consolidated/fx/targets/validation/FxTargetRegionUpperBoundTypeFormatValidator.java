package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetRegionUpperBoundTypeFormatValidator implements Validator<FxTargetRegionUpperBound> {

	private List<ComparisonResult> getComparisonResults(FxTargetRegionUpperBound o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRegionUpperBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRegionUpperBound", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetRegionUpperBound", path, "", res.getError());
				}
				return success("FxTargetRegionUpperBound", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetRegionUpperBound", path, "");
			})
			.collect(toList());
	}

}
