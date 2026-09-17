package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetLinearPayoffRegionTypeFormatValidator implements Validator<FxTargetLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLinearPayoffRegion", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxTargetLinearPayoffRegion", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
