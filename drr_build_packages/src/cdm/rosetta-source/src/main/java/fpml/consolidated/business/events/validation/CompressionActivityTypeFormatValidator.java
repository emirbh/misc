package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CompressionActivity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CompressionActivityTypeFormatValidator implements Validator<CompressionActivity> {

	private List<ComparisonResult> getComparisonResults(CompressionActivity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionActivity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompressionActivity", ValidationResult.ValidationType.TYPE_FORMAT, "CompressionActivity", path, "", res.getError());
				}
				return success("CompressionActivity", ValidationResult.ValidationType.TYPE_FORMAT, "CompressionActivity", path, "");
			})
			.collect(toList());
	}

}
