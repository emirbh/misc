package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.com.CommodityPhysicalQuantity;
import fpml.consolidated.com.OilDelivery;
import fpml.consolidated.com.OilPhysicalLeg;
import fpml.consolidated.com.OilProduct;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OilPhysicalLegValidator implements Validator<OilPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(OilPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryPeriods", (CommodityDeliveryPeriods) o.getDeliveryPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("oil", (OilProduct) o.getOil() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryConditions", (OilDelivery) o.getDeliveryConditions() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryQuantity", (CommodityPhysicalQuantity) o.getDeliveryQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "OilPhysicalLeg", path, "", res.getError());
				}
				return success("OilPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "OilPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
