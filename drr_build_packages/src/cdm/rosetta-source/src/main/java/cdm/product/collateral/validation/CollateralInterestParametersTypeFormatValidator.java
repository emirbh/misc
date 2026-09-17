package cdm.product.collateral.validation;

import cdm.product.collateral.CollateralInterestParameters;
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

public class CollateralInterestParametersTypeFormatValidator implements Validator<CollateralInterestParameters> {

	private List<ComparisonResult> getComparisonResults(CollateralInterestParameters o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralInterestParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralInterestParameters", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralInterestParameters", path, "", res.getError());
				}
				return success("CollateralInterestParameters", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralInterestParameters", path, "");
			})
			.collect(toList());
	}

}
