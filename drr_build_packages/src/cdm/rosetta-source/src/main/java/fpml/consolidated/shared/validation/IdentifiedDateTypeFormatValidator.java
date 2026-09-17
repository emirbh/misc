package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IdentifiedDateTypeFormatValidator implements Validator<IdentifiedDate> {

	private List<ComparisonResult> getComparisonResults(IdentifiedDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedDate", ValidationResult.ValidationType.TYPE_FORMAT, "IdentifiedDate", path, "", res.getError());
				}
				return success("IdentifiedDate", ValidationResult.ValidationType.TYPE_FORMAT, "IdentifiedDate", path, "");
			})
			.collect(toList());
	}

}
