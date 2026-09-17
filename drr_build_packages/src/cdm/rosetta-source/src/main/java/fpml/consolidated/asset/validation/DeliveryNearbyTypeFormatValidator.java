package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.DeliveryNearby;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class DeliveryNearbyTypeFormatValidator implements Validator<DeliveryNearby> {

	private List<ComparisonResult> getComparisonResults(DeliveryNearby o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("deliveryNearbyMultiplier", o.getDeliveryNearbyMultiplier(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryNearby o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliveryNearby", ValidationResult.ValidationType.TYPE_FORMAT, "DeliveryNearby", path, "", res.getError());
				}
				return success("DeliveryNearby", ValidationResult.ValidationType.TYPE_FORMAT, "DeliveryNearby", path, "");
			})
			.collect(toList());
	}

}
