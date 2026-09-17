package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.InterestRateStream;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestRateStreamTypeFormatValidator implements Validator<InterestRateStream> {

	private List<ComparisonResult> getComparisonResults(InterestRateStream o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateStream o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateStream", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRateStream", path, "", res.getError());
				}
				return success("InterestRateStream", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRateStream", path, "");
			})
			.collect(toList());
	}

}
