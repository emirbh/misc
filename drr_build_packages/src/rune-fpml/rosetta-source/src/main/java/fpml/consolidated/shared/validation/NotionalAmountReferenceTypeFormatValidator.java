package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.NotionalAmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalAmountReferenceTypeFormatValidator implements Validator<NotionalAmountReference> {

	private List<ComparisonResult> getComparisonResults(NotionalAmountReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalAmountReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalAmountReference", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalAmountReference", path, "", res.getError());
				}
				return success("NotionalAmountReference", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalAmountReference", path, "");
			})
			.collect(toList());
	}

}
