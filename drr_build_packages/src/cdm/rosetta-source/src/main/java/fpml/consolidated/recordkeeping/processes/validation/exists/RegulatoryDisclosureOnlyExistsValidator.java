package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.AmountRef;
import fpml.consolidated.business.events.EventId;
import fpml.consolidated.business.events.EventTaxonomy;
import fpml.consolidated.business.events.MoneyRef;
import fpml.consolidated.business.events.UnitQuantityRef;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.recordkeeping.processes.EventTimestamps;
import fpml.consolidated.recordkeeping.processes.RegReportingCDE;
import fpml.consolidated.recordkeeping.processes.RegulationDetails;
import fpml.consolidated.recordkeeping.processes.RegulatoryDisclosure;
import fpml.consolidated.reg.fpmlreporting.shared.ApplicableRegulations;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryDisclosureOnlyExistsValidator implements ValidatorWithArg<RegulatoryDisclosure, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryDisclosure> ValidationResult<RegulatoryDisclosure> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((NotificationMessageHeader) o.getHeader()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("asOfDate", ExistenceChecker.isSet((IdentifiedDate) o.getAsOfDate()))
				.put("asOfTime", ExistenceChecker.isSet((LocalTime) o.getAsOfTime()))
				.put("eventId", ExistenceChecker.isSet((EventId) o.getEventId()))
				.put("eventType", ExistenceChecker.isSet((EventTaxonomy) o.getEventType()))
				.put("eventTimestamps", ExistenceChecker.isSet((EventTimestamps) o.getEventTimestamps()))
				.put("reportingPartyReference", ExistenceChecker.isSet((PartyReference) o.getReportingPartyReference()))
				.put("counterPartyReference", ExistenceChecker.isSet((PartyReference) o.getCounterPartyReference()))
				.put("notionalChange", ExistenceChecker.isSet((NotionalChangeEnum) o.getNotionalChange()))
				.put("changeInNotional", ExistenceChecker.isSet((List<? extends MoneyRef>) o.getChangeInNotional()))
				.put("changeInNumberOfOptions", ExistenceChecker.isSet((List<? extends AmountRef>) o.getChangeInNumberOfOptions()))
				.put("changeInQuantity", ExistenceChecker.isSet((List<? extends UnitQuantityRef>) o.getChangeInQuantity()))
				.put("payment", ExistenceChecker.isSet((List<? extends NonNegativePayment>) o.getPayment()))
				.put("applicableRegulations", ExistenceChecker.isSet((ApplicableRegulations) o.getApplicableRegulations()))
				.put("regulationSpecificInformation", ExistenceChecker.isSet((RegulationDetails) o.getRegulationSpecificInformation()))
				.put("cpmiIoscoCDE", ExistenceChecker.isSet((RegReportingCDE) o.getCpmiIoscoCDE()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("quote", ExistenceChecker.isSet((List<? extends BasicQuotation>) o.getQuote()))
				.put("collateralization", ExistenceChecker.isSet((List<? extends RegulatoryReportingCollateralization>) o.getCollateralization()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryDisclosure", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryDisclosure", path, "");
		}
		return failure("RegulatoryDisclosure", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryDisclosure", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
