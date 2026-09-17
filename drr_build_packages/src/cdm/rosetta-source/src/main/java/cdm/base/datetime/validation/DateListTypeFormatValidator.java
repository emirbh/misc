package cdm.base.datetime.validation;

import cdm.base.datetime.DateList;
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

public class DateListTypeFormatValidator implements Validator<DateList> {

	private List<ComparisonResult> getComparisonResults(DateList o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DateList o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DateList", ValidationResult.ValidationType.TYPE_FORMAT, "DateList", path, "", res.getError());
				}
				return success("DateList", ValidationResult.ValidationType.TYPE_FORMAT, "DateList", path, "");
			})
			.collect(toList());
	}

}
