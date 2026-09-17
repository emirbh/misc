package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.OnBehalfOf;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OnBehalfOfTypeFormatValidator implements Validator<OnBehalfOf> {

	private List<ComparisonResult> getComparisonResults(OnBehalfOf o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OnBehalfOf o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OnBehalfOf", ValidationResult.ValidationType.TYPE_FORMAT, "OnBehalfOf", path, "", res.getError());
				}
				return success("OnBehalfOf", ValidationResult.ValidationType.TYPE_FORMAT, "OnBehalfOf", path, "");
			})
			.collect(toList());
	}

}
