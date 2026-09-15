package fpml.consolidated.variance.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.variance.swaps.VarianceSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceSwapTypeFormatValidator implements Validator<VarianceSwap> {

	private List<ComparisonResult> getComparisonResults(VarianceSwap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceSwap", ValidationResult.ValidationType.TYPE_FORMAT, "VarianceSwap", path, "", res.getError());
				}
				return success("VarianceSwap", ValidationResult.ValidationType.TYPE_FORMAT, "VarianceSwap", path, "");
			})
			.collect(toList());
	}

}
