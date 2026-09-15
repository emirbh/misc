package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDatesReference;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import fpml.consolidated.fpmlenum.ResetRelativeToEnum;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.ResetFrequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestLegResetDatesValidator implements Validator<InterestLegResetDates> {

	private List<ComparisonResult> getComparisonResults(InterestLegResetDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", (InterestLegCalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetRelativeTo", (ResetRelativeToEnum) o.getResetRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetFrequency", (ResetFrequency) o.getResetFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFixingDate", (RelativeDateOffset) o.getInitialFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingDates", (AdjustableDatesOrRelativeDateOffset) o.getFixingDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegResetDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLegResetDates", ValidationResult.ValidationType.CARDINALITY, "InterestLegResetDates", path, "", res.getError());
				}
				return success("InterestLegResetDates", ValidationResult.ValidationType.CARDINALITY, "InterestLegResetDates", path, "");
			})
			.collect(toList());
	}

}
