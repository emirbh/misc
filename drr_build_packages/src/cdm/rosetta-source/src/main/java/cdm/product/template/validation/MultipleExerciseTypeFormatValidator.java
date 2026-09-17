package cdm.product.template.validation;

import cdm.product.template.MultipleExercise;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class MultipleExerciseTypeFormatValidator implements Validator<MultipleExercise> {

	private List<ComparisonResult> getComparisonResults(MultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("minimumNumberOfOptions", o.getMinimumNumberOfOptions(), empty(), of(0), empty(), empty()), 
				checkNumber("maximumNumberOfOptions", o.getMaximumNumberOfOptions(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultipleExercise", ValidationResult.ValidationType.TYPE_FORMAT, "MultipleExercise", path, "", res.getError());
				}
				return success("MultipleExercise", ValidationResult.ValidationType.TYPE_FORMAT, "MultipleExercise", path, "");
			})
			.collect(toList());
	}

}
