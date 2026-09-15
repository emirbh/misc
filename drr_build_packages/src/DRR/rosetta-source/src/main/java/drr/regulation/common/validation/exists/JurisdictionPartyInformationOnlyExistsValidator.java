package drr.regulation.common.validation.exists;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ASICPartyInformation;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.CSAPartyInformation;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.MandatorilyClearableEnum;
import drr.regulation.common.ReportingRoleEnum;
import drr.regulation.common.SECPartyInformation;
import drr.regulation.common.TechnicalRecordId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class JurisdictionPartyInformationOnlyExistsValidator implements ValidatorWithArg<JurisdictionPartyInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends JurisdictionPartyInformation> ValidationResult<JurisdictionPartyInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((ReferenceWithMetaParty) o.getPartyReference()))
				.put("mandatorilyClearable", ExistenceChecker.isSet((MandatorilyClearableEnum) o.getMandatorilyClearable()))
				.put("clearingException", ExistenceChecker.isSet((ClearingException) o.getClearingException()))
				.put("postPricedIndicator", ExistenceChecker.isSet((Boolean) o.getPostPricedIndicator()))
				.put("asicPartyInformation", ExistenceChecker.isSet((ASICPartyInformation) o.getAsicPartyInformation()))
				.put("cftcPartyInformation", ExistenceChecker.isSet((CFTCPartyInformation) o.getCftcPartyInformation()))
				.put("csaPartyInformation", ExistenceChecker.isSet((CSAPartyInformation) o.getCsaPartyInformation()))
				.put("secPartyInformation", ExistenceChecker.isSet((SECPartyInformation) o.getSecPartyInformation()))
				.put("esmaPartyInformation", ExistenceChecker.isSet((ESMAPartyInformation) o.getEsmaPartyInformation()))
				.put("fcaPartyInformation", ExistenceChecker.isSet((FCAPartyInformation) o.getFcaPartyInformation()))
				.put("hkmaPartyInformation", ExistenceChecker.isSet((HKMAPartyInformation) o.getHkmaPartyInformation()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRoleEnum) o.getReportingRole()))
				.put("tradingCapacity", ExistenceChecker.isSet((ReportingRoleEnum) o.getTradingCapacity()))
				.put("technicalRecordId", ExistenceChecker.isSet((TechnicalRecordId) o.getTechnicalRecordId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("JurisdictionPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "JurisdictionPartyInformation", path, "");
		}
		return failure("JurisdictionPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "JurisdictionPartyInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
