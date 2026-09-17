package cdm.base.datetime.validation;

import cdm.base.datetime.CalculationFrequency;
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

public class CalculationFrequencyTypeFormatValidator implements Validator<CalculationFrequency> {

	private List<ComparisonResult> getComparisonResults(CalculationFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationFrequency", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationFrequency", path, "", res.getError());
				}
				return success("CalculationFrequency", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationFrequency", path, "");
			})
			.collect(toList());
	}

}
