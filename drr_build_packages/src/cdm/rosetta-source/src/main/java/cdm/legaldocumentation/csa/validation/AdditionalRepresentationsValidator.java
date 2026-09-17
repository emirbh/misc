package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalRepresentation;
import cdm.legaldocumentation.csa.AdditionalRepresentations;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdditionalRepresentationsValidator implements Validator<AdditionalRepresentations> {

	private List<ComparisonResult> getComparisonResults(AdditionalRepresentations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("additionalRepresentation", (AdditionalRepresentation) o.getAdditionalRepresentation() != null ? 1 : 0, 0, 1), 
				checkCardinality("regulatoryComplianceRepresentation", (Boolean) o.getRegulatoryComplianceRepresentation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRepresentations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalRepresentations", ValidationResult.ValidationType.CARDINALITY, "AdditionalRepresentations", path, "", res.getError());
				}
				return success("AdditionalRepresentations", ValidationResult.ValidationType.CARDINALITY, "AdditionalRepresentations", path, "");
			})
			.collect(toList());
	}

}
