package fpml.consolidated.dividend.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.FixedPaymentAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedPaymentAmountTypeFormatValidator implements Validator<FixedPaymentAmount> {

	private List<ComparisonResult> getComparisonResults(FixedPaymentAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPaymentAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPaymentAmount", ValidationResult.ValidationType.TYPE_FORMAT, "FixedPaymentAmount", path, "", res.getError());
				}
				return success("FixedPaymentAmount", ValidationResult.ValidationType.TYPE_FORMAT, "FixedPaymentAmount", path, "");
			})
			.collect(toList());
	}

}
