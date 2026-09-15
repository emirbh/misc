package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.NoTouchRateObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NoTouchRateObservationTypeFormatValidator implements Validator<NoTouchRateObservation> {

	private List<ComparisonResult> getComparisonResults(NoTouchRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchRateObservation", ValidationResult.ValidationType.TYPE_FORMAT, "NoTouchRateObservation", path, "", res.getError());
				}
				return success("NoTouchRateObservation", ValidationResult.ValidationType.TYPE_FORMAT, "NoTouchRateObservation", path, "");
			})
			.collect(toList());
	}

}
