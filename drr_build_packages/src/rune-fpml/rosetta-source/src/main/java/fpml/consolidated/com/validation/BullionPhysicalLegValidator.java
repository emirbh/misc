package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.BullionDeliveryLocation;
import fpml.consolidated.com.BullionPhysicalLeg;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.fpmlenum.BullionTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BullionPhysicalLegValidator implements Validator<BullionPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(BullionPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("bullionType", (BullionTypeEnum) o.getBullionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryLocation", (BullionDeliveryLocation) o.getDeliveryLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalQuantity", (CommodityNotionalQuantity) o.getPhysicalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalQuantitySchedule", (CommodityPhysicalQuantitySchedule) o.getPhysicalQuantitySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalPhysicalQuantity", (UnitQuantity) o.getTotalPhysicalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BullionPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BullionPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "BullionPhysicalLeg", path, "", res.getError());
				}
				return success("BullionPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "BullionPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
