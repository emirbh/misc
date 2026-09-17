package cdm.observable.event.validation;

import cdm.observable.event.GracePeriodExtension;
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

public class GracePeriodExtensionTypeFormatValidator implements Validator<GracePeriodExtension> {

	private List<ComparisonResult> getComparisonResults(GracePeriodExtension o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GracePeriodExtension o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GracePeriodExtension", ValidationResult.ValidationType.TYPE_FORMAT, "GracePeriodExtension", path, "", res.getError());
				}
				return success("GracePeriodExtension", ValidationResult.ValidationType.TYPE_FORMAT, "GracePeriodExtension", path, "");
			})
			.collect(toList());
	}

}
