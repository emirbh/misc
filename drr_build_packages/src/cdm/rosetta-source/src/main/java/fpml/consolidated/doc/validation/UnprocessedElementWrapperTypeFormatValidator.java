package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.UnprocessedElementWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UnprocessedElementWrapperTypeFormatValidator implements Validator<UnprocessedElementWrapper> {

	private List<ComparisonResult> getComparisonResults(UnprocessedElementWrapper o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnprocessedElementWrapper o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnprocessedElementWrapper", ValidationResult.ValidationType.TYPE_FORMAT, "UnprocessedElementWrapper", path, "", res.getError());
				}
				return success("UnprocessedElementWrapper", ValidationResult.ValidationType.TYPE_FORMAT, "UnprocessedElementWrapper", path, "");
			})
			.collect(toList());
	}

}
