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
import fpml.consolidated.doc.VerificationMethod;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2012;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationPart45_2012OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationPart45_2012, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationPart45_2012> ValidationResult<RegulatoryClassificationPart45_2012> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("intentToAllocate", ExistenceChecker.isSet((Boolean) o.getIntentToAllocate()))
				.put("allocationStatus", ExistenceChecker.isSet((AllocationReportingStatus) o.getAllocationStatus()))
				.put("allocationAgent", ExistenceChecker.isSet((PartyReference) o.getAllocationAgent()))
				.put("multiAssetSwap", ExistenceChecker.isSet((Boolean) o.getMultiAssetSwap()))
				.put("mixedSwap", ExistenceChecker.isSet((Boolean) o.getMixedSwap()))
				.put("contractType", ExistenceChecker.isSet((ProductId) o.getContractType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationPart45_2012", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationPart45_2012", path, "");
		}
		return failure("RegulatoryClassificationPart45_2012", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationPart45_2012", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
