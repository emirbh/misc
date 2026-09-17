package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MultipleExercise;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MultipleExerciseValidator implements Validator<MultipleExercise> {

	private List<ComparisonResult> getComparisonResults(MultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("integralMultipleAmount", (BigDecimal) o.getIntegralMultipleAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumNotionalAmount", (BigDecimal) o.getMinimumNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumNumberOfOptions", (BigDecimal) o.getMinimumNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumNotionalAmount", (BigDecimal) o.getMaximumNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumNumberOfOptions", (BigDecimal) o.getMaximumNumberOfOptions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultipleExercise", ValidationResult.ValidationType.CARDINALITY, "MultipleExercise", path, "", res.getError());
				}
				return success("MultipleExercise", ValidationResult.ValidationType.CARDINALITY, "MultipleExercise", path, "");
			})
			.collect(toList());
	}

}
