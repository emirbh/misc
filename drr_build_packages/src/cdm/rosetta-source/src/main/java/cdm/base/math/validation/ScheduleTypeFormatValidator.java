package cdm.base.math.validation;

import cdm.base.math.Schedule;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ScheduleTypeFormatValidator implements Validator<Schedule> {

	private List<ComparisonResult> getComparisonResults(Schedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Schedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Schedule", ValidationResult.ValidationType.TYPE_FORMAT, "Schedule", path, "", res.getError());
				}
				return success("Schedule", ValidationResult.ValidationType.TYPE_FORMAT, "Schedule", path, "");
			})
			.collect(toList());
	}

}
