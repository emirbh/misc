package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ImplementationSpecification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ImplementationSpecificationTypeFormatValidator implements Validator<ImplementationSpecification> {

	private List<ComparisonResult> getComparisonResults(ImplementationSpecification o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ImplementationSpecification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ImplementationSpecification", ValidationResult.ValidationType.TYPE_FORMAT, "ImplementationSpecification", path, "", res.getError());
				}
				return success("ImplementationSpecification", ValidationResult.ValidationType.TYPE_FORMAT, "ImplementationSpecification", path, "");
			})
			.collect(toList());
	}

}
