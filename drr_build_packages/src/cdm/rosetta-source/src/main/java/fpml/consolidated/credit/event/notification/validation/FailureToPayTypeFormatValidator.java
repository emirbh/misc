package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.FailureToPay;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FailureToPayTypeFormatValidator implements Validator<FailureToPay> {

	private List<ComparisonResult> getComparisonResults(FailureToPay o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FailureToPay o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FailureToPay", ValidationResult.ValidationType.TYPE_FORMAT, "FailureToPay", path, "", res.getError());
				}
				return success("FailureToPay", ValidationResult.ValidationType.TYPE_FORMAT, "FailureToPay", path, "");
			})
			.collect(toList());
	}

}
