package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.TransformTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TransformTypeChoiceTypeFormatValidator implements Validator<TransformTypeChoice> {

	private List<ComparisonResult> getComparisonResults(TransformTypeChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformTypeChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransformTypeChoice", ValidationResult.ValidationType.TYPE_FORMAT, "TransformTypeChoice", path, "", res.getError());
				}
				return success("TransformTypeChoice", ValidationResult.ValidationType.TYPE_FORMAT, "TransformTypeChoice", path, "");
			})
			.collect(toList());
	}

}
