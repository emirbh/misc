package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.loan.DateAdjustmentType;
import fpml.consolidated.loan.DueDateAdjustment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DueDateAdjustmentValidator implements Validator<DueDateAdjustment> {

	private List<ComparisonResult> getComparisonResults(DueDateAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("numberOfDays", (Integer) o.getNumberOfDays() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustmentType", (DateAdjustmentType) o.getAdjustmentType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DueDateAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DueDateAdjustment", ValidationResult.ValidationType.CARDINALITY, "DueDateAdjustment", path, "", res.getError());
				}
				return success("DueDateAdjustment", ValidationResult.ValidationType.CARDINALITY, "DueDateAdjustment", path, "");
			})
			.collect(toList());
	}

}
