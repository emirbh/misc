package cdm.product.collateral.validation;

import cdm.product.collateral.EligibleCollateralCriteria;
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

public class EligibleCollateralCriteriaTypeFormatValidator implements Validator<EligibleCollateralCriteria> {

	private List<ComparisonResult> getComparisonResults(EligibleCollateralCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibleCollateralCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EligibleCollateralCriteria", ValidationResult.ValidationType.TYPE_FORMAT, "EligibleCollateralCriteria", path, "", res.getError());
				}
				return success("EligibleCollateralCriteria", ValidationResult.ValidationType.TYPE_FORMAT, "EligibleCollateralCriteria", path, "");
			})
			.collect(toList());
	}

}
