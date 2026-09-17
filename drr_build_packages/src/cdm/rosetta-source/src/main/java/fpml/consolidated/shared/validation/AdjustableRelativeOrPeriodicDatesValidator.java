package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.PeriodicDates;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableRelativeOrPeriodicDatesValidator implements Validator<AdjustableRelativeOrPeriodicDates> {

	private List<ComparisonResult> getComparisonResults(AdjustableRelativeOrPeriodicDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDates", (AdjustableDates) o.getAdjustableDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDateSequence", (RelativeDateSequence) o.getRelativeDateSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodicDates", (PeriodicDates) o.getPeriodicDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableRelativeOrPeriodicDates", ValidationResult.ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates", path, "", res.getError());
				}
				return success("AdjustableRelativeOrPeriodicDates", ValidationResult.ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates", path, "");
			})
			.collect(toList());
	}

}
