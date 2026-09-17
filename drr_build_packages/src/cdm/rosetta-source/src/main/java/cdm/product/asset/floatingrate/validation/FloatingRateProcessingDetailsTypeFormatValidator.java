package cdm.product.asset.floatingrate.validation;

import cdm.product.asset.floatingrate.FloatingRateProcessingDetails;
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

public class FloatingRateProcessingDetailsTypeFormatValidator implements Validator<FloatingRateProcessingDetails> {

	private List<ComparisonResult> getComparisonResults(FloatingRateProcessingDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateProcessingDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateProcessingDetails", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRateProcessingDetails", path, "", res.getError());
				}
				return success("FloatingRateProcessingDetails", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRateProcessingDetails", path, "");
			})
			.collect(toList());
	}

}
