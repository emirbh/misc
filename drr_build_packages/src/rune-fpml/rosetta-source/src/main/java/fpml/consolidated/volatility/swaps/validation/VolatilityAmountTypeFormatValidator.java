package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilityAmountTypeFormatValidator implements Validator<VolatilityAmount> {

	private List<ComparisonResult> getComparisonResults(VolatilityAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityAmount", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilityAmount", path, "", res.getError());
				}
				return success("VolatilityAmount", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilityAmount", path, "");
			})
			.collect(toList());
	}

}
