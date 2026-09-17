package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.ObligationAcceleration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObligationAccelerationValidator implements Validator<ObligationAcceleration> {

	private List<ComparisonResult> getComparisonResults(ObligationAcceleration o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObligationAcceleration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObligationAcceleration", ValidationResult.ValidationType.CARDINALITY, "ObligationAcceleration", path, "", res.getError());
				}
				return success("ObligationAcceleration", ValidationResult.ValidationType.CARDINALITY, "ObligationAcceleration", path, "");
			})
			.collect(toList());
	}

}
