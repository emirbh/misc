package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelativeDateSequenceTypeFormatValidator implements Validator<RelativeDateSequence> {

	private List<ComparisonResult> getComparisonResults(RelativeDateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativeDateSequence", ValidationResult.ValidationType.TYPE_FORMAT, "RelativeDateSequence", path, "", res.getError());
				}
				return success("RelativeDateSequence", ValidationResult.ValidationType.TYPE_FORMAT, "RelativeDateSequence", path, "");
			})
			.collect(toList());
	}

}
