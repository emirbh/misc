package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.TimeDimension;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TimeDimensionValidator implements Validator<TimeDimension> {

	private List<ComparisonResult> getComparisonResults(TimeDimension o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenor", (Period) o.getTenor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TimeDimension o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TimeDimension", ValidationResult.ValidationType.CARDINALITY, "TimeDimension", path, "", res.getError());
				}
				return success("TimeDimension", ValidationResult.ValidationType.CARDINALITY, "TimeDimension", path, "");
			})
			.collect(toList());
	}

}
