package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.InterestRateStreamReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestRateStreamReferenceTypeFormatValidator implements Validator<InterestRateStreamReference> {

	private List<ComparisonResult> getComparisonResults(InterestRateStreamReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateStreamReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateStreamReference", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRateStreamReference", path, "", res.getError());
				}
				return success("InterestRateStreamReference", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRateStreamReference", path, "");
			})
			.collect(toList());
	}

}
