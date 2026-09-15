package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxMultipleExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxMultipleExerciseTypeFormatValidator implements Validator<FxMultipleExercise> {

	private List<ComparisonResult> getComparisonResults(FxMultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxMultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxMultipleExercise", ValidationResult.ValidationType.TYPE_FORMAT, "FxMultipleExercise", path, "", res.getError());
				}
				return success("FxMultipleExercise", ValidationResult.ValidationType.TYPE_FORMAT, "FxMultipleExercise", path, "");
			})
			.collect(toList());
	}

}
