package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanAllocationNotification;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.LoanTradeSummary;
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

public class LoanAllocationNotificationValidator implements Validator<LoanAllocationNotification> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNotification o) {
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
				checkCardinality("loanAllocationNotificationChoice0", (List<? extends LoanAllocationNotificationChoice0>) o.getLoanAllocationNotificationChoice0() == null ? 0 : o.getLoanAllocationNotificationChoice0().size(), 1, 0), 
				checkCardinality("loanAllocationNotificationChoice1", (List<? extends LoanAllocationNotificationChoice1>) o.getLoanAllocationNotificationChoice1() == null ? 0 : o.getLoanAllocationNotificationChoice1().size(), 1, 0), 
				checkCardinality("tradeIdentifier", (TradeIdentifier) o.getTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeSummary", (LoanTradeSummary) o.getTradeSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealIdentifier", (DealIdentifier) o.getDealIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealSummary", (DealSummary) o.getDealSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityIdentifier", (FacilityIdentifier) o.getFacilityIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilitySummary", (FacilitySummary) o.getFacilitySummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : o.getParty().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNotification", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotification", path, "", res.getError());
				}
				return success("LoanAllocationNotification", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotification", path, "");
			})
			.collect(toList());
	}

}
