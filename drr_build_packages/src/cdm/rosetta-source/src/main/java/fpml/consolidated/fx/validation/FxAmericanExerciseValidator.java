package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.CutName;
import fpml.consolidated.fx.FxAmericanExercise;
import fpml.consolidated.fx.FxMultipleExercise;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAmericanExerciseValidator implements Validator<FxAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(FxAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (ZonedDateTime) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryTime", (BusinessCenterTime) o.getExpiryTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("cutName", (CutName) o.getCutName() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestValueDate", (ZonedDateTime) o.getLatestValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("multipleExercise", (FxMultipleExercise) o.getMultipleExercise() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAmericanExercise", ValidationResult.ValidationType.CARDINALITY, "FxAmericanExercise", path, "", res.getError());
				}
				return success("FxAmericanExercise", ValidationResult.ValidationType.CARDINALITY, "FxAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
