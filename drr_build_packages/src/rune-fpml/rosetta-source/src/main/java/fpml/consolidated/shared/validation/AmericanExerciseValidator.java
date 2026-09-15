package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.AmericanExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.ExerciseFeeSchedule;
import fpml.consolidated.shared.MultipleExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AmericanExerciseValidator implements Validator<AmericanExercise> {

	private List<ComparisonResult> getComparisonResults(AmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("relevantUnderlyingDate", (AdjustableOrRelativeDates) o.getRelevantUnderlyingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestExerciseTime", (BusinessCenterTime) o.getEarliestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTime", (BusinessCenterTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("multipleExercise", (MultipleExercise) o.getMultipleExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseFeeSchedule", (ExerciseFeeSchedule) o.getExerciseFeeSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmericanExercise", ValidationResult.ValidationType.CARDINALITY, "AmericanExercise", path, "", res.getError());
				}
				return success("AmericanExercise", ValidationResult.ValidationType.CARDINALITY, "AmericanExercise", path, "");
			})
			.collect(toList());
	}

}
