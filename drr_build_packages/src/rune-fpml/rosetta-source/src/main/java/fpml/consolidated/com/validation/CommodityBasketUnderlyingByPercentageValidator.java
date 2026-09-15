package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityBasketUnderlyingByPercentage;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingByPercentageValidator implements Validator<CommodityBasketUnderlyingByPercentage> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingByPercentage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction", (PayerReceiverEnum) o.getDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("constituentWeight", (BigDecimal) o.getConstituentWeight() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByPercentage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingByPercentage", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketUnderlyingByPercentage", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingByPercentage", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketUnderlyingByPercentage", path, "");
			})
			.collect(toList());
	}

}
