package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalRightsEvent;
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

public class AdditionalRightsEventValidator implements Validator<AdditionalRightsEvent> {

	private List<ComparisonResult> getComparisonResults(AdditionalRightsEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("qualification", (String) o.getQualification() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRightsEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalRightsEvent", ValidationResult.ValidationType.CARDINALITY, "AdditionalRightsEvent", path, "", res.getError());
				}
				return success("AdditionalRightsEvent", ValidationResult.ValidationType.CARDINALITY, "AdditionalRightsEvent", path, "");
			})
			.collect(toList());
	}

}
