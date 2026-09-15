package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBasketByPercentage;
import fpml.consolidated.shared.NotionalAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketByPercentageValidator implements Validator<CommodityBasketByPercentage> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketByPercentage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NotionalAmount) o.getNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketByPercentage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketByPercentage", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketByPercentage", path, "", res.getError());
				}
				return success("CommodityBasketByPercentage", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketByPercentage", path, "");
			})
			.collect(toList());
	}

}
