package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.loan.AbstractLoanTradeEvent;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanTradeNotification;
import fpml.consolidated.loan.LoanTradeSettlementTask;
import fpml.consolidated.loan.LoanTradeSummary;
import fpml.consolidated.loan.LoanTradeType;
import fpml.consolidated.loan.LoanTradingPartyRole;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradeNotificationValidator implements Validator<LoanTradeNotification> {

	private List<ComparisonResult> getComparisonResults(LoanTradeNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("noticeDate", (ZonedDateTime) o.getNoticeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (LoanTradingPartyRole) o.getRole() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTradeEventGroup", (AbstractLoanTradeEvent) o.getLoanTradeEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementTask", (LoanTradeSettlementTask) o.getSettlementTask() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeIdentifier", (TradeIdentifier) o.getTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeSummary", (LoanTradeSummary) o.getTradeSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (LoanTradeType) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealIdentifier", (DealIdentifier) o.getDealIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealSummary", (DealSummary) o.getDealSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityIdentifier", (FacilityIdentifier) o.getFacilityIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilitySummary", (FacilitySummary) o.getFacilitySummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : o.getParty().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeNotification", ValidationResult.ValidationType.CARDINALITY, "LoanTradeNotification", path, "", res.getError());
				}
				return success("LoanTradeNotification", ValidationResult.ValidationType.CARDINALITY, "LoanTradeNotification", path, "");
			})
			.collect(toList());
	}

}
