package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CreditSupportAmount;
import cdm.legaldocumentation.csa.CreditSupportAmountEnum;
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

public class CreditSupportAmountValidator implements Validator<CreditSupportAmount> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditSupportAmount", (CreditSupportAmountEnum) o.getCreditSupportAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAmount", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAmount", path, "", res.getError());
				}
				return success("CreditSupportAmount", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAmount", path, "");
			})
			.collect(toList());
	}

}
