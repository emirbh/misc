package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.CommodityHub;
import fpml.consolidated.com.GasDelivery;
import fpml.consolidated.com.GasDeliveryPoint;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.DeliveryTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GasDeliveryValidator implements Validator<GasDelivery> {

	private List<ComparisonResult> getComparisonResults(GasDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryPoint", (GasDeliveryPoint) o.getDeliveryPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("entryPoint", (CommodityDeliveryPoint) o.getEntryPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("withdrawalPoint", (CommodityDeliveryPoint) o.getWithdrawalPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryType", (DeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerHub", (CommodityHub) o.getBuyerHub() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerHub", (CommodityHub) o.getSellerHub() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasDelivery", ValidationResult.ValidationType.CARDINALITY, "GasDelivery", path, "", res.getError());
				}
				return success("GasDelivery", ValidationResult.ValidationType.CARDINALITY, "GasDelivery", path, "");
			})
			.collect(toList());
	}

}
