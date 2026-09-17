package cdm.product.template.validation;

import cdm.product.template.TradableProduct;
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

public class TradableProductTypeFormatValidator implements Validator<TradableProduct> {

	private List<ComparisonResult> getComparisonResults(TradableProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradableProduct", ValidationResult.ValidationType.TYPE_FORMAT, "TradableProduct", path, "", res.getError());
				}
				return success("TradableProduct", ValidationResult.ValidationType.TYPE_FORMAT, "TradableProduct", path, "");
			})
			.collect(toList());
	}

}
