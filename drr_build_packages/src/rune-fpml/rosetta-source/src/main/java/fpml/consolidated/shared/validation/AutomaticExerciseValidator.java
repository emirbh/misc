package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AutomaticExercise;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AutomaticExerciseValidator implements Validator<AutomaticExercise> {

	private List<ComparisonResult> getComparisonResults(AutomaticExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("thresholdRate", (BigDecimal) o.getThresholdRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AutomaticExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AutomaticExercise", ValidationResult.ValidationType.CARDINALITY, "AutomaticExercise", path, "", res.getError());
				}
				return success("AutomaticExercise", ValidationResult.ValidationType.CARDINALITY, "AutomaticExercise", path, "");
			})
			.collect(toList());
	}

}
