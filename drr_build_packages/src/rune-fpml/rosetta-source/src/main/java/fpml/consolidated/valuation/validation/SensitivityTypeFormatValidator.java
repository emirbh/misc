package fpml.consolidated.valuation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.Sensitivity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SensitivityTypeFormatValidator implements Validator<Sensitivity> {

	private List<ComparisonResult> getComparisonResults(Sensitivity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Sensitivity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Sensitivity", ValidationResult.ValidationType.TYPE_FORMAT, "Sensitivity", path, "", res.getError());
				}
				return success("Sensitivity", ValidationResult.ValidationType.TYPE_FORMAT, "Sensitivity", path, "");
			})
			.collect(toList());
	}

}
