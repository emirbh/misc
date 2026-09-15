package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityMultipleExercise;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityMultipleExerciseValidator implements Validator<EquityMultipleExercise> {

	private List<ComparisonResult> getComparisonResults(EquityMultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("integralMultipleExercise", (BigDecimal) o.getIntegralMultipleExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumNumberOfOptions", (BigDecimal) o.getMinimumNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumNumberOfOptions", (BigDecimal) o.getMaximumNumberOfOptions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityMultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityMultipleExercise", ValidationResult.ValidationType.CARDINALITY, "EquityMultipleExercise", path, "", res.getError());
				}
				return success("EquityMultipleExercise", ValidationResult.ValidationType.CARDINALITY, "EquityMultipleExercise", path, "");
			})
			.collect(toList());
	}

}
