package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDates;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestLegCalculationPeriodDatesValidator implements Validator<InterestLegCalculationPeriodDates> {

	private List<ComparisonResult> getComparisonResults(InterestLegCalculationPeriodDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestLegResetDates", (InterestLegResetDates) o.getInterestLegResetDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestLegPaymentDates", (AdjustableRelativeOrPeriodicDates2) o.getInterestLegPaymentDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegCalculationPeriodDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLegCalculationPeriodDates", ValidationResult.ValidationType.CARDINALITY, "InterestLegCalculationPeriodDates", path, "", res.getError());
				}
				return success("InterestLegCalculationPeriodDates", ValidationResult.ValidationType.CARDINALITY, "InterestLegCalculationPeriodDates", path, "");
			})
			.collect(toList());
	}

}
