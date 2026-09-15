package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ParentEventIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ParentEventIdentifierTypeFormatValidator implements Validator<ParentEventIdentifier> {

	private List<ComparisonResult> getComparisonResults(ParentEventIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParentEventIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParentEventIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "ParentEventIdentifier", path, "", res.getError());
				}
				return success("ParentEventIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "ParentEventIdentifier", path, "");
			})
			.collect(toList());
	}

}
