package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.fpmlenum.EMIRSupervisoryBodyEnum;
import fpml.consolidated.recordkeeping.processes.ESMAContractType;
import fpml.consolidated.recordkeeping.processes.ESMACreditDetails;
import fpml.consolidated.recordkeeping.processes.ESMADeliveryType;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationEMIR_2015;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationEMIR_2015OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationEMIR_2015, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationEMIR_2015> ValidationResult<RegulatoryClassificationEMIR_2015> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((List<EMIRSupervisoryBodyEnum>) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("tradePartyRelationshipType", ExistenceChecker.isSet((PartyRelationshipType) o.getTradePartyRelationshipType()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.put("mandatorilyClearable", ExistenceChecker.isSet((Boolean) o.getMandatorilyClearable()))
				.put("exceedsClearingThreshold", ExistenceChecker.isSet((Boolean) o.getExceedsClearingThreshold()))
				.put("reportingPartyClassification", ExistenceChecker.isSet((EntityClassification) o.getReportingPartyClassification()))
				.put("counterPartyClassification", ExistenceChecker.isSet((EntityClassification) o.getCounterPartyClassification()))
				.put("counterPartyisEEA", ExistenceChecker.isSet((Boolean) o.getCounterPartyisEEA()))
				.put("contractType", ExistenceChecker.isSet((ESMAContractType) o.getContractType()))
				.put("deliveryType", ExistenceChecker.isSet((ESMADeliveryType) o.getDeliveryType()))
				.put("creditDetails", ExistenceChecker.isSet((ESMACreditDetails) o.getCreditDetails()))
				.put("underlyer", ExistenceChecker.isSet((ESMAProductUnderlyer) o.getUnderlyer()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationEMIR_2015", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationEMIR_2015", path, "");
		}
		return failure("RegulatoryClassificationEMIR_2015", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationEMIR_2015", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
