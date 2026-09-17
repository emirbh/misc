package cdm.product.collateral.validation;

import cdm.product.collateral.CollateralCriteria;
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

public class CollateralCriteriaTypeFormatValidator implements Validator<CollateralCriteria> {

	private List<ComparisonResult> getComparisonResults(CollateralCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralCriteria", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralCriteria", path, "", res.getError());
				}
				return success("CollateralCriteria", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralCriteria", path, "");
			})
			.collect(toList());
	}

}
