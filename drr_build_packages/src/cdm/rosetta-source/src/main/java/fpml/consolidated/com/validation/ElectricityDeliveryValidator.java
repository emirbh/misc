package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.ElectricityDelivery;
import fpml.consolidated.com.ElectricityDeliveryPoint;
import fpml.consolidated.com.ElectricityDeliveryType;
import fpml.consolidated.com.ElectricityTransmissionContingency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliveryValidator implements Validator<ElectricityDelivery> {

	private List<ComparisonResult> getComparisonResults(ElectricityDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryPoint", (ElectricityDeliveryPoint) o.getDeliveryPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryType", (ElectricityDeliveryType) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("transmissionContingency", (ElectricityTransmissionContingency) o.getTransmissionContingency() != null ? 1 : 0, 0, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryZone", (CommodityDeliveryPoint) o.getDeliveryZone() != null ? 1 : 0, 0, 1), 
				checkCardinality("electingPartyReference", (PartyReference) o.getElectingPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDelivery", ValidationResult.ValidationType.CARDINALITY, "ElectricityDelivery", path, "", res.getError());
				}
				return success("ElectricityDelivery", ValidationResult.ValidationType.CARDINALITY, "ElectricityDelivery", path, "");
			})
			.collect(toList());
	}

}
