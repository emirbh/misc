package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.SpecificInconvertibility;
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

public class SpecificInconvertibilityTypeFormatValidator implements Validator<SpecificInconvertibility> {

	private List<ComparisonResult> getComparisonResults(SpecificInconvertibility o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificInconvertibility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecificInconvertibility", ValidationResult.ValidationType.TYPE_FORMAT, "SpecificInconvertibility", path, "", res.getError());
				}
				return success("SpecificInconvertibility", ValidationResult.ValidationType.TYPE_FORMAT, "SpecificInconvertibility", path, "");
			})
			.collect(toList());
	}

}
