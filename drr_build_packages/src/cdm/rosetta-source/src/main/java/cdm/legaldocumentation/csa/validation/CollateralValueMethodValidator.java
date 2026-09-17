package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CollateralValueMethod;
import cdm.legaldocumentation.csa.ValueCashEnum;
import cdm.legaldocumentation.csa.ValueSecuritiesEnum;
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

public class CollateralValueMethodValidator implements Validator<CollateralValueMethod> {

	private List<ComparisonResult> getComparisonResults(CollateralValueMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashCollateral", (ValueCashEnum) o.getCashCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("securitiesCollateral", (ValueSecuritiesEnum) o.getSecuritiesCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValueMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValueMethod", ValidationResult.ValidationType.CARDINALITY, "CollateralValueMethod", path, "", res.getError());
				}
				return success("CollateralValueMethod", ValidationResult.ValidationType.CARDINALITY, "CollateralValueMethod", path, "");
			})
			.collect(toList());
	}

}
