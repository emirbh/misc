package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.ConsentRefused;
import fpml.consolidated.doc.ApprovalType;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.PortfolioReferenceBase;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PersonId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ConsentRefusedValidator implements Validator<ConsentRefused> {

	private List<ComparisonResult> getComparisonResults(ConsentRefused o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ResponseMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("type", (ApprovalType) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("approver", (PersonId) o.getApprover() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvingPartyReference", (PartyReference) o.getApprovingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioReference", (PortfolioReferenceBase) o.getPortfolioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("amendment", (TradeAmendmentContent) o.getAmendment() != null ? 1 : 0, 0, 1), 
				checkCardinality("increase", (TradeNotionalChange) o.getIncrease() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminatingEvent", (TerminatingEvent) o.getTerminatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("termination", (TradeNotionalChange) o.getTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("novation", (TradeNovationContent) o.getNovation() != null ? 1 : 0, 0, 1), 
				checkCardinality("withdrawal", (Withdrawal) o.getWithdrawal() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalEvent", (AdditionalEvent) o.getAdditionalEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeReferenceInformation", (TradeReferenceInformation) o.getTradeReferenceInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentRefused o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConsentRefused", ValidationResult.ValidationType.CARDINALITY, "ConsentRefused", path, "", res.getError());
				}
				return success("ConsentRefused", ValidationResult.ValidationType.CARDINALITY, "ConsentRefused", path, "");
			})
			.collect(toList());
	}

}
