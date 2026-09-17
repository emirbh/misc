package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.CreditDerivativesNotices;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.FirstPeriodStartDate;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Empty;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeNovationContentValidator implements Validator<TradeNovationContent> {

	private List<ComparisonResult> getComparisonResults(TradeNovationContent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("newTrade", (Trade) o.getNewTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("oldTrade", (Trade) o.getOldTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeTradeIdentifier", (PartyTradeIdentifier) o.getFeeTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeTrade", (Trade) o.getFeeTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferor", (PartyReference) o.getTransferor() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferorAccount", (AccountReference) o.getTransferorAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferee", (PartyReference) o.getTransferee() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherTransferee", (PartyReference) o.getOtherTransferee() != null ? 1 : 0, 0, 1), 
				checkCardinality("transfereeAccount", (AccountReference) o.getTransfereeAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherTransfereeAccount", (AccountReference) o.getOtherTransfereeAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("remainingParty", (PartyReference) o.getRemainingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("remainingPartyAccount", (AccountReference) o.getRemainingPartyAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherRemainingParty", (PartyReference) o.getOtherRemainingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherRemainingPartyAccount", (AccountReference) o.getOtherRemainingPartyAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("novationDate", (ZonedDateTime) o.getNovationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("novationTradeDate", (ZonedDateTime) o.getNovationTradeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("novatedNumberOfOptions", (BigDecimal) o.getNovatedNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("remainingNumberOfOptions", (BigDecimal) o.getRemainingNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("novatedNumberOfUnits", (BigDecimal) o.getNovatedNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("remainingNumberOfUnits", (BigDecimal) o.getRemainingNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullFirstCalculationPeriod", (Boolean) o.getFullFirstCalculationPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPeriodStartDate", (List<? extends FirstPeriodStartDate>) o.getFirstPeriodStartDate() == null ? 0 : o.getFirstPeriodStartDate().size(), 0, 2), 
				checkCardinality("nonReliance", (Empty) o.getNonReliance() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditDerivativesNotices", (CreditDerivativesNotices) o.getCreditDerivativesNotices() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (Payment) o.getPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNovationContent", ValidationResult.ValidationType.CARDINALITY, "TradeNovationContent", path, "", res.getError());
				}
				return success("TradeNovationContent", ValidationResult.ValidationType.CARDINALITY, "TradeNovationContent", path, "");
			})
			.collect(toList());
	}

}
