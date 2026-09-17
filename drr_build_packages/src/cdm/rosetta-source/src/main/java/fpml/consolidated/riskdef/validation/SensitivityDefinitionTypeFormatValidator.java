package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.SensitivityDefinition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class SensitivityDefinitionTypeFormatValidator implements Validator<SensitivityDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivityDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivityDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "SensitivityDefinition", path, "", res.getError());
				}
				return success("SensitivityDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "SensitivityDefinition", path, "");
			})
			.collect(toList());
	}

}
