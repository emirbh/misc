package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.FloatingRateCalculationReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRateCalculationReferenceTypeFormatValidator implements Validator<FloatingRateCalculationReference> {

	private List<ComparisonResult> getComparisonResults(FloatingRateCalculationReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateCalculationReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateCalculationReference", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRateCalculationReference", path, "", res.getError());
				}
				return success("FloatingRateCalculationReference", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRateCalculationReference", path, "");
			})
			.collect(toList());
	}

}
