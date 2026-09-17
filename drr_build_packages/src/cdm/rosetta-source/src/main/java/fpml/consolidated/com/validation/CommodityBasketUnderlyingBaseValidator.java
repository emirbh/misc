package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityBasketUnderlyingBase;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingBaseValidator implements Validator<CommodityBasketUnderlyingBase> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction", (PayerReceiverEnum) o.getDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingBase", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketUnderlyingBase", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingBase", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketUnderlyingBase", path, "");
			})
			.collect(toList());
	}

}
