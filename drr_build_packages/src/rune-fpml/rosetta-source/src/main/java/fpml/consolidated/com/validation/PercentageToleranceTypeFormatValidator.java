package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.PercentageTolerance;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PercentageToleranceTypeFormatValidator implements Validator<PercentageTolerance> {

	private List<ComparisonResult> getComparisonResults(PercentageTolerance o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PercentageTolerance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PercentageTolerance", ValidationResult.ValidationType.TYPE_FORMAT, "PercentageTolerance", path, "", res.getError());
				}
				return success("PercentageTolerance", ValidationResult.ValidationType.TYPE_FORMAT, "PercentageTolerance", path, "");
			})
			.collect(toList());
	}

}
