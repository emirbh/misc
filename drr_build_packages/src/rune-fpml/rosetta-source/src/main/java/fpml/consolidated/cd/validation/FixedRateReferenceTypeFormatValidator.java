package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FixedRateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedRateReferenceTypeFormatValidator implements Validator<FixedRateReference> {

	private List<ComparisonResult> getComparisonResults(FixedRateReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateReference", ValidationResult.ValidationType.TYPE_FORMAT, "FixedRateReference", path, "", res.getError());
				}
				return success("FixedRateReference", ValidationResult.ValidationType.TYPE_FORMAT, "FixedRateReference", path, "");
			})
			.collect(toList());
	}

}
