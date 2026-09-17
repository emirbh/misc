package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.CommodityDeliveryRisk;
import fpml.consolidated.com.MetalDelivery;
import fpml.consolidated.fpmlenum.MetalTitleEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MetalDeliveryValidator implements Validator<MetalDelivery> {

	private List<ComparisonResult> getComparisonResults(MetalDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryLocation", (CommodityDeliveryPoint) o.getDeliveryLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("risk", (CommodityDeliveryRisk) o.getRisk() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalQuantityTolerance", (BigDecimal) o.getTotalQuantityTolerance() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodQuantityTolerance", (BigDecimal) o.getPeriodQuantityTolerance() != null ? 1 : 0, 0, 1), 
				checkCardinality("title", (MetalTitleEnum) o.getTitle() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MetalDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MetalDelivery", ValidationResult.ValidationType.CARDINALITY, "MetalDelivery", path, "", res.getError());
				}
				return success("MetalDelivery", ValidationResult.ValidationType.CARDINALITY, "MetalDelivery", path, "");
			})
			.collect(toList());
	}

}
