package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.CurrencyPairClassification;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.FacilityExecutionExceptionDeclaration;
import fpml.consolidated.doc.NotionalReportingType;
import fpml.consolidated.doc.PartyEntityClassification;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.ReportingRegimeName;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingRegimeOnlyExistsValidator implements ValidatorWithArg<ReportingRegime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingRegime> ValidationResult<ReportingRegime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((ReportingRegimeName) o.getName()))
				.put("supervisorRegistration", ExistenceChecker.isSet((List<? extends SupervisorRegistration>) o.getSupervisorRegistration()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("mandatorilyClearable", ExistenceChecker.isSet((ReportingBoolean) o.getMandatorilyClearable()))
				.put("mandatoryFacilityExecution", ExistenceChecker.isSet((Boolean) o.getMandatoryFacilityExecution()))
				.put("mandatoryFacilityExecutionException", ExistenceChecker.isSet((Boolean) o.getMandatoryFacilityExecutionException()))
				.put("mandatoryFacilityExecutionExceptionDeclaration", ExistenceChecker.isSet((FacilityExecutionExceptionDeclaration) o.getMandatoryFacilityExecutionExceptionDeclaration()))
				.put("exceedsClearingThreshold", ExistenceChecker.isSet((Boolean) o.getExceedsClearingThreshold()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("entityClassification", ExistenceChecker.isSet((EntityClassification) o.getEntityClassification()))
				.put("partyEntityClassification", ExistenceChecker.isSet((List<? extends PartyEntityClassification>) o.getPartyEntityClassification()))
				.put("tradePartyRelationshipType", ExistenceChecker.isSet((PartyRelationshipType) o.getTradePartyRelationshipType()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.put("preEnactmentTrade", ExistenceChecker.isSet((Boolean) o.getPreEnactmentTrade()))
				.put("notionalType", ExistenceChecker.isSet((NotionalReportingType) o.getNotionalType()))
				.put("currencyPairClassification", ExistenceChecker.isSet((CurrencyPairClassification) o.getCurrencyPairClassification()))
				.put("transmissionOfOrder", ExistenceChecker.isSet((Boolean) o.getTransmissionOfOrder()))
				.put("postPricedIndicator", ExistenceChecker.isSet((Boolean) o.getPostPricedIndicator()))
				.put("directlyLinkedActivity", ExistenceChecker.isSet((Boolean) o.getDirectlyLinkedActivity()))
				.put("endUserException", ExistenceChecker.isSet((Boolean) o.getEndUserException()))
				.put("endUserExceptionReason", ExistenceChecker.isSet((List<? extends ClearingExceptionReason>) o.getEndUserExceptionReason()))
				.put("endUserExceptionDeclaration", ExistenceChecker.isSet((EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingRegime", ValidationResult.ValidationType.ONLY_EXISTS, "ReportingRegime", path, "");
		}
		return failure("ReportingRegime", ValidationResult.ValidationType.ONLY_EXISTS, "ReportingRegime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
