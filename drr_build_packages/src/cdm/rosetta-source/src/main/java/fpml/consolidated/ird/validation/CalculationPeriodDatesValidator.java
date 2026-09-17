package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.StubPeriodTypeEnum;
import fpml.consolidated.ird.CalculationPeriodDates;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationPeriodDatesValidator implements Validator<CalculationPeriodDates> {

	private List<ComparisonResult> getComparisonResults(CalculationPeriodDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeEffectiveDate", (AdjustedRelativeDateOffset) o.getRelativeEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeTerminationDate", (RelativeDateOffset) o.getRelativeTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodDatesAdjustments", (BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPeriodStartDate", (AdjustableDate) o.getFirstPeriodStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstRegularPeriodStartDate", (ZonedDateTime) o.getFirstRegularPeriodStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstCompoundingPeriodEndDate", (ZonedDateTime) o.getFirstCompoundingPeriodEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastRegularPeriodEndDate", (ZonedDateTime) o.getLastRegularPeriodEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("stubPeriodType", (StubPeriodTypeEnum) o.getStubPeriodType() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodFrequency", (CalculationPeriodFrequency) o.getCalculationPeriodFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationPeriodDates", ValidationResult.ValidationType.CARDINALITY, "CalculationPeriodDates", path, "", res.getError());
				}
				return success("CalculationPeriodDates", ValidationResult.ValidationType.CARDINALITY, "CalculationPeriodDates", path, "");
			})
			.collect(toList());
	}

}
