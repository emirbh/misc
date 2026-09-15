package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.GasDelivery;
import fpml.consolidated.com.GasDeliveryPeriods;
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.com.GasPhysicalQuantity;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GasPhysicalLegValidator implements Validator<GasPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(GasPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryPeriods", (GasDeliveryPeriods) o.getDeliveryPeriods() != null ? 1 : 0, 1, 1), 
				checkCardinality("gas", (GasProduct) o.getGas() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryConditions", (GasDelivery) o.getDeliveryConditions() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryQuantity", (GasPhysicalQuantity) o.getDeliveryQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "GasPhysicalLeg", path, "", res.getError());
				}
				return success("GasPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "GasPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
