package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ReferencePair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferencePairTypeFormatValidator implements Validator<ReferencePair> {

	private List<ComparisonResult> getComparisonResults(ReferencePair o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePair o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferencePair", ValidationResult.ValidationType.TYPE_FORMAT, "ReferencePair", path, "", res.getError());
				}
				return success("ReferencePair", ValidationResult.ValidationType.TYPE_FORMAT, "ReferencePair", path, "");
			})
			.collect(toList());
	}

}
