package cdm.product.asset.validation;

import cdm.product.asset.DiscountingMethod;
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

public class DiscountingMethodTypeFormatValidator implements Validator<DiscountingMethod> {

	private List<ComparisonResult> getComparisonResults(DiscountingMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DiscountingMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DiscountingMethod", ValidationResult.ValidationType.TYPE_FORMAT, "DiscountingMethod", path, "", res.getError());
				}
				return success("DiscountingMethod", ValidationResult.ValidationType.TYPE_FORMAT, "DiscountingMethod", path, "");
			})
			.collect(toList());
	}

}
