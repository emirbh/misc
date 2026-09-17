package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.EventProposedMatch;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.MatchId;
import fpml.consolidated.shared.OriginatingEvent;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EventProposedMatchValidator implements Validator<EventProposedMatch> {

	private List<ComparisonResult> getComparisonResults(EventProposedMatch o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("amendment", (TradeAmendmentContent) o.getAmendment() != null ? 1 : 0, 0, 1), 
				checkCardinality("increase", (TradeNotionalChange) o.getIncrease() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminatingEvent", (TerminatingEvent) o.getTerminatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("termination", (TradeNotionalChange) o.getTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("novation", (TradeNovationContent) o.getNovation() != null ? 1 : 0, 0, 1), 
				checkCardinality("withdrawal", (Withdrawal) o.getWithdrawal() != null ? 1 : 0, 0, 1), 
				checkCardinality("change", (TradeChangeContent) o.getChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExercise", (OptionExercise) o.getOptionExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEvent", (OptionEvent) o.getOptionEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalEvent", (AdditionalEvent) o.getAdditionalEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("matchId", (MatchId) o.getMatchId() != null ? 1 : 0, 0, 1), 
				checkCardinality("matchScore", (BigDecimal) o.getMatchScore() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventProposedMatch o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventProposedMatch", ValidationResult.ValidationType.CARDINALITY, "EventProposedMatch", path, "", res.getError());
				}
				return success("EventProposedMatch", ValidationResult.ValidationType.CARDINALITY, "EventProposedMatch", path, "");
			})
			.collect(toList());
	}

}
