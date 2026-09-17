package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.SensitivitySetDefinition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class SensitivitySetDefinitionTypeFormatValidator implements Validator<SensitivitySetDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivitySetDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivitySetDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivitySetDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "SensitivitySetDefinition", path, "", res.getError());
				}
				return success("SensitivitySetDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "SensitivitySetDefinition", path, "");
			})
			.collect(toList());
	}

}
