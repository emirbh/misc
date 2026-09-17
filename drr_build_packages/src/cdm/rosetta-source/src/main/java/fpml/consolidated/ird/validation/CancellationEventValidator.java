package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CancellationEvent;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CancellationEventValidator implements Validator<CancellationEvent> {

	private List<ComparisonResult> getComparisonResults(CancellationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedExerciseDate", (ZonedDateTime) o.getAdjustedExerciseDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedEarlyTerminationDate", (ZonedDateTime) o.getAdjustedEarlyTerminationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CancellationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CancellationEvent", ValidationResult.ValidationType.CARDINALITY, "CancellationEvent", path, "", res.getError());
				}
				return success("CancellationEvent", ValidationResult.ValidationType.CARDINALITY, "CancellationEvent", path, "");
			})
			.collect(toList());
	}

}
