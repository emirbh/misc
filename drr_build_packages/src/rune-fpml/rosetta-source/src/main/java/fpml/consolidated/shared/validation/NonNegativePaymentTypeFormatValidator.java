package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.NonNegativePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonNegativePaymentTypeFormatValidator implements Validator<NonNegativePayment> {

	private List<ComparisonResult> getComparisonResults(NonNegativePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonNegativePayment", ValidationResult.ValidationType.TYPE_FORMAT, "NonNegativePayment", path, "", res.getError());
				}
				return success("NonNegativePayment", ValidationResult.ValidationType.TYPE_FORMAT, "NonNegativePayment", path, "");
			})
			.collect(toList());
	}

}
