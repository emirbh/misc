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
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.doc.VerificationMethod;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2019;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationPart45_2019Validator implements Validator<RegulatoryClassificationPart45_2019> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationPart45_2019 o) {
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
				checkCardinality("allocationStatus", (AllocationReportingStatus) o.getAllocationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("clientAccountType", (TradeCategory) o.getClientAccountType() != null ? 1 : 0, 0, 1), 
				checkCardinality("interAffiliateClearingExemptionParty", (PartyReference) o.getInterAffiliateClearingExemptionParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolioContainsNonReportableComponents", (Boolean) o.getCollateralPortfolioContainsNonReportableComponents() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageContainsNonReportableComponents", (Boolean) o.getPackageContainsNonReportableComponents() != null ? 1 : 0, 0, 1), 
				checkCardinality("specialEntityType", (String) o.getSpecialEntityType() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventType", (String) o.getEventType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeExecutionRequirementIndicator", (Boolean) o.getTradeExecutionRequirementIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceResetDate", (ZonedDateTime) o.getLastFloatingReferenceResetDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("nextFloatingReferenceResetDate", (ZonedDateTime) o.getNextFloatingReferenceResetDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart45_2019 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationPart45_2019", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart45_2019", path, "", res.getError());
				}
				return success("RegulatoryClassificationPart45_2019", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart45_2019", path, "");
			})
			.collect(toList());
	}

}
