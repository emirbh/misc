package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxAverageRateObservationSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAverageRateObservationScheduleTypeFormatValidator implements Validator<FxAverageRateObservationSchedule> {

	private List<ComparisonResult> getComparisonResults(FxAverageRateObservationSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageRateObservationSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageRateObservationSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "FxAverageRateObservationSchedule", path, "", res.getError());
				}
				return success("FxAverageRateObservationSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "FxAverageRateObservationSchedule", path, "");
			})
			.collect(toList());
	}

}
