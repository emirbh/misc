package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyDefinition;
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

public class LegacyDefinitionTypeFormatValidator implements Validator<LegacyDefinition> {

	private List<ComparisonResult> getComparisonResults(LegacyDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyDefinition", path, "", res.getError());
				}
				return success("LegacyDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyDefinition", path, "");
			})
			.collect(toList());
	}

}
