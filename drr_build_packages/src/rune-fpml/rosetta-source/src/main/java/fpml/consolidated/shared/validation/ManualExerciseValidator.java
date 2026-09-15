package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.ManualExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ManualExerciseValidator implements Validator<ManualExercise> {

	private List<ComparisonResult> getComparisonResults(ManualExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseNotice", (ExerciseNotice) o.getExerciseNotice() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackExercise", (Boolean) o.getFallbackExercise() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ManualExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ManualExercise", ValidationResult.ValidationType.CARDINALITY, "ManualExercise", path, "", res.getError());
				}
				return success("ManualExercise", ValidationResult.ValidationType.CARDINALITY, "ManualExercise", path, "");
			})
			.collect(toList());
	}

}
