package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityBasketUnderlyingByNotional;
import fpml.consolidated.com.CommodityFx;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingByNotionalValidator implements Validator<CommodityBasketUnderlyingByNotional> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingByNotional o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction", (PayerReceiverEnum) o.getDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("fx", (CommodityFx) o.getFx() != null ? 1 : 0, 0, 1), 
				checkCardinality("conversionFactor", (BigDecimal) o.getConversionFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantitySchedule", (CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantity", (CommodityNotionalQuantity) o.getNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalNotionalQuantity", (BigDecimal) o.getTotalNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingByNotional", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketUnderlyingByNotional", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingByNotional", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketUnderlyingByNotional", path, "");
			})
			.collect(toList());
	}

}
