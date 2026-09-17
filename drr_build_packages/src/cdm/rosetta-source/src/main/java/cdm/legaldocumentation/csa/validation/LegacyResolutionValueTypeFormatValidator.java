package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyResolutionValue;
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

public class LegacyResolutionValueTypeFormatValidator implements Validator<LegacyResolutionValue> {

	private List<ComparisonResult> getComparisonResults(LegacyResolutionValue o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyResolutionValue", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyResolutionValue", path, "", res.getError());
				}
				return success("LegacyResolutionValue", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyResolutionValue", path, "");
			})
			.collect(toList());
	}

}
