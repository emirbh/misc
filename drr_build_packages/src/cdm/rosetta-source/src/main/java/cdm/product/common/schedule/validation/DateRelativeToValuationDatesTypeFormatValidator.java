package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.DateRelativeToValuationDates;
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

public class DateRelativeToValuationDatesTypeFormatValidator implements Validator<DateRelativeToValuationDates> {

	private List<ComparisonResult> getComparisonResults(DateRelativeToValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DateRelativeToValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DateRelativeToValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "DateRelativeToValuationDates", path, "", res.getError());
				}
				return success("DateRelativeToValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "DateRelativeToValuationDates", path, "");
			})
			.collect(toList());
	}

}
