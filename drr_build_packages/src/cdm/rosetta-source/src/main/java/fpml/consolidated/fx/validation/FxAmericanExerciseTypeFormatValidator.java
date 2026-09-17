package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxAmericanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAmericanExerciseTypeFormatValidator implements Validator<FxAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(FxAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAmericanExercise", ValidationResult.ValidationType.TYPE_FORMAT, "FxAmericanExercise", path, "", res.getError());
				}
				return success("FxAmericanExercise", ValidationResult.ValidationType.TYPE_FORMAT, "FxAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
