package cdm.product.template.validation;

import cdm.product.template.PartialExercise;
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

public class PartialExerciseTypeFormatValidator implements Validator<PartialExercise> {

	private List<ComparisonResult> getComparisonResults(PartialExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("minimumNumberOfOptions", o.getMinimumNumberOfOptions(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartialExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartialExercise", ValidationResult.ValidationType.TYPE_FORMAT, "PartialExercise", path, "", res.getError());
				}
				return success("PartialExercise", ValidationResult.ValidationType.TYPE_FORMAT, "PartialExercise", path, "");
			})
			.collect(toList());
	}

}
