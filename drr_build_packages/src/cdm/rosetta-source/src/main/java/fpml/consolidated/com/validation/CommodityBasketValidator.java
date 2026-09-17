package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.BasketName;
import fpml.consolidated.com.CommodityBasket;
import fpml.consolidated.com.CommodityBasketByNotional;
import fpml.consolidated.com.CommodityBasketByPercentage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketValidator implements Validator<CommodityBasket> {

	private List<ComparisonResult> getComparisonResults(CommodityBasket o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basketName", (BasketName) o.getBasketName() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantityBasket", (CommodityBasketByNotional) o.getNotionalQuantityBasket() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmountBasket", (CommodityBasketByPercentage) o.getNotionalAmountBasket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasket", ValidationResult.ValidationType.CARDINALITY, "CommodityBasket", path, "", res.getError());
				}
				return success("CommodityBasket", ValidationResult.ValidationType.CARDINALITY, "CommodityBasket", path, "");
			})
			.collect(toList());
	}

}
