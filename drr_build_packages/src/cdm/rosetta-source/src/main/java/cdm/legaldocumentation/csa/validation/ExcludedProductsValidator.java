package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ExcludedProducts;
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

public class ExcludedProductsValidator implements Validator<ExcludedProducts> {

	private List<ComparisonResult> getComparisonResults(ExcludedProducts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("excluded", (Boolean) o.getExcluded() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExcludedProducts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExcludedProducts", ValidationResult.ValidationType.CARDINALITY, "ExcludedProducts", path, "", res.getError());
				}
				return success("ExcludedProducts", ValidationResult.ValidationType.CARDINALITY, "ExcludedProducts", path, "");
			})
			.collect(toList());
	}

}
