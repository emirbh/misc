package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ExtensionEvent;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExtensionEventValidator implements Validator<ExtensionEvent> {

	private List<ComparisonResult> getComparisonResults(ExtensionEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedExerciseDate", (ZonedDateTime) o.getAdjustedExerciseDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedExtendedTerminationDate", (ZonedDateTime) o.getAdjustedExtendedTerminationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtensionEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExtensionEvent", ValidationResult.ValidationType.CARDINALITY, "ExtensionEvent", path, "", res.getError());
				}
				return success("ExtensionEvent", ValidationResult.ValidationType.CARDINALITY, "ExtensionEvent", path, "");
			})
			.collect(toList());
	}

}
