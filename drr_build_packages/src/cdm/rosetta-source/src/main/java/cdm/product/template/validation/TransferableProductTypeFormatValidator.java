package cdm.product.template.validation;

import cdm.product.template.TransferableProduct;
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

public class TransferableProductTypeFormatValidator implements Validator<TransferableProduct> {

	private List<ComparisonResult> getComparisonResults(TransferableProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransferableProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransferableProduct", ValidationResult.ValidationType.TYPE_FORMAT, "TransferableProduct", path, "", res.getError());
				}
				return success("TransferableProduct", ValidationResult.ValidationType.TYPE_FORMAT, "TransferableProduct", path, "");
			})
			.collect(toList());
	}

}
