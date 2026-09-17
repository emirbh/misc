package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.NonDeliverableSubstitute;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonDeliverableSubstituteTypeFormatValidator implements Validator<NonDeliverableSubstitute> {

	private List<ComparisonResult> getComparisonResults(NonDeliverableSubstitute o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSubstitute o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonDeliverableSubstitute", ValidationResult.ValidationType.TYPE_FORMAT, "NonDeliverableSubstitute", path, "", res.getError());
				}
				return success("NonDeliverableSubstitute", ValidationResult.ValidationType.TYPE_FORMAT, "NonDeliverableSubstitute", path, "");
			})
			.collect(toList());
	}

}
