package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxPerformanceFloatingLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxPerformanceFloatingLegTypeFormatValidator implements Validator<FxPerformanceFloatingLeg> {

	private List<ComparisonResult> getComparisonResults(FxPerformanceFloatingLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceFloatingLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPerformanceFloatingLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FxPerformanceFloatingLeg", path, "", res.getError());
				}
				return success("FxPerformanceFloatingLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FxPerformanceFloatingLeg", path, "");
			})
			.collect(toList());
	}

}
