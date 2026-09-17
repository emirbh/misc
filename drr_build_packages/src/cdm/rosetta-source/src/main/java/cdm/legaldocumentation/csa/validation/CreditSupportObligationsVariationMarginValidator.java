package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CreditSupportObligationsVariationMargin;
import cdm.legaldocumentation.csa.IneligibleCreditSupport;
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

public class CreditSupportObligationsVariationMarginValidator implements Validator<CreditSupportObligationsVariationMargin> {

	private List<ComparisonResult> getComparisonResults(CreditSupportObligationsVariationMargin o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ineligibleCreditSupport", (IneligibleCreditSupport) o.getIneligibleCreditSupport() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxHaircut", (String) o.getFxHaircut() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportObligationsVariationMargin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportObligationsVariationMargin", ValidationResult.ValidationType.CARDINALITY, "CreditSupportObligationsVariationMargin", path, "", res.getError());
				}
				return success("CreditSupportObligationsVariationMargin", ValidationResult.ValidationType.CARDINALITY, "CreditSupportObligationsVariationMargin", path, "");
			})
			.collect(toList());
	}

}
