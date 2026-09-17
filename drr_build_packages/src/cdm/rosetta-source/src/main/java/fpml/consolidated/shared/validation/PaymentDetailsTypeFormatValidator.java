package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PaymentDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentDetailsTypeFormatValidator implements Validator<PaymentDetails> {

	private List<ComparisonResult> getComparisonResults(PaymentDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDetails", ValidationResult.ValidationType.TYPE_FORMAT, "PaymentDetails", path, "", res.getError());
				}
				return success("PaymentDetails", ValidationResult.ValidationType.TYPE_FORMAT, "PaymentDetails", path, "");
			})
			.collect(toList());
	}

}
