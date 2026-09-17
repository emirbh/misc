package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBasketUnderlyingBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingBaseTypeFormatValidator implements Validator<CommodityBasketUnderlyingBase> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingBase", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingBase", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingBase", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingBase", path, "");
			})
			.collect(toList());
	}

}
