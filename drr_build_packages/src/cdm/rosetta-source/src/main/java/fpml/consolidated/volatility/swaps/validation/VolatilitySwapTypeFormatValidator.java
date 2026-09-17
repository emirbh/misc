package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilitySwapTypeFormatValidator implements Validator<VolatilitySwap> {

	private List<ComparisonResult> getComparisonResults(VolatilitySwap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilitySwap", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilitySwap", path, "", res.getError());
				}
				return success("VolatilitySwap", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilitySwap", path, "");
			})
			.collect(toList());
	}

}
