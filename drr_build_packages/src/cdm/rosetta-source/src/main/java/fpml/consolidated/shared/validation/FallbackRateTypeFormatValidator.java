package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FallbackRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FallbackRateTypeFormatValidator implements Validator<FallbackRate> {

	private List<ComparisonResult> getComparisonResults(FallbackRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FallbackRate", ValidationResult.ValidationType.TYPE_FORMAT, "FallbackRate", path, "", res.getError());
				}
				return success("FallbackRate", ValidationResult.ValidationType.TYPE_FORMAT, "FallbackRate", path, "");
			})
			.collect(toList());
	}

}
