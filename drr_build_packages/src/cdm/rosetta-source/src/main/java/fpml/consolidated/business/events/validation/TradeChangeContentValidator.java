package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ChangeEvent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeChangeContentValidator implements Validator<TradeChangeContent> {

	private List<ComparisonResult> getComparisonResults(TradeChangeContent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("oldTradeIdentifier", (PartyTradeIdentifier) o.getOldTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("oldTrade", (Trade) o.getOldTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeEvent", (ChangeEvent) o.getChangeEvent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeChangeContent", ValidationResult.ValidationType.CARDINALITY, "TradeChangeContent", path, "", res.getError());
				}
				return success("TradeChangeContent", ValidationResult.ValidationType.CARDINALITY, "TradeChangeContent", path, "");
			})
			.collect(toList());
	}

}
