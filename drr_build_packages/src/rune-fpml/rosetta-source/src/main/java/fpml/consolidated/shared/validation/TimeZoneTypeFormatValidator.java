package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.TimeZone;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TimeZoneTypeFormatValidator implements Validator<TimeZone> {

	private List<ComparisonResult> getComparisonResults(TimeZone o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TimeZone o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TimeZone", ValidationResult.ValidationType.TYPE_FORMAT, "TimeZone", path, "", res.getError());
				}
				return success("TimeZone", ValidationResult.ValidationType.TYPE_FORMAT, "TimeZone", path, "");
			})
			.collect(toList());
	}

}
