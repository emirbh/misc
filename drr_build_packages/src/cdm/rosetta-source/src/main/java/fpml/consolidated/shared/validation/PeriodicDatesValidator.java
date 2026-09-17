package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import fpml.consolidated.shared.PeriodicDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PeriodicDatesValidator implements Validator<PeriodicDates> {

	private List<ComparisonResult> getComparisonResults(PeriodicDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationStartDate", (AdjustableOrRelativeDate) o.getCalculationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationEndDate", (AdjustableOrRelativeDate) o.getCalculationEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodFrequency", (CalculationPeriodFrequency) o.getCalculationPeriodFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodDatesAdjustments", (BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodicDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodicDates", ValidationResult.ValidationType.CARDINALITY, "PeriodicDates", path, "", res.getError());
				}
				return success("PeriodicDates", ValidationResult.ValidationType.CARDINALITY, "PeriodicDates", path, "");
			})
			.collect(toList());
	}

}
