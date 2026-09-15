package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FloatingAmountCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingAmountCalculationTypeFormatValidator implements Validator<FloatingAmountCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingAmountCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingAmountCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingAmountCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingAmountCalculation", path, "", res.getError());
				}
				return success("FloatingAmountCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingAmountCalculation", path, "");
			})
			.collect(toList());
	}

}
