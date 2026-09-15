package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BermudaExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BermudaExerciseTypeFormatValidator implements Validator<BermudaExercise> {

	private List<ComparisonResult> getComparisonResults(BermudaExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BermudaExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BermudaExercise", ValidationResult.ValidationType.TYPE_FORMAT, "BermudaExercise", path, "", res.getError());
				}
				return success("BermudaExercise", ValidationResult.ValidationType.TYPE_FORMAT, "BermudaExercise", path, "");
			})
			.collect(toList());
	}

}
