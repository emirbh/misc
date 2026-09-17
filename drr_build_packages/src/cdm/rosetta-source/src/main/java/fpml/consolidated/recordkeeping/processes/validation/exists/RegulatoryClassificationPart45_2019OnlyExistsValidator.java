package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.ConfirmationMethod;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.ExecutionType;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.doc.VerificationMethod;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2019;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationPart45_2019OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationPart45_2019, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationPart45_2019> ValidationResult<RegulatoryClassificationPart45_2019> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((List<String>) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("mandatorilyClearable", ExistenceChecker.isSet((ReportingBoolean) o.getMandatorilyClearable()))
				.put("endUserException", ExistenceChecker.isSet((Boolean) o.getEndUserException()))
				.put("endUserExceptionReason", ExistenceChecker.isSet((List<? extends ClearingExceptionReason>) o.getEndUserExceptionReason()))
				.put("endUserExceptionDeclaration", ExistenceChecker.isSet((EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration()))
				.put("largeSizeTrade", ExistenceChecker.isSet((Boolean) o.getLargeSizeTrade()))
				.put("executionType", ExistenceChecker.isSet((ExecutionType) o.getExecutionType()))
				.put("executionVenueType", ExistenceChecker.isSet((ExecutionVenueType) o.getExecutionVenueType()))
				.put("verificationMethod", ExistenceChecker.isSet((VerificationMethod) o.getVerificationMethod()))
				.put("confirmationMethod", ExistenceChecker.isSet((ConfirmationMethod) o.getConfirmationMethod()))
				.put("collateralizationType", ExistenceChecker.isSet((CollateralizationType) o.getCollateralizationType()))
				.put("reportingPartyOrganizationType", ExistenceChecker.isSet((String) o.getReportingPartyOrganizationType()))
				.put("counterPartyOrganizationType", ExistenceChecker.isSet((String) o.getCounterPartyOrganizationType()))
				.put("counterPartyIsUsPerson", ExistenceChecker.isSet((Boolean) o.getCounterPartyIsUsPerson()))
				.put("allocationStatus", ExistenceChecker.isSet((AllocationReportingStatus) o.getAllocationStatus()))
				.put("clientAccountType", ExistenceChecker.isSet((TradeCategory) o.getClientAccountType()))
				.put("interAffiliateClearingExemptionParty", ExistenceChecker.isSet((PartyReference) o.getInterAffiliateClearingExemptionParty()))
				.put("reportingPartyClearingExemption", ExistenceChecker.isSet((List<String>) o.getReportingPartyClearingExemption()))
				.put("counterPartyClearingExemption", ExistenceChecker.isSet((List<String>) o.getCounterPartyClearingExemption()))
				.put("collateralTypeAllowed", ExistenceChecker.isSet((List<String>) o.getCollateralTypeAllowed()))
				.put("collateralPortfolioContainsNonReportableComponents", ExistenceChecker.isSet((Boolean) o.getCollateralPortfolioContainsNonReportableComponents()))
				.put("packageContainsNonReportableComponents", ExistenceChecker.isSet((Boolean) o.getPackageContainsNonReportableComponents()))
				.put("specialEntityType", ExistenceChecker.isSet((String) o.getSpecialEntityType()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.put("eventType", ExistenceChecker.isSet((String) o.getEventType()))
				.put("tradeExecutionRequirementIndicator", ExistenceChecker.isSet((Boolean) o.getTradeExecutionRequirementIndicator()))
				.put("lastFloatingReferenceResetDate", ExistenceChecker.isSet((ZonedDateTime) o.getLastFloatingReferenceResetDate()))
				.put("nextFloatingReferenceResetDate", ExistenceChecker.isSet((ZonedDateTime) o.getNextFloatingReferenceResetDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationPart45_2019", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationPart45_2019", path, "");
		}
		return failure("RegulatoryClassificationPart45_2019", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationPart45_2019", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
