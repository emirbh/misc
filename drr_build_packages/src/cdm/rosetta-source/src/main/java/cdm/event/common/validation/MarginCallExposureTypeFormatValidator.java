package cdm.event.common.validation;

import cdm.event.common.MarginCallExposure;
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

public class MarginCallExposureTypeFormatValidator implements Validator<MarginCallExposure> {

	private List<ComparisonResult> getComparisonResults(MarginCallExposure o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallExposure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginCallExposure", ValidationResult.ValidationType.TYPE_FORMAT, "MarginCallExposure", path, "", res.getError());
				}
				return success("MarginCallExposure", ValidationResult.ValidationType.TYPE_FORMAT, "MarginCallExposure", path, "");
			})
			.collect(toList());
	}

}
