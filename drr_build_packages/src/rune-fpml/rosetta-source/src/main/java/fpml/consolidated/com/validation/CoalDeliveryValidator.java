package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalDelivery;
import fpml.consolidated.com.CoalDeliveryPoint;
import fpml.consolidated.com.CoalTransportationEquipment;
import fpml.consolidated.com.CommodityDeliveryRisk;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoalDeliveryValidator implements Validator<CoalDelivery> {

	private List<ComparisonResult> getComparisonResults(CoalDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryPoint", (CoalDeliveryPoint) o.getDeliveryPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryAtSource", (Boolean) o.getDeliveryAtSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityVariationAdjustment", (Boolean) o.getQuantityVariationAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("transportationEquipment", (CoalTransportationEquipment) o.getTransportationEquipment() != null ? 1 : 0, 0, 1), 
				checkCardinality("risk", (CommodityDeliveryRisk) o.getRisk() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalDelivery", ValidationResult.ValidationType.CARDINALITY, "CoalDelivery", path, "", res.getError());
				}
				return success("CoalDelivery", ValidationResult.ValidationType.CARDINALITY, "CoalDelivery", path, "");
			})
			.collect(toList());
	}

}
