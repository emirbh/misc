package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFlexibleForwardExecutionPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardExecutionPeriodTypeFormatValidator implements Validator<FxFlexibleForwardExecutionPeriod> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForwardExecutionPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForwardExecutionPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForwardExecutionPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "FxFlexibleForwardExecutionPeriod", path, "", res.getError());
				}
				return success("FxFlexibleForwardExecutionPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "FxFlexibleForwardExecutionPeriod", path, "");
			})
			.collect(toList());
	}

}
