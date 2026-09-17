package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.SensitivityDefinitionChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SensitivityDefinitionChoiceTypeFormatValidator implements Validator<SensitivityDefinitionChoice> {

	private List<ComparisonResult> getComparisonResults(SensitivityDefinitionChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinitionChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivityDefinitionChoice", ValidationResult.ValidationType.TYPE_FORMAT, "SensitivityDefinitionChoice", path, "", res.getError());
				}
				return success("SensitivityDefinitionChoice", ValidationResult.ValidationType.TYPE_FORMAT, "SensitivityDefinitionChoice", path, "");
			})
			.collect(toList());
	}

}
