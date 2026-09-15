package fpml.consolidated.variance.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceSwapTransactionSupplementTypeFormatValidator implements Validator<VarianceSwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VarianceSwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceSwapTransactionSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "VarianceSwapTransactionSupplement", path, "", res.getError());
				}
				return success("VarianceSwapTransactionSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "VarianceSwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
