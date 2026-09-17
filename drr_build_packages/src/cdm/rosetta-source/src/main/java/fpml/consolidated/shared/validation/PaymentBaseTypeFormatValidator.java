package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PaymentBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentBaseTypeFormatValidator implements Validator<PaymentBase> {

	private List<ComparisonResult> getComparisonResults(PaymentBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentBase", ValidationResult.ValidationType.TYPE_FORMAT, "PaymentBase", path, "", res.getError());
				}
				return success("PaymentBase", ValidationResult.ValidationType.TYPE_FORMAT, "PaymentBase", path, "");
			})
			.collect(toList());
	}

}
