package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AdmissionToTrading;
import fpml.consolidated.doc.CurrencyPairClassification;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS23_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.RelatedPerson;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationMifirRTS23_2015OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationMifirRTS23_2015, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationMifirRTS23_2015> ValidationResult<RegulatoryClassificationMifirRTS23_2015> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((List<String>) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("relatedPerson", ExistenceChecker.isSet((List<? extends RelatedPerson>) o.getRelatedPerson()))
				.put("tradingObligation", ExistenceChecker.isSet((RegulatoryTradingObligation) o.getTradingObligation()))
				.put("isCommodityHedge", ExistenceChecker.isSet((Boolean) o.getIsCommodityHedge()))
				.put("currencyPairClassification", ExistenceChecker.isSet((CurrencyPairClassification) o.getCurrencyPairClassification()))
				.put("transmissionOfOrder", ExistenceChecker.isSet((Boolean) o.getTransmissionOfOrder()))
				.put("admissionToTrading", ExistenceChecker.isSet((AdmissionToTrading) o.getAdmissionToTrading()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationMifirRTS23_2015", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationMifirRTS23_2015", path, "");
		}
		return failure("RegulatoryClassificationMifirRTS23_2015", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationMifirRTS23_2015", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
