package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ResetRelativeToEnum;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.ird.ResetDates;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.ResetFrequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResetDatesValidator implements Validator<ResetDates> {

	private List<ComparisonResult> getComparisonResults(ResetDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodDatesReference", (CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetRelativeTo", (ResetRelativeToEnum) o.getResetRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFixingDate", (RelativeDateOffset) o.getInitialFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingDates", (RelativeDateOffset) o.getFixingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateCutOffDaysOffset", (Offset) o.getRateCutOffDaysOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetFrequency", (ResetFrequency) o.getResetFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("resetDatesAdjustments", (BusinessDayAdjustments) o.getResetDatesAdjustments() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetDates", ValidationResult.ValidationType.CARDINALITY, "ResetDates", path, "", res.getError());
				}
				return success("ResetDates", ValidationResult.ValidationType.CARDINALITY, "ResetDates", path, "");
			})
			.collect(toList());
	}

}
