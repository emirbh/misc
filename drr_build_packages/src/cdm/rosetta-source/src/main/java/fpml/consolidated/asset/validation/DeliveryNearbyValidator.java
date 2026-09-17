package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.DeliveryNearby;
import fpml.consolidated.fpmlenum.DeliveryNearbyTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DeliveryNearbyValidator implements Validator<DeliveryNearby> {

	private List<ComparisonResult> getComparisonResults(DeliveryNearby o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryNearbyMultiplier", (Integer) o.getDeliveryNearbyMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryNearbyType", (DeliveryNearbyTypeEnum) o.getDeliveryNearbyType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryNearby o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliveryNearby", ValidationResult.ValidationType.CARDINALITY, "DeliveryNearby", path, "", res.getError());
				}
				return success("DeliveryNearby", ValidationResult.ValidationType.CARDINALITY, "DeliveryNearby", path, "");
			})
			.collect(toList());
	}

}
