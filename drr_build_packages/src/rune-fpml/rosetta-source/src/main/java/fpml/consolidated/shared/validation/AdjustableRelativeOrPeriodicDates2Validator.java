package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import fpml.consolidated.shared.PeriodicDates;
import fpml.consolidated.shared.RelativeDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableRelativeOrPeriodicDates2Validator implements Validator<AdjustableRelativeOrPeriodicDates2> {

	private List<ComparisonResult> getComparisonResults(AdjustableRelativeOrPeriodicDates2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDates", (AdjustableDates) o.getAdjustableDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDates", (RelativeDates) o.getRelativeDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodicDates", (PeriodicDates) o.getPeriodicDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableRelativeOrPeriodicDates2", ValidationResult.ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates2", path, "", res.getError());
				}
				return success("AdjustableRelativeOrPeriodicDates2", ValidationResult.ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates2", path, "");
			})
			.collect(toList());
	}

}
