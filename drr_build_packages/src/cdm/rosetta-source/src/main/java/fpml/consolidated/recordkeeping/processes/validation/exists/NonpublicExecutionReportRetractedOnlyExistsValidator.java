package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradingEventSummary;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReportRetracted;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedParty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonpublicExecutionReportRetractedOnlyExistsValidator implements ValidatorWithArg<NonpublicExecutionReportRetracted, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonpublicExecutionReportRetracted> ValidationResult<NonpublicExecutionReportRetracted> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("tradingEvent", ExistenceChecker.isSet((List<? extends TradingEventSummary>) o.getTradingEvent()))
				.put("amendment", ExistenceChecker.isSet((TradeAmendmentContent) o.getAmendment()))
				.put("increase", ExistenceChecker.isSet((TradeNotionalChange) o.getIncrease()))
				.put("terminatingEvent", ExistenceChecker.isSet((TerminatingEvent) o.getTerminatingEvent()))
				.put("termination", ExistenceChecker.isSet((TradeNotionalChange) o.getTermination()))
				.put("novation", ExistenceChecker.isSet((TradeNovationContent) o.getNovation()))
				.put("withdrawal", ExistenceChecker.isSet((Withdrawal) o.getWithdrawal()))
				.put("observation", ExistenceChecker.isSet((List<? extends ObservationEvent>) o.getObservation()))
				.put("reset", ExistenceChecker.isSet((List<? extends ResetEvent>) o.getReset()))
				.put("change", ExistenceChecker.isSet((TradeChangeContent) o.getChange()))
				.put("optionExercise", ExistenceChecker.isSet((OptionExercise) o.getOptionExercise()))
				.put("optionExpiry", ExistenceChecker.isSet((List<? extends OptionExpiry>) o.getOptionExpiry()))
				.put("optionEvent", ExistenceChecker.isSet((OptionEvent) o.getOptionEvent()))
				.put("additionalEvent", ExistenceChecker.isSet((AdditionalEvent) o.getAdditionalEvent()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("tradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getTradeIdentifier()))
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.put("account", ExistenceChecker.isSet((List<? extends Account>) o.getAccount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonpublicExecutionReportRetracted", ValidationResult.ValidationType.ONLY_EXISTS, "NonpublicExecutionReportRetracted", path, "");
		}
		return failure("NonpublicExecutionReportRetracted", ValidationResult.ValidationType.ONLY_EXISTS, "NonpublicExecutionReportRetracted", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
