package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.ConfirmationMethod;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.ExecutionType;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.VerificationMethod;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2012;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationPart45_2012Validator implements Validator<RegulatoryClassificationPart45_2012> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationPart45_2012 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatorilyClearable", (ReportingBoolean) o.getMandatorilyClearable() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserException", (Boolean) o.getEndUserException() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserExceptionDeclaration", (EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration() != null ? 1 : 0, 0, 1), 
				checkCardinality("largeSizeTrade", (Boolean) o.getLargeSizeTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionType", (ExecutionType) o.getExecutionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1), 
				checkCardinality("verificationMethod", (VerificationMethod) o.getVerificationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmationMethod", (ConfirmationMethod) o.getConfirmationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizationType", (CollateralizationType) o.getCollateralizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingPartyOrganizationType", (String) o.getReportingPartyOrganizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterPartyOrganizationType", (String) o.getCounterPartyOrganizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterPartyIsUsPerson", (Boolean) o.getCounterPartyIsUsPerson() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToAllocate", (Boolean) o.getIntentToAllocate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationStatus", (AllocationReportingStatus) o.getAllocationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationAgent", (PartyReference) o.getAllocationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiAssetSwap", (Boolean) o.getMultiAssetSwap() != null ? 1 : 0, 0, 1), 
				checkCardinality("mixedSwap", (Boolean) o.getMixedSwap() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractType", (ProductId) o.getContractType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart45_2012 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationPart45_2012", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart45_2012", path, "", res.getError());
				}
				return success("RegulatoryClassificationPart45_2012", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart45_2012", path, "");
			})
			.collect(toList());
	}

}
