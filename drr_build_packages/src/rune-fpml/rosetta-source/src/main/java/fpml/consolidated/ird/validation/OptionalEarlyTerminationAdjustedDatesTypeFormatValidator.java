package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.OptionalEarlyTerminationAdjustedDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionalEarlyTerminationAdjustedDatesTypeFormatValidator implements Validator<OptionalEarlyTerminationAdjustedDates> {

	private List<ComparisonResult> getComparisonResults(OptionalEarlyTerminationAdjustedDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionalEarlyTerminationAdjustedDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionalEarlyTerminationAdjustedDates", ValidationResult.ValidationType.TYPE_FORMAT, "OptionalEarlyTerminationAdjustedDates", path, "", res.getError());
				}
				return success("OptionalEarlyTerminationAdjustedDates", ValidationResult.ValidationType.TYPE_FORMAT, "OptionalEarlyTerminationAdjustedDates", path, "");
			})
			.collect(toList());
	}

}
