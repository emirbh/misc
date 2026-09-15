package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.CalendarSpread;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalendarSpreadTypeFormatValidator implements Validator<CalendarSpread> {

	private List<ComparisonResult> getComparisonResults(CalendarSpread o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalendarSpread o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalendarSpread", ValidationResult.ValidationType.TYPE_FORMAT, "CalendarSpread", path, "", res.getError());
				}
				return success("CalendarSpread", ValidationResult.ValidationType.TYPE_FORMAT, "CalendarSpread", path, "");
			})
			.collect(toList());
	}

}
