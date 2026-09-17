package cdm.product.collateral.validation;

import cdm.product.collateral.DeliveryAmount;
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

public class DeliveryAmountTypeFormatValidator implements Validator<DeliveryAmount> {

	private List<ComparisonResult> getComparisonResults(DeliveryAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliveryAmount", ValidationResult.ValidationType.TYPE_FORMAT, "DeliveryAmount", path, "", res.getError());
				}
				return success("DeliveryAmount", ValidationResult.ValidationType.TYPE_FORMAT, "DeliveryAmount", path, "");
			})
			.collect(toList());
	}

}
