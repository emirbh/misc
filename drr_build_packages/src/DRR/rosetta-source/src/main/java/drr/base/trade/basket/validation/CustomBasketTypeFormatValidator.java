package drr.base.trade.basket.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.basket.CustomBasket;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CustomBasketTypeFormatValidator implements Validator<CustomBasket> {

	private List<ComparisonResult> getComparisonResults(CustomBasket o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustomBasket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustomBasket", ValidationResult.ValidationType.TYPE_FORMAT, "CustomBasket", path, "", res.getError());
				}
				return success("CustomBasket", ValidationResult.ValidationType.TYPE_FORMAT, "CustomBasket", path, "");
			})
			.collect(toList());
	}

}
