package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.com.ElectricityDelivery;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.com.ElectricityPhysicalQuantity;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.com.SettlementPeriodsSchedule;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalLegValidator implements Validator<ElectricityPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryPeriods", (CommodityDeliveryPeriods) o.getDeliveryPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriods", (List<? extends SettlementPeriods>) o.getSettlementPeriods() == null ? 0 : o.getSettlementPeriods().size(), 1, 0), 
				checkCardinality("settlementPeriodsSchedule", (SettlementPeriodsSchedule) o.getSettlementPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("loadType", (LoadTypeEnum) o.getLoadType() != null ? 1 : 0, 0, 1), 
				checkCardinality("electricity", (ElectricityProduct) o.getElectricity() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryConditions", (ElectricityDelivery) o.getDeliveryConditions() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryQuantity", (ElectricityPhysicalQuantity) o.getDeliveryQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "ElectricityPhysicalLeg", path, "", res.getError());
				}
				return success("ElectricityPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "ElectricityPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
