package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ExercisePeriod;
import fpml.consolidated.shared.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExercisePeriodValidator implements Validator<ExercisePeriod> {

	private List<ComparisonResult> getComparisonResults(ExercisePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestExerciseDateTenor", (Period) o.getEarliestExerciseDateTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseFrequency", (Period) o.getExerciseFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExercisePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExercisePeriod", ValidationResult.ValidationType.CARDINALITY, "ExercisePeriod", path, "", res.getError());
				}
				return success("ExercisePeriod", ValidationResult.ValidationType.CARDINALITY, "ExercisePeriod", path, "");
			})
			.collect(toList());
	}

}
