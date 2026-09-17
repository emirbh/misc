package cdm.legaldocumentation.csa.validation;

import cdm.base.datetime.BusinessCenterTime;
import cdm.legaldocumentation.csa.DisputeResolution;
import cdm.legaldocumentation.csa.LegacyResolutionAlternative;
import cdm.legaldocumentation.csa.LegacyResolutionValue;
import cdm.legaldocumentation.csa.RecalculationOfValue;
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

public class DisputeResolutionValidator implements Validator<DisputeResolution> {

	private List<ComparisonResult> getComparisonResults(DisputeResolution o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resolutionTime", (BusinessCenterTime) o.getResolutionTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherTerms", (String) o.getOtherTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("valueTerms", (String) o.getValueTerms() != null ? 1 : 0, 1, 1), 
				checkCardinality("alternativeTerms", (String) o.getAlternativeTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("recalculationOfValue", (RecalculationOfValue) o.getRecalculationOfValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyResolutionTime", (BusinessCenterTime) o.getLegacyResolutionTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyAlternative", (LegacyResolutionAlternative) o.getLegacyAlternative() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyValue", (LegacyResolutionValue) o.getLegacyValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DisputeResolution o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DisputeResolution", ValidationResult.ValidationType.CARDINALITY, "DisputeResolution", path, "", res.getError());
				}
				return success("DisputeResolution", ValidationResult.ValidationType.CARDINALITY, "DisputeResolution", path, "");
			})
			.collect(toList());
	}

}
