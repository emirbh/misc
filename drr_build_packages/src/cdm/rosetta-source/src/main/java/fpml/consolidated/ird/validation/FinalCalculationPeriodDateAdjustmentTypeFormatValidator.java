package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FinalCalculationPeriodDateAdjustment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinalCalculationPeriodDateAdjustmentTypeFormatValidator implements Validator<FinalCalculationPeriodDateAdjustment> {

	private List<ComparisonResult> getComparisonResults(FinalCalculationPeriodDateAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalCalculationPeriodDateAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinalCalculationPeriodDateAdjustment", ValidationResult.ValidationType.TYPE_FORMAT, "FinalCalculationPeriodDateAdjustment", path, "", res.getError());
				}
				return success("FinalCalculationPeriodDateAdjustment", ValidationResult.ValidationType.TYPE_FORMAT, "FinalCalculationPeriodDateAdjustment", path, "");
			})
			.collect(toList());
	}

}
