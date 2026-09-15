package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.OtcClassification;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.ShortSale;
import fpml.consolidated.doc.TradingWaiver;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS6b_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.RelatedPerson;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationMifirRTS6b_2015OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationMifirRTS6b_2015, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationMifirRTS6b_2015> ValidationResult<RegulatoryClassificationMifirRTS6b_2015> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((List<String>) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("relatedPerson", ExistenceChecker.isSet((List<? extends RelatedPerson>) o.getRelatedPerson()))
				.put("tradingObligation", ExistenceChecker.isSet((RegulatoryTradingObligation) o.getTradingObligation()))
				.put("isSecuritiesFinancing", ExistenceChecker.isSet((Boolean) o.getIsSecuritiesFinancing()))
				.put("otcClassification", ExistenceChecker.isSet((List<? extends OtcClassification>) o.getOtcClassification()))
				.put("tradingWaiver", ExistenceChecker.isSet((List<? extends TradingWaiver>) o.getTradingWaiver()))
				.put("shortSale", ExistenceChecker.isSet((ShortSale) o.getShortSale()))
				.put("isCommodityHedge", ExistenceChecker.isSet((Boolean) o.getIsCommodityHedge()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationMifirRTS6b_2015", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationMifirRTS6b_2015", path, "");
		}
		return failure("RegulatoryClassificationMifirRTS6b_2015", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationMifirRTS6b_2015", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
