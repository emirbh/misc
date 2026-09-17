package fpml.consolidated.correlation.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CorrelationSwapTypeFormatValidator implements Validator<CorrelationSwap> {

	private List<ComparisonResult> getComparisonResults(CorrelationSwap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationSwap", ValidationResult.ValidationType.TYPE_FORMAT, "CorrelationSwap", path, "", res.getError());
				}
				return success("CorrelationSwap", ValidationResult.ValidationType.TYPE_FORMAT, "CorrelationSwap", path, "");
			})
			.collect(toList());
	}

}
