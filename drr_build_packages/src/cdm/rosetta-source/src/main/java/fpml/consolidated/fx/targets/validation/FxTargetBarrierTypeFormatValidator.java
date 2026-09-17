package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetBarrier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetBarrierTypeFormatValidator implements Validator<FxTargetBarrier> {

	private List<ComparisonResult> getComparisonResults(FxTargetBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetBarrier", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetBarrier", path, "", res.getError());
				}
				return success("FxTargetBarrier", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetBarrier", path, "");
			})
			.collect(toList());
	}

}
