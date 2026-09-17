package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ResetCalculationPeriod;
import fpml.consolidated.shared.DayCountFraction;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResetCalculationPeriodValidator implements Validator<ResetCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(ResetCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("adjustedStartDate", (ZonedDateTime) o.getAdjustedStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedEndDate", (ZonedDateTime) o.getAdjustedEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfDays", (Integer) o.getNumberOfDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountYearFraction", (BigDecimal) o.getDayCountYearFraction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetCalculationPeriod", ValidationResult.ValidationType.CARDINALITY, "ResetCalculationPeriod", path, "", res.getError());
				}
				return success("ResetCalculationPeriod", ValidationResult.ValidationType.CARDINALITY, "ResetCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
