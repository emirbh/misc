package cdm.observable.event.validation;

import cdm.observable.event.FeaturePayment;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FeaturePaymentTypeFormatValidator implements Validator<FeaturePayment> {

	private List<ComparisonResult> getComparisonResults(FeaturePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeaturePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeaturePayment", ValidationResult.ValidationType.TYPE_FORMAT, "FeaturePayment", path, "", res.getError());
				}
				return success("FeaturePayment", ValidationResult.ValidationType.TYPE_FORMAT, "FeaturePayment", path, "");
			})
			.collect(toList());
	}

}
