package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxDisruptionFallbacks;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxDisruptionFallbacksTypeFormatValidator implements Validator<FxDisruptionFallbacks> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionFallbacks o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionFallbacks o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionFallbacks", ValidationResult.ValidationType.TYPE_FORMAT, "FxDisruptionFallbacks", path, "", res.getError());
				}
				return success("FxDisruptionFallbacks", ValidationResult.ValidationType.TYPE_FORMAT, "FxDisruptionFallbacks", path, "");
			})
			.collect(toList());
	}

}
