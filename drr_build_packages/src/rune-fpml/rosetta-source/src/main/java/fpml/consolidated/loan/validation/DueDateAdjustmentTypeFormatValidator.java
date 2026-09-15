package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DueDateAdjustment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class DueDateAdjustmentTypeFormatValidator implements Validator<DueDateAdjustment> {

	private List<ComparisonResult> getComparisonResults(DueDateAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("numberOfDays", o.getNumberOfDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DueDateAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DueDateAdjustment", ValidationResult.ValidationType.TYPE_FORMAT, "DueDateAdjustment", path, "", res.getError());
				}
				return success("DueDateAdjustment", ValidationResult.ValidationType.TYPE_FORMAT, "DueDateAdjustment", path, "");
			})
			.collect(toList());
	}

}
