package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CalculationAndTiming;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationAndTimingTypeFormatValidator implements Validator<CalculationAndTiming> {

	private List<ComparisonResult> getComparisonResults(CalculationAndTiming o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAndTiming o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationAndTiming", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationAndTiming", path, "", res.getError());
				}
				return success("CalculationAndTiming", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationAndTiming", path, "");
			})
			.collect(toList());
	}

}
