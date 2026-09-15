package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.FirstPeriodStartDate;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FirstPeriodStartDateValidator implements Validator<FirstPeriodStartDate> {

	private List<ComparisonResult> getComparisonResults(FirstPeriodStartDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (ZonedDateTime) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FirstPeriodStartDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FirstPeriodStartDate", ValidationResult.ValidationType.CARDINALITY, "FirstPeriodStartDate", path, "", res.getError());
				}
				return success("FirstPeriodStartDate", ValidationResult.ValidationType.CARDINALITY, "FirstPeriodStartDate", path, "");
			})
			.collect(toList());
	}

}
