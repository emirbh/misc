package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ExerciseProcedure;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExerciseProcedureTypeFormatValidator implements Validator<ExerciseProcedure> {

	private List<ComparisonResult> getComparisonResults(ExerciseProcedure o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseProcedure", ValidationResult.ValidationType.TYPE_FORMAT, "ExerciseProcedure", path, "", res.getError());
				}
				return success("ExerciseProcedure", ValidationResult.ValidationType.TYPE_FORMAT, "ExerciseProcedure", path, "");
			})
			.collect(toList());
	}

}
