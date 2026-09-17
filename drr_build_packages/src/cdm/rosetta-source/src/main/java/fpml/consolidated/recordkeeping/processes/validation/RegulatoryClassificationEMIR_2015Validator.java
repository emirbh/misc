package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.ESMAContractType;
import fpml.consolidated.recordkeeping.processes.ESMACreditDetails;
import fpml.consolidated.recordkeeping.processes.ESMADeliveryType;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationEMIR_2015;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationEMIR_2015Validator implements Validator<RegulatoryClassificationEMIR_2015> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationEMIR_2015 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePartyRelationshipType", (PartyRelationshipType) o.getTradePartyRelationshipType() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatorilyClearable", (Boolean) o.getMandatorilyClearable() != null ? 1 : 0, 0, 1), 
				checkCardinality("exceedsClearingThreshold", (Boolean) o.getExceedsClearingThreshold() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingPartyClassification", (EntityClassification) o.getReportingPartyClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterPartyClassification", (EntityClassification) o.getCounterPartyClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterPartyisEEA", (Boolean) o.getCounterPartyisEEA() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractType", (ESMAContractType) o.getContractType() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryType", (ESMADeliveryType) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditDetails", (ESMACreditDetails) o.getCreditDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (ESMAProductUnderlyer) o.getUnderlyer() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationEMIR_2015 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationEMIR_2015", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationEMIR_2015", path, "", res.getError());
				}
				return success("RegulatoryClassificationEMIR_2015", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationEMIR_2015", path, "");
			})
			.collect(toList());
	}

}
