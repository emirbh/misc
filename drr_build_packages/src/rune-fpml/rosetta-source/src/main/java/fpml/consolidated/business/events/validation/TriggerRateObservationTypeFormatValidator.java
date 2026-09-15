package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TriggerRateObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TriggerRateObservationTypeFormatValidator implements Validator<TriggerRateObservation> {

	private List<ComparisonResult> getComparisonResults(TriggerRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerRateObservation", ValidationResult.ValidationType.TYPE_FORMAT, "TriggerRateObservation", path, "", res.getError());
				}
				return success("TriggerRateObservation", ValidationResult.ValidationType.TYPE_FORMAT, "TriggerRateObservation", path, "");
			})
			.collect(toList());
	}

}
