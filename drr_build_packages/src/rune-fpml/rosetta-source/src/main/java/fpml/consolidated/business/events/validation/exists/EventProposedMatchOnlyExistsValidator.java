package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.EventProposedMatch;
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
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeDifference;
import fpml.consolidated.shared.MatchId;
import fpml.consolidated.shared.OriginatingEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventProposedMatchOnlyExistsValidator implements ValidatorWithArg<EventProposedMatch, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventProposedMatch> ValidationResult<EventProposedMatch> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradePackage", ExistenceChecker.isSet((TradePackage) o.getTradePackage()))
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
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
				.put("matchId", ExistenceChecker.isSet((MatchId) o.getMatchId()))
				.put("difference", ExistenceChecker.isSet((List<? extends TradeDifference>) o.getDifference()))
				.put("matchScore", ExistenceChecker.isSet((BigDecimal) o.getMatchScore()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventProposedMatch", ValidationResult.ValidationType.ONLY_EXISTS, "EventProposedMatch", path, "");
		}
		return failure("EventProposedMatch", ValidationResult.ValidationType.ONLY_EXISTS, "EventProposedMatch", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
