package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.DateRange;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DateRangeValidator implements Validator<DateRange> {

	private List<ComparisonResult> getComparisonResults(DateRange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedFirstDate", (ZonedDateTime) o.getUnadjustedFirstDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedLastDate", (ZonedDateTime) o.getUnadjustedLastDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DateRange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DateRange", ValidationResult.ValidationType.CARDINALITY, "DateRange", path, "", res.getError());
				}
				return success("DateRange", ValidationResult.ValidationType.CARDINALITY, "DateRange", path, "");
			})
			.collect(toList());
	}

}
