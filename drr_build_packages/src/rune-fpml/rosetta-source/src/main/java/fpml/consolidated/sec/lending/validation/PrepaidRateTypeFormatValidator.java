package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.PrepaidRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrepaidRateTypeFormatValidator implements Validator<PrepaidRate> {

	private List<ComparisonResult> getComparisonResults(PrepaidRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrepaidRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrepaidRate", ValidationResult.ValidationType.TYPE_FORMAT, "PrepaidRate", path, "", res.getError());
				}
				return success("PrepaidRate", ValidationResult.ValidationType.TYPE_FORMAT, "PrepaidRate", path, "");
			})
			.collect(toList());
	}

}
