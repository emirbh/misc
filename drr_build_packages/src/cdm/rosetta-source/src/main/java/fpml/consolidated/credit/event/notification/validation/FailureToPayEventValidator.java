package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.FailureToPayEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FailureToPayEventValidator implements Validator<FailureToPayEvent> {

	private List<ComparisonResult> getComparisonResults(FailureToPayEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FailureToPayEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FailureToPayEvent", ValidationResult.ValidationType.CARDINALITY, "FailureToPayEvent", path, "", res.getError());
				}
				return success("FailureToPayEvent", ValidationResult.ValidationType.CARDINALITY, "FailureToPayEvent", path, "");
			})
			.collect(toList());
	}

}
