package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityAmericanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityAmericanExerciseTypeFormatValidator implements Validator<EquityAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(EquityAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityAmericanExercise", ValidationResult.ValidationType.TYPE_FORMAT, "EquityAmericanExercise", path, "", res.getError());
				}
				return success("EquityAmericanExercise", ValidationResult.ValidationType.TYPE_FORMAT, "EquityAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
