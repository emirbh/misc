package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.DateTimeList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DateTimeListValidator implements Validator<DateTimeList> {

	private List<ComparisonResult> getComparisonResults(DateTimeList o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DateTimeList o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DateTimeList", ValidationResult.ValidationType.CARDINALITY, "DateTimeList", path, "", res.getError());
				}
				return success("DateTimeList", ValidationResult.ValidationType.CARDINALITY, "DateTimeList", path, "");
			})
			.collect(toList());
	}

}
