package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilitySwapTransactionSupplementTypeFormatValidator implements Validator<VolatilitySwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VolatilitySwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilitySwapTransactionSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilitySwapTransactionSupplement", path, "", res.getError());
				}
				return success("VolatilitySwapTransactionSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilitySwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
