package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SharedAmericanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SharedAmericanExerciseTypeFormatValidator implements Validator<SharedAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(SharedAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SharedAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SharedAmericanExercise", ValidationResult.ValidationType.TYPE_FORMAT, "SharedAmericanExercise", path, "", res.getError());
				}
				return success("SharedAmericanExercise", ValidationResult.ValidationType.TYPE_FORMAT, "SharedAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
