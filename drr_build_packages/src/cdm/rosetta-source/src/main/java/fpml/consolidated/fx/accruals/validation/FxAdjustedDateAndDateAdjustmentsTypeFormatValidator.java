package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAdjustedDateAndDateAdjustments;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAdjustedDateAndDateAdjustmentsTypeFormatValidator implements Validator<FxAdjustedDateAndDateAdjustments> {

	private List<ComparisonResult> getComparisonResults(FxAdjustedDateAndDateAdjustments o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdjustedDateAndDateAdjustments o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAdjustedDateAndDateAdjustments", ValidationResult.ValidationType.TYPE_FORMAT, "FxAdjustedDateAndDateAdjustments", path, "", res.getError());
				}
				return success("FxAdjustedDateAndDateAdjustments", ValidationResult.ValidationType.TYPE_FORMAT, "FxAdjustedDateAndDateAdjustments", path, "");
			})
			.collect(toList());
	}

}
