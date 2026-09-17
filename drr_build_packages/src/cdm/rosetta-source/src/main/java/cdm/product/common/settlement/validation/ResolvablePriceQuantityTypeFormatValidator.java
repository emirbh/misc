package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ResolvablePriceQuantity;
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

public class ResolvablePriceQuantityTypeFormatValidator implements Validator<ResolvablePriceQuantity> {

	private List<ComparisonResult> getComparisonResults(ResolvablePriceQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResolvablePriceQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResolvablePriceQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "ResolvablePriceQuantity", path, "", res.getError());
				}
				return success("ResolvablePriceQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "ResolvablePriceQuantity", path, "");
			})
			.collect(toList());
	}

}
