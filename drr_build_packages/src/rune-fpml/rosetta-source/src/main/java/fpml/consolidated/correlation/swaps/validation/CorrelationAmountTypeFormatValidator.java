package fpml.consolidated.correlation.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.correlation.swaps.CorrelationAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CorrelationAmountTypeFormatValidator implements Validator<CorrelationAmount> {

	private List<ComparisonResult> getComparisonResults(CorrelationAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationAmount", ValidationResult.ValidationType.TYPE_FORMAT, "CorrelationAmount", path, "", res.getError());
				}
				return success("CorrelationAmount", ValidationResult.ValidationType.TYPE_FORMAT, "CorrelationAmount", path, "");
			})
			.collect(toList());
	}

}
