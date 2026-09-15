package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AdmissionToTrading;
import fpml.consolidated.doc.CurrencyPairClassification;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS23_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationMifirRTS23_2015Validator implements Validator<RegulatoryClassificationMifirRTS23_2015> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationMifirRTS23_2015 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingObligation", (RegulatoryTradingObligation) o.getTradingObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("isCommodityHedge", (Boolean) o.getIsCommodityHedge() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyPairClassification", (CurrencyPairClassification) o.getCurrencyPairClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("transmissionOfOrder", (Boolean) o.getTransmissionOfOrder() != null ? 1 : 0, 0, 1), 
				checkCardinality("admissionToTrading", (AdmissionToTrading) o.getAdmissionToTrading() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationMifirRTS23_2015 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationMifirRTS23_2015", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationMifirRTS23_2015", path, "", res.getError());
				}
				return success("RegulatoryClassificationMifirRTS23_2015", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationMifirRTS23_2015", path, "");
			})
			.collect(toList());
	}

}
