package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.CompressionActivity;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.Clearing;
import fpml.consolidated.confirmation.processes.ClearingConfirmed;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.msg.PortfolioReference;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingConfirmedValidator implements Validator<ClearingConfirmed> {

	private List<ComparisonResult> getComparisonResults(ClearingConfirmed o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (NotificationMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("compressionActivity", (CompressionActivity) o.getCompressionActivity() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioReference", (PortfolioReference) o.getPortfolioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalEvent", (AdditionalEvent) o.getAdditionalEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminatingEvent", (TerminatingEvent) o.getTerminatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("termination", (TradeNotionalChange) o.getTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("deClear", (DeClear) o.getDeClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearing", (Clearing) o.getClearing() != null ? 1 : 0, 0, 1), 
				checkCardinality("change", (TradeChangeContent) o.getChange() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingConfirmed o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingConfirmed", ValidationResult.ValidationType.CARDINALITY, "ClearingConfirmed", path, "", res.getError());
				}
				return success("ClearingConfirmed", ValidationResult.ValidationType.CARDINALITY, "ClearingConfirmed", path, "");
			})
			.collect(toList());
	}

}
