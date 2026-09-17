package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalRepresentation;
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

public class AdditionalRepresentationTypeFormatValidator implements Validator<AdditionalRepresentation> {

	private List<ComparisonResult> getComparisonResults(AdditionalRepresentation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRepresentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalRepresentation", ValidationResult.ValidationType.TYPE_FORMAT, "AdditionalRepresentation", path, "", res.getError());
				}
				return success("AdditionalRepresentation", ValidationResult.ValidationType.TYPE_FORMAT, "AdditionalRepresentation", path, "");
			})
			.collect(toList());
	}

}
