package fpml.consolidated.clearing.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.clearing.processes.ClearingEligibility;
import fpml.consolidated.clearing.processes.ClearingRequirements;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingEligibilityOnlyExistsValidator implements ValidatorWithArg<ClearingEligibility, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingEligibility> ValidationResult<ClearingEligibility> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ResponseMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("tradePackage", ExistenceChecker.isSet((TradePackage) o.getTradePackage()))
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("additionalEvent", ExistenceChecker.isSet((AdditionalEvent) o.getAdditionalEvent()))
				.put("deClear", ExistenceChecker.isSet((DeClear) o.getDeClear()))
				.put("partyTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getPartyTradeIdentifier()))
				.put("eligibleForClearing", ExistenceChecker.isSet((Boolean) o.getEligibleForClearing()))
				.put("clearingRequirements", ExistenceChecker.isSet((List<? extends ClearingRequirements>) o.getClearingRequirements()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.put("account", ExistenceChecker.isSet((List<? extends Account>) o.getAccount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingEligibility", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingEligibility", path, "");
		}
		return failure("ClearingEligibility", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingEligibility", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
