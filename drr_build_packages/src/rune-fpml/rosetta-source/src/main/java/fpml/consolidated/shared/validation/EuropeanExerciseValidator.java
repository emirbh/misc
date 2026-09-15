package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.EuropeanExercise;
import fpml.consolidated.shared.ExerciseFee;
import fpml.consolidated.shared.PartialExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EuropeanExerciseValidator implements Validator<EuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(EuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("relevantUnderlyingDate", (AdjustableOrRelativeDates) o.getRelevantUnderlyingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestExerciseTime", (BusinessCenterTime) o.getEarliestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("partialExercise", (PartialExercise) o.getPartialExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseFee", (ExerciseFee) o.getExerciseFee() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EuropeanExercise", ValidationResult.ValidationType.CARDINALITY, "EuropeanExercise", path, "", res.getError());
				}
				return success("EuropeanExercise", ValidationResult.ValidationType.CARDINALITY, "EuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
